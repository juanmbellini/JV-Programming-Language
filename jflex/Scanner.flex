package atlc;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java.io.StringReader;

%%

%class Scanner
%cup
%line
%column
%char

%{
    private ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();
    StringBuffer string = new StringBuffer();
    int currentLineIndent = 0;
    int indentLevel = 0;

    public Scanner(java.io.Reader reader, ComplexSymbolFactory symbolFactory) {
		this(reader);
        this.symbolFactory = symbolFactory;
    }

    public Symbol createSymbol(String plaintext, int code) {
        return symbolFactory.newSymbol(plaintext, code,
            new Location("", yyline + 1, yycolumn + 1, yychar),
            new Location("", yyline + 1, yycolumn + yylength(), yychar));
    }

    public Symbol createSymbol(String plaintext, int code, Object object) {
        return symbolFactory.newSymbol(plaintext, code,
            new Location("", yyline + 1, yycolumn + 1, yychar),
            new Location("", yyline + 1, yycolumn + yylength(), yychar),
            object);
    }

    public Symbol createSymbol(String plaintext, int code, Object object, int buffLength) {
        return symbolFactory.newSymbol(plaintext, code,
            new Location("", yyline + 1, yycolumn + yylength() - buffLength, yychar + yylength() - buffLength),
            new Location("", yyline + 1, yycolumn + yylength(), yychar + yylength()),
            object);
    }

    public Boolean createBoolean(String str) {
        if (!str.equals("yes") && !str.equals("no")) {
            throw new IllegalArgumentException();
        }
        return str.equals("yes");
    }

    public void printError(String symbol) {
        System.err.println("Invalid symbol <" + string + ">");
    }

%}
%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

// Macros
// For Unix and Windows files
EndOfLine = \n | \r\n | \r
// Tab character
Tab = \t
// We only accept ' ' as a white space
WhiteSpace = " "
// A comment starts with the '~' character and continues with its content
Comment = "~" [ ][^\n]* {EndOfLine}

// Integer can be a 0 or an infinite amount of any digit preceded by any digit from 1 to 9
IntegerLiteral = 0 | [1-9][0-9]*
BooleanLiteral = "yes" | "no"

VarName = [:jletter:] [:jletterdigit:]*

%state STRING
%state NORMAL
%state FINAL

%%

<NORMAL> {

    /* Functions */
    "fn"                { return createSymbol("Function", sym.FUNC); }
    "ret"               { return createSymbol("Return", sym.RET); }
	/* Code Structure */
	{EndOfLine}			{ currentLineIndent = 0; yybegin(YYINITIAL); return createSymbol("End of Line", sym.EOL); }
	[ ]					{ return createSymbol("Space", sym.SP); }

	/* Data types */
	"int"				{ return createSymbol("IntType", sym.TYPE_INT); }
	"bln"				{ return createSymbol("BoolType", sym.TYPE_BOOL); }
	"str"				{ return createSymbol("StrType", sym.TYPE_STR); }

	/* Commands */
	"rl"				{ return createSymbol("Read", sym.READ_LINE); }
	"wl"				{ return createSymbol("Write", sym.WRITE_LINE); }
	"w"					{ return createSymbol("Write", sym.WRITE); }

	/* Decision and repetition structures */
	"if"				{ return createSymbol("If", sym.IF); }
	"ls"				{ return createSymbol("Else", sym.ELSE); }
	"do"				{ return createSymbol("Do", sym.DO); }
	"whl"				{ return createSymbol("While", sym.WHILE); }

	/* Operators */
	"+" 				{ return createSymbol("Plus",sym.PLUS); }
	"-" 				{ return createSymbol("Minus", sym.MINUS); }
	"*" 				{ return createSymbol("Times",sym.TIMES); }
	"/" 				{ return createSymbol("Divide", sym.DIVIDE); }
	"!" 				{ return createSymbol("Not", sym.NOT); }
	"&&" 				{ return createSymbol("And", sym.AND); }
	"||" 				{ return createSymbol("Or", sym.OR); }
	"<" 				{ return createSymbol("Lower Than", sym.LT); }
	">" 				{ return createSymbol("Greater than", sym.GT); }
	"<=" 				{ return createSymbol("Lower than or equal to", sym.LE); }
	">=" 				{ return createSymbol("greater than or equal to", sym.GE); }
	"==" 				{ return createSymbol("Equal to", sym.EQ); }
	"!=" 				{ return createSymbol("Not equal to", sym.NEQ); }
	"=" 				{ return createSymbol("Assign", sym.ASSIGN); }
	":" 				{ return createSymbol("TypeAssign", sym.ASSIGN_TYPE); }

	/* Identifiers */
    // TODO: Space is being added before var name
	{VarName} 			{ return createSymbol("Var Name", sym.VAR_NAME, yytext()); }

	/* Literal */
	{IntegerLiteral} 	{ return createSymbol("Integer", sym.LIT_INT, new Integer(yytext())); }
	{BooleanLiteral} 	{ return createSymbol("Boolean", sym.LIT_BOOL, createBoolean(yytext())); }
	\"                  { string.setLength(0); yybegin(STRING); }

	/* Comments */
	{Comment}			{ /* Do Nothing */	}

}

<STRING> {
  \"                             { yybegin(NORMAL); 
                                   return createSymbol("String", sym.LIT_STR, string.toString(), string.length()); }
  [^\n\r\"\\]+                   { string.append(yytext()); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }
  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}

<FINAL> \n { currentLineIndent = 0; yybegin(YYINITIAL); }

<YYINITIAL> {
\t { currentLineIndent++; }
^[\t]*{EndOfLine}	{/* Ignore blank lines. */}
<<EOF>> {
			if (currentLineIndent < indentLevel) {
				indentLevel--;
				yyreset(new StringReader("\n"));
				yybegin(FINAL);
				return createSymbol("Dedent", sym.DEDENT);
			} else {
				return symbolFactory.newSymbol("EOF",sym.EOF);
			}
		}
.  {
		yypushback(1);
		if (currentLineIndent > indentLevel) {
			indentLevel++;
			return createSymbol("Indent", sym.INDENT);
		} else if (currentLineIndent < indentLevel) {
			indentLevel--;
			return createSymbol("Dedent", sym.DEDENT);
		} else {
			yybegin(NORMAL);
		}
	}
}

[^]		{ throw new Error("Illegal character <" + yytext() + ">"); }

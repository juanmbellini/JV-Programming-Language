package atlc;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%

%class Scanner
%cup
%line
%column
%char

%{
    private ComplexSymbolFactory symbolFactory;
    StringBuffer string = new StringBuffer();

    public Scanner(java.io.InputStream inputStream, ComplexSymbolFactory symbolFactory) {
        this(inputStream);
        this.symbolFactory = symbolFactory;
    }

    public Symbol createSymbol(String plaintext, int code) {
        System.out.println("parsed: " + plaintext);
        return symbolFactory.newSymbol(plaintext, code,
            new Location("", yyline + 1, yycolumn + 1, yychar),
            new Location("", yyline + 1, yycolumn + yylength(), yychar));
    }

    public Symbol createSymbol(String plaintext, int code, Object object) {
        System.out.println("parsed: " + plaintext +" :: " + object);
        return symbolFactory.newSymbol(plaintext, code,
            new Location("", yyline + 1, yycolumn + 1, yychar),
            new Location("", yyline + 1, yycolumn + yylength(), yychar),
            object);
    }

    public Symbol createSymbol(String plaintext, int code, Object object, int buffLength) {
        return symbolFactory.newSymbol(plaintext, code,
            new Location(yyline + 1, yycolumn + yylength() - buffLength, yychar + yylength() - buffLength),
            new Location(yyline + 1, yycolumn + yylength(), yychar + yylength()),
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
    System.out.println("parsed: EOF");
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

VarName = [ ] [:jletter:] [:jletterdigit:]*

%state STRING

%%

<YYINITIAL> {

    /* Main */
    "mn"                { return createSymbol("Main", sym.MAIN); }
    "ret"               { return createSymbol("Main", sym.RETURN); }
	/* Code Structure */
	{EndOfLine}			{ return createSymbol("End of Line", sym.EOL); }
	{Tab}				{ return createSymbol("Tab", sym.TAB); }
	{WhiteSpace}		{ return createSymbol("Space", sym.SPACE); }

	/* Data types */
	"int"				{ return createSymbol("Integer", sym.TYPE_INT); }
	"bln"				{ return createSymbol("Boolean", sym.TYPE_BOOL); }
	"str"				{ return createSymbol("String", sym.TYPE_STR); }

	/* Commands */
	"rd"				{ return createSymbol("Read", sym.READ); }
	"wr"				{ return createSymbol("Write", sym.WRITE); }

	/* Decision and repetition structures */
	"ff"				{ return createSymbol("If", sym.IF); }
	"ls"				{ return createSymbol("Else", sym.ELSE); }
	"dd"				{ return createSymbol("Do", sym.DO); }
	"whl"				{ return createSymbol("While", sym.WHILE); }

	/* Operators */
	"(" 				{ return createSymbol("Left Bracket",sym.LPAREN); }
	")" 				{ return createSymbol("Right Bracket",sym.RPAREN); }
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
	":" 				{ return createSymbol("Assign", sym.ASSIGN); }

	/* Identifiers */
    // TODO: Space is being added before var name
	{VarName} 			{ return createSymbol("Var Name", sym.VAR_NAME, yytext()); }

	/* Literal */
	{IntegerLiteral} 	{ return createSymbol("Integer", sym.LIT_INT, new Integer(yytext())); }
	{BooleanLiteral} 	{ return createSymbol("Boolean", sym.LIT_BOOL, createBoolean(yytext())); }
	\"                  { string.setLength(0); yybegin(STRING); }

	/* Comments */
	{Comment}			{ /* Do Nothing */	}
	^[\t]*\n       		{/* Ignore blank lines. */}

}

<STRING> {
  \"                             { yybegin(YYINITIAL); 
                                   return createSymbol("String", sym.LIT_STR, string.toString()); }
  [^\n\r\"\\]+                   { string.append(yytext()); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }
  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}

[^]                              { throw new Error("Illegal character <" + yytext() + ">"); }

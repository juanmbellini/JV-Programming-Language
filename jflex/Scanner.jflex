package atlc;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;

/**
 * This class represents the scanner.
 */


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
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}




// Macros
// For Unix and Windows files
EndOfLine = \n | \r\n | \r
// Tab character
Tab = \t
// We only accept ' ' as a white space
WhiteSpace = [ ]
// A comment starts with the '~' character and continues with its content
Comment = "~" {StringLiteral} \n


// Integer can be a 0 or an infinite amount of any digit preceded by any digit from 1 to 9
IntegerLiteral = 0 | [1-9][0-9]*
BooleanLiteral = "yes" | "no"
// A string can have any character as long as it's not a line terminator
StringLiteral = [^\n]*

VarName = [:jletter:] [:jletterdigit:]*

// %state STRING

/*
 * SYMBOLS
 *
 *	END_OF_LINE
 *	TAB
 *	SPACE
 *
 *	INT_TYPE
 *	BOOL_TYPE
 *	STR_TYPE
 *
 *	READ
 *	WRITE
 *	WRITE_VAR
 *	NEW_LINE
 *
 * 	IF
 * 	ELSE_IF
 *	ELSE
 *	DO
 *	WHILE
 *
 *	LPAREN
 *	RPAREN
 *	PLUS
 *	MINUS
 *	TIMES
 * 	DIVDE
 * 	NOT
 * 	AND
 *	OR
 *	LOWER_THAN
 *	GREATER_THAN
 *	LOWER_THAN_OR_EQUAL_TO
 *	GREATER_THAN_OR_EQUAL_TO
 *	EQUAL_TO
 *	NOT_EQUAL_TO
 *	
 *	INTCONST
 *	BOOLCONST
 *
 *	VAR_NAME
 *
 *
 */

%%

<YYINITIAL> {

    /* Main */
    "mn"                { return createSymbol("Main", sym.MAIN); }
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
	"wv"				{ return createSymbol("Write var", sym.WRITE_VAR); }
	"nl"				{ return createSymbol("Write new line", sym.NEW_LINE); }

	/* Decision and repetition structures */
	"ff"				{ return createSymbol("If", sym.IF); }
	"lsff"				{ return createSymbol("Else-If", sym.ELSE_IF); }
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

	/* Literal */
	{IntegerLiteral} 	{ return createSymbol("Integer", sym.LIT_INT, new Integer(yytext())); }
	{BooleanLiteral} 	{ return createSymbol("Boolean", sym.LIT_BOOL, createBoolean(yytext())); }
	{StringLiteral} 	{ return createSymbol("String", sym.LIT_STR, yytext()); }

	/* Comments */
	{Comment}			{ /* Do Nothing */	}

	/* Identifiers */
	{VarName} 			{ return createSymbol("Var Name", sym.VAR_NAME, yytext()); }
	.					{ throw new Error("Illegal character <" + yytext() + ">");}

}

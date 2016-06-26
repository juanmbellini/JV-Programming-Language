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
	/*
	public Symbol createSymbol(String plaintext, int code, Integer number) {
	    
	    return symbolFactory.newSymbol(plaintext, code, 
	    	new Location("", yyline + 1, yycolumn + 1, yychar),
	    	new Location("", yyline + 1, yycolumn + yylength(), yychar),
	    	number);
	}
	public Symbol createSymbol(String plaintext, int code, Boolean boolean) {
	    
	    return symbolFactory.newSymbol(plaintext, code, 
	    	new Location("", yyline + 1, yycolumn + 1, yychar),
	    	new Location("", yyline + 1, yycolumn + yylength(), yychar),
	    	boolean);
	}
	public Symbol createSymbol(String plaintext, int code, String string) {
	    
	    return symbolFactory.newSymbol(plaintext, code, 
	    	new Location("", yyline + 1, yycolumn + 1, yychar),
	    	new Location("", yyline + 1, yycolumn + yylength(), yychar),
	    	string);
	}*/
	
	
%}
%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}




// Macros
EndOfLine = \n | \r\n | \r 			// For Unix and Windows files
Tab = \t 							// Tab character
WhiteSpace = [ ] 					// We only accept ' ' as a white space
Comment = "~" {CommentContent} 		// A comment starts with the '~' character and continues with its content


IntegerLiteral = 0 | [1-9][0-9]* 	// Integer can be a 0 or an infinite amount of any digit preceded by any digit from 1 to 9
BooleanLiteral = "true" | "false"	// 	
String = ""

CommentContent = [^{EndOfLine}]*	// A comment content can have any character as long as it's not a line terminator

EntryPoint = "mn"
VarName = [a-zA-Z_][a-zA-Z0-9_]*




%state STRING

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

{EndOfLine}			{ return createSymbol("End of Line", sym.END_OF_LINE); }
{Tab}				{ return  createSymbol("Tab", sym.TAB); }
{WhiteSpace}		{ return createSymbol("Space", sym.SPACE)}


"int"				{ return createSymbol("Integer", sym.INT_TYPE); }
"bln"				{ return createSymbol("Boolean", sym.BOOL_TYPE); }
"str"				{ return createSymbol("String", sym.STR_TYPE); }

"rd"				{ return createSymbol("Read", sym.READ); }
"wr"				{ return createSymbol("Read", sym.WRITE); }
"wv"				{ return createSymbol("Read", sym.WRITE_VAR); }
"nl"				{ return createSymbol("Read", sym.NEW_LINE); }

"ff"				{ return createSymbol("If", sym.IF); }
"lsff"				{ return createSymbol("Else-If", sym.ELSE_IF); }
"ls"				{ return createSymbol("Else", sym.ELSE); }
"dd"				{ return createSymbol("Do", sym.DO); }
"whl"				{ return createSymbol("While", sym.WHILE)}

"(" 				{ return createSymbol("Left Bracket",sym.LPAREN); }
")" 				{ return createSymbol("Right Bracket",sym.RPAREN); }
"+" 				{ return createSymbol("Plus",sym.PLUS); }
"-" 				{ return createSymbol("Minus", sym.MINUS); }
"*" 				{ return createSymbol("Times",sym.TIMES); }
"/" 				{ return createSymbol("Divide", sym.DIVIDE); }
"!" 				{ return createSymbol("Not", sym.NOT); }
"&&" 				{ return createSymbol("And", sym.AND); }
"||" 				{ return createSymbol("Or", sym.OR); }
"<" 				{ return createSymbol("Lower Than", sym.LOWER_THAN); }
">" 				{ return createSymbol("Greater than", sym.GREATER_THAN); }
"<=" 				{ return createSymbol("Lower than or equal to", sym.LOWER_THAN_OR_EQUAL_TO); }
">=" 				{ return createSymbol("greater than or equal to", sym.GREATER_THAN_OR_EQUAL_TO); }
"==" 				{ return createSymbol("Equal to", sym.EQUAL_TO); }
"!=" 				{ return createSymbol("Not equal to", sym.NOT_EQUAL_TO); }


{IntegerLiteral} 	{ return createSymbol("Integer", sym.INTCONST, new Boolean(yytext())); }
{BooleanLiteral} 	{ return createSymbol("Boolean", sym.BOOLCONST, new Boolean(yytext())); }

{Comment}			{ /* Do Nothing */	}

{VarName} 			{ return createSymbol("Var Name", sym.VAR_NAME, yytext(); }


. { System.err.println("Illegal symbol <" + yytext() + ">"); }







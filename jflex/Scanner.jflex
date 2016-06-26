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
 *	VAR_NAME
 *	INTCONST
 *	BOOLCONST
 *
 *
 */

%%

"(" { return createSymbol("Left Bracket",sym.LPAREN); }
")" { return createSymbol("Right Bracket",sym.RPAREN); }
"+" { return createSymbol("Plus",sym.PLUS); }
"-" { return createSymbol("Minus", sym.MINUS); }
"*" { return createSymbol("Times",sym.TIMES); }
"/" { return createSymbol("Divide", sym.DIVIDE); }
"!" { return createSymbol("Not", sym.NOT); }
"&&" { return createSymbol("Not", sym.AND); }
"||" { return createSymbol("Not", sym.OR); }
"<" { return createSymbol("Not", sym.LOWER_THAN); }
">" { return createSymbol("Not", sym.GREATER_THAN); }
"<=" { return createSymbol("Not", sym.LOWER_THAN_OR_EQUAL_TO); }
">=" { return createSymbol("Not", sym.GREATER_THAN_OR_EQUAL_TO); }
"==" { return createSymbol("Not", sym.EQUAL_TO); }
"!=" { return createSymbol("Not", sym.NOT_EQUAL_TO); }


{VarName} { return createSymbol("Integer", sym.VAR_NAME, yytext(); }
{IntegerLiteral} { return createSymbol("Integer", sym.INTCONST, new Boolean(yytext())); }
{BooleanLiteral} { return createSymbol("Boolean", sym.BOOLCONST, new Boolean(yytext())); }



. { System.err.println("Illegal character: "+yytext()); }







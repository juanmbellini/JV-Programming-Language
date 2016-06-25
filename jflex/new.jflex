/*-***
 *
 * This file defines a stand-alone lexical analyzer for a subset of this glorious
 * programming language. A mix of pizza and booze.
 *
 */


import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%
%cup
%line
%column


%class Scanner
%{
	public Scanner(java.io.InputStream r, ComplexSymbolFactory sf){
		this(r);
		this.sf=sf;
	}
	public Symbol symbol(String plaintext,int code){
	    return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar));
	}
	public Symbol symbol(String plaintext,int code,Integer number){
	    return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar),number);
	}
	private ComplexSymbolFactory sf;
%}
%eofval{
    return sf.newSymbol("EOF",sym.EOF);
%eofval}



%%
"do"            { return symbol("Do", sym.DO); }
"while"         { return symbol("While", sym.WHILE); }
"ff"            { return symbol("If", sym.IF); }
"ls"            { return symbol("Else", sym.ELSE); }
"+" 			{ return symbol("Plus",sym.PLUS); }
"*" 			{ return symbol("Times",sym.TIMES); }
"-"             { return newSym(sym.MINUS); }
"/"             { return newSym(sym.DIVIDE); }
"(" 			{ return symbol("Left Bracket",sym.LPAREN); }
")" 			{ return symbol("Right Bracket",sym.RPAREN); }
"="             { return newSym(sym.EQ); }
"<"             { return newSym(sym.GTR); }
">"             { return newSym(sym.LESS); }
"<="            { return newSym(sym.LESS_EQ); }
">="            { return newSym(sym.GTR_EQ); }
"!="            { return newSym(sym.NOT_EQ); }
[0-9]+ 			{ return symbol("Integral Number",sym.NUMBER, new Integer(yytext())); }

"int"           { return symbol("Int" , sym.INT); }

"true"          { return symbol("True", sym.BOOLEAN_LITERAL, new Boolean(true)); }
"false"         { return symbol("False", sym.BOOLEAN_LITERAL, new Boolean(false)); }




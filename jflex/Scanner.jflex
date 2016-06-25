package atlc;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;
%%
%cup
%line
%column
%char
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
"dd"            { return symbol(sym.DO); }
"whl"         { return symbol(sym.WHILE); }
"ff"            { return symbol(sym.IF); }
"ls"            { return symbol(sym.ELSE); }
"+" 			{ return symbol(sym.PLUS); }
"*" 			{ return symbol(sym.TIMES); }
"-"             { return newSym(sym.MINUS); }
"/"             { return newSym(sym.DIVIDE); }
"(" 			{ return symbol("Left Bracket",sym.LPAREN); }
")" 			{ return symbol("Right Bracket",sym.RPAREN); }
"=="             { return newSym(sym.EQ); }
"<"             { return newSym(sym.GTR); }
">"             { return newSym(sym.LESS); }
"<="            { return newSym(sym.LESS_EQ); }
">="            { return newSym(sym.GTR_EQ); }
"!="            { return newSym(sym.NOT_EQ); }
[0-9]+ 			{ return symbol("Integral Number",sym.NUMBER, new Integer(yytext())); }

"rd"
"wv"
"wr"
"nl"
" "
"||"
"&&"
"\n"
"\t"



"int"           { return symbol("Int" , sym.INT); }

"true"          { return symbol("True", sym.BOOLEAN_LITERAL, new Boolean(true)); }
"false"         { return symbol("False", sym.BOOLEAN_LITERAL, new Boolean(false)); }
. { System.err.println("Illegal character: "+yytext()); }



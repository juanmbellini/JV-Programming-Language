package org.intellij.grammar.parser;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static org.intellij.grammar.psi.BnfTypes.*;

%%

%{
  public _GrammarLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _GrammarLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

SPACE=[ \t\n\x0B\f\r]+
ID=[a-zA-Z_0-9]+
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\\"|\\'|\\)*\")
NUMBER=[0-9]+
LINE_COMMENT="//".*
BLOCK_COMMENT="/"\*(.|\n)*\*"/"

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "="                  { return BNF_OP_EQ; }
  "::="                { return BNF_OP_IS; }
  "|"                  { return BNF_OP_OR; }
  "?"                  { return BNF_OP_OPT; }
  "+"                  { return BNF_OP_ONEMORE; }
  "*"                  { return BNF_OP_ZEROMORE; }
  "&"                  { return BNF_OP_AND; }
  "!"                  { return BNF_OP_NOT; }
  ";"                  { return BNF_SEMICOLON; }
  "{"                  { return BNF_LEFT_BRACE; }
  "}"                  { return BNF_RIGHT_BRACE; }
  "["                  { return BNF_LEFT_BRACKET; }
  "]"                  { return BNF_RIGHT_BRACKET; }
  "("                  { return BNF_LEFT_PAREN; }
  ")"                  { return BNF_RIGHT_PAREN; }
  "<<"                 { return BNF_EXTERNAL_START; }
  ">>"                 { return BNF_EXTERNAL_END; }

  {SPACE}              { return BNF_SPACE; }
  {ID}                 { return BNF_ID; }
  {STRING}             { return BNF_STRING; }
  {NUMBER}             { return BNF_NUMBER; }
  {LINE_COMMENT}       { return BNF_LINE_COMMENT; }
  {BLOCK_COMMENT}      { return BNF_BLOCK_COMMENT; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}

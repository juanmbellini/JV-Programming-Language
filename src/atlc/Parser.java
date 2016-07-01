
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20140611 (SVN rev 31)
// Fri Jul 01 01:01:54 ART 2016
//----------------------------------------------------

package atlc;

import java_cup.runtime.*;
import atlc.ast.*;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b 20140611 (SVN rev 31) generated parser.
  * @version Fri Jul 01 01:01:54 ART 2016
  */
public class Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\057\000\002\002\004\000\002\002\005\000\002\003" +
    "\004\000\002\003\003\000\002\004\004\000\002\004\003" +
    "\000\002\005\003\000\002\005\003\000\002\005\003\000" +
    "\002\005\003\000\002\006\004\000\002\006\006\000\002" +
    "\006\004\000\002\006\006\000\002\006\004\000\002\006" +
    "\006\000\002\007\007\000\002\007\012\000\002\011\004" +
    "\000\002\011\004\000\002\011\004\000\002\011\003\000" +
    "\002\011\005\000\002\010\010\000\002\010\007\000\002" +
    "\016\003\000\002\016\003\000\002\015\003\000\002\015" +
    "\003\000\002\015\003\000\002\014\005\000\002\014\005" +
    "\000\002\014\005\000\002\014\005\000\002\014\005\000" +
    "\002\014\005\000\002\012\005\000\002\012\005\000\002" +
    "\012\005\000\002\012\005\000\002\012\005\000\002\012" +
    "\004\000\002\012\003\000\002\013\005\000\002\013\005" +
    "\000\002\013\004\000\002\013\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\137\000\004\004\005\001\002\000\004\002\141\001" +
    "\002\000\004\045\006\001\002\000\032\011\020\012\012" +
    "\013\014\033\013\034\026\035\027\037\015\040\030\041" +
    "\010\042\017\045\016\046\011\001\002\000\010\002\ufff9" +
    "\012\ufff9\045\ufff9\001\002\000\004\036\140\001\002\000" +
    "\030\011\020\012\012\013\014\033\013\034\026\035\027" +
    "\037\015\040\030\041\010\042\017\046\011\001\002\000" +
    "\004\043\133\001\002\000\004\036\130\001\002\000\004" +
    "\043\121\001\002\000\004\032\120\001\002\000\032\011" +
    "\020\012\012\013\014\033\013\034\026\035\027\037\015" +
    "\040\030\041\010\042\017\045\016\046\011\001\002\000" +
    "\012\002\uffec\012\uffec\045\uffec\047\115\001\002\000\032" +
    "\011\020\012\012\013\014\033\013\034\026\035\027\037" +
    "\015\040\030\041\010\042\017\045\016\046\011\001\002" +
    "\000\010\002\ufffa\012\ufffa\045\ufffa\001\002\000\010\002" +
    "\ufffc\012\ufffc\045\ufffc\001\002\000\010\002\ufffe\012\ufffe" +
    "\045\ufffe\001\002\000\010\002\ufff8\012\ufff8\045\ufff8\001" +
    "\002\000\010\002\ufffb\012\ufffb\045\ufffb\001\002\000\004" +
    "\036\105\001\002\000\004\036\033\001\002\000\004\036" +
    "\032\001\002\000\004\002\000\001\002\000\010\002\uffee" +
    "\012\uffee\045\uffee\001\002\000\012\002\ufff3\012\ufff3\027" +
    "\034\045\ufff3\001\002\000\016\007\035\024\046\030\042" +
    "\031\044\036\041\043\047\001\002\000\012\007\035\030" +
    "\042\036\051\043\047\001\002\000\016\002\uffe6\012\uffe6" +
    "\025\uffe6\026\uffe6\044\uffe6\045\uffe6\001\002\000\016\002" +
    "\uffd3\012\uffd3\025\uffd3\026\uffd3\044\uffd3\045\uffd3\001\002" +
    "\000\042\002\uffd7\005\uffd7\006\uffd7\007\uffd7\010\uffd7\012" +
    "\uffd7\016\uffd7\017\uffd7\020\uffd7\021\uffd7\022\uffd7\023\uffd7" +
    "\025\uffd7\026\uffd7\044\uffd7\045\uffd7\001\002\000\042\002" +
    "\uffe4\005\uffe7\006\uffe7\007\uffe7\010\uffe7\012\uffe4\016\uffe7" +
    "\017\uffe7\020\uffe7\021\uffe7\022\uffe7\023\uffe7\025\uffe4\026" +
    "\uffe4\044\uffe4\045\uffe4\001\002\000\042\002\uffe8\005\uffe8" +
    "\006\uffe8\007\uffe8\010\uffe8\012\uffe8\016\uffe8\017\uffe8\020" +
    "\uffe8\021\uffe8\022\uffe8\023\uffe8\025\uffe8\026\uffe8\044\uffe8" +
    "\045\uffe8\001\002\000\026\005\053\006\056\007\054\010" +
    "\055\016\072\017\071\020\074\021\075\022\073\023\070" +
    "\001\002\000\016\002\uffe5\012\uffe5\025\uffe5\026\uffe5\044" +
    "\uffe5\045\uffe5\001\002\000\014\002\ufff2\012\ufff2\025\065" +
    "\026\064\045\ufff2\001\002\000\016\007\035\024\046\030" +
    "\042\031\044\036\041\043\047\001\002\000\012\007\035" +
    "\030\042\036\051\043\047\001\002\000\014\005\053\006" +
    "\056\007\054\010\055\044\052\001\002\000\042\002\uffe7" +
    "\005\uffe7\006\uffe7\007\uffe7\010\uffe7\012\uffe7\016\uffe7\017" +
    "\uffe7\020\uffe7\021\uffe7\022\uffe7\023\uffe7\025\uffe7\026\uffe7" +
    "\044\uffe7\045\uffe7\001\002\000\042\002\uffd9\005\uffd9\006" +
    "\uffd9\007\uffd9\010\uffd9\012\uffd9\016\uffd9\017\uffd9\020\uffd9" +
    "\021\uffd9\022\uffd9\023\uffd9\025\uffd9\026\uffd9\044\uffd9\045" +
    "\uffd9\001\002\000\012\007\035\030\042\036\051\043\047" +
    "\001\002\000\012\007\035\030\042\036\051\043\047\001" +
    "\002\000\012\007\035\030\042\036\051\043\047\001\002" +
    "\000\012\007\035\030\042\036\051\043\047\001\002\000" +
    "\042\002\uffdb\005\uffdb\006\uffdb\007\uffdb\010\uffdb\012\uffdb" +
    "\016\uffdb\017\uffdb\020\uffdb\021\uffdb\022\uffdb\023\uffdb\025" +
    "\uffdb\026\uffdb\044\uffdb\045\uffdb\001\002\000\042\002\uffda" +
    "\005\uffda\006\uffda\007\uffda\010\uffda\012\uffda\016\uffda\017" +
    "\uffda\020\uffda\021\uffda\022\uffda\023\uffda\025\uffda\026\uffda" +
    "\044\uffda\045\uffda\001\002\000\042\002\uffdc\005\uffdc\006" +
    "\056\007\uffdc\010\055\012\uffdc\016\uffdc\017\uffdc\020\uffdc" +
    "\021\uffdc\022\uffdc\023\uffdc\025\uffdc\026\uffdc\044\uffdc\045" +
    "\uffdc\001\002\000\042\002\uffdd\005\uffdd\006\056\007\uffdd" +
    "\010\055\012\uffdd\016\uffdd\017\uffdd\020\uffdd\021\uffdd\022" +
    "\uffdd\023\uffdd\025\uffdd\026\uffdd\044\uffdd\045\uffdd\001\002" +
    "\000\016\002\uffd4\012\uffd4\025\uffd4\026\uffd4\044\uffd4\045" +
    "\uffd4\001\002\000\016\007\035\024\046\030\042\031\044" +
    "\036\041\043\047\001\002\000\016\007\035\024\046\030" +
    "\042\031\044\036\041\043\047\001\002\000\016\002\uffd6" +
    "\012\uffd6\025\uffd6\026\064\044\uffd6\045\uffd6\001\002\000" +
    "\016\002\uffd5\012\uffd5\025\uffd5\026\uffd5\044\uffd5\045\uffd5" +
    "\001\002\000\012\007\035\030\042\036\051\043\047\001" +
    "\002\000\012\007\035\030\042\036\051\043\047\001\002" +
    "\000\012\007\035\030\042\036\051\043\047\001\002\000" +
    "\012\007\035\030\042\036\051\043\047\001\002\000\012" +
    "\007\035\030\042\036\051\043\047\001\002\000\012\007" +
    "\035\030\042\036\051\043\047\001\002\000\026\002\uffe3" +
    "\005\053\006\056\007\054\010\055\012\uffe3\025\uffe3\026" +
    "\uffe3\044\uffe3\045\uffe3\001\002\000\026\002\uffe2\005\053" +
    "\006\056\007\054\010\055\012\uffe2\025\uffe2\026\uffe2\044" +
    "\uffe2\045\uffe2\001\002\000\026\002\uffe1\005\053\006\056" +
    "\007\054\010\055\012\uffe1\025\uffe1\026\uffe1\044\uffe1\045" +
    "\uffe1\001\002\000\026\002\uffdf\005\053\006\056\007\054" +
    "\010\055\012\uffdf\025\uffdf\026\uffdf\044\uffdf\045\uffdf\001" +
    "\002\000\026\002\uffde\005\053\006\056\007\054\010\055" +
    "\012\uffde\025\uffde\026\uffde\044\uffde\045\uffde\001\002\000" +
    "\026\002\uffe0\005\053\006\056\007\054\010\055\012\uffe0" +
    "\025\uffe0\026\uffe0\044\uffe0\045\uffe0\001\002\000\042\002" +
    "\uffd8\005\uffd8\006\056\007\uffd8\010\055\012\uffd8\016\uffd8" +
    "\017\uffd8\020\uffd8\021\uffd8\022\uffd8\023\uffd8\025\uffd8\026" +
    "\uffd8\044\uffd8\045\uffd8\001\002\000\012\002\ufff5\012\ufff5" +
    "\027\106\045\ufff5\001\002\000\004\032\107\001\002\000" +
    "\010\002\ufff4\012\ufff4\045\ufff4\001\002\000\004\012\111" +
    "\001\002\000\004\043\112\001\002\000\016\007\035\024" +
    "\046\030\042\031\044\036\041\043\047\001\002\000\010" +
    "\025\065\026\064\044\114\001\002\000\010\002\uffea\012" +
    "\uffea\045\uffea\001\002\000\004\030\116\001\002\000\010" +
    "\002\uffeb\012\uffeb\045\uffeb\001\002\000\010\002\uffff\012" +
    "\uffff\045\uffff\001\002\000\010\002\uffed\012\uffed\045\uffed" +
    "\001\002\000\016\007\035\024\046\030\042\031\044\036" +
    "\041\043\047\001\002\000\010\025\065\026\064\044\123" +
    "\001\002\000\032\011\020\012\012\013\014\033\013\034" +
    "\026\035\027\037\015\040\030\041\010\042\017\045\016" +
    "\046\011\001\002\000\010\002\ufff1\012\ufff1\045\ufff1\001" +
    "\002\000\004\014\126\001\002\000\032\011\020\012\012" +
    "\013\014\033\013\034\026\035\027\037\015\040\030\041" +
    "\010\042\017\045\016\046\011\001\002\000\010\002\ufff0" +
    "\012\ufff0\045\ufff0\001\002\000\012\002\ufff7\012\ufff7\027" +
    "\131\045\ufff7\001\002\000\012\007\035\030\042\036\051" +
    "\043\047\001\002\000\020\002\ufff6\005\053\006\056\007" +
    "\054\010\055\012\ufff6\045\ufff6\001\002\000\016\007\035" +
    "\024\046\030\042\031\044\036\041\043\047\001\002\000" +
    "\010\025\065\026\064\044\135\001\002\000\032\011\020" +
    "\012\012\013\014\033\013\034\026\035\027\037\015\040" +
    "\030\041\010\042\017\045\016\046\011\001\002\000\010" +
    "\002\uffe9\012\uffe9\045\uffe9\001\002\000\010\002\ufffd\012" +
    "\ufffd\045\ufffd\001\002\000\010\002\uffef\012\uffef\045\uffef" +
    "\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\137\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\020\003\030\004\022\005\021\006\024" +
    "\007\020\010\006\011\023\001\001\000\002\001\001\000" +
    "\002\001\001\000\016\004\136\005\021\006\024\007\020" +
    "\010\006\011\023\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\020\003\116" +
    "\004\022\005\021\006\024\007\020\010\006\011\023\001" +
    "\001\000\002\001\001\000\020\003\107\004\022\005\021" +
    "\006\024\007\020\010\006\011\023\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\014\012\042\013\044\014\035\015\036\016" +
    "\037\001\001\000\006\012\103\016\037\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\014\012\042\013\062\014\035\015" +
    "\036\016\037\001\001\000\006\012\047\016\037\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\012\061\016\037\001\001\000\006\012\060\016\037" +
    "\001\001\000\006\012\057\016\037\001\001\000\006\012" +
    "\056\016\037\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\014\012\042\013\066\014\035\015\036\016\037\001\001" +
    "\000\014\012\042\013\065\014\035\015\036\016\037\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\012\102" +
    "\016\037\001\001\000\006\012\101\016\037\001\001\000" +
    "\006\012\100\016\037\001\001\000\006\012\077\016\037" +
    "\001\001\000\006\012\076\016\037\001\001\000\006\012" +
    "\075\016\037\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\014\012\042\013\112\014\035\015\036\016\037" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\014\012\042\013\121\014\035\015\036\016\037\001" +
    "\001\000\002\001\001\000\020\003\123\004\022\005\021" +
    "\006\024\007\020\010\006\011\023\001\001\000\002\001" +
    "\001\000\002\001\001\000\020\003\126\004\022\005\021" +
    "\006\024\007\020\010\006\011\023\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\012\131\016\037\001\001" +
    "\000\002\001\001\000\014\012\042\013\133\014\035\015" +
    "\036\016\037\001\001\000\002\001\001\000\020\003\135" +
    "\004\022\005\021\006\024\007\020\010\006\011\023\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public static void main(String args[]) throws Exception {
        ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();
        if (args.length == 0) {
            new Parser(new Scanner(System.in, symbolFactory), symbolFactory).parse();
        } else {
            new Parser(new Scanner(new java.io.FileInputStream(args[0]), symbolFactory), symbolFactory).parse();
        }
    }

    public void syntax_error(Symbol sym){ 
    // Mute legacy Error Printing
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		Location start_valxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location start_valxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= MAIN EOL BLOCK 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // BLOCK ::= EOL BLOCK 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BLOCK",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // BLOCK ::= LINE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BLOCK",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // LINE ::= TAB LINE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("LINE",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // LINE ::= INSTRUCTION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("LINE",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // INSTRUCTION ::= ASSIGNMENT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCTION",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // INSTRUCTION ::= BLOCK_IF 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCTION",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // INSTRUCTION ::= BLOCK_WHILE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCTION",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // INSTRUCTION ::= COMMAND 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCTION",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // ASSIGNMENT ::= TYPE_INT VAR_NAME 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ASSIGNMENT",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // ASSIGNMENT ::= TYPE_INT VAR_NAME ASSIGN EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ASSIGNMENT",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // ASSIGNMENT ::= TYPE_STR VAR_NAME 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ASSIGNMENT",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // ASSIGNMENT ::= TYPE_STR VAR_NAME ASSIGN LIT_STR 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ASSIGNMENT",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // ASSIGNMENT ::= TYPE_BOOL VAR_NAME 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ASSIGNMENT",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ASSIGNMENT ::= TYPE_BOOL VAR_NAME ASSIGN EXP_BOOL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ASSIGNMENT",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // BLOCK_IF ::= IF LPAREN EXP_BOOL RPAREN BLOCK 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BLOCK_IF",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // BLOCK_IF ::= IF LPAREN EXP_BOOL RPAREN BLOCK EOL ELSE BLOCK 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BLOCK_IF",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // COMMAND ::= READ VAR_NAME 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMMAND",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // COMMAND ::= WRITE_VAR VAR_NAME 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMMAND",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // COMMAND ::= WRITE LIT_STR 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMMAND",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // COMMAND ::= NEW_LINE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMMAND",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // COMMAND ::= NEW_LINE SPACE LIT_INT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMMAND",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // BLOCK_WHILE ::= DO BLOCK WHILE LPAREN EXP_BOOL RPAREN 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BLOCK_WHILE",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // BLOCK_WHILE ::= WHILE LPAREN EXP_BOOL RPAREN BLOCK 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BLOCK_WHILE",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // NUM_RESULT ::= LIT_INT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("NUM_RESULT",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // NUM_RESULT ::= VAR_NAME 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("NUM_RESULT",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // BOOL_RESULT ::= COMPARATOR 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BOOL_RESULT",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // BOOL_RESULT ::= LIT_BOOL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BOOL_RESULT",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // BOOL_RESULT ::= VAR_NAME 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("BOOL_RESULT",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // COMPARATOR ::= EXP_NUM LT EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMPARATOR",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // COMPARATOR ::= EXP_NUM GT EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMPARATOR",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // COMPARATOR ::= EXP_NUM LE EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMPARATOR",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // COMPARATOR ::= EXP_NUM GE EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMPARATOR",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // COMPARATOR ::= EXP_NUM EQ EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMPARATOR",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // COMPARATOR ::= EXP_NUM NEQ EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMPARATOR",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // EXP_NUM ::= EXP_NUM PLUS EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_NUM",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // EXP_NUM ::= EXP_NUM MINUS EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_NUM",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // EXP_NUM ::= EXP_NUM TIMES EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_NUM",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // EXP_NUM ::= EXP_NUM DIVIDE EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_NUM",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // EXP_NUM ::= LPAREN EXP_NUM RPAREN 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_NUM",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // EXP_NUM ::= MINUS EXP_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_NUM",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // EXP_NUM ::= NUM_RESULT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_NUM",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // EXP_BOOL ::= EXP_BOOL OR EXP_BOOL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_BOOL",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // EXP_BOOL ::= EXP_BOOL AND EXP_BOOL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_BOOL",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // EXP_BOOL ::= NOT EXP_BOOL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_BOOL",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // EXP_BOOL ::= BOOL_RESULT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXP_BOOL",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}


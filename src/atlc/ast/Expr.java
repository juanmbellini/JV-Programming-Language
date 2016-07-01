package atlc.ast;

import atlc.sym;
import java_cup.runtime.ComplexSymbolFactory.Location;

public abstract class Expr {
    public abstract int eval();
    public abstract Location right();
    public abstract Location left();
    static class BinExpr extends Expr {
        Expr l, r;
        int s;
        BinExpr(Expr l, int sym, Expr r) {
            this.l = l;
            this.r = r;
            this.s = sym;
        }
        public int eval() {
            if (s==sym.PLUS) {
                return l.eval() + r.eval();
            } else {
                return l.eval() * r.eval();
            }
        }
        public Location left() {
            return l.left();
        }
        public Location right() {
            return r.right();
        }
    }
    static class Const extends Expr {
        Location l, r;
        Integer value;
        Const(Location l,Integer i,Location r) {
            this.l = l;
            this.r = r;
            this.value = i;
        }
        public int eval() {
            return value;
        }
        public Location left() {
            return l;
        }
        public Location right() {
            return r;
        }
    }
    }

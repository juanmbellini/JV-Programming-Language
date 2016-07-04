package atlc.expr;

import atlc.Context;
import org.objectweb.asm.Type;

import java.util.function.Function;

abstract class ExprFactory<T> {

    abstract Type getType();
    abstract Function<Context, Type> createLiteral(T obj);

    public Function<Context, Type> createBinary(final int op, Function<Context, Type> e1, Function<Context, Type> e2) {
        return context -> {
            e1.apply(context);
            e2.apply(context);
            context.getGa().math(op, this.getType());
            return this.getType();
        };
    }

}

package atlc.nodes;

import atlc.Context;
import org.objectweb.asm.Type;

import java.util.function.Function;

public class ArithmeticFactory {

    public static Function<Context, Type> createLiteral(Integer n) {
        return context -> {
            context.getGa().push(n);
            return Type.INT_TYPE;
        };
    }

    public static Function<Context, Type> createBinary(final int op, Function<Context, Type> e1, Function<Context, Type> e2) {
        return context -> {
            e1.apply(context);
            e2.apply(context);
            context.getGa().math(op, Type.INT_TYPE);
            return Type.INT_TYPE;
        };
    }
}

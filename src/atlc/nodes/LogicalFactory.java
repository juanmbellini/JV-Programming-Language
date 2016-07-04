package atlc.nodes;

import atlc.Context;
import org.objectweb.asm.Type;

import java.util.function.Function;

public class LogicalFactory {

    public static Function<Context, Type> createLiteral(Boolean b) {
        return context -> {
            context.getGa().push(b);
            return Type.BOOLEAN_TYPE;
        };
    }

    public static Function<Context, Type> createBinary(final int op, Function<Context, Type> e1, Function<Context, Type> e2) {
        return context -> {
            e1.apply(context);
            e2.apply(context);
            context.getGa().math(op, Type.BOOLEAN_TYPE);
            return Type.BOOLEAN_TYPE;
        };
    }
}

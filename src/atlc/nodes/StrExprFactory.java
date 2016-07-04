package atlc.nodes;

import atlc.Context;
import org.objectweb.asm.Type;

import java.util.function.Function;

public class StrExprFactory {
    public static Function<Context, Type> createLiteral(String str) {
        return context -> {
            context.getGa().push(str);
            return Type.getType(String.class);
        };
    }
}

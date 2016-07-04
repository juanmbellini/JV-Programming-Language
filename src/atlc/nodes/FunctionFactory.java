package atlc.nodes;

import atlc.Context;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.Type;
import java.io.PrintStream;
import java.util.function.Function;

public final class FunctionFactory {

    public static void writeLine(Function<Context, Type> expr, Context context) {
        context.getGa().getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        Type type = expr.apply(context);
        context.getGa().invokeVirtual(
                Type.getType(PrintStream.class),
                new Method("println", Type.VOID_TYPE, new Type[] {type})
        );
    }

}

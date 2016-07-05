package atlc.nodes;

import atlc.Context;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.Type;
import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class FunctionFactory {

    public void writeLine(Function<Context, Type> expr, Context context) {
        write(expr, context, true);
    }

    public void write(Function<Context, Type> expr, Context context) {
        write(expr, context, false);
    }

    private void write(Function<Context, Type> expr, Context context, boolean newLine) {
        context.getGa().getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        Type type = expr.apply(context);
        context.getGa().invokeVirtual(
                Type.getType(PrintStream.class),
                new Method(newLine ? "println" : "print", Type.VOID_TYPE, new Type[] {type})
        );
    }

    public Consumer<Context> createFn(
            Type returnType,
            String name,
            Consumer<Context> params,
            Consumer<Context> closure
            ) {
        return context -> {};
    }

    public Consumer<Context> createFn(
            String name,
            Consumer<Context> params,
            Consumer<Context> closure
    ) {
        return this.createFn(Type.VOID_TYPE, name, params, closure);
    }

    public Function<Context, Type> createFnParam(
            Type type,
            String name
    ) {
        return context -> type;
    }

    public Function<Context, Type> invokeFn(
            String name,
            Consumer<Context> argumentList
    ) {
        return context -> Type.VOID_TYPE;
    }
}

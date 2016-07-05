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
            Function<Context, List<Type>> arguments,
            Consumer<Context> closure
            ) {
        return context -> {
            List<Type> tl = arguments.apply(context);
            Type[] types = tl.toArray(new Type[tl.size()]);
            context.start(new Method(name, returnType, types));
            closure.accept(context);
            // TODO save reference (and maybe create invoker code) to invoke later
            context.endMethod();
        };
    }

    public Consumer<Context> createFn(
            String name,
            Function<Context, List<Type>> arguments,
            Consumer<Context> closure
    ) {
        return this.createFn(Type.VOID_TYPE, name, arguments, closure);
    }

    public Function<Context, Type> createFnParam(
            Type type,
            String name
    ) {
        return context -> type;
    }

    public Function<Context, Type> invokeFn(
            String name,
            Function<Context, List<Type>> arguments
    ) {
        // TODO invoke pushing arguments.
        return context -> Type.VOID_TYPE;
    }
}

package atlc.nodes;

import atlc.Context;
import atlc.expr.ExceptionFactory;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.Type;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class FunctionFactory {

    private Map<String, Method> methods = new HashMap<>();

    public void writeLine(Function<Context, Type> expr, Context context) {
        write(expr, context, true);
    }

    public void write(Function<Context, Type> expr, Context context) {
        write(expr, context, false);
    }

    public static void read(Function<Context, Type> targetType, Consumer<Context> target, Context context) {
        context.getGa().newInstance(Type.getType(Scanner.class));
        context.getGa().dup(); // Duplicate since we are constructing and calling
        context.getGa().getStatic(Type.getType(System.class), "in", Type.getType(InputStream.class));
        context.getGa().invokeConstructor(Type.getType(Scanner.class), Method.getMethod("void <init> (java.io.InputStream)"));
        Type type = targetType.apply(context);
        context.getGa().invokeVirtual(Type.getType(Scanner.class), getReadMethod(type));
        target.accept(context);
    }

    private static Method getReadMethod(Type type) {
        if (type.equals(Type.getType(Integer.class)) || type.equals(Type.INT_TYPE)) {
            return new Method("nextInt", Type.INT_TYPE, new Type[] {});
        }
        if (type.equals(Type.getType(Boolean.TYPE)) || type.equals(Type.BOOLEAN_TYPE)) {
            return new Method("nextBoolean", Type.BOOLEAN_TYPE, new Type[] {});
        }
        return new Method("nextLine", Type.getType(String.class), new Type[] {});
    }

    private static void write(Function<Context, Type> expr, Context context, boolean newLine) {
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
            List<Function<Context, Type>> arguments,
            Consumer<Context> closure
            ) {
        return context -> {
            List<Type> tl = new ArrayList<>();
            for (Function<Context, Type> argument : arguments) {
                tl.add(argument.apply(context));
            }
            Method method = new Method(name, returnType, this.toTypeArray(tl));
            context.start(method);
            closure.accept(context);
            methods.put(name, method);
            context.endMethod();
        };
    }

    public Consumer<Context> createFn(
            String name,
            List<Function<Context, Type>> arguments,
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
            List<Function<Context, Type>> arguments
    ) {
        return context -> {
            final Method method = methods.get(name);
            if (method == null) {
                return ExceptionFactory.createRuntime("Invalid method: " + name).apply(context);
            }
            List<Type> tl = arguments.stream().map(argument -> argument.apply(context)).collect(Collectors.toList());
            Type[] types = this.toTypeArray(tl);
            if (!Arrays.equals(types, method.getArgumentTypes())) {
                for (Type ignored : types) {
                    context.getGa().pop();
                }
                return ExceptionFactory.createRuntime("Invalid arguments for method <" + name + ">: \n" +
                        "\tExpected: " + Arrays.toString(method.getArgumentTypes()) + "\n" +
                        "\t     Got: " + Arrays.toString(types)).apply(context);
            }
            context.getGa().invokeStatic(context.getClassType(), method);
            return method.getReturnType();
        };
    }

    private Type[] toTypeArray(List<Type> list) {
        return list.toArray(new Type[list.size()]);
    }
}

package atlc.nodes;

import atlc.Context;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.Type;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public final class FunctionFactory {

    public static void writeLine(Function<Context, Type> expr, Context context) {
        write(expr, context, true);
    }

    public static void write(Function<Context, Type> expr, Context context) {
        write(expr, context, false);
    }

    public static void read(Function<Context, Type> targetType, Consumer<Context> target, Context context) {
        context.getGa().newInstance(Type.getType(Scanner.class));
        context.getGa().dup(); // Duplicate since we are constructing and calling
        context.getGa().getStatic(Type.getType(System.class), "in", Type.getType(InputStream.class));
        context.getGa().invokeConstructor(Type.getType(Scanner.class), Method.getMethod("void <init> (java.io.InputStream)"));
        Type type = targetType.apply(context);
        context.getGa().invokeVirtual(Type.getType(Scanner.class), getReadMethod(type));
    }

    private static Method getReadMethod(Type type) {
        if (type.equals(Type.getType(Integer.class)) || type.equals(Type.INT_TYPE)) {
            return new Method("nextInt", Type.INT_TYPE, new Type[] {});
        }
        if (type.equals(Type.getType(Boolean.TYPE)) || type.equals(Type.BOOLEAN_TYPE)) {
            return new Method("nextBoolean", Type.BOOLEAN_TYPE, new Type[] {});
        }
        return new Method("next", Type.getType(String.class), new Type[] {});
    }

    private static void write(Function<Context, Type> expr, Context context, boolean newLine) {
        context.getGa().getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        Type type = expr.apply(context);
        context.getGa().invokeVirtual(
                Type.getType(PrintStream.class),
                new Method(newLine ? "println" : "print", Type.VOID_TYPE, new Type[] {type})
        );
    }
}

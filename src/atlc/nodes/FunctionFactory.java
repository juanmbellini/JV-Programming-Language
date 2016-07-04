package atlc.nodes;

import atlc.Context;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.Type;
import java.io.PrintStream;

public final class FunctionFactory {

	public static void writeLine(Object expr, Context context) {
		if (expr instanceof String) {
			writeLine((String) expr, context);
		}
        if (expr instanceof Integer) {
            writeLine((Integer) expr, context);
        }
	}
	
    public static void writeLine(String expr, Context context) {
        context.getGa().getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        context.getGa().push(expr);
        context.getGa().invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));
    }

    public static void writeLine(Integer expr, Context context) {
        context.getGa().getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        context.getGa().push(expr);
        context.getGa().invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (Integer)"));
    }
}

package atlc.nodes;

import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.Type;
import java.io.PrintStream;

import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public final class FunctionFactory {

	public static void writeLine(Object expr, GeneratorAdapter ga) {
		if (expr instanceof String) {
			writeLine((String) expr, ga);
		}
	}
	
    public static void writeLine(String expr, GeneratorAdapter ga) {
        InsnList il = new InsnList();
        ga.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        ga.push(expr);
        ga.invokeVirtual(Type.getType(PrintStream.class),
                Method.getMethod("void println (String)"));
    }
}

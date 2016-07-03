package atlc.nodes;

import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;

import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public final class FunctionFactory {

    public static InsnList writeLine(InsnList expr) {
        InsnList il = new InsnList();
        il.add(new FieldInsnNode(
                GETSTATIC,
                "java/lang/System",
                "out",
                "Ljava/io/PrintStream;"
        ));
        il.add(expr);
        il.add(new MethodInsnNode(
                INVOKEVIRTUAL,
                "java/io/PrintStream",
                "println",
                "(Ljava/lang/String;)V",
                false
        ));
        return il;
    }
}

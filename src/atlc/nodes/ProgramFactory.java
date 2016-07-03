package atlc.nodes;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

@SuppressWarnings("unchecked")
public class ProgramFactory implements Opcodes {
    public static ClassNode create(List<MethodNode> methods, InsnList main) {
        ClassNode c = new ClassNode();
        methods.forEach(methodNode -> c.methods.add(methodNode));
        MethodVisitor m = c.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        m.visitCode();
        main.accept(m);
        m.visitEnd();
        return c;
    }
}

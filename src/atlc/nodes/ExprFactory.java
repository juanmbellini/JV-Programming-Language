package atlc.nodes;


import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;

public final class ExprFactory {

    private static InsnList _create(Object str) {
        InsnList il = new InsnList();
        il.add(new LdcInsnNode(str));
        return il;
    }

    public static InsnList create(Integer literal) {
        return _create(literal);
    }

    public static InsnList create(Boolean literal) {
        return _create(literal);
    }

    public static InsnList create(String literal) {
        return _create(literal);
    }

}

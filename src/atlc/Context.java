package atlc;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import java.util.*;
import java.util.function.Consumer;

public class Context implements Opcodes {
    private final ClassWriter cw;
    private GeneratorAdapter ga = null;
    private Deque<Map<String, Integer>> localVariablesStack;

    public Context(ClassWriter cw) {
        this.cw = cw;
        this.localVariablesStack = new ArrayDeque<>();
    }

    public void start(Method method) {
        if (ga == null) {
            this.ga = new GeneratorAdapter(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, method, null, null, cw);
        } else {
            throw new RuntimeException("CANNOT START");
        }
    }

    public void endMethod() {
        ga.returnValue();
        ga.endMethod();
        ga = null;
    }

    public GeneratorAdapter getGa() {
        return ga;
    }

    public ClassWriter getCw() {
        return cw;
    }

}

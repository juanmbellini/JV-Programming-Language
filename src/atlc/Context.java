package atlc;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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
    
    public void addLocal(String name, Type type) {
        // TODO: Default values
        int localId = ga.newLocal(type);
        getLocalVariables().put(name, localId);
    }
    
    public void addLocal(String name, Type type, Function<Context, Type> value) {
    	addLocal(name, type);
    	assignLocal(name, value);
    }

    public void assignLocal(String name, Function<Context, Type> value) {
    	int localId = getLocalVariables().get(name);
    	value.apply(this);
    	ga.storeLocal(localId);
    }
    
    public void endMethod() {
        ga.returnValue();
        ga.endMethod();
        ga = null;
    }

    public int getVariableId(String name) {
      return getLocalVariables().get(name);
    }

    public Type getVariableType(int variableId) {
        return ga.getLocalType(variableId);
    }

    public GeneratorAdapter getGa() {
        return ga;
    }

    public ClassWriter getCw() {
        return cw;
    }

    private Map<String, Integer> getLocalVariables() {
    	if (localVariablesStack.isEmpty()) {
    		localVariablesStack.push(new HashMap<>());
    	}
    	return localVariablesStack.peekFirst();
    }
}

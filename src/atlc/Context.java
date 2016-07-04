package atlc;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
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
    
    public void addLocal(String name, Type type) {
    	if (type == Type.INT_TYPE) {
    		addLocal(name, type, 0);
    	}
    }
    
    public void addLocal(String name, Type type, Object value) {
    	int localId = ga.newLocal(type);
    	getLocalVariables().put(name, localId);
    	assignLocal(name, value);
    }

    public void assignLocal(String name, Object value) {
    	int localId = getLocalVariables().get(name);
    	Type localType = getVariableType(localId);
    	if (localType == Type.INT_TYPE) {
            ga.push((Integer) value);
        } else if (localType == Type.getType(String.class)) {
            ga.push((String) value);
        }
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

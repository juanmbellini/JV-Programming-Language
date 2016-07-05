package atlc.var;

import atlc.Context;

import org.objectweb.asm.Type;

import java.util.function.Consumer;
import java.util.function.Function;

public class VariableFactory {

    public Function<Context, Type> loadLocal(String name) {
        return context -> {
              int id = context.getVariableId(name);
              context.getGa().loadLocal(id);
              return context.getVariableType(id);
        };
    }

    public Consumer<Context> assignLocal(String name, Function<Context, Type> value) {
        return context -> context.assignLocal(name, value);
    }

    public Consumer<Context> createLocal(String name, Type type) {
        return context -> context.addLocal(name, type);
    }

    public Consumer<Context> createLocal(String name, Type type, Function<Context, Type> value) {
        return context -> context.addLocal(name, type, value);
    }

}

package atlc.expr;

import atlc.Context;
import org.objectweb.asm.Type;

import java.util.function.Function;

public class LogicalFactory extends ExprFactory<Boolean> {

    @Override
    protected Type getType() {
        return Type.BOOLEAN_TYPE;
    }

    @Override
    public Function<Context, Type> createLiteral(Boolean obj) {
        return context -> {
            context.getGa().push(obj);
            return this.getType();
        };
    }

    public Function<Context, Type> createNot(Function<Context, Type> e) {
        return context -> {
            e.apply(context);
            context.getGa().not();
            return this.getType();
        };
    }
}

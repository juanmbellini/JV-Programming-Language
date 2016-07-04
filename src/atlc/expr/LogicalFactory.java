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

}

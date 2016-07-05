package atlc.nodes;

import atlc.Context;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;

import java.util.function.Consumer;
import java.util.function.Function;

public class FlowControlFactory {

    public static Consumer<Context> createIf (
            Function<Context, Type> expr,
            Consumer<Context> ifTrueBlock,
            Consumer<Context> elseBlock
    ) {
        return context -> {
            GeneratorAdapter ga = context.getGa();
            final Label ifTrueRun = ga.newLabel();
            final Label elseRun = ga.newLabel();
            final Label endIf = ga.newLabel();

            expr.apply(context);
            ga.ifZCmp(GeneratorAdapter.NE, ifTrueRun);
            ga.goTo(elseRun);

            ga.visitLabel(ifTrueRun);
            ifTrueBlock.accept(context);
            ga.goTo(endIf);
            ga.visitLabel(elseRun);
            if (elseBlock != null) {
                elseBlock.accept(context);
            }
            ga.visitLabel(endIf);
        };
    }
}

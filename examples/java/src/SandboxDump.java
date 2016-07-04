import org.objectweb.asm.*;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

public class SandboxDump implements Opcodes {

    public static byte[] dump() throws Exception {
        ClassWriter cw = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
        cw.visit(V1_8, ACC_PUBLIC, "Example", null, "java/lang/Object", null);

        Method m = Method.getMethod("void <init> ()");
        GeneratorAdapter mg = new GeneratorAdapter(ACC_PUBLIC, m, null, null, cw);
        mg.loadThis();
        mg.invokeConstructor(Type.getType(Object.class), m);
        mg.returnValue();
        mg.endMethod();

        m = Method.getMethod("boolean fun2 ()");
        mg = new GeneratorAdapter(ACC_PRIVATE + ACC_STATIC, m, null, null, cw);
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        mg.push("Hello world!");
        mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));
        mg.returnValue();
        mg.endMethod();

        m = Method.getMethod("void main (String[])");
        mg = new GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, m, null, null, cw);
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        mg.push("Hello world!");
        mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));
        mg.returnValue();
        mg.endMethod();

        cw.visitEnd();

        return cw.toByteArray();
    }

    public static void main(String[] args) {
        try {
            Path file = Paths.get("examples/java/gen/HelloWorld.class");
            Files.write(file, SandboxDump.dump());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

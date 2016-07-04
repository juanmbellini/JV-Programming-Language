package atlc;

import java_cup.runtime.ComplexSymbolFactory;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

public class JvCompiler implements Opcodes {

    public static final Logger l = Logger.getLogger("JvCompiler");

    public static void main(String args[]) throws Exception {
        // Parser.l.setLevel(Level.WARNING);
        ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();
        String sourceFile = args[0];
        String javaClass = FileSystems.getDefault().getPath(sourceFile).getFileName().toString();
        String className = javaClass.substring(0, 1).toUpperCase() + javaClass.substring(1);
        className = className.substring(0,className.lastIndexOf(".jv"));
        ClassWriter cw = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, className, null, "java/lang/Object", null);
        new Parser(
                new Scanner(new FileReader(sourceFile), symbolFactory),
                symbolFactory,
                cw
        ).parse();

        Path file = Paths.get("examples/jv/gen/" + className + ".class");
        Files.write(file, cw.toByteArray());
    }
}

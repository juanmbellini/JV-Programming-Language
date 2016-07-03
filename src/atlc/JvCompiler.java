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

public class JvCompiler implements Opcodes {

    public static final Logger l = Logger.getLogger("JvCompiler");


    public static void main(String args[]) throws Exception {
        // Parser.l.setLevel(Level.WARNING);
        ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();
        String sourceFile = args[0];
        String javaClass = FileSystems.getDefault().getPath(sourceFile).getFileName().toString();
        String className = javaClass.substring(0, 1).toUpperCase() + javaClass.substring(1);
        className = className.substring(0,className.lastIndexOf(".jv"));

        ClassWriter cw = (ClassWriter) new Parser(
                new Scanner(new FileReader(sourceFile), symbolFactory),
                symbolFactory
        ).parse().value;

        Path file = Paths.get("examples/java/gen/" + className + ".class");
        Files.write(file, cw.toByteArray());
    }
}

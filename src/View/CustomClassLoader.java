package View;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {

    private static final String packagePath = "Tools.";

    public Class<?> defineClassFromFile(File file) throws IOException {
        Path path = Paths.get(file.getPath());
        return this.defineClassFromPath(path);
    }

    public Class<?> defineClassFromPath(Path path) throws IOException {
        String name = packagePath + path.getFileName().toString().split(".class")[0];//Récupère le nom du fichier (avec package), sans l'extension
        byte[] b = Files.readAllBytes(path); //Lit chaque byte du fichier proposé
        int off = 0; //De 0
        int len = b.length; //Jusqu'à la fin du fichier
        return this.defineClass(name, b, off, len);
    }
}

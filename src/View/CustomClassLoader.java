package View;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {
    private static final String packagePath = "Tools."; //chemin vers notre dossier .Tools

    public Class<?> defineClassFromFile(File file) throws IOException {
        Path path = Paths.get(file.getPath());
        return this.defineClassFromPath(path);
    }

    public Class<?> defineClassFromPath(Path path) throws IOException {
        String name = packagePath + path.getFileName().toString().split(".class")[0];   //récupère le nom du fichier choisi
        byte[] b = Files.readAllBytes(path);    //on lit chaque bit de ce fichier
        int off = 0;    //on part du début du fichier
        int len = b.length;     //on lit jusqu'à la fin du fichier
        return this.defineClass(name, b, off, len);     //on retourne la class du fichier .class
    }
}

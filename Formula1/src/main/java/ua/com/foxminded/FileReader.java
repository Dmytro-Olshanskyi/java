package ua.com.foxminded;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    protected List<String> read(File file) {
        requiredValidFile(file);
        try {
            return Files.readAllLines(Paths.get(String.valueOf(file)));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void requiredValidFile(File file) {
        if (file == null)
            throw new IllegalArgumentException("File arg is null!");
        if (!file.exists())
            throw new IllegalArgumentException(file + " does not exist!");
        if (!file.canRead())
            throw new IllegalArgumentException(file + " cant read!");
        if (!file.isFile())
            throw new IllegalArgumentException(file + " is not a file. (is directory or something else)");
        if (file.length() < 19)
            throw new IllegalArgumentException(file + " length is invalid!");
    }
}

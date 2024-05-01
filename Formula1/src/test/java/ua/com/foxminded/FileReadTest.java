package ua.com.foxminded;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class FileReadTest {

    @Test
    @DisplayName("If file argument is null")
    void fileIsNullReturnIllegalArgumentException() {
        FileReader fileReader = new FileReader();

        Exception illegalArgumentException = assertThrows(RuntimeException.class,
                () -> fileReader.read(null));

        String expected = "File arg is null!";
        String result = illegalArgumentException.getMessage();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("File does not exist")
    void fileDotExistReturnIllegalArgumentException() {
        FileReader fileReader = new FileReader();
        File notExist = new File("src/main/resources/notExist.log");

        Exception illegalArgumentException = assertThrows(RuntimeException.class,
                () -> fileReader.read(notExist));

        String expected = notExist.toString() + " does not exist!";
        String result = illegalArgumentException.getMessage();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Can not read file")
    void fileCanNotReadIllegalArgumentException() throws IOException {
        FileReader fileReader = new FileReader();
        File mockFile = Mockito.mock(File.class); //!-WARNING-! -> look here, learn/remember!
        when(mockFile.exists()).thenReturn(true);
        when(mockFile.canRead()).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class,
                () -> fileReader.read(mockFile));

        assertTrue(exception.getMessage().contains("cant read"));
    }

    @Test
    @DisplayName("It's not a file")
    void notFileIllegalArgumentException() throws IOException {

        FileReader fileReader = new FileReader();
        File mockFile = Mockito.mock(File.class);
        when(mockFile.exists()).thenReturn(true);
        when(mockFile.canRead()).thenReturn(true);
        when(mockFile.isFile()).thenReturn(false);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> fileReader.read(mockFile));

        assertTrue(illegalArgumentException.getMessage().contains(" is not a file. (is directory or something else)"));
    }

    @Test
    @DisplayName("Incorrect length")
    void invalidFileLengthIllegalArgumentException() throws IOException {

        FileReader fileReader = new FileReader();
        File incorrectLength = new File("src/main/resources/incorrectLength");

        if (incorrectLength.exists()) {
            incorrectLength.delete();
        }
        incorrectLength.createNewFile();

        String str = "foobar";
        BufferedWriter writer = new BufferedWriter(new FileWriter(incorrectLength, true));

        writer.append(str);
        writer.close();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> fileReader.read(incorrectLength));

        assertTrue(exception.getMessage().contains("length is invalid"));
    }
}

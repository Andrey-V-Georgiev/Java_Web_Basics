package util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HtmlFileReader {
    String readFile(String filePath) throws IOException;
}

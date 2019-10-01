package app.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HtmlFileReader {
    String readHtmlFile(String filePath) throws IOException;
}

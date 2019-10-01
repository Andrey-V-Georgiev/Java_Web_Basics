package app.util;

import java.io.*;
import java.util.StringJoiner;

public class HtmlFileReaderImpl implements HtmlFileReader{
    @Override
    public String readHtmlFile(String filePath) throws IOException {
        StringJoiner sj = new StringJoiner("");
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(filePath))));
        String htmlLine;
        while((htmlLine = bf.readLine()) != null) {
            sj.add(htmlLine);
        }
        return sj.toString().trim();
    }
}

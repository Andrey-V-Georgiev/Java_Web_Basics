package util;

import java.io.*;
import java.util.StringJoiner;

public class HtmlFileReaderImpl implements HtmlFileReader {

    @Override
    public String readFile(String filePath) throws IOException {

        BufferedReader bf = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(filePath))));
        StringJoiner sj = new StringJoiner("");
        String line="";
        while((line=bf.readLine()) != null) {
            sj.add(line);
        }

        return sj.toString().trim();
    }
}

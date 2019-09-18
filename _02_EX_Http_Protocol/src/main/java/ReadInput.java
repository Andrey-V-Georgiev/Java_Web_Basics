import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ReadInput {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static List<String> readValidUrls() throws IOException {
        List<String> validUrls = Arrays.asList(bf.readLine().split("\\s+"));
        return validUrls;
    }

    static List<String> readRequestLine() throws IOException {
        List<String> requestLine = Arrays.asList(bf.readLine().split("\\s+"));
        return requestLine;
    }

    static Map<String, String> readHeaders() throws IOException {
        List<String> headerLines = new ArrayList<>();
        Map<String, String> headers = new LinkedHashMap<>();
        String line = "";
        while ((line = bf.readLine()) != null && line.length() > 0) {
            List<String> pair = Arrays.asList(line.split(": "));
            headers.put(pair.get(0), pair.get(1));
        }
        return headers;
    }

    static String[][] readBody() throws IOException {
        String bodyLine = bf.readLine();
        String[][] matrix = new String[3][2];
        if (bodyLine == null || "".equals(bodyLine)) {
            return null;
        } else {
            String[] pairs = bodyLine.split("&");
            for (int i = 0; i < 3; i++) {
                matrix[i][0] = pairs[i].split("=")[0];
                matrix[i][1] = pairs[i].split("=")[1];
            }
            return matrix;
        }
    }
}

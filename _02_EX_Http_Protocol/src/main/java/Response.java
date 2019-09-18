import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

class Response {

    private List<String> validUrls;
    private List<String> requestLine;
    private Map<String, String> headers;
    private String[][] bodyMatrix;
    private final StringJoiner sj = new StringJoiner("");

    Response(List<String> validUrls, List<String> requestLine,
             Map<String, String> headers, String[][] bodyMatrix) {
        this.validUrls = validUrls;
        this.requestLine = requestLine;
        this.headers = headers;
        this.bodyMatrix = bodyMatrix;
    }

    void produceTextResponse() {
        if ("GET".equals(this.requestLine.get(0))) {
            System.out.println(response_GET());
            return;
        }
        if (this.validUrls.contains(this.requestLine.get(1))) {
            if (!this.headers.containsKey("Authorization")) {
                System.out.println(response_401());
            } else if (this.bodyMatrix == null) {
                System.out.println(response_400());
            } else {
                System.out.println(response_200());
            }
        } else {
            System.out.println(response_404());
        }
    }

    private String response_GET() {
        sj.add(String.format("%s 200 OK\n", this.requestLine.get(2)));
        putResponseHeaders();
        sj.add(String.format("Greetings %s!", decodeUsername()));
        return sj.toString();
    }

    private String response_200() {
        sj.add(String.format("%s 200 OK\n", this.requestLine.get(2)));
        putResponseHeaders();
        sj.add(String
                .format("Greetings %s! You have successfully created %s with %s – %s, %s – %s.\n",
                decodeUsername(), bodyMatrix[0][1], bodyMatrix[1][0],
                bodyMatrix[1][1], bodyMatrix[2][0], bodyMatrix[2][1]));
        return sj.toString();
    }

    private String response_400() {
        sj.add(String.format("%s 400 Bad Request\n", this.requestLine.get(2)));
        putResponseHeaders();
        sj.add("There was an error with the requested functionality due to malformed request.");
        return sj.toString();
    }

    private String response_401() {
        sj.add(String.format("%s 401 Unauthorized\n", this.requestLine.get(2)));
        putResponseHeaders();
        sj.add("You are not authorized to access the requested functionality.");
        return sj.toString();
    }

    private String response_404() {
        sj.add(String.format("%s 404 Not Found\n", this.requestLine.get(2)));
        putResponseHeaders();
        sj.add("The requested functionality was not found.");
        return sj.toString();
    }

    private void putResponseHeaders() {
        if (this.headers.containsKey("Date")) {
            sj.add(String.format("Date: %s\n", this.headers.get("Date")));
        }
        if (this.headers.containsKey("Host")) {
            sj.add(String.format("Host: %s\n", this.headers.get("Host")));
        }
        if (this.headers.containsKey("Content-Type")) {
            sj.add(String.format("Content-Type: %s\n", this.headers.get("Content-Type")));
        }
        sj.add(System.lineSeparator());
    }

    private String decodeUsername() {
        String decryptedString = this.headers.get("Authorization").split("\\s+")[1];
        byte[] byteArray = Base64.getDecoder().decode(decryptedString);
        return new String(byteArray);
    }
}

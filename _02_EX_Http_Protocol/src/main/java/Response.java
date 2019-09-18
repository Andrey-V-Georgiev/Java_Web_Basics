import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

class Response {
    List<String> validUrls;
    List<String> requestLine;
    Map<String, String> headers;
    String[][] bodyMatrix;

     Response(List<String> validUrls, List<String> requestLine,
                    Map<String, String> headers, String[][] bodyMatrix) {
        this.validUrls = validUrls;
        this.requestLine = requestLine;
        this.headers = headers;
        this.bodyMatrix = bodyMatrix;
    }

    public void produceTextResponse() {
        StringJoiner sj = new StringJoiner("");
        String textResponse = "";

        if (this.validUrls.contains(this.requestLine.get(1))) {
              System.out.println(response_200());;
        } else {

        }
    }

    private String response_200() {
        StringJoiner sj = new StringJoiner("");
        sj.add(String.format("%s 200 OK\n", this.requestLine.get(2)));
        if(this.headers.containsKey("Date")){
            sj.add(String.format("Date: %s\n", this.headers.get("Date")));
        }
        if(this.headers.containsKey("Host")){
            sj.add(String.format("Host %s\n", this.headers.get("Host")));
        }
        if(this.headers.containsKey("Content-Type")){
            sj.add(String.format("Content-Type %s\n", this.headers.get("Content-Type")));
        }


        sj.add(String.format("Greetings %s! You have successfully created %s with %s – %s, %s – %s.\n",
                decodeUsername(), bodyMatrix[0][1], bodyMatrix[1][0], bodyMatrix[1][1], bodyMatrix[2][0], bodyMatrix[2][1]));
        return sj.toString();
    }

    private String decodeUsername() {
         String decryptedString = this.headers.get("Authorization").split("\\s+")[1];
         byte[] byteArray = Base64.getDecoder().decode(decryptedString);
         return new String(byteArray);
    }
}

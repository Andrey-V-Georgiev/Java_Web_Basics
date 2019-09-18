import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {

        List<String> validUrls = ReadInput.readValidUrls();
        List<String> requestLine = ReadInput.readRequestLine();
        Map<String, String> headers = ReadInput.readHeaders();
        String[][] bodyMatrix = ReadInput.readBody();

        Response response =  new Response(validUrls, requestLine, headers, bodyMatrix);
        response.produceTextResponse();
    }
}

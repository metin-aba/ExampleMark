import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ApiRequestExample {

    // HTTP POST request
    public static String sendPostRequest(String url, String requestBody) throws Exception {
        // API URL'sini oluştur
        URL apiUrl = new URL(url);
        // HTTP bağlantısını aç
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        // POST request özelliklerini ayarla
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Request body'i bağlantıya yaz
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // HTTP response kodunu al
        int responseCode = connection.getResponseCode();

        // Response body'yi oku
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            // Response detaylarını konsola yazdır
            System.out.println("\nPOST Request:");
            System.out.println("  URL: " + url);
            System.out.println("  Response Code: " + responseCode);
            System.out.println("  Response Body: " + response.toString());

            return response.toString();
        }
    }

    // HTTP GET request
    public static String sendGetRequest(String url) throws Exception {
        // API URL'sini oluştur
        URL apiUrl = new URL(url);
        // HTTP bağlantısını aç
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        // GET request özelliklerini ayarla
        connection.setRequestMethod("GET");

        // HTTP response kodunu al
        int responseCode = connection.getResponseCode();

        // Response body'yi oku
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            // Response detaylarını konsola yazdır
            System.out.println("\nGET Request:");
            System.out.println("  URL: " + url);
            System.out.println("  Response Code: " + responseCode);
            System.out.println("  Response Body: " + response.toString());

            return response.toString();
        }
    }

    public static void main(String[] args) {
        try {
            // Örnek POST request
            String postUrl = "https://jsonplaceholder.typicode.com/posts";
            String postRequestBody = "{\"title\":\"Sample Title\",\"body\":\"Sample Body\",\"userId\":1}";
            String postResponse = sendPostRequest(postUrl, postRequestBody);

            // Örnek GET request
            String getUrl = "https://jsonplaceholder.typicode.com/posts/1";
            String getResponse = sendGetRequest(getUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

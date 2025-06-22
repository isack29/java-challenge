package main;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import io.github.cdimascio.dotenv.Dotenv; // ✅ importar dotenv


public class Converter {

    String url = "https://v6.exchangerate-api.com/v6/";
    private final String key;

    public Converter() {
        Dotenv dotenv = Dotenv.load(); // Carga las variables del archivo .env
        key = dotenv.get("EXCHANGE_API_KEY");

        if (key == null) {
            throw new RuntimeException("❌ La variable EXCHANGE_API_KEY no está definida en el archivo .env");
        }
    }
    public double convert(double amount, String baseCurrency, String targetCurrency) throws IOException, InterruptedException {

        String url2 = "GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT\n";

        String requestUrl = url + key + "/pair/" + baseCurrency + "/" + targetCurrency + "/" + amount;

        double conversionResult = 0;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUrl))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ExchangeResponse exchange = gson.fromJson(response.body(), ExchangeResponse.class);

            System.out.println("Tasa de conversión: " + exchange.getConversion_rate());
            System.out.println("Resultado de conversión: " + exchange.getConversion_result());

            conversionResult =  exchange.getConversion_result();
        } catch (Exception e) {
            e.getMessage();
        }
        return conversionResult;

    }
}

package main;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {

    String url = "https://v6.exchangerate-api.com/v6/";
    String key = "2d26dba6f5cc5845a24e0c63";

    public Converter(){}

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

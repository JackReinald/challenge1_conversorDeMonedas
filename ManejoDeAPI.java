import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ManejoDeAPI {
    // Se encarga de aplicar la lógica de comunicación HTTP cliente servidor

    public ConsultaTasaDeCambio buscaMoneda(String divisa, String divisaObjetivo, Double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/dd25412cc1ff69fc27b18264/pair/"
                + divisa + "/" + divisaObjetivo + "/" + cantidad);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConsultaTasaDeCambio.class);
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Error en la dirección, verifíquela nuevamente.");
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa divisa.");
        }
    }

}

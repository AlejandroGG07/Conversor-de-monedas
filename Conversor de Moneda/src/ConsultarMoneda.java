import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class ConsultarMoneda {
        public Monedas buscarMoneda(String monedaBase, String monedaTarget) {
                URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7b5b1bdee25ea5ffa9420a9c/pair/" + monedaBase + "/" + monedaTarget);

                // Tuve que rear un TrustManager que acepte todos los certificados, ya que no me dejaba iniciar mi codigo
                TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                                public X509Certificate[] getAcceptedIssuers() {
                                        return null;
                                }
                                public void checkClientTrusted(X509Certificate[] certs, String authType) {

                                }
                                public void checkServerTrusted(X509Certificate[] certs, String authType) {

                                }
                        }
                };

                // Inicializar el SSLContext con el TrustManager que acepta todos los certificados
                SSLContext sslContext;
                try {
                        sslContext = SSLContext.getInstance("TLS");
                        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                } catch (Exception e) {
                        throw new RuntimeException("Error al configurar el SSLContext: " + e.getMessage());
                }

                HttpClient client = HttpClient.newBuilder()
                        .sslContext(sslContext)
                        .build();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(direccion)
                        .build();
                try {
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        return new Gson().fromJson(response.body(), Monedas.class);
                } catch (Exception e) {
                        throw new RuntimeException("No encontré esa moneda. " + e.getMessage());
                }
        }
}

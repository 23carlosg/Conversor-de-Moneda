package com.desafio.conversorDeMonedas.servicio;

import com.desafio.conversorDeMonedas.modelo.DatosRatioConversion;
import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsumoApi {
    private static Scanner lectura = new Scanner(System.in);
    private static final String API_KEY = "d059bfc1fd45c856b03e30a5";
    public static DatosRatioConversion consumir(String base, String objetivo) {
        Gson gson = new Gson();
        String url = "https://v6.exchangerate-api.com/v6/"+ API_KEY + "/pair/" + base + "/" + objetivo;

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            DatosRatioConversion drc = gson.fromJson(json, DatosRatioConversion.class);

            return drc;

        }catch (NumberFormatException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la dirección.");
        }catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

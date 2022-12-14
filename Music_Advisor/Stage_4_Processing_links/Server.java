package org.hyperskill.projects.Music_Advisor.Stage_4_Processing_links;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Server {

    public static final String REDIRECT_URI = "http://localhost:8080";
    public static final String CLIENT_ID = "0e65daed4aa543eb9f3a37d20bd511a1";
    public static final String CLIENT_SECRET = "66dd56e9a68d4619ad391e250f78ef55";
    public static String SERVER_PATH = "";
    public static String ACCESS_CODE = "";
    public static String ACCESS_TOKEN = "";





    public void createServer()  {
        if(SERVER_PATH.equals("")) {
            SERVER_PATH = "https://accounts.spotify.com";
        }
        String uri = SERVER_PATH + "/authorize?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=code";
        System.out.println("use this link to request the access code:");
        System.out.println(uri);

        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);
            server.start();
            server.createContext("/",
                    new HttpHandler() {
                        public void handle(HttpExchange exchange) throws IOException {
                            String query = exchange.getRequestURI().getQuery();
                            String requestValue ;
                            if (query != null && query.contains("code")) {
                                ACCESS_CODE = query.substring(5);
                                System.out.println("code received");
                                requestValue = "Got the code. Return back to your program.";
                            } else {
                                requestValue = "Not found authorization code. Try again.";
                            }
                            exchange.sendResponseHeaders(200, requestValue.length());
                            exchange.getResponseBody().write(requestValue.getBytes());
                            exchange.getResponseBody().close();
                        }
                    }
            );
            System.out.println("waiting for code...");
            while (ACCESS_CODE.length() == 0) {
                Thread.sleep(10000);
            }
            server.stop(5);
        } catch (IOException | InterruptedException e) {
            System.out.println("server error");
        }
    }

    public void getToken() {
        System.out.println("making http request for access_token...");
        System.out.println("response:");
        if(SERVER_PATH.equals("")) {
            SERVER_PATH = "https://accounts.spotify.com";
        }
        String postURI = SERVER_PATH + "/api/token";
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(postURI))
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=authorization_code"
                        + "&code=" + ACCESS_CODE
                        + "&client_id=" + CLIENT_ID
                        + "&client_secret=" + CLIENT_SECRET
                        + "&redirect_uri=" + REDIRECT_URI))
                .build();
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            assert response != null;
            ACCESS_TOKEN = response.body();
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Error Response..");
        }

    }
}

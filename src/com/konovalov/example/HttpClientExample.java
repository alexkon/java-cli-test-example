package com.konovalov.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClientExample {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String urlYandex = "https://yandex.ru";
        String gitHubUser = "https://api.github.com/users?since=135";

        String result = run(urlYandex, client);
        System.out.println("Result: " + result);
    }


    public static String run(String url, OkHttpClient client) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }


}

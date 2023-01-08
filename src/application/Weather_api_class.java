package application;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.StringTokenizer;

public class Weather_api_class implements Co_ordinates{

    public static Object[] getInfo(String url) throws URISyntaxException, IOException, InterruptedException {
    	Object objs[];
    	Object tokens[]; 
    	Co_ordinates.coOrdinates coOr = Co_ordinates.coOrdinates.valueOf(coOrdinates.class, url);
    	url = coOr.string;
    	String URL = "https://api.open-meteo.com/v1/forecast?"+url+"&current_weather=true";
//        String url = "https://api.open-meteo.com/v1/forecast?latitude=53.33&longitude=-6.25&current_weather=true";
    	
        HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(new URI(URL))
            .build();

        HttpClient httpClient =  HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(getResponse.statusCode());
//        System.out.println(getResponse.body());
        objs = getResponse.body().split("\"current_weather\":");
        String val = objs[1].toString();
        val = val.replace('{', ' ');
        val = val.replace('}', ' ');
        val = val.trim();
        tokens = val.split("\\:|\\,");
        for(int i=0; i <tokens.length; i++) {
        	System.out.println(tokens[i]);
        }
        return tokens;
    }

}
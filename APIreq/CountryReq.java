package APIreq;

import java.net.http.*;
import java.net.*;
import java.net.http.HttpResponse.BodyHandlers;
import city.City;
import city.Weather;
import org.json.*;

public class CountryReq {
    public CountryReq() {
    }

    public static City getCity(String zip_code, String country_code) {
        String url = "http://api.openweathermap.org/geo/1.0/zip?zip=" + zip_code + "," + country_code + "&appid=" + api_key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response = client.sendAsync(request, BodyHandlers.ofString())
                                            .join();

        String str = response.body();

        JSONObject obj = new JSONObject(str);

        City theCity = new City((String)obj.get("zip"), (String)obj.get("name"), obj.getDouble("lat"), obj.getDouble("lon"), (String)obj.get("country"));

        return theCity;
    }

    public static Weather getWeather(City city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + city.getLatString() + "&lon=" + city.getLonString() + "&appid=" + api_key + "&units=metric";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response = client.sendAsync(request, BodyHandlers.ofString())
                                            .join();

        String str = response.body();

        JSONObject obj = new JSONObject(str);
        JSONObject main = obj.getJSONObject("main");
        JSONArray weather = obj.getJSONArray("weather");
        JSONObject wind = obj.getJSONObject("wind");

        Weather theWeat = new Weather((String)weather.getJSONObject(0).get("main"), (String)weather.getJSONObject(0).get("description"), main.getDouble("temp"), main.getDouble("feels_like"), main.getDouble("humidity"), wind.getDouble("speed"));
        
        return theWeat;
    }

    private static String api_key = "858779e402a691e0b0d194a303e98bd1";
}

package app;

import APIreq.CountryReq;
import city.City;
import city.Weather;

public class App {
    public static void main(String[] args) {
        //CountryReq test = new CountryReq();
        String zip = "69000";
        String country = "FR";

        City Lyon = CountryReq.getCity(zip, country);
        Lyon.print();
        Weather LyonW = CountryReq.getWeather(Lyon);
        LyonW.print();
        }
}

package city;

public class Weather {
    public Weather(String theMain, String theDesc, double theTemp, double theTempFeels, double theHumid, double theWindSpeed) {
        main = theMain;
        description = theDesc;
        temp = theTemp;
        tempFeels = theTempFeels;
        humidity = theHumid;
        windSpeed = theWindSpeed;
    }

    public void print() {
        System.out.println("general : " + main);
        System.out.println("description : " + description);
        System.out.println("temperature : " + temp + "C");
        System.out.println("feels like : " + tempFeels + "C");
        System.out.println("Humidity : " + humidity + "%");
        System.out.println("Wind speed : " + windSpeed + "m/s");
    }

    private String main;
    private String description;
    private double temp;
    private double tempFeels;
    private double humidity;
    private double windSpeed;
}

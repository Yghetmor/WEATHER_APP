package city;

public class City {
    public City(String theZip, String theName, double theLat, double theLon, String theCountry) {
        zip = theZip;
        name = theName;
        lat = theLat;
        lon = theLon;
        country = theCountry;
    }

    public void print() {
        System.out.println("ZIP : " + zip);
        System.out.println("name : " + name);
        System.out.println("latitude : " + lat);
        System.out.println("longitude : " + lon);
        System.out.println("country : " + country);
    }

    public String getLatString() {
        return String.valueOf(lat);
    }

    public String getLonString() {
        return String.valueOf(lon);
    }

    private String zip;
    private String name;
    private double lat;
    private double lon;
    private String country;
}

package app.domain.order;

public class Klant {
    
    private String name;
    private String street;
    private String postalcode;
    private String city;
    private Telefoonnummer telefoonnummer;

    public Klant(String name, String street, String postalcode, String city, Telefoonnummer telefoonnummer) {
        this.name = name;
        this.street = street;
        this.postalcode = postalcode;
        this.city = city;
        this.telefoonnummer = telefoonnummer;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getCity() {
        return city;
    }

    public Telefoonnummer getTelefoonnummer() {
        return telefoonnummer;
    }
    
    
}

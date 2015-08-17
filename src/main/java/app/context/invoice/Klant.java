package app.context.invoice;

/**
 * Created by marc on 03/08/15.
 */
public class Klant {
    
    private String naam;

    public Klant(String naam) {
        super();
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

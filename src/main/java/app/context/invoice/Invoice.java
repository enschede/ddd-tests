package app.context.invoice;

import app.context.Entity;

/**
 * Created by marc on 03/08/15.
 */
public class Invoice extends Entity {
    
    private Klant klant;

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }
}

package app.domain.order;

/**
 * Created by marc on 31/07/15.
 */
public class Telefoonnummer {
    
    private String nummer;

    public Telefoonnummer(String nummer) {
        this.nummer = nummer;
    }

    public String getNummer() {
        return nummer;
    }

    private void setNummer(String nummer) {
        this.nummer = nummer;
    }
}

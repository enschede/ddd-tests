package app.domain.order;

public class OrderRegel {
    
    private String omschrijving;
    private Bedrag bedrag;

    public OrderRegel(String omschrijving, Bedrag bedrag) {
        this.omschrijving = omschrijving;
        this.bedrag = bedrag;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    private void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Bedrag getBedrag() {
        return bedrag;
    }

    private void setBedrag(Bedrag bedrag) {
        this.bedrag = bedrag;
    }
}

package app.context.order;

import app.context.order.valueobjects.Bedrag;

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

    @Override
    public String toString() {
        return "OrderRegel{" +
                "omschrijving='" + omschrijving + '\'' +
                ", bedrag=" + bedrag +
                '}';
    }
}

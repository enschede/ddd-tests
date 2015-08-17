package app.context.order;

public class Telefoonnummer {
    
    private String nummer;

    public Telefoonnummer(String nummer) {
        this.nummer = nummer;
    }

    public String getNummer() {
        return nummer;
    }

    @Override
    public String toString() {
        return "Telefoonnummer{" +
                "nummer='" + nummer + '\'' +
                '}';
    }
}

package app.domainevents.offer;

import app.context.order.valueobjects.Klant;
import app.domainevents.DomainEvent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateOrderDomainEvent extends DomainEvent {
    
    public class Line {
        public String description;
        public BigDecimal price;

        public Line(String description, BigDecimal price) {
            this.description = description;
            this.price = price;
        }
    }
    
    private Klant klant;
    private List<Line> lines = new ArrayList<>();
    
    public CreateOrderDomainEvent(Offer offer) {
        final List<String> stdcolor = Arrays.asList("9001", "5200", "8200");

        klant = new Klant(offer.getNaam(), offer.getAdres(), offer.getPostcode(), offer.getPlaats(), null);

        if(offer.getMetLaadstation()) {
            switch (offer.getType()) {
                case "STD":
                    lines.add(new Line("LILO std", new BigDecimal("999.00")));
                    break;

                case "STD4":
                    lines.add(new Line("LILO std met 4 meter kabel", new BigDecimal("1099.00")));
                    break;

                case "STD8":
                    lines.add(new Line("LILO std met 8 meter kabel", new BigDecimal("1199.00")));
                    break;

                case "STD+4":
                    lines.add(new Line("LILO std", new BigDecimal("999.00")));
                    lines.add(new Line("4 meter kabel", new BigDecimal("100.00")));
                    break;

                case "STD+8":
                    lines.add(new Line("LILO std", new BigDecimal("999.00")));
                    lines.add(new Line("8 meter kabel", new BigDecimal("200.00")));
                    break;
            }
            
            if(!stdcolor.contains(offer.getKleur())) {
                lines.add(new Line("Meerwerk bijzondere kleur", new BigDecimal("40.00")));
            }

            if(offer.getInstalliewerk()) {
                lines.add(new Line("Installatiewerk", new BigDecimal("400.00")));
            }

            lines.add(new Line("Jaarabonnement pas", new BigDecimal("140.00")));
            lines.add(new Line("Voorschot std verbruik", new BigDecimal("50.00")));
        }
    }

    public Klant getKlant() {
        return klant;
    }

    public List<Line> getLines() {
        return lines;
    }
}

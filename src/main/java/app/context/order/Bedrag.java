package app.context.order;

import java.math.BigDecimal;

public class Bedrag {
    
    private BigDecimal bedrag;

    public Bedrag(BigDecimal bedrag) {
        this.bedrag = bedrag;
    }

    public BigDecimal getBedrag() {
        return bedrag;
    }

    @Override
    public String toString() {
        return "Bedrag{" +
                "bedrag=" + bedrag +
                '}';
    }
}

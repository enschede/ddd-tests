package app.domain.order;

import java.math.BigDecimal;

public class Bedrag {
    
    private BigDecimal bedrag;

    public Bedrag(BigDecimal bedrag) {
        this.bedrag = bedrag;
    }

    public BigDecimal getBedrag() {
        return bedrag;
    }

    private void setBedrag(BigDecimal bedrag) {
        this.bedrag = bedrag;
    }
}

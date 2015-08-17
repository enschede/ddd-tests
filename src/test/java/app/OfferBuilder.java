package app;

import app.domainevents.offer.Offer;

/**
 * Created by marc on 03/08/15.
 */
public class OfferBuilder {

    private Boolean metLaadstation;
    private String type;
    private String kleur;
    private Boolean installiewerk;
    private String naam;
    private String adres;
    private String postcode;
    private String plaats;

    public OfferBuilder setMetLaadstation(Boolean metLaadstation) {
        this.metLaadstation = metLaadstation;
        return this;
    }

    public OfferBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public OfferBuilder setKleur(String kleur) {
        this.kleur = kleur;
        return this;
    }

    public OfferBuilder setInstalliewerk(Boolean installiewerk) {
        this.installiewerk = installiewerk;
        return this;
    }

    public OfferBuilder setNaam(String naam) {
        this.naam = naam;
        return this;
    }

    public OfferBuilder setAdres(String adres) {
        this.adres = adres;
        return this;
    }

    public OfferBuilder setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public OfferBuilder setPlaats(String plaats) {
        this.plaats = plaats;
        return this;
    }

    public Offer build() {
        Offer offer = new Offer();

        offer.setMetLaadstation(metLaadstation);
        offer.setType(type);
        offer.setKleur(kleur);
        offer.setInstalliewerk(installiewerk);
        offer.setNaam(naam);
        offer.setAdres(adres);
        offer.setPostcode(postcode);
        offer.setPlaats(plaats);        

        return offer;
    }

    public static OfferBuilder newInstance() {
        return new OfferBuilder();
    }

}

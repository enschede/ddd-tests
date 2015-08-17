package app.domainevents.offer;

/**
 * Created by marc on 02/08/15.
 */
public class Offer {
    
    private Boolean metLaadstation ;
    private String type;
    private String kleur;
    private Boolean installiewerk;
    private String naam;
    private String adres;
    private String postcode;
    private String plaats;

    public Boolean getMetLaadstation() {
        return metLaadstation;
    }

    public void setMetLaadstation(Boolean metLaadstation) {
        this.metLaadstation = metLaadstation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public Boolean getInstalliewerk() {
        return installiewerk;
    }

    public void setInstalliewerk(Boolean installiewerk) {
        this.installiewerk = installiewerk;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }
}

package vikob3tp4.Entities;

import javax.persistence.*;

@Embeddable
public class Adresse {

    @Column(name="NUMERO",length = 255,nullable = false)
    private Integer numero;

    @Column(name = "RUE", length = 255, nullable = false)
    private String rue;

    @Column(name = "CODEPOSTAL", length = 255, nullable = false)
    private Integer codePostal;

    @Column(name = "VILLE", length = 255, nullable = false)
    private String ville;

    public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Adresse() {

    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}

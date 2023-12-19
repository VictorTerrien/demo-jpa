package vikob3tp4.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VIREMENT")
@DiscriminatorValue("Virement")
public class Virement extends Operation {

    @Column(name="BENEFICIAIRE",length = 255,nullable = true)
    private String beneficiaire;

    public Virement(LocalDateTime date, Double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Virement() {

    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}

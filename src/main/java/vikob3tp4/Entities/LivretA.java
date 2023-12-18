package vikob3tp4.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LIVRETA")
public class LivretA extends Compte {

    @Column(name="TAUX",length = 255,nullable = false)
    private Double taux;

    public LivretA(String numero, Double solde, Set<Client> clients, Double taux) {
        super(numero, solde, clients);
        this.taux = taux;
    }

    public LivretA(Double taux) {
        this.taux = taux;
    }

    public LivretA() {

    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}

package vikob3tp4.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "ASSURANCEVIE")
public class AssuranceVie extends Compte {

    @Column(name="DATEFIN",length = 255,nullable = false)
    private LocalDate dateFin;

    @Column(name="TAUX",length = 255,nullable = false)
    private Double taux;

    public AssuranceVie(String numero, Double solde, Set<Client> clients, LocalDate dateFin, Double taux) {
        super(numero, solde, clients);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie(LocalDate dateFin, Double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie() {

    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}

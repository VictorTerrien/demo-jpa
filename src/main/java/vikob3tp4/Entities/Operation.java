package vikob3tp4.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "OPERATION")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="DATE",length = 255,nullable = false)
    private LocalDateTime date;

    @Column(name = "MONTANT", length = 255, nullable = false)
    private Double montant;

    @Column(name = "MOTIF", length = 255, nullable = false)
    private String motif;

    @ManyToOne
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

    public Operation(LocalDateTime date, Double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    public Operation() {

    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}

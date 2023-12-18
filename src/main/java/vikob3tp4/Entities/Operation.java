package vikob3tp4.Entities;

import vikob3.Entities.Client;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "OPERATIONCOMPTE",
            joinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID")
    )
    private Set<Compte> comptes;

    public Operation(LocalDateTime date, Double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
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

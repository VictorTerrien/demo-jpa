package vikob3tp4.Entities;

import vikob3.Entities.Livre;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NOM",length = 255,nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 255, nullable = false)
    private String prenom;

    @Column(name = "DATENAISSANCE", length = 255, nullable = false)
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;

    @ManyToMany(mappedBy = "clients")
    private Set<Compte> comptes;

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}

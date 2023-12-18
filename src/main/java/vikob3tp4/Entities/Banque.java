package vikob3tp4.Entities;

import vikob3.Entities.Client;
import vikob3.Entities.Emprunt;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NOM",length = 255,nullable = false)
    private String nom;

    @OneToMany(mappedBy = "banque")
    private Set<Client> clients;

    public Banque(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

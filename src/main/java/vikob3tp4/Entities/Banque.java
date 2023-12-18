package vikob3tp4.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BANQUE")
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

    public Banque() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

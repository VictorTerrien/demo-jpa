package vikob3.Entities;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LIVRE")
public class Livre {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITRE", length = 255, nullable = false)
    private String titre;

    @Column(name = "AUTEUR", length = 50, nullable = false)
    private String auteur;

    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
    )
    private Set<Emprunt> emprunts;

    @Override
    public String toString() {
        return String.format("{ id: %s, titre: %s, auteur: %s }", this.id, this.titre, this.auteur);
    }

    public Livre() {}

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(int id,String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return titre + ", " + auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

}

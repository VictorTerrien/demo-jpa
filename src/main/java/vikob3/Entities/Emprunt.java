package vikob3.Entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE_DEBUT", length = 255,  nullable = false)
    private Date date_debut;

    @Column(name = "DATE_FIN", length = 255, nullable = true)
    private Date date_fin;

    @Column(name = "DELAI", length = 255, nullable = true)
    private Integer delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany(mappedBy = "emprunts")
    private Set<Livre> livres;

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + date_debut +
                ", dateFin=" + date_fin +
                ", delai=" + delai +
                ", livres=" + livres +
                '}';
    }

    public Emprunt() {
    }

    public Emprunt(Date dateDebut, Date dateFin, int delai, int clientId) {
        this.date_debut = dateDebut;
        this.date_fin = dateFin;
        this.delai = delai;
    }

    public Emprunt(int id, Date dateDebut, Date dateFin, int delai, int clientId) {
        this.id = id;
        this.date_debut = dateDebut;
        this.date_fin = dateFin;
        this.delai = delai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return date_debut;
    }

    public void setDateDebut(Date dateDebut) {
        this.date_debut = dateDebut;
    }

    public Date getDateFin() {
        return date_fin;
    }

    public void setDateFin(Date dateFin) {
        this.date_fin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }
}


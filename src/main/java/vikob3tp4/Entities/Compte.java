package vikob3tp4.Entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COMPTE")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NUMERO",length = 255,nullable = false)
    private String numero;

    @Column(name = "SOLDE", length = 255, nullable = false)
    private Double solde;

    @ManyToMany
    @JoinTable(name = "COMPTECLIENT",
            joinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID")
    )
    private Set<Client> clients;

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    public Compte(String numero, Double solde, Set<Client> clients) {
        this.numero = numero;
        this.solde = solde;
        this.clients = clients;
    }

    public Compte() {

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
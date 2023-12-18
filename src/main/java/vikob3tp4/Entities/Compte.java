package vikob3tp4.Entities;

import vikob3.Entities.Client;
import vikob3.Entities.Emprunt;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(mappedBy = "comptes")
    private Set<Operation> operations;

    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
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
package AppliBancaire;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "numero")
    private String numero;
    @Column(name = "solde")
    private double solde;
    @OneToMany(
            mappedBy = "compte", // Le nom de l'attribut dans la classe Emprunt qui a le @ManyToOne
            cascade = CascadeType.ALL, // Optionnel : pour cascader les opérations (persist, remove)
            fetch = FetchType.LAZY // Optionnel : chargement différé par défaut, meilleur pour la performance
    )
    private Set<Operation>operations;
    @ManyToMany(mappedBy = "comptes",cascade = CascadeType.PERSIST)
    private Set<Client> clients;

    public Compte() {}

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}

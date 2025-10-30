package AppliBancaire;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Banque")
public class Banque implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nom")
    private String nom;
    @OneToMany(
            mappedBy = "banque", // Le nom de l'attribut dans la classe Emprunt qui a le @ManyToOne
            cascade = CascadeType.ALL, // Optionnel : pour cascader les opérations (persist, remove)
            fetch = FetchType.LAZY // Optionnel : chargement différé par défaut, meilleur pour la performance
    )
    private Set<Client> clients;

    public Banque() {}
    public Banque(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}

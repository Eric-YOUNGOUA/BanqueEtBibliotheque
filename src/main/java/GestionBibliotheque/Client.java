package GestionBibliotheque;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @OneToMany(
            mappedBy = "idClient", // Le nom de l'attribut dans la classe Emprunt qui a le @ManyToOne
            cascade = CascadeType.ALL, // Optionnel : pour cascader les opérations (persist, remove)
            fetch = FetchType.LAZY // Optionnel : chargement différé par défaut, meilleur pour la performance
    )
    private Set<Emprunt> emprunts;

    {
        emprunts = new HashSet<Emprunt>();
    }

    public Client() {}
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Emprunt emprunts) {
        this.emprunts.add(emprunts);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

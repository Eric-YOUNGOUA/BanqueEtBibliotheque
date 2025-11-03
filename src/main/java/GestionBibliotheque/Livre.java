package GestionBibliotheque;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "livre")
public class Livre implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "TITRE")
    private String nom;
    @Column(name = "AUTEUR")
    private String auteur;
    @ManyToMany(mappedBy = "livre",cascade =CascadeType.ALL)
    private Set<Emprunt> emprunt;

    {
        emprunt = new HashSet<Emprunt>();
    }

    public Livre() {
    }
    public Livre(String nom, String auteur) {
        this.nom = nom;
        this.auteur = auteur;
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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur( String auteur){
        this.auteur = auteur;
    }

    public Set<Emprunt> getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Set<Emprunt> emprunt) {
        this.emprunt = emprunt;
    }

    @Override
    public String toString() {
        return "livre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", auteur=" + auteur +
                '}';
    }
}

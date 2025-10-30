package AppliBancaire;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "dateNaissance")
    private LocalDate dateNaissance;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name = "nomBanque", nullable = false)
    private Banque banque;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "idClient"),
            inverseJoinColumns = @JoinColumn(name = "idCompte"))
    private Set<Compte> comptes;

    public Client() {}
    public Client(String nom, String prenom, LocalDate dateNaissance,Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}

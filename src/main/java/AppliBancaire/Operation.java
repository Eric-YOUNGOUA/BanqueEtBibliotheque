package AppliBancaire;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "montant")
    private Double montant;
    @Column(name = "motif")
    private String motif;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "NumeroCompte", nullable = false)
    private Compte compte;

    public Operation() {}

    public Operation(LocalDateTime date, Double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                ", date=" + getDate() +
                ", montant=" + getMontant() +
                ", motif='" + getMotif()     + '\'' +
                ", compte=" + getCompte() +
                '}';
    }
}

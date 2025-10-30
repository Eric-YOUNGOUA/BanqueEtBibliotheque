package AppliBancaire;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Operation")
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
    @ManyToOne
    @JoinColumn(name = "NumeroCompte", nullable = false)
    private Compte compte;

    public Operation() {}
    public Operation(LocalDateTime date, Double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
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
}

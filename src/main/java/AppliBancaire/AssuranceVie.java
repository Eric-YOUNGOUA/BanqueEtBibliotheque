package AppliBancaire;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "AssuranceVie")
public class AssuranceVie extends Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numero")
    private String numero;
    @Column(name = "solde")
    private double solde;
    @Column(name = "dateFin")
    private LocalDate dateFin;
    @Column(name = "taux")
    private double taux;
    public AssuranceVie(){}
    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero,solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                "numero='" + numero + '\'' +
                ", solde=" + solde +
                ", dateFin=" + dateFin +
                ", taux=" + taux +
                '}';
    }
}

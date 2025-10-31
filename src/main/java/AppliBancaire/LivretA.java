package AppliBancaire;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "LivretA")
public class LivretA extends Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numero")
    private String numero;
    @Column(name = "solde")
    private double solde;
    @Column(name = "taux")
    private double taux;

    public LivretA() {}
    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "numero='" + numero + '\'' +
                ", solde=" + solde +
                ", taux=" + taux +
                '}';
    }
}

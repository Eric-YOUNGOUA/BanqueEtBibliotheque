package AppliBancaire;

import java.io.Serializable;

public class LivretA extends Compte implements Serializable {
    private String numero;
    private double solde;
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

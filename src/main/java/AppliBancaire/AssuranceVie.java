package AppliBancaire;

import java.io.Serializable;
import java.time.LocalDate;

public class AssuranceVie extends Compte implements Serializable {
    private String numero;
    private double solde;
    private LocalDate dateFin;
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

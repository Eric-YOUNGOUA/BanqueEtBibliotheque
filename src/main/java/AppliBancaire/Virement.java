package AppliBancaire;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Virement extends Operation{
    private LocalDateTime date;
    private double montant;
    private String motif;
    private String beneficiare;

    public Virement(){}
    public Virement(LocalDateTime date, double montant, String motif, String beneficiare){
        super(date,montant,motif);
        this.beneficiare = beneficiare;
    }

    public String getBeneficiare() {
        return beneficiare;
    }

    public void setBeneficiare(String beneficiare) {
        this.beneficiare = beneficiare;
    }

    @Override
    public String toString() {
        return "Virement{" +
                "date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", beneficiare='" + beneficiare + '\'' +
                '}';
    }
}

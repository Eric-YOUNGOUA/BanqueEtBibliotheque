package AppliBancaire;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class Virement extends Operation{
    @Column(name = "beneficiare")
    private String beneficiare;

    public Virement(){}
    public Virement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiare) {
        super(date,montant,motif,compte);
        this.beneficiare = beneficiare;
    }

    public String getBeneficiare() {
        return beneficiare;
    }

    public void setBeneficiare(String beneficiare) {
        this.beneficiare = beneficiare;
    }

    @Override
    public String toString(){
        return "Virement {"+
                "date ="+this.getDate()+
                ", montant ="+this.getMontant()+
                ", motif="+this.getMotif()+
                ", compte="+this.getCompte()+
                ", beneficiare ="+this.getBeneficiare()+
                "}";
    }
}

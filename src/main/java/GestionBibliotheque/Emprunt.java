package GestionBibliotheque;

import jakarta.persistence.*;
import org.hibernate.boot.models.annotations.spi.ColumnDetails;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "emprunt")
public class Emprunt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "DATE_DEBUT")
    private Date dateDebut;
    @Column(name = "DATE_FIN")
    private Date dateFin;
    @Column(name = "DELAI")
    private int delai;
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client idClient;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV"))
    private Set<Livre> livre;

    {
        livre = new HashSet<Livre>();
    }

    public Emprunt() {}

    public Emprunt(Date dateDebut, Date dateFin, int delai) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
    }

    public int getId() {
        return id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getIdClient() {
        return idClient;
    }


    public Set<Livre> getLivre() {
        return livre;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", delai=" + delai +
                '}';
    }
}

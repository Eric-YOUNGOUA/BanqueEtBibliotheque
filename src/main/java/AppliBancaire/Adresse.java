package AppliBancaire;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    private int numero;
    private String rue;
    private int codePostal;
    private String ville;

    public Adresse() {}

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public int getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String toString() {
        return getNumero() + " " + getRue() + ", " + getCodePostal() + ", " + getVille();
    }
}

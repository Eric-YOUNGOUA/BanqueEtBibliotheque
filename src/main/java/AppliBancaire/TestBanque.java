package AppliBancaire;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestBanque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Compte compte = new Compte("AFTYZ",17298373);
        em.persist(compte);
        em.getTransaction().commit();
    }
}

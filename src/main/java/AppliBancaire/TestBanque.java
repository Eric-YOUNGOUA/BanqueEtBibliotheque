package AppliBancaire;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestBanque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        LivretA art = new LivretA("123",100.0,200.0);
        em.persist(art);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Adresse SciBerete=new Adresse(8,"rue d'Osnabruck",49100,"Angers");
        System.out.println("\n\n\nAdresse: "+SciBerete.toString()+"\n\n\n");
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

package GestionBibliotheque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import static java.lang.System.in;

public class TestBibliotheque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");
        EntityManager em = emf.createEntityManager();

//        System.out.println("\nextraire un emprunt et tous ses livres associés \n");
//            em.getTransaction().begin();
//            Emprunt emprunt=em.find(Emprunt.class, 1);
//            Set<Livre>livres=emprunt.getLivre();
//            for (Livre livre : livres) {
//                System.out.println(livre.toString());
//            }
//            em.getTransaction().commit();

//        System.out.println("\n extraire tous les emprunts d'un client donné \n");
//            em.getTransaction().begin();
//            Client client=em.find(Client.class, 3);
//            Set<Emprunt> emprunts=client.getEmprunts();
//            for (Emprunt emprunt1 : emprunts) {
//                System.out.println(emprunt1.toString());
//            }
//            em.getTransaction().commit();

//            em.getTransaction().begin();
//            Livre livre = new Livre("Le prince","Machiavel");
//            em.persist(livre);
//            em.getTransaction().commit();

            em.getTransaction().begin();
            Emprunt emprunt1 = new Emprunt(LocalDate.now(),LocalDate.now().plusDays(15),15);
            em.persist(emprunt1);
            em.getTransaction().commit();
        System.out.println("Creer une nouvelle association");
            em.getTransaction().begin();
            Client client = new Client("Mike","Dayawa");
            em.persist(client);
            em.getTransaction().commit();
        System.out.println("Creer une nouvelle association");



        em.close();
        emf.close();


    }
}

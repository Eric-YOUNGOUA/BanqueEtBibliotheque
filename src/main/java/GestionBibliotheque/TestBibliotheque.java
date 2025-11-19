package GestionBibliotheque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TestBibliotheque {
    static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");
        EntityManager em = emf.createEntityManager();

//        System.out.println("\nextraire un emprunt et tous ses livres associés \n");
//            Emprunt emprunt=em.find(Emprunt.class, 6);
//            Set<Livre>livres=emprunt.getLivre();
//            for (Livre livre : livres) {
//                System.out.println(livre.toString());
//            }

//        System.out.println("\n extraire tous les emprunts d'un client donné \n");
//            Client client=em.find(Client.class, 3);
//            Set<Emprunt> emprunts=client.getEmprunts();
//            for (Emprunt emprunt1 : emprunts) {
//                System.out.println(emprunt1.toString());
//            }

//         System.out.println("Creer un client, un emprunt et des livres et faire leurs associations");
//            em.getTransaction().begin();
//
//            Client client = new Client("Mike","Dayawa");
//            Livre livre = new Livre("La mort heureuse","Albert Camus") ;
//            Livre livre2 = new Livre("Atteindre l'excellence","Robert Greene") ;
//            Emprunt emprunt1 = new Emprunt(LocalDate.now(),LocalDate.now().plusDays(15),15,client);
//            emprunt1.setLivre(Set.of(livre,livre2));
//            livre.setEmprunt(Set.of(emprunt1));
//            livre2.setEmprunt(Set.of(emprunt1));
//            client.setEmprunts(Set.of(emprunt1));
//            em.persist(client);
//
//            em.getTransaction().commit();

//            System.out.println("Récuperer la liste de tous les livres");
//            Query query = em.createQuery("select l from Livre l where  l.auteur='Robert Greene'", Livre.class);
//            List<Livre> livres = query.getResultList();
//            for(Livre l : livres){
//                System.out.println(l.toString());
//            }


        em.close();
        emf.close();


    }
}

package AppliBancaire;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TestBanque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        /*em.getTransaction().begin();
        Adresse SciBerete=new Adresse(8,"rue d'Osnabruck",49100,"Angers");
        System.out.println("\n\n\nAdresse: "+SciBerete.toString()+"\n\n\n");
        Banque sg=new Banque("Societe Generale");
        Client mike=new Client("Dayawa","Mike", LocalDate.now().minusYears(21),SciBerete,sg);

        em.persist(mike);
        em.getTransaction().commit();*/

//Insérer un compte associé à 2 clients

        em.getTransaction().begin();
        Banque banque = new Banque("Crédit Marcel");

        Adresse adr1 = new Adresse(1, "rue A", 49000, "France");
        Adresse adr2 = new Adresse(2, "rue B", 49000, "France");

        Client client1 = new Client("Youngoua", "Marcel",LocalDate.now(), adr1, banque);
        Client client2 = new Client("Doe", "John",LocalDate.now().plusMonths(13), adr2, banque);

        Compte compte = new Compte("CPT001", 1500.0);
        compte.setClients(Set.of(client1, client2));

        client1.setComptes(Set.of(compte));
        client2.setComptes(Set.of(compte));

        em.persist(client1);
        em.persist(client2);

        em.getTransaction().commit();

//Insérer un client avec plusieurs comptes : LivretA et AssuranceVie

        em.getTransaction().begin();

        Adresse adr3 = new Adresse(3, "rue C", 49000, "France");
        Client client3 = new Client("Dupont", "Alice",LocalDate.now().minusYears(2), adr3, banque);

        LivretA livretA = new LivretA("LIV001", 2000.0, 1.5);
        AssuranceVie assuranceVie = new AssuranceVie("ASS001", 5000.0,LocalDate.now(), 2.0);

        livretA.setClients(Set.of(client3));
        assuranceVie.setClients(Set.of(client3));
        client3.setComptes(Set.of(livretA, assuranceVie));

        em.persist(client3);
        em.persist(livretA);
        em.persist(assuranceVie);

        em.getTransaction().commit();

//Insérer des opérations de type Virement sur un compte


        em.getTransaction().begin();

        Virement virement1 = new Virement(LocalDateTime.now().plusWeeks(2).plusSeconds(9), 300.0, "Virement vers LivretA", compte, "LIV001");
        Virement virement2 = new Virement(LocalDateTime.now().minusHours(7), 150.0, "Virement vers AssuranceVie", compte, "ASS001");

        em.persist(virement1);
        em.persist(virement2);

        em.getTransaction().commit();

//Insérer des opérations classiques sur un compte


        em.getTransaction().begin();

        Operation op1 = new Operation(LocalDateTime.now(), 50.0, "Retrait DAB", compte);
        Operation op2 = new Operation(LocalDateTime.now(), 100.0, "Paiement CB", compte);

        em.persist(op1);
        em.persist(op2);

        em.getTransaction().commit();






        em.close();
        emf.close();
    }
}

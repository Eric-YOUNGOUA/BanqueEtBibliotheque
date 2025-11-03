package AppliBancaire;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TestBanque {
    static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Adresse SciBerete=new Adresse(8,"rue d'Osnabruck",49100,"Angers");
        System.out.println("\n\n\nAdresse: "+SciBerete+"\n\n\n");
        Banque sg=new Banque("Societe Generale");
        Client mike=new Client("Dayawa","Mike", LocalDate.now().minusYears(21),SciBerete,sg);
        Compte mikeCompte=new Compte("CPT000",15000);
        mikeCompte.setClients(Set.of(mike));
        mike.setComptes(Set.of(mikeCompte));

        em.persist(mike);
        em.getTransaction().commit();

//Insérer un compte associé à 2 clients

        em.getTransaction().begin();
        Banque banque = new Banque("Crédit Mutuel");

        Adresse adr1 = new Adresse(1, "rue A", 49000, "Angers");
        Adresse adr2 = new Adresse(2, "rue B", 49240, "Avrillé");

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

        Adresse adr3 = new Adresse(3, "rue C", 49124, "St-Barthelemy d'Anjou");
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

        Virement virement1 = new Virement(LocalDateTime.now().plusWeeks(2).plusSeconds(9), 3000.0, "Virement vers LivretA", compte, "LIV001");
        Virement virement2 = new Virement(LocalDateTime.now().minusHours(7), 150.0, "Virement vers AssuranceVie", compte, "ASS001");

        em.persist(virement1);
        em.persist(virement2);

        em.getTransaction().commit();

//Insérer des opérations classiques sur un compte


        em.getTransaction().begin();

        Operation op1 = new Operation(LocalDateTime.now(), 5000.0, "Retrait DAB", compte);
        Operation op2 = new Operation(LocalDateTime.now(), 100.0, "Paiement CB", compte);

        em.persist(op1);
        em.persist(op2);

        em.getTransaction().commit();

//Afficher tous les comptes d'une personne donnée :
        System.out.println("\n\n\n\nAfficher tous les comptes d'une personne donnée:");
        TypedQuery<Compte> query = em.createQuery(
                "SELECT c FROM Compte c JOIN c.clients cl WHERE cl.nom = :nom AND cl.prenom = :prenom", Compte.class);
        query.setParameter("nom", "Dupont");
        query.setParameter("prenom", "Alice");
        List<Compte> comptes = query.getResultList();
        for (Compte c : comptes) {
            System.out.println(c.toString());
        }

//Rechercher tous les comptes pour une banque donnée :
        System.out.println("\n\n\n\nRechercher tous les comptes pour une banque donnée");
        TypedQuery<Compte> query1=em.createQuery("select c from Compte c JOIN c.clients cl where cl.banque.nom=:nom", Compte.class);
        query1.setParameter("nom", "Credit Mutuel");
        List<Compte> comptes1=query1.getResultList();
        for (Compte c : comptes1) {
            System.out.println(c.toString());
        }

//Rechercher tous les comptes ayant une opération de plus de 1000€ :
        System.out.println("\n\n\n\nRechercher tous les comptes ayant une opération de plus de 1000€");
        TypedQuery<Compte> query2= em.createQuery("select distinct c from Compte c JOIN c.operations co where co.montant>1000.0",Compte.class);
        List<Compte> comptes2=query2.getResultList();
        for (Compte c : comptes2) {
            System.out.println(c.toString());
        }

//Rechercher tous les comptes qui ont au moins une opération :
        System.out.println("\n\n\n\nRechercher tous les comptes qui ont au moins une opération");
        TypedQuery<Compte> query3=em.createQuery("select distinct c from Compte c join c.operations co",Compte.class);
        List<Compte> comptes3=query3.getResultList();
        for (Compte c : comptes3) {
            System.out.println(c.toString());
        }

        em.close();
        emf.close();
    }
}

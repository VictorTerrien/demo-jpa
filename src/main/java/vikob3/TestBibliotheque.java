package vikob3;

import vikob3.Entities.Client;
import vikob3.Entities.Emprunt;
import vikob3.Entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestBibliotheque {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager em = emf.createEntityManager();

        Emprunt h2 = em.find(Emprunt.class, 1);
        System.out.println(h2.toString());

        Client client = em.find(Client.class, 1);
        System.out.println(client.toString());


        em.close();
        emf.close();
    }
}
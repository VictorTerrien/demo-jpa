package vikob3;

import vikob3.Entities.Livre;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        System.out.println(emf);
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        // SELECT
        Livre l = em.find(Livre.class, 2);
        if (l!=null) {
            System.out.println(l.getInfo());
        }

        // INSERT
        /*Livre l2 = new Livre("Votre", "Choix");
        em.persist(l2);
        System.out.println(l2.getId());*/

        // MODIF
        Livre l3 = em.find(Livre.class, 5);
        if (l3!=null) {
            l3.setTitre("Du plaisir dans la cuisine");
        }
        em.merge(l3);

        // SELECT WITH SPECIAL SPECIFICITY
        TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre='Votre'", Livre.class);
        Livre l4 = query.getResultList().get(0);
        System.out.println(l4.getInfo());
        TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.auteur='Choix'", Livre.class);
        Livre l5 = query2.getResultList().get(0);
        System.out.println(l5.getInfo());

        // REMOVE
        /*Livre l6 = em.find(Livre.class, 10);
        if (l6 != null) {
            em.remove(l6);
        }*/

        // SELECT ALL
        Query queryAll = em.createQuery("select l from Livre l");
        List<Livre> listBook = queryAll.getResultList();
        System.out.println("Liste de tous les livres :");
        for (Livre li : listBook) {
            System.out.println(li.getInfo());
        }

        et.commit();
        em.close();
        emf.close();
    }
}
package vikob3tp4;

import vikob3tp4.Entities.Adresse;
import vikob3tp4.Entities.Banque;
import vikob3tp4.Entities.Client;
import vikob3tp4.Entities.Compte;

import javax.persistence.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        /*EntityTransaction et = em.getTransaction();
        et.begin();

        Adresse adr = new Adresse(4,"chemin des Avettes", 44240, "La Chapelle sur Erdre");
        Banque ban = new Banque("VikoBanque");
        em.persist(ban);

        Client cli = new Client( "Terrien", "Victor", LocalDate.now(), adr, b);
        em.persist(cli);
        // System.out.println(c.getId());


        Compte com = new Compte("uihisbfuh", 12000.00);
        em.persist(com);*/


        em.close();
        emf.close();
    }
}
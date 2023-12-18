package vikob3tp4;

import vikob3tp4.Entities.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Adresse adr = new Adresse(4,"chemin des Avettes", 44240, "La Chapelle sur Erdre");
        Banque ban = new Banque("VikoBanque");
        em.persist(ban);

        Client cli = new Client( "Terrien", "Victor", LocalDate.now(), adr, ban);
        em.persist(cli);

        Compte com = new Compte("uihisbfuh", 12000.00, Set.of(cli));
        em.persist(com);

        Operation ope = new Operation(LocalDateTime.now(), 120.00, "virement check", com);
        em.persist(ope);

        Adresse adr2 = new Adresse(8,"rue des P", 44000, "Nantes");
        Client cli2 = new Client("Ab", "Cd", LocalDate.now(), adr2, ban);
        em.persist(cli2);


        et.commit();

        em.close();
        emf.close();
    }
}
package vikob3tp4;

import vikob3tp4.Entities.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
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

        Adresse adr2 = new Adresse(8,"rue des P", 44000, "Nantes");
        Client cli2 = new Client("Ab", "Cd", LocalDate.now(), adr2, ban);
        em.persist(cli2);

        Set<Client> clients = new HashSet<>();
        clients.add(cli);
        clients.add(cli2);

        Compte com = new Compte("uihisbfuh", 12000.00, clients);
        em.persist(com);

        LivretA lva = new LivretA("hajgni", 1500.00, Set.of(cli),10.00);
        em.persist(lva);

        AssuranceVie asv = new AssuranceVie("jhifhzfz", 10000.00, Set.of(cli), LocalDate.now(), 15.00);
        em.persist(asv);

        Virement vir = new Virement(LocalDateTime.now(), 120.00, "virement check", com, "Sheeesh");
        em.persist(vir);

        Operation ope = new Operation(LocalDateTime.now(), 150.00, "operation check", com);
        em.persist(ope);

        et.commit();

        em.close();
        emf.close();
    }
}
package raffaele;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import raffaele.dao.EventoDao;
import raffaele.entities.Concerto;
import raffaele.entities.EventType;
import raffaele.entities.Genere;

public class Application {


    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("U4-W3-D4");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDao eventoDAO = new EventoDao(em);

        Concerto c1 = new Concerto("Rock in Roma", LocalDate.of(2026, 7, 10), "Concerto rock all'aperto", EventType.PUBBLICO, 5000, Genere.ROCK, true);

        eventoDAO.save(c1);


        System.out.println("=== CONCERTI IN STREAMING ===");
        List<Concerto> concertiStreaming = eventoDAO.getConcertiInStreaming(true);
        concertiStreaming.forEach(System.out::println);


        System.out.println("=== CONCERTI ROCK ===");
        List<Concerto> concertiRock = eventoDAO.getConcertiPerGenere(Genere.ROCK);
        concertiRock.forEach(System.out::println);

    }
}

package a.albertocoscia;

import a.albertocoscia.dao.EventoDAO;
import a.albertocoscia.entities.Evento;
import a.albertocoscia.entities.EventoTipo;
import a.albertocoscia.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi");

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = emf.createEntityManager();

        EventoDAO evento = new EventoDAO(em);
        LocalDate today = LocalDate.now();
        LocalDate inTwoDays = today.plusDays(2);
        Evento cena = new Evento("Cena", today, "Cibo buono", EventoTipo.PRIVATO, 2);
        Evento concerto = new Evento("Concerto Fred", inTwoDays, "Musica bella", EventoTipo.PUBBLICO, 15000);
        /*evento.save(cena);
        evento.save(concerto);*/

        try {
            Evento concertoFromDb = evento.getById(52);
            Evento cenaFromDb = evento.getById(53);
            System.out.println(concertoFromDb);
            System.out.println(cenaFromDb);
        } catch (NotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        /*try {
            evento.getByIdAndDelete(102);
        } catch (NotFoundException ex) {
            System.err.println(ex.getMessage() + " DELETE");
        }*/

        em.close();
        emf.close();
    }
}

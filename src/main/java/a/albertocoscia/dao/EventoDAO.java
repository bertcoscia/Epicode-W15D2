package a.albertocoscia.dao;

import a.albertocoscia.entities.Evento;
import a.albertocoscia.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        // richiedo all'em di fornire una transazione
        EntityTransaction transaction = em.getTransaction();
        // inizio la transazione
        transaction.begin();
        // aggiungo evento al persistence context
        em.persist(evento);
        // concludo la transazione
        transaction.commit();

        System.out.println("Evento " + evento.getTitolo() + " salvato correttamente");
    }

    public Evento getById(long eventId) {
        Evento found = em.find(Evento.class, eventId);
        if (found == null) throw new NotFoundException(eventId);
        return found;
    }

    public void getByIdAndDelete(long eventId) {
        Evento found = getById(eventId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Evento " + found.getTitolo() + " eliminato correttamente");
    }
}

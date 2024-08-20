package a.albertocoscia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi");

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }
}

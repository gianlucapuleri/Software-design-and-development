package com.puleri;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utils {

    public static void dropDatabase() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("football-persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        
        entityManager.createNativeQuery("DELETE IGNORE FROM Finanzia WHERE 1").executeUpdate();
        entityManager.createNativeQuery("DELETE IGNORE FROM Sponsor WHERE 1").executeUpdate();
        entityManager.createNativeQuery("DELETE IGNORE FROM Calciatore WHERE 1").executeUpdate();
        entityManager.createNativeQuery("DELETE IGNORE FROM Dirigente WHERE 1").executeUpdate();
        entityManager.createNativeQuery("DELETE IGNORE FROM Squadra WHERE 1").executeUpdate();
        entityManager.createNativeQuery("DELETE IGNORE FROM Citta WHERE 1").executeUpdate();
       
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

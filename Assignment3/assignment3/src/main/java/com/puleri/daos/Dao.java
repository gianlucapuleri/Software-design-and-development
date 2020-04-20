package com.puleri.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public abstract class Dao<T, Id extends Serializable> {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    abstract List<T> all();
    abstract T get(Id id);
    abstract T create(T t);
    abstract void delete(T t);
    abstract T update(T t);
    abstract List<T> search(String field, String value);

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("football-persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    Dao() {}

    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void rollbackTransaction() {
        entityManager.getTransaction().rollback();
    }

    EntityManager getEntityManager() {
        return entityManager;
    }
}

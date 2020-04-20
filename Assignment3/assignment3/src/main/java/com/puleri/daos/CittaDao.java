package com.puleri.daos;

import com.puleri.models.Citta;

import java.util.List;

public class CittaDao extends Dao<Citta, Integer> {

    @Override
    public List<Citta> all() {
        return getEntityManager().createQuery("from Citta").getResultList();
    }

    @Override
    public Citta get(Integer id) {
        return getEntityManager().find(Citta.class, id);
    }

    @Override
    public Citta create(Citta citta) {
        getEntityManager().persist(citta);
        return citta;
    }

    @Override
    public void delete(Citta citta) {
        getEntityManager().remove(citta);
    }

    @Override
    public Citta update(Citta citta) {
        return getEntityManager().merge(citta);
    }

    @Override
    public List<Citta> search(String field, String value) {
        return getEntityManager()
                .createQuery("SELECT citta FROM Citta citta WHERE citta." + field + " LIKE :value")
                .setParameter("value", value)
                .getResultList();
    }
}

package com.puleri.daos;

import com.puleri.models.Calciatore;

import java.util.List;

public class CalciatoreDao extends Dao<Calciatore, Integer> {
    @Override
    public List<Calciatore> all() {
        return getEntityManager().createQuery("from Calciatore").getResultList();
    }

    @Override
    public Calciatore get(Integer id) {
        return getEntityManager().find(Calciatore.class, id);
    }

    @Override
    public Calciatore create(Calciatore calciatore) {
        getEntityManager().persist(calciatore);
        return calciatore;
    }

    @Override
    public void delete(Calciatore calciatore) {
        getEntityManager().remove(calciatore);
    }

    @Override
    public Calciatore update(Calciatore calciatore) {
        return getEntityManager().merge(calciatore);
    }

    @Override
    public List<Calciatore> search(String field, String value) {
        return getEntityManager()
                .createQuery("SELECT calciatore FROM Calciatore calciatore WHERE calciatore." + field + " LIKE :value")
                .setParameter("value", value)
                .getResultList();
    }
}

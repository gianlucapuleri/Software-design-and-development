package com.puleri.daos;

import com.puleri.models.Squadra;

import java.util.List;

public class SquadraDao extends Dao<Squadra, Integer> {

    @Override
    public List<Squadra> all() {
        return getEntityManager().createQuery("from Squadra").getResultList();
    }

    @Override
    public Squadra get(Integer id) {
        return getEntityManager().find(Squadra.class, id);
    }

    @Override
    public Squadra create(Squadra squadra) {
        getEntityManager().persist(squadra);
        return squadra;
    }

    @Override
    public void delete(Squadra squadra) {
        getEntityManager().remove(squadra);
    }

    @Override
    public Squadra update(Squadra squadra) {
        return getEntityManager().merge(squadra);
    }

    @Override
    public List<Squadra> search(String field, String value) {
        return getEntityManager()
                .createQuery("SELECT squadra FROM Squadra squadra WHERE squadra." + field + " LIKE :value")
                .setParameter("value", value)
                .getResultList();
    }


}

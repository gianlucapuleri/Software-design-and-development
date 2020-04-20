package com.puleri.daos;

import com.puleri.models.Dirigente;

import java.util.List;

public class DirigenteDao extends Dao<Dirigente, Integer> {

    @Override
    public List<Dirigente> all() {
        return getEntityManager().createQuery("from Dirigente").getResultList();
    }

    @Override
    public Dirigente get(Integer id) {
        return getEntityManager().find(Dirigente.class, id);
    }

    @Override
    public Dirigente create(Dirigente dirigente) {
        getEntityManager().persist(dirigente);
        return dirigente;
    }

    @Override
    public void delete(Dirigente dirigente) {
        getEntityManager().remove(dirigente);
    }

    @Override
    public Dirigente update(Dirigente dirigente) {
        return getEntityManager().merge(dirigente);
    }

    @Override
    public List<Dirigente> search(String field, String value) {
        return getEntityManager()
                .createQuery("SELECT dirigente FROM Dirigente dirigente WHERE dirigente." + field + " LIKE :value")
                .setParameter("value", value)
                .getResultList();
    }

}

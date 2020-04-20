package com.puleri.services;

import com.puleri.daos.SquadraDao;
import com.puleri.models.Squadra;


import java.util.List;

public class SquadraService implements DaoInterface<Squadra, Integer>  {

    private SquadraDao squadraDao;

    public SquadraService() {
        this.squadraDao = new SquadraDao();
    }

    public Squadra get(Integer id) {
        squadraDao.beginTransaction();
        Squadra squadra = squadraDao.get(id);
        squadraDao.commitTransaction();

        return squadra;
    }

    public List<Squadra> all() {
        squadraDao.beginTransaction();
        List<Squadra> squadre = squadraDao.all();
        squadraDao.commitTransaction();

        return squadre;
    }

    public Squadra create(Squadra squadra) {
        squadraDao.beginTransaction();
        squadra = squadraDao.create(squadra);
        squadraDao.commitTransaction();

        return squadra;
    }

    public void delete(Squadra squadra) {
        squadraDao.beginTransaction();
        squadraDao.delete(squadra);
        squadraDao.commitTransaction();
    }

    public Squadra update(Squadra squadra) {
        squadraDao.beginTransaction();
        squadra = squadraDao.update(squadra);
        squadraDao.commitTransaction();

        return squadra;
    }

    public List<Squadra> search(String field, String value) {
        squadraDao.beginTransaction();
        List<Squadra> results = squadraDao.search(field, value);
        squadraDao.commitTransaction();
        return results;
    }
}

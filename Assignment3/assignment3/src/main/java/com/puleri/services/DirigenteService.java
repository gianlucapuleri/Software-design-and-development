package com.puleri.services;

import com.puleri.daos.DirigenteDao;
import com.puleri.models.Dirigente;

import java.util.List;

public class DirigenteService implements DaoInterface<Dirigente, Integer> {

    private DirigenteDao dirigenteDao;

    public DirigenteService() {
        this.dirigenteDao = new DirigenteDao();
    }

    public Dirigente get(Integer id) {
        dirigenteDao.beginTransaction();
        Dirigente dirigente = dirigenteDao.get(id);
        dirigenteDao.commitTransaction();
        return dirigente;
    }

    public List<Dirigente> all() {
        dirigenteDao.beginTransaction();
        List<Dirigente> dirigenti = dirigenteDao.all();
        dirigenteDao.commitTransaction();

        return dirigenti;
    }

    public Dirigente create(Dirigente dirigente) {
        dirigenteDao.beginTransaction();
        dirigente = dirigenteDao.create(dirigente);
        dirigenteDao.commitTransaction();

        return dirigente;
    }

    public void delete(Dirigente dirigente) {
        dirigenteDao.beginTransaction();
        dirigenteDao.delete(dirigente);
        dirigenteDao.commitTransaction();
    }

    public Dirigente update(Dirigente dirigente) {
        dirigenteDao.beginTransaction();
        dirigente = dirigenteDao.update(dirigente);
        dirigenteDao.commitTransaction();

        return dirigente;
    }

    public List<Dirigente> search(String field, String value) {
        dirigenteDao.beginTransaction();
        List<Dirigente> results = dirigenteDao.search(field, value);
        dirigenteDao.commitTransaction();
        return results;
    }
}

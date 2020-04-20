package com.puleri.services;

import com.puleri.daos.CittaDao;
import com.puleri.models.Citta;

import java.util.List;

public class CittaService implements DaoInterface<Citta, Integer> {

    private CittaDao cittaDao;

    public CittaService() {
        this.cittaDao = new CittaDao();
    }

    public Citta get(Integer id) {
        cittaDao.beginTransaction();
        Citta citta = cittaDao.get(id);
        cittaDao.commitTransaction();

        return citta;
    }

    public List<Citta> all() {
        cittaDao.beginTransaction();
        List<Citta> citta = cittaDao.all();
        cittaDao.commitTransaction();

        return citta;
    }

    public Citta create(Citta citta) {
        cittaDao.beginTransaction();
        citta = cittaDao.create(citta);
        cittaDao.commitTransaction();
        return citta;
    }

    public void delete(Citta citta) {
        cittaDao.beginTransaction();
        cittaDao.delete(citta);
        cittaDao.commitTransaction();
    }

    public Citta update(Citta citta) {
        cittaDao.beginTransaction();
        citta = cittaDao.update(citta);
        cittaDao.commitTransaction();

        return citta;
    }


    public List<Citta> search(String field, String value) {
        cittaDao.beginTransaction();
        List<Citta> results = cittaDao.search(field, value);
        cittaDao.commitTransaction();
        return results;
    }
}

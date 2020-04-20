package com.puleri.services;

import com.puleri.daos.CalciatoreDao;
import com.puleri.models.Calciatore;

import java.util.List;

public class CalciatoreService implements DaoInterface<Calciatore, Integer> {

    private CalciatoreDao calciatoreDao;

    public CalciatoreService() {
        this.calciatoreDao = new CalciatoreDao();
    }

    public Calciatore get(Integer id) {
        calciatoreDao.beginTransaction();
        Calciatore calciatore = calciatoreDao.get(id);
        calciatoreDao.commitTransaction();

        return calciatore;
    }

    public List<Calciatore> all() {
        calciatoreDao.beginTransaction();
        List<Calciatore> calciatori = calciatoreDao.all();
        calciatoreDao.commitTransaction();

        return calciatori;
    }

    public Calciatore create(Calciatore calciatore) {
        calciatoreDao.beginTransaction();
        calciatore = calciatoreDao.create(calciatore);
        calciatoreDao.commitTransaction();
        return calciatore;
    }

    public void delete(Calciatore calciatore) {
    	calciatoreDao.beginTransaction();
        calciatoreDao.delete(calciatore);
        calciatoreDao.commitTransaction();
    }

    public Calciatore update(Calciatore calciatore) {
        calciatoreDao.beginTransaction();
        calciatore = calciatoreDao.update(calciatore);
        calciatoreDao.commitTransaction();

        return calciatore;
    }

    public List<Calciatore> search(String field, String value) {
        calciatoreDao.beginTransaction();
        List<Calciatore> results = calciatoreDao.search(field, value);
        calciatoreDao.commitTransaction();
        return results;
    }


}

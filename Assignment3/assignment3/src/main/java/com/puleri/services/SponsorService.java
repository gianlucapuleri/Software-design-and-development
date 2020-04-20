package com.puleri.services;

import com.puleri.daos.SponsorDao;
import com.puleri.models.Sponsor;

import java.util.List;

public class SponsorService implements DaoInterface<Sponsor, Integer>  {

    private SponsorDao sponsorDao;

    public SponsorService() {
        this.sponsorDao = new SponsorDao();
    }

    public Sponsor get(Integer id) {
        sponsorDao.beginTransaction();
        Sponsor sponsor = sponsorDao.get(id);
        sponsorDao.commitTransaction();

        return sponsor;
    }

    public List<Sponsor> all() {
        sponsorDao.beginTransaction();
        List<Sponsor> sponsor = sponsorDao.all();
        sponsorDao.commitTransaction();

        return sponsor;
    }

    public Sponsor create(Sponsor sponsor) {
        sponsorDao.beginTransaction();
        sponsor = sponsorDao.create(sponsor);
        sponsorDao.commitTransaction();
        return sponsor;
    }

    public void delete(Sponsor sponsor) {
        sponsorDao.beginTransaction();
        sponsorDao.delete(sponsor);
        sponsorDao.commitTransaction();
    }

    public Sponsor update(Sponsor sponsor) {
        sponsorDao.beginTransaction();
        sponsor = sponsorDao.update(sponsor);
        sponsorDao.commitTransaction();

        return sponsor;
    }

    public List<Sponsor> search(String field, String value) {
    	sponsorDao.beginTransaction();
        List<Sponsor> results = sponsorDao.search(field, value);
        sponsorDao.commitTransaction();
        return results;
    }
}

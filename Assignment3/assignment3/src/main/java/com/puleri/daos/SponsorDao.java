package com.puleri.daos;

import com.puleri.models.Sponsor;

import java.util.List;

public class SponsorDao extends Dao<Sponsor, Integer> {

    @Override
    public List<Sponsor> all() {
        return getEntityManager().createQuery("from Sponsor").getResultList();
    }

    @Override
    public Sponsor get(Integer id) {
        return getEntityManager().find(Sponsor.class, id);
    }

    @Override
    public Sponsor create(Sponsor sponsor) {
        getEntityManager().persist(sponsor);
        return sponsor;
    }

    @Override
    public void delete(Sponsor sponsor) {
        getEntityManager().remove(sponsor);
    }

    @Override
    public Sponsor update(Sponsor sponsor) {
        return getEntityManager().merge(sponsor);
    }

    @Override
	public List<Sponsor> search(String field, String value) {
        return getEntityManager()
                .createQuery("SELECT sponsor FROM Sponsor sponsor WHERE sponsor." + field + " LIKE :value")
                .setParameter("value", value)
                .getResultList();
    }
}

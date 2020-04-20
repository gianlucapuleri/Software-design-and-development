package com.puleri.services;

import com.puleri.ServicesSingleton;
import com.puleri.Utils;
import com.puleri.models.*;

import com.puleri.seeders.fakefactories.*;
import org.junit.AfterClass;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

public class SponsorServiceTest {
    private SponsorService sponsorService;


    @Before
    public void before() {
        sponsorService = ServicesSingleton.getInstance().getSponsorService();
        Utils.dropDatabase();

    }

    @org.junit.Test
    public void get() {
        Sponsor a = createSponsor();
        sponsorService.get(a.getId());
        assertNotNull(a.getNome());
    }

    @org.junit.Test
    public void all() {
        createSponsor();
        createSponsor();
        List<Sponsor> as = sponsorService.all();
        assertEquals(as.size(), 2);
    }

    @org.junit.Test
    public void create() {
        Sponsor a = SponsorFakeFactory.make();
        a = sponsorService.create(a);
        assertNotNull(a.getId());
    }

    @org.junit.Test
    public void delete() {
        Sponsor a = createSponsor();
        sponsorService.delete(a);
        a = sponsorService.get(a.getId());
        assertNull(a);
    }

    @org.junit.Test
    public void update() {
        Sponsor a = createSponsor();
        a.setNome("Pirelli");
        a = sponsorService.update(a);

        Sponsor newSponsor = sponsorService.get(a.getId());
        assertEquals(newSponsor.getNome(), "Pirelli");
    }

    @org.junit.Test
    public void search() {
        createSponsor();
        Sponsor p = createSponsor();
        p.setNome("Nike");
        sponsorService.update(p);
        assertEquals(sponsorService.search("nome", "Nike").size(), 1);
        assertNotEquals(sponsorService.search("nome", "Adidas").size(), 1);
    }

    private Sponsor createSponsor() {
        Sponsor a = SponsorFakeFactory.make();
        a = sponsorService.create(a);
        return a;
    }

    @AfterClass
    public static void dropDb() {
        Utils.dropDatabase();
    }
}
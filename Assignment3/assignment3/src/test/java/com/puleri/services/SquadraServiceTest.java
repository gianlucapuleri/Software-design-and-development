package com.puleri.services;

import com.puleri.ServicesSingleton;
import com.puleri.Utils;
import com.puleri.models.Citta;
import com.puleri.models.Sponsor;
import com.puleri.models.Squadra;

import com.puleri.seeders.fakefactories.CittaFakeFactory;
import com.puleri.seeders.fakefactories.SponsorFakeFactory;
import com.puleri.seeders.fakefactories.SquadraFakeFactory;
import org.junit.AfterClass;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

public class SquadraServiceTest {
    private SquadraService squadraService;
    private List<Citta> citta;
    private List<Sponsor> sponsor;

    @Before
    public void before() {
        squadraService = ServicesSingleton.getInstance().getSquadraService();
        Utils.dropDatabase();
        
        this.citta= CittaFakeFactory.make(1);
        this.sponsor= SponsorFakeFactory.make(1);
        
        CittaService cittaService = new CittaService();
        cittaService.create(citta.get(0));
        SponsorService sponsorService = new SponsorService();
        sponsorService.create(sponsor.get(0));
    }

    @org.junit.Test
    public void get() {
        Squadra squadra = createSquadra();
        squadraService.get(squadra.getId());
        assertNotNull(squadra.getNome());
        assertNotNull(squadra.getFatturato());
        assertNotNull(squadra.getColori());
        assertNotNull(squadra.getLega());
    }

    @org.junit.Test
    public void all() {
        createSquadra();
        createSquadra();
        createSquadra();
        List<Squadra> as = squadraService.all();
        assertEquals(as.size(), 3);
    }

    @org.junit.Test
    public void create() {
        Squadra squadra = SquadraFakeFactory.make(citta, sponsor);
        squadra = squadraService.create(squadra);
        assertNotNull(squadra.getId());
        assertNotNull(squadra.getNome());
        assertNotNull(squadra.getFatturato());
        assertNotNull(squadra.getColori());
        assertNotNull(squadra.getLega());
    }

    @org.junit.Test
    public void delete() {
        Squadra squadra = createSquadra();
        squadraService.delete(squadra);
        squadra = squadraService.get(squadra.getId());
        assertNull(squadra);
    }

    @org.junit.Test
    public void update() {
        Squadra squadra = createSquadra();
        squadra.setNome("Napoli");
        squadra.setFatturato(100000);
        squadra.setColori("azzurro");
        squadra.setLega("Serie A");
        squadra = squadraService.update(squadra);
        Squadra newSquadra = squadraService.get(squadra.getId());
        assertEquals(newSquadra.getNome(), "Napoli");
        assertEquals(newSquadra.getFatturato(), (Integer) 100000);
        assertEquals(newSquadra.getColori(), "azzurro");
        assertEquals(newSquadra.getLega(), "Serie A");
    }

    @org.junit.Test
    public void updateCitta() {
        Squadra squadra = createSquadra();
        Citta a = CittaFakeFactory.make();
        CittaService cittaService = ServicesSingleton.getInstance().getCittaService();
        cittaService.create(a);

        squadra.setCitta(a);
        squadra = squadraService.update(squadra);
        Squadra newSquadra = squadraService.get(squadra.getId());
        assertEquals(newSquadra.getCitta().getId(), a.getId());
    }
    
    @org.junit.Test
    public void updateSponsor() {
        Squadra squadra = createSquadra();
        List<Sponsor> a = SponsorFakeFactory.make(2);
        SponsorService sponsorService = ServicesSingleton.getInstance().getSponsorService();
        sponsorService.create(a.get(0));
        sponsorService.create(a.get(1));

        squadra.setSponsors(a);
        squadra = squadraService.update(squadra);
        Squadra newSquadra = squadraService.get(squadra.getId());
        assertEquals(newSquadra.getSponsors().get(0).getId(), a.get(0).getId());
        assertEquals(newSquadra.getSponsors().get(1).getId(), a.get(1).getId());
    }
    
    @org.junit.Test
    public void search() {
        createSquadra();
        Squadra b = createSquadra();
        b.setNome("Inter");
        squadraService.update(b);
        assertEquals(squadraService.search("nome", "Inter").size(), 1);
    }

    private Squadra createSquadra() {
        Squadra squadra = SquadraFakeFactory.make(citta, sponsor);
        squadra = squadraService.create(squadra);
        return squadra;
    }

    @AfterClass
    public static void dropDb() {
        Utils.dropDatabase();
    }
}
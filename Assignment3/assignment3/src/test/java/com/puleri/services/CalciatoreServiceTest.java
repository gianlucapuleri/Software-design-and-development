package com.puleri.services;

import com.puleri.ServicesSingleton;
import com.puleri.Utils;
import com.puleri.models.Calciatore;
import com.puleri.models.Citta;
import com.puleri.models.Sponsor;
import com.puleri.models.Squadra;

import com.puleri.seeders.fakefactories.CalciatoreFakeFactory;
import com.puleri.seeders.fakefactories.CittaFakeFactory;
import com.puleri.seeders.fakefactories.SponsorFakeFactory;
import com.puleri.seeders.fakefactories.SquadraFakeFactory;

import org.junit.AfterClass;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

public class CalciatoreServiceTest {
    private CalciatoreService calciatoreService;
    private List<Squadra> squadre;
    private List<Citta> citta;
    private List<Sponsor> sponsor;

    @Before
    public void before() {
        calciatoreService = ServicesSingleton.getInstance().getCalciatoreService();
        Utils.dropDatabase();
        
        this.citta= CittaFakeFactory.make(1);
        this.sponsor= SponsorFakeFactory.make(1);
        
        CittaService cittaService = ServicesSingleton.getInstance().getCittaService();
        cittaService.create(citta.get(0));
        SponsorService sponsorService = ServicesSingleton.getInstance().getSponsorService();
        sponsorService.create(sponsor.get(0));
        
        this.squadre = SquadraFakeFactory.make(1, citta, sponsor);

        SquadraService squadraService = ServicesSingleton.getInstance().getSquadraService();
        squadraService.create(squadre.get(0));
    }

    @org.junit.Test
    public void get() {
        Calciatore a = createCalciatore();
        calciatoreService.get(a.getId());
        assertNotNull(a.getNome());
        assertNotNull(a.getCognome());
        assertNotNull(a.getNazionalita());
        assertNotNull(a.getRuolo());
    }

    @org.junit.Test
    public void all() {
        createCalciatore();
        createCalciatore();
        List<Calciatore> as = calciatoreService.all();
        assertEquals(as.size(), 2);
    }

    @org.junit.Test
    public void create() {
        Calciatore a = CalciatoreFakeFactory.make(squadre);
        a = calciatoreService.create(a);
        assertNotNull(a.getId());
        assertNotNull(a.getNazionalita());
        assertNotNull(a.getNome());
        assertNotNull(a.getCognome());
        assertNotNull(a.getRuolo());
    }

    @org.junit.Test
    public void delete() {
        Calciatore a = createCalciatore();
        calciatoreService.delete(a);
        a = calciatoreService.get(a.getId());
        assertNull(a);
    }

    @org.junit.Test
    public void update() {
        Calciatore a = createCalciatore();
        a.setNome("Cristiano");
        a.setCognome("Ronaldo");
        a.setNazionalita("Portogallo");
        a.setRuolo("attaccante");
        a = calciatoreService.update(a);
        Calciatore newCalciatore = calciatoreService.get(a.getId());
        assertEquals(newCalciatore.getNome(), "Cristiano");
        assertEquals(newCalciatore.getCognome(), "Ronaldo");
        assertEquals(newCalciatore.getNazionalita(), "Portogallo");
        assertEquals(newCalciatore.getRuolo(), "attaccante");
    }

    @org.junit.Test
    public void search() {
        createCalciatore();
        Calciatore a = createCalciatore();
        a.setNome("Milan");
        a.setCognome("Skriniar");
        a.setNazionalita("Slovacchia");
        a.setRuolo("difensore");
        calciatoreService.update(a);
        assertEquals(calciatoreService.search("nome", "Milan").size(), 1);
        assertEquals(calciatoreService.search("cognome", "Skriniar").size(), 1);
        assertEquals(calciatoreService.search("nazionalita", "Slovacchia").size(), 1);
        assertEquals(calciatoreService.search("ruolo", "difensore").size(), 1);
    }

    @org.junit.Test
    public void updateSquadra() {
        Calciatore calciatore = createCalciatore();
        Squadra a = SquadraFakeFactory.make(citta, sponsor);
        SquadraService squadraService = ServicesSingleton.getInstance().getSquadraService();
        squadraService.create(a);

        calciatore.setSquadre(a);
        calciatore = calciatoreService.update(calciatore);
        Calciatore newCalciatore = calciatoreService.get(calciatore.getId());
        assertEquals(newCalciatore.getSquadre().getId(), a.getId());
    }
    
    @org.junit.Test
    public void updateCalciatore() {
        Calciatore figlio = createCalciatore();
        Calciatore padre = createCalciatore();

        figlio.setPadre(padre);
        figlio = calciatoreService.update(figlio);
        Calciatore newCalciatore = calciatoreService.get(figlio.getId());
        assertEquals(newCalciatore.getPadre().getId(), padre.getId());
    }
    
    private Calciatore createCalciatore() {
        Calciatore a = CalciatoreFakeFactory.make(squadre);
        a = calciatoreService.create(a);
        return a;
    }

    @AfterClass
    public static void dropDb() {
        Utils.dropDatabase();
    }
}
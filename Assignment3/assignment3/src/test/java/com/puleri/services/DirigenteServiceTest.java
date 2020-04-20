package com.puleri.services;

import com.puleri.ServicesSingleton;
import com.puleri.Utils;
import com.puleri.models.Citta;
import com.puleri.models.Dirigente;
import com.puleri.models.Sponsor;
import com.puleri.models.Squadra;
import com.puleri.seeders.fakefactories.CittaFakeFactory;
import com.puleri.seeders.fakefactories.DirigenteFakeFactory;
import com.puleri.seeders.fakefactories.SponsorFakeFactory;
import com.puleri.seeders.fakefactories.SquadraFakeFactory;

import org.junit.AfterClass;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

public class DirigenteServiceTest {
    private DirigenteService dirigenteService;
    private List<Squadra> squadre;
    private List<Citta> citta;
    private List<Sponsor> sponsor;

    @Before
    public void before() {
        dirigenteService = ServicesSingleton.getInstance().getDirigenteService();
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
        Dirigente a = createDirigente();
        dirigenteService.get(a.getId());
        assertNotNull(a.getNome());
        assertNotNull(a.getCognome());
        assertNotNull(a.getRuolo());
    }

    @org.junit.Test
    public void all() {
        createDirigente();
        createDirigente();
        createDirigente();
        List<Dirigente> as = dirigenteService.all();
        assertEquals(as.size(), 3);
    }

    @org.junit.Test
    public void create() {
        Dirigente a = DirigenteFakeFactory.make(squadre);
        a = dirigenteService.create(a);
        assertNotNull(a.getId());
        assertNotNull(a.getNome());
        assertNotNull(a.getCognome());
        assertNotNull(a.getRuolo());
    }

    @org.junit.Test
    public void delete() {
        Dirigente a = createDirigente();
        dirigenteService.delete(a);
        a = dirigenteService.get(a.getId());
        assertNull(a);
    }

    @org.junit.Test
    public void update() {
        Dirigente a = createDirigente();
        a.setNome("Giovanni");
        a.setCognome("Romano");
        a.setRuolo("allenatore");
        a = dirigenteService.update(a);
        Dirigente newDirigente = dirigenteService.get(a.getId());
        assertEquals(newDirigente.getNome(), "Giovanni");
        assertEquals(newDirigente.getCognome(), "Romano");
        assertEquals(newDirigente.getRuolo(), "allenatore");
    }

    @org.junit.Test
    public void search() {
        createDirigente();
        Dirigente a = createDirigente();
        a.setNome("Giovanni");
        a.setCognome("Romano");
        a.setRuolo("allenatore");
        dirigenteService.update(a);
        assertEquals(dirigenteService.search("nome", "Giovanni").size(), 1);
        assertEquals(dirigenteService.search("cognome", "Romano").size(), 1);
        assertEquals(dirigenteService.search("ruolo", "allenatore").size(), 1);
        assertNotEquals(dirigenteService.search("nome", "Andrea").size(), 1);
    }

    @org.junit.Test
    public void updateSquadra() {
        Dirigente dirigente = createDirigente();
        Squadra a = SquadraFakeFactory.make(citta, sponsor);
        SquadraService squadraService = ServicesSingleton.getInstance().getSquadraService();
        squadraService.create(a);

        dirigente.setSquadre(a);
        dirigente = dirigenteService.update(dirigente);
        Dirigente newDirigente = dirigenteService.get(dirigente.getId());
        assertEquals(newDirigente.getSquadre().getId(), a.getId());
    }
    
    private Dirigente createDirigente() {
        Dirigente a = DirigenteFakeFactory.make(squadre);
        a = dirigenteService.create(a);
        return a;
    }

    @AfterClass
    public static void dropDb() {
        Utils.dropDatabase();
    }
}
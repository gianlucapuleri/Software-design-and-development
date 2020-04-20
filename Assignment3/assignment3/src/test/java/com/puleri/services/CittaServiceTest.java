package com.puleri.services;


import com.puleri.ServicesSingleton;
import com.puleri.Utils;
import com.puleri.models.Citta;
import com.puleri.seeders.fakefactories.CittaFakeFactory;
import org.junit.AfterClass;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

public class CittaServiceTest {
    private CittaService cittaService;

    @Before
    public void before() {
        cittaService = ServicesSingleton.getInstance().getCittaService();
        Utils.dropDatabase();
    }

    @org.junit.Test
    public void get() {
        Citta a = createCitta();
        cittaService.get(a.getId());
        
        assertNotNull(a.getNome());
        assertNotNull(a.getProvincia());
        assertNotNull(a.getStato());
    }

    @org.junit.Test
    public void all() {
        createCitta();
        createCitta();
        createCitta();
        List<Citta> as = cittaService.all();
        assertEquals(as.size(), 3);
    }

    @org.junit.Test
    public void create() {
        Citta a = CittaFakeFactory.make();
        a = cittaService.create(a);
        assertNotNull(a.getId());
        assertNotNull(a.getNome());
        assertNotNull(a.getProvincia());
        assertNotNull(a.getStato());
    }

    @org.junit.Test
    public void delete() {
        Citta a = createCitta();
        cittaService.delete(a);
        a = cittaService.get(a.getId());
        assertNull(a);
    }

    @org.junit.Test
    public void update() {
        Citta a = createCitta();
        a.setNome("Desio");
        a.setProvincia("Monza");
        a.setStato("Italia");
        a = cittaService.update(a);
        Citta newCitta = cittaService.get(a.getId());
        assertEquals(newCitta.getNome(), "Desio");
        assertEquals(newCitta.getProvincia(), "Monza");
        assertEquals(newCitta.getStato(), "Italia");
    }

    @org.junit.Test
    public void search() {
        createCitta();
        Citta g = createCitta();
        g.setNome("Milano");
        g.setProvincia("Milano");
        g.setStato("Italia");
        cittaService.update(g);
        assertEquals(cittaService.search("nome", "Milano").size(), 1);
        assertEquals(cittaService.search("provincia", "Milano").size(), 1);
        assertEquals(cittaService.search("stato", "Italia").size(), 1);
        assertNotEquals(cittaService.search("stato", "Germania").size(), 1);
    }

    private Citta createCitta() {
        Citta a = CittaFakeFactory.make();
        a = cittaService.create(a);
        return a;
    }

    @AfterClass
    public static void dropDb() {
        Utils.dropDatabase();
    }
}
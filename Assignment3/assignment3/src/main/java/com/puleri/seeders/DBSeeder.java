package com.puleri.seeders;

import com.puleri.models.*;
import com.puleri.seeders.fakefactories.*;
import com.puleri.Utils;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

public class DBSeeder {

    private static final int N_CITTA = 15;
    private static final int N_DIRIGENTI = 20;
    private static final int N_CALCIATORI = 40;
    private static final int N_SQUADRE = 20;
    private static final int N_SPONSOR = 30;

    private static Logger log = Logger.getLogger(DBSeeder.class.getName());

    public static void seedDatabase() {
		
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("football-persistence");
        
        EntityManager em = factory.createEntityManager();
        
        
        em.getTransaction().begin();
        
        List<Citta> citta = CittaFakeFactory.make(N_CITTA);
        citta.forEach(em::persist);

        List<Sponsor> sponsors = SponsorFakeFactory.make(N_SPONSOR);
        sponsors.forEach(em::persist);

        List<Squadra> squadre = SquadraFakeFactory.make(N_SQUADRE, citta, sponsors);
        squadre.forEach(em::persist);

        List<Dirigente> dirigenti = DirigenteFakeFactory.make(N_DIRIGENTI, squadre);
        dirigenti.forEach(em::persist);

        List<Calciatore> calciatori = CalciatoreFakeFactory.make(N_CALCIATORI, squadre);
        calciatori.forEach(em::persist);

        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
        log.info("Populating the database...");
        Utils.dropDatabase();
        seedDatabase();
		log.info("Completed!");
        System.exit(0);
    }
}

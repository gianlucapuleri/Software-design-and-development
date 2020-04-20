package com.puleri;

import com.puleri.services.*;

public class ServicesSingleton {

    private static ServicesSingleton instance;

    private SquadraService squadraService;
    private DirigenteService dirigenteService;
    private CalciatoreService calciatoreService;
    private CittaService cittaService;
    private SponsorService sponsorService;

    private ServicesSingleton(){
        dirigenteService = new DirigenteService();
        calciatoreService = new CalciatoreService();
        cittaService = new CittaService();
        squadraService = new SquadraService();
        sponsorService = new SponsorService();
    }

    public static synchronized ServicesSingleton getInstance(){
        if(instance == null){
            instance = new ServicesSingleton();
        }
        return instance;
    }

    public SquadraService getSquadraService() {
        return squadraService;
    }

    public DirigenteService getDirigenteService() {
        return dirigenteService;
    }

    public CalciatoreService getCalciatoreService() {
        return calciatoreService;
    }

    public CittaService getCittaService() {
        return cittaService;
    }

    public SponsorService getSponsorService() {
        return sponsorService;
    }
}

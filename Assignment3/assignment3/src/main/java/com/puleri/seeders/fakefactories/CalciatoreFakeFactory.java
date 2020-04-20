package com.puleri.seeders.fakefactories;

import com.github.javafaker.Faker;
import com.puleri.models.Calciatore;
import com.puleri.models.Squadra;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalciatoreFakeFactory {
    private static Faker faker = new Faker(new Locale("it"));

    public static Calciatore make(List<Squadra> squadre) {
        Calciatore calciatore = new Calciatore();
        calciatore.setNome(faker.name().firstName());
        calciatore.setCognome(faker.name().lastName());
        calciatore.setRuolo(UtilFakeFactory.CalciatoriRuolo.randomRole().toString());
        calciatore.setNazionalita(faker.address().country());
        
        calciatore.setSquadre(UtilFakeFactory.randomFromList(squadre));
        return calciatore;
    }

    public static List<Calciatore> make(int amount, List<Squadra> squadre) {
        List<Calciatore> calciatori = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            calciatori.add(make(squadre));
        }
        for (int i = 0; i < amount / 10; i++) {
        	calciatori.get(i).setPadre(UtilFakeFactory.randomFromList(calciatori));
        }
        return calciatori;
    }
}

package com.puleri.seeders.fakefactories;

import com.github.javafaker.Faker;
import com.puleri.models.Dirigente;
import com.puleri.models.Squadra;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DirigenteFakeFactory {
    private static Faker faker = new Faker(new Locale("it"));

    public static Dirigente make(List<Squadra> squadre) {
        Dirigente dirigente = new Dirigente();
        dirigente.setNome(faker.name().firstName());
        dirigente.setCognome(faker.name().lastName());
        dirigente.setRuolo(UtilFakeFactory.DirigentiRuolo.randomRole().toString());
        
        dirigente.setSquadre(UtilFakeFactory.randomFromList(squadre));
        
        return dirigente;
    }

    public static List<Dirigente> make(int amount, List<Squadra> squadre) {
        List<Dirigente> dirigenti = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            dirigenti.add(make(squadre));
        }
        return dirigenti;
    }
}

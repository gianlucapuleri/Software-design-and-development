package com.puleri.seeders.fakefactories;

import com.github.javafaker.Faker;
import com.puleri.models.Squadra;
import com.puleri.models.Citta;
import com.puleri.models.Sponsor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SquadraFakeFactory {
    private static Faker faker = new Faker(new Locale("it"));


    public static Squadra make(List<Citta> citta, List<Sponsor> sponsors) {
        Squadra squadra = new Squadra();
        squadra.setNome(faker.team().name());
        squadra.setLega(faker.esports().league());
        squadra.setColori(faker.color().name());
        squadra.setFatturato(faker.number().numberBetween(1000, 100000));

        squadra.setCitta(UtilFakeFactory.randomFromList(citta));
        squadra.setSponsors(UtilFakeFactory.randomSubList(sponsors, Math.min(2, sponsors.size())));

        return squadra;
    }

    public static List<Squadra> make(int amount, List<Citta> citta, List<Sponsor> sponsors) {
        List<Squadra> squadre = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            squadre.add(make(citta, sponsors));
        }
        return squadre;
    }
}

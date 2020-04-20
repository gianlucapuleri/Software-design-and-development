package com.puleri.seeders.fakefactories;

import com.github.javafaker.Faker;
import com.puleri.models.Citta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CittaFakeFactory {
    private static Faker faker = new Faker(new Locale("it"));

    public static Citta make() {
        Citta citta = new Citta();
        citta.setNome(faker.address().cityName());
        citta.setProvincia(faker.address().state());
        citta.setStato(faker.address().country());
        return citta;
    }

    public static List<Citta> make(int amount) {
        List<Citta> citta = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            citta.add(make());
        }
        return citta;
    }
}

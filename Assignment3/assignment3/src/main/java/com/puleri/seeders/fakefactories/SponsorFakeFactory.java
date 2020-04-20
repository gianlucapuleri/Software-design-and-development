package com.puleri.seeders.fakefactories;

import com.github.javafaker.Faker;
import com.puleri.models.Sponsor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SponsorFakeFactory {
    private static Faker faker = new Faker(new Locale("it"));


    public static Sponsor make() {
        Sponsor sponsor = new Sponsor();
        sponsor.setNome(faker.company().name());

        return sponsor;
    }

    public static List<Sponsor> make(int amount) {
        List<Sponsor> sponsors = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            sponsors.add(make());
        }
        return sponsors;
    }
}

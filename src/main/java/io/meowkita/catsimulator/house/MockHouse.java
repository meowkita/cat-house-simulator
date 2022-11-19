package io.meowkita.catsimulator.house;

import io.meowkita.catsimulator.cat.Cat;

public class MockHouse extends House {

    public MockHouse() {
        add(new Cat.CatBuilder().name("Milky").age(11).randomStats().build());
        add(new Cat.CatBuilder().name("David").age(13).randomStats().build());
        add(new Cat.CatBuilder().name("Damian").age(8).randomStats().build());
        add(new Cat.CatBuilder().name("Sam").age(5).randomStats().build());
    }

}

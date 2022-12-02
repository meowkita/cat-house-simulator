package io.meowkita.catsimulator.cat.house;

import io.meowkita.catsimulator.cat.Cat;
import io.meowkita.catsimulator.cat.decorators.LockInteractionCat;

public class MockHouse extends House {

    public MockHouse() {
        add(new LockInteractionCat(new Cat.CatBuilder().name("Milky").age(11).randomStats().build()));
        add(new LockInteractionCat(new Cat.CatBuilder().name("Damian").age(8).randomStats().build()));
        add(new LockInteractionCat(new Cat.CatBuilder().name("Sam").age(5).randomStats().build()));
    }

}

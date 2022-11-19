package io.meowkita.catsimulator.house;

import io.meowkita.catsimulator.cat.Cat;
import io.meowkita.catsimulator.cat.decorators.LockInteractionCatDecorator;

public class MockHouse extends House {

    public MockHouse() {
        add(new LockInteractionCatDecorator(new Cat.CatBuilder().name("Milky").age(11).randomStats().build()));
        add(new LockInteractionCatDecorator(new Cat.CatBuilder().name("Damian").age(8).randomStats().build()));
        add(new LockInteractionCatDecorator(new Cat.CatBuilder().name("Sam").age(5).randomStats().build()));
    }

}

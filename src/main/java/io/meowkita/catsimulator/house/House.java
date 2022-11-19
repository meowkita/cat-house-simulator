package io.meowkita.catsimulator.house;

import io.meowkita.catsimulator.cat.Cat;
import io.meowkita.catsimulator.house.printer.HousePrinter;

import java.util.HashMap;

public class House {

    protected final HousePrinter printer;
    private final HashMap<Integer, Cat> catHashMap = new HashMap<>();
    private int counter = 0;

    public House(HousePrinter printer) {
        this.printer = printer;
    }

    public void print() {
        printer.print(catHashMap);
    }

    public void add(Cat cat) {
        catHashMap.put(++counter, cat);
    }

    public void remove(int id) {
        catHashMap.remove(id);
    }

    public void sleep() {
        catHashMap.forEach((id, cat) -> cat.sleep(15));
    }

}

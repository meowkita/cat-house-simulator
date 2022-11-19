package io.meowkita.catsimulator.house;

import io.meowkita.catsimulator.cat.Cat;

import java.util.HashMap;

public class House {

    private final HashMap<Integer, Cat> catHashMap = new HashMap<>();
    private int counter = 0;

    public HashMap<Integer, Cat> getCatHashMap() {
        return new HashMap<>(catHashMap);
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

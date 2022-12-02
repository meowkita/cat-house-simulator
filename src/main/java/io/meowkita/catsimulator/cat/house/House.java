package io.meowkita.catsimulator.cat.house;

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

    public Cat get(int id) {
        return catHashMap.get(id);
    }

    public void remove(int id) {
        catHashMap.remove(id);
    }

    public void sleep() {
        catHashMap.forEach((id, cat) -> cat.sleep(15));
    }

}

package io.meowkita.catsimulator.cat.house.printer;

import io.meowkita.catsimulator.cat.Cat;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public interface HousePrinter {

    void print(HashMap<Integer, Cat> catList);

    void printSorted(HashMap<Integer, Cat> catHashMap, Comparator<Map.Entry<Integer, Cat>> comparator);

}

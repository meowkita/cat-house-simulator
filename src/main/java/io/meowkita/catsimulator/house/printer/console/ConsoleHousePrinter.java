package io.meowkita.catsimulator.house.printer.console;

import io.meowkita.catsimulator.cat.Cat;
import io.meowkita.catsimulator.house.House;
import io.meowkita.catsimulator.house.printer.HousePrinter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ConsoleHousePrinter implements HousePrinter {

    private final String format = "| %2s | %25s | %3s | %6s | %9s | %7s | %13s |";

    @Override
    public void print(HashMap<Integer, Cat> catHashMap) {
        printDelimiter();
        printHeader();
        printDelimiter();

        catHashMap.forEach((id, cat) -> {
            String line = String.format(
                    format,
                    id,
                    cat.getName(),
                    cat.getAge(),
                    cat.getHealth(),
                    cat.getHappiness(),
                    cat.getSatiety(),
                    cat.getStatsAverage());
            System.out.println(line);
        });

        printDelimiter();
    }

    @Override
    public void printSorted(HashMap<Integer, Cat> catHashMap, Comparator<Map.Entry<Integer, Cat>> comparator) {
        HashMap<Integer, Cat> sortedCats = new HashMap<>();
        catHashMap.entrySet().stream()
                .sorted(comparator)
                .forEach(entry -> sortedCats.put(entry.getKey(), entry.getValue()));
        print(sortedCats);
    }

    private void printHeader() {
        String line = String.format(format, "#", "Name", "Age", "Health", "Happiness", "Satiety", "Stats Average");
        System.out.println(line);
    }

    private void printDelimiter() {
        String delimiter = "+----+---------------------------+-----+--------+-----------+---------+---------------+";
        System.out.println(delimiter);
    }

}

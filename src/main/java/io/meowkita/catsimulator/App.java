package io.meowkita.catsimulator;

import io.meowkita.catsimulator.cat.Cat;
import io.meowkita.catsimulator.house.House;
import io.meowkita.catsimulator.house.printer.ConsoleHousePrinter;
import io.meowkita.catsimulator.house.menu.ConsoleHouseMenu;
import io.meowkita.catsimulator.house.menu.HouseMenu;

public class App {

    public static void main(String[] args) {
        House house = new House(new ConsoleHousePrinter());
        HouseMenu menu = new ConsoleHouseMenu(house);

        house.add(new Cat.CatBuilder().name("Milky").age(16).randomStats().build());
        house.add(new Cat.CatBuilder().name("Damian").age(8).randomStats().build());

        menu.print();

        menu.add();

        menu.sleep();

        menu.print();
    }

}
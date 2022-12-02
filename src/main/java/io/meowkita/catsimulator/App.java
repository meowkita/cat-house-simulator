package io.meowkita.catsimulator;

import io.meowkita.catsimulator.cat.house.House;
import io.meowkita.catsimulator.cat.house.MockHouse;
import io.meowkita.catsimulator.cat.house.menu.HouseMenu;
import io.meowkita.catsimulator.cat.house.menu.console.ConsoleHouseMenu;
import io.meowkita.catsimulator.cat.house.menu.console.decorators.LoopedConsoleHouseMenu;
import io.meowkita.catsimulator.cat.house.printer.console.ConsoleHousePrinter;
import io.meowkita.catsimulator.cat.house.printer.HousePrinter;

public class App {

    public static void main(String[] args) {
        House house = new MockHouse();
        HousePrinter printer = new ConsoleHousePrinter();
        HouseMenu menu = new LoopedConsoleHouseMenu(new ConsoleHouseMenu(house, printer));

        menu.open();
    }

}

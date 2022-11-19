package io.meowkita.catsimulator;

import io.meowkita.catsimulator.house.House;
import io.meowkita.catsimulator.house.MockHouse;
import io.meowkita.catsimulator.house.menu.HouseMenu;
import io.meowkita.catsimulator.house.menu.console.ConsoleHouseMenu;
import io.meowkita.catsimulator.house.menu.console.decorators.LoopedConsoleHouseMenuDecorator;
import io.meowkita.catsimulator.house.printer.ConsoleHousePrinter;
import io.meowkita.catsimulator.house.printer.HousePrinter;

public class App {

    public static void main(String[] args) {
        House house = new MockHouse();
        HousePrinter printer = new ConsoleHousePrinter();
        HouseMenu menu = new LoopedConsoleHouseMenuDecorator(new ConsoleHouseMenu(house, printer));

        menu.open();
    }

}

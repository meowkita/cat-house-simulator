package io.meowkita.catsimulator.house.menu.console;

import io.meowkita.catsimulator.cat.Cat;
import io.meowkita.catsimulator.house.House;
import io.meowkita.catsimulator.house.menu.HouseMenu;
import io.meowkita.catsimulator.house.printer.HousePrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHouseMenu implements HouseMenu {

    protected final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final HousePrinter printer;
    private final House house;
    protected boolean isOpened;

    public ConsoleHouseMenu(House house, HousePrinter printer) {
        this.house = house;
        this.printer = printer;
        isOpened = false;
    }

    protected ConsoleHouseMenu(ConsoleHouseMenu consoleHouseMenu) {
        this(consoleHouseMenu.house, consoleHouseMenu.printer);
    }

    @Override
    public void open() {
        isOpened = true;
    }

    @Override
    public void print() {
        printer.print(house.getCatHashMap());
    }

    @Override
    public void add() {
        String name;
        int age;

        try {
            System.out.print("Enter cat name: ");
            name = reader.readLine();

            if (name.length() <= 1) {
                throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            System.out.println("Pet name is invalid! Cat won't be added.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Pet name must be greater than 1 symbol! Cat won't be added.");
            return;
        }

        try {
            System.out.print("Enter cat age: ");
            age = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Age is invalid! Cat won't be added.");
            return;
        }

        house.add(new Cat.CatBuilder().name(name).age(age).randomStats().build());
    }

    @Override
    public void remove() {
        int id;

        try {
            System.out.print("Enter ID to remove: ");
            id = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("ID is invalid! Cat won't be removed.");
            return;
        }

        house.remove(id);
    }

    @Override
    public void play() {
        try {
            int id = getCatId();
            if (id != -1) {
                house.get(id).play(50);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void feed() {
        try {
            int id = getCatId();
            if (id != -1) {
                house.get(id).feed(50);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void heal() {
        try {
            int id = getCatId();
            if (id != -1) {
                house.get(id).heal(50);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void sleep() {
        System.out.println("--- Bed time. Cats are going to sleep. ---");
        house.sleep();
        System.out.println("--- ZZzzz...");
        System.out.println("--- New day is coming! Time to wake up! ---");
    }

    @Override
    public void close() {
        isOpened = false;
    }

    private int getCatId() {
        int id;

        try {
            System.out.print("Enter a cat ID: ");
            id = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("ID is invalid!");
            return -1;
        }

        return id;
    }

}

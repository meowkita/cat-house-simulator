package io.meowkita.catsimulator.house.menu.console.decorators;

import io.meowkita.catsimulator.house.menu.console.ConsoleHouseMenu;

import java.io.IOException;

public class LoopedConsoleHouseMenuDecorator extends ConsoleHouseMenu {

    public LoopedConsoleHouseMenuDecorator(ConsoleHouseMenu consoleHouseMenu) {
        super(consoleHouseMenu);
    }

    @Override
    public void open() {
        super.open();
        loop();
    }

    private void loop() {
        while (isOpened) {
            print();

            printActions();
            System.out.print("Enter action number: ");
            int action;

            try {
                action = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                throw new RuntimeException(e);
            }

            switch (action) {
                case 1 -> add();
                case 2 -> remove();
                case 3 -> sleep();
                case 4 -> close();
                default -> System.out.println("Action [" + action + "] is not supported!");
            }

            System.out.println("\n");
        }
    }

    private void printActions() {
        System.out.println("[1] Add / Adds a new cat");
        System.out.println("[2] Remove / Remove a cat by ID");
        System.out.println("[3] Sleep / Skip a one day till morning");
        System.out.println("[4] Close / Closes this menu");
    }

}

package io.meowkita.catsimulator.house.menu.console.decorators;

import io.meowkita.catsimulator.house.menu.console.ConsoleHouseMenu;

import java.io.IOException;
import java.util.Locale;

public class LoopedConsoleHouseMenuDecorator extends ConsoleHouseMenu {

    public LoopedConsoleHouseMenuDecorator(ConsoleHouseMenu menu) {
        super(menu);
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
            System.out.print("Enter action name: ");
            String action;

            try {
                action = reader
                        .readLine()
                        .toLowerCase(Locale.ROOT)
                        .strip();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println();

            switch (action) {
                case "add" -> add();
                case "remove" -> remove();
                case "play" -> play();
                case "feed" -> feed();
                case "heal" -> heal();
                case "sleep" -> sleep();
                case "close" -> close();
                default -> System.out.println("Action [" + action + "] is not supported!");
            }

            System.out.println("\n");
        }
    }

    private void printActions() {
        System.out.println("[Add]     Adds a new cat");
        System.out.println("[Remove]  Remove a cat by ID");
        System.out.println("[Play]    Plays with a cat by ID");
        System.out.println("[Feed]    Feeds a cat by ID");
        System.out.println("[Heal]    Heals a cat by ID");
        System.out.println("[Sleep]   Skip a one day till morning");
        System.out.println("[Close]   Closes this menu");
    }

}

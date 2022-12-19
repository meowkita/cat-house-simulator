package io.meowkita.catsimulator.cat.house.menu.console.decorators;

import io.meowkita.catsimulator.cat.house.menu.console.ConsoleHouseMenu;

import java.io.IOException;
import java.util.Locale;

public class LoopedConsoleHouseMenu extends ConsoleHouseMenu {

    public LoopedConsoleHouseMenu(ConsoleHouseMenu menu) {
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
            String action = tryReadString();

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

            System.out.println();
        }
    }

    private void printActions() {
        System.out.println("[Add]     Add a new cat");
        System.out.println("[Remove]  Remove a cat by ID");
        System.out.println("[Play]    Play with a cat by ID");
        System.out.println("[Feed]    Feed a cat by ID");
        System.out.println("[Heal]    Heal a cat by ID");
        System.out.println("[Sleep]   Skip a one day till morning");
        System.out.println("[Close]   Close this menu");
    }

    private String normalizeInput(String input) {
        return input.toLowerCase(Locale.ROOT).strip();
    }

    private String tryReadString() {
        try {
            return normalizeInput(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

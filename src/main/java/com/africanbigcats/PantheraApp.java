package com.africanbigcats;

import java.util.*;

/**
 * PantheraApp — African Big Cats Tracking Application
 * ---------------------------------------------------- Controls menu interaction and cat
 * management.
 */
public class PantheraApp {

    public static void main(String[] args) {

        Menu appMenu = new Menu();
        LinkedList<Panthera> catList = new LinkedList<>();
        char command = '_';

        System.out.println("------------------------------------------------------------");
        System.out.println("Welcome to the African Big Cats Tracker!");
        System.out.println("------------------------------------------------------------");

        // loop until user quits
        while (command != 'q') {

            appMenu.print();

            System.out.print("Enter a command: ");
            command = appMenu.getCommand();

            try {
                appMenu.executeCommand(command, catList);
            } catch (Exception e) {
                System.out.println("⚠️  Error executing command: " + e.getMessage());
            }

            // simulate cats updating their GPS coordinates
            appMenu.update(catList);
        }

        System.out.println("👋 Exiting African Big Cats App. Goodbye!");
    }
}

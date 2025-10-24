package com.africanbigcats;

import java.util.*;

/*
 * Menu class for the African Big Cat App
 */
public class Menu {

    // attributes
    private Scanner input;

    // constructor
    public Menu() {
        // initialize attributes
        this.input = new Scanner(System.in);
    }

    // prints the menu
    public void print() {
        printLine();
        System.out.println("African Big Cats App");
        printLine();

        printCommand('c', "[C]reates a big cat");
        printCommand('d', "[D]eletes a big cat");
        printCommand('f', "[F]inds a big cat");
        printCommand('l', "[L]ists all big Cats");
        printCommand('r', "[R]isk report");
        printCommand('w', "[W]arning report");
        printCommand('q', "[Q]uits");

        printLine();
    }

    private static void printLine() {
        System.out.println("----------------------------------------------------------");
    }

    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // get first character from input
    public Character getCommand() {
        Character command = '_';
        String rawInput = input.nextLine();

        if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
        }

        return command;
    }

    // command switch
    public Boolean executeCommand(Character command, LinkedList<Panthera> catList) {
        Boolean success = true;

        switch (command) {
            case 'c':
                executeCreate(catList);
                break;

            case 'd':
                executeDelete(catList);
                break;

            case 'f':
                executeFind(catList);
                break;

            case 'l':
                executeList(catList);
                break;

            case 'r':
                executeRiskReport(catList);
                break;

            case 'w':
                executeWarningReport(catList);
                break;

            case 'q':
                executeQuit();
                break;

            default:
                System.out.println("ERROR: Unknown command");
                success = false;
        }

        return success;
    }

    // update the position of all the cats
    public void update(LinkedList<Panthera> catList) {
        for (Panthera cat : catList) {
            cat.move();
        }
    }

    // quit the app
    public void executeQuit() {
        input.close();
        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();
    }

    public Panthera getNewCat(String name) {
        System.out.println("Enter a 1 for Tiger, 2 for Lion, 3 for Jaguar: ");
        String choice = input.nextLine().trim();

        switch (choice) {
            case "1":
                return new Tiger(name);
            case "2":
                return new Lion(name);
            case "3":
                return new Jaguar(name);
            default:
                System.out.println("Invalid selection. Defaulting to Tiger.");
                return new Tiger(name);
        }
    }

    // create a cat, if it's unique
    public void executeCreate(LinkedList<Panthera> catList) {
        System.out.println();
        System.out.print("Enter a name for the big cat to create: ");
        String name = input.nextLine();
        System.out.println();

        for (Panthera cat : catList) {
            if (cat.name().equalsIgnoreCase(name)) {
                System.out.println("ERROR: A cat with that name already exists.");
                return;
            }
        }

        Panthera cat = getNewCat(name);
        catList.add(cat);
        System.out.println("STATUS: " + cat.name() + " has been added.");
    }

    // delete a cat by name
    public void executeDelete(LinkedList<Panthera> catList) {
        System.out.println();
        System.out.print("Enter the name of the cat to delete: ");
        String name = input.nextLine();
        System.out.println();

        Iterator<Panthera> iterator = catList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Panthera cat = iterator.next();
            if (cat.name().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
                System.out.println("Deleted " + name);
                break;
            }
        }

        if (!found) {
            System.out.println("No cat found with that name.");
        }
    }

    // find a cat by partial or full name
    public void executeFind(LinkedList<Panthera> catList) {
        System.out.println();
        System.out.print("Enter a name or part of a name to find: ");
        String search = input.nextLine().toLowerCase();
        System.out.println();

        boolean found = false;

        for (Panthera cat : catList) {
            if (cat.name().toLowerCase().contains(search)) {
                System.out.println(cat);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cats found matching that name.");
        }
    }

    // list all big cats
    public void executeList(LinkedList<Panthera> catList) {
        System.out.println();
        printLine();
        System.out.println("African Big Cat List");
        printLine();

        if (catList.size() > 0) {
            for (Panthera cat : catList) {
                System.out.println(cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }

        System.out.println();
    }

    // RISK REPORT - show distance between two cats
    public void executeRiskReport(LinkedList<Panthera> catList) {
        if (catList.size() < 2) {
            System.out.println("Need at least two cats to calculate risk report.");
            return;
        }

        System.out.println();
        printLine();
        System.out.println("African Big Cats Risk Report");
        printLine();

        System.out.print("Enter the first cat’s name: ");
        String name1 = input.nextLine().trim().toLowerCase();
        System.out.print("Enter the second cat’s name: ");
        String name2 = input.nextLine().trim().toLowerCase();

        Panthera cat1 = null, cat2 = null;

        for (Panthera cat : catList) {
            if (cat.name().toLowerCase().equals(name1))
                cat1 = cat;
            if (cat.name().toLowerCase().equals(name2))
                cat2 = cat;
        }

        if (cat1 == null || cat2 == null) {
            System.out.println("One or both cats not found.");
            return;
        }

        double dx = cat1.longitude() - cat2.longitude();
        double dy = cat1.latitude() - cat2.latitude();
        double distance = Math.sqrt(dx * dx + dy * dy);

        System.out.println("{ name: " + cat1.name() + ", species: " + cat1.species()
                + ", longitude: " + cat1.longitude() + ", latitude: " + cat1.latitude()
                + ", weight: " + cat1.weight() + ", speed: " + cat1.speed() + ", fur: " + cat1.fur()
                + " }");

        System.out.println("{ name: " + cat2.name() + ", species: " + cat2.species()
                + ", longitude: " + cat2.longitude() + ", latitude: " + cat2.latitude()
                + ", weight: " + cat2.weight() + ", speed: " + cat2.speed() + ", fur: " + cat2.fur()
                + " }");

        System.out.printf("\nThe distance between %s and %s is %.2f\n", cat1.name(), cat2.name(),
                distance);
        System.out.println();
    }

    // WARNING REPORT - find the closest cat to user coordinates
    public void executeWarningReport(LinkedList<Panthera> catList) {
        if (catList.isEmpty()) {
            System.out.println("There are no cats to check.");
            return;
        }

        System.out.print("\nEnter your current longitude: ");
        float userLon = Float.parseFloat(input.nextLine());
        System.out.print("Enter your current latitude: ");
        float userLat = Float.parseFloat(input.nextLine());

        Panthera closest = null;
        double minDistance = Double.MAX_VALUE;

        for (Panthera cat : catList) {
            double dx = userLon - cat.longitude();
            double dy = userLat - cat.latitude();
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance < minDistance) {
                minDistance = distance;
                closest = cat;
            }
        }

        if (closest != null) {
            System.out.println();
            printLine();
            System.out.println("African Big Cats Warning Report");
            printLine();

            System.out.println("{ name: " + closest.name() + ", species: " + closest.species()
                    + ", longitude: " + closest.longitude() + ", latitude: " + closest.latitude()
                    + ", weight: " + closest.weight() + ", speed: " + closest.speed() + ", fur: "
                    + closest.fur() + " }");

            System.out.printf("\nThe closest cat is %s which is at a distance of %.2f\n",
                    closest.name(), minDistance);
            System.out.println();
        }
    }
}

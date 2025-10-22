package com.africanbigcats;

import java.util.*;

/*
 * Menu class for the african big cat app
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

        /*
         * TIP: In this area of the code, the additional commands need to be created and added to
         * the menu.
         */

        printCommand('c', "[C]reates a big cat");
        printCommand('d', "[D]eletes a big cat");
        printCommand('f', "[F]inds a big cat");
        printCommand('l', "[L]ists all big Cats");
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

        /*
         * TIP: In this area of the code, the additional commands need to be created and added.
         */

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

            case 'q':
                executeQuit();
                break;

            default:
                System.out.println("ERROR: Unknown commmand");
                success = false;
        }

        return success;
    }

    // update the position of all the cats
    public void update(LinkedList<Panthera> catList) {

        // update by moving all the cats
        for (Panthera cat : catList) {
            cat.move();
        }

    }

    // quit the app
    public void executeQuit() {

        // close the scannner
        input.close();

        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();

    }

    public Panthera getNewCat(String name) {

        /*
         * TIP: In this area of the code, students need to get input from the user for the type of
         * cat and create the correct type.
         * 
         * Currently, the code always create a Tiger. But, support for Lions and Jaguars also needs
         * to be added.
         */

        System.out.print("Enter the species (tiger, lion, jaguar): ");
        String type = input.nextLine().toLowerCase();

        Panthera result;

        if (type.equals("tiger")) {
            result = new Tiger(name);
        } else if (type.equals("lion")) {
            result = new Lion(name);
        } else if (type.equals("jaguar")) {
            result = new Jaguar(name);
        } else {
            System.out.println("Invalid type. Defaulting to Tiger.");
            result = new Tiger(name);
        }

        return result;

    }

    // create a cat, if it's unique
    public void executeCreate(LinkedList<Panthera> catList) {

        // get the name
        System.out.println();
        System.out.print("Enter a name for the big cat to create: ");
        String name = input.nextLine();
        System.out.println();

        // check for duplicate cat names
        for (Panthera cat : catList) {
            if (cat.name().equalsIgnoreCase(name)) {
                System.out.println("ERROR: A cat with that name already exists.");
                return;
            }
        }

        // create new cat
        Panthera cat = getNewCat(name);
        catList.add(cat);
        System.out.println("Created " + cat.species() + " named " + cat.name());
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

        Panthera cat;
        if (catList.size() > 0) {
            for (Integer i = 0; i < catList.size(); i++) {
                cat = catList.get(i);
                System.out.println(cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }

        System.out.println();

    }

    /*
     * TIP: Additional methods and functionality need to be added to this class.
     */

}

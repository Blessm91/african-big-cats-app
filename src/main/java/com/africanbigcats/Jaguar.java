package com.africanbigcats;

/*
 * Jaguar class that extends Panthera
 */
public class Jaguar extends Panthera {

    private boolean sleepsInTrees;

    // constructor
    public Jaguar(String name) {

        // call the super-class (parent) to instantiate it
        super(name);

        // initialize attributes
        this.setSpecies("jaguar");
        this.sleepsInTrees = true;

    }

    // serializes attributes into a string
    @Override
    public String toString() {
        String s;

        // return a JSON formatted string
        s = "{ ";
        s += "name: " + name();
        s += ", ";
        s += "species: " + species();
        s += ", ";
        s += "longitude: " + longitude();
        s += ", ";
        s += "latitude: " + latitude();
        s += ", ";
        s += "fur: " + fur();
        s += ", ";
        s += "sleepsInTrees: " + sleepsInTrees();
        s += " }";

        return s;
    }

    public String fur() {
        return "spots";
    }

    public boolean sleepsInTrees() {
        return sleepsInTrees;
    }
}

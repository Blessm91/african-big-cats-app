package com.africanbigcats;

/*
 * Lion class that extends Panthera
 */
public class Lion extends Panthera {

    // constructor
    public Lion(String name) {

        // call the super-class (parent) to instantiate it
        super(name);

        // initialize attributes
        this.setSpecies("lion");

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
        s += " }";

        return s;
    }

    public String fur() {
        return "mane";
    }
}

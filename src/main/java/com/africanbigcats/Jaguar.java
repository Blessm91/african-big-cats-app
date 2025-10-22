package com.africanbigcats;

/*
 * Jaguar class that extends Panthera
 */
public class Jaguar extends Panthera {

    // additional attribute
    private boolean sleepsInTrees;

    // constructor
    public Jaguar(String name) {

        // call the super-class (parent) to instantiate it
        super(name);

        // initialize attributes
        this.setSpecies("jaguar");
        this.sleepsInTrees = true;
    }

    // returns what type of fur this species has
    public String fur() {
        return "spots";
    }

    // returns true if the jaguar sleeps in trees
    public boolean sleepsInTrees() {
        return sleepsInTrees;
    }

    // serializes attributes into a JSON formatted string
    @Override
    public String toString() {

        // since the object is complex, we return a JSON formatted string
        String s;
        s = "{ ";
        s += "name: " + this.name();
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += ", ";
        s += "fur: " + this.fur();
        s += ", ";
        s += "sleepsInTrees: " + this.sleepsInTrees();
        s += " }";

        return s;
    }
}

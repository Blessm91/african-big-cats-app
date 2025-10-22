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

    // returns what type of fur this species has
    public String fur() {
        return "mane";
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
        s += " }";

        return s;
    }
}

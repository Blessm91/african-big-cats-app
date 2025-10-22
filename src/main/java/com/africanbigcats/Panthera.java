package com.africanbigcats;

/*
 * Panthera base class that simulates GPS information
 */
public class Panthera extends PantheraGPS {

    /*
     * TIP: Students will need to add additional attributes and methods to complete this class's
     * implementation.
     */

    // constructor
    public Panthera(String name) {

        // call the super-class (parent) to instantiate it
        super(name);

        // initialize attributes
        this.setSpecies("panthera");

    }

    // returns what type of fur this species has (can be overridden)
    public String fur() {
        return "unknown";
    }

    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        String s;

        // since the object is complex, we return a JSON formatted string
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

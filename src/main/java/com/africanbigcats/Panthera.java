package com.africanbigcats;

/*
 * Panthera base class that simulates GPS information
 */
public class Panthera extends PantheraGPS {

    /*
     * TIP: Students will need to add additional attributes and methods to complete this class's
     * implementation.
     */

    // attributes
    private double weight;
    private double speed;

    // constructor
    public Panthera(String name) {

        // call the super-class (parent) to instantiate it
        super(name);

        // initialize attributes
        this.setSpecies("panthera");

        /*
         * TIP: The weight and speed are initialized to random values to simulate different cat
         * conditions.
         */

        this.weight = 100 + Math.random() * 500; // random weight between 100–600 lbs
        this.speed = 5 + Math.random() * 45; // random speed between 5–50 mph
    }

    // returns what type of fur this species has (can be overridden)
    public String fur() {
        return "unknown";
    }

    // returns the random weight of the cat
    public double weight() {
        return this.weight;
    }

    // returns the random speed of the cat
    public double speed() {
        // re-randomize speed to simulate changing motion
        this.speed = 5 + Math.random() * 45;
        return this.speed;
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
        s += "weight: " + this.weight();
        s += ", ";
        s += "speed: " + String.format("%.2f", this.speed());
        s += ", ";
        s += "fur: " + this.fur();
        s += " }";

        return s;
    }

}

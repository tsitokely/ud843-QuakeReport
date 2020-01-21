package com.example.android.quakereport;

/**
 * {@link Earthquake} represents a single earthquake that happened somewhere in the world
 * Each object has 3 attributes: city, magnitude, date
 */

public class Earthquake {

    // name of the location where the earthquake happened
    private String mCity;

    //magnitude of the earthquake
    private float mMagnitude;

    //date at which the earthquake happened
    private String mDate;

    /**
     * Constructor for the earthquake object
     *
     * @param city is the city where the earthquake happened
     * @param mag  is the magnitude of the earthquake
     * @param date is the date of the earthquake event
     */
    public Earthquake(String city, float mag, String date) {
        mCity = city;
        mMagnitude = mag;
        mDate = date;
    }

    // Methods

    /**
     * Getter for the city
     */
    public String getCity() {
        return mCity;
    }

    /**
     * Getter for the magnitude
     */
    public float getMagnitude(){
        return mMagnitude;
    }

    /**
     * Getter for the date
     */
    public String getDate(){
        return mDate;
    }
}

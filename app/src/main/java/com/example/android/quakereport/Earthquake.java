package com.example.android.quakereport;

/**
 * {@link Earthquake} represents a single earthquake that happened somewhere in the world
 * Each object has 3 attributes: city, magnitude, date
 */

public class Earthquake {

    // name of the location where the earthquake happened
    private String mLocation;

    //magnitude of the earthquake
    private String mMagnitude;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *  earthquake happened
     */
    public Earthquake(String magnitude, String location, long timeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    // Methods

    /**
     * Getter for the location
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Getter for the magnitude
     */
    public String getMagnitude(){
        return mMagnitude;
    }

    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}

package com.example.android.quakereport;

/**
 * {@link Earthquake} represents a single earthquake that happened somewhere in the world
 * Each object has 3 attributes: city, magnitude, date
 */

class Earthquake {

    // name of the location where the earthquake happened
    private String mLocation;

    //magnitude of the earthquake
    private double mMagnitude;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    // name of the location where the earthquake happened
    private String mUrl;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *  earthquake happened
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
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
    public Double getMagnitude(){
        return mMagnitude;
    }

    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Getter for the url
     */
    public String getUrl() {
        return mUrl;
    }
}

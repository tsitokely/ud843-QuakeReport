package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * {@link EarthquakeAdapter} is an {@link ArrayAdapter} that can provide the layout each list
 * based on data source, which is a list of {@link Earthquake} objects.
 */
class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param Earthquakes A List of earthquake objects to display in a list
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> Earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews , the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Earthquakes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Earthquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);
        // maps id to object attributes
        TextView locationPrimaryTextView =
                (TextView) listItemView.findViewById(R.id.location_primary);
        TextView locationOffsetTextView =
                (TextView) listItemView.findViewById(R.id.location_offset);
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        String location = currentEarthquake.getLocation();
        String[] LocationArray = formatLocation(location);
        locationPrimaryTextView.setText(LocationArray[1]);
        locationOffsetTextView.setText(LocationArray[0]);
        magnitudeTextView.setText(String.valueOf(currentEarthquake.getMagnitude()));
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        String formattedTime = formatTime(dateObject);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);
        timeTextView.setText(formattedTime);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.US);
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.US);
        return timeFormat.format(dateObject);
    }

    /**
     * Return the primary location with its offset
     *
     * @return
     */
    private String[] formatLocation(String location) {
        String[] locationParts = new String[2];
        if(location.contains(",")){
            locationParts = location.split(",");
        } else {
            locationParts[1] = "Near the " + location;
            locationParts[0] = "";
        }
        locationParts[1] = locationParts[1].trim();
        locationParts[0] = locationParts[0].trim();
        return locationParts;
    }

}
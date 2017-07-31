package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by krishna on 7/3/17.
 */

public class EarthAdapter extends ArrayAdapter<Earth> {
    private static String Location_Separator = "of";

    public EarthAdapter(Context context, ArrayList<Earth> earths) {

        super(context, 0, earths);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Earth currentEarth = getItem(position);

        Double magnitude = currentEarth.getmMagnitude();

        TextView magnitudeText = (TextView) listItemView.findViewById(R.id.mag);
        String Mag = formatMag(magnitude);
        magnitudeText.setText(Mag);
        GradientDrawable magnitudeCircle =(GradientDrawable) magnitudeText.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarth.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        String originalLocation = currentEarth.getmPlace();
        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(Location_Separator)) {
            String[] parts = originalLocation.split(Location_Separator);
            primaryLocation = parts[0] + Location_Separator;
            locationOffset = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView primary = (TextView) listItemView.findViewById(R.id.primary);
        primary.setText(primaryLocation);

        TextView secondary = (TextView) listItemView.findViewById(R.id.offSet);
        secondary.setText(locationOffset);


        Date dateObject = new Date(currentEarth.getmTime());

        TextView dateText = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateText.setText(formattedDate);

        TextView timeText = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeText.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMag(Double magnitude){
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(magnitude);
        return output;
    }
    private int getMagnitudeColor(double magnitude){
        int magnitudeResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeResourceId = R.color.magnitude1;
                break;
            case 3:
                magnitudeResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeResourceId = R.color.magnitude10plus;
                break;

        }
        return ContextCompat.getColor(getContext(),magnitudeResourceId);
    }
}

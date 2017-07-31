package com.example.android.quakereport;

import static com.example.android.quakereport.R.id.date;

/**
 * Created by krishna on 7/3/17.
 */

public class Earth {

    private Double mMagnitude;
    private String mPlace;
    private long mTime;
    private String mUrl;

    public Earth(Double magnitude,String place,long time,String url){
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
        mUrl = url;
    }

    public Double getmMagnitude(){
        return mMagnitude;
    }
    public String getmPlace(){return mPlace;}
    public long getmTime(){ return mTime; }
    public String getmUrl(){return mUrl;}

}

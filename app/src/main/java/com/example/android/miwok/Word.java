package com.example.android.miwok;

import android.graphics.drawable.Drawable;

import javax.xml.transform.sax.SAXResult;

public class Word {
    // We add this because our ArrayList needed two inputs to be represented (instead of the standart one ArrayList<String>..)
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mActivityName;

    // A Constructor that accepts only the word translation
    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }
    public Word(String defaultTranslation, String miwokTranslation, String activityName) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mActivityName = activityName;
    }
    public Word(String defaultTranslation, String miwokTranslation, String activityName, int imageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mActivityName = activityName;
        mImageResourceId = imageResourceId;
    }
    /*

    }
    */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getActivityName(){
        return mActivityName;
    }

}
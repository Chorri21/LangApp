package com.example.android.miwok;

import android.graphics.drawable.Drawable;

public class Word {
    // We add this because our ArrayList needed two inputs to be represented (instead of the standart one ArrayList<String>..)
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageDrawable;

    public Word(String defaultTranslation, String miwokTranslation, int imageDrawable){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageDrawable = imageDrawable;
    }
    /*
    public Image(){
        mImageName = imageName;

    }
    */
    public String getDefaultTranslation(){

        return mDefaultTranslation;
    }
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;

    }
    public int getImageDrawable(){
        return mImageDrawable;
    }
}

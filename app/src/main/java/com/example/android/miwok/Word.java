package com.example.android.miwok;

public class Word {
    // We add this because our ArrayList needed two inputs to be represented (instead of the standart one ArrayList<String>..)
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation(){

        return mDefaultTranslation;
    }
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;

    }
}

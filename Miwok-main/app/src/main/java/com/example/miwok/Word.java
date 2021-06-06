package com.example.miwok;
//It contains default translation and miwok translation
public class Word {
    private String mDefaultTranslation;//member variable declaration
    private String mMiwokTranslation;//member variable declaration
    private int  mImageResourceId = N0_IMAGE_PRIVIDED;//member variable declaration.This will get upgraded if there is an image
    public static final int N0_IMAGE_PRIVIDED = -1;//-1 is choosen as it is different from all img visibillity values i.e 0,4,8
    private int mAudioResourceId;
    //creating a new coustom constructor for phrases
    public Word(String defaultTranslation,String miwokTranslation,int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }
    //creating a constructor
    public Word(String defaultTranslation,String miwokTranslation,int mimageResourseId,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = mimageResourseId;
        mAudioResourceId = audioResourceId;
    }
    //get default translation of a word
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    //get miwok translation of a word
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }//get miwok imageid
    public int getImageResourceId(){
        return mImageResourceId;
    }
    //provides if image is there or not for the view
    public boolean hasImage(){
        return mImageResourceId != N0_IMAGE_PRIVIDED;
    }//provides audio files
    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}

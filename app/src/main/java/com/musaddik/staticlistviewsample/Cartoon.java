package com.musaddik.staticlistviewsample;

public class Cartoon {
    private String mName;
    private String mAbout;
    private int mPicRes;

    public Cartoon(String name, int picRes, String about) {
        mName = name;
        mPicRes = picRes;
        mAbout = about;
    }

    public String getName() {
        return mName;
    }

    public int getPicRes() {
        return mPicRes;
    }

    public String getAbout() {
        return mAbout;
    }

}


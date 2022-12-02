package com.example.finalpro;

public class ChickenRecyclerViewItem {
    private int mImgName;
    private String mMainText;

    public ChickenRecyclerViewItem(int chickenImage, String s) {
        this.mImgName = chickenImage;
        this.mMainText = s;
    }

    public int getmImgName() {
        return mImgName;
    }

    public void setmImgName(int mImgName) {
        this.mImgName = mImgName;
    }

    public String getmMainText() {
        return mMainText;
    }

    public void setmMainText(String mMainText) {
        this.mMainText = mMainText;
    }
}

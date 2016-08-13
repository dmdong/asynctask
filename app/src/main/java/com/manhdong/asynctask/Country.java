package com.manhdong.asynctask;

import android.widget.ImageView;

/**
 * Created by Saphiro on 6/24/2016.
 */
public class Country {


    int imageView;
    String title;

    public Country() {
    }

    public Country(int imageView, String title) {
        this.imageView = imageView;
        this.title = title;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.scratch.tabbfrag;

public class BDataModel {

    boolean availability;
    String title;
    String sub;

    // TODO: Implement Methods for Loading Images from URLS into the ImageView
    public BDataModel(String categoryTitle, String category_sub){
        this.title = categoryTitle;
        this.sub = category_sub;
        this.availability = true;
    }

    public BDataModel(String categoryTitle, String category_sub, boolean availability){
        this.title = categoryTitle;
        this.sub = category_sub;
        this.availability = availability;
    }

}

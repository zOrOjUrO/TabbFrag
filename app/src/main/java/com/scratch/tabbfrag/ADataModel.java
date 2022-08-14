package com.scratch.tabbfrag;

public class ADataModel {

    String title;
    String sub;
    boolean availability;
    int mrp;
    int price;

    // TODO: Implement Methods for Loading Images from URLS into the ImageView
    public ADataModel(String productTitle, String product_sub, int mrp, int price){
            this.mrp = mrp;
            this.price = price;
            this.title = productTitle;
            this.sub = product_sub;
            this.availability = true;
    }

    public ADataModel(String productTitle, String product_sub, int mrp, int price, boolean availability){
        this.mrp = mrp;
        this.price = price;
        this.title = productTitle;
        this.sub = product_sub;
        this.availability = availability;
    }

}

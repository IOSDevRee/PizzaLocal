package com.a000webhostapp.infopizzalocal.pizzalocal;

public class GetterSetter {

    String zip;
    String city;
    String title;
    int img;
    String desc;
    String small_price;
    String medium_price;
    String large_price;
    String image;
    String size;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }




    public GetterSetter(String title, int img, String desc, String small_price, String medium_price, String large_price) {
        this.title = title;
        this.img = img;
        this.desc = desc;
        this.small_price = small_price;
        this.medium_price = medium_price;
        this.large_price = large_price;
    }

    public GetterSetter(String c_name, String i_image, String c_id, String small_price, String medium_price, String large_price) {
        this.title = c_name;
        this.image = i_image;
        this.desc = c_id;
        this.small_price = small_price;
        this.medium_price = medium_price;
        this.large_price = large_price;

    }

    public GetterSetter(String restaurant, String i_image, String city, String zip) {

        this.title = restaurant;
        this.image = i_image;
        this.city = city;
        this.zip = zip;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSmall_price() {
        return small_price;
    }

    public void setSmall_price(String small_price) {
        this.small_price = small_price;
    }

    public String getMedium_price() {
        return medium_price;
    }

    public void setMedium_price(String medium_price) {
        this.medium_price = medium_price;
    }

    public String getLarge_price() {
        return large_price;
    }

    public void setLarge_price(String large_price) {
        this.large_price = large_price;
    }


}

package com.calci.newsapp;

public class listIteam {
    private String heading;
    private  String main;
    private String ImageURL;


    public listIteam(String heading,String main,String ImageURL) {
        this.heading = heading;
        this.main = main;
        this.ImageURL=ImageURL;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}

package com.calci.newsapp;

public class ScienceList {
    private String title;
    private String description;
    private String imageURl;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ScienceList(String title, String description, String imageURl, String url) {
        this.title = title;
        this.description = description;
        this.imageURl = imageURl;
        this.url=url;

    }
}

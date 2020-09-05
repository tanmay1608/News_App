package com.calci.newsapp;

public class HealthList {
    private String title;
    private String description;
    private String ImageURL;
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

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        this.ImageURL = imageURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HealthList(String title, String description, String imageURL, String url) {
        this.title = title;
        this.description = description;
        this.ImageURL = imageURL;
        this.url=url;

    }
}

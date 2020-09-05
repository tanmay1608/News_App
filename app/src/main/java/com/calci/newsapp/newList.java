package com.calci.newsapp;

public class newList  {
    private String title;
    private String description;
    private String imageURL;
    private String url;

    public newList(String title, String description, String imageURL,String url) {
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
        this.url=url;
    }

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
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        imageURL = imageURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

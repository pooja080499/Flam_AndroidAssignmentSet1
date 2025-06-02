package com.bookreviewapp;

public class Book {
    private int id;
    private String title;
    private String author;
    private String description;
    private String thumbnailUrl;
    private double rating;
    private boolean isFavorite;

    // Empty constructor (required for database)
    public Book() {}

    // Constructor with all fields
    public Book(int id, String title, String author, String description,
                String thumbnailUrl, double rating, boolean isFavorite) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
        this.isFavorite = isFavorite;
    }

    // Getters and Setters (these let other parts of app access the data)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}

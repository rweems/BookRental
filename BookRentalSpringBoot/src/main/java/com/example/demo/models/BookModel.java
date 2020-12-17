package com.example.demo.models;


public class BookModel {

    private long id;
    private String title;
    private long publishYear;
    private String author;
    private String publisher;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
//    public BookModel(String title, long publishYear, String author, int numOfPages) {
//        this.title = title;
//        this.publishYear = publishYear;
//        this.author = author;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishYear(long publishYear) {
        this.publishYear = publishYear;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public long getPublishYear() {
        return publishYear;
    }

    public String getAuthor() {
        return author;
    }


    @Override
    public String toString() {
        return "BookModel{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}

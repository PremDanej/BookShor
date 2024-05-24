package com.merp.my.book.shor.app.model;

public class BookDetail {

    private Integer bookId;
    private String bookName;
    private String authorName;
    private String price;
    private String description;
    private String contact;
    private byte[] image;

    public BookDetail() {
    }

    public BookDetail(String bookName, String authorName, String price, String description, String contact, byte[] image) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
        this.description = description;
        this.contact = contact;
        this.image = image;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

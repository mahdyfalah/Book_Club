package model;

import java.util.Date;

public class Book {
    private String isbn;
    private String title;
    private String publisher;
    private Date release_date;

    public Book() {
    }

    public Book(String isbn, String title, String publisher, Date release_date) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.release_date = release_date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", release_date=" + release_date +
                '}';
    }
}

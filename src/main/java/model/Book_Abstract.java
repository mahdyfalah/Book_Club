package model;

public class Book_Abstract {
    private int book_abstract_id;
    private String details;
    private String parental_advisory;

    public Book_Abstract() {
    }

    public Book_Abstract(int book_abstract_id, String details, String parental_advisory) {
        this.book_abstract_id = book_abstract_id;
        this.details = details;
        this.parental_advisory = parental_advisory;
    }

    public int getBook_abstract_id() {
        return book_abstract_id;
    }

    public void setBook_abstract_id(int book_abstract_id) {
        this.book_abstract_id = book_abstract_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getParental_advisory() {
        return parental_advisory;
    }

    public void setParental_advisory(String parental_advisory) {
        this.parental_advisory = parental_advisory;
    }

    @Override
    public String toString() {
        return "Book_Abstract{" +
                "book_abstract_id=" + book_abstract_id +
                ", details='" + details + '\'' +
                ", parental_advisory='" + parental_advisory + '\'' +
                '}';
    }
}

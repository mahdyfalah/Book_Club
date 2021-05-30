package model;

import java.util.Date;

public class Rate {
    private String rating_ID;
    private int rate;
    private String text_review;
    private Date rate_date;

    public Rate() {
    }

    public Rate(String rating_ID, int rate, String text_review) {
        this.rating_ID = rating_ID;
        this.rate = rate;
        this.text_review = text_review;
        this.rate_date = new Date();
    }

    public String getRating_ID() {
        return rating_ID;
    }

    public void setRating_ID(String rating_ID) {
        this.rating_ID = rating_ID;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getText_review() {
        return text_review;
    }

    public void setText_review(String text_review) {
        this.text_review = text_review;
    }

    public Date getRate_date() {
        return rate_date;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rating_ID='" + rating_ID + '\'' +
                ", rate=" + rate +
                ", text_review='" + text_review + '\'' +
                ", rate_date=" + rate_date +
                '}';
    }
}

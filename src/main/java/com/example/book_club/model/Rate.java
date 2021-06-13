package com.example.book_club.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "Rate")
public class Rate {

    @Id
    @GeneratedValue
    private int rating_id;
    private int rate;
    private String text_review;
    private String rate_date;

    public Rate() {
    }

    public Rate(int rating_id, int rate, String text_review, String rate_date) {
        this.rating_id = rating_id;
        this.rate = rate;
        this.text_review = text_review;
        this.rate_date = rate_date;
    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
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

    public String getRate_date() {
        return rate_date;
    }

    public void setRate_date(String rate_date) {
        this.rate_date = rate_date;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rating_id=" + rating_id +
                ", rate=" + rate +
                ", text_review='" + text_review + '\'' +
                ", rate_date=" + rate_date +
                '}';
    }
}

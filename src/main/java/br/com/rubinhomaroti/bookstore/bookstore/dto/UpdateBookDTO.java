package br.com.rubinhomaroti.bookstore.bookstore.dto;

import java.math.BigDecimal;

public class UpdateBookDTO {
    private String title;
    private String author;
    private Double price;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

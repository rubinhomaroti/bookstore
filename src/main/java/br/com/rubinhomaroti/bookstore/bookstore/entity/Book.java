package br.com.rubinhomaroti.bookstore.bookstore.entity;

import br.com.rubinhomaroti.bookstore.bookstore.dto.BookDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 16)
    private String isbn;

    @Column(nullable = false, length = 80)
    private String title;

    @Column(nullable = false, length = 80)
    private String author;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, name = "published_at")
    private Date publishedAt;

    public Book() {
    }

    public Book(BookDTO newBookDTO) {
        this.isbn = newBookDTO.getIsbn();
        this.title = newBookDTO.getTitle();
        this.author = newBookDTO.getAuthor();
        this.price = newBookDTO.getPrice();
        this.publishedAt = newBookDTO.getPublishedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
}

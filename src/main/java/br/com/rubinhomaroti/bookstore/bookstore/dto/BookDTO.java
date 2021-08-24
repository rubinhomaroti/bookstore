package br.com.rubinhomaroti.bookstore.bookstore.dto;

import br.com.rubinhomaroti.bookstore.bookstore.entity.Book;

import java.util.Date;

/* DTO - Data Transfer Object
- Representa o objeto que será mapeado entre as requisições
- Deve seguir o padrão Java Beans utilizando getters e setters para ocorrer a serialização e deserialização do objeto corretamente
*/

public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private Double price;
    private Date publishedAt;

    public BookDTO() {}

    public BookDTO(Book book) {
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        this.publishedAt = book.getPublishedAt();
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

    public Date getPublishedAt() { return publishedAt; }

    public void setPublishedAt(Date publishedAt) { this.publishedAt = publishedAt; }
}

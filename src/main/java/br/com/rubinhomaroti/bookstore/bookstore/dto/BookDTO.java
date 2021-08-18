package br.com.rubinhomaroti.bookstore.bookstore.dto;

import java.math.BigDecimal;

/* DTO - Data Transfer Object
- Representa o objeto que será mapeado entre as requisições
- Deve seguir o padrão Java Beans utilizando getters e setters para ocorrer a serialização e deserialização do objeto corretamente
*/

public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private BigDecimal price;


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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

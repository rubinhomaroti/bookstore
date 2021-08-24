package br.com.rubinhomaroti.bookstore.bookstore.dto;

import java.math.BigDecimal;

public class UpdateBookPriceDTO {
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

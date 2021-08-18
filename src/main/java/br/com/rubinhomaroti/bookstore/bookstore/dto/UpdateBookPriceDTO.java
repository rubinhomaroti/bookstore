package br.com.rubinhomaroti.bookstore.bookstore.dto;

import java.math.BigDecimal;

public class UpdateBookPriceDTO {
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

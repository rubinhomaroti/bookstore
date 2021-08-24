package br.com.rubinhomaroti.bookstore.bookstore.service;

import br.com.rubinhomaroti.bookstore.bookstore.dto.BookDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UpdateBookDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UpdateBookPriceDTO;

import java.util.List;

public interface BookstoreService {
    List<BookDTO> listBooks(String title, String author);
    BookDTO findById(Long id);
    BookDTO createBook(BookDTO newBookDTO);
    BookDTO updateBook(Long id, UpdateBookDTO newBookDTO);
    BookDTO updatePrice(Long id, UpdateBookPriceDTO newBook);
    void deleteBook(Long id);
}

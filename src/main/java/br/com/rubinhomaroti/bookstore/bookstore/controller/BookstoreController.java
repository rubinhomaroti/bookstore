package br.com.rubinhomaroti.bookstore.bookstore.controller;

import br.com.rubinhomaroti.bookstore.bookstore.dto.BookDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UpdateBookDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UpdateBookPriceDTO;
import br.com.rubinhomaroti.bookstore.bookstore.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livros") // Nome de recursos sempre no plural
public class BookstoreController {

    private BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping
    public List<BookDTO> getBooks(
            @RequestParam(required = false, value = "titulo") String title) {
        return bookstoreService.listBooks(title);
    }

    @GetMapping("{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookstoreService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody BookDTO newBook) {
        return bookstoreService.createBook(newBook);
    }

    @PutMapping("{id}")
    public BookDTO updateBook(
            @RequestBody UpdateBookDTO newBook,
            @PathVariable Long id) {
        return bookstoreService.updateBook(id, newBook);
    }

    @PatchMapping("{id}")
    public BookDTO updateBookPrice(
            @RequestBody UpdateBookPriceDTO newPrice,
            @PathVariable Long id) {
        return bookstoreService.updatePrice(id, newPrice);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookstoreService.deleteBook(id);
    }
}

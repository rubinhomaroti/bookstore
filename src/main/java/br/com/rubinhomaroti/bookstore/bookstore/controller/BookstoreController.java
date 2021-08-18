package br.com.rubinhomaroti.bookstore.bookstore.controller;

import br.com.rubinhomaroti.bookstore.bookstore.dto.BookDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UpdateBookDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UpdateBookPriceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros") // Nome de recursos sempre no plural
public class BookstoreController {
    // Mock funcional para testar o CRUD
    private List<BookDTO> bookDTOList;

    public BookstoreController() {
        // Inicialização do Mock
        BookDTO l1 = new BookDTO();
        l1.setIsbn("111");
        l1.setTitle("Ensaio sobre a cegueira");
        l1.setAuthor("José Saramago");
        l1.setPrice(BigDecimal.valueOf(39.90));

        BookDTO l2 = new BookDTO();
        l2.setIsbn("222");
        l2.setTitle("1984");
        l2.setAuthor("George Orwell");
        l2.setPrice(BigDecimal.valueOf(29.90));

        BookDTO l3 = new BookDTO();
        l3.setIsbn("333");
        l3.setTitle("A volta ao mundo em 80 dias");
        l3.setAuthor("Jules Verne");
        l3.setPrice(BigDecimal.valueOf(39.90));

        bookDTOList = new ArrayList<>();
        bookDTOList.add(l1);
        bookDTOList.add(l2);
        bookDTOList.add(l3);
    }

    @GetMapping
    public List<BookDTO> getBooks(
            @RequestParam(required = false, value = "titulo") String title,
            @RequestParam(required = false, value = "autor") String author) {
        return bookDTOList
                .stream()
                .filter(dto -> title == null || dto.getTitle().toUpperCase(Locale.ROOT).contains(title.toUpperCase(Locale.ROOT)))
                .filter(dto -> author == null || dto.getAuthor().toUpperCase(Locale.ROOT).contains(author.toUpperCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    @GetMapping("{isbn}")
    public BookDTO getBookByIsbn(@PathVariable String isbn) {
        return findBookByIsbn(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody BookDTO newBook) {
        bookDTOList.add(newBook);
        return newBook;
    }

    @PutMapping("{isbn}")
    public BookDTO updateBook(
            @RequestBody UpdateBookDTO newBook,
            @PathVariable String isbn) {
        BookDTO existingBook = findBookByIsbn(isbn);
        existingBook.setTitle(newBook.getTitle());
        existingBook.setAuthor(newBook.getAuthor());
        existingBook.setPrice(newBook.getPrice());
        return existingBook;
    }

    @PatchMapping("{isbn}")
    public BookDTO updateBookPrice(
            @RequestBody UpdateBookPriceDTO newPrice,
            @PathVariable String isbn) {
        BookDTO existingBook = findBookByIsbn(isbn);
        existingBook.setPrice((newPrice.getPrice()));
        return existingBook;
    }

    @DeleteMapping("{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        BookDTO existingBook = findBookByIsbn(isbn);
        bookDTOList.remove(existingBook);
    }

    private BookDTO findBookByIsbn(String isbn) {
        return bookDTOList
                .stream()
                .filter(dto -> dto.getIsbn().toUpperCase(Locale.ROOT).equals(isbn.toUpperCase(Locale.ROOT)))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

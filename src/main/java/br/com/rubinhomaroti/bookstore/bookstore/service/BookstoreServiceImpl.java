package br.com.rubinhomaroti.bookstore.bookstore.service;

import br.com.rubinhomaroti.bookstore.bookstore.dto.BookDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UpdateBookDTO;
import br.com.rubinhomaroti.bookstore.bookstore.dto.UpdateBookPriceDTO;
import br.com.rubinhomaroti.bookstore.bookstore.entity.Book;
import br.com.rubinhomaroti.bookstore.bookstore.repository.BookstoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookstoreServiceImpl implements BookstoreService {
    private BookstoreRepository bookstoreRepository;

    public BookstoreServiceImpl(BookstoreRepository bookstoreRepository) {
        this.bookstoreRepository = bookstoreRepository;
    }

    @Override
    public List<BookDTO> listBooks(String title, String author) {
        if (title == null) {
            title = "";
        }

        if (author == null) {
            author = "";
        }

        List<Book> books = bookstoreRepository.findAllByTitleLikeOrAuthorLike(title, author);
        return books.stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findById(Long id) {
        return new BookDTO(this.findBookById(id));
    }

    @Override
    public BookDTO createBook(BookDTO newBookDTO) {
        Book newBook = new Book(newBookDTO);
        Book newBookSaved = bookstoreRepository.save(newBook);
        return new BookDTO(newBookSaved);
    }

    @Override
    public BookDTO updateBook(Long id, UpdateBookDTO newBookDTO) {
        Book book = findBookById(id);
        book.setTitle(newBookDTO.getTitle());
        book.setAuthor(newBookDTO.getAuthor());
        book.setPrice(newBookDTO.getPrice());
        Book savedBook = bookstoreRepository.save(book);
        return new BookDTO(savedBook);
    }

    @Override
    public BookDTO updatePrice(Long id, UpdateBookPriceDTO newBook) {
        Book book = findBookById(id);
        book.setPrice(newBook.getPrice());
        Book savedBook = bookstoreRepository.save(book);
        return new BookDTO(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = findBookById(id);
        bookstoreRepository.delete(book);
    }

    private Book findBookById(Long id) {
        return bookstoreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

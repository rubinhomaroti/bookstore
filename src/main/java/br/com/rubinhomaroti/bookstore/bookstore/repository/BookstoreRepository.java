package br.com.rubinhomaroti.bookstore.bookstore.repository;

import br.com.rubinhomaroti.bookstore.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookstoreRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleLikeOrAuthorLike(String title, String author);

    // Mesma função do método acima, apenas exemplficando como seria utilizando direct query
    @Query("select b from Book b where b.title like :title or b.author like :author")
    List<Book> findBooksByTitleOrAuthor(String title, String author);
}

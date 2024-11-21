package domain.ports.in.book;

import domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface GetBookUseCase {
    Optional<Book> getBookById(Integer id);
    List<Book> getAllBooks();
}

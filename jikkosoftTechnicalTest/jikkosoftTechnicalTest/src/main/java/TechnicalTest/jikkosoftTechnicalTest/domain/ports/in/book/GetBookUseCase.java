package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.book;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface GetBookUseCase {
    Optional<Book> getBookById(Integer id);
    List<Book> getAllBooks();
}

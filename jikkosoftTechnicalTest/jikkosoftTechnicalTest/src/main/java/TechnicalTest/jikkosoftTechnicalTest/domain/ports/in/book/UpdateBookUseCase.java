package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.book;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;

import java.util.Optional;

public interface UpdateBookUseCase {
    Optional<Book> updateBook(Integer id, Book book);
}

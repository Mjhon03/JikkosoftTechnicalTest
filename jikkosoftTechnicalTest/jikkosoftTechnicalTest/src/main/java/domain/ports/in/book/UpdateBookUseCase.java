package domain.ports.in.book;

import domain.models.Book;

import java.util.Optional;

public interface UpdateBookUseCase {
    Optional<Book> updateBook(Integer id, Book book);
}

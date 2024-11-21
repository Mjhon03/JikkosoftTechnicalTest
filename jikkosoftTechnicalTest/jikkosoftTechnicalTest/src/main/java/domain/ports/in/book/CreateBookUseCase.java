package domain.ports.in.book;

import domain.models.Book;

public interface CreateBookUseCase {
    Book createBook(Book book);
}

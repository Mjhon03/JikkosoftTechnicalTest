package domain.ports.in.bookReserve;

import domain.models.BookReserve;

import java.util.Optional;

public interface UpdateBookReserveUseCase {
    Optional<BookReserve> updateBookReserve(Integer id, BookReserve book);

}

package domain.ports.in.bookReserve;

import domain.models.BookReserve;

public interface CreateBookReserveUseCase {
    BookReserve createBookReserve(BookReserve book);
}

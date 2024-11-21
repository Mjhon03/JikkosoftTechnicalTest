package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;

public interface CreateBookReserveUseCase {
    BookReserve createBookReserve(BookReserve book);
}

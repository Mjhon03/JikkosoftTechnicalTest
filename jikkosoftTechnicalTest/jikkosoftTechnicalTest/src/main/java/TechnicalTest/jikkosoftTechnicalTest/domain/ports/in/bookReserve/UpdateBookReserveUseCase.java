package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;

import java.util.Optional;

public interface UpdateBookReserveUseCase {
    Optional<BookReserve> updateBookReserve(Integer id, BookReserve book);

}

package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;

import java.util.List;
import java.util.Optional;

public interface GetBookReserveUseCase {
    Optional<BookReserve> getBookReserveById(Integer id);

    List<BookReserve> getAllBookReserves();

}

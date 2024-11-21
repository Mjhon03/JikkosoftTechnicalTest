package TechnicalTest.jikkosoftTechnicalTest.application.usecases.bookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve.GetBookReserveUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.bookReserve.BookReverseRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GetBookReserveUseCaseImp implements GetBookReserveUseCase {
    private final BookReverseRepositoryPort bookReverseRepositoryPort;

    public GetBookReserveUseCaseImp(BookReverseRepositoryPort bookReverseRepositoryPort) {
        this.bookReverseRepositoryPort = bookReverseRepositoryPort;
    }

    @Override
    public Optional<BookReserve> getBookReserveById(Integer id) {
        return bookReverseRepositoryPort.findById(id);
    }

    @Override
    public List<BookReserve> getAllBookReserves() {
        return bookReverseRepositoryPort.findAll();
    }
}

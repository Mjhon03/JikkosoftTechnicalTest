package TechnicalTest.jikkosoftTechnicalTest.application.usecases.bookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve.UpdateBookReserveUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.bookReserve.BookReverseRepositoryPort;

import java.util.Optional;

public class UpdateBookReserveUseCaseImp implements UpdateBookReserveUseCase {
    private final BookReverseRepositoryPort bookReverseRepositoryPort;

    public UpdateBookReserveUseCaseImp(BookReverseRepositoryPort bookReverseRepositoryPort) {
        this.bookReverseRepositoryPort = bookReverseRepositoryPort;
    }

    @Override
    public Optional<BookReserve> updateBookReserve(Integer id, BookReserve book) {
        return bookReverseRepositoryPort.findById(id);
    }
}

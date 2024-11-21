package TechnicalTest.jikkosoftTechnicalTest.application.usecases.bookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve.CreateBookReserveUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.bookReserve.BookReverseRepositoryPort;

public class CreateBookReserveUseCaseImp implements CreateBookReserveUseCase {

    private final BookReverseRepositoryPort  bookReverseRepositoryPort;

    public CreateBookReserveUseCaseImp(BookReverseRepositoryPort bookReverseRepositoryPort) {
        this.bookReverseRepositoryPort = bookReverseRepositoryPort;
    }

    @Override
    public BookReserve createBookReserve(BookReserve bookReserve) {
        return bookReverseRepositoryPort.save(bookReserve);
    }
}

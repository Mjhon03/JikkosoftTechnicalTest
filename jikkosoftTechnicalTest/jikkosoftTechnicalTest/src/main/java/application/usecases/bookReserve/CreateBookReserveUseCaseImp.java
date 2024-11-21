package application.usecases.bookReserve;

import domain.models.BookReserve;
import domain.ports.in.bookReserve.CreateBookReserveUseCase;
import domain.ports.out.bookReserve.BookReverseRepositoryPort;

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

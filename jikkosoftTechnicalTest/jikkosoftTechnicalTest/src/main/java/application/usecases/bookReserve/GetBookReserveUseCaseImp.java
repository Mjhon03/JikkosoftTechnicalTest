package application.usecases.bookReserve;

import domain.models.BookReserve;
import domain.ports.in.bookReserve.GetBookReserveUseCase;
import domain.ports.out.bookReserve.BookReverseRepositoryPort;

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

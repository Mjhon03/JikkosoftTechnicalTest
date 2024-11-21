package TechnicalTest.jikkosoftTechnicalTest.application.usecases.bookReserve;

import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve.DeleteBookReserveUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.bookReserve.BookReverseRepositoryPort;

public class DeleteBookReserveUseCaseImp implements DeleteBookReserveUseCase {
    private final BookReverseRepositoryPort bookReverseRepositoryPort;

    public DeleteBookReserveUseCaseImp(BookReverseRepositoryPort bookReverseRepositoryPort) {
        this.bookReverseRepositoryPort = bookReverseRepositoryPort;
    }

    @Override
    public Boolean deleteBookReserveById(Integer id) {
        return bookReverseRepositoryPort.deleteById(id);
    }
}

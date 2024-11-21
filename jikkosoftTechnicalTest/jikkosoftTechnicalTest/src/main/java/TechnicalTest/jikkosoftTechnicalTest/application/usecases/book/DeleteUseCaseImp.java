package TechnicalTest.jikkosoftTechnicalTest.application.usecases.book;

import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.book.DeleteBookUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.book.BookRepositoryPort;

public class DeleteUseCaseImp implements DeleteBookUseCase {
    private final BookRepositoryPort bookRepositoryPort;

    public DeleteUseCaseImp(BookRepositoryPort BookRepositoryPort) {
        this.bookRepositoryPort = BookRepositoryPort;
    }

    @Override
    public Boolean deleteBookById(Integer id) { return bookRepositoryPort.deleteById(id); }

}

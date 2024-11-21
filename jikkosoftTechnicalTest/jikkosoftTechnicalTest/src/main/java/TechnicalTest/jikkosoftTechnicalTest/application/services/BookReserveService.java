package TechnicalTest.jikkosoftTechnicalTest.application.services;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve.CreateBookReserveUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve.DeleteBookReserveUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve.GetBookReserveUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.bookReserve.UpdateBookReserveUseCase;

import java.util.List;
import java.util.Optional;

public class BookReserveService implements GetBookReserveUseCase, CreateBookReserveUseCase, UpdateBookReserveUseCase, DeleteBookReserveUseCase {

    private final GetBookReserveUseCase getBookReserveUseCase;
    private final CreateBookReserveUseCase createBookReserveUseCase;
    private final UpdateBookReserveUseCase updateBookReserveUseCase;
    private final DeleteBookReserveUseCase deleteBookReserveUseCase;

    public BookReserveService(GetBookReserveUseCase getBookReserveUseCase,CreateBookReserveUseCase createBookReserveUseCase, UpdateBookReserveUseCase updateBookReserveUseCase, DeleteBookReserveUseCase deleteBookReserveUseCase ) {
        this.getBookReserveUseCase = getBookReserveUseCase;
        this.createBookReserveUseCase = createBookReserveUseCase;
        this.updateBookReserveUseCase = updateBookReserveUseCase;
        this.deleteBookReserveUseCase = deleteBookReserveUseCase;
    }


    @Override
    public BookReserve createBookReserve(BookReserve book) {
        return createBookReserveUseCase.createBookReserve(book);
    }

    @Override
    public Boolean deleteBookReserveById(Integer id) {
        return deleteBookReserveUseCase.deleteBookReserveById(id);
    }

    @Override
    public Optional<BookReserve> getBookReserveById(Integer id) {
        return getBookReserveUseCase.getBookReserveById(id);
    }

    @Override
    public List<BookReserve> getAllBookReserves() {
        return getBookReserveUseCase.getAllBookReserves();
    }

    @Override
    public Optional<BookReserve> updateBookReserve(Integer id, BookReserve book) {
        return updateBookReserveUseCase.updateBookReserve(id, book);
    }
}

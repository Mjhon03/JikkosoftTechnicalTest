package application.services;

import domain.models.BookReserve;
import domain.ports.in.bookReserve.CreateBookReserveUseCase;
import domain.ports.in.bookReserve.DeleteBookReserveUseCase;
import domain.ports.in.bookReserve.GetBookReserveUseCase;
import domain.ports.in.bookReserve.UpdateBookReserveUseCase;

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

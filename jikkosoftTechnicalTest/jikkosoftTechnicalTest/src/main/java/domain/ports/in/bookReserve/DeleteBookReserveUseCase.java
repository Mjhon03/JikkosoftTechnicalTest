package domain.ports.in.bookReserve;

import domain.models.BookReserve;

public interface DeleteBookReserveUseCase {
    Boolean deleteBookReserveById(Integer id);
}

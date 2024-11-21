package infraestructure.mappers;

import domain.models.Book;
import domain.models.BookReserve;
import domain.models.User;
import infraestructure.Dto.in.BookReserveDto;
import infraestructure.Dto.in.BookReserveUpdateDto;

import java.util.List;
import java.util.stream.Collectors;

public class BookReserveMapper {

    public static BookReserveDto mapBookReserve(BookReserve bookReserve) {
        if (bookReserve == null) return null;

        return new BookReserveDto(
                bookReserve.getUser().getUserID(),
                bookReserve.getBook().getId(),
                bookReserve.getReservationDate()
        );
    }

    public static BookReserve toBookReserve(BookReserveDto bookReserveDTO) {
        if (bookReserveDTO == null) {
            return null;
        }

        return new BookReserve(
                null,
                new User(bookReserveDTO.getUser()),
                new Book(bookReserveDTO.getBook()),
                bookReserveDTO.getReservationDate()
        );
    }

    public static BookReserve toBookReserve(BookReserveUpdateDto bookReserveUpdateDTO) {
        if (bookReserveUpdateDTO == null) {
            return null;
        }

        return new BookReserve(
                bookReserveUpdateDTO.getId(),
                new User(bookReserveUpdateDTO.getUserId()),
                new Book(bookReserveUpdateDTO.getBookId()),
                bookReserveUpdateDTO.getReservationDate()
        );
    }

    public static List<BookReserveDto> toBookReserveCreationDTOList(List<BookReserve> bookReserves) {
        if (bookReserves == null) {
            return null;
        }

        return bookReserves.stream()
                .map(BookReserveMapper::mapBookReserve)
                .collect(Collectors.toList());
    }


    public static List<BookReserve> toBookReserveList(List<BookReserveDto> bookReserveDTOS) {
        if (bookReserveDTOS == null) {
            return null;
        }

        return bookReserveDTOS.stream()
                .map(BookReserveMapper::toBookReserve)
                .collect(Collectors.toList());
    }
}

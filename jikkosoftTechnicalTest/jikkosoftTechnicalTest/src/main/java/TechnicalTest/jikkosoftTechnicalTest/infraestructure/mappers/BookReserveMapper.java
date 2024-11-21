package TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.Book;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.BookReserveDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.BookReserveUpdateDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.out.BookReserveOutputDto;

import java.util.Collections;
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

    public static BookReserveOutputDto toOutputDto(BookReserve bookReserve) {
        if (bookReserve == null) {
            return null;
        }

        return new BookReserveOutputDto(
                bookReserve.getId(),
                bookReserve.getUser() != null ? bookReserve.getUser().getUserID() : null, // Convertimos el usuario a su ID
                bookReserve.getBook() != null ? bookReserve.getBook().getId() : null, // Convertimos el libro a su ID
                bookReserve.getReservationDate()
        );
    }

    public static List<BookReserveOutputDto> toOutputDtoList(List<BookReserve> bookReserves) {
        if (bookReserves == null || bookReserves.isEmpty()) {
            return Collections.emptyList();
        }

        return bookReserves.stream()
                .map(BookReserveMapper::toOutputDto)
                .collect(Collectors.toList());
    }
}

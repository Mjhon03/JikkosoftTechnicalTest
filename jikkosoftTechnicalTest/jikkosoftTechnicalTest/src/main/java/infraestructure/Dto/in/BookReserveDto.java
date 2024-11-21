package infraestructure.Dto.in;

import domain.models.Book;
import domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BookReserveDto {
    private Integer user;
    private Integer book;
    private LocalDate reservationDate;
}

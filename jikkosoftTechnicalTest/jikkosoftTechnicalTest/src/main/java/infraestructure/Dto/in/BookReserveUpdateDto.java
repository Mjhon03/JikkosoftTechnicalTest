package infraestructure.Dto.in;

import domain.models.Book;
import domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BookReserveUpdateDto {

    private Integer id;
    private Integer userId;
    private Integer bookId;
    private LocalDate reservationDate;
}

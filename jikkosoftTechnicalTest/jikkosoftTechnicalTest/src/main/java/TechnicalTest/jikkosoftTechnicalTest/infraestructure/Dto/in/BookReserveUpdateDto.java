package TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in;

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

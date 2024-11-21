package TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BookReserveOutputDto {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private LocalDate reservationDate;
}

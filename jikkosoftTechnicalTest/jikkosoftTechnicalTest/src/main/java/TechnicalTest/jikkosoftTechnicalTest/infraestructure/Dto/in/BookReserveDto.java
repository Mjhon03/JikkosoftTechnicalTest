package TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in;

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

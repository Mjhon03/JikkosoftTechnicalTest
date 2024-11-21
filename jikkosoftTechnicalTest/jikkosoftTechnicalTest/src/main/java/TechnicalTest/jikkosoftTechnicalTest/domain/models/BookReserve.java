package TechnicalTest.jikkosoftTechnicalTest.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookReserve {
    private Integer id;
    private User user;
    private Book book;
    private LocalDate reservationDate;
}

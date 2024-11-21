package TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class UserOutputDto {
    private Integer userId;
    private String userName;
    private String userLastName;
    private List<Integer> reservedBookIds; // IDs de las reservas de libros
}

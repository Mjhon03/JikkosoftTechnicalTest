package infraestructure.Dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserUpdateDto {
    private Integer userID;
    private String userName;
    private String UserLastName;
}

package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer userID;
    private String userName;
    private String UserLastName;
    private List<BookReserve> reservedBooks;

    public User(Integer userId){
        this.userID = userId;
    }
}

package TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_last_name", nullable = false)
    private String userLastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookReserveEntity> reservedBooks;

    public User toDomainModelWithoutBooks(){
        return new User(this.userId,  this.userName, this.userLastName, null);
    }

    public User toDomainModel(){
        return new User(this.userId, this.userName, this.userLastName,  BookReserveEntity.toDomainModelList(this.reservedBooks));
    }
}

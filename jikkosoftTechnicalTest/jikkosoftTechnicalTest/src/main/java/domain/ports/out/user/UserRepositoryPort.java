package domain.ports.out.user;

import domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);

    Optional<User> findById(Integer id);

    List<User> findAll();
    
    Boolean deleteById(Integer id);

    Optional<User> updateUser(Integer id, User user);
}

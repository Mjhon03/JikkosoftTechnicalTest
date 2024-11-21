package domain.ports.in.user;

import domain.models.User;

import java.util.List;
import java.util.Optional;

public interface GetUserUseCase {
    Optional<User> getUser(Integer id);

    List<User> getAllUsers();
}

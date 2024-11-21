package domain.ports.in.user;

import domain.models.User;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<User> updateUser(Integer id, User user);

}

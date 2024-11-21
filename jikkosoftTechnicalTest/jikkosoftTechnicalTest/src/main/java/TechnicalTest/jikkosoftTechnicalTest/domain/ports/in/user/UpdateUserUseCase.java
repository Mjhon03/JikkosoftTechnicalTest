package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<User> updateUser(Integer id, User user);

}

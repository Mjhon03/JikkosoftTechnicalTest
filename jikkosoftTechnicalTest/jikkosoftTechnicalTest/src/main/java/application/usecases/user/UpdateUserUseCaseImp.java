package application.usecases.user;

import domain.models.User;
import domain.ports.in.user.UpdateUserUseCase;
import domain.ports.out.user.UserRepositoryPort;

import java.util.Optional;

public class UpdateUserUseCaseImp implements UpdateUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCaseImp(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> updateUser(Integer id, User user) {
        return userRepositoryPort.updateUser(id, user);
    }
}

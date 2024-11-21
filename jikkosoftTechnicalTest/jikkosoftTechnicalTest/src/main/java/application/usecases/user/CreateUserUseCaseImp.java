package application.usecases.user;

import domain.models.User;
import domain.ports.in.user.CreateUserUseCase;
import domain.ports.out.user.UserRepositoryPort;

public class CreateUserUseCaseImp implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImp(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }
}

package TechnicalTest.jikkosoftTechnicalTest.application.usecases.user;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user.CreateUserUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.user.UserRepositoryPort;

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

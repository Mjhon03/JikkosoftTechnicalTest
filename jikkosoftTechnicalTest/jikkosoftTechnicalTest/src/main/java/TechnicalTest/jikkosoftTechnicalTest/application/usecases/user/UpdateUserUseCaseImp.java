package TechnicalTest.jikkosoftTechnicalTest.application.usecases.user;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user.UpdateUserUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.user.UserRepositoryPort;

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

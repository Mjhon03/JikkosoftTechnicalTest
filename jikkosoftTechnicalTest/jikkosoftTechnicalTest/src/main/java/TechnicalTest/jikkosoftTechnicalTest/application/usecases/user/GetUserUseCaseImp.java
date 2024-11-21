package TechnicalTest.jikkosoftTechnicalTest.application.usecases.user;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user.GetUserUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.user.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GetUserUseCaseImp implements GetUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public GetUserUseCaseImp(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.findAll();
    }
}

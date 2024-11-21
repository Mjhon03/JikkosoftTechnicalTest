package application.usecases.user;

import domain.models.User;
import domain.ports.in.user.GetUserUseCase;
import domain.ports.out.user.UserRepositoryPort;

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

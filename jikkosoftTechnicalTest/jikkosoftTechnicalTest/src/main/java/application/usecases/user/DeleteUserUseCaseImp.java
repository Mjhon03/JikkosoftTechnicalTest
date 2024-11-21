package application.usecases.user;

import domain.ports.in.user.DeleteUserUseCase;
import domain.ports.out.user.UserRepositoryPort;

public class DeleteUserUseCaseImp implements DeleteUserUseCase {

    private final UserRepositoryPort userRepository;

    public DeleteUserUseCaseImp(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return userRepository.deleteById(id);
    }
}

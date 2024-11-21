package TechnicalTest.jikkosoftTechnicalTest.application.usecases.user;

import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user.DeleteUserUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.user.UserRepositoryPort;

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

package TechnicalTest.jikkosoftTechnicalTest.application.services;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user.CreateUserUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user.DeleteUserUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user.GetUserUseCase;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user.UpdateUserUseCase;

import java.util.List;
import java.util.Optional;

public class UserService implements GetUserUseCase, CreateUserUseCase, UpdateUserUseCase, DeleteUserUseCase {

    private final GetUserUseCase getUserUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserService(GetUserUseCase getUserUseCase,CreateUserUseCase createUserUseCase,
                       UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.getUserUseCase = getUserUseCase;
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @Override
    public User createUser(User user) {
        return createUserUseCase.createUser(user);
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return deleteUserUseCase.deleteUserById(id);
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return getUserUseCase.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return getUserUseCase.getAllUsers();
    }

    @Override
    public Optional<User> updateUser(Integer id, User user) {
        return updateUserUseCase.updateUser(id, user);
    }
}

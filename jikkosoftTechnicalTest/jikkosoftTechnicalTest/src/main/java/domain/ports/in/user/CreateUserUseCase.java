package domain.ports.in.user;
import domain.models.User;

public interface CreateUserUseCase {
    User createUser(User user);
}

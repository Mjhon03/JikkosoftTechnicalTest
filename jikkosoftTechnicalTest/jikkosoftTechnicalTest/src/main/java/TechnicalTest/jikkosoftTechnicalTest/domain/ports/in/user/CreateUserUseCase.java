package TechnicalTest.jikkosoftTechnicalTest.domain.ports.in.user;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;

public interface CreateUserUseCase {
    User createUser(User user);
}

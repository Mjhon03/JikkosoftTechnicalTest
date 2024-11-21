package infraestructure.repositories.User;

import domain.models.User;
import domain.ports.out.user.UserRepositoryPort;
import infraestructure.entities.UserEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JpaUserAdapter implements UserRepositoryPort {

    private final JpaUserRepository userRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.fromDomainModel(user);
        return userRepository.save(userEntity).toDomainModel();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id.longValue()).map(UserEntity::toDomainModel);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(UserEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (userRepository.existsById(id.longValue())) {
            userRepository.deleteById(id.longValue());
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> updateUser(Integer id, User user) {
        if(userRepository.existsById(id.longValue())){
            UserEntity savedUserEntity = userRepository.save(UserEntity.fromDomainModel(user));
            return Optional.of(savedUserEntity.toDomainModel());
        }
        return Optional.empty();
    }
}

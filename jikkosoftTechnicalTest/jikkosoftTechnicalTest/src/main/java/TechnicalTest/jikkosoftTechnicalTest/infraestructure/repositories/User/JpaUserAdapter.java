package TechnicalTest.jikkosoftTechnicalTest.infraestructure.repositories.User;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;
import TechnicalTest.jikkosoftTechnicalTest.domain.ports.out.user.UserRepositoryPort;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.UserEntity;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers.UserMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaUserAdapter implements UserRepositoryPort {

    private final JpaUserRepository userRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserMapper.fromDomainModel(user);
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
            UserEntity savedUserEntity = userRepository.save(UserMapper.fromDomainModel(user));
            return Optional.of(savedUserEntity.toDomainModel());
        }
        return Optional.empty();
    }
}

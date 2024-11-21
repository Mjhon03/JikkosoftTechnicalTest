package TechnicalTest.jikkosoftTechnicalTest.infraestructure.mappers;

import TechnicalTest.jikkosoftTechnicalTest.domain.models.BookReserve;
import TechnicalTest.jikkosoftTechnicalTest.domain.models.User;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.UserDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.in.UserUpdateDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.Dto.out.UserOutputDto;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.BookReserveEntity;
import TechnicalTest.jikkosoftTechnicalTest.infraestructure.entities.UserEntity;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
public class UserMapper {

    public static UserEntity fromDomainModel(User user) {
        return new UserEntity(
                user.getUserID(),
                user.getUserName(),
                user.getUserLastName(),
                user.getReservedBooks() != null ? BookReserveEntity.fromDomainModelList(user.getReservedBooks()) : new ArrayList<>()
        );
    }

    public static UserDto toCreationDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getUserName(),
                user.getUserLastName()
        );
    }

    public static List<UserDto> toUserDtoList(List<User> users) {
        if (users == null) {
            return null;
        }

        return users.stream()
                .map(UserMapper::toCreationDto)
                .collect(Collectors.toList());
    }

    public static User toUser(UserDto dto) {
        if (dto == null) {
            return null;
        }

        return new User(
                null, // userID será nulo ya que UserDto no lo incluye
                dto.getUserName(),
                dto.getUserLastName(),
                null // reservedBooks no está en el UserDto
        );
    }

    public static List<User> toUserList(List<UserDto> dto) {
        if (dto == null) {
            return null;
        }

        return dto.stream()
                .map(UserMapper::toUser)
                .collect(Collectors.toList());
    }

    public static User toUser(UserUpdateDto updateDto) {
        if (updateDto == null) {
            return null;
        }

        return new User(
                updateDto.getUserID(),
                updateDto.getUserName(),
                updateDto.getUserLastName(),
                null // reservedBooks no está en el UserUpdateDto
        );
    }


    public static List<User> toUserListFromUpdateDto(List<UserUpdateDto> updateDto) {
        if (updateDto == null) {
            return null;
        }

        return updateDto.stream()
                .map(UserMapper::toUser)
                .collect(Collectors.toList());
    }

    public static UserOutputDto toOutputDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserOutputDto(
                user.getUserID(),
                user.getUserName(),
                user.getUserLastName(),
                user.getReservedBooks() != null
                        ? user.getReservedBooks().stream()
                        .map(BookReserve::getId)
                        .collect(Collectors.toList())
                        : Collections.emptyList()
        );
    }

    public static List<UserOutputDto> toOutputDtoList(List<User> users) {
        if (users == null || users.isEmpty()) {
            return Collections.emptyList();
        }

        return users.stream()
                .map(UserMapper::toOutputDto)
                .collect(Collectors.toList());
    }
}

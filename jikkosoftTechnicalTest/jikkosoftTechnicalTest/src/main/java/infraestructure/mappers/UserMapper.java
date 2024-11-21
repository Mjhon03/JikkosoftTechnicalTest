package infraestructure.mappers;

import domain.models.User;
import infraestructure.Dto.in.UserDto;
import infraestructure.Dto.in.UserUpdateDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
public class UserMapper {

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
}

package infraestructure.controllers;

import application.services.UserService;
import domain.models.User;
import infraestructure.Dto.in.UserDto;
import infraestructure.Dto.in.UserUpdateDto;
import infraestructure.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> userList = new ArrayList<>();
        try{
            userList = userService.getAllUsers();
        } catch(Exception e){
            log.error("Failed: find all users", e);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto user){
        User newUser = new User();
        try{
            newUser = userService.createUser(UserMapper.toUser(user));
        } catch (Exception e){
            log.error("Failed: create user", e);
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserUpdateDto user){
        User updatedUser = new User();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<User> optUser = userService.updateUser(user.getUserID(), UserMapper.toUser(user));
            if(optUser.isPresent()){
                updatedUser = optUser.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: update user", e);
        }

        return new ResponseEntity<>(updatedUser, status);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer userId){
        try{
            userService.deleteUserById(userId);
        } catch(Exception e){
            log.error("Failed: delete user", e);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}

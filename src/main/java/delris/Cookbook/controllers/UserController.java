package delris.Cookbook.controllers;

import delris.Cookbook.dto.UserGetDTO;
import delris.Cookbook.dto.UserPostDTO;
import delris.Cookbook.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<UserGetDTO> getUser(@PathVariable long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<UserPostDTO> createUser(@RequestBody UserPostDTO userPostDTO){
        UserPostDTO createdUserPostDTO = userService.createUser(userPostDTO);
        return ResponseEntity.created(URI.create("/api/user/" + createdUserPostDTO.getUserId())).body(createdUserPostDTO);
    }
}

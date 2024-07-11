package delris.Cookbook.controllers;

import delris.Cookbook.dto.UserDTO;
import delris.Cookbook.security.AccessConstants;
import delris.Cookbook.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PreAuthorize(AccessConstants.permitAdmin)
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PreAuthorize(AccessConstants.permitAdminAndModerator)
    @GetMapping("/user/{email}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }
    @PreAuthorize(AccessConstants.permitAdmin)
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long id){
        return ResponseEntity.ok(userService.findById(id));
    }

}

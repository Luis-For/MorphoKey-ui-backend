package morpho.key.demo.infrastructure.controller;

import lombok.AllArgsConstructor;
import morpho.key.demo.application.service.UserService;
import morpho.key.demo.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/add")
    ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>();
    }
}

package morpho.key.demo.controller;

import lombok.RequiredArgsConstructor;
import morpho.key.demo.entity.User;
import morpho.key.demo.service.UserServiceImplementation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImplementation userServiceImplementation;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userServiceImplementation.registrerUser(user));
    }

    @GetMapping("/search")
    public ResponseEntity<User> search(@RequestParam("name") String name) {
        Optional<User> user= userServiceImplementation.findByUsername(name);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        //userServiceImplementation.loginUser()
        return null;
    }

    @GetMapping("/test")
    public String test() {
        return "ResponseEntity.ok().build();";
    }
}

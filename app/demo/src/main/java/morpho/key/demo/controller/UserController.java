package morpho.key.demo.controller;

import lombok.RequiredArgsConstructor;
import morpho.key.demo.dto.user.UserDto;
import morpho.key.demo.entity.User;
import morpho.key.demo.service.EmailService;
import morpho.key.demo.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImplementation userServiceImplementation;
    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto user) {
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

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String token = UUID.randomUUID().toString();
        emailService.sendRecoveryEmail(email, token);
        return ResponseEntity.ok("correo enviado"+email);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("¡Hola desde el backend!");
    }

}

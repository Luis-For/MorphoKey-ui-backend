package morpho.key.demo.controller;

import lombok.RequiredArgsConstructor;
import morpho.key.demo.dto.user.UserDto;
import morpho.key.demo.entity.User;
import morpho.key.demo.service.EmailService;
import morpho.key.demo.service.UserServiceImplementation;
import morpho.key.demo.service.ValidationEmailServiceImplementation;
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
    private UserServiceImplementation userServiceImplementation;
    private EmailService emailService;
    private ValidationEmailServiceImplementation validationEmailServiceImplementation;

    @Autowired
    public UserController(UserServiceImplementation userServiceImplementation, EmailService emailService, ValidationEmailServiceImplementation validationEmailServiceImplementation) {
        this.userServiceImplementation = userServiceImplementation;
        this.emailService = emailService;
        this.validationEmailServiceImplementation = validationEmailServiceImplementation;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto user) {
        if (!validationEmailServiceImplementation.validateEmail(user.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("El correo ingresado no es valido");
        }
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

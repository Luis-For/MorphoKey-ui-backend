package morpho.key.demo.controller;

import lombok.RequiredArgsConstructor;
import morpho.key.demo.dto.UserDto;
import morpho.key.demo.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImplementation userServiceImplementation;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto user, String password) {
        return ResponseEntity.ok(userServiceImplementation.registrerUser(user, password));
    }

    @GetMapping("/search")
    public ResponseEntity<UserDto> search(@RequestParam("name") String username, Pageable pageable) {
        Optional<UserDto> user= userServiceImplementation.findByUsername(username, pageable);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}

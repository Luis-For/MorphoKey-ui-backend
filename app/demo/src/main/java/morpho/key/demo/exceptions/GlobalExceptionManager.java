package morpho.key.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionManager{
    @ExceptionHandler(value = {UserAlreadyExist.class})
    public ResponseEntity<Map<String, String>> handleUserAlreadyExists(UserAlreadyExist userAlreadyExistException){
        Map<String,String> error = new HashMap<>();
        error.put("Error", "The user already exists");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}

package forumEntrega;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<Void> handleNofindException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @ExceptionHandler(NotUniqueException.class)
    public ResponseEntity<Void> NotUniqueException() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    
    @ExceptionHandler(InvalidIDException.class)
    public ResponseEntity<Void> InvalidIDException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    
}

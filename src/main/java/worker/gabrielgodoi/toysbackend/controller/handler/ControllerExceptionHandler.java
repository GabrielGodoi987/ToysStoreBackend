package worker.gabrielgodoi.toysbackend.controller.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import worker.gabrielgodoi.toysbackend.erros.BadFormatException;
import worker.gabrielgodoi.toysbackend.erros.EntityNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> notFound(EntityNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new StandardError(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage(),
                        LocalDateTime.now(),
                        request.getRequestURI()
                )
        );
    }

    @ExceptionHandler(BadFormatException.class)
    public ResponseEntity<StandardError> badFormatError(BadFormatException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(
                new StandardError(
                        HttpStatus.UNPROCESSABLE_ENTITY.value(),
                        e.getMessage(),
                        LocalDateTime.now(),
                        request.getRequestURI()
                )
        );
    }
}

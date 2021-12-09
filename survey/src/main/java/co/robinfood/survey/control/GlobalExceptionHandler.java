package co.robinfood.survey.control;

import co.robinfood.survey.dto.exception.ErrorResponse;
import co.robinfood.survey.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> handleEntityNotFound(ResourceNotFound e) {
        return new ResponseEntity<Object>(ErrorResponse.builder()
                .code(e.getCode())
                .mensaje(e.getMessage()).build(), HttpStatus.NOT_FOUND);
    }
}

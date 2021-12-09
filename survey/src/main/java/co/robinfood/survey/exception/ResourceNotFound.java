package co.robinfood.survey.exception;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Value
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

    int code;

    public ResourceNotFound(String mensaje, int codigo) {
        super(mensaje);
        code = codigo;
    }
}

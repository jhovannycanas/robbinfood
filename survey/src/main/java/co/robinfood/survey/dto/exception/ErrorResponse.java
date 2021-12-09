package co.robinfood.survey.dto.exception;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResponse {
    String mensaje;
    int code;
}

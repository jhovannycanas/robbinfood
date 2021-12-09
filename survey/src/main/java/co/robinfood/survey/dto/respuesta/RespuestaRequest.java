package co.robinfood.survey.dto.respuesta;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RespuestaRequest {

    Long preguntaId;
    Long encuestaId;
    String valor;
    Long opcionRespuestaId;
}

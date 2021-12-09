package co.robinfood.survey.dto.respuesta;

import lombok.Value;

@Value
public class RespuestaRequest {

    Long preguntaId;
    Long encuestaId;
    String valor;
    Long opcionRespuestaId;
}

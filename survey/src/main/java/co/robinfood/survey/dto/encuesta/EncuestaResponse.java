package co.robinfood.survey.dto.encuesta;

import lombok.Value;

import java.util.List;

@Value
public class EncuestaResponse {

    Long id;
    String nombre;
    List<PreguntaDto> preguntaDtos;
}

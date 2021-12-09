package co.robinfood.survey.dto.encuesta;

import lombok.Value;

import java.util.List;

@Value
public class PreguntaDto {

    Long id;
    String nombre;
    TipoPreguntaDto tipoPreguntaDto;
    List<OpcionRespuestaDto> opcionRespuestas;
}

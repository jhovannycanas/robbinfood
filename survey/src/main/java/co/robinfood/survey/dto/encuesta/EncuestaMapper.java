package co.robinfood.survey.dto.encuesta;

import co.robinfood.survey.model.Encuesta;
import co.robinfood.survey.model.EncuestaPregunta;
import co.robinfood.survey.model.Pregunta;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface EncuestaMapper {

    @Mapping(source = "encuestaPreguntas", target = "preguntaDtos")
    EncuestaResponse toDto(Encuesta encuesta);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "tipoPreguntaDto", source = "pregunta.tipoPregunta")
    PreguntaDto toDto(Pregunta pregunta);

    @Mapping(source = "pregunta.id", target = "id")
    @Mapping(source = "pregunta.nombre", target = "nombre")
    @Mapping(source = "pregunta.tipoPregunta", target = "tipoPreguntaDto")
    @Mapping(source = "pregunta.opcionRespuestas", target = "opcionRespuestas")
    PreguntaDto encuestaPreguntaToDot(EncuestaPregunta encuestaPregunta);



}

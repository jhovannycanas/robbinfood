package co.robinfood.survey.service.impl;

import co.robinfood.survey.dto.encuesta.EncuestaMapper;
import co.robinfood.survey.dto.encuesta.EncuestaResponse;
import co.robinfood.survey.dto.respuesta.RespuestaRequest;
import co.robinfood.survey.model.*;
import co.robinfood.survey.repository.EncuestaRepository;
import co.robinfood.survey.repository.FormularioRepository;
import co.robinfood.survey.service.EncuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EncuestaServiceImpl implements EncuestaService {

    private final EncuestaRepository encuestaRepository;
    private final EncuestaMapper encuestaMapper;
    private final FormularioRepository formularioRepository;

    @Override
    public EncuestaResponse getEncuesta(Long id) {
        return this.encuestaRepository.findById(id).map(encuestaMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Encuesta no encontrada"));
    }

    @Transactional
    @Override
    public void saveEncuesta(List<RespuestaRequest> respuestaRequest) {

        List<Respuesta> respuestas = respuestaRequest.stream().map(respuestaRequest1 -> {
            Encuesta encuesta = this.encuestaRepository.findById(respuestaRequest1.getEncuestaId())
                    .orElseThrow(() -> new EntityNotFoundException("Encuesta no encontrada"));
            Pregunta pregunta = encuesta.getEncuestaPreguntas().stream()
                    .filter(encuestaPregunta -> encuestaPregunta.getPregunta().getId().equals(respuestaRequest1.getPreguntaId()))
                    .findAny().map(EncuestaPregunta::getPregunta)
                    .orElseThrow(() -> new EntityNotFoundException("Encuesta no encontrada"));
            OpcionRespuesta opcionRespuestaPregunta = null;
            if (respuestaRequest1.getOpcionRespuestaId() != null) {
                opcionRespuestaPregunta = pregunta.getOpcionRespuestas().stream().filter(opcionRespuesta -> opcionRespuesta.getId().equals(respuestaRequest1.getOpcionRespuestaId()))
                        .findAny().orElseThrow(() -> new EntityNotFoundException("Opcion de respuesta no encontrada"));
            }
            return Respuesta.builder().pregunta(pregunta).valor(respuestaRequest1.getValor())
                    .opcionRespuesta(opcionRespuestaPregunta).build();
        }).collect(Collectors.toList());

        Formulario formulario = new Formulario();
        formulario.setFechaCreacion(new Date());
        formulario.addRespuesta(respuestas);
        this.formularioRepository.save(formulario);
    }
}

package co.robinfood.survey.service;

import co.robinfood.survey.dto.encuesta.EncuestaResponse;
import co.robinfood.survey.dto.respuesta.RespuestaRequest;

import java.util.List;

public interface EncuestaService {


    EncuestaResponse getEncuesta(Long id);

    void saveEncuesta(List<RespuestaRequest> respuestaRequest);
}

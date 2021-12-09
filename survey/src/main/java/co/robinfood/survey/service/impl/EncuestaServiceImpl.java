package co.robinfood.survey.service.impl;

import co.robinfood.survey.dto.encuesta.EncuestaResponse;
import co.robinfood.survey.dto.respuesta.RespuestaRequest;
import co.robinfood.survey.repository.EncuestaRepository;
import co.robinfood.survey.service.EncuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EncuestaServiceImpl implements EncuestaService {

    private final EncuestaRepository encuestaRepository;

    @Override
    public EncuestaResponse getEncuesta(Long id) {
        return null;
    }

    @Transactional
    @Override
    public void saveEncuesta(List<RespuestaRequest> respuestaRequest) {

    }
}

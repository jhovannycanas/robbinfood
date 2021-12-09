package co.robinfood.survey.controller;

import co.robinfood.survey.dto.encuesta.EncuestaResponse;
import co.robinfood.survey.dto.respuesta.RespuestaRequest;
import co.robinfood.survey.service.EncuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/robinfood/surveys")
public class EncuestaController {

    private final EncuestaService encuestaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EncuestaResponse> getEncuesta(@PathVariable Long id) {
        return new ResponseEntity<EncuestaResponse>(encuestaService.getEncuesta(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveRespuesta(@RequestBody List<RespuestaRequest> respuestaRequest) {
        encuestaService.saveEncuesta(respuestaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

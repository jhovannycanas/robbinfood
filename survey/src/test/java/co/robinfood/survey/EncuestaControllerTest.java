package co.robinfood.survey;

import co.robinfood.survey.dto.respuesta.RespuestaRequest;
import co.robinfood.survey.model.*;
import co.robinfood.survey.repository.EncuestaRepository;
import co.robinfood.survey.repository.PreguntaRepository;
import co.robinfood.survey.repository.TipoPreguntaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EncuestaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EncuestaRepository encuestaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private TipoPreguntaRepository tipoPreguntaRepository;

    Encuesta encuesta = null;
    Pregunta pregunta = null;
    OpcionRespuesta opcionRespuesta = null;

    @BeforeAll
    public void setup() {

        TipoPregunta tipoPregunta = new TipoPregunta();
        tipoPregunta.setNombre("Multiple selección");

        tipoPregunta = this.tipoPreguntaRepository.save(tipoPregunta);

        pregunta = new Pregunta();
        pregunta.setTipoPregunta(tipoPregunta);

        opcionRespuesta = new OpcionRespuesta();
        opcionRespuesta.setNombre("Azul");

        OpcionRespuesta opcionRespuesta1 = new OpcionRespuesta();
        opcionRespuesta1.setNombre("Verde");

        pregunta.addOpcionRespuesta(opcionRespuesta);
        pregunta.addOpcionRespuesta(opcionRespuesta1);

        pregunta = this.preguntaRepository.save(pregunta);
        encuesta = new Encuesta();
        encuesta.setNombre("Prueba encuesta");

        EncuestaPregunta encuestaPregunta = new EncuestaPregunta();
        encuestaPregunta.setPregunta(pregunta);

        encuesta.addPregunta(encuestaPregunta);
        this.encuestaRepository.save(encuesta);
    }

    @Test
    public void getEncuestaTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/robinfood/surveys/{id}", encuesta.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getEncuestaExceptionTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/robinfood/surveys/{id}", 1000l))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void saveRespuestaTest() throws Exception {
        RespuestaRequest respuestaRequest = RespuestaRequest.builder()
                .encuestaId(encuesta.getId()).preguntaId(pregunta.getId())
                .opcionRespuestaId(opcionRespuesta.getId()).build();
        List<RespuestaRequest> respuestaRequests = new ArrayList<>();
        respuestaRequests.add(respuestaRequest);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/robinfood/surveys")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(respuestaRequests))
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void saveRespuestaExceptionTest() throws Exception {
        RespuestaRequest respuestaRequest = RespuestaRequest.builder()
                .encuestaId(1000l).preguntaId(pregunta.getId())
                .opcionRespuestaId(opcionRespuesta.getId()).build();
        List<RespuestaRequest> respuestaRequests = new ArrayList<>();
        respuestaRequests.add(respuestaRequest);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/robinfood/surveys")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(respuestaRequests))
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

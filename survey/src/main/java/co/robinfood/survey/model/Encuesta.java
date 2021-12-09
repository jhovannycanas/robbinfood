package co.robinfood.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_encuesta")
@Data
@EqualsAndHashCode(callSuper = false)
public class Encuesta extends AbstractBase {

    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "encuesta", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<EncuestaPregunta> encuestaPreguntas = new ArrayList<>();

    public void addPregunta(EncuestaPregunta encuestaPregunta) {
        this.encuestaPreguntas.add(encuestaPregunta);
        encuestaPregunta.setEncuesta(this);
    }
}

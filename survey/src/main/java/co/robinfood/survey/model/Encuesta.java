package co.robinfood.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_encuesta")
@Data
@EqualsAndHashCode(callSuper = false)
public class Encuesta extends AbstractBase {

    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "encuesta", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<EncuestaPregunta> encuestaPreguntas = new HashSet<>();

    public void addPregunta(EncuestaPregunta encuestaPregunta) {
        this.encuestaPreguntas.add(encuestaPregunta);
        encuestaPregunta.setEncuesta(this);
    }
}

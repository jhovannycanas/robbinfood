package co.robinfood.survey.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_encuesta_pregunta")
@Data
@EqualsAndHashCode(callSuper = false)
public class EncuestaPregunta extends AbstractBase {

    @ManyToOne
    @JoinColumn(name = "id_encuesta", referencedColumnName = "id")
    private Encuesta encuesta;

    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id")
    private Pregunta pregunta;
}

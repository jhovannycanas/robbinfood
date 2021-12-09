package co.robinfood.survey.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_respuesta")
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Respuesta extends AbstractBase {

    @ManyToOne
    @JoinColumn(name = "id_formulario", referencedColumnName = "id")
    private Formulario formulario;

    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id")
    private Pregunta pregunta;

    private String valor;

    @ManyToOne
    @JoinColumn(name = "id_opcion_respuesta", referencedColumnName = "id")
    private OpcionRespuesta opcionRespuesta;
}

package co.robinfood.survey.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_opcion_respuesta")
@Data
@EqualsAndHashCode(callSuper = false)
public class OpcionRespuesta extends AbstractBase {

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id")
    private Pregunta pregunta;
}

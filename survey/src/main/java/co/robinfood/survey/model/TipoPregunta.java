package co.robinfood.survey.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_pregunta")
@Data
@EqualsAndHashCode(callSuper = false)
public class TipoPregunta extends AbstractBase {

    private String nombre;
}

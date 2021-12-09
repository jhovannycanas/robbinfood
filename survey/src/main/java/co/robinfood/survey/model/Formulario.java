package co.robinfood.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_formulario")
@Data
@EqualsAndHashCode(callSuper = false)
public class Formulario extends AbstractBase {

    @JsonIgnore
    @OneToMany(mappedBy = "formulario", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Respuesta> respuestas = new ArrayList<>();

    public void addRespuesta(List<Respuesta> respuestas) {
        for (Respuesta respuesta :
                respuestas) {
            respuesta.setFormulario(this);
            respuesta.setFechaCreacion(new Date());
        }
        this.respuestas.addAll(respuestas);
    }
}

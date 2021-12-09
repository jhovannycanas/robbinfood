package co.robinfood.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_pregunta")
@Data
@EqualsAndHashCode(callSuper = false)
public class Pregunta extends AbstractBase {

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pregunta", referencedColumnName = "id")
    private TipoPregunta tipoPregunta;

    @JsonIgnore
    @OneToMany(mappedBy = "pregunta", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<OpcionRespuesta> opcionRespuestas = new HashSet<>();
}

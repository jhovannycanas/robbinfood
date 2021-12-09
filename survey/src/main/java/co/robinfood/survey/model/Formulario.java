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
@Table(name = "tbl_formulario")
@Data
@EqualsAndHashCode(callSuper = false)
public class Formulario extends AbstractBase {

    @JsonIgnore
    @OneToMany(mappedBy = "formulario", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Respuesta> respuestas = new HashSet<>();
}

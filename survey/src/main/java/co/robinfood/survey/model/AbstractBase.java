package co.robinfood.survey.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@Access(AccessType.FIELD)
public abstract class AbstractBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    @CreatedDate
    private Date fechaCreacion;

}

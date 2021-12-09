package co.robinfood.survey.repository;

import co.robinfood.survey.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}

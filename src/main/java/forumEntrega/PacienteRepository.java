package forumEntrega;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface PacienteRepository extends JpaRepository<Paciente, String> {

	@Query(value = "select count(nome) "
				+ " from paciente", nativeQuery = true)
	String totaliza();

	

}
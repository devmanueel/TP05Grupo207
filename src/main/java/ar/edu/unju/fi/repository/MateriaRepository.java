package ar.edu.unju.fi.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia,String> {
	
	List<Materia> findMateriaByEstado(Boolean estado);
}

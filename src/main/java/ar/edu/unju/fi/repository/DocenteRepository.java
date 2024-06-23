package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente,String>{
	
	List<Docente> findDocenteByEstado(Boolean estado);
	
}

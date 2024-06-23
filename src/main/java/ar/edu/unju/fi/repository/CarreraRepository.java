package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Carrera;
@Repository
public interface CarreraRepository  extends JpaRepository<Carrera,String>{
	 List<Carrera> findCarreraByEstado(boolean estado);
}

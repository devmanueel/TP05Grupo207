package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

@Service
public interface DocenteService {
	
	//public void guardarDocente(Docente docente);
	public List<DocenteDTO> MostrarDocente(); //muestra los docentes
	DocenteDTO findByLegajo(String legajo); //buscar Docene
	boolean save (DocenteDTO docenteDTO);
	void deleteByLegajo(String legajo);
	void edit(DocenteDTO docenteDTO);
	public Docente buscaDocente(String legajo);
	//public void borrarDocente(String legajo);
	//public void modificarDocente(DocenteDTO docenteDTO);
	//public Docente buscaDocente(String legajo); 
	
}

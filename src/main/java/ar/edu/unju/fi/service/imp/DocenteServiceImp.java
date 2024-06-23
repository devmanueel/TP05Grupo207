 package ar.edu.unju.fi.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.map.DocenteMapDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;

@Service("docenteServiceImp")
public class DocenteServiceImp implements DocenteService {

	//@Autowired DocenteMapDTO docenteMapDTO;
	@Autowired DocenteMapDTO docenteMapDTO;
	
	@Autowired
	DocenteRepository docenteRepository;
	
	
	@Override
	public List<DocenteDTO> MostrarDocente() {
		// TODO Auto-generated method stub
		//List<DocenteDTO> docenteDTOs=docenteMapDTO.toDocenteDTOList(ListadoDocentes.listarDocentes());
		List<DocenteDTO>docenteDTOs=docenteMapDTO.toDocenteDTOList(docenteRepository.findDocenteByEstado(true));
		return docenteDTOs;
		
		//return docenteDTOs;
	}

	@Override
	public DocenteDTO findByLegajo(String legajo) {
		// TODO Auto-generated method stub
		DocenteDTO docenteDTO = docenteMapDTO.toDocenteDTO(ListadoDocentes.buscarDocentePorLegajo(legajo));
		return docenteDTO;
	}

	@Override
	public boolean save(DocenteDTO docenteDTO) {
		// TODO Auto-generated method stub0
		boolean respuesta = ListadoDocentes.agregarDocente(docenteMapDTO.toDocente(docenteDTO));
		Docente docente = docenteMapDTO.toDocente(docenteDTO);
        docenteRepository.save(docente);
		
		//System.out.println(docenteDTO);
		
		return respuesta;
	}

	@Override
	public void deleteByLegajo(String legajo) {
		// TODO Auto-generated method stub
		//ListadoDocentes.eliminarDocente(legajo);
		
		List<Docente> todosLosDocentes = docenteRepository.findAll();
		for (int i = 0; i < todosLosDocentes.size(); i++) {
		      Docente docente = todosLosDocentes.get(i);
		      if (docente.getLegajo().equals(legajo)) {
		        docente.setEstado(false);
		        docenteRepository.save(docente);
		        break;
		      }
		    }
	}

	@Override
	public void edit(DocenteDTO docenteDTO) {
		// TODO Auto-generated method stub
		ListadoDocentes.modificarDocente(docenteMapDTO.toDocente(docenteDTO));
		
		
	}

	@Override
	public Docente buscaDocente(String legajo) {
		return docenteRepository.findById(legajo).orElse(null);
	}




	
	
	
	
	
}

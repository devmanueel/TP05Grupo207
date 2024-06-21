package ar.edu.unju.fi.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;

@Service
public class DocenteServiceImp implements DocenteService {

	@Autowired
	DocenteRepository docenteRepository;
	
	@Override
	public void guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		//INsertar try y chat
		//docente.setEstado(true);
		docenteRepository.save(docente);
		
	}
 
	@Override
	public List<Docente> MostrarDocente() {
		// TODO Auto-generated method stub
		//return docenteRepository.findAll()	;		
		return docenteRepository.findDocenteByEstado(true);
	}

	@Override
	public void borrarDocente(String legajo) {
		// TODO Auto-generated method stub
		System.out.println("este es el codigo: "+legajo);
		// TODO Auto-generated method stub
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
	public void modificarDocente(Docente docente) {
		// TODO Auto-generated method stub
		 docenteRepository.save(docente);
	}

	@Override
	public Docente buscaDocente(String legajo) {
		// TODO Auto-generated method stub
		 return docenteRepository.findById(legajo).orElse(null);
	}



	

	
}

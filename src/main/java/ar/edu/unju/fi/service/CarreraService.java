package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Carrera;

@Service
public interface CarreraService {

		public void guardarCarrera(Carrera docente);
		public List<Carrera> MostrarCarrera();
		public void borrarCarrera(String codigo);
		public void modificarCarrera(Carrera carrera);
		public Carrera buscaCarrera(String codigo);
		
}

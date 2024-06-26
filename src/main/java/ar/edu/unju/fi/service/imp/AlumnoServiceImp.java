package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.map.AlumnoMapDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;


@Service("alumnoServiceImp")
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired AlumnoMapDTO alumnoMapDTO;
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Override
	public List<AlumnoDTO> MostrarAlumno() {
		// TODO Auto-generated method stub
		List<AlumnoDTO>alumnoDTOs=alumnoMapDTO.toAlumnoDTOList(alumnoRepository.findAlumnoByEstado(true));
		
		return alumnoDTOs;
		
	}

	@Override
	public AlumnoDTO findByDni(String dni) {
		// TODO Auto-generated method stub
		 Optional<Alumno> alumnoOpt = alumnoRepository.findByDni(dni);
		 
		 System.out.println("ALUMNO POR DNI:  "+alumnoOpt);
	     return alumnoOpt.map(alumnoMapDTO::toAlumnoDTO).orElse(null);
		
	}

	@Override
	public boolean save(AlumnoDTO alumnoDTO) {
		boolean respuesta = ListadoAlumnos.agregarAlumno(alumnoMapDTO.toAlumno(alumnoDTO));
		Alumno alumno = alumnoMapDTO.toAlumno(alumnoDTO);
		alumnoRepository.save(alumno);
		return respuesta;
	}

	@Override
	public void deleteByDni(String dni) {
		// TODO Auto-generated method stub

		List<Alumno> todosLosAlumnos = alumnoRepository.findAll();
		for (int i = 0; i < todosLosAlumnos.size(); i++) {
		      Alumno alumno = todosLosAlumnos.get(i);
		      if (alumno.getDni().equals(dni)) {
		    	  alumno.setEstado(false);
		    	  alumnoRepository.save(alumno);
		        break;
		      }
		    }
	}

	@Override
	public void edit(AlumnoDTO alumnoDTO) {
		// TODO Auto-generated method stub
		ListadoAlumnos.modificarAlumno(alumnoMapDTO.toAlumno(alumnoDTO));
	}

	@Override
	public Alumno buscaAlumno(String dni) {
		return alumnoRepository.findById(dni).orElse(null);
	}

}

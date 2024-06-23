package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService {

	@Autowired
	CarreraRepository carreraRepository;

	@Override
	public void guardarCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		carreraRepository.save(carrera);
		System.out.println("Carrera ejecutada en metodo GUARDAR CARRERA" + carrera.getCodigo());
	}

	@Override
	public List<Carrera> MostrarCarrera() {
		// TODO Auto-generated method stub
		return carreraRepository.findCarreraByEstado(true);
	}

	@Override
	public void borrarCarrera(String codigo) {
		// TODO Auto-generated method stub
		List<Carrera> todosLasCarreras = carreraRepository.findAll();
		for (int i = 0; i < todosLasCarreras.size(); i++) {
			Carrera carrera = todosLasCarreras.get(i);
			if (carrera.getCodigo().equals(codigo)) {
				carrera.setEstado(false);
				carreraRepository.save(carrera);
				break;
			}
		}
	}

	@Override
	public void modificarCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		carreraRepository.save(carrera);
	}

	@Override
	public Carrera buscaCarrera(String codigo) {
		// TODO Auto-generated method stub
		return carreraRepository.findById(codigo).orElse(null);
	}
}

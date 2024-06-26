package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.CarreraMapDTO.CarreraMapDTO;
import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service("carreraServiceImp")
public class CarreraServiceImp implements CarreraService {

	@Autowired CarreraMapDTO carreraMapDTO;
	
	@Autowired 
	CarreraRepository carreraRepository;
	
	@Override
	public List<CarreraDTO> MostrarCarrera() {
		List<CarreraDTO>carreraDTOs = carreraMapDTO.toCarreraDTOList(carreraRepository.findCarreraByEstado(true));
		return carreraDTOs;
	}

	@Override
	public CarreraDTO findByCodigo(String codigo) {
		CarreraDTO carreraDTO = carreraMapDTO.toCarreraDTO(ListadoCarreras.buscarCarreraPorCodigo(codigo));
		return carreraDTO;
	}

	@Override
	public boolean save(CarreraDTO carreraDTO) {
		boolean respuesta = ListadoCarreras.agregarCarrera(carreraMapDTO.toCarrera(carreraDTO));
		Carrera carrera = carreraMapDTO.toCarrera(carreraDTO);
		carreraRepository.save(carrera);
		
		return respuesta;
	}

	@Override
	public void deleteByCodigo(String codigo) {
		List<Carrera> todosLasCarrera = carreraRepository.findAll();
		for (int i = 0; i < todosLasCarrera.size(); i++) {
		      Carrera carrera = todosLasCarrera.get(i);
		      if (carrera.getCodigo().equals(codigo)) {
		        carrera.setEstado(false);
		        carreraRepository.save(carrera);
		        break;
		      }
		    }

		
	}

	@Override
	public void edit(CarreraDTO carreraDTO) {
		ListadoCarreras.modificarCarrera(carreraMapDTO.toCarrera(carreraDTO));
	}

	@Override
	public Carrera buscarCarrera(String codigo) {
		// TODO Auto-generated method stub
		return carreraRepository.findById(codigo).orElse(null);
	}
}


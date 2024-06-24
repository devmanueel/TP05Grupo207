package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.map.MateriaMapDTO;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.MateriaService;

@Service("materiaServiceImp")
public class MateriaServiceImp implements MateriaService {
	
	@Autowired MateriaMapDTO materiaMapDTO;
		
	@Autowired
	MateriaRepository materiaRepository;
	
	@Override
	public List<MateriaDTO> MostrarMateria() {
		// TODO Auto-generated method stub
		List<MateriaDTO>materiaDTOs=materiaMapDTO.toMateriaDTOList(materiaRepository.findMateriaByEstado(true));
		return materiaDTOs;
	}

	@Override
	public MateriaDTO findByCodigo(String codigo) {
		// TODO Auto-generated method stub
		MateriaDTO materiaDTO = materiaMapDTO.toMateriaDTO(ListadoMateria.buscarMateriaPorCodigo(codigo));
		return materiaDTO;
	}

	@Override
	public boolean save(MateriaDTO materiaDTO) {
		// TODO Auto-generated method stub
		boolean respuesta = ListadoMateria.agregarMateria(materiaMapDTO.toMateria(materiaDTO));
		Materia materia = materiaMapDTO.toMateria(materiaDTO);
		materiaRepository.save(materia);
		return respuesta;
	}

	@Override
	public void deleteByCodigo(String codigo) {
		// TODO Auto-generated method stub
		List<Materia> todasLasMaterias = materiaRepository.findAll();
		for (int i = 0; i < todasLasMaterias.size(); i++) {
		      Materia materia = todasLasMaterias.get(i);
		      if (materia.getCodigo().equals(codigo)) {
		    	  materia.setEstado(false);
		    	  materiaRepository.save(materia);
		        break;
		      }
		    }
		
	}

	@Override
	public void edit(MateriaDTO materiaDTO) {
		// TODO Auto-generated method stub
		ListadoMateria.modificarMateria(materiaMapDTO.toMateria(materiaDTO));
	}

	@Override
	public Materia buscaMateria(String codigo) {
		// TODO Auto-generated method stub
		return materiaRepository.findById(codigo).orElse(null);
	}

}

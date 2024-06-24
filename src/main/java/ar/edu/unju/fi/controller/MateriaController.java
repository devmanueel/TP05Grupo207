package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.service.MateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	@Qualifier("materiaServiceImp")
	MateriaService materiaService;
	
	@Autowired
	MateriaDTO nuevaMateriaDTO;

	 // Muestra materias
	@GetMapping("/listado")
	public String getMateria(Model model) {
		model.addAttribute("materia", materiaService.MostrarMateria());
		
		return "listaDeMaterias";
		
	}

	@GetMapping("/nuevo")
	 public String getVistaNuevaCarrera(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        //model.addAttribute("nuevoDocente", nuevoDocente);
        model.addAttribute("nuevaMateria", nuevaMateriaDTO);
        model.addAttribute("edicion", edicion);
        return "formMateria";
    }

	@PostMapping("/guardar")
	public String guardarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO) {
		materiaService.save(materiaDTO);
    	return "redirect:/materia/listado ";
        
        
    }

	@GetMapping("/modificarMateria/{codigo}")
	public String getModificarMateriaPague(Model model,@PathVariable(value = "codigo") String codigo) {
		
		MateriaDTO materiaEncontradoDTO = materiaService.findByCodigo(codigo);
		boolean edicion = true;
		model.addAttribute("nuevaMateria", materiaEncontradoDTO);
		model.addAttribute("edicion", edicion);
		return "formMateria";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaDTO) {
        //docenteService.edit(docenteDTO);
        materiaService.save(materiaDTO);
        return "redirect:/materia/listado";
    }

		
	@GetMapping("/borrarMateria/{codigo}")
	  public String eliminarMateria(@PathVariable(value = "codigo") String codigo) {
    	materiaService.deleteByCodigo(codigo);
    	//ListadoDocentes.eliminarDocente(legajo);
    	return "redirect:/materia/listado";
   }
}

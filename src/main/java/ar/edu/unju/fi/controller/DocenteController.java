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

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.service.DocenteService;


@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	
	@Autowired
	@Qualifier("docenteServiceImp")
	DocenteService docenteService;
	
	@Autowired
	DocenteDTO nuevoDocenteDTO;
	
    // Muestra Carreras
    @GetMapping("/listadoDocente")
    public String getCarreras(Model model) {
        model.addAttribute("docente",docenteService.MostrarDocente()); //muestra por parte de lservide
    	//model.addAllAttributes("docente",docenteService);
        return "listadoDeDocentes";	
        
    }
     
    @GetMapping("/nuevo")
    public String getVistaNuevaDocente(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        //model.addAttribute("nuevoDocente", nuevoDocente);
        model.addAttribute("nuevoDocente", nuevoDocenteDTO);
        model.addAttribute("edicion", edicion);
        return "formDocente";
    }
    
    
    @PostMapping("/guardar")
    public String guardarDocente(@ModelAttribute("docente") DocenteDTO docenteDTO) {
        //ListadoDocentes.agregarDocente(docente);
    	docenteService.save(docenteDTO);
    	//Lista de carreras
        
    	return "redirect:/docente/listadoDocente";
        
        
    }
	

    @GetMapping("/modificar/{legajo}")
    public String getModificarDocentePage(Model model, @PathVariable(value = "legajo") String legajo) {
    	
    	DocenteDTO docenteEncontradoDTO = docenteService.findByLegajo(legajo);
        boolean edicion = true;
        model.addAttribute("nuevoDocente", docenteEncontradoDTO);
        model.addAttribute("edicion", edicion);
        return "formDocente";
    }
    
    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute("nuevoDocente") DocenteDTO docenteDTO) {
        //docenteService.edit(docenteDTO);
        docenteService.save(docenteDTO);
        return "redirect:/docente/listadoDocente";
    }
    
//    BORRAR
    
    @GetMapping("/borrar/{legajo}")
   public String eliminarDocente(@PathVariable(value = "legajo") String legajo) {
    	docenteService.deleteByLegajo(legajo);
    	//ListadoDocentes.eliminarDocente(legajo);
    	return "redirect:/docente/listadoDocente";
   }
}

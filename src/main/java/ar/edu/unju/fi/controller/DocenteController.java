package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.DocenteService;


@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private Docente nuevoDocente;
	
	@Autowired
	DocenteService docenteService;
	
    // Muestra Carreras
    @GetMapping("/listadoDocente")
    public String getCarreras(Model model) {
        model.addAttribute("docente",docenteService.MostrarDocente());
    	
        return "listadoDeDocentes";	
        
    }
    @GetMapping("/nuevo")
    public String getVistaNuevaDocente(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        model.addAttribute("nuevoDocente", nuevoDocente);
        model.addAttribute("edicion", edicion);
        return "formDocente";
    }
    @PostMapping("/guardar")
    public String guardarDocente(@ModelAttribute("docente") Docente docente) {
        //ListadoDocentes.agregarDocente(docente);
    	docenteService.guardarDocente(docente);
    	//Lista de carreras
        
        return "redirect:/docente/listadoDocente";
        
        
    }
	
//    @GetMapping("/modificar/{legajo}")
//    public String getModificarDocentePague(Model model, @PathVariable(value = "legajo") String legajo) {
//        Docente nuevoDocente = ListadoDocentes.buscarDocentePorLegajo(legajo);
//        boolean edicion = true;
//        model.addAttribute("nuevoDocente", nuevoDocente);
//        model.addAttribute("edicion", edicion);
//        return "formDocente";
//    }
    	
    @GetMapping("/modificar/{legajo}")
    public String getModificarDocentePage(Model model, @PathVariable(value = "legajo") String legajo) {
        Docente docente = docenteService.buscaDocente(legajo);
        boolean edicion = true;
        model.addAttribute("nuevoDocente", docente);
        model.addAttribute("edicion", edicion);
        return "formDocente";
    }
    
    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute("nuevoDocente") Docente docente) {
        docenteService.modificarDocente(docente);
        return "redirect:/docente/listadoDocente";
    }
    
//    @PostMapping("/modificar")
//    public String modificarDocente(@ModelAttribute("nuevoDocente") Docente docente) {
//    	//System.out.println(carrera.getCodigo());
//        ListadoDocentes.modificarDocente(docente);
//        return "redirect:/docente/listadoDocente";
//    }
//    BORRAR
    
    @GetMapping("/borrar/{legajo}")
   public String eliminarDocente(@PathVariable(value = "legajo") String legajo) {
    	docenteService.borrarDocente(legajo);
    	//ListadoDocentes.eliminarDocente(legajo);
    	return "redirect:/docente/listadoDocente";
   }
}

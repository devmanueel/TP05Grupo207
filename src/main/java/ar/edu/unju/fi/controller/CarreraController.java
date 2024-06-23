package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.service.CarreraService;



@Controller
@RequestMapping("/carrera")
public class CarreraController {
    
    @Autowired
    private Carrera nuevaCarrera; // inyección de dependencias
    @Autowired
    private CarreraService cs;
    
    // Muestra Carreras
    @GetMapping("/listado")
    public String getCarreras(Model model) {
       model.addAttribute("carrera", cs.MostrarCarrera());
        return "listaDeCarreras";
    }
    
    @GetMapping("/nuevo")
    public String getVistaNuevaCarrera(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        model.addAttribute("nuevaCarrera", nuevaCarrera);
        model.addAttribute("edicion", edicion);
        return "formCarrera";
    }
    
    @PostMapping("/guardar")
    public String guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
        cs.guardarCarrera(carrera);
        return "redirect:/docente/listadoDocente";
    }
    
    @GetMapping("/modificarCarrera/{codigo}")
    public String getModificarCarreraPague(Model model, @PathVariable(value = "codigo") String codigo) {
        Carrera nuevaCarrera = cs.buscaCarrera(codigo);
        boolean edicion = true;
        model.addAttribute("nuevaCarrera", nuevaCarrera);
        model.addAttribute("edicion", edicion);
        return "formCarrera";
    }
    
    @PostMapping("/modificar")
    public String modificarCarrera(@ModelAttribute("nuevaCarrera") Carrera carrera) {
       cs.modificarCarrera(carrera);
        return "redirect:/carrera/listado";
    }
    
    @GetMapping("/borrarCarrera/{codigo}")
    public String eliminarCarrera(@PathVariable(value = "codigo") String codigo) {
    	cs.borrarCarrera(codigo);
    	return "redirect:/carrera/listado";
    }
   
    
}

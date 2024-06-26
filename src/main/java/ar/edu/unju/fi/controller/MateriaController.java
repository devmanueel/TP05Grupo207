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

    // Muestra la lista de materias
    @GetMapping("/listado")
    public String getMateria(Model model) {
        try {
            model.addAttribute("materia", materiaService.MostrarMateria());
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al obtener la lista de materias
            model.addAttribute("error", "Ocurrió un error al obtener la lista de materias.");
        }
        return "listaDeMaterias";
    }

    // Muestra el formulario para agregar una nueva materia
    @GetMapping("/nuevo")
    public String getVistaNuevaCarrera(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        model.addAttribute("nuevaMateria", nuevaMateriaDTO);
        model.addAttribute("edicion", edicion);
        return "formMateria";
    }

    // Guarda una nueva materia
    @PostMapping("/guardar")
    public String guardarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO) {
        try {
            materiaService.save(materiaDTO);
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al guardar la materia
            return "redirect:/materia/nuevo?error=true";
        }
        return "redirect:/materia/listado";
    }

    // Muestra el formulario para modificar una materia existente
    @GetMapping("/modificarMateria/{codigo}")
    public String getModificarMateriaPague(Model model, @PathVariable(value = "codigo") String codigo) {
        try {
            MateriaDTO materiaEncontradoDTO = materiaService.findByCodigo(codigo);
            boolean edicion = true;
            model.addAttribute("nuevaMateria", materiaEncontradoDTO);
            model.addAttribute("edicion", edicion);
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al encontrar la materia por código
            return "redirect:/materia/listado?error=true";
        }
        return "formMateria";
    }

    // Guarda las modificaciones de una materia existente
    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaDTO) {
        try {
            materiaService.save(materiaDTO);
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al modificar la materia
            return "redirect:/materia/modificar/" + materiaDTO.getCodigo() + "?error=true";
        }
        return "redirect:/materia/listado";
    }

    // Elimina una materia por su código
    @GetMapping("/borrarMateria/{codigo}")
    public String eliminarMateria(@PathVariable(value = "codigo") String codigo) {
        try {
            materiaService.deleteByCodigo(codigo);
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al borrar la materia
            return "redirect:/materia/listado?error=true";
        }
        return "redirect:/materia/listado";
    }
}

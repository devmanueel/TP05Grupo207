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
import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.service.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    @Qualifier("alumnoServiceImp")
    AlumnoService alumnoService;

    @Autowired
    AlumnoDTO nuevoAlumnoDTO;

    // Muestra la lista de alumnos
    @GetMapping("/listadoAlumno")
    public String getAlumno(Model model) {
        try {
            model.addAttribute("alumno", alumnoService.MostrarAlumno());
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al obtener la lista de alumnos
            model.addAttribute("error", "Ocurrió un error al obtener la lista de alumnos.");
        }
        return "listaDeAlumnos";
    }

    // Muestra el formulario para agregar un nuevo alumno
    @GetMapping("/nuevo")
    public String getVistaNuevoAlumno(Model model) {
        boolean edicion = false;
        model.addAttribute("nuevoAlumno", nuevoAlumnoDTO);
        model.addAttribute("edicion", edicion);
        return "formAlumno";
    }

    // Guarda un nuevo alumno
    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoDTO) {
        try {
            alumnoService.save(alumnoDTO);
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al guardar el alumno
            return "redirect:/alumno/nuevo?error=true";
        }
        return "redirect:/alumno/listadoAlumno";
    }

    // Muestra el formulario para modificar un alumno existente
    @GetMapping("/modificar/{dni}")
    public String getModificarAlumnoPague(Model model, @PathVariable(value = "dni") String dni) {
        try {
            AlumnoDTO alumnoEncontradoDTO = alumnoService.findByDni(dni);
            model.addAttribute("nuevoAlumno", alumnoEncontradoDTO);
            model.addAttribute("edicion", true);
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al encontrar el alumno por DNI
            return "redirect:/alumno/listadoAlumno?error=true";
        }
        return "formAlumno";
    }

    // Guarda las modificaciones de un alumno existente
    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoDTO) {
        try {
            alumnoService.save(alumnoDTO);
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al modificar el alumno
            return "redirect:/alumno/modificar/" + alumnoDTO.getDni() + "?error=true";
        }
        return "redirect:/alumno/listadoAlumno";
    }

    // Elimina un alumno por su DNI
    @GetMapping("/borrar/{dni}")
    public String eliminarAlumno(@PathVariable(value = "dni") String dni) {
        try {
            alumnoService.deleteByDni(dni);
        } catch (Exception e) {
            // Manejo de cualquier excepción que ocurra al borrar el alumno
            return "redirect:/alumno/listadoAlumno?error=true";
        }
        return "redirect:/alumno/listadoAlumno";
    }
}

package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumnos {
    public static List<Alumno> alumnos = new ArrayList<Alumno>();
    
    // Método para listar alumnos
    public static List<Alumno> listarAlumnos() {
        return alumnos;
    }
    
    // Método para buscar un alumno por DNI
    public static Alumno buscarAlumnoPorDNI(String dni) {
        for (Alumno alumno : alumnos) {
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
        }
        return null;
    }
    
    // Método para agregar un alumno
    public static void agregarAlumno(Alumno alumno) {
        alumno.setEstado(true);
        alumnos.add(alumno);
    }
    
    // Método para modificar un alumno
    public static void modificarAlumno(Alumno alumnoModificado) {
        alumnoModificado.setEstado(true);
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = alumnos.get(i);
            if (alumno.getDni().equals(alumnoModificado.getDni())) {
                alumnos.set(i, alumnoModificado);
                break;
            }
        }
    }
    
    // Método para eliminar un alumno
    public static void eliminarAlumno(String dni) {
        alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
    }
}

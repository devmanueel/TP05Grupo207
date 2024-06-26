package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumnos {

    public static List<Alumno> alumnos = new ArrayList<>();

    // Método para listar todos los alumnos
    public static List<Alumno> listarAlumnos() {
        return alumnos;
    }

    // Método para buscar un Alumno por DNI
    public static Alumno buscarAlumnoPorDNI(String dni) {
        for (Alumno a : alumnos) {
            if (a.getDni().equals(dni)) {
                return a;
            }
        }
        return null;
    }

    // Método para agregar un Alumno
    public static boolean agregarAlumno(Alumno a) {
        return alumnos.add(a);
    }

    // Método para modificar un Alumno
    public static void modificarAlumno(Alumno alumnoModificado) {
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = alumnos.get(i);
            if (alumno.getDni().equals(alumnoModificado.getDni())) { // Usar DNI en lugar de LU
                alumnos.set(i, alumnoModificado);
                break;
            }
        }
    }

    // Método para eliminar un Alumno por DNI
    public static void eliminarAlumno(String dni) {
        alumnos.removeIf(alumno -> alumno.getDni().equals(dni)); // Usar DNI en lugar de LU
    }
}

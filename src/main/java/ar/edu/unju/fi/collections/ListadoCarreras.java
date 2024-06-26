package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
	public static List<Carrera> carreras = new ArrayList<Carrera>();

	// metodo para listar todas las carreras
	public static List<Carrera> listarCarreras() {
		// Filtrar solo las carreras activas
		return carreras;
		// .stream().filter(Carrera::isEstado).collect(Collectors.toList());

	}

	// metodo para buscar una carrera por ID

	public static Carrera buscarCarreraPorCodigo(String codigo) {
		for (Carrera c : carreras) {
			if (c.getCodigo().equals(codigo)) {
				return c;
			}
		}
		return null;
	}

	// Método para agregar una carrera
	public static boolean agregarCarrera(Carrera c) {
		// agregando el estado
		// c.setEstado(true);
		return carreras.add(c);
	}

	// Método para modificar una carrera
	public static void modificarCarrera(Carrera carreraModificada) {
		// carreraModificada.setEstado(true);
		for (int i = 0; i < carreras.size(); i++) {
			Carrera carrera = carreras.get(i);
			if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
				carreras.set(i, carreraModificada);
				break;
			} else {
				System.out.println("No se encuentra el codigo de Carrera");
			}
		}
	}

	// Método para eliminar una carrera
	public static void eliminarCarrera(String codigo) {
		// borrado físico
		// carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));

		// borrado lógico
		for (int i = 0; i < carreras.size(); i++) {
			Carrera carrera = carreras.get(i);
			if (carrera.getCodigo().equals(codigo)) {
				carrera.setEstado(false);
				;
				break;
			}
		}
	}
}

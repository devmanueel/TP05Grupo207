package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Materia;

public class ListadoMateria {
	
	public static List<Materia> materias = new ArrayList<Materia>();
	
	
	//metodo para listar todas las MATERIAS
	
	
	public static List<Materia> listarMaterias(){
		   
		 return materias;

	}
	
	
	public static Materia buscarMateriaPorCodigo(String codigo) {
	    for (Materia m : materias) {
	      if (m.getCodigo().equals(codigo)) {
	        return m;
	      }
	    }
	    return null;
	  }
	

	 // Método para agregar una materia
	 public static boolean agregarMateria(Materia m) {
		//agregando el estado
		  //c.setEstado(true); 
		  return materias.add(m);
	  }	
	
	// Método para modificar una carrera
	  public static void modificarMateria(Materia materiaModificada) {
		  //carreraModificada.setEstado(true);
	    for (int i = 0; i < materias.size(); i++) {
	      Materia materia = materias.get(i);
	      if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
	        materias.set(i, materiaModificada);
	        break;
	      }
	      else {
				System.out.println("No se encuentra el codigo de Carrera");
			}
	    }
	  }
	
	 // Método para eliminar una carrera
	  public static void eliminarMateria(String codigo) {
		  //borrado físico
	    //carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));
		  
		  //borrado lógico
		  for (int i = 0; i < materias.size(); i++) {
		      Materia materia = materias.get(i);
		      if (materia.getCodigo().equals(codigo)) {
		        materias.remove(i);;
		        break;
		      }
		    }
	  }	
}

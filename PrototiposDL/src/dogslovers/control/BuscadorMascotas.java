package dogslovers.control;

import java.util.LinkedList;
import java.util.Vector;

import dogslovers.modelo.Mascota;

public class BuscadorMascotas {
	
	LinkedList<Mascota> resultados;
	LinkedList<String> terminos;
	
	public BuscadorMascotas(LinkedList<Mascota> pLista, LinkedList<String> pTerminos) {
		resultados = pLista;
		terminos = pTerminos;
		buscar();
	}
	
	private void buscar(){
		for (int criterio = 0; criterio < 5; criterio++) {
			for (int temp = 0; temp < resultados.size(); temp++) {
				if (terminos.get(criterio) != "") {
					switch (criterio) {
						case 0: if (!resultados.get(temp).getNombre().toLowerCase().contains(terminos.get(criterio).toLowerCase())) 				resultados.remove(temp);
						break; 
						case 1: if (!resultados.get(temp).getExtravio().getLugar().toLowerCase().contains(terminos.get(criterio).toLowerCase())) 	resultados.remove(temp);
						break;
						case 2: if (!resultados.get(temp).getChipID().toString().contains(terminos.get(criterio).toLowerCase())) 					resultados.remove(temp); 
						break;
						case 3: if (resultados.get(temp).getEspecie() != terminos.get(criterio)) 													resultados.remove(temp); 
						break;
						case 4: if (resultados.get(temp).getRaza() != terminos.get(criterio)) 														resultados.remove(temp);
						break;
					}
				}
			}
		}
	}
	
	public Vector<Vector<String>> getVectorResultados(){
		Vector<Vector<String>> registros = new Vector<Vector<String>>();
		registros.setSize(resultados.size()); 
		for (int i = 0; i < resultados.size(); i++) {
			Vector<String> campos = new Vector<String>();
			campos.setSize(5);
			campos.add(resultados.get(i).getNombre());
			campos.add(resultados.get(i).getExtravio().getLugar());
			campos.add(resultados.get(i).getChipID().toString());
			campos.add(resultados.get(i).getEspecie());
			campos.add(resultados.get(i).getRaza());
			registros.add(campos);
		}
		return registros;
	}
	
	public Vector<String> getVectorTitulosColumnas(){
		Vector<String> titulos = new Vector<String>();
		titulos.setSize(5);
		titulos.add("Nombre Mascota");
		titulos.add("Lugar de Extrav\u00EDo");
		titulos.add("N\u00FAmero de Chip");
		titulos.add("Especie");
		titulos.add("Raza");
		return titulos;
	}
	
}

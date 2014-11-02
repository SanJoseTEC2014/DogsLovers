package dogslovers.control;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.LinkedList;

import dogslovers.modelo.Mascota;

public class BuscadorMascotas extends AbstractTableModel {

	private static String[] titulos = {"ID", "Nombre Mascota",
			"Lugar de Encuentro", "Especie", "Raza" };
	private ArrayList<Mascota> resultados;
	private LinkedList<String> terminos;

	public BuscadorMascotas(ArrayList<Mascota> pLista, LinkedList<String> pTerminos) {
		
		// TODO Es necesario parametrizar desde cúal lista quiere filtrar los resultados
		// TODO También aplica para las líneas 49 y 85.
		resultados = pLista;
		terminos = pTerminos;
		// Aquí antes de aplicar el algoritmo de búsqueda, se obtienen todas las Mascotas
		/*
		for (Mascota x : resultados){
			System.out.println(x);
		}
		*/
		buscar();
		// Aquí después de aplicarlo, quedan sólamente las mascotas de ID par.
		/*
		for (Mascota x : resultados){
			System.out.println(x);
		}
		*/
	}
		
	private void buscar () {
		for (int criterio = 0; criterio < 5; criterio++) {
			if (terminos.get(criterio) != "") {
				for (int temp = 0; temp < resultados.size(); temp++) {
					switch (criterio) {
						case 0:
							if (!resultados.get(temp).getNombre().toLowerCase()
									.contains(terminos.get(criterio).toLowerCase()))
								resultados.remove(temp);
							break;
						case 1:
							if (!resultados.get(temp).getEncuentro().getLugar()
									.toLowerCase()
									.contains(terminos.get(criterio).toLowerCase()))
								resultados.remove(temp);
							break;
						case 2:
							if (!resultados.get(temp).getNumeroChip().toString()
									.contains(terminos.get(criterio).toLowerCase()))
								resultados.remove(temp);
							break;
						case 3:
							if (resultados.get(temp).getEspecie() != terminos.get(criterio))
								resultados.remove(temp);
							break;
						case 4:
							if (resultados.get(temp).getRaza() != terminos.get(criterio))
								resultados.remove(temp);
							break;
					}
				}
			}
		}
	}


	public String getColumnName(int column) {
		return titulos[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return resultados.get(rowIndex).getID().toString();
		case 1:
			return resultados.get(rowIndex).getNombre();
		case 2:
			return resultados.get(rowIndex).getEncuentro().getLugar();
		case 3:
			return resultados.get(rowIndex).getEspecie();
		case 4:
			return resultados.get(rowIndex).getRaza();
		default:
			return null;
		}
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return resultados.size();
	}
}

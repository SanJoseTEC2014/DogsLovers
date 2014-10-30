package dogslovers.control;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.LinkedList;

import dogslovers.modelo.Mascota;

public class BuscadorMascotas extends AbstractTableModel {

	private static String[] titulos = { "Nombre Mascota",
			"Lugar de Extrav\u00EDo", "N\u00FAmero de Chip", "Especie", "Raza" };
	private ArrayList<Mascota> resultados;
	private LinkedList<String> terminos;

	public BuscadorMascotas(ArrayList<Mascota> pLista,
			LinkedList<String> pTerminos) {

		resultados = pLista;
		terminos = pTerminos;
		buscar();
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
							if (!resultados.get(temp).getPerdida().getLugar()
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
			return resultados.get(rowIndex).getNombre();
		case 1:
			return resultados.get(rowIndex).getPerdida().getLugar();
		case 2:
			return resultados.get(rowIndex).getNumeroChip().toString();
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
		// TODO Auto-generated method stub
		return resultados.size();
	}
}

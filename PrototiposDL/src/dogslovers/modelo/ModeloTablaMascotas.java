package dogslovers.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaMascotas extends AbstractTableModel {
	private ArrayList<Mascota> listaMascotas;
	private String[] titulos = {"ID", "Nombre Mascota", "Lugar de Encuentro", "Especie", "Raza" };

	public ModeloTablaMascotas(ArrayList<Mascota> pListaMascotas){
		listaMascotas = pListaMascotas;
	}
	public String getColumnName(int column) {
		return titulos[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaMascotas.get(rowIndex).getID().toString();
		case 1:
			return listaMascotas.get(rowIndex).getNombre();
		case 2:
			return listaMascotas.get(rowIndex).getEncuentro().getLugar();
		case 3:
			return listaMascotas.get(rowIndex).getEspecie();
		case 4:
			return listaMascotas.get(rowIndex).getRaza();
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
		return listaMascotas.size();
	}
	
	public int getCantidadDeResultados(){
		return listaMascotas.size();
	}

}

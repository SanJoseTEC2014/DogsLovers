package dogslovers.control;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.LinkedList;

import dogslovers.modelo.Mascota;

public class BuscadorMascotas extends AbstractTableModel {

	private String[] titulos = {"ID", "Nombre Mascota", "Lugar de Encuentro", "Especie", "Raza" };
	private ArrayList<Mascota> entrada;
	private ArrayList<Mascota> resultados;
	private LinkedList<String> terminos;

	public BuscadorMascotas(LinkedList<String> pTerminos, boolean[] listasABuscar) {
		
		entrada = new ArrayList<Mascota>();
		
		if (listasABuscar[0] == true) {
			entrada.addAll(Principal.getCopiaMascotasEncontradas());
		}
		if (listasABuscar[1] == true) {
			entrada.addAll(Principal.getCopiaMascotasPerdidas());
		}
		if (listasABuscar[2] == true) {
			entrada.addAll(Principal.getCopiaMascotasAdoptadas());
		}
		if (listasABuscar[3] == true) {
			entrada.addAll(Principal.getCopiaMascotasEnAdopcion());
		}
		if (listasABuscar[4] == true) {
			entrada.addAll(Principal.getCopiaMascotasRefugiadas());
		}
		
		resultados = new ArrayList<Mascota>();
		terminos = pTerminos;
		buscar();
	}
		
	private void buscar () {
		for (int numeroTermino = 0; numeroTermino < terminos.size(); numeroTermino++){
			String criterio = terminos.get(numeroTermino);
			if (criterio != "") {
				for (Mascota porFiltrar : entrada) {
					switch (numeroTermino){
						case 0: {
							if (nombreCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 1: {
							if (lugarEncuentroCoincide(porFiltrar, criterio) || lugarPerdidaCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 2: {
							if (numeroChipCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 3: {
							if (especieCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 4: {
							if (razaCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
					}
				}
			}
		}
	}
	
	private boolean nombreCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getNombre().toLowerCase().contains(pCriterio.toLowerCase());
	}
	
	private boolean lugarPerdidaCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getPerdida().getLugar().toLowerCase().contains(pCriterio.toLowerCase());
	}
	
	private boolean lugarEncuentroCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getEncuentro().getLugar().toLowerCase().contains(pCriterio.toLowerCase());
	}
	
	// Se asume que el criterio es un Integer validado desde la ventana
	private boolean numeroChipCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getNumeroChip() == Integer.getInteger(pCriterio);
	}
	
	private boolean especieCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getEspecie() == pCriterio;
	}
	
	private boolean razaCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getRaza() == pCriterio;
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
	
	public int getCantidadDeResultados(){
		return resultados.size();
	}
}

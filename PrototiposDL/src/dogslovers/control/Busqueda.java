package dogslovers.control;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.LinkedList;

import dogslovers.modelo.Mascota;

public class Busqueda {





	public static ArrayList<Mascota>  buscarMascotas(LinkedList<String> pTerminos, boolean[] listasABuscar) {
		
		ArrayList<Mascota> entrada = new ArrayList<Mascota>();
		
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
		
		ArrayList<Mascota> resultados = new ArrayList<Mascota>();
	
		for (int numeroTermino = 0; numeroTermino < pTerminos.size(); numeroTermino++){
			String criterio = pTerminos.get(numeroTermino);
			if (criterio != "") {
				for (Mascota porFiltrar : entrada) {
					
					// Verificación de los resultados de una búsqueda
					/*
					String debugmsg = nombreCoincide(porFiltrar, criterio) ? "true " : "false ";
					debugmsg += lugarEncuentroCoincide(porFiltrar, criterio) ? "true " : "false ";
					debugmsg += lugarPerdidaCoincide(porFiltrar, criterio) ? "true " : "false ";
					debugmsg += numeroChipCoincide(porFiltrar, criterio) ? "true " : "false ";
					debugmsg += especieCoincide(porFiltrar, criterio) ? "true " : "false ";
					debugmsg += razaCoincide(porFiltrar, criterio) ? "true " : "false ";
					System.out.println(debugmsg);
					*/
					
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
		
		return resultados;
	}
	
	private static boolean nombreCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getNombre().toLowerCase().contains(pCriterio.toLowerCase());
	}
	
	private static boolean lugarPerdidaCoincide(Mascota pMascota, String pCriterio){
		if (pMascota.getPerdida() != null) {
			return pMascota.getPerdida().getLugar().toLowerCase().contains(pCriterio.toLowerCase());
		}
		return false;
	}
	
	private static boolean lugarEncuentroCoincide(Mascota pMascota, String pCriterio){
		if (pMascota.getEncuentro() != null) {
			return pMascota.getEncuentro().getLugar().toLowerCase().contains(pCriterio.toLowerCase());
		}
		return false;
	}
	
	private static boolean numeroChipCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getNumeroChip().equals(pCriterio);
	}
	
	private static boolean especieCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getEspecie().equals(pCriterio);
	}
	
	private static boolean razaCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getRaza().equals(pCriterio);
	}
}

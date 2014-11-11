package dogslovers.control;
/**	 Controlador Búsqueda: 
 * 	 Esta clase implementa los métodos que se encargan
 * 	 de realizar la búsqueda de usuarios y mascotas en 
 *   el sistema.
 * 
 *	Fecha de creación: 17/10/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.LinkedList;

import dogslovers.modelo.Mascota;
import dogslovers.modelo.Usuario;

public class Busqueda {

	public static ArrayList<Mascota>  buscarMascotas(LinkedList<String> pTerminos, boolean[] listasABuscar) {
		
		ArrayList<Mascota> listaMascotas = new ArrayList<Mascota>();
		
		if (listasABuscar[0] == true) {
			listaMascotas.addAll(Principal.getCopiaMascotasEncontradas());
		}
		if (listasABuscar[1] == true) {
			listaMascotas.addAll(Principal.getCopiaMascotasPerdidas());
		}
		if (listasABuscar[2] == true) {
			listaMascotas.addAll(Principal.getCopiaMascotasAdoptadas());
		}
		if (listasABuscar[3] == true) {
			listaMascotas.addAll(Principal.getCopiaMascotasEnAdopcion());
		}
		if (listasABuscar[4] == true) {
			listaMascotas.addAll(Principal.getCopiaMascotasRefugiadas());
		}
		
		ArrayList<Mascota> resultados = new ArrayList<Mascota>();
	
		for (int numeroTermino = 0; numeroTermino < pTerminos.size(); numeroTermino++){
			String criterio = pTerminos.get(numeroTermino);
			if (criterio != "") {
				for (Mascota porFiltrar : listaMascotas) {
					
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
		if (pMascota.getEstadoActual() == MaquinaEstadosMascotas.estadoPERDIDA) {
			return pMascota.getUltimoSuceso().getLugar().toLowerCase().contains(pCriterio.toLowerCase());
		}
		return false;
	}
	
	private static boolean lugarEncuentroCoincide(Mascota pMascota, String pCriterio){
		if (pMascota.getEstadoActual() == MaquinaEstadosMascotas.estadoENCONTRADA) {
			return pMascota.getUltimoSuceso().getLugar().toLowerCase().contains(pCriterio.toLowerCase());
		}
		return false;
	}
	
	private static boolean numeroChipCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getNumeroChip() == null? false : pMascota.getNumeroChip().equals(pCriterio);
	}
	
	private static boolean especieCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getEspecie().equals(pCriterio);
	}
	
	private static boolean razaCoincide(Mascota pMascota, String pCriterio){
		return pMascota.getRaza().equals(pCriterio);
	}

	
	//////////////////////////////// BLOQUE BUSQUEDA DE USUARIOS /////////////////////////////
	
	public static ArrayList<Usuario> buscarUsuarios(LinkedList<String> pTerminos, boolean soloUsusariosRefugiantes) {

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		

		if (soloUsusariosRefugiantes) {
			listaUsuarios.addAll(Principal.getCopiaUsuariosRefugiantes());
		}else {
			listaUsuarios.addAll(Principal.getCopiaUsuarios());
		}
		
		ArrayList<Usuario> resultados = new ArrayList<Usuario>();
	
		for (int numeroTermino = 0; numeroTermino < pTerminos.size(); numeroTermino++){
			String criterio = pTerminos.get(numeroTermino);
			if (criterio != "") {
				for (Usuario porFiltrar : listaUsuarios) {
					
					
					switch (numeroTermino){
						case 0: {
							if (nickCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 1: {
							if (nombreCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 2: {
							if (apellidosCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 3: {
							if (cedulaCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 4: {
							if (numTelefonoCoincide(porFiltrar, criterio)){
								resultados.add(porFiltrar);
							}
						}
						break;
						case 5: {
							if (correoCoincide(porFiltrar, criterio)){
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

	private static boolean correoCoincide(Usuario pUsuario, String pCriterio) {
		return pUsuario.getCorreo().toLowerCase().contains(pCriterio.toLowerCase());
	}

	private static boolean numTelefonoCoincide(Usuario pUsuario, String pCriterio) {
		return pUsuario.getTelefono().toString().contains(pCriterio);
	}

	private static boolean cedulaCoincide(Usuario pUsuario, String pCriterio) {
		return pUsuario.getCedula().toString().contains(pCriterio);
	}

	private static boolean apellidosCoincide(Usuario pUsuario, String pCriterio) {
		return pUsuario.getApellidos().toLowerCase().contains(pCriterio.toLowerCase());
	}

	private static boolean nombreCoincide(Usuario pUsuario, String pCriterio) {
		return pUsuario.getNombre().toLowerCase().contains(pCriterio.toLowerCase());

	}

	private static boolean nickCoincide(Usuario pUsuario, String pCriterio) {
		return pUsuario.getNickname().toLowerCase().contains(pCriterio.toLowerCase());
	}
}

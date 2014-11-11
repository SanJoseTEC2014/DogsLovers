package dogslovers.control;

/**	 Controlador Coordinador Visual: 
 * 	 Esta clase implementa diversos métodos que permiten
 * 	 mostrar y ocultar cada una de las ventanas de la aplicación.
 * 
 *	Fecha de creación: 7/11/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

import java.awt.Window;

import javax.swing.JFrame;

import dogslovers.modelo.Mascota;
import dogslovers.modelo.Usuario;
import dogslovers.vista.*;

public class CoordinadorVisual {
	private VentanaParametrosSistema parametrosSistema;
	private VentanaMenuPrincipal menuPrincipal;
	private VentanaDetallesUsuario detallesUsuario;
	private VentanaDetallesMascota detallesMascota;
	private VentanaBusqueda busqueda;
	
	private JFrame ventanaActiva;
	private VentanaCondicionesRefugio condicionesRefugio;
	private VentanaMascotasDeUsuario mascotasAsociadas;
	private VentanaCalificaciones calificaciones;
	
	public CoordinadorVisual(){
		parametrosSistema = new VentanaParametrosSistema();
		menuPrincipal = new VentanaMenuPrincipal();
		detallesUsuario = new VentanaDetallesUsuario();
		detallesMascota = new VentanaDetallesMascota();
		busqueda = new VentanaBusqueda();
		condicionesRefugio = new VentanaCondicionesRefugio();
		agregarComentario = new VentanaAgregarComentario();
		mascotasAsociadas = new VentanaMascotasDeUsuario();
		calificaciones = new VentanaCalificaciones();
	}
	
	public synchronized void mostrarInicioSesion() {
		ocultarVentanas();
		VentanaInicioSesion inicioSesion = new VentanaInicioSesion();
		inicioSesion.setVisible(true);
		ventanaActiva = inicioSesion;
	}

	public synchronized void mostrarParametrosSistema() {
		parametrosSistema.setVisible(Acceso.isAdministradorActivo());
		parametrosSistema.setMensajeNuevo();
		parametrosSistema.setVisible(true);
	}

	public synchronized void mostrarMenuPrincipal() {
		ocultarVentanas();
		menuPrincipal.setVisible(true);
		menuPrincipal.setUsuario();
	}

	public synchronized void mostrarDetallesUsuario(Usuario usuarioActual) {
		detallesUsuario.setDatosIniciales(usuarioActual);
		detallesUsuario.setModoEdicion(usuarioActual == Acceso.getUsuarioActivo());
		detallesUsuario.setVisible(true);
	}

	public synchronized void mostrarRegistroUsuarios() {
		VentanaRegistroUsuarios registroUsuarios = new VentanaRegistroUsuarios();
		registroUsuarios.setVisible(true);
	}

	public synchronized void mostrarRegistroMascotas() {
		VentanaRegistroMascotas registroMascotas = new VentanaRegistroMascotas();
		registroMascotas.setVisible(true);
	}

	public synchronized void mostrarBusqueda() {
		busqueda.setVisible(true);
	}
	
	public synchronized void mostrarAgregarComentario(Usuario usuarioACalificar){
		VentanaAgregarComentario agregarComentario = new VentanaAgregarComentario();
		agregarComentario.setUsuarioACalificar(usuarioACalificar);
		agregarComentario.setVisible(true);		
	}
	
	private synchronized void ocultarVentanas() {
		parametrosSistema.setVisible(false);
		menuPrincipal.setVisible(false);
		detallesUsuario.setVisible(false);
		detallesMascota.setVisible(false);
		busqueda.setVisible(false);
		agregarComentario.setVisible(false);
	}
	
	public synchronized void mostrarVentanas() {
		parametrosSistema.setVisible(true);
		menuPrincipal.setVisible(true);
		detallesUsuario.setVisible(true);
		detallesMascota.setVisible(true);
		busqueda.setVisible(true);
		agregarComentario.setVisible(true);
	}

	public void mostrarCondicionesRefugio(Usuario usuarioActual) {
		
		condicionesRefugio.setDatos(usuarioActual);
		condicionesRefugio.setVisible(true);
		condicionesRefugio.setModoEdicion(usuarioActual == Acceso.getUsuarioActivo());
	}
	
	public void mostrarMascotasAsociadas(Usuario usuarioActual){
		mascotasAsociadas.setUsuario(usuarioActual);
		mascotasAsociadas.setVisible(true);
	}

	public void mostrarCalificaciones(Usuario usuarioActual) {
		calificaciones.setUsuario(usuarioActual);
		calificaciones.setVisible(true);
		
	}

	public void mostrarDetallesMascota(Mascota mascota) {
		detallesMascota.setDatosIniciales(mascota);
		detallesMascota.setVisible(true);
	}
}

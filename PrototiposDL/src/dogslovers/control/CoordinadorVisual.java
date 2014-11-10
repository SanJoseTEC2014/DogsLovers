package dogslovers.control;

import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dogslovers.control.excepciones.UsuarioNoExisteException;
import dogslovers.modelo.Mascota;
import dogslovers.modelo.Usuario;
import dogslovers.vista.*;

public class CoordinadorVisual {
	private VentanaInicioSesion inicioSesion;
	private VentanaParametrosSistema parametrosSistema;
	private VentanaMenuPrincipal menuPrincipal;
	private VentanaDetallesUsuario detallesUsuario;
	private VentanaDetallesMascota detallesMascota;
	private VentanaRegistroUsuarios registroUsuarios;
	private VentanaRegistroMascotas registroMascotas;
	private VentanaBusqueda busqueda;
	private VentanaAgregarComentario agregarComentario;
	
	private JFrame ventanaActiva;
	private VentanaCondicionesRefugio condicionesRefugio;
	private VentanaMascotasDeUsuario mascotasAsociadas;
	private VentanaCalificaciones calificaciones;
	
	public CoordinadorVisual(){
		inicioSesion = new VentanaInicioSesion();
		parametrosSistema = new VentanaParametrosSistema();
		menuPrincipal = new VentanaMenuPrincipal();
		detallesUsuario = new VentanaDetallesUsuario();
		detallesMascota = new VentanaDetallesMascota();
		registroUsuarios = new VentanaRegistroUsuarios();
		registroMascotas = new VentanaRegistroMascotas();
		busqueda = new VentanaBusqueda();
		condicionesRefugio = new VentanaCondicionesRefugio();
		agregarComentario = new VentanaAgregarComentario();
		mascotasAsociadas = new VentanaMascotasDeUsuario();
		calificaciones = new VentanaCalificaciones();
		
	}
	
	public synchronized void mostrarInicioSesion() {
		ocultarVentanas();
		inicioSesion.setVisible(true);
		ventanaActiva = inicioSesion;
	}

	public synchronized void mostrarParametrosSistema() {
		parametrosSistema.setVisible(Acceso.isAdministradorActivo());
	}

	public synchronized void mostrarMenuPrincipal() {
		ocultarVentanas();
		menuPrincipal.setUsuario();
		menuPrincipal.setVisible(true);
	}

	public synchronized void mostrarDetallesUsuario(Usuario usuarioActual) {
		detallesUsuario.setDatosIniciales(usuarioActual);
		detallesUsuario.setModoEdicion(usuarioActual == Acceso.getUsuarioActivo());
		detallesUsuario.setVisible(true);
	}

	public synchronized void mostrarDetallesMascota(Mascota mascotaActual) {
		detallesMascota.setDatosIniciales(mascotaActual);
		
		
		// Si la mascota está actualmente perdida "O" encontrada y 
		// la persona que registro ese estado es la persona activa
		// en el sistema, tiene permiso de modificar la informacion
		try {
			detallesMascota.setModoEdicion((mascotaActual.getEstadoActual().equals(MaquinaEstadosMascotas.estadoENCONTRADA) 
							|| mascotaActual.getEstadoActual().equals(MaquinaEstadosMascotas.estadoPERDIDA))
							&& Principal.getUsuarioListaBlanca(mascotaActual.getUltimoSuceso().getNick()) == Acceso
									.getUsuarioActivo());
		} catch (UsuarioNoExisteException e) {
			JOptionPane.showMessageDialog(null, "Usuario no activo/encontrado", "Error del sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		detallesMascota.setVisible(true);
	}

	public synchronized void mostrarRegistroUsuarios() {
		ocultarVentanas();
	}

	public synchronized void mostrarRegistroMascotas() {
		registroMascotas.setVisible(true);
	}

	public synchronized void mostrarBusqueda() {
		busqueda.setVisible(true);
	}
	
	public synchronized void mostrarAgregarComentario(Usuario usuarioACalificar){
		agregarComentario.setUsuarioACalificar(usuarioACalificar);
		agregarComentario.setVisible(true);		
	}
	
	private synchronized void ocultarVentanas() {
		inicioSesion.setVisible(false);
		parametrosSistema.setVisible(false);
		menuPrincipal.setVisible(false);
		detallesUsuario.setVisible(false);
		detallesMascota.setVisible(false);
		registroUsuarios.setVisible(false);
		registroMascotas.setVisible(false);
		busqueda.setVisible(false);
		agregarComentario.setVisible(false);
	}
	
	public synchronized void mostrarVentanas() {
		inicioSesion.setVisible(true);
		parametrosSistema.setVisible(true);
		menuPrincipal.setVisible(true);
		detallesUsuario.setVisible(true);
		detallesMascota.setVisible(true);
		registroUsuarios.setVisible(true);
		registroMascotas.setVisible(true);
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
	
}

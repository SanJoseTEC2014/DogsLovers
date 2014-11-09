package dogslovers.control;

import java.awt.Window;

import javax.swing.JFrame;

import dogslovers.modelo.Usuario;
import dogslovers.vista.*;

public class CoordinadorVisual {
	private VentanaInicioSesion inicioSesion;
	private VentanaParametrosSistema parametrosSistema;
	private VentanaPrincipal menuPrincipal;
	private VentanaDetallesUsuario detallesUsuario;
	private VentanaDetallesMascota detallesMascota;
	private VentanaRegistroUsuarios registroUsuarios;
	private VentanaRegistroMascotas registroMascotas;
	private VentanaBusquedaMascotas busquedaMascotas;
	private VentanaAgregarComentario agregarComentario;
	
	private JFrame ventanaActiva;
	private VentanaCondicionesRefugio condicionesRefugio;
	
	public CoordinadorVisual(){
		inicioSesion = new VentanaInicioSesion();
		parametrosSistema = new VentanaParametrosSistema();
		menuPrincipal = new VentanaPrincipal();
		detallesUsuario = new VentanaDetallesUsuario();
		detallesMascota = new VentanaDetallesMascota();
		registroUsuarios = new VentanaRegistroUsuarios();
		registroMascotas = new VentanaRegistroMascotas();
		busquedaMascotas = new VentanaBusquedaMascotas();
		condicionesRefugio = new VentanaCondicionesRefugio();
		agregarComentario = new VentanaAgregarComentario();
	}
	
	public synchronized void mostrarInicioSesion() {
		ocultarVentanas();
		inicioSesion.setVisible(true);
		ventanaActiva = inicioSesion;
	}

	public synchronized void mostrarParametrosSistema() {
		ocultarVentanas();
	}

	public synchronized void mostrarMenuPrincipal() {
		ocultarVentanas();
	}

	public synchronized void mostrarDetallesUsuario() {
		ocultarVentanas();
		detallesUsuario.setDatosIniciales(Acceso.getUsuarioActivo());
		detallesUsuario.setModoEdicion(false);
		detallesUsuario.setVisible(true);
	}

	public synchronized void mostrarDetallesMascota() {
		ocultarVentanas();
	}

	public synchronized void mostrarRegistroUsuarios() {
		ocultarVentanas();
	}

	public synchronized void mostrarRegistroMascotas() {
		ocultarVentanas();
	}

	public synchronized void mostrarBusquedaMascotas() {
		ocultarVentanas();
		busquedaMascotas.setVisible(true);
	}
	
	public synchronized void mostrarAgregarComentario(){
		ocultarVentanas();
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
		busquedaMascotas.setVisible(false);
		agregarComentario.setVisible(false);
	}

	public void mostrarCondicionesRefugio(Usuario usuarioActual) {
		condicionesRefugio.setDatos(usuarioActual);
		condicionesRefugio.setVisible(true);
		
	}
	
}

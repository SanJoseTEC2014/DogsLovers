package dogslovers.modelo;
/**	Prototipo de la clase Mascota
 *	Fecha de creaci�n: 03/10/2014
 * 
 *	@author Isaac Antonio Campos Mes�n 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa Mar�a Molina Corrales 2013006074
 *	@author Luis Andr�s Pe�a Castillo 2014057250 
 *  
 */

import java.util.LinkedList;

public class Mascota {
	
	public static LinkedList<String> especies = new LinkedList<String>();
	public static LinkedList<String[]> razas = new LinkedList<String[]>(); 
	private static Integer totalChips = 0;
	
	private String nombre;
	private Integer chipID; // Se usa tambi�n para la foto: /src/imagenes/mascotas/chipID.png
	private String especie;
	private String raza;
	private String estado;
	
	private Integer telefonoDuenio;
	private String correoDuenio;
	
	private Integer telefonoColaborador;
	private String correoColaborador;
	
	private Suceso extravio;
	private Suceso encuentro;

	private Integer recompensa;
	private String notasSecundarias;
	
	public Mascota(String pNombre, Integer pTelefonoDuenio, String pCorreoDuenio, Integer pIndiceEspecie, Integer pIndiceRaza,
				   Suceso pExtravio, Integer pRecompensa, String pNotasSecundarias) {
		nombre = pNombre;
		chipID = ++totalChips;
		telefonoDuenio = pTelefonoDuenio;
		correoDuenio = pCorreoDuenio;
		estado = "Perdido";
		
		especie = Mascota.especies.get(pIndiceEspecie);
		raza = Mascota.razas.get(pIndiceEspecie)[pIndiceRaza];
		
		extravio = pExtravio;
		
		recompensa = pRecompensa;
		notasSecundarias = pNotasSecundarias;
	}

	public String 	getNombre() 								{		return nombre;						}
	public void 	setNombre(String pNombre) 					{		nombre = pNombre;					}
	
	public Integer 	getChipID() 								{		return chipID;						}
	public void 	setChipID(Integer pChipID) 					{		chipID = pChipID;					}
	
	public String 	getEspecie() 								{		return especie;						}
	public void 	setEspecie(String pEspecie)					{		especie = pEspecie;					}
	
	public String 	getRaza() 									{		return raza;						}
	public void 	setRaza(String pRaza) 						{		raza = pRaza;						}
	
	public Integer 	getTelefonoDuenio() 						{		return telefonoDuenio;				}
	public void 	setTelefonoDuenio(Integer pTelefono) 		{		telefonoDuenio = pTelefono;			}
	
	public Integer 	getTelefonoColaborador() 					{		return telefonoColaborador;			}
	public void setTelefonoColaborador(Integer pTelefono) 		{		telefonoColaborador = pTelefono;	}
	
	public String getCorreoDuenio() 							{		return correoDuenio;				}
	public void setCorreoDuenio(String pCorreo) 				{		correoDuenio = pCorreo;				}
	
	public String getCorreoColaborador() 						{		return correoColaborador;			}
	public void setCorreoColaborador(String pCorreo) 			{		correoColaborador = pCorreo;		}
	
	public Suceso getExtravio() 								{		return extravio;					}
	public void setExtravio(Suceso pLugar) 						{		extravio = pLugar;					}
	
	public Suceso getEncuentro() 								{		return encuentro;					}
	public void setEncuentro(Suceso pLugar) 					{		encuentro = pLugar;					}
	
	public Integer getRecompensa() 								{		return recompensa;					}
	public void setRecompensa(Integer pRecompensa) 				{		recompensa = pRecompensa;			}
	
	public String getNotasSecundarias() 						{		return notasSecundarias;			}
	public void setNotasSecundarias(String pNotas) 				{		notasSecundarias = pNotas;			}

	/// MAQUINA DE ESTADOS
	public String getEstado() 									{		return estado;						}
	public void setEstado(String pEstado) 						{		estado = pEstado;					}
	
	public String toString(){
		String msg = "Nombre de la mascota: " + getNombre();
		msg += "\nNumero ID en el chip: " + getChipID();
		msg += "\nTel�fono del due�o: " + getTelefonoDuenio();
		msg += "\nCorreo del due�o: " + getCorreoDuenio();
		msg += "\nEstado de la mascota: " + getEstado();
		
		msg += "\n\nEspecie de la mascota: " + getEspecie();
		msg += "\nRaza de la mascota: " + getRaza();
		
		msg += "\n\nTel�fono del colaborador: " + getTelefonoColaborador();
		msg += "\nCorreo del colaborador: " + getCorreoColaborador();
		
		msg += "\nExtrav�o: \n" + extravio.toString();
		//msg += "\n\nEncuentro: " + encuentro.toString();
		
		msg += "\n\nMonto de recompensa: " + getRecompensa();
		msg += "\nNotas Secundarias: " + getNotasSecundarias();
		return msg;
	}
	
	
	
}

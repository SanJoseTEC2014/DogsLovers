package actores;
/**	Prototipo de la clase Mascota
 *	Fecha de creación: 03/10/2014
 * 
 *	@author Isaac Antonio Campos Mesén 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa María Molina Corrales 2013006074
 *	@author Luis Andrés Peña Castillo 2014057250 
 *  
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

public class Mascota {
	
	public static LinkedList<String> especies = new LinkedList<String>();
	public static LinkedList<LinkedList<String>> razas = new LinkedList<LinkedList<String>>(); 
	private static Integer totalChips = 0;
	
	private String nombre;
	private Integer chipID; // Se usa también para la foto: /src/imagenes/mascotas/chipID.png
	private String especie;
	private String raza;
	private String estado;
	
	private Integer telefonoDuenio;
	private String correoDuenio;
	
	private Integer telefonoColaborador;
	private String correoColaborador;
	
	private String lugarExtravio;
	private Calendar fechaExtravio;
	
	private String lugarEncuentro;
	private Calendar fechaEncuentro;
	
	private Integer recompensa;
	private String notasSecundarias;
	
	public Mascota(String pNombre, Integer pChipID, Integer pTelefonoDuenio, String pCorreoDuenio, Integer pIndiceEspecie, Integer pIndiceRaza,
				   String pLugarExtravio, Calendar pFechaExtravio, Integer pRecompensa, String pNotasSecundarias) {
		nombre = pNombre;
		chipID = pChipID;
		telefonoDuenio = pTelefonoDuenio;
		correoDuenio = pCorreoDuenio;
		estado = "Perdido";
		
		especie = Mascota.especies.get(pIndiceEspecie);
		raza = Mascota.razas.get(pIndiceEspecie).get(pIndiceRaza);
		
		lugarExtravio = pLugarExtravio;
		fechaExtravio = pFechaExtravio;
		
		recompensa = pRecompensa;
		notasSecundarias = pNotasSecundarias;
	}

	public static void main(String[] args) {
		Mascota.especies.add("Perro");
		
		LinkedList<String> razasPerros = new LinkedList<String>();
		
		razasPerros.add("Otro");
		razasPerros.add("Chihuahua");
		razasPerros.add("Schnauzer");
		razasPerros.add("Doberman");
		razasPerros.add("Salchicha");
		
		Mascota.razas.add(razasPerros);
		
		Calendar fechaLucky = Calendar.getInstance();
		fechaLucky.set(2014, 9, 26);
		
		
		LinkedList<Mascota> prototipo = new LinkedList<Mascota>();
		prototipo.add(new Mascota("Lucky", Mascota.totalChips++, 83511265, "bormo1218@gmail.com", 0, 1, "Heredia", fechaLucky, 50000, "Agradable."));
		
		for (Mascota i : prototipo){
			System.out.println(i);
		}
		
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
	
	public String getLugarExtravio() 							{		return lugarExtravio;				}
	public void setLugarExtravio(String pLugar) 				{		lugarExtravio = pLugar;				}
	
	public String getLugarEncuentro() 							{		return lugarEncuentro;				}
	public void setLugarEncuentro(String pLugar) 				{		lugarEncuentro = pLugar;			}
	
	public Integer getRecompensa() 								{		return recompensa;					}
	public void setRecompensa(Integer pRecompensa) 				{		recompensa = pRecompensa;			}
	
	public String getNotasSecundarias() 						{		return notasSecundarias;			}
	public void setNotasSecundarias(String pNotas) 				{		notasSecundarias = pNotas;			}
	
	public String getFechaExtravio() 							{		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
																		return mascara.format(fechaExtravio.getTime());	}
	public void setFechaExtravio(Calendar pFecha) 				{		fechaExtravio = pFecha;				}
	
	public String getFechaEncuentro() 							{		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
																		return mascara.format(fechaEncuentro.getTime());	}
	public void setFechaEncuentro(Calendar pFecha) 				{		fechaEncuentro = pFecha;			}

	/// MAQUINA DE ESTADOS
	public String getEstado() 									{		return estado;	}
	
	
	public String toString(){
		String msg = "Nombre de la mascota: " + getNombre();
		msg += "\nNumero ID en el chip: " + getChipID();
		msg += "\nTeléfono del dueño: " + getTelefonoDuenio();
		msg += "\nCorreo del dueño: " + getCorreoDuenio();
		msg += "\nEstado de la mascota: " + getEstado();
		
		msg += "\n\nEspecie de la mascota: " + getEspecie();
		msg += "\nRaza de la mascota: " + getRaza();
		
		msg += "\n\nTeléfono del colaborador: " + getTelefonoColaborador();
		msg += "\nCorreo del colaborador: " + getCorreoColaborador();
		
		msg += "\nLugar donde se extravió: " + getLugarExtravio();
		msg += "\nFecha donde se extravió: " + getFechaExtravio();
		
		//msg += "\n\nLugar donde se encontró: " + getLugarEncuentro();
		//msg += "\nFecha donde se encontró: " + getFechaEncuentro();
		
		msg += "\n\nMonto de recompensa: " + getRecompensa();
		msg += "\nNotas Secundarias: " + getNotasSecundarias();
		return msg;
	}
	
}

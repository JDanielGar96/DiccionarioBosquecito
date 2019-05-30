package Controlador;

import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Modelo.ArchivadorFrecuencia;
import Modelo.Archivo;
import Modelo.Diccionario;
import Vista.VentanaPrincipal;

/**
 * Controla las clases que se encuentran en los paquetes Modelo y Vista,
 * utilizando distintos metodos que haran la labor de comunicar las clases de
 * dichos paquetes. Generando objetos de tipo VentanaPrincial, Diccionario y
 * Archivo
 * 
 * @author Oscar Romero y Daniel Garcia
 *
 */
public class Control {

	private VentanaPrincipal ventana; // Sera la ventana que va a ver el usuario
	private Diccionario diccionarioEng; // Sera el diccionario de ingles que cargara el usuario
	private Diccionario diccionarioFra; // Sera el diccionario de Frances que cargara el usuario
	private Diccionario diccionarioIta; // Sera el diccionario de Italiano que cargara el usuario
	private Archivo archivo;
	private ArchivadorFrecuencia frecuencia;

	/*
	 * Este es el constructor de la clase donde se inicializan las variables creando
	 * objetos de las clases respectivas
	 */
	public Control() {
		this.ventana = new VentanaPrincipal(this);
		this.frecuencia = new ArchivadorFrecuencia();

		this.diccionarioEng = new Diccionario("ENG");
		this.diccionarioFra = new Diccionario("FRA");
		this.diccionarioIta = new Diccionario("ITA");

		try {
			archivo = new Archivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Este metodo se encarga de agregar las palabras que recibe de la vista a los
	 * diccionarios respectivos de cada idioma por medio de las parametros de
	 * cadenas de texto palabra, traduccion e idioma. A su vez conecta con el metodo
	 * de la clase Archivo donde escribira la palabra agregada.
	 */
	public void agregarPalabra(String palabra, String traduccion, String idioma) {
		switch (idioma) {
		case "ENG":
			this.diccionarioEng.agregarPalabra(palabra, traduccion);
			this.archivo.agregarPalabra(palabra, traduccion, idioma);
			break;
		case "FRA":
			this.diccionarioFra.agregarPalabra(palabra, traduccion);
			this.archivo.agregarPalabra(palabra, traduccion, idioma);
			break;
		case "ITA":
			this.diccionarioIta.agregarPalabra(palabra, traduccion);
			this.archivo.agregarPalabra(palabra, traduccion, idioma);
			break;
		default:
			break;
		}
	}

	/*
	 * Este metodo buscara la traduccion de una palabra introducida por el usuario
	 * en los objetis de la clase diccionario y utilizando el metro
	 * traduccionPalabra de dicha clase. Esto lo hara recibiendo como parametros la
	 * palabra que se busca traducir en espanol, el idioma de la palabra ingresada
	 * (ESP) y el idioma del que quiere saber la traduccion, retornando finalmente
	 * la palabra traducida en ese idioma. En caso de que el usuario seleccione que
	 * la palabra buscada no es de idioma espanol se usuara el metodo
	 * traduccionInversaPalabra que retornada la traduccion de dicha palabra en el
	 * idioma en que se busca traducir
	 */
	public String buscarTraduccion(String palabraBuscada, String idiomaOrigen, String idiomaDestino) {
		String traduccion = "";

		if (idiomaOrigen.equalsIgnoreCase("ESP")) {
			switch (idiomaDestino) {
			case "ENG":
				traduccion = this.diccionarioEng.traduccionPalabra(palabraBuscada);
				break;
			case "FRA":
				traduccion = this.diccionarioFra.traduccionPalabra(palabraBuscada);
				break;
			case "ITA":
				traduccion = this.diccionarioIta.traduccionPalabra(palabraBuscada);
				break;
			default:
				break;
			}
			this.frecuencia.agregarRegistro(palabraBuscada);
		} else {
			switch (idiomaOrigen) {
			case "ENG":
				traduccion = this.diccionarioEng.traduccionInversaPalabra(palabraBuscada);
				break;
			case "FRA":
				traduccion = this.diccionarioFra.traduccionInversaPalabra(palabraBuscada);
				break;
			case "ITA":
				traduccion = this.diccionarioIta.traduccionInversaPalabra(palabraBuscada);
				break;
			default:
				break;
			}
			this.frecuencia.agregarRegistro(palabraBuscada);
		}
		return traduccion;
	}

	/*
	 * Este metodo conecta la vista cuando se selecciona el boton Cargar Diccionario
	 * con el objeto de la clase diccionario y utiliza su metodo cargarDiccionario
	 * dependiendo del diccionario que desee cargar el usario cuando selecciona en
	 * la clase CargarDiccionario.
	 */
	public void agregarDiccionario(String idioma) {
		switch (idioma) {
		case "ENG":
			this.diccionarioEng.cargarDiccionario("./Diccionario/eng.properties");
			break;
		case "FRA":
			this.diccionarioFra.cargarDiccionario("./Diccionario/fra.properties");
			break;
		case "ITA":
			this.diccionarioIta.cargarDiccionario("./Diccionario/ita.properties");
			;
			break;
		default:
			break;
		}
	}
	
	public String obtenerPalabrasFrecuentes() {
		this.frecuencia.escribirRegistros();
		return this.frecuencia.obtenerFrecuenciaPalabras();
	}

	public int[] actualizarNumeroPalabras() {
		int[] numeroPalabras = new int[3];
		
		numeroPalabras[0] = this.diccionarioEng.contarTraducciones();
		
		System.out.println("Numero de traducciones en ingles " + numeroPalabras[0]);
		numeroPalabras[1] = this.diccionarioFra.contarTraducciones();
		numeroPalabras[2] = this.diccionarioIta.contarTraducciones();
		
		return numeroPalabras;
	}

}
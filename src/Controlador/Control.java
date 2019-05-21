package Controlador;

import Modelo.Diccionario;
import Vista.VentanaPrincipal;

public class Control {

	private VentanaPrincipal ventana;
	private Diccionario diccionarioEng;
	private Diccionario diccionarioFra;
	private Diccionario diccionarioIta;
	
	public Control() {
		this.ventana = new VentanaPrincipal(this);
		
		this.diccionarioEng = new Diccionario("ENG");
		this.diccionarioFra = new Diccionario("FRA");
		this.diccionarioIta = new Diccionario("ITA");
	}	
	
	public void agregarPalabra(String palabra, String traduccion, String idioma) { 
		switch(idioma) {
		case "ENG":
			this.diccionarioEng.agregarPalabra(palabra, traduccion);
			break;
		case "FRA":
			this.diccionarioFra.agregarPalabra(palabra, traduccion);
			break;
		case "ITA":
			this.diccionarioIta.agregarPalabra(palabra, traduccion);
			break;
		default:
			break;
		}
	}
	
	public String buscarTraduccion(String palabra, String idioma) {
		String traduccion = "";
		switch(idioma) {
		case "ENG":
			traduccion = this.diccionarioEng.buscarTraduccion(palabra);
			break;
		case "FRA":
			traduccion = this.diccionarioFra.buscarTraduccion(palabra);
			break;
		case "ITA":
			traduccion = this.diccionarioIta.buscarTraduccion(palabra);
			break;
		default:
			break;
		}
		return traduccion;
	}
}

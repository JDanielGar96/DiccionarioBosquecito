package Controlador;

import java.io.IOException;

import javax.swing.JLabel;

import Modelo.Archivo;
import Modelo.Diccionario;
import Vista.VentanaPrincipal;

public class Control {

	private VentanaPrincipal ventana;
	private Diccionario diccionarioEng;
	private Diccionario diccionarioFra;
	private Diccionario diccionarioIta;
	private Archivo archivo;

	public Control() {
		this.ventana = new VentanaPrincipal(this);

		this.diccionarioEng = new Diccionario("ENG");
		this.diccionarioFra = new Diccionario("FRA");
		this.diccionarioIta = new Diccionario("ITA");

		try {
			archivo = new Archivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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

	public String buscarTraduccion( String palabraBuscada, 
									String idiomaOrigen,
									String idiomaDestino, 
									String traduccion) {
		String traducido = "";
		
		if(idiomaOrigen.equalsIgnoreCase("ESP")) {				
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
		}
		return traducido;
	}
	
	public void agregarDiccionario(String idioma) {
		switch(idioma) {
		case "ENG":
			this.diccionarioEng.cargarDiccionario();
			break;
		case "FRA":
			this.diccionarioFra.cargarDiccionario();
			break;
		case "ITA":
			this.diccionarioIta.cargarDiccionario();
			break;
		default:
			break;
		}
	}
	
	public void frecuentes() {

	}

	public JLabel actualizarNumPalIng() {
		return null;
	}

	public JLabel actualizarNumFr() {
		return null;
	}

	public JLabel actualizarNumIta() {
		return null;
	}

}
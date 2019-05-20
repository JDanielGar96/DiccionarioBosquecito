package Controlador;

import Modelo.Diccionario;
import Vista.VentanaPrincipal;

public class Control {

	private VentanaPrincipal ventana;
	private Diccionario diccionario;

	public Control() {
		ventana = new VentanaPrincipal(this);
	}	
	
	public void agregarPalabra(String palabra, String traduccion, String idioma) { }
}

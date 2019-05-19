package Controlador;

import Modelo.Diccionario;
import Vista.VentanaPrincipal;

public class Control {

	private VentanaPrincipal ventana;
	private Diccionario diccionario;

	public Control() {
		ventana = new VentanaPrincipal(this);
	}	
	
	public void agregarPalabra(String comandoDeAccion, String p, String t, String i) {
		if (ventana.getOpcion().equals("AGREGAR PALABRA")) {
			diccionario.agregarPalabra(p, t, i);
		}
	}
}

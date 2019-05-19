package Controlador;

import Modelo.Diccionario;
import Vista.VentanaPrincipal;

public class Control {

	private VentanaPrincipal ventana;
	private Diccionario diccionario;

	public Control() {
		ventana = new VentanaPrincipal(this);
	}

	public void cargarDiccionario(String opcion) {
		if (ventana.getOpcion().equals("FRECUENTES")) {
//			diccionario.cargarDiccionario();
		}

	}
	
	public void traducirPalabra(String comandoDeAccion, String p, String t, String i) {
		if (ventana.getOpcion().equals("TRADUCIR PALABRA")) {
//			diccionario.traducirPalabra(p, t, i);
		}
	}

	public void agregarPalabra(String comandoDeAccion, String p, String iO, String t, String iD) {
		if (ventana.getOpcion().equals("AGREGAR PALABRA")) {
//			diccionario.agregarPalabra(p, iO, t, iD);
		}
	}

	public void frecuentes() {
		if (ventana.getOpcion().equals("FRECUENTES")) {

		}
	}

}

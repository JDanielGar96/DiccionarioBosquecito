package Controlador;

import Modelo.Diccionario;
import Vista.VentanaPrincipal;

public class Control {

	private VentanaPrincipal ventana;
	private Diccionario diccionario;

	public Control() {
		ventana = new VentanaPrincipal(this);
		diccionario = new Diccionario();
	}

	public void cargarDiccionario(String opcion) {
		if (ventana.getOpcion().equals("FRECUENTES")) {
//			diccionario.cargarDiccionario();
		}

	}

	public void traducirPalabra(String comandoDeAccion, String p, String iO, String iD) {
		if (ventana.getOpcion().equals("TRADUCIR PALABRA")) {
			diccionario.traducir(p, iO, iD);
		}
	}

	public void agregarPalabra(String comandoDeAccion, String p, String iO, String t, String iD) {
		System.out.println(iD);
		if (ventana.getOpcion().equals("AGREGAR PALABRA")) {
			diccionario.agregarTraduccion(p, iO, t, iD);
		}
	}

	public void frecuentes() {
		if (ventana.getOpcion().equals("FRECUENTES")) {

		}
	}

}

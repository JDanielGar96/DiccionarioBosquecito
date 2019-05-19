package Controlador;

import java.io.IOException;

import javax.swing.JOptionPane;

import Modelo.Archivo;
import Modelo.Diccionario;
import Vista.VentanaPrincipal;

public class Control {

	private VentanaPrincipal ventana;
	private Diccionario diccionario;
	private Archivo archivo;

	public Control() {
		ventana = new VentanaPrincipal(this);
		diccionario = new Diccionario();
		try {
			archivo = new Archivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarDiccionario(String opcion) {
		if (ventana.getOpcion().equals("FRECUENTES")) {
			archivo.cargarDiccionario();
//			diccionario.agregarDiccionario();
		}
	}

	public void traducirPalabra(String comandoDeAccion, String p, String iO, String iD) {
		if (ventana.getOpcion().equals("TRADUCIR PALABRA")) {
			diccionario.traducir(p, iO, iD);
			try {
				archivo.buscarPalabra(p, iD);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, this, "Ups, la palabra no fue encontrada", 0);
				e.printStackTrace();
			}
		}
	}

	public void agregarPalabra(String comandoDeAccion, String p, String iO, String t, String iD) {
		System.out.println(iD);
		if (ventana.getOpcion().equals("AGREGAR PALABRA")) {
			diccionario.agregarTraduccion(p, iO, t, iD);
			archivo.agregarPalabra(p, iO);
		}
	}

	public void frecuentes() {
		if (ventana.getOpcion().equals("FRECUENTES")) {

		}
	}

}

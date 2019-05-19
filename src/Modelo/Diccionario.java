package Modelo;

import java.util.ArrayList;

public class Diccionario {
	
	private ArrayList<Traduccion> traducciones;
	private ArrayList<Palabra> palabras;

	public Diccionario() {
		this.traducciones = new ArrayList<Traduccion>();
	}
	
	public void agregarTraduccion ( String palabraOrigen, 
									String idiomaOrigen, 
									String palabraTraduccion,
									String idiomaTraduccion ) {
		// Se agregan las dos palabras
		Palabra palabraUno = this.agregarPalabra(palabraOrigen, idiomaOrigen);
		Palabra palabraDos = this.agregarPalabra(palabraTraduccion, idiomaTraduccion);
		
		// Se relaciona en una traduccion
		Traduccion traduccionPalabras = new Traduccion();
		traduccionPalabras.agregarPalabra(palabraUno);
		traduccionPalabras.agregarPalabra(palabraDos);
		
		// Se agrega la traduccion
		this.traducciones.add(traduccionPalabras);
	}
	
	private Palabra agregarPalabra ( String palabra, String idioma ) {
		for( Palabra registroPalabra: this.palabras ) {
			if( 
				registroPalabra.getPalabra().equalsIgnoreCase(palabra) && 
				registroPalabra.getIdioma().equalsIgnoreCase(idioma)
			) { 
				registroPalabra.setPalabra(palabra);
				registroPalabra.setIdioma(idioma);
				return registroPalabra;
			}
		}
		return new Palabra(palabra, idioma);
	}
	
	public String traducir ( String palabra,
							 String idiomaOrigen, 
							 String idiomaTraduccion ) {
		for(Traduccion traduccion: this.traducciones) {
			ArrayList<Palabra> palabras = traduccion.getTraducciones();
			for(Palabra registroPalabra: palabras) {
				if (
					registroPalabra.getPalabra().equalsIgnoreCase(palabra) &&
					registroPalabra.getIdioma().equalsIgnoreCase(idiomaOrigen)
				) {
					return buscarTraduccion(palabras, idiomaTraduccion);
				}
			}
		}
		return null;
	}
	
	private String buscarTraduccion (ArrayList<Palabra> palabras, String idiomaTraduccion) {
		for(Palabra registroPalabra: palabras) {
			if(registroPalabra.getIdioma().equalsIgnoreCase(idiomaTraduccion)) {
				return registroPalabra.getPalabra();
			}
		}
		return null;
	}
}

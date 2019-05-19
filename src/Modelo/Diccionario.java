package Modelo;

public class Diccionario {
	
	private Palabra[] palabras;

	public Diccionario(int dimensionDiccionario) {
		this.palabras = new Palabra[dimensionDiccionario];
	}

	public void agregarPalabra(String palabra, String palabraTraducida, String idioma) {

		// TODO Verificar existencia de la palabra

		Palabra p = new Palabra(palabra);

		if (idioma.equalsIgnoreCase("Frances")) {
			p.setFra(palabraTraducida);
		} else if (idioma.equalsIgnoreCase("Italiano")) {
			p.setIta(palabraTraducida);
		} else {
			p.setIng(palabraTraducida);
		}
	}

	public Palabra buscarPalabraEsp(String palabra) {
		for (Palabra p : palabras) {
			if (p.getEsp().equalsIgnoreCase(palabra)) {
				return p;
			}
		}
		return null;
	}

	public Palabra buscarPalabraIng(String palabra) {
		for (Palabra p : palabras) {
			if (p.getIng().equalsIgnoreCase(palabra)) {
				return p;
			}
		}
		return null;
	}

	public Palabra buscarPalabraFra(String palabra) {
		for (Palabra p : palabras) {
			if (p.getFra().equalsIgnoreCase(palabra)) {
				return p;
			}
		}
		return null;
	}

	public Palabra buscarPalabraIta(String palabra) {
		for (Palabra p : palabras) {
			if (p.getIta().equalsIgnoreCase(palabra)) {
				return p;
			}
		}
		return null;
	}

	// public String[] obtenerPalabrasEsp() {
	// return new String[1];
	// }
	//
	// public String[] obtenerPalabrasIng() {
	// return new String[1];
	// }
	//
	// public String[] obtenerPalabrasFra() {
	// return new String[1];
	// }
	//
	// public String[] obtenerPalabrasIta() {
	// return new String[1];
	// }
}

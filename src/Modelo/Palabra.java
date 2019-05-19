package Modelo;

public class Palabra {
	private String palabra;
	private String idioma;
	
	public Palabra(String palabra, String idioma) {
		this.palabra = palabra;
		this.idioma = idioma;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	
}

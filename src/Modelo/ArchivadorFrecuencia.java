package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.io.RandomAccessFile;

public class ArchivadorFrecuencia {
	
	private File archivo;
	private ArrayList<String> registroPalabras;
	
	public ArchivadorFrecuencia() {
		this.registroPalabras = new ArrayList<String>();
		this.cargarRegistro();
	}
	
	public void agregarRegistro(String traduccion) {
		this.registroPalabras.add(traduccion);
	}
	
	public void escribirRegistros() {
		int clave = 0;
		archivo = new File("./datos/registroPalabras.dat");
		
		try {
			RandomAccessFile accesor = new RandomAccessFile(archivo, "rw");
			for(String traduccion: this.registroPalabras) {
				int longitudTraduccion = traduccion.length();
				if(longitudTraduccion < 25) {
					for(int caracter = 1; caracter < 25 - longitudTraduccion; caracter++) {
						traduccion += " ";
					}
				} else {
					traduccion.substring(0, 25);
				}
				accesor.writeInt(clave);
				accesor.writeChars(traduccion);
				clave++;
			}
			accesor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			System.out.println("Error en ejecucion.");
		}
	}
	
	private void cargarRegistro() {
		int clave = 0;
		archivo = new File("./datos/registroPalabras.dat");
		

		
		try {
			RandomAccessFile accesor = new RandomAccessFile(archivo, "rw");
			int cantidadRegistros = (int) (this.archivo.length() / 50);
			System.out.println(cantidadRegistros);
			for( int numeroPalabra = 0; numeroPalabra < cantidadRegistros ; numeroPalabra++) {
				String palabra = "";
				for( int posicionPalabra = 0; posicionPalabra < 25; posicionPalabra++ ) {
					char caracter = accesor.readChar();
					if(caracter != ' ') {	
						palabra += caracter;
					}
				}
				this.registroPalabras.add(palabra);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			System.out.println("Error en ejecucion.");
			System.out.println(e);
		}
	}
	
	public ArrayList<String> obtenerTraducciones() {
		return this.registroPalabras;
	}
}

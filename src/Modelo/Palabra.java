package Modelo;

public class Palabra {
	private String esp;
	private String ing;
	private String ita;
	private String fra;
	private String go;
	
	
	
	public Palabra(String esp) {
		this.esp = esp;
	}
	
	public String getEsp() {
		return esp;
	}
	public void setEsp(String esp) {
		this.esp = esp;
	}
	public String getIng() {
		return ing;
	}
	public void setIng(String ing) {
		this.ing = ing;
	}
	public String getIta() {
		return ita;
	}
	public void setIta(String ita) {
		this.ita = ita;
	}
	public String getFra() {
		return fra;
	}
	public void setFra(String fra) {
		this.fra = fra;
	}
}

package entities;

import Interfaces.Resultado;

public class Estudio {
	
	private String practicaCodigo;
	private Resultado resultado;
	
	public Estudio(String practicaCodigo) {
		setPracticaCodigo(practicaCodigo);
	}
	
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	public String getPracticaCodigo() {
		return practicaCodigo;
	}
	public void setPracticaCodigo(String practicaCodigo) {
		this.practicaCodigo = practicaCodigo;
	}
	
}
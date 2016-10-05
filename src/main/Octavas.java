package main;

public enum Octavas {
	
	PRIMERA("1"),
	SEGUNDA("2"),
	TERCERA("3"),
	CUARTA("4"),
	QUINTA("5"),
	SEXTA("6"),
	SEPTIMA("7"),
	OCTAVA("8"),
	NOVENA("9");
	
	private String representacion;

	Octavas(String representacion) {
		this.setRepresentacion(representacion);
	}
	
	public String getRepresentacion() {
		return representacion;
	}
	
	public void setRepresentacion(String representacion) {
		this.representacion = representacion;
	}
}

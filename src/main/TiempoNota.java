package main;

public enum TiempoNota {
	
	REDONDA("redonda"),
	BLANCA("blanca"),
	NEGRA("negra"),
	CORCHEA("corchea"),
	SEMICORCHEA("semicorchea"),
	FUSA("fusa"),
	SEMIFUSA("semifusa");
	
	private String nombre;
	
	TiempoNota(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getImagenNombre() {
		return this.nombre + ".png";
	}

}

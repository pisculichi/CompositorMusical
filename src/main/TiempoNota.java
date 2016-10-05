package main;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum TiempoNota {
	
	REDONDA("redonda","w"),
	BLANCA("blanca","h"),
	NEGRA("negra","q"),
	CORCHEA("corchea","i"),
	SEMICORCHEA("semicorchea","s"),
	FUSA("fusa","t"),
	SEMIFUSA("semifusa","x");
	
	private String nombre;
	private String tempo;

	private Image imagen;
	
	TiempoNota(String nombre, String tempo) {
		this.setTempo(tempo);
		this.nombre = nombre;
		try {
			this.setImagen(ImageIO.read(getClass().getResource("/resources/" + this.getImagenNombre())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image getImagen() {
		return this.imagen;
	}
	
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return this.nombre;
	}
	
	public String getImagenNombre() {
		return this.nombre + ".png";
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

}

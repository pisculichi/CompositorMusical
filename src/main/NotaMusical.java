package main;

import main.Notas;
import main.TiempoNota;
import main.Octavas;


public class NotaMusical {
	
	private Notas nota;
	private Octavas octava;
	private TiempoNota tiempoNota;

	public NotaMusical() {
	}
	
	public NotaMusical(TiempoNota tiempoNota) {
		this.setTiempoNota(tiempoNota);
	}
	
	public NotaMusical(Notas nota, Octavas octava, TiempoNota tiempoNota) {
		this(tiempoNota);
		this.setNota(nota);
		this.setOctava(octava);
	}

	public Notas getNota() {
		return nota;
	}

	public void setNota(Notas nota) {
		this.nota = nota;
	}

	public Octavas getOctava() {
		return octava;
	}

	public void setOctava(Octavas octava) {
		this.octava = octava;
	}

	public TiempoNota getTiempoNota() {
		return tiempoNota;
	}

	public void setTiempoNota(TiempoNota tiempoNota) {
		this.tiempoNota = tiempoNota;
	}
	
	public String toString() {
		return this.getNota().cifradoAmericano()+this.getOctava().getRepresentacion()+this.getTiempoNota().getTempo();
	}
}

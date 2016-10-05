package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;


public class Controller {

	private TiempoNota tiempoNota;
	private ArrayList<NotaPentagrama> notasPentagrama;

	public Controller() {
		this.setTiempoNota(TiempoNota.REDONDA);
		this.setNotasPentagrama(new ArrayList<NotaPentagrama>());
	}

	public void puntoSeleccionado(Point p, Pentagrama pentagrama, JTextField inputText) {
		try{
			NotaPentagrama notaPentagrama = new NotaPentagrama(p, tiempoNota);
			this.getNotasPentagrama().add(notaPentagrama);
			Collections.sort(this.getNotasPentagrama());
			pentagrama.redibujar(this.getNotasPentagrama());
			inputText.setText(this.cifradoJflugue());
		}catch (Exception e){
			// Nada que hacer
			System.out.println(e.getMessage());
		}	
	}
	
	public void duracionSeleccionada(TiempoNota t) {
		this.setTiempoNota(t);
	}

	public TiempoNota getTiempoNota() {
		return this.tiempoNota;
	}

	public void setTiempoNota(TiempoNota t) {
		this.tiempoNota = t;
	}

	public ArrayList<NotaPentagrama> getNotasPentagrama() {
		return notasPentagrama;
	}

	public void setNotasPentagrama(ArrayList<NotaPentagrama> notasPentagrama) {
		this.notasPentagrama = notasPentagrama;
	}
	
	private String cifradoJflugue(){
		String texto ="";
		for (NotaPentagrama n: this.getNotasPentagrama()) {
			texto+=" "+n;
		}
		return texto;
	}

	public void borrarNotasPentagrama() {
		this.setNotasPentagrama(new ArrayList<NotaPentagrama>());	
	}
}

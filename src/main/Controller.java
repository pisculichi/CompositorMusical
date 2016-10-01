package main;

import java.awt.Point;


public class Controller {

	private TiempoNota tiempoNota;
	private Point puntoSeleccionado;
	private String[] notas = {"A","G","F","E","D","C","B","A","G","F","E","D","C"};
	
	public Controller() {
		this.setTiempoNota(TiempoNota.REDONDA);
	}

	private String convertPointToNote() {
		int y = (int) puntoSeleccionado.getY();
		int tono=0;
		int count=0;
		while (tono<112){
			if ((tono<=y && y-tono<=7))
				break;
			if (tono!=0 && count%2==0)
				tono+=14;
			else
				tono+=7;
			count++;
		}
		return notas[count];
	}
	
	public void puntoSeleccionado(Point p, Pentagrama pentagrama) {
		this.setPuntoSeleccionado(p);
		pentagrama.paintNote(this.getTiempoNota(),this.getPuntoSeleccionado());
		System.out.println(convertPointToNote());
	}
	
	public void duracionSeleccionada(TiempoNota t) {
		this.setTiempoNota(t);
		//System.out.println(this.getTiempoNota().getNombre());
	}

	public TiempoNota getTiempoNota() {
		return this.tiempoNota;
	}

	public void setTiempoNota(TiempoNota t) {
		this.tiempoNota = t;
	}

	public Point getPuntoSeleccionado() {
		return puntoSeleccionado;
	}

	public void setPuntoSeleccionado(Point puntoSeleccionado) {
		this.puntoSeleccionado = puntoSeleccionado;
	}
}

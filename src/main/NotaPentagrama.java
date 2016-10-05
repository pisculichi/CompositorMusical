package main;

import java.awt.Point;

public class NotaPentagrama extends NotaMusical implements Comparable<NotaPentagrama>{
	
	private final Notas[] notas = { 
			Notas.LA,
			Notas.SOL,
			Notas.FA,
			Notas.MI,
			Notas.RE,
			Notas.DO,
			Notas.SI,
			Notas.LA,
			Notas.SOL,
			Notas.FA,
			Notas.MI,
			Notas.RE,
			Notas.DO
			};
	
	private Point coordenadaPentagrama;

	public NotaPentagrama(Point coordenadaPentagrama, TiempoNota tiempoNota) throws Exception {
		super(tiempoNota);
		this.setCoordenadaPentagrama(coordenadaPentagrama);
		int y = (int) this.getCoordenadaPentagrama().getY();
		int tono=0;
		int count=0;
		Octavas octava;
		while (tono<127){
			if (tono<=y && y-tono<=7)
				break;
			else if (tono >y && tono-y<=7){
				count--;
				break;
				}
			if (tono!=0 && count%2==0)
				tono+=14;
			else
				tono+=7;
			count++;
		}
		if (count==13)
			throw new Exception("Nota fuera del pentagrama");
		if (count <3 )
			octava = Octavas.SEXTA;
		else if (count < 11) {
			octava = Octavas.QUINTA;
		}else {
			octava = Octavas.CUARTA;
		}
		this.setNota(notas[count]);
		this.setOctava(octava);
	}

	public Point getCoordenadaPentagrama() {
		return coordenadaPentagrama;
	}

	public void setCoordenadaPentagrama(Point coordenadaPentagrama) {
		this.coordenadaPentagrama = coordenadaPentagrama;
	}

	@Override
	public int compareTo(NotaPentagrama o) {
		Double ox2,ox1;
		ox2 = o.getCoordenadaPentagrama().getX();
		ox1 = this.getCoordenadaPentagrama().getX();
		return ox1.compareTo(ox2);
	}
	
	public String toString() {
		return super.toString();
	}
}

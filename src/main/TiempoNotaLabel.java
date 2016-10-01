package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TiempoNotaLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8803064043940270402L;
	private TiempoNota tiempoNota;

	public TiempoNotaLabel(TiempoNota t) {
		super(t.getNombre());
		this.setTiempoNota(t);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/resources/"+t.getImagenNombre()));
		this.setIcon(image);
	}

	public TiempoNota getTiempoNota() {
		return tiempoNota;
	}

	public void setTiempoNota(TiempoNota tn) {
		this.tiempoNota = tn;
	}
}

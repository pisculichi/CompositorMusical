package main;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TiempoNotaButton extends JButton {

	private static final long serialVersionUID = -8803064043940270402L;
	private TiempoNota tiempoNota;

	public TiempoNotaButton(TiempoNota t) {
		super(t.getNombre());
		this.setTiempoNota(t);
		this.setIcon(new ImageIcon(t.getImagen()));
		this.noSelectedButton();
	}

	public TiempoNota getTiempoNota() {
		return tiempoNota;
	}

	public void setTiempoNota(TiempoNota tn) {
		this.tiempoNota = tn;
	}
	
	public void selectedButton() {
		this.setBackground(Color.WHITE);
	}
	
	public void noSelectedButton() {
		this.setBackground(Color.GRAY);
	}
}

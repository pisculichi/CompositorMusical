package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pentagrama extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 316233707961019770L;

	public Pentagrama() {
		super();
		this.setSize(900, 126);
		this.setBounds(0, 61, 900, 126);
		this.setBackground(Color.WHITE);
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);

	    int width = getWidth();
	    // int height = getHeight();
	    Image clavesol;
		try {
			clavesol = ImageIO.read(this.getClass().getResource("/resources/clavesol.png"));
			g.drawImage(clavesol, 0, 20, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawLine(0, 21, width, 21);
		g.drawLine(0, 42, width, 42);
		g.drawLine(0, 63, width, 63);
		g.drawLine(0, 84, width, 84);
		g.drawLine(0, 105, width, 105);
	}
	
	public void dibujarNotaPentagrama(NotaPentagrama notaPentagrama) {
		//Graphics g =this.getGraphics();
		super.getGraphics().drawImage(notaPentagrama.getTiempoNota().getImagen(), 
				(int) notaPentagrama.getCoordenadaPentagrama().getX(),
				(int) notaPentagrama.getCoordenadaPentagrama().getY()-25, 
				null);
	}
	
	public void clean() {
		this.repaint();
	}

	public void redibujar(ArrayList<NotaPentagrama> notasPentagrama) {
		for (NotaPentagrama notaPentagrama: notasPentagrama){
			this.dibujarNotaPentagrama(notaPentagrama);
		}
	}
}

package main;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class CompositorMusical {

	private Controller controller = new Controller();

	private void createAndShowGUI() {
		JFrame frame = new JFrame("Compositor Musical");
		frame.setSize(600, 300);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelSuperior = new JPanel();
		Pentagrama pentagrama = new Pentagrama();

		pentagrama.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.puntoSeleccionado(e.getPoint(), pentagrama);
			}
		});
		JPanel panelInferior = new JPanel();

		TiempoNotaLabel[] notasLabel = new TiempoNotaLabel[7];
		notasLabel[0] = new TiempoNotaLabel(TiempoNota.REDONDA);
		notasLabel[1] = new TiempoNotaLabel(TiempoNota.BLANCA);
		notasLabel[2] = new TiempoNotaLabel(TiempoNota.NEGRA);
		notasLabel[3] = new TiempoNotaLabel(TiempoNota.CORCHEA);
		notasLabel[4] = new TiempoNotaLabel(TiempoNota.SEMICORCHEA);
		notasLabel[5] = new TiempoNotaLabel(TiempoNota.FUSA);
		notasLabel[6] = new TiempoNotaLabel(TiempoNota.SEMIFUSA);

		for (TiempoNotaLabel tnl : notasLabel) {
			tnl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					controller.duracionSeleccionada(tnl.getTiempoNota());
				}
			});
			panelSuperior.add(tnl);
		}

		frame.setLayout(new BorderLayout());
		frame.add(panelSuperior, BorderLayout.NORTH);
		frame.add(pentagrama, BorderLayout.CENTER);
		frame.add(panelInferior, BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
	}

    public static void main(String[] args) {

    	CompositorMusical prueba = new CompositorMusical();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                prueba.createAndShowGUI();
            }
        });
    }

}

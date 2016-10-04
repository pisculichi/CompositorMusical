package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import org.jfugue.player.Player;

public class CompositorMusical {

	private Controller controller = new Controller();
	public TiempoNotaButton last=null;	

	private void createAndShowGUI() {
		JFrame frame = new JFrame("Compositor Musical");
		Pentagrama pentagrama = new Pentagrama();
		
		frame.setSize(900, 300);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelSuperior = new JPanel();
		panelSuperior.setSize(900, 60);
		
		JTextField inputText = new JTextField("",50);

		pentagrama.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.puntoSeleccionado(e.getPoint(), pentagrama, inputText);
			}
		});
		
		
		JPanel panelInferior = new JPanel();
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = new Player();
				player.play(inputText.getText());
			}
		});
		
		JButton cleanButton = new JButton("Clean");
		cleanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pentagrama.clean();
				inputText.setText("");
			}
		});
		panelInferior.setSize(900, 50);
		panelInferior.setBounds(0, 200, 900, 50);
		panelInferior.add(inputText);
		panelInferior.add(playButton);
		panelInferior.add(cleanButton);

		for (TiempoNota tn: TiempoNota.values()){
			TiempoNotaButton  tnb = new TiempoNotaButton(tn);
			last = tnb;
			tnb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					last.noSelectedButton();
					controller.setTiempoNota(tnb.getTiempoNota());
					tnb.selectedButton();
					last = tnb;
				}
			});
			panelSuperior.add(tnb);
		}
		last.selectedButton();
		controller.setTiempoNota(last.getTiempoNota());

		frame.add(panelSuperior);
		frame.add(pentagrama);
		frame.add(panelInferior);
		
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
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

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}

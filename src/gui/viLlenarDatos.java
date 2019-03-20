package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class viLlenarDatos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viLlenarDatos frame = new viLlenarDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viLlenarDatos() {
		setBounds(100, 100, 608, 449);

	}

}

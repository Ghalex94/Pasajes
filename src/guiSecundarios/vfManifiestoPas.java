package guiSecundarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class vfManifiestoPas extends JFrame {
	private JLabel lblNewLabel;
	private JTextField txtArequipa;
	private JLabel lblDestino;
	private JTextField txtPuno;
	private JLabel lblFechaViaje;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label_1;
	private JTextField textField_3;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel label_4;
	private JTextField textField_6;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel label_7;
	private JTextField textField_9;
	private JLabel label_8;
	private JLabel label_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JLabel label_10;
	private JTextField textField_12;
	private JLabel label_11;
	private JButton btnNewButton;
	private JButton btnManifiestoPasajeros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vfManifiestoPas frame = new vfManifiestoPas();
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
	public vfManifiestoPas() {
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 777);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Origen");
		lblNewLabel.setBounds(37, 94, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtArequipa = new JTextField();
		txtArequipa.setText("Arequipa");
		txtArequipa.setBounds(93, 91, 92, 17);
		getContentPane().add(txtArequipa);
		txtArequipa.setColumns(10);
		
		lblDestino = new JLabel("Destino");
		lblDestino.setBounds(207, 97, 46, 14);
		getContentPane().add(lblDestino);
		
		txtPuno = new JTextField();
		txtPuno.setText("Puno");
		txtPuno.setColumns(10);
		txtPuno.setBounds(263, 94, 92, 17);
		getContentPane().add(txtPuno);
		
		lblFechaViaje = new JLabel("Fecha Viaje");
		lblFechaViaje.setBounds(376, 94, 97, 14);
		getContentPane().add(lblFechaViaje);
		
		textField = new JTextField();
		textField.setText("Puno");
		textField.setColumns(10);
		textField.setBounds(442, 92, 92, 17);
		getContentPane().add(textField);
		
		label = new JLabel("Fecha Viaje");
		label.setBounds(376, 143, 97, 14);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("Puno");
		textField_1.setColumns(10);
		textField_1.setBounds(442, 141, 92, 17);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Puno");
		textField_2.setColumns(10);
		textField_2.setBounds(263, 143, 92, 17);
		getContentPane().add(textField_2);
		
		label_1 = new JLabel("Destino");
		label_1.setBounds(207, 146, 46, 14);
		getContentPane().add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setText("Arequipa");
		textField_3.setColumns(10);
		textField_3.setBounds(93, 140, 92, 17);
		getContentPane().add(textField_3);
		
		label_2 = new JLabel("Origen");
		label_2.setBounds(37, 143, 46, 14);
		getContentPane().add(label_2);
		
		label_3 = new JLabel("Fecha Viaje");
		label_3.setBounds(376, 199, 97, 14);
		getContentPane().add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Puno");
		textField_4.setColumns(10);
		textField_4.setBounds(442, 197, 92, 17);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("Puno");
		textField_5.setColumns(10);
		textField_5.setBounds(263, 199, 92, 17);
		getContentPane().add(textField_5);
		
		label_4 = new JLabel("Destino");
		label_4.setBounds(207, 202, 46, 14);
		getContentPane().add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setText("Arequipa");
		textField_6.setColumns(10);
		textField_6.setBounds(93, 196, 92, 17);
		getContentPane().add(textField_6);
		
		label_5 = new JLabel("Origen");
		label_5.setBounds(37, 199, 46, 14);
		getContentPane().add(label_5);
		
		label_6 = new JLabel("Fecha Viaje");
		label_6.setBounds(376, 260, 97, 14);
		getContentPane().add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setText("Puno");
		textField_7.setColumns(10);
		textField_7.setBounds(442, 258, 92, 17);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("Puno");
		textField_8.setColumns(10);
		textField_8.setBounds(263, 260, 92, 17);
		getContentPane().add(textField_8);
		
		label_7 = new JLabel("Destino");
		label_7.setBounds(207, 263, 46, 14);
		getContentPane().add(label_7);
		
		textField_9 = new JTextField();
		textField_9.setText("Arequipa");
		textField_9.setColumns(10);
		textField_9.setBounds(93, 257, 92, 17);
		getContentPane().add(textField_9);
		
		label_8 = new JLabel("Origen");
		label_8.setBounds(37, 260, 46, 14);
		getContentPane().add(label_8);
		
		label_9 = new JLabel("Fecha Viaje");
		label_9.setBounds(376, 323, 97, 14);
		getContentPane().add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setText("Puno");
		textField_10.setColumns(10);
		textField_10.setBounds(442, 321, 92, 17);
		getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("Puno");
		textField_11.setColumns(10);
		textField_11.setBounds(263, 323, 92, 17);
		getContentPane().add(textField_11);
		
		label_10 = new JLabel("Destino");
		label_10.setBounds(207, 326, 46, 14);
		getContentPane().add(label_10);
		
		textField_12 = new JTextField();
		textField_12.setText("Arequipa");
		textField_12.setColumns(10);
		textField_12.setBounds(93, 320, 92, 17);
		getContentPane().add(textField_12);
		
		label_11 = new JLabel("Origen");
		label_11.setBounds(37, 323, 46, 14);
		getContentPane().add(label_11);
		
		btnNewButton = new JButton("PIE PAGINA");
		btnNewButton.setBounds(51, 587, 582, 119);
		getContentPane().add(btnNewButton);
		
		btnManifiestoPasajeros = new JButton("MANIFIESTO PASAJEROS");
		btnManifiestoPasajeros.setBounds(37, 11, 596, 72);
		getContentPane().add(btnManifiestoPasajeros);
	}
}

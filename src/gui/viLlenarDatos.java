package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.JTextArea;

public class viLlenarDatos extends JInternalFrame {
	private JTextField txtCompletarDatos;
	private JLabel lblViajeStandar;
	private JTextField textField;
	private JCheckBox chbxViajeStandar;
	private JLabel lblEscalasComerciales;
	private JCheckBox checkBox;
	private JLabel lblContratante;
	private JLabel lblHataLaCiudad;
	private JTextField textField_1;
	private JLabel lblPuntoDeEncuento;
	private JTextField textField_2;
	private JLabel lblEscalasYParadas;
	private JTextArea textArea;
	private JLabel lblConductor;
	private JTextField textField_3;
	private JLabel lblHoraInicio;
	private JTextField textField_4;
	private JLabel lblHoraFin;
	private JTextField textField_5;
	private JLabel lblNLicenciaDe;
	private JTextField textField_6;
	private JLabel lblConductor_1;
	private JTextField textField_7;
	private JLabel label_1;
	private JTextField textField_8;
	private JLabel label_2;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel label_3;

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
		setBounds(100, 100, 1373, 676);
		getContentPane().setLayout(null);
		
		txtCompletarDatos = new JTextField();
		txtCompletarDatos.setText("COMPLETAR DATOS");
		txtCompletarDatos.setRequestFocusEnabled(false);
		txtCompletarDatos.setIgnoreRepaint(true);
		txtCompletarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		txtCompletarDatos.setForeground(Color.WHITE);
		txtCompletarDatos.setFont(new Font("USAngel", Font.BOLD, 32));
		txtCompletarDatos.setFocusable(false);
		txtCompletarDatos.setFocusTraversalKeysEnabled(false);
		txtCompletarDatos.setEditable(false);
		txtCompletarDatos.setColumns(10);
		txtCompletarDatos.setBackground(Color.DARK_GRAY);
		txtCompletarDatos.setBounds(0, 0, 1920, 75);
		getContentPane().add(txtCompletarDatos);
		
		lblViajeStandar = new JLabel("Viaje Standar");
		lblViajeStandar.setHorizontalAlignment(SwingConstants.LEFT);
		lblViajeStandar.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblViajeStandar.setBounds(50, 97, 189, 20);
		getContentPane().add(lblViajeStandar);
		
		textField = new JTextField();
		textField.setText((String) null);
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(50, 201, 355, 23);
		getContentPane().add(textField);
		
		chbxViajeStandar = new JCheckBox("");
		chbxViajeStandar.setBounds(307, 91, 40, 26);
		getContentPane().add(chbxViajeStandar);
		
		lblEscalasComerciales = new JLabel("Escalas comerciales");
		lblEscalasComerciales.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscalasComerciales.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblEscalasComerciales.setBounds(50, 133, 251, 20);
		getContentPane().add(lblEscalasComerciales);
		
		checkBox = new JCheckBox("");
		checkBox.setVerticalAlignment(SwingConstants.BOTTOM);
		checkBox.setBounds(307, 127, 40, 26);
		getContentPane().add(checkBox);
		
		lblContratante = new JLabel("Transportar desde la ciudad de: ");
		lblContratante.setHorizontalAlignment(SwingConstants.LEFT);
		lblContratante.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblContratante.setBounds(50, 175, 427, 20);
		getContentPane().add(lblContratante);
		
		lblHataLaCiudad = new JLabel("Hasta la ciudad de: ");
		lblHataLaCiudad.setHorizontalAlignment(SwingConstants.LEFT);
		lblHataLaCiudad.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblHataLaCiudad.setBounds(50, 252, 427, 20);
		getContentPane().add(lblHataLaCiudad);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(50, 275, 355, 23);
		getContentPane().add(textField_1);
		
		lblPuntoDeEncuento = new JLabel("Punto de encuento en:");
		lblPuntoDeEncuento.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntoDeEncuento.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblPuntoDeEncuento.setBounds(50, 329, 427, 20);
		getContentPane().add(lblPuntoDeEncuento);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(50, 352, 355, 23);
		getContentPane().add(textField_2);
		
		lblEscalasYParadas = new JLabel("Escalas y paradas en el recorrido:");
		lblEscalasYParadas.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscalasYParadas.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblEscalasYParadas.setBounds(50, 402, 427, 20);
		getContentPane().add(lblEscalasYParadas);
		
		textArea = new JTextArea();
		textArea.setBounds(50, 433, 355, 97);
		getContentPane().add(textArea);
		
		lblConductor = new JLabel("Conductor 1:");
		lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblConductor.setBounds(561, 104, 427, 20);
		getContentPane().add(lblConductor);
		
		textField_3 = new JTextField();
		textField_3.setText((String) null);
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(561, 132, 454, 23);
		getContentPane().add(textField_3);
		
		lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoraInicio.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblHoraInicio.setBounds(561, 227, 169, 20);
		getContentPane().add(lblHoraInicio);
		
		textField_4 = new JTextField();
		textField_4.setText((String) null);
		textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(561, 255, 135, 23);
		getContentPane().add(textField_4);
		
		lblHoraFin = new JLabel("Hora Fin:");
		lblHoraFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoraFin.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblHoraFin.setBounds(880, 227, 169, 20);
		getContentPane().add(lblHoraFin);
		
		textField_5 = new JTextField();
		textField_5.setText((String) null);
		textField_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(880, 255, 135, 23);
		getContentPane().add(textField_5);
		
		lblNLicenciaDe = new JLabel("N Licencia de Conducir:");
		lblNLicenciaDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblNLicenciaDe.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblNLicenciaDe.setBounds(561, 165, 427, 20);
		getContentPane().add(lblNLicenciaDe);
		
		textField_6 = new JTextField();
		textField_6.setText((String) null);
		textField_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(561, 193, 454, 23);
		getContentPane().add(textField_6);
		
		lblConductor_1 = new JLabel("Conductor 2:");
		lblConductor_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor_1.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblConductor_1.setBounds(561, 356, 427, 20);
		getContentPane().add(lblConductor_1);
		
		textField_7 = new JTextField();
		textField_7.setText((String) null);
		textField_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(561, 384, 454, 23);
		getContentPane().add(textField_7);
		
		label_1 = new JLabel("N Licencia de Conducir:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_1.setBounds(561, 417, 427, 20);
		getContentPane().add(label_1);
		
		textField_8 = new JTextField();
		textField_8.setText((String) null);
		textField_8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(561, 445, 454, 23);
		getContentPane().add(textField_8);
		
		label_2 = new JLabel("Hora Inicio:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_2.setBounds(561, 479, 169, 20);
		getContentPane().add(label_2);
		
		textField_9 = new JTextField();
		textField_9.setText((String) null);
		textField_9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(561, 507, 135, 23);
		getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText((String) null);
		textField_10.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(880, 507, 135, 23);
		getContentPane().add(textField_10);
		
		label_3 = new JLabel("Hora Fin:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_3.setBounds(880, 479, 169, 20);
		getContentPane().add(label_3);

	}
}

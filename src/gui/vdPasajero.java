package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class vdPasajero extends JDialog implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnCancelar;
	private JButton btnGuardar;
	
	vPrincipal vp;
	viSeleccionAsientos1 vsa1;
	int asiento = 0;
	private JLabel lblAsiento;
	private JLabel lblNAsiento;
	
	public static void main(String[] args) {
		try {
			vdPasajero dialog = new vdPasajero(null, null, 0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public vdPasajero(vPrincipal temp, viSeleccionAsientos1 temp2, int temp3) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		vsa1 = temp2;
		vp = temp;
		asiento = temp3;
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBounds(100, 100, 559, 304);
		getContentPane().setLayout(null);
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setText("DATOS DE PASAJERO");
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setForeground(Color.WHITE);
			textField.setFont(new Font("USAngel", Font.PLAIN, 20));
			textField.setColumns(10);
			textField.setBackground(new Color(30, 144, 255));
			textField.setBounds(0, 0, 559, 46);
			getContentPane().add(textField);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			label.setBounds(31, 114, 132, 20);
			getContentPane().add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			textField_1.setColumns(10);
			textField_1.setBounds(144, 113, 380, 23);
			getContentPane().add(textField_1);
		}
		{
			JLabel label = new JLabel("DNI:");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			label.setBounds(31, 155, 132, 20);
			getContentPane().add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			textField_2.setColumns(10);
			textField_2.setBounds(382, 194, 142, 23);
			getContentPane().add(textField_2);
		}
		{
			btnGuardar = new JButton("<html>Guardar e<br>\u00A0\u00A0imprimir</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("USAngel", Font.PLAIN, 20));
			btnGuardar.setBackground(Color.DARK_GRAY);
			btnGuardar.setBounds(304, 240, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			JLabel label = new JLabel("Edad:");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			label.setBounds(31, 194, 78, 20);
			getContentPane().add(label);
		}
		{
			textField_3 = new JTextField();
			textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			textField_3.setColumns(10);
			textField_3.setBounds(144, 154, 380, 23);
			getContentPane().add(textField_3);
		}
		{
			JLabel label = new JLabel("Precio:");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			label.setBounds(261, 194, 102, 20);
			getContentPane().add(label);
		}
		{
			textField_4 = new JTextField();
			textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			textField_4.setColumns(10);
			textField_4.setBounds(144, 194, 107, 23);
			getContentPane().add(textField_4);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("USAngel", Font.PLAIN, 20));
			btnCancelar.setBackground(Color.DARK_GRAY);
			btnCancelar.setBounds(31, 237, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			lblAsiento = new JLabel("ASIENTO:");
			lblAsiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblAsiento.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblAsiento.setBounds(31, 81, 132, 20);
			getContentPane().add(lblAsiento);
		}
		{
			lblNAsiento = new JLabel("");
			lblNAsiento.setBackground(Color.LIGHT_GRAY);
			lblNAsiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblNAsiento.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			lblNAsiento.setBounds(144, 81, 380, 20);
			getContentPane().add(lblNAsiento);
		}
		cargar();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}
	
	public void cargar(){
		this.setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		lblNAsiento.setText(""+asiento);
		
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		vp.enable(true);
		this.dispose();
		
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		vsa1.cambiarColorAsiento(asiento);		
		vp.enable(true);
		this.dispose();
	}
}

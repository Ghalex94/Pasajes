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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class vdConductor extends JDialog implements ActionListener {
	private JTextField txtDatosDeConductor;
	private JTextField txtPlaca;
	private JTextField txtPasaje;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JComboBox cbConductor;
	private JButton btnNewConductor;
	
	vPrincipal vp;
	viSeleccionAsientos1 vsa1;
	
	public static void main(String[] args) {
		try {
			vdConductor dialog = new vdConductor(null, null, null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public vdConductor(vPrincipal temp, viSeleccionAsientos1 temp2, viSeleccionAsientos2 temp3, viSeleccionAsientos3 temp4, viSeleccionAsientos4 temp5) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		vsa1 = temp2;
		vp = temp;
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBounds(100, 100, 559, 304);
		getContentPane().setLayout(null);
		{
			txtDatosDeConductor = new JTextField();
			txtDatosDeConductor.setEditable(false);
			txtDatosDeConductor.setText("DATOS DE CONDUCTOR");
			txtDatosDeConductor.setHorizontalAlignment(SwingConstants.CENTER);
			txtDatosDeConductor.setForeground(Color.WHITE);
			txtDatosDeConductor.setFont(new Font("USAngel", Font.PLAIN, 20));
			txtDatosDeConductor.setColumns(10);
			txtDatosDeConductor.setBackground(new Color(30, 144, 255));
			txtDatosDeConductor.setBounds(0, 0, 559, 46);
			getContentPane().add(txtDatosDeConductor);
		}
		{
			JLabel lblConductor = new JLabel("Conductor:");
			lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblConductor.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblConductor.setBounds(31, 114, 132, 20);
			getContentPane().add(lblConductor);
		}
		{
			JLabel lblPlaca = new JLabel("Placa:");
			lblPlaca.setHorizontalAlignment(SwingConstants.LEFT);
			lblPlaca.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblPlaca.setBounds(31, 155, 132, 20);
			getContentPane().add(lblPlaca);
		}
		{
			btnGuardar = new JButton("<html>Guardar<br></html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("USAngel", Font.PLAIN, 20));
			btnGuardar.setBackground(Color.DARK_GRAY);
			btnGuardar.setBounds(304, 240, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			JLabel lblPrecioDePasaje = new JLabel("Precio de pasaje:");
			lblPrecioDePasaje.setHorizontalAlignment(SwingConstants.LEFT);
			lblPrecioDePasaje.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblPrecioDePasaje.setBounds(31, 194, 216, 20);
			getContentPane().add(lblPrecioDePasaje);
		}
		{
			txtPlaca = new JTextField();
			txtPlaca.setText("AC8-D61");
			txtPlaca.setEditable(false);
			txtPlaca.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(173, 154, 351, 23);
			getContentPane().add(txtPlaca);
		}
		{
			txtPasaje = new JTextField();
			txtPasaje.setText("25.00");
			txtPasaje.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			txtPasaje.setColumns(10);
			txtPasaje.setBounds(257, 194, 267, 23);
			getContentPane().add(txtPasaje);
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
		
		cbConductor = new JComboBox();
		cbConductor.setModel(new DefaultComboBoxModel(new String[] {"Juan Manuel", "Andres Carpio", "Victor Carbajal", "Luis Ventura"}));
		cbConductor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbConductor.setBounds(173, 103, 289, 31);
		getContentPane().add(cbConductor);
		{
			btnNewConductor = new JButton("+");
			btnNewConductor.addActionListener(this);
			btnNewConductor.setForeground(Color.WHITE);
			btnNewConductor.setBackground(new Color(50, 205, 50));
			btnNewConductor.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnNewConductor.setBounds(472, 103, 52, 31);
			getContentPane().add(btnNewConductor);
		}
		cargar();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewConductor) {
			actionPerformedBtnNewConductor(arg0);
		}
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
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		vp.enable(true);
		this.dispose();
		
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {	
		vp.enable(true);
		this.dispose();
	}
	protected void actionPerformedBtnNewConductor(ActionEvent arg0) {
		
	}
}

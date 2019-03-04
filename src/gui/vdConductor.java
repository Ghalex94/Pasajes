package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Conductor;
import guiSecundarios.vdConductorNuevo;
import mysql.Consultas;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class vdConductor extends JDialog implements ActionListener {
	private JTextField txtDatosDeConductor;
	private JTextField txtPlaca;
	private JTextField txtPasaje;
	private JButton btnCancelar;
	private JButton btnGuardar;
	public JComboBox <Conductor> cbConductor ;
	private JButton btnNewConductor;
	
	vPrincipal vp;
	viSeleccionAsientos1 vsa1;
	private JLabel lblEmpresa;
	private JTextField txtEmpresa;
	
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
		setBounds(100, 100, 658, 378);
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
			txtDatosDeConductor.setBounds(0, 0, 658, 68);
			getContentPane().add(txtDatosDeConductor);
		}
		{
			JLabel lblConductor = new JLabel("Conductor:");
			lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblConductor.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblConductor.setBounds(83, 147, 132, 20);
			getContentPane().add(lblConductor);
		}
		{
			JLabel lblPlaca = new JLabel("Placa:");
			lblPlaca.setHorizontalAlignment(SwingConstants.LEFT);
			lblPlaca.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblPlaca.setBounds(83, 188, 132, 20);
			getContentPane().add(lblPlaca);
		}
		{
			btnGuardar = new JButton("<html>Guardar<br></html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("USAngel", Font.PLAIN, 20));
			btnGuardar.setBackground(Color.DARK_GRAY);
			btnGuardar.setBounds(387, 303, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			JLabel lblPrecioDePasaje = new JLabel("Precio de pasaje:");
			lblPrecioDePasaje.setVerticalAlignment(SwingConstants.TOP);
			lblPrecioDePasaje.setHorizontalAlignment(SwingConstants.LEFT);
			lblPrecioDePasaje.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblPrecioDePasaje.setBounds(83, 227, 216, 32);
			getContentPane().add(lblPrecioDePasaje);
		}
		{
			txtPlaca = new JTextField();
			txtPlaca.setEditable(false);
			txtPlaca.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(225, 187, 351, 23);
			getContentPane().add(txtPlaca);
		}
		{
			txtPasaje = new JTextField();
			txtPasaje.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			txtPasaje.setColumns(10);
			txtPasaje.setBounds(309, 227, 267, 23);
			getContentPane().add(txtPasaje);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("USAngel", Font.PLAIN, 20));
			btnCancelar.setBackground(Color.DARK_GRAY);
			btnCancelar.setBounds(43, 303, 220, 53);
			getContentPane().add(btnCancelar);
		}
		
		cbConductor = new JComboBox();
		cbConductor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbConductor.setBounds(225, 136, 289, 31);
		getContentPane().add(cbConductor);
		{
			btnNewConductor = new JButton("+");
			btnNewConductor.addActionListener(this);
			btnNewConductor.setForeground(Color.WHITE);
			btnNewConductor.setBackground(new Color(50, 205, 50));
			btnNewConductor.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnNewConductor.setBounds(524, 136, 52, 31);
			getContentPane().add(btnNewConductor);
		}
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpresa.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblEmpresa.setBounds(83, 99, 132, 24);
		getContentPane().add(lblEmpresa);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setText((String) null);
		txtEmpresa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtEmpresa.setEditable(false);
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(225, 100, 351, 23);
		getContentPane().add(txtEmpresa);
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
				
		Conductor conductor = new Conductor();
		conductor.cargarConductores(cbConductor);
		
		Consultas consulta = new Consultas();
		ResultSet rs = consulta.cargarVentaTemporal();
		
		try {
			rs.next();
			txtPlaca.setText(rs.getString("placa"));
			txtPasaje.setText(""+rs.getFloat("prepasaje"));
			if(rs.getInt("empresa") == 1)
				txtEmpresa.setText("MERMA HERMANOS S.R.L");
			if(rs.getInt("empresa") == 2)
				txtEmpresa.setText("ZIGUEL E.I.R.L");
			for(int i = 0; i < cbConductor.getItemCount(); i++){
				if(rs.getInt("dniconductor") == cbConductor.getItemAt(i).getDni()){
					cbConductor.setSelectedIndex(i);
					i = cbConductor.getItemCount();
				}
			}
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		vp.enable(true);
		this.dispose();
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		int dniconductor = cbConductor.getItemAt(cbConductor.getSelectedIndex()).getDni();
		float prepasaje = Float.parseFloat(txtPasaje.getText());
		Consultas consulta = new Consultas();
		consulta.actualizarVentaTemporal02(dniconductor, prepasaje);
		vp.enable(true);
		this.dispose();
	}
	protected void actionPerformedBtnNewConductor(ActionEvent arg0) {
		vdConductorNuevo vncon = new vdConductorNuevo(null, null, this);
		this.setAlwaysOnTop(false);
		vncon.setVisible(true);
		this.setVisible(false);
	}
}

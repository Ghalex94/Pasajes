package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Conductor;
import clases.Socio;
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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class vdConductor extends JDialog implements ActionListener, KeyListener, WindowListener {
	private JTextField txtDatosDeConductor;
	private JTextField txtPlaca;
	private JTextField txtPasaje;
	private JButton btnCancelar;
	private JButton btnGuardar;
	public JComboBox <Conductor> cbConductor ;
	private JButton btnNewConductor;
	private JLabel lblEmpresa;
	private JTextField txtEmpresa;
	private JLabel label;
	private JLabel lblSocio;
	private JComboBox <Socio> cbSocio;
	
	vPrincipal vp;
	viSeleccionAsientos3 vsa1;
	
	public static void main(String[] args) {
		try {
			vdConductor dialog = new vdConductor(null, null, null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public vdConductor(vPrincipal temp, viSeleccionAsientos3 temp2, viSeleccionAsientos4 temp3, viSeleccionAsientos2 temp4, viSeleccionAsientos1 temp5) {
		addWindowListener(this);
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		vsa1 = temp2;
		vp = temp;
		
		setLocationRelativeTo(null);
		setBounds(100, 100, 658, 399);
		getContentPane().setLayout(null);
		{
			txtDatosDeConductor = new JTextField();
			txtDatosDeConductor.setEditable(false);
			txtDatosDeConductor.setText("DATOS DE CONDUCTOR");
			txtDatosDeConductor.setHorizontalAlignment(SwingConstants.CENTER);
			txtDatosDeConductor.setForeground(Color.WHITE);
			txtDatosDeConductor.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			txtDatosDeConductor.setColumns(10);
			txtDatosDeConductor.setBackground(new Color(0, 139, 139));
			txtDatosDeConductor.setBounds(0, 0, 658, 68);
			getContentPane().add(txtDatosDeConductor);
		}
		{
			JLabel lblConductor = new JLabel("Conductor:");
			lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblConductor.setBounds(43, 165, 132, 20);
			getContentPane().add(lblConductor);
		}
		{
			JLabel lblPlaca = new JLabel("Placa:");
			lblPlaca.setHorizontalAlignment(SwingConstants.LEFT);
			lblPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblPlaca.setBounds(43, 205, 132, 20);
			getContentPane().add(lblPlaca);
		}
		{
			btnGuardar = new JButton("<html>Guardar<br></html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnGuardar.setBackground(new Color(0, 139, 139));
			btnGuardar.setBounds(387, 292, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			JLabel lblPrecioDePasaje = new JLabel("Precio de pasaje:");
			lblPrecioDePasaje.setVerticalAlignment(SwingConstants.TOP);
			lblPrecioDePasaje.setHorizontalAlignment(SwingConstants.LEFT);
			lblPrecioDePasaje.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblPrecioDePasaje.setBounds(43, 249, 216, 32);
			getContentPane().add(lblPrecioDePasaje);
		}
		{
			txtPlaca = new JTextField();
			txtPlaca.setEditable(false);
			txtPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(185, 204, 422, 23);
			getContentPane().add(txtPlaca);
		}
		{
			txtPasaje = new JTextField();
			txtPasaje.setHorizontalAlignment(SwingConstants.RIGHT);
			txtPasaje.addKeyListener(this);
			txtPasaje.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtPasaje.setColumns(10);
			txtPasaje.setBounds(269, 249, 79, 23);
			getContentPane().add(txtPasaje);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnCancelar.setBackground(new Color(0, 139, 139));
			btnCancelar.setBounds(43, 292, 220, 53);
			getContentPane().add(btnCancelar);
		}
		
		cbConductor = new JComboBox();
		cbConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbConductor.setBounds(185, 158, 351, 31);
		getContentPane().add(cbConductor);
		{
			btnNewConductor = new JButton("+");
			btnNewConductor.addActionListener(this);
			btnNewConductor.setForeground(Color.WHITE);
			btnNewConductor.setBackground(new Color(50, 205, 50));
			btnNewConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			btnNewConductor.setBounds(555, 158, 52, 31);
			getContentPane().add(btnNewConductor);
		}
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpresa.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblEmpresa.setBounds(43, 124, 132, 24);
		getContentPane().add(lblEmpresa);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setText((String) null);
		txtEmpresa.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtEmpresa.setEditable(false);
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(185, 124, 422, 23);
		getContentPane().add(txtEmpresa);
		
		label = new JLabel(".00");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label.setBackground(Color.WHITE);
		label.setBounds(347, 249, 52, 23);
		getContentPane().add(label);
		{
			lblSocio = new JLabel("Socio:");
			lblSocio.setHorizontalAlignment(SwingConstants.LEFT);
			lblSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblSocio.setBounds(43, 89, 132, 24);
			getContentPane().add(lblSocio);
		}
		
		cbSocio = new JComboBox();
		cbSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbSocio.setBounds(185, 88, 422, 25);
		getContentPane().add(cbSocio);
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
		
		Socio socio = new Socio();
		socio.cargarSocio(cbSocio);
				
		Conductor conductor = new Conductor();
		conductor.cargarConductores(cbConductor);
		
		Consultas consulta = new Consultas();
		consulta.iniciar();
		ResultSet rs = consulta.cargarVentaTemporal();
		
		try {
			rs.next();
			txtPlaca.setText(rs.getString("placa"));
			txtPasaje.setText("0");
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
			
			for(int i = 0; i < cbSocio.getItemCount(); i++){
				if(rs.getInt("codsocio") == cbSocio.getItemAt(i).getCodsocio()){
					cbSocio.setSelectedIndex(i);
					i = cbSocio.getItemCount();
				}
			}
			
			//txtPasaje.setText("" + (rs.getFloat("prepasaje")));
			int prepas = Integer.parseInt(rs.getString("prepasaje"));
			txtPasaje.setText(""+prepas);			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		try {
			rs.close();
			consulta.reset();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		vp.enable(true);
		this.dispose();
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		int codSocio = Integer.parseInt(cbSocio.getSelectedItem().toString());
		int dniconductor = cbConductor.getItemAt(cbConductor.getSelectedIndex()).getDni();
		float prepasaje = Float.parseFloat(txtPasaje.getText());
		Consultas consulta = new Consultas();
		consulta.iniciar();
		consulta.actualizarVentaTemporal02(dniconductor, prepasaje, codSocio);
		consulta.reset();
		vp.enable(true);
		this.dispose();
	}
	protected void actionPerformedBtnNewConductor(ActionEvent arg0) {
		vdConductorNuevo vncon = new vdConductorNuevo(null, null, this);
		this.setAlwaysOnTop(false);
		vncon.setVisible(true);
		this.setVisible(false);
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtPasaje) {
			keyTypedTxtPasaje(arg0);
		}
	}
	protected void keyTypedTxtPasaje(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE)){
			arg0.consume();
		}
		if (txtPasaje.getText().length() == 4){
			arg0.consume();
		}
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowClosingThis(arg0);
		}
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) {
	}
	protected void windowClosingThis(WindowEvent arg0) {
		vp.setEnabled(true);
	}
}

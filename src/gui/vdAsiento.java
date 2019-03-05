package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mysql.Consultas;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class vdAsiento extends JDialog implements ActionListener, KeyListener {
	private JTextField textField;
	private JTextField txtDni;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel lblAsiento;
	private JLabel lblNAsiento;
	private JLabel lblFNacimiento;
	private JComboBox cbDia;
	private JComboBox cbMes;
	private JComboBox cbAnio;
	private JTextField txtRuc;
	private JLabel lblRuc;
	private JLabel lblRazSocial;
	private JTextField txtRazsocial;
	private JLabel lblOpcional;
	
	vPrincipal vp;
	int asiento = 0;
	viSeleccionAsientos1 vsa1;
	viSeleccionAsientos2 vsa2;
	viSeleccionAsientos3 vsa3;
	viSeleccionAsientos4 vsa4;
	float prepasajeoriginal = 0;
	
	
	public static void main(String[] args) {
		try {
			vdAsiento dialog = new vdAsiento(null, 0, null, null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public vdAsiento(vPrincipal temp, int temp2, viSeleccionAsientos1 temp3, viSeleccionAsientos2 temp4, viSeleccionAsientos3 temp5, viSeleccionAsientos4 temp6) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		vp = temp;
		asiento = temp2;
		vsa1 = temp3;
		vsa2 = temp4;
		vsa3 = temp5;
		vsa4 = temp6;
		
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBounds(100, 100, 649, 409);
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
			textField.setBounds(0, 0, 649, 46);
			getContentPane().add(textField);
		}
		{
			JLabel lblDni = new JLabel("DNI:");
			lblDni.setHorizontalAlignment(SwingConstants.LEFT);
			lblDni.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblDni.setBounds(39, 114, 132, 20);
			getContentPane().add(lblDni);
		}
		{
			txtDni = new JTextField();
			txtDni.addKeyListener(this);
			txtDni.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			txtDni.setColumns(10);
			txtDni.setBounds(185, 113, 403, 23);
			getContentPane().add(txtDni);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombre.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblNombre.setBounds(39, 188, 132, 20);
			getContentPane().add(lblNombre);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(446, 296, 142, 23);
			getContentPane().add(txtPrecio);
		}
		{
			btnGuardar = new JButton("<html>Guardar e<br>\u00A0\u00A0imprimir</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("USAngel", Font.PLAIN, 20));
			btnGuardar.setBackground(Color.DARK_GRAY);
			btnGuardar.setBounds(317, 342, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			JLabel label = new JLabel("Edad:");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			label.setBounds(39, 296, 78, 20);
			getContentPane().add(label);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			txtNombre.setColumns(10);
			txtNombre.setBounds(185, 187, 403, 23);
			getContentPane().add(txtNombre);
		}
		{
			JLabel label = new JLabel("Precio:");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			label.setBounds(325, 296, 102, 20);
			getContentPane().add(label);
		}
		{
			txtEdad = new JTextField();
			txtEdad.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
			txtEdad.setColumns(10);
			txtEdad.setBounds(127, 296, 107, 23);
			getContentPane().add(txtEdad);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("USAngel", Font.PLAIN, 20));
			btnCancelar.setBackground(Color.DARK_GRAY);
			btnCancelar.setBounds(64, 342, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			lblAsiento = new JLabel("ASIENTO:");
			lblAsiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblAsiento.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblAsiento.setBounds(39, 81, 132, 20);
			getContentPane().add(lblAsiento);
		}
		{
			lblNAsiento = new JLabel("");
			lblNAsiento.setForeground(new Color(220, 20, 60));
			lblNAsiento.setBackground(Color.WHITE);
			lblNAsiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblNAsiento.setFont(new Font("Segoe UI", Font.BOLD, 25));
			lblNAsiento.setBounds(185, 81, 347, 20);
			getContentPane().add(lblNAsiento);
		}
		{
			lblFNacimiento = new JLabel("F. Nacimiento (d/m/a):");
			lblFNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblFNacimiento.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			lblFNacimiento.setBounds(41, 257, 251, 20);
			getContentPane().add(lblFNacimiento);
		}
		
		cbDia = new JComboBox();
		cbDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDia.setFont(new Font("Segoe UI", Font.BOLD, 18));
		cbDia.setBounds(326, 253, 65, 27);
		getContentPane().add(cbDia);
		
		cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}));
		cbMes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		cbMes.setBounds(401, 253, 112, 27);
		getContentPane().add(cbMes);
		
		cbAnio = new JComboBox();
		cbAnio.setFont(new Font("Segoe UI", Font.BOLD, 18));
		cbAnio.setBounds(523, 253, 65, 27);
		getContentPane().add(cbAnio);
		
		txtRuc = new JTextField();
		txtRuc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtRuc.setColumns(10);
		txtRuc.setBounds(185, 153, 403, 23);
		getContentPane().add(txtRuc);
		
		lblRuc = new JLabel("*RUC:");
		lblRuc.setHorizontalAlignment(SwingConstants.LEFT);
		lblRuc.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblRuc.setBounds(39, 154, 132, 20);
		getContentPane().add(lblRuc);
		
		lblRazSocial = new JLabel("*Raz. Social:");
		lblRazSocial.setHorizontalAlignment(SwingConstants.LEFT);
		lblRazSocial.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblRazSocial.setBounds(39, 220, 154, 20);
		getContentPane().add(lblRazSocial);
		
		txtRazsocial = new JTextField();
		txtRazsocial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtRazsocial.setColumns(10);
		txtRazsocial.setBounds(185, 219, 403, 23);
		getContentPane().add(txtRazsocial);
		{
			lblOpcional = new JLabel("Los datos con * son opcionales");
			lblOpcional.setForeground(new Color(178, 34, 34));
			lblOpcional.setHorizontalAlignment(SwingConstants.LEFT);
			lblOpcional.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblOpcional.setBounds(10, 44, 251, 20);
			getContentPane().add(lblOpcional);
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtDni, txtRuc, txtNombre, txtRazsocial, cbDia, cbMes, cbAnio, txtEdad, txtPrecio, btnGuardar, btnCancelar}));
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
		lblNAsiento.setText("11");
		
		Consultas consulta = new Consultas();
		ResultSet rs = consulta.cargarVentaTemporal();
		try {
			rs.next();
			txtPrecio.setText(rs.getString("prepasaje"));
			prepasajeoriginal = Float.parseFloat(rs.getString("prepasaje"));
		} catch (SQLException e) {	e.printStackTrace(); }
		
		//LLENAR COMBOS DE FECHA
		/*for(int i = 1; i<=31; i++) //DIA
			cbDia.addItem(i);*/
		Calendar cal= Calendar.getInstance();
		int anio= cal.get(Calendar.YEAR);
		for(int i = anio; i>=1900; i--) //AÑO
			cbAnio.addItem(i);
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		vp.enable(true);
		this.dispose();
		
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		if(txtDni.getText().length() == 0 || txtNombre.getText().length() == 0 || txtEdad.getText().length() == 0 || txtPrecio.getText().length() == 0)
			JOptionPane.showMessageDialog(null, "Ingrese los datos necesarios correctamente");
		else{
			int dni = Integer.parseInt(txtDni.getText());
			int ruc = 0;
			if(txtRuc.getText().length()>0)
				ruc = Integer.parseInt(txtRuc.getText());
			String nombre = txtNombre.getText();
			String razsocial = null;
			if(txtRazsocial.getText().length()>0)
				razsocial = txtRazsocial.getText();
			int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
			int mes = cbMes.getSelectedIndex() + 1;
			int anio = Integer.parseInt(cbAnio.getSelectedItem().toString());
			String fnacimiento = anio+"-"+mes+"-"+dia;
			int edad = Integer.parseInt(txtEdad.getText());
			float prepasaje = Float.parseFloat(txtPrecio.getText());
			
			
			vsa1.cambiarColorAsiento(asiento);
			vp.enable(true);
			this.dispose();
		}
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtDni) {
			keyTypedTxtDni(arg0);
		}
	}
	protected void keyTypedTxtDni(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == (char)KeyEvent.VK_ENTER){
			int dni;
			if(txtDni.getText().length() != 8){
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Ingrese dni correcto");
				this.setAlwaysOnTop(true);
			}
			else{
				dni = Integer.parseInt(txtDni.getText());
				Consultas consulta = new Consultas();
				ResultSet rs = consulta.buscarPasajero(dni);
				try {
					rs.next();
					txtRuc.setText(rs.getString("ruc"));
					txtNombre.setText(rs.getString("nombre"));
					txtRazsocial.setText(rs.getString("razsocial"));
				} catch (SQLException ex) {
					this.setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "No existe el pasajero, se creará uno nuevo.");
					txtRuc.requestFocus();
					this.setAlwaysOnTop(true);
					txtRuc.setText(null);
					txtNombre.setText(null);
					txtRazsocial.setText(null);
					cbDia.setSelectedIndex(0);
					cbMes.setSelectedIndex(0);
					cbAnio.setSelectedIndex(0);
					txtEdad.setText(null);
					txtPrecio.setText(""+prepasajeoriginal);
				}
				
				
			}
		}
		
	}
}








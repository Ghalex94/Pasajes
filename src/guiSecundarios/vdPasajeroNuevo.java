package guiSecundarios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.vPrincipal;
import gui.viListaPasajeros;
import mysql.Consultas;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class vdPasajeroNuevo extends JDialog implements ActionListener {
	private JTextField textField;
	private JLabel label;
	private JTextField txtDni;
	private JLabel label_1;
	private JTextField txtRuc;
	private JTextField txtNombre;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txtRazSocial;
	private JLabel label_4;
	private JComboBox cbDia;
	private JComboBox cbMes;
	private JComboBox cbAnio;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel label_5;

	vPrincipal vp = null;
	viListaPasajeros vilp = null; // VENTANA INTERNA LISTA PASAJEROS
	int opc = 0; 
	int dni = 0;
	private JLabel lblNacionalidad;
	private JTextField txtNacionalidad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			vdPasajeroNuevo dialog = new vdPasajeroNuevo(null, null, 0, 0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vdPasajeroNuevo(vPrincipal temp, viListaPasajeros temp1, int temp2, int temp3) {
		vp = temp;
		vilp = temp1;
		opc = temp2;
		dni = temp3;
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setBounds(100, 100, 654, 441);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setText("DATOS DE PASAJERO");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("USAngel", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(30, 144, 255));
		textField.setBounds(0, 0, 649, 46);
		getContentPane().add(textField);
		
		label = new JLabel("DNI:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label.setBounds(47, 89, 132, 20);
		getContentPane().add(label);
		
		txtDni = new JTextField();
		txtDni.setText("0");
		txtDni.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtDni.setColumns(10);
		txtDni.setBounds(204, 88, 392, 23);
		getContentPane().add(txtDni);
		
		label_1 = new JLabel("*RUC:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_1.setBounds(47, 129, 132, 20);
		getContentPane().add(label_1);
		
		txtRuc = new JTextField();
		txtRuc.setText((String) null);
		txtRuc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtRuc.setColumns(10);
		txtRuc.setBounds(204, 128, 392, 23);
		getContentPane().add(txtRuc);
		
		txtNombre = new JTextField();
		txtNombre.setText((String) null);
		txtNombre.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(204, 162, 392, 23);
		getContentPane().add(txtNombre);
		
		label_2 = new JLabel("Nombre:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_2.setBounds(47, 163, 132, 20);
		getContentPane().add(label_2);
		
		label_3 = new JLabel("*Raz. Social:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_3.setBounds(47, 195, 154, 20);
		getContentPane().add(label_3);
		
		txtRazSocial = new JTextField();
		txtRazSocial.setText((String) null);
		txtRazSocial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtRazSocial.setColumns(10);
		txtRazSocial.setBounds(204, 194, 392, 23);
		getContentPane().add(txtRazSocial);
		
		label_4 = new JLabel("F. Nacimiento (d/m/a):");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_4.setBounds(49, 232, 251, 20);
		getContentPane().add(label_4);
		
		cbDia = new JComboBox();
		cbDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDia.setSelectedIndex(-1);
		cbDia.setFont(new Font("Segoe UI", Font.BOLD, 18));
		cbDia.setBounds(334, 228, 65, 27);
		getContentPane().add(cbDia);
		
		cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}));
		cbMes.setSelectedIndex(-1);
		cbMes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		cbMes.setBounds(409, 228, 112, 27);
		getContentPane().add(cbMes);
		
		cbAnio = new JComboBox();
		cbAnio.setFont(new Font("Segoe UI", Font.BOLD, 18));
		cbAnio.setBounds(531, 228, 65, 27);
		getContentPane().add(cbAnio);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(47, 335, 220, 53);
		getContentPane().add(btnCancelar);
		
		btnGuardar = new JButton("Guardar ");
		btnGuardar.addActionListener(this);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setBounds(376, 335, 220, 53);
		getContentPane().add(btnGuardar);
		
		label_5 = new JLabel("Los datos con * son opcionales");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(new Color(178, 34, 34));
		label_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		label_5.setBounds(0, 45, 251, 20);
		getContentPane().add(label_5);
		
		lblNacionalidad = new JLabel("Pa\u00EDs:");
		lblNacionalidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblNacionalidad.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblNacionalidad.setBounds(47, 267, 154, 20);
		getContentPane().add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setText("Per\u00FA");
		txtNacionalidad.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(204, 266, 392, 23);
		getContentPane().add(txtNacionalidad);
		cargar();
	}
	
	public void cargar(){
		Calendar cal= Calendar.getInstance();
		int anio= cal.get(Calendar.YEAR);
		for(int i = anio; i>=1900; i--) //AÑO
			cbAnio.addItem(i);
		
		if(opc == 2){
			txtDni.setEditable(false);
			try {
				Consultas consulta = new Consultas();
				ResultSet rs = null;
				rs = consulta.buscarPasajero(dni);
				rs.next();
				txtDni.setText(""+dni);
				txtNombre.setText(rs.getString("nombre"));
				txtRazSocial.setText(rs.getString("razsocial"));
				txtRuc.setText(rs.getString("ruc"));
				txtNacionalidad.setText(rs.getString("nacionalidad"));
				
				String fnacimiento =  rs.getString("fnacimiento").toString();
				String[] parts = fnacimiento.split("-");
				int a = Integer.parseInt(parts[0]); //año
				int m = Integer.parseInt(parts[1]); //mes
				int d = Integer.parseInt(parts[2]); //dia
				cbDia.setSelectedIndex(d-1);
				cbMes.setSelectedIndex(m-1);
				cbAnio.setSelectedItem(a);
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR: " + e);
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		if(txtNombre.getText().length() == 0 || txtDni.getText().length() != 8 || txtNacionalidad.getText().length() == 0 || cbAnio.getSelectedIndex() < 0 || cbMes.getSelectedIndex() < 0 || cbDia.getSelectedIndex() < 0){
			this.setAlwaysOnTop(false);		
			JOptionPane.showMessageDialog(null, "Ingrese los datos necesarios correctamente");
			this.setAlwaysOnTop(true);
		}
		else{
			if(opc ==1){
				int dni = Integer.parseInt(txtDni.getText());
				String ruc = txtRuc.getText();
				int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
				int mes = cbMes.getSelectedIndex() + 1;
				int anio = Integer.parseInt(cbAnio.getSelectedItem().toString());
				String fnacimiento = "" + anio + "-" + mes + "-" + dia;
				String nombre = txtNombre.getText();
				String razSocial = txtRazSocial.getText();
				String nacionalidad = txtNacionalidad.getText();
				
				Consultas consulta = new Consultas();
				consulta.crearPasajero(dni, ruc, fnacimiento, nombre, razSocial, nacionalidad);
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Cliente creado correctamente.");
			}
			if(opc == 2){
				int dni = Integer.parseInt(txtDni.getText());
				String ruc = txtRuc.getText();
				int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
				int mes = cbMes.getSelectedIndex() + 1;
				int anio = Integer.parseInt(cbAnio.getSelectedItem().toString());
				String fnacimiento = "" + anio + "-" + mes + "-" + dia;
				String nombre = txtNombre.getText();
				String razSocial = txtRazSocial.getText();
				String nacionalidad = txtNacionalidad.getText();
				Consultas consulta = new Consultas();
				consulta.actualizarPasajero(dni, ruc, fnacimiento, nombre, razSocial, nacionalidad);
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Cliente modificado correctamente.");
			}		
			vp.enable(true);
			vilp.cargar();
			this.dispose();
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		vp.enable(true);
		this.dispose();
	}
}

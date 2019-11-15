package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import mysql.Consultas;
import mysql.MySQLConexion;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.math.BigInteger;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import clases.AbstractJasperReports;
import clases.NumeroLetras;
import java.awt.Component;
import javax.swing.JCheckBox;

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
	viSeleccionAsientos2 vsa2 = null;
	viSeleccionAsientos3 vsa3 = null;
	viSeleccionAsientos4 vsa4 = null;
	viSeleccionAsientos1 vsa1 = null;
	int prepasajeoriginal = 0;
	private JButton btnEliminar;
	private JLabel lblNacionalidad;
	private JTextField txtNacionalidad;
	private JTextField txtNboleto;
	private JLabel lblBoletoNo;
	private JCheckBox chckbxImprimir;
	private JCheckBox chckbxContratante;
	private JLabel label_1;
	private JLabel lblDireccin;
	private JTextField txtDireccion;
	
	
	public static void main(String[] args) {
		try {
			vdAsiento dialog = new vdAsiento(null, 0, null, null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public vdAsiento(vPrincipal temp, int temp2, viSeleccionAsientos3 temp3, viSeleccionAsientos4 temp4, viSeleccionAsientos2 temp5, viSeleccionAsientos1 temp6) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		vp = temp;
		asiento = temp2;
		vsa2 = temp5;
		vsa3 = temp3;
		vsa4 = temp4;
		vsa1 = temp6;
		
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBounds(100, 100, 649, 560);
		getContentPane().setLayout(null);
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setText("DATOS DE PASAJERO");
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setForeground(Color.WHITE);
			textField.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
			textField.setColumns(10);
			textField.setBackground(new Color(0, 139, 139));
			textField.setBounds(0, 0, 649, 46);
			getContentPane().add(textField);
		}
		{
			JLabel lblDni = new JLabel("DNI:");
			lblDni.setHorizontalAlignment(SwingConstants.LEFT);
			lblDni.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			lblDni.setBounds(39, 152, 132, 20);
			getContentPane().add(lblDni);
		}
		{
			txtDni = new JTextField();
			txtDni.addKeyListener(this);
			txtDni.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			txtDni.setColumns(10);
			txtDni.setBounds(185, 151, 403, 23);
			getContentPane().add(txtDni);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			lblNombre.setBounds(39, 188, 132, 20);
			getContentPane().add(lblNombre);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
			txtPrecio.addKeyListener(this);
			txtPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(446, 402, 72, 23);
			getContentPane().add(txtPrecio);
		}
		{
			btnGuardar = new JButton("<html>Guardar e<br>imprimir</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnGuardar.setBackground(new Color(0, 139, 139));
			btnGuardar.setBounds(368, 496, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			JLabel label = new JLabel("Edad:");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			label.setBounds(39, 402, 78, 20);
			getContentPane().add(label);
		}
		{
			txtNombre = new JTextField();
			txtNombre.addKeyListener(this);
			txtNombre.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			txtNombre.setColumns(10);
			txtNombre.setBounds(185, 187, 403, 23);
			getContentPane().add(txtNombre);
		}
		{
			JLabel label = new JLabel("Precio:");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			label.setBounds(325, 402, 102, 20);
			getContentPane().add(label);
		}
		{
			txtEdad = new JTextField();
			txtEdad.setEditable(false);
			txtEdad.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			txtEdad.setColumns(10);
			txtEdad.setBounds(127, 402, 107, 23);
			getContentPane().add(txtEdad);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnCancelar.setBackground(new Color(0, 139, 139));
			btnCancelar.setBounds(39, 496, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			lblAsiento = new JLabel("ASIENTO:");
			lblAsiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblAsiento.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			lblAsiento.setBounds(39, 81, 132, 20);
			getContentPane().add(lblAsiento);
		}
		{
			lblNAsiento = new JLabel("");
			lblNAsiento.setForeground(new Color(220, 20, 60));
			lblNAsiento.setBackground(Color.WHITE);
			lblNAsiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblNAsiento.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			lblNAsiento.setBounds(185, 81, 173, 20);
			getContentPane().add(lblNAsiento);
		}
		{
			lblFNacimiento = new JLabel("F. Nacimiento (d/m/a):");
			lblFNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblFNacimiento.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			lblFNacimiento.setBounds(41, 363, 251, 20);
			getContentPane().add(lblFNacimiento);
		}
		
		cbDia = new JComboBox();
		cbDia.addActionListener(this);
		cbDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDia.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		cbDia.setBounds(326, 359, 65, 27);
		getContentPane().add(cbDia);
		
		cbMes = new JComboBox();
		cbMes.addActionListener(this);
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}));
		cbMes.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		cbMes.setBounds(401, 359, 112, 27);
		getContentPane().add(cbMes);
		
		cbAnio = new JComboBox();
		cbAnio.addActionListener(this);
		cbAnio.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		cbAnio.setBounds(523, 359, 65, 27);
		getContentPane().add(cbAnio);
		
		txtRuc = new JTextField();
		txtRuc.addKeyListener(this);
		txtRuc.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtRuc.setColumns(10);
		txtRuc.setBounds(185, 224, 403, 23);
		getContentPane().add(txtRuc);
		
		lblRuc = new JLabel("*RUC:");
		lblRuc.setHorizontalAlignment(SwingConstants.LEFT);
		lblRuc.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblRuc.setBounds(39, 225, 132, 20);
		getContentPane().add(lblRuc);
		
		lblRazSocial = new JLabel("*Raz. Social:");
		lblRazSocial.setHorizontalAlignment(SwingConstants.LEFT);
		lblRazSocial.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblRazSocial.setBounds(39, 261, 154, 20);
		getContentPane().add(lblRazSocial);
		
		txtRazsocial = new JTextField();
		txtRazsocial.addKeyListener(this);
		txtRazsocial.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtRazsocial.setColumns(10);
		txtRazsocial.setBounds(185, 260, 403, 23);
		getContentPane().add(txtRazsocial);
		{
			lblOpcional = new JLabel("Los datos con * son opcionales");
			lblOpcional.setForeground(new Color(178, 34, 34));
			lblOpcional.setHorizontalAlignment(SwingConstants.LEFT);
			lblOpcional.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblOpcional.setBounds(10, 44, 251, 20);
			getContentPane().add(lblOpcional);
		}
		
		btnEliminar = new JButton("X");
		btnEliminar.setVisible(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnEliminar(arg0);
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setBounds(269, 496, 89, 53);
		getContentPane().add(btnEliminar);
		{
			lblNacionalidad = new JLabel("Pa\u00EDs:");
			lblNacionalidad.setHorizontalAlignment(SwingConstants.LEFT);
			lblNacionalidad.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			lblNacionalidad.setBounds(39, 296, 154, 20);
			getContentPane().add(lblNacionalidad);
		}
		{
			txtNacionalidad = new JTextField();
			txtNacionalidad.addKeyListener(this);
			txtNacionalidad.setText("Per\u00FA");
			txtNacionalidad.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			txtNacionalidad.setColumns(10);
			txtNacionalidad.setBounds(185, 295, 403, 23);
			getContentPane().add(txtNacionalidad);
		}
		{
			txtNboleto = new JTextField();
			txtNboleto.setForeground(Color.RED);
			txtNboleto.setText("0");
			txtNboleto.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			txtNboleto.setColumns(10);
			txtNboleto.setBounds(185, 112, 206, 23);
			getContentPane().add(txtNboleto);
		}
		{
			lblBoletoNo = new JLabel("BOLETO No:");
			lblBoletoNo.setHorizontalAlignment(SwingConstants.LEFT);
			lblBoletoNo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			lblBoletoNo.setBounds(39, 113, 154, 20);
			getContentPane().add(lblBoletoNo);
		}
		
		chckbxImprimir = new JCheckBox("Imprimir?");
		chckbxImprimir.setSelected(true);
		chckbxImprimir.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		chckbxImprimir.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxImprimir.setBackground(Color.LIGHT_GRAY);
		chckbxImprimir.setBounds(446, 471, 142, 23);
		getContentPane().add(chckbxImprimir);
		{
			chckbxContratante = new JCheckBox("\u00BFCONTRATANTE?");
			chckbxContratante.setForeground(new Color(255, 255, 0));
			chckbxContratante.setHorizontalAlignment(SwingConstants.CENTER);
			chckbxContratante.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			chckbxContratante.setBackground(Color.LIGHT_GRAY);
			chckbxContratante.setBounds(198, 442, 240, 35);
			getContentPane().add(chckbxContratante);
		}
		{
			label_1 = new JLabel(".00");
			label_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			label_1.setBackground(Color.WHITE);
			label_1.setBounds(518, 402, 52, 23);
			getContentPane().add(label_1);
		}
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccin.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblDireccin.setBounds(39, 330, 154, 20);
		getContentPane().add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(185, 329, 403, 23);
		getContentPane().add(txtDireccion);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtDni, txtNombre, txtRuc, txtRazsocial, txtNacionalidad, txtDireccion, cbDia, cbMes, cbAnio, txtEdad, txtPrecio, btnGuardar, btnCancelar, btnEliminar}));
		cargar();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cbAnio) {
			actionPerformedCbAnio(arg0);
		}
		if (arg0.getSource() == cbMes) {
			actionPerformedCbMes(arg0);
		}
		if (arg0.getSource() == cbDia) {
			actionPerformedCbDia(arg0);
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
		lblNAsiento.setText(""+asiento);
		Consultas consulta = new Consultas();
		consulta.iniciar();
		ResultSet rs = consulta.cargarVentaTemporal();
		try {
			rs.next();
			//txtPrecio.setText(rs.getString("prepasaje"));
			int prepas = Integer.parseInt(rs.getString("prepasaje"));
			txtPrecio.setText(""+prepas);
			prepasajeoriginal = Integer.parseInt(rs.getString("prepasaje"));
		} catch (SQLException e) {	e.printStackTrace(); }
		//LLENAR COMBOS DE FECHA
		/*for(int i = 1; i<=31; i++) //DIA
			cbDia.addItem(i);*/
		Calendar cal= Calendar.getInstance();
		int anio= cal.get(Calendar.YEAR);
		for(int i = anio; i>=1900; i--) //AÑO
			cbAnio.addItem(i);
		
		
		try {
			ResultSet rs2 = consulta.buscarPasajerosTemporal(asiento);
			rs2.next();
			txtNboleto.setText("" + rs2.getInt("nboleto"));
			int dnipasajero = rs2.getInt("dnipasajero");
			txtDni.setText(""+dnipasajero);
			txtEdad.setText("" + rs2.getInt("edad"));
			txtPrecio.setText("" + rs2.getFloat("prepasaje"));
			int estado = rs.getInt("estado");
			int contratante = rs2.getInt("contratante");
			if(contratante == 1)
				chckbxContratante.setSelected(true);
			ResultSet rs3 = consulta.buscarPasajero(dnipasajero);
			rs3.next();
			txtRuc.setText(rs3.getString("ruc"));
			txtNombre.setText(rs3.getString("nombre"));
			txtRazsocial.setText(rs3.getString("razsocial"));
			txtNacionalidad.setText(rs3.getString("nacionalidad"));
			txtDireccion.setText(rs3.getString("direccion"));
			String fnacimiento =  rs3.getString("fnacimiento").toString();
			String[] parts = fnacimiento.split("-");
			int a = Integer.parseInt(parts[0]); //año
			int m = Integer.parseInt(parts[1]); //mes
			int d = Integer.parseInt(parts[2]); //dia
			this.setAlwaysOnTop(false);
			//JOptionPane.showMessageDialog(null, a+" "+m+" "+d);
			cbDia.setSelectedIndex(d-1);
			cbMes.setSelectedIndex(m-1);
			cbAnio.setSelectedItem(a);
			/*for(int i = 0 ; i<cbAnio.getItemCount(); i++){
				if(Integer.parseInt(cbAnio.getItemAt(i).toString()) == a)
					cbAnio.setSelectedIndex(i);
			}*/
			if(estado == 1){
				txtNboleto.setEditable(false);
				txtDni.setEditable(false);
				txtRuc.setEditable(false);
				txtNombre.setEditable(false);
				txtRazsocial.setEditable(false);
				txtEdad.setEditable(false);
				txtPrecio.setEditable(false);
				cbDia.setEnabled(false);
				cbMes.setEnabled(false);
				cbAnio.setEnabled(false);
				btnGuardar.setEnabled(false);
				btnEliminar.setVisible(true);
				chckbxContratante.setEnabled(false);
			}
			rs2.close();
			rs3.close();
			
		} catch (Exception e) {
			try { //ASIGNAR N BOLETO SI EL ASIENTO ESTÁ VACIO
				ResultSet rs4 = consulta.ultimoNboleto();
				rs4.next();
				int ultimoNboleto = rs4.getInt("nboleto");
				txtNboleto.setText("" + (ultimoNboleto+1));
				rs4.close();
			} catch (SQLException e1) {
				// SI NO EXISTE ALGUN BOLETO EN TABLA PASAJERO TEMPORAL, BUSCAR EN LA ANTERIOR VENTA
				try {
					ResultSet rs5 = consulta.ultboletoUltVenta();
					rs5.next();
					int ultimoNboleto = rs5.getInt("nboleto");
					txtNboleto.setText("" + (ultimoNboleto+1));
					rs5.close();
				} catch (Exception e2) {
					//SI NO EXISTE NINGUNA VENTA, BUSCARA LA SERIE DE LA CONFGURACION PRINCIPAL
					try {
						ResultSet rs6 = consulta.nasientoCInicial();
						rs6.next();
						int ultimoNboleto = rs6.getInt("nboletoinicial");
						txtNboleto.setText("" + (ultimoNboleto));
						rs6.close();
					} catch (Exception e3) {
					}
				}
			}
		}
		
		try {
			rs.close();
			consulta.reset();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		vp.enable(true);
		this.dispose();
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		if(txtDni.getText().length() == 0 || txtNombre.getText().length() == 0 || txtEdad.getText().length() == 0 || txtPrecio.getText().length() == 0 || txtDni.getText().length() != 8 || txtNacionalidad.getText().length() == 0){
			this.setAlwaysOnTop(false);		
			JOptionPane.showMessageDialog(null, "Ingrese los datos necesarios correctamente");
			this.setAlwaysOnTop(true);
		}
		else{
			this.setAlwaysOnTop(false);
			int opc = JOptionPane.showConfirmDialog(null, "¿Vender pasaje?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			this.setAlwaysOnTop(true);
			if (opc == 0){
				int nboleto = Integer.parseInt(txtNboleto.getText());
				int dnipasajero = Integer.parseInt(txtDni.getText());
				String ruc = "";
				if(txtRuc.getText().length()>0)
					ruc = txtRuc.getText();
				String nombre = txtNombre.getText();
				String razsocial = null;
				if(txtRazsocial.getText().length()>0)
					razsocial = txtRazsocial.getText();
				int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
				int mes = cbMes.getSelectedIndex() + 1;
				int anio = Integer.parseInt(cbAnio.getSelectedItem().toString());
				int edad = Integer.parseInt(txtEdad.getText());
				String fnacimiento = "" + anio + "-" + mes + "-" + dia;
				float prepasaje = Float.parseFloat(txtPrecio.getText() + ".00");
				String nacionalidad = txtNacionalidad.getText();
				String direccion = txtDireccion.getText();
				int contratante = 0;
				if(chckbxContratante.isSelected())
					contratante = 1;
				try {
					Consultas consulta = new Consultas();
					consulta.iniciar();
					ResultSet rs = consulta.buscarPasajero(dnipasajero);
					if(rs.next()){// SE ACTUALIZARÁ LOS DATOS DEL PASAJERO
						Consultas consulta2 = new Consultas();
						consulta2.iniciar();
						consulta2.actualizarPasajero(dnipasajero, ruc, fnacimiento, nombre, razsocial, nacionalidad, direccion);
						consulta2.reset();
					}
					else{// SE CREARÁ UN PASAJERO NUEVO
						this.setAlwaysOnTop(false);
						consulta.crearPasajero(dnipasajero, ruc, fnacimiento, nombre, razsocial, nacionalidad, direccion);					
					}
					rs.close();
					consulta.reset();
				} catch (SQLException ex) {
					this.setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "ERROR: " + ex);
					this.setAlwaysOnTop(true);
				}
				
				try {
					Consultas consulta3 = new Consultas();
					consulta3.iniciar();
					this.setAlwaysOnTop(false);
					consulta3.asignarAsiento(asiento, dnipasajero, edad, prepasaje, nboleto, contratante);
					
					if(vsa1 != null)
						vsa1.cambiarColorAsiento(asiento, contratante);
					if(vsa2 != null)
						vsa2.cambiarColorAsiento(asiento, contratante);
					if(vsa3 != null)
						vsa3.cambiarColorAsiento(asiento, contratante);
					if(vsa4 != null)
						vsa4.cambiarColorAsiento(asiento, contratante);
					vp.enable(true);
					consulta3.reset();
					this.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERROR: " + e);
				}
				
				
				sumarTotalPasajes();
				//IMPRIMIR
				if(chckbxImprimir.isSelected()){
					try {
						this.setAlwaysOnTop(false);
						
						String precio = txtPrecio.getText();
						precio = precio + ".00";
						String[] arrayprecio = precio.split("\\.");
						String soles = arrayprecio[0];
						String centimos = arrayprecio[1];
						//JOptionPane.showMessageDialog(null, soles + "   -   " + centimos);
						String solesLetras = new NumeroLetras().convertir(Integer.parseInt(soles));
						//JOptionPane.showMessageDialog(null, solesLetras + " CON " + centimos);
						String precioLetras = solesLetras + " CON " + centimos + "/100 SOLES";
						Connection con = MySQLConexion.getConection();
						int asiento = Integer.parseInt(lblNAsiento.getText());
						
						//IMPRIMIR TICKET
						try {
							Map<String, Object> parameters = new HashMap();
							parameters.put("prmtNasiento", asiento);
							parameters.put("prmtPrecioLetras", precioLetras);
							/*new AbstractJasperReports().createReport( con.getConn(), "rPrueba.jasper", null);
							AbstractJasperReports.showViewer();*/
							try{
								//JasperReport reporte=(JasperReport) JRLoader.loadObjectFromFile("D:\\ INFORMACION_DEL_SISTEMA\\rBoleto.jasper");
								//JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters, con);
								JasperPrint impressao = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("rBoleto.jasper"), parameters, con);
	
								//AbstractJasperReports.showViewer();
								JasperPrintManager.printReport(impressao, false);
								JOptionPane.showMessageDialog(null, "VENTA CORRECTA");          
							}
							catch (JRException ex){
								System.err.println( "Error iReport: " + ex.getMessage() );
							}
							
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "ERROR2 "+ e);
						}				
						con.close();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"ERROR1 " + e);
					}
				}
				
			}
		}
	}
	
	public void sumarTotalPasajes(){
		try {
			Consultas consulta = new Consultas();

			consulta.iniciar();
			ResultSet rs = consulta.cargarPasajerosTemporal();
			float tot = 0 ;
			while(rs.next()){
				tot = tot + rs.getFloat("prepasaje");
			}
			if(vsa1!= null)
				vsa1.lblTotal.setText(""+tot);
			if(vsa2!= null)
				vsa2.lblTotal.setText(""+tot);
			if(vsa3!= null)
				vsa3.lblTotal.setText(""+tot);
			if(vsa4!= null)
				vsa4.lblTotal.setText(""+tot);

			consulta.reset();
		}
		catch (Exception e) {
		}
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtPrecio) {
			keyTypedTxtPrecio(arg0);
		}
		if (arg0.getSource() == txtNacionalidad) {
			keyTypedTxtNacionalidad(arg0);
		}
		if (arg0.getSource() == txtRazsocial) {
			keyTypedTxtRazsocial(arg0);
		}
		if (arg0.getSource() == txtRuc) {
			keyTypedTxtRuc(arg0);
		}
		if (arg0.getSource() == txtNombre) {
			keyTypedTxtNombre(arg0);
		}
		if (arg0.getSource() == txtDni) {
			keyTypedTxtDni(arg0);
		}
	}
	protected void keyTypedTxtDni(KeyEvent e) {
		char c = e.getKeyChar();
		
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER)){
			e.consume();
		}
		if (txtDni.getText().length() == 8){
			e.consume();
		}
		
		
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
				consulta.iniciar();
				ResultSet rs = consulta.buscarPasajero(dni);
				try {
					rs.next();
					txtRuc.setText(rs.getString("ruc"));
					txtNombre.setText(rs.getString("nombre"));
					txtRazsocial.setText(rs.getString("razsocial"));
					String fnacimiento =  rs.getString("fnacimiento").toString();
					String[] parts = fnacimiento.split("-");
					int anio = Integer.parseInt(parts[0]); //año
					int mes = Integer.parseInt(parts[1]); //mes
					int dia = Integer.parseInt(parts[2]); //dia
					
					cbDia.setSelectedIndex(dia-1);
					cbMes.setSelectedIndex(mes-1);
					for(int i = 0 ; i<cbAnio.getItemCount(); i++){
						if(Integer.parseInt(cbAnio.getItemAt(i).toString()) == anio)
							cbAnio.setSelectedIndex(i);
					}
					int edad = calcularEdad(dia, mes, anio);
					txtEdad.setText(""+edad);
					txtNacionalidad.setText(rs.getString("nacionalidad"));
					txtDireccion.setText(rs.getString("direccion"));
				} catch (SQLException ex) {
					this.setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "No existe el pasajero, se creará uno nuevo.");
					txtNombre.requestFocus();
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
				consulta.reset();
			}
		}
	}
	
	public int calcularEdad(int dia, int mes, int anio){
		Scanner sca = new Scanner(System.in);
        Calendar cal = new GregorianCalendar();
        int mesActual = cal.get(Calendar.MONTH) + 1;
        int anioActual = cal.get(Calendar.YEAR);
        int diaActual = cal.get(Calendar.DAY_OF_MONTH);
        
        int mesResultado, diaResultado, anioResultado;
        
        anioResultado = anioActual - anio;
        mesResultado = mesActual - mes;
        diaResultado = diaActual - dia;
        		            
        if(mesResultado < 0 // Aún no es el mes de su cumpleaños
                || (mesResultado==0 && diaResultado < 0)) { // o es el mes pero no ha llegado el día.
        	anioResultado--;
             }
        /*
        this.setAlwaysOnTop(false);
        JOptionPane.showMessageDialog(null, "Tienes " + anioResultado + " años" + ", " + mesResultado
                + " meses " + " y " + diaResultado + " días");
        */
        return anioResultado;
	}
	protected void actionPerformedCbDia(ActionEvent arg0) {
		int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
		int mes = cbMes.getSelectedIndex() + 1;
		int anio = Integer.parseInt(cbAnio.getSelectedItem().toString());
		int edad = calcularEdad(dia, mes, anio);
		txtEdad.setText(""+edad);
	}
	protected void actionPerformedCbMes(ActionEvent arg0) {
		int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
		int mes = cbMes.getSelectedIndex() + 1;
		int anio = Integer.parseInt(cbAnio.getSelectedItem().toString());
		int edad = calcularEdad(dia, mes, anio);
		txtEdad.setText(""+edad);
	}
	protected void actionPerformedCbAnio(ActionEvent arg0) {
		int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
		int mes = cbMes.getSelectedIndex() + 1;
		int anio = Integer.parseInt(cbAnio.getSelectedItem().toString());
		int edad = calcularEdad(dia, mes, anio);
		txtEdad.setText(""+edad);
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		this.setAlwaysOnTop(false);
		int opc = JOptionPane.showConfirmDialog(null, "¿Liberar asiento?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		this.setAlwaysOnTop(true);
		if (opc == 0){
			Consultas consulta = new Consultas();

			consulta.iniciar();
			consulta.eliminarAsiento(asiento);
			this.setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "Asiento Liberado");
			
			if(vsa1!= null)
				vsa1.cambiarColorAsientoVerde(asiento);;
			if(vsa2!= null)
				vsa2.cambiarColorAsientoVerde(asiento);;
			if(vsa3!= null)
				vsa3.cambiarColorAsientoVerde(asiento);;
			if(vsa4!= null)
				vsa4.cambiarColorAsientoVerde(asiento);;
			sumarTotalPasajes();
			vp.enable(true);
			this.dispose();

			consulta.reset();
		}
	}
	protected void keyTypedTxtNombre(KeyEvent arg0) {
		
		if (txtNombre.getText().length() == 50){
			arg0.consume();
		}
	}
	protected void keyTypedTxtRuc(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER)){
			arg0.consume();
		}
		if (txtRuc.getText().length() == 11){
			arg0.consume();
		}
	}
	protected void keyTypedTxtRazsocial(KeyEvent arg0) {
		if (txtRazsocial.getText().length() == 80){
			arg0.consume();
		}
	}
	protected void keyTypedTxtNacionalidad(KeyEvent arg0) {
		if (txtNacionalidad.getText().length() == 50){
			arg0.consume();
		}
	}
	protected void keyTypedTxtPrecio(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE)){
			arg0.consume();
		}
		if (txtPrecio.getText().length() == 4){
			arg0.consume();
		}
	}
}








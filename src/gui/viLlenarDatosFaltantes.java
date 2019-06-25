package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Conductor;
import mysql.Consultas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class viLlenarDatosFaltantes extends JInternalFrame implements ActionListener, KeyListener {
	private JTextField txtCompletarDatos;
	private JLabel lblViajeStandar;
	private JTextField txtDesde;
	private JCheckBox chbxViajeStandar;
	private JLabel lblEscalasComerciales;
	private JCheckBox chbxEscalasCom;
	private JLabel lblContratante;
	private JLabel lblHataLaCiudad;
	private JTextField txtHasta;
	private JLabel lblPuntoDeEncuento;
	private JTextField txtPencuentro;
	private JLabel lblEscalasYParadas;
	private JTextArea txtEscalasParadas;
	private JLabel lblConductor;
	private JTextField txtConductor1;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JLabel lblNLicenciaDe;
	private JTextField txtNlicencia1;
	private JLabel lblConductor_1;
	private JLabel label_1;
	private JTextField txtNlicencia2;
	private JLabel label_2;
	private JLabel label_3;
	private JComboBox <Conductor> cbConductor2;

	vPrincipal vp = null;
	private JButton btnGuardarCambios;
	private JComboBox cbHinicio1;
	private JComboBox cbMinicio1;
	private JComboBox cbHinicio2;
	private JComboBox cbMinicio2;
	private JComboBox cbHfin1;
	private JComboBox cbMfin1;
	private JComboBox cbHfin2;
	private JComboBox cbMfin2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viLlenarDatosFaltantes frame = new viLlenarDatosFaltantes(null);
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
	public viLlenarDatosFaltantes(vPrincipal temp) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		vp = temp;
		
		setBounds(100, 100, 1373, 676);
		getContentPane().setLayout(null);
		
		txtCompletarDatos = new JTextField();
		txtCompletarDatos.setText("COMPLETAR DATOS");
		txtCompletarDatos.setRequestFocusEnabled(false);
		txtCompletarDatos.setIgnoreRepaint(true);
		txtCompletarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		txtCompletarDatos.setForeground(Color.WHITE);
		txtCompletarDatos.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		txtCompletarDatos.setFocusable(false);
		txtCompletarDatos.setFocusTraversalKeysEnabled(false);
		txtCompletarDatos.setEditable(false);
		txtCompletarDatos.setColumns(10);
		txtCompletarDatos.setBackground(Color.DARK_GRAY);
		txtCompletarDatos.setBounds(0, 0, 1920, 75);
		getContentPane().add(txtCompletarDatos);
		
		lblViajeStandar = new JLabel("Viaje Standar");
		lblViajeStandar.setHorizontalAlignment(SwingConstants.LEFT);
		lblViajeStandar.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblViajeStandar.setBounds(30, 104, 189, 20);
		getContentPane().add(lblViajeStandar);
		
		txtDesde = new JTextField();
		txtDesde.addKeyListener(this);
		txtDesde.setText((String) null);
		txtDesde.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDesde.setColumns(10);
		txtDesde.setBounds(30, 208, 355, 38);
		getContentPane().add(txtDesde);
		
		chbxViajeStandar = new JCheckBox("");
		chbxViajeStandar.setBackground(Color.LIGHT_GRAY);
		chbxViajeStandar.setSelected(true);
		chbxViajeStandar.setBounds(287, 104, 40, 26);
		getContentPane().add(chbxViajeStandar);
		
		lblEscalasComerciales = new JLabel("Escalas comerciales");
		lblEscalasComerciales.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscalasComerciales.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblEscalasComerciales.setBounds(30, 140, 251, 26);
		getContentPane().add(lblEscalasComerciales);
		
		chbxEscalasCom = new JCheckBox("");
		chbxEscalasCom.setBackground(Color.LIGHT_GRAY);
		chbxEscalasCom.setVerticalAlignment(SwingConstants.BOTTOM);
		chbxEscalasCom.setBounds(287, 140, 40, 26);
		getContentPane().add(chbxEscalasCom);
		
		lblContratante = new JLabel("Transportar desde la ciudad de: ");
		lblContratante.setHorizontalAlignment(SwingConstants.LEFT);
		lblContratante.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblContratante.setBounds(30, 180, 383, 20);
		getContentPane().add(lblContratante);
		
		lblHataLaCiudad = new JLabel("Hasta la ciudad de: ");
		lblHataLaCiudad.setHorizontalAlignment(SwingConstants.LEFT);
		lblHataLaCiudad.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblHataLaCiudad.setBounds(30, 261, 355, 20);
		getContentPane().add(lblHataLaCiudad);
		
		txtHasta = new JTextField();
		txtHasta.addKeyListener(this);
		txtHasta.setText((String) null);
		txtHasta.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtHasta.setColumns(10);
		txtHasta.setBounds(30, 284, 355, 38);
		getContentPane().add(txtHasta);
		
		lblPuntoDeEncuento = new JLabel("Punto de encuento en:");
		lblPuntoDeEncuento.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntoDeEncuento.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPuntoDeEncuento.setBounds(30, 325, 355, 38);
		getContentPane().add(lblPuntoDeEncuento);
		
		txtPencuentro = new JTextField();
		txtPencuentro.addKeyListener(this);
		txtPencuentro.setText((String) null);
		txtPencuentro.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtPencuentro.setColumns(10);
		txtPencuentro.setBounds(30, 363, 355, 43);
		getContentPane().add(txtPencuentro);
		
		lblEscalasYParadas = new JLabel("<html>Escalas y paradas en el recorrido:</html>");
		lblEscalasYParadas.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscalasYParadas.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblEscalasYParadas.setBounds(410, 325, 474, 38);
		getContentPane().add(lblEscalasYParadas);
		
		txtEscalasParadas = new JTextArea();
		txtEscalasParadas.setLineWrap(true);
		txtEscalasParadas.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtEscalasParadas.addKeyListener(this);
		txtEscalasParadas.setText("Sin escalas ni paradas.");
		txtEscalasParadas.setBounds(410, 363, 454, 75);
		getContentPane().add(txtEscalasParadas);
		
		lblConductor = new JLabel("Conductor 1:");
		lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblConductor.setBounds(410, 104, 427, 20);
		getContentPane().add(lblConductor);
		
		txtConductor1 = new JTextField();
		txtConductor1.setEditable(false);
		txtConductor1.setText((String) null);
		txtConductor1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtConductor1.setColumns(10);
		txtConductor1.setBounds(410, 132, 454, 38);
		getContentPane().add(txtConductor1);
		
		lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoraInicio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblHoraInicio.setBounds(409, 261, 169, 20);
		getContentPane().add(lblHoraInicio);
		
		lblHoraFin = new JLabel("Hora Fin:");
		lblHoraFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoraFin.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblHoraFin.setBounds(728, 261, 135, 20);
		getContentPane().add(lblHoraFin);
		
		lblNLicenciaDe = new JLabel("N Licencia de Conducir:");
		lblNLicenciaDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblNLicenciaDe.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNLicenciaDe.setBounds(410, 180, 427, 20);
		getContentPane().add(lblNLicenciaDe);
		
		txtNlicencia1 = new JTextField();
		txtNlicencia1.setText((String) null);
		txtNlicencia1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNlicencia1.setEditable(false);
		txtNlicencia1.setColumns(10);
		txtNlicencia1.setBounds(410, 208, 454, 38);
		getContentPane().add(txtNlicencia1);
		
		lblConductor_1 = new JLabel("Conductor 2:");
		lblConductor_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblConductor_1.setBounds(895, 104, 427, 20);
		getContentPane().add(lblConductor_1);
		
		label_1 = new JLabel("N Licencia de Conducir:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_1.setBounds(895, 180, 427, 20);
		getContentPane().add(label_1);
		
		txtNlicencia2 = new JTextField();
		txtNlicencia2.setEnabled(false);
		txtNlicencia2.setEditable(false);
		txtNlicencia2.setText((String) null);
		txtNlicencia2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNlicencia2.setColumns(10);
		txtNlicencia2.setBounds(895, 208, 454, 38);
		getContentPane().add(txtNlicencia2);
		
		label_2 = new JLabel("Hora Inicio:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(894, 261, 169, 20);
		getContentPane().add(label_2);
		
		label_3 = new JLabel("Hora Fin:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBounds(1213, 261, 169, 20);
		getContentPane().add(label_3);
		
		cbConductor2 = new JComboBox();
		cbConductor2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbConductor2.addActionListener(this);
		cbConductor2.setBounds(895, 132, 452, 38);
		getContentPane().add(cbConductor2);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.addActionListener(this);
		btnGuardarCambios.setForeground(Color.WHITE);
		btnGuardarCambios.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		btnGuardarCambios.setBackground(new Color(0, 139, 139));
		btnGuardarCambios.setBounds(895, 363, 454, 75);
		getContentPane().add(btnGuardarCambios);
		
		cbHinicio1 = new JComboBox();
		cbHinicio1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cbHinicio1.setEnabled(false);
		cbHinicio1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbHinicio1.setBounds(409, 284, 65, 23);
		getContentPane().add(cbHinicio1);
		
		cbMinicio1 = new JComboBox();
		cbMinicio1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cbMinicio1.setEnabled(false);
		cbMinicio1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		cbMinicio1.setBounds(474, 284, 58, 23);
		getContentPane().add(cbMinicio1);
		
		cbHinicio2 = new JComboBox();
		cbHinicio2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cbHinicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCbHinicio2(e);
			}
		});
		cbHinicio2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbHinicio2.setBounds(728, 284, 65, 23);
		getContentPane().add(cbHinicio2);
		
		cbMinicio2 = new JComboBox();
		cbMinicio2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cbMinicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCbMinicio2(e);
			}
		});
		cbMinicio2.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		cbMinicio2.setBounds(793, 284, 58, 23);
		getContentPane().add(cbMinicio2);
		
		cbHfin1 = new JComboBox();
		cbHfin1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cbHfin1.setEnabled(false);
		cbHfin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCbHfin1(e);
			}
		});
		cbHfin1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbHfin1.setBounds(894, 284, 65, 23);
		getContentPane().add(cbHfin1);
		
		cbMfin1 = new JComboBox();
		cbMfin1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cbMfin1.setEnabled(false);
		cbMfin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCbMfin1(e);
			}
		});
		cbMfin1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		cbMfin1.setBounds(959, 284, 58, 23);
		getContentPane().add(cbMfin1);
		
		cbHfin2 = new JComboBox();
		cbHfin2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cbHfin2.setEnabled(false);
		cbHfin2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbHfin2.setBounds(1213, 284, 65, 23);
		getContentPane().add(cbHfin2);
		
		cbMfin2 = new JComboBox();
		cbMfin2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cbMfin2.setEnabled(false);
		cbMfin2.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		cbMfin2.setBounds(1278, 284, 58, 23);
		getContentPane().add(cbMfin2);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{chbxViajeStandar, chbxEscalasCom, txtDesde, txtHasta, txtPencuentro, cbConductor2, txtEscalasParadas, btnGuardarCambios}));
		
		cargar();
	}
	
	public void cargar(){
		Conductor conductor = new Conductor();
		cbConductor2.addItem(new Conductor(0, "", ""));
		conductor.cargarConductores(cbConductor2);
		cbConductor2.setSelectedIndex(0);
		
		//Cargar venta temporal
		try {
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.cargarVentaTemporal();
			if(rs.next()){
				int dniconductor = rs.getInt("dniconductor");
				ResultSet rs2 = consulta.buscarConductor(dniconductor);
				if(rs2.next()){
					txtConductor1.setText(rs2.getString("conductor"));
					txtNlicencia1.setText(rs2.getString("licencia"));
					if(rs.getInt("standar") == 1)
						chbxViajeStandar.setSelected(true);
					if(rs.getInt("escalacom" ) == 1)
						chbxEscalasCom.setSelected(true);
					if(rs.getString("ciudaddesde") == null)
						txtDesde.setText(rs.getString("origen"));
					else
						txtDesde.setText(rs.getString("ciudaddesde"));
					if(rs.getString("ciudadhasta") == null)
						txtHasta.setText(rs.getString("destino"));
					else
						txtHasta.setText(rs.getString("ciudadhasta"));
					if(rs.getString("puntoencuentro") == null)
						txtPencuentro.setText("Terminal de " + rs.getString("origen"));
					else
						txtPencuentro.setText(rs.getString("puntoencuentro"));
					if(rs.getString("escalas") != null)
						txtEscalasParadas.setText(rs.getString("escalas"));
					if(rs.getString("licencia2") != null)
						txtNlicencia2.setText(rs.getString("licencia2"));
					if(rs.getInt("dniconductor2") != 0){
						for(int i = 0; i < cbConductor2.getItemCount(); i++){
							if(rs.getInt("dniconductor2") == cbConductor2.getItemAt(i).getDni()){
								cbConductor2.setSelectedIndex(i);
								i = cbConductor2.getItemCount();
							}
						}
					}
						
					String fpartidaoriginal = "";
					if(rs.getString("fpartida") != null){
						fpartidaoriginal = rs.getString("fpartida");
						String[] arrayfecha1 = fpartidaoriginal.split(" ");
						String horamin1 = arrayfecha1[1];
						String[] arrayhora1 = horamin1.split(":");
						String hora1 = arrayhora1[0];
						String minuto1 = arrayhora1[1];
						cbHinicio1.setSelectedItem(hora1);
						cbMinicio1.setSelectedItem(minuto1);
					}
						
					if(rs.getString("horainicio2") != null){						
						String horamininicio2 = rs.getString("horainicio2");
						String[] arrayhorainicio2 = horamininicio2.split(":");
						String horainicio2 = arrayhorainicio2[0];
						String mininicio2 = arrayhorainicio2[1];
						cbHinicio2.setSelectedItem(horainicio2);
						cbMinicio2.setSelectedItem(mininicio2);
						
						
					}
					else{
						String fllegadaoriginal = "";					
						if(rs.getString("fllegada") != null){
							fllegadaoriginal = rs.getString("fllegada");
							String[] arrayfecha2 = fllegadaoriginal.split(" ");
							String horamin2 = arrayfecha2[1];
							String[] arrayhora2 = horamin2.split(":");
							String hora2 = arrayhora2[0];
							String minuto2 = arrayhora2[1];
							cbHinicio2.setSelectedItem(hora2);
							cbMinicio2.setSelectedItem(minuto2);
						}
					}
						
					if(rs.getString("horafin1") != null){
						String horaminfin1 = rs.getString("horafin1");
						String[] arrayhorafin1 = horaminfin1.split(":");
						String horafin1 = arrayhorafin1[0];
						String minfin1 = arrayhorafin1[1];
						cbHfin1.setSelectedItem(horafin1);
						cbMfin1.setSelectedItem(minfin1);
					}
					if(rs.getString("horafin2") != null){
						String horaminfin2 = rs.getString("horafin2");
						String[] arrayhorafin2 = horaminfin2.split(":");
						String horafin2 = arrayhorafin2[0];
						String minfin2 = arrayhorafin2[1];
						cbHfin2.setSelectedItem(horafin2);
						cbMfin2.setSelectedItem(minfin2);
					}
					
				}			
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardarCambios) {
			actionPerformedBtnGuardarInformacion(arg0);
		}
		if (arg0.getSource() == cbConductor2) {
			actionPerformedCbConductor2(arg0);
		}
	}
	protected void actionPerformedCbConductor2(ActionEvent arg0) {
		txtNlicencia2.setText("" + cbConductor2.getItemAt(cbConductor2.getSelectedIndex()).getNlicencia());
		if(txtNlicencia2.getText().equals("")){}
		else{
			cbHfin1.setEnabled(true);
			cbMfin1.setEnabled(true);
			cbHfin2.setEnabled(true);
			cbMfin2.setEnabled(true);
		 }
	}
	protected void actionPerformedBtnGuardarInformacion(ActionEvent arg0) {
		int vstandar = 0;
		if(chbxViajeStandar.isSelected()) vstandar = 1;
		int escalascom = 0;
		if(chbxEscalasCom.isSelected()) escalascom = 1;
		
		String desde = null, hasta = null, pencuentro = null, escalasparadas = null, horafin1, licencia2 = null, horainicio2, horafin2, comentarios = null;
		int dniconductor2 = 0;
		if(txtDesde.getText().length() != 0)
			desde = txtDesde.getText();
		if(txtHasta.getText().length() != 0)
			hasta = txtHasta.getText();
		if(txtPencuentro.getText().length() != 0)
			pencuentro = txtPencuentro.getText();
		if(txtEscalasParadas.getText().length() != 0)
			escalasparadas = txtEscalasParadas.getText();
		horainicio2 = cbHinicio2.getSelectedItem().toString() + ":" + cbMinicio2.getSelectedItem().toString();
		dniconductor2 = cbConductor2.getItemAt(cbConductor2.getSelectedIndex()).getDni();
		if(txtNlicencia2.getText().length() != 0)
			licencia2 = txtNlicencia2.getText();
		horafin1 = cbHfin1.getSelectedItem().toString() + ":" + cbMfin1.getSelectedItem().toString();
		horafin2 = cbHfin2.getSelectedItem().toString() + ":" + cbMfin2.getSelectedItem().toString();
		
		Consultas.actualizarVentaTemporal08(vstandar, escalascom, desde, hasta, pencuentro, escalasparadas,
				horainicio2, dniconductor2, licencia2, horafin1, horafin2, comentarios);
	}
	protected void actionPerformedCbHinicio2(ActionEvent e) {
		if(cbHfin1.isEnabled()){
			String hi2 = cbHinicio2.getSelectedItem().toString();
			cbHfin1.setSelectedItem(hi2);
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.cargarVentaTemporal();
			String fllegadaoriginal = "";					
			try {
				rs.next();
				if(rs.getString("fllegada") != null){
					fllegadaoriginal = rs.getString("fllegada");
					String[] arrayfecha2 = fllegadaoriginal.split(" ");
					String horamin2 = arrayfecha2[1];
					String[] arrayhora2 = horamin2.split(":");
					String hora2 = arrayhora2[0];
					String minuto2 = arrayhora2[1];
					cbHfin2.setSelectedItem(hora2);
					cbMfin2.setSelectedItem(minuto2);
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
		}
	}
	protected void actionPerformedCbMinicio2(ActionEvent e) {
		if(cbMfin1.isEnabled()){
			String mi2 = cbMinicio2.getSelectedItem().toString();
			cbMfin1.setSelectedItem(mi2);
		}
	}
	protected void actionPerformedCbHfin1(ActionEvent e) {
		String hf1 = cbHfin1.getSelectedItem().toString();
		cbHinicio2.setSelectedItem(hf1);
	}
	protected void actionPerformedCbMfin1(ActionEvent e) {
		String mf1 = cbMfin1.getSelectedItem().toString();
		cbMinicio2.setSelectedItem(mf1);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtEscalasParadas) {
			keyTypedTxtEscalasParadas(e);
		}
		if (e.getSource() == txtPencuentro) {
			keyTypedTxtPencuentro(e);
		}
		if (e.getSource() == txtHasta) {
			keyTypedTxtHasta(e);
		}
		if (e.getSource() == txtDesde) {
			keyTypedTxtDesde(e);
		}
	}
	protected void keyTypedTxtDesde(KeyEvent e) {
		if (txtDesde.getText().length() == 50){
			e.consume();
		}
	}
	protected void keyTypedTxtHasta(KeyEvent e) {
		if (txtHasta.getText().length() == 50){
			e.consume();
		}
	}
	protected void keyTypedTxtPencuentro(KeyEvent e) {
		if (txtPencuentro.getText().length() == 60){
			e.consume();
		}
	}
	protected void keyTypedTxtEscalasParadas(KeyEvent e) {
		if (txtEscalasParadas.getText().length() == 100){
			e.consume();
		}
	}
}



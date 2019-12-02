package gui;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import clases.AbstractJasperReports;
import clases.Empresa;
import clases.Sedes;
import mysql.MySQLConexion;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class viReporte_Viajes extends JInternalFrame implements ActionListener {
	
	vPrincipal vp = null;
	private JTextField txtEmisionDeBoletas;
	private JPanel panel1;
	private JTextField txtNviajeDetalles;
	private JDateChooser dchFechaInicio;
	private JLabel lblFecha;
	private JButton btnVerViajesRealizados;
	private JTextField txtViajesRealizados;
	private JDateChooser dchFechaFin;
	private JPanel panel;
	private JButton btnVerDetalleViaje;
	private JTextField txtDetalleDeViaje;
	private JPanel panel_1;
	private JButton btnVerPasajeros;
	private JTextField txtPasajerosDeViaje;
	private JTextField txtPasajerosViaje;
	private JLabel label;
	private JPanel panel_2;
	private JButton btnDNI;
	private JTextField txtVerViajesDe;
	private JTextField txtDniPasajero;
	private JLabel lblDni;
	private JTextField txtRucPasajero;
	private JLabel lblRuc;
	private JButton btnRUC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viReporte_Viajes frame = new viReporte_Viajes(null);
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
	public viReporte_Viajes(vPrincipal temp) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		vp = temp;
		
		setBounds(100, 100, 1361, 660);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        
		txtEmisionDeBoletas = new JTextField();
		txtEmisionDeBoletas.setText("REPORTES DE VIAJES");
		txtEmisionDeBoletas.setRequestFocusEnabled(false);
		txtEmisionDeBoletas.setIgnoreRepaint(true);
		txtEmisionDeBoletas.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmisionDeBoletas.setForeground(Color.WHITE);
		txtEmisionDeBoletas.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		txtEmisionDeBoletas.setFocusable(false);
		txtEmisionDeBoletas.setFocusTraversalKeysEnabled(false);
		txtEmisionDeBoletas.setEditable(false);
		txtEmisionDeBoletas.setColumns(10);
		txtEmisionDeBoletas.setBackground(Color.DARK_GRAY);
		txtEmisionDeBoletas.setBounds(0, 0, ancho, 75);
		getContentPane().add(txtEmisionDeBoletas);
		
		panel1 = new JPanel();
		panel1.setBackground(SystemColor.control);
		panel1.setBounds(33, 86, 626, 185);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		dchFechaInicio = new JDateChooser();
		dchFechaInicio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "FECHA INICIO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		dchFechaInicio.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dchFechaInicio.setBounds(43, 55, 250, 60);
		panel1.add(dchFechaInicio);
		
		btnVerViajesRealizados = new JButton("Ver");
		btnVerViajesRealizados.addActionListener(this);
		btnVerViajesRealizados.setForeground(Color.WHITE);
		btnVerViajesRealizados.setFont(new Font("Dialog", Font.BOLD, 25));
		btnVerViajesRealizados.setBackground(new Color(0, 139, 139));
		btnVerViajesRealizados.setBounds(147, 126, 338, 43);
		panel1.add(btnVerViajesRealizados);
		
		txtViajesRealizados = new JTextField();
		txtViajesRealizados.setEditable(false);
		txtViajesRealizados.setText("VER VIAJES REALIZADOS");
		txtViajesRealizados.setHorizontalAlignment(SwingConstants.CENTER);
		txtViajesRealizados.setForeground(Color.WHITE);
		txtViajesRealizados.setFont(new Font("Dialog", Font.BOLD, 30));
		txtViajesRealizados.setColumns(10);
		txtViajesRealizados.setBackground(Color.DARK_GRAY);
		txtViajesRealizados.setBounds(0, 0, 625, 44);
		panel1.add(txtViajesRealizados);
		
		dchFechaFin = new JDateChooser();
		dchFechaFin.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dchFechaFin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "FECHA FIN", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		dchFechaFin.setBounds(335, 55, 250, 60);
		panel1.add(dchFechaFin);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.menu);
		panel.setBounds(684, 86, 626, 185);
		getContentPane().add(panel);
		
		btnVerDetalleViaje = new JButton("Ver");
		this.btnVerDetalleViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnVerDetalleViaje(arg0);
			}
		});
		btnVerDetalleViaje.setForeground(Color.WHITE);
		btnVerDetalleViaje.setFont(new Font("Dialog", Font.BOLD, 25));
		btnVerDetalleViaje.setBackground(new Color(0, 139, 139));
		btnVerDetalleViaje.setBounds(147, 126, 338, 43);
		panel.add(btnVerDetalleViaje);
		
		txtDetalleDeViaje = new JTextField();
		txtDetalleDeViaje.setEditable(false);
		txtDetalleDeViaje.setText("VER DETALLE DE VIAJE");
		txtDetalleDeViaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtDetalleDeViaje.setForeground(Color.WHITE);
		txtDetalleDeViaje.setFont(new Font("Dialog", Font.BOLD, 30));
		txtDetalleDeViaje.setColumns(10);
		txtDetalleDeViaje.setBackground(Color.DARK_GRAY);
		txtDetalleDeViaje.setBounds(0, 0, 625, 44);
		panel.add(txtDetalleDeViaje);
		
		txtNviajeDetalles = new JTextField();
		txtNviajeDetalles.setBounds(216, 68, 365, 40);
		panel.add(txtNviajeDetalles);
		txtNviajeDetalles.setHorizontalAlignment(SwingConstants.LEFT);
		txtNviajeDetalles.setForeground(Color.DARK_GRAY);
		txtNviajeDetalles.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtNviajeDetalles.setColumns(10);
		
		lblFecha = new JLabel("N\u00B0 Viaje:");
		lblFecha.setBounds(46, 68, 169, 40);
		panel.add(lblFecha);
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setForeground(Color.DARK_GRAY);
		lblFecha.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(33, 287, 626, 185);
		getContentPane().add(panel_1);
		
		btnVerPasajeros = new JButton("Ver");
		btnVerPasajeros.addActionListener(this);
		btnVerPasajeros.setForeground(Color.WHITE);
		btnVerPasajeros.setFont(new Font("Dialog", Font.BOLD, 25));
		btnVerPasajeros.setBackground(new Color(0, 139, 139));
		btnVerPasajeros.setBounds(147, 126, 338, 43);
		panel_1.add(btnVerPasajeros);
		
		txtPasajerosDeViaje = new JTextField();
		txtPasajerosDeViaje.setEditable(false);
		txtPasajerosDeViaje.setText("VER PASAJEROS DE VIAJE");
		txtPasajerosDeViaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasajerosDeViaje.setForeground(Color.WHITE);
		txtPasajerosDeViaje.setFont(new Font("Dialog", Font.BOLD, 30));
		txtPasajerosDeViaje.setColumns(10);
		txtPasajerosDeViaje.setBackground(Color.DARK_GRAY);
		txtPasajerosDeViaje.setBounds(0, 0, 625, 44);
		panel_1.add(txtPasajerosDeViaje);
		
		txtPasajerosViaje = new JTextField();
		txtPasajerosViaje.setHorizontalAlignment(SwingConstants.LEFT);
		txtPasajerosViaje.setForeground(Color.DARK_GRAY);
		txtPasajerosViaje.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtPasajerosViaje.setColumns(10);
		txtPasajerosViaje.setBounds(216, 68, 365, 40);
		panel_1.add(txtPasajerosViaje);
		
		label = new JLabel("N\u00B0 Viaje:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Dialog", Font.PLAIN, 30));
		label.setBounds(46, 68, 169, 40);
		panel_1.add(label);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(684, 287, 626, 185);
		getContentPane().add(panel_2);
		
		btnDNI = new JButton("Ver");
		this.btnDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnDNI(arg0);
			}
		});
		btnDNI.setForeground(Color.WHITE);
		btnDNI.setFont(new Font("Dialog", Font.BOLD, 25));
		btnDNI.setBackground(new Color(0, 139, 139));
		btnDNI.setBounds(414, 66, 166, 43);
		panel_2.add(btnDNI);
		
		txtVerViajesDe = new JTextField();
		txtVerViajesDe.setEditable(false);
		txtVerViajesDe.setText("VER VIAJES DE PASAJERO");
		txtVerViajesDe.setHorizontalAlignment(SwingConstants.CENTER);
		txtVerViajesDe.setForeground(Color.WHITE);
		txtVerViajesDe.setFont(new Font("Dialog", Font.BOLD, 30));
		txtVerViajesDe.setColumns(10);
		txtVerViajesDe.setBackground(Color.DARK_GRAY);
		txtVerViajesDe.setBounds(0, 0, 625, 44);
		panel_2.add(txtVerViajesDe);
		
		txtDniPasajero = new JTextField();
		txtDniPasajero.setHorizontalAlignment(SwingConstants.LEFT);
		txtDniPasajero.setForeground(Color.DARK_GRAY);
		txtDniPasajero.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtDniPasajero.setColumns(10);
		txtDniPasajero.setBounds(155, 68, 249, 40);
		panel_2.add(txtDniPasajero);
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setForeground(Color.DARK_GRAY);
		lblDni.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblDni.setBounds(46, 68, 104, 40);
		panel_2.add(lblDni);
		
		txtRucPasajero = new JTextField();
		txtRucPasajero.setHorizontalAlignment(SwingConstants.LEFT);
		txtRucPasajero.setForeground(Color.DARK_GRAY);
		txtRucPasajero.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtRucPasajero.setColumns(10);
		txtRucPasajero.setBounds(155, 122, 249, 40);
		panel_2.add(txtRucPasajero);
		
		lblRuc = new JLabel("RUC:");
		lblRuc.setHorizontalAlignment(SwingConstants.LEFT);
		lblRuc.setForeground(Color.DARK_GRAY);
		lblRuc.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblRuc.setBounds(46, 122, 104, 40);
		panel_2.add(lblRuc);
		
		btnRUC = new JButton("Ver");
		this.btnRUC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRUC(e);
			}
		});
		btnRUC.setForeground(Color.WHITE);
		btnRUC.setFont(new Font("Dialog", Font.BOLD, 25));
		btnRUC.setBackground(new Color(0, 139, 139));
		btnRUC.setBounds(414, 120, 166, 43);
		panel_2.add(btnRUC);
		
		cargar();

	}
	
	public void cargar(){
		//LLENAR COMBOS
			Empresa empresa1 = new Empresa();
			
			Empresa todEmpresas = new Empresa(-1, "0", "TODOS");
			Empresa empresa2 = new Empresa();
			
			Sedes sinOrigen = new Sedes(-1, "Sin seleccionar");
			Sedes origen1 = new Sedes();
			
			Sedes sinDestino = new Sedes(-2, "Sin seleccionar");
			Sedes destino1 = new Sedes();
			
			// CARGAR FECHA ACTUAL EN CALENDARS
			java.util.Date date = new Date();
			date.getTime();
			dchFechaInicio.setDate(date);
			dchFechaFin.setDate(date);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVerPasajeros) {
			actionPerformedBtnVerPasajeros(arg0);
		}
		if (arg0.getSource() == btnVerViajesRealizados) {
			actionPerformedBtnVerViajesRealizados(arg0);
		}
	}
	
	protected void actionPerformedBtnVerViajesRealizados(ActionEvent arg0) {
		Connection con = null;
		try {
			con = MySQLConexion.getConection();
			
			int añoi = dchFechaInicio.getCalendar().get(Calendar.YEAR);
			int mesi = dchFechaInicio.getCalendar().get(Calendar.MARCH) + 1;
			int diai = dchFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
			String fechai = añoi + "-" + mesi + "-" + diai + " 00:00:00";

			int añof = dchFechaFin.getCalendar().get(Calendar.YEAR);
			int mesf = dchFechaFin.getCalendar().get(Calendar.MARCH) + 1;
			int diaf = dchFechaFin.getCalendar().get(Calendar.DAY_OF_MONTH);
			String fechaf = añof + "-" + mesf + "-" + diaf + " 23:59:59";
			
			DateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = (Date) formatter.parse(fechai);
			java.sql.Timestamp timeStampDateI = new Timestamp(date.getTime());
			DateFormat formatter2;
			formatter2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date2 = (Date) formatter2.parse(fechaf);
			java.sql.Timestamp timeStampDateF = new Timestamp(date2.getTime());
			
			Map parameters = new HashMap();
			parameters.put("prtFechaI", timeStampDateI);
			parameters.put("prtFechaF", timeStampDateF);
			new AbstractJasperReports().createReport(con, "rrViajesRealizados.jasper", parameters);
			AbstractJasperReports.showViewer();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se encontraron datos registrados en estas fechas" + ex);
		}
	}
	
	protected void actionPerformedBtnVerPasajeros(ActionEvent arg0) {
		Connection con = null;
		try {
			con = MySQLConexion.getConection();
			int nviaje = Integer.parseInt(txtPasajerosViaje.getText());
			Map parameters = new HashMap();
			parameters.put("nviaje", nviaje);
			new AbstractJasperReports().createReport(con, "rrViajeDetalle.jasper", parameters);
			AbstractJasperReports.showViewer();
			txtPasajerosViaje.setText(null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se encontró el viaje. " + ex);
		}
	}
	
	protected void actionPerformedBtnVerDetalleViaje(ActionEvent arg0) {
		Connection con = null;
		try {
			con = MySQLConexion.getConection();
			int nviaje = Integer.parseInt(txtNviajeDetalles.getText());
			Map parameters = new HashMap();
			parameters.put("nviaje", nviaje);
			new AbstractJasperReports().createReport(con, "rrViajesDetallesOtro.jasper", parameters);
			AbstractJasperReports.showViewer();
			txtNviajeDetalles.setText(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontró el viaje. " + e);
		}
	}
	
	protected void actionPerformedBtnDNI(ActionEvent arg0) {
		Connection con = null;
		try {
			con = MySQLConexion.getConection();
			int dnipasajero = Integer.parseInt(txtDniPasajero.getText());
			Map parameters = new HashMap();
			parameters.put("dnipasajero", dnipasajero);
			new AbstractJasperReports().createReport(con, "rrPasajeroDNI.jasper", parameters);
			AbstractJasperReports.showViewer();
			txtDniPasajero.setText(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontró el viaje. " + e);
		}
	}
	
	protected void actionPerformedBtnRUC(ActionEvent e) {
		Connection con = null;
		try {
			con = MySQLConexion.getConection();
			String ruc = txtRucPasajero.getText();
			Map parameters = new HashMap();
			parameters.put("ruc", ruc);
			new AbstractJasperReports().createReport(con, "rrPasajeroRUC.jasper", parameters);
			AbstractJasperReports.showViewer();
			txtRucPasajero.setText(null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se encontró el viaje. " + ex);
		}
	}
}

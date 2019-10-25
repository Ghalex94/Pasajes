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
import java.awt.SystemColor;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import clases.Empresa;
import clases.Sedes;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class viReporte_Contabilidad extends JInternalFrame {
	
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
	private JTextField txtNviajePasajero;
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
					viReporte_Contabilidad frame = new viReporte_Contabilidad(null);
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
	public viReporte_Contabilidad(vPrincipal temp) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		vp = temp;
		
		setBounds(100, 100, 1361, 660);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        
		txtEmisionDeBoletas = new JTextField();
		txtEmisionDeBoletas.setText("REPORTES DE CONTABILIDAD");
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
		btnVerViajesRealizados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegstrar1(e);
			}
		});
		btnVerViajesRealizados.setForeground(Color.WHITE);
		btnVerViajesRealizados.setFont(new Font("Dialog", Font.BOLD, 25));
		btnVerViajesRealizados.setBackground(new Color(0, 139, 139));
		btnVerViajesRealizados.setBounds(147, 126, 338, 43);
		panel1.add(btnVerViajesRealizados);
		
		txtViajesRealizados = new JTextField();
		txtViajesRealizados.setText("REPORTE 1");
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
		btnVerDetalleViaje.setForeground(Color.WHITE);
		btnVerDetalleViaje.setFont(new Font("Dialog", Font.BOLD, 25));
		btnVerDetalleViaje.setBackground(new Color(0, 139, 139));
		btnVerDetalleViaje.setBounds(147, 126, 338, 43);
		panel.add(btnVerDetalleViaje);
		
		txtDetalleDeViaje = new JTextField();
		txtDetalleDeViaje.setText("REPORTE 2");
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
		btnVerPasajeros.setForeground(Color.WHITE);
		btnVerPasajeros.setFont(new Font("Dialog", Font.BOLD, 25));
		btnVerPasajeros.setBackground(new Color(0, 139, 139));
		btnVerPasajeros.setBounds(147, 126, 338, 43);
		panel_1.add(btnVerPasajeros);
		
		txtPasajerosDeViaje = new JTextField();
		txtPasajerosDeViaje.setText("REPORTE 3");
		txtPasajerosDeViaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasajerosDeViaje.setForeground(Color.WHITE);
		txtPasajerosDeViaje.setFont(new Font("Dialog", Font.BOLD, 30));
		txtPasajerosDeViaje.setColumns(10);
		txtPasajerosDeViaje.setBackground(Color.DARK_GRAY);
		txtPasajerosDeViaje.setBounds(0, 0, 625, 44);
		panel_1.add(txtPasajerosDeViaje);
		
		txtNviajePasajero = new JTextField();
		txtNviajePasajero.setHorizontalAlignment(SwingConstants.LEFT);
		txtNviajePasajero.setForeground(Color.DARK_GRAY);
		txtNviajePasajero.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtNviajePasajero.setColumns(10);
		txtNviajePasajero.setBounds(216, 68, 365, 40);
		panel_1.add(txtNviajePasajero);
		
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
		btnDNI.setForeground(Color.WHITE);
		btnDNI.setFont(new Font("Dialog", Font.BOLD, 25));
		btnDNI.setBackground(new Color(0, 139, 139));
		btnDNI.setBounds(414, 66, 166, 43);
		panel_2.add(btnDNI);
		
		txtVerViajesDe = new JTextField();
		txtVerViajesDe.setText("REPORTE 4");
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
	}
	     void actionPerformedBtnRegstrar1(ActionEvent e) {
	}
}

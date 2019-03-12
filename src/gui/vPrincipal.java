package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import mysql.Consultas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.awt.print.PrinterJob;
import java.awt.event.WindowEvent;
import java.awt.Color;


public class vPrincipal extends JFrame implements ActionListener, WindowListener {
	
	public JDesktopPane desktopPane;
	private JPanel contentPane;
	public JMenuBar menuBar;
	public JMenu mnArchivo;
	public JMenu mnSalidas;
	public JMenu mnClientes;
	public JMenu mnReportes;
	public JMenuItem mntmCrearNuevaSalida;
	public JMenuItem mntmSalir;
	public JMenu mnVehiculosConductores;
	public JMenuItem mntmCerrarSesin;
	public JMenuItem mntmListaDeVehiculos;
	public JMenuItem mntmListaDeDestinos;
    public JMenuItem mntmGastos;
    public JMenuItem mntmContinuarPreparacion;
    public JMenuItem mntmCancelarSalida;
    
	viLogin lg = new viLogin(this);  	//Login
	viDatos1 d1 = null;  				//Datos1
	viSeleccionAsientos1 sa1 = null;	//Seleccion de asientos 1
	viSeleccionAsientos2 sa2 = null;	//Seleccion de asientos 2
	viSeleccionAsientos3 sa3 = null;	//Seleccion de asientos 3
	viSeleccionAsientos4 sa4 = null;	//Seleccion de asientos 4
	viListaVehiculos lvc = null;		//Lista de vehiculos
	viListaDestinos ldest = null;		//Lista destinos 
	viListaPasajeros lpjr = null;		//Lista de pasajeros
	viFormatos format = null;
	
	ResultSet rs;
	//RESOLUCION MONITOR
	//Dimension desktopSize = desktopPane.getSize();
    Dimension FrameSize = lg.getSize();
    // Toolkit t = Toolkit.getDefaultToolkit();
    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    private JMenuItem mntmListaDeClientes;
    
    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPrincipal frame = new vPrincipal();
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
	public vPrincipal() {
		setBackground(Color.GRAY);
		
		addWindowListener(this);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 563);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(30, 144, 255));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("ARCHIVO");
		mnArchivo.setEnabled(false);
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		
		mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.addActionListener(this);
		mnArchivo.add(mntmCerrarSesin);
		mnArchivo.add(mntmSalir);
		
		mnSalidas = new JMenu("SALIDAS DE VEHICULOS");
		mnSalidas.setEnabled(false);
		menuBar.add(mnSalidas);
		
		mntmCrearNuevaSalida = new JMenuItem("Crear nueva salida bus");
		mntmCrearNuevaSalida.addActionListener(this);
		mnSalidas.add(mntmCrearNuevaSalida);
		
		mntmContinuarPreparacion = new JMenuItem("Continuar con la preparaci\u00F3n");
		mntmContinuarPreparacion.addActionListener(this);
		mntmContinuarPreparacion.setEnabled(false);
		mnSalidas.add(mntmContinuarPreparacion);
		
		mntmCancelarSalida = new JMenuItem("Cancelar salida");
		mntmCancelarSalida.addActionListener(this);
		mntmCancelarSalida.setEnabled(false);
		mnSalidas.add(mntmCancelarSalida);
		
		mnVehiculosConductores = new JMenu("VEHICULOS Y CONDUCTORES");
		mnVehiculosConductores.setEnabled(false);
		menuBar.add(mnVehiculosConductores);
		
		mntmListaDeVehiculos = new JMenuItem("Lista de Vehiculos");
		mntmListaDeVehiculos.addActionListener(this);
		mnVehiculosConductores.add(mntmListaDeVehiculos);
		
		mntmListaDeDestinos = new JMenuItem("Lista de Destinos");
		mntmListaDeDestinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedMntmListaDeDestinos(arg0);
			}
		});
		mnVehiculosConductores.add(mntmListaDeDestinos);
		
		mntmGastos = new JMenuItem("Ingresar gastos generados con vehiculos");
		mnVehiculosConductores.add(mntmGastos);
		
		mnClientes = new JMenu("CLIENTES");
		mnClientes.setEnabled(false);
		menuBar.add(mnClientes);
		
		mntmListaDeClientes = new JMenuItem("Lista de Clientes");
		mntmListaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmListaDeClientes(e);
			}
		});
		mnClientes.add(mntmListaDeClientes);
		
		mnReportes = new JMenu("REPORTES");
		mnReportes.setEnabled(false);
		menuBar.add(mnReportes);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		desktopPane.add(lg);//LOGIN		
		cargar();
	}
	
	public void cargar(){
		Consultas consulta = new Consultas();
		rs = consulta.cargarVentaTemporal();
		int estado;
		try {
			rs.next();
			estado = rs.getInt("estado");
			if(estado == 0){
				mntmCrearNuevaSalida.setEnabled(true);
				mntmContinuarPreparacion.setEnabled(false);
				mntmCancelarSalida.setEnabled(false);
			}
			else{
				mntmCrearNuevaSalida.setEnabled(false);
				mntmContinuarPreparacion.setEnabled(true);
				mntmCancelarSalida.setEnabled(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        lg.setLocation((ancho - FrameSize.width)/2, (alto - FrameSize.height)/4);
		lg.show();
	}
	
	public void integrar(){
		desktopPane.add(d1);//DETALLES 1 (DESELECCION DE CARRO)
		desktopPane.add(sa1);//SELECCION DE ASIENTOS 1
		desktopPane.add(sa2);//SELECCION DE ASIENTOS 2 
		desktopPane.add(sa3);//SELECCION DE ASIENTOS 3 
		desktopPane.add(sa4);//SELECCION DE ASIENTOS 4 
		desktopPane.add(lvc);//LISTA DE VEHICULOS
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmCancelarSalida) {
			actionPerformedMntmCancelarSalida(arg0);
		}
		if (arg0.getSource() == mntmContinuarPreparacion) {
			actionPerformedMntmContinuarPreparacion(arg0);
		}
		if (arg0.getSource() == mntmListaDeVehiculos) {
			actionPerformedMntmListaDeVehiculos(arg0);
		}
		if (arg0.getSource() == mntmCerrarSesin) {
			actionPerformedMntmCerrarSesin(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmCrearNuevaSalida) {
			actionPerformedMntmCrearNuevaSalida(arg0);
		}
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
		if (e.getSource() == this) {
			windowClosingThis(e);
		}
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
	}
	protected void windowClosingThis(WindowEvent e) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Cerrar Sistema?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0)
			System.exit(0);
		else
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Cerrar Sistema?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0)
			System.exit(0);
	}
	
	public void cerrarVentanas(){
		d1 = null;
		sa1 = null;
		sa2 = null;
		sa3 = null;
		sa4 = null;
		lvc = null;
		ldest = null;
		lpjr = null;
	}
	
	public void esconderVentanas(){
		if (d1!=null)
			d1.setVisible(false);
		if (sa1!=null)
			sa1.setVisible(false);
		if (sa2!=null)
			sa2.setVisible(false);
		if (sa3!=null)
			sa3.setVisible(false);
		if (sa4!=null)
			sa4.setVisible(false);
		if (lvc!=null)
			lvc.setVisible(false);
		if (ldest!=null)
			ldest.setVisible(false);
		if (lpjr!=null)
			lpjr.setVisible(false);
	}
	
	public void desactivarMenu(){
		mnArchivo.setEnabled(false);
		mnClientes.setEnabled(false);
		mnVehiculosConductores.setEnabled(false);
		mnReportes.setEnabled(false);
		mnSalidas.setEnabled(false);
	}
	
	public void activarMenu(int tipo){
		if(tipo == 0){
			mnArchivo.setEnabled(true);
			mnClientes.setEnabled(true);
			mnVehiculosConductores.setEnabled(true);
			mnReportes.setEnabled(true);
			mnSalidas.setEnabled(true);
		}
		else{
			mnArchivo.setEnabled(true);
			mnClientes.setEnabled(true);
			mnVehiculosConductores.setEnabled(true);
			mnSalidas.setEnabled(true);
		}	
	}
	
	protected void actionPerformedMntmCerrarSesin(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Cerrar Sesión?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			desactivarMenu();
			cerrarVentanas();
			lg.show();
			lg.cursor();
		}
	}
	
	protected void actionPerformedMntmCrearNuevaSalida(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		d1 = new viDatos1(this);
		desktopPane.add(d1);
		d1.setLocation((ancho - FrameSize.width)/2, (alto - FrameSize.height)/4);
		d1.show();
	}
	
	protected void actionPerformedMntmContinuarPreparacion(ActionEvent arg0) {
		Consultas consulta = new Consultas();
		rs = consulta.cargarVentaTemporal();
		int modelovh = 0;
		esconderVentanas();
		cerrarVentanas();
		try {
			rs.next();
			modelovh = rs.getInt("modelovh");
		} catch (SQLException e1) {	e1.printStackTrace(); }
		switch(modelovh){
		case 1:
			sa1 = new viSeleccionAsientos1(this);
			desktopPane.add(sa1);
			sa1.show();
			try{
				sa1.setMaximum(true);
			}catch(Exception f){}
			break;
		case 2:
			sa2 = new viSeleccionAsientos2(this);
			desktopPane.add(sa2);
			sa2.show();
			try{
				sa2.setMaximum(true);
			}catch(Exception f){}
			break;
		case 3:
			sa3 = new viSeleccionAsientos3(this);
			desktopPane.add(sa3);
			sa3.show();
			try{
				sa3.setMaximum(true);
			}catch(Exception f){}
			break;
		case 4:
			sa4 = new viSeleccionAsientos4(this);
			desktopPane.add(sa4);
			sa4.show();
			try{
				sa4.setMaximum(true);
			}catch(Exception f){}
			break;
		}
		
		//Null a ventanas que pueden estar abiertas 
		lvc = null;
		
	}
	
	protected void actionPerformedMntmCancelarSalida(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Cancelar salida?\nSi lo hace toda la preparación se eliminará permanentemente", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			Consultas consulta = new Consultas();
			consulta.eliminarSalidaVehiculo();
			esconderVentanas();
			cerrarVentanas();
			mntmCrearNuevaSalida.setEnabled(true);
			mntmContinuarPreparacion.setEnabled(false);
			mntmCancelarSalida.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Salida cancelada");
		}
	}
	
	protected void actionPerformedMntmListaDeVehiculos(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		lvc = new viListaVehiculos(this);
		desktopPane.add(lvc);
		lvc.show();
		try{
			lvc.setMaximum(true);
		}catch(Exception f){}
	}
	protected void actionPerformedMntmListaDeDestinos(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		ldest = new viListaDestinos(this);
		desktopPane.add(ldest);
		ldest.show();
		try{
			ldest.setMaximum(true);
		}catch(Exception f){}
	}
	protected void actionPerformedMntmListaDeClientes(ActionEvent e) {
		esconderVentanas();
		cerrarVentanas();
		lpjr = new viListaPasajeros(this);
		desktopPane.add(lpjr);
		lpjr.show();
		try{
			lpjr.setMaximum(true);
		}catch(Exception f){}
	}
	
		
	
}





















package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import clases.AbstractJasperReports;
import mysql.Consultas;
import mysql.MySQLConexion;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.awt.print.PrinterJob;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Font;


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
    public JMenuItem mntmContinuarPreparacion;
    public JMenuItem mntmCancelarSalida;
    
	viLogin lg = new viLogin(this);  	 //Login
	viDatos1 d1 = null;  				 //Datos1
	viSeleccionAsientos1 sa1 = null;	 //Seleccion de asientos 1
	viSeleccionAsientos2 sa2 = null;	 //Seleccion de asientos 2
	viSeleccionAsientos3 sa3 = null;	 //Seleccion de asientos 3
	viSeleccionAsientos4 sa4 = null;	 //Seleccion de asientos 4
	viListaVehiculos lvc = null;		 //Lista de vehiculos
	viListaDestinos ldest = null;		 //Lista destinos 
	viListaPasajeros lpjr = null;		 //Lista de pasajeros
	viLlenarDatosFaltantes datfalt = null;//Datosa Faltantes 
	
	ResultSet rs;
	//RESOLUCION MONITOR
	//Dimension desktopSize = desktopPane.getSize();
    Dimension FrameSize = lg.getSize();
    // Toolkit t = Toolkit.getDefaultToolkit();
    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    private JMenuItem mntmListaDeClientes;
    public JMenu mnFormatos;
    private JMenuItem mntmMDP;
    private JMenuItem mntmHdR;
    private JMenuItem mntmIdV;
    private JMenuItem mntmContrato;
    private JMenuItem mntmLlenarInformacion;
    private JMenuItem mntmAdministrarUsuarios;
    private JMenuItem mntmOpcionesAvanzadas;
    private JMenuItem mntmListaSocios;
    private JMenu mnSedes;
    
    
	
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
		setBackground(Color.WHITE);
		
		addWindowListener(this);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 563);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.setMargin(new Insets(5, 5, 5, 5));
		menuBar.setBackground(new Color(0, 139, 139));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("|Archivo|");
		mnArchivo.setForeground(Color.WHITE);
		mnArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnArchivo.setEnabled(false);
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmSalir.addActionListener(this);
		
		mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCerrarSesin.addActionListener(this);
		
		mntmAdministrarUsuarios = new JMenuItem("Administrar Usuarios");
		mntmAdministrarUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnArchivo.add(mntmAdministrarUsuarios);
		
		mntmOpcionesAvanzadas = new JMenuItem("Opciones Avanzadas");
		mntmOpcionesAvanzadas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnArchivo.add(mntmOpcionesAvanzadas);
		mnArchivo.add(mntmCerrarSesin);
		mnArchivo.add(mntmSalir);
		
		mnSalidas = new JMenu("|Salida de Minivan|");
		mnSalidas.setForeground(Color.WHITE);
		mnSalidas.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnSalidas.setEnabled(false);
		menuBar.add(mnSalidas);
		
		mntmCrearNuevaSalida = new JMenuItem("Preparar salida de Minivan");
		mntmCrearNuevaSalida.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCrearNuevaSalida.addActionListener(this);
		mnSalidas.add(mntmCrearNuevaSalida);
		
		mntmContinuarPreparacion = new JMenuItem("Continuar con la preparaci\u00F3n");
		mntmContinuarPreparacion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmContinuarPreparacion.addActionListener(this);
		mntmContinuarPreparacion.setEnabled(false);
		mnSalidas.add(mntmContinuarPreparacion);
		
		mntmCancelarSalida = new JMenuItem("Cancelar salida");
		mntmCancelarSalida.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCancelarSalida.addActionListener(this);
		mntmCancelarSalida.setEnabled(false);
		mnSalidas.add(mntmCancelarSalida);
		
		mnFormatos = new JMenu("|Formatos|");
		mnFormatos.setForeground(Color.WHITE);
		mnFormatos.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnFormatos.setEnabled(false);
		menuBar.add(mnFormatos);
		
		mntmLlenarInformacion = new JMenuItem("COMPLETAR INFORMACI\u00D3N");
		mntmLlenarInformacion.setForeground(new Color(0, 139, 139));
		mntmLlenarInformacion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmLlenarInformacion.addActionListener(this);
		mnFormatos.add(mntmLlenarInformacion);
		
		mntmMDP = new JMenuItem("Ver Manifiesto de pasajeros");
		mntmMDP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmMDP.addActionListener(this);
		mnFormatos.add(mntmMDP);
		
		mntmHdR = new JMenuItem("Ver Hoja de Ruta");
		mntmHdR.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmHdR.addActionListener(this);
		mnFormatos.add(mntmHdR);
		
		mntmIdV = new JMenuItem("Ver Itinerario de Viaje");
		mntmIdV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmIdV.addActionListener(this);
		mnFormatos.add(mntmIdV);
		
		mntmContrato = new JMenuItem("Ver Contrato");
		mntmContrato.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnFormatos.add(mntmContrato);
		
		mnVehiculosConductores = new JMenu("|Socio - conductores - vehiculos|");
		mnVehiculosConductores.setForeground(Color.WHITE);
		mnVehiculosConductores.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnVehiculosConductores.setEnabled(false);
		menuBar.add(mnVehiculosConductores);
		
		mntmListaDeVehiculos = new JMenuItem("Lista de Vehiculos y Conductores");
		mntmListaDeVehiculos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmListaDeVehiculos.addActionListener(this);
		
		mntmListaSocios = new JMenuItem("Lista de Socios");
		mntmListaSocios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnVehiculosConductores.add(mntmListaSocios);
		mnVehiculosConductores.add(mntmListaDeVehiculos);
		
		mnSedes = new JMenu("|Sedes|");
		mnSedes.setForeground(Color.WHITE);
		mnSedes.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		menuBar.add(mnSedes);
		
		mntmListaDeDestinos = new JMenuItem("Lista de Sedes");
		mnSedes.add(mntmListaDeDestinos);
		mntmListaDeDestinos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmListaDeDestinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedMntmListaDeDestinos(arg0);
			}
		});
		
		mnClientes = new JMenu("|Clientes|");
		mnClientes.setForeground(Color.WHITE);
		mnClientes.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnClientes.setEnabled(false);
		menuBar.add(mnClientes);
		
		mntmListaDeClientes = new JMenuItem("Lista de Clientes");
		mntmListaDeClientes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmListaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmListaDeClientes(e);
			}
		});
		mnClientes.add(mntmListaDeClientes);
		
		mnReportes = new JMenu("|Reportes|");
		mnReportes.setForeground(Color.WHITE);
		mnReportes.setBackground(Color.DARK_GRAY);
		mnReportes.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnReportes.setEnabled(false);
		menuBar.add(mnReportes);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
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
				mnFormatos.setEnabled(false);
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

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmIdV) {
			actionPerformedMntmIdV(arg0);
		}
		if (arg0.getSource() == mntmHdR) {
			actionPerformedMntmHdR(arg0);
		}
		if (arg0.getSource() == mntmMDP) {
			actionPerformedMntmMDP(arg0);
		}
		if (arg0.getSource() == mntmLlenarInformacion) {
			actionPerformedMntmLlenarInformacion(arg0);
		}
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
		datfalt = null;
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
		if (datfalt!=null)
			datfalt.setVisible(false);
	}
	
	public void desactivarMenu(){
		mnArchivo.setEnabled(false);
		mnClientes.setEnabled(false);
		mnVehiculosConductores.setEnabled(false);
		mnReportes.setEnabled(false);
		mnSalidas.setEnabled(false);
		mnFormatos.setEnabled(false);
	}
	
	public void activarMenu(int tipo){
		if(tipo == 0){
			mnArchivo.setEnabled(true);
			mnClientes.setEnabled(true);
			mnVehiculosConductores.setEnabled(true);
			mnReportes.setEnabled(true);
			mnSalidas.setEnabled(true);
			mnFormatos.setEnabled(true);
		}
		else{
			mnArchivo.setEnabled(true);
			mnClientes.setEnabled(true);
			mnVehiculosConductores.setEnabled(true);
			mnSalidas.setEnabled(true);
		}
		
		Consultas consulta = new Consultas();
		rs = consulta.cargarVentaTemporal();
		int estado;
		try {
			rs.next();
			estado = rs.getInt("estado");
			if(estado != 0){
				mnFormatos.setEnabled(true);
			}
			else{
				mnFormatos.setEnabled(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void actionPerformedMntmCerrarSesin(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Cerrar Sesión?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			desactivarMenu();
			esconderVentanas();
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
		int idmodelovh = 0;
		String modelovh = null;
		esconderVentanas();
		cerrarVentanas();
		try {
			rs.next();
			idmodelovh = rs.getInt("modelovh");
		} catch (SQLException e1) {	e1.printStackTrace(); }
		
		rs = consulta.buscarModeloVehiculo(idmodelovh);
		try {
			rs.next();
			modelovh = rs.getString("modelo");
		} catch (SQLException e1) {	e1.printStackTrace(); }
		
		switch(idmodelovh){
		case 1:
			sa1 = new viSeleccionAsientos1(this);	// Mercedes Sprinter 413 19+1 Asientos
			desktopPane.add(sa1);
			sa1.show();
			sa1.txtTitulo.setText(modelovh);
			try{
				sa1.setMaximum(true);
			}catch(Exception f){}
			break;			
		case 2:
			sa1 = new viSeleccionAsientos1(this);	// Mercedes sprinter 515 19+1 
			desktopPane.add(sa1);
			sa1.show();
			sa1.txtTitulo.setText(modelovh);
			Image imBanner = new ImageIcon(this.getClass().getResource("/mv02.png")).getImage();
			sa1.lblBanner.setIcon(new ImageIcon(imBanner));
			try{
				sa1.setMaximum(true);
			}catch(Exception f){}
			break;
		case 3:
			sa2 = new viSeleccionAsientos2(this);     // Mercedes sprinter 515 20+1	
			desktopPane.add(sa2);
			sa2.show();
			sa2.txtTitulo.setText(modelovh);
			try{
				sa2.setMaximum(true);
			}catch(Exception f){}
			break;
		case 4:
			sa3 = new viSeleccionAsientos3(this);    // Renault 2012 15
			desktopPane.add(sa3);
			sa3.show();
			sa3.txtTitulo.setText(modelovh);
			try{
				sa3.setMaximum(true);
			}catch(Exception f){}
			break;
		case 5:
			sa4 = new viSeleccionAsientos4(this);     // Renault master moderna
			desktopPane.add(sa4);
			sa4.show();
			sa4.txtTitulo.setText(modelovh);
			try{
				sa4.setMaximum(true);
			}catch(Exception f){}
			break;
		case 6:
			sa2 = new viSeleccionAsientos2(this);     // Wolskwagen Crafter
			desktopPane.add(sa2);
			sa2.show();
			sa2.txtTitulo.setText(modelovh);
			Image imBanner2 = new ImageIcon(this.getClass().getResource("/mv06.png")).getImage();
			sa2.lblBanner.setIcon(new ImageIcon(imBanner2));
			try{
				sa2.setMaximum(true);
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
			mnFormatos.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Salida cancelada");
		}
	}
	
	protected void actionPerformedMntmListaDeVehiculos(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		lvc = new viListaVehiculos(this);
		desktopPane.add(lvc);
		
		try{
			lvc.setMaximum(true);
		}catch(Exception f){}
		lvc.show();
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
	protected void actionPerformedMntmLlenarInformacion(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		datfalt = new viLlenarDatosFaltantes(this);
		desktopPane.add(datfalt);
		datfalt.show();
		try{
			datfalt.setMaximum(true);
		}catch(Exception f){}	
	}
	
	protected void actionPerformedMntmMDP(ActionEvent arg0) {
		Consultas consulta = new Consultas();
		rs = consulta.cantPasajeros();
		int cantPasajeros = 0;
		try {
			rs.next();
			cantPasajeros = rs.getInt("cantPasajeros");
		} catch (SQLException e1) {	e1.printStackTrace(); }
		
		try {
			Map<String, Object> parameters = new HashMap();
			parameters.put("cantPasajeros", cantPasajeros);
			Connection con = MySQLConexion.getConection();
			new AbstractJasperReports().createReport( con, "rManifiestoPasajerosM.jasper", parameters);
			AbstractJasperReports.showViewer();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:. "+ e.getStackTrace());			
		}
	}
	
	protected void actionPerformedMntmHdR(ActionEvent arg0) {
		Consultas consulta = new Consultas();
		try {
			Connection con = MySQLConexion.getConection();
			new AbstractJasperReports().createReport( con, "rHojaRuta3.jasper");
			AbstractJasperReports.showViewer();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:. "+ e.getStackTrace());			
		}
	}
	
	protected void actionPerformedMntmIdV(ActionEvent arg0) {
		Consultas consulta = new Consultas();
		try {
			Connection con = MySQLConexion.getConection();
			new AbstractJasperReports().createReport( con, "rItinerarioViajeM.jasper");
			AbstractJasperReports.showViewer();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:. "+ e.getStackTrace());			
		}
	}
}





















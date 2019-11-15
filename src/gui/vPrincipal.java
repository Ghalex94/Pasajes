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
    
    viConfiguracionInicial ci = null; 	  //Configuracion inicial
	viLogin lg = new viLogin(this);		  //Login
	viListaUsuarios lusu = null;		  //Usuarios
	viDatos1 d1 = null;  				  //Datos1
	viSeleccionAsientos1 sa1 = null;	  //Seleccion de asientos 1
	viSeleccionAsientos2 sa2 = null;	  //Seleccion de asientos 2
	viSeleccionAsientos3 sa3 = null;	  //Seleccion de asientos 3
	viSeleccionAsientos4 sa4 = null;	  //Seleccion de asientos 4
	viListaVehiculos lvc = null;		  //Lista de vehiculos
	viListaConductores lcond = null;	  //Lista dde conductores
	viListaSedes ldest = null;		 	  //Lista destinos 
	viListaPasajeros lpjr = null;		  //Lista de pasajeros
	viLlenarDatosFaltantes datfalt = null;//Datosa Faltantes 
	viListaSocios lsoc = null; 			  //Lista de Socios
	viReporte_GastosByF r_fyb = null; 	  //Reporte Boleta y Facturas 
	viReporte_GastosOtros r_go = null;	  //Reporte Gastos Otros
	viReporte_Viajes r_v = null;		  //Reporte Viajes
	viReporte_Contabilidad r_c = null;	  //Reporte de Contabilidad

	
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
    private JMenuItem mntmVerConductores;
    private JMenuItem mntmVerBoletaVenta;
    private JMenu mnRegristrarGastosRealizados;
    private JMenuItem mntmViajes;
    private JMenuItem mntmContabilidad;
    
    
	
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
		mntmAdministrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmAdministrarUsuarios(e);
			}
		});
		mntmAdministrarUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnArchivo.add(mntmAdministrarUsuarios);
		
		mntmOpcionesAvanzadas = new JMenuItem("Opciones Avanzadas");
		mntmOpcionesAvanzadas.setEnabled(false);
		mntmOpcionesAvanzadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmOpcionesAvanzadas(e);
			}
		});
		mntmOpcionesAvanzadas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnArchivo.add(mntmOpcionesAvanzadas);
		mnArchivo.add(mntmCerrarSesin);
		mnArchivo.add(mntmSalir);
		
		mnSalidas = new JMenu("|Salida de Minivan");
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
		
		mnFormatos = new JMenu("Formatos|");
		mnFormatos.setForeground(Color.WHITE);
		mnFormatos.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnFormatos.setEnabled(false);
		menuBar.add(mnFormatos);
		
		mntmLlenarInformacion = new JMenuItem("COMPLETAR INFORMACI\u00D3N");
		mntmLlenarInformacion.setBackground(new Color(105, 105, 105));
		mntmLlenarInformacion.setForeground(new Color(255, 255, 255));
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
		mntmContrato.addActionListener(this);
		mntmContrato.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnFormatos.add(mntmContrato);
		
		mntmVerBoletaVenta = new JMenuItem("<html>Ver Ejemplo de <br>Boleta y Factura de Venta</html>");
		mntmVerBoletaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedMntmVerBoletaVenta(arg0);
			}
		});
		mntmVerBoletaVenta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnFormatos.add(mntmVerBoletaVenta);
		
		mnVehiculosConductores = new JMenu("|Socios - vehiculos - conductores|");
		mnVehiculosConductores.setForeground(Color.WHITE);
		mnVehiculosConductores.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnVehiculosConductores.setEnabled(false);
		menuBar.add(mnVehiculosConductores);
		
		mntmListaDeVehiculos = new JMenuItem("Ver Vehiculos");
		mntmListaDeVehiculos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmListaDeVehiculos.addActionListener(this);
		
		mntmListaSocios = new JMenuItem("Lista de Socios");
		mntmListaSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmListaSocios(e);
			}
		});
		mntmListaSocios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnVehiculosConductores.add(mntmListaSocios);
		mnVehiculosConductores.add(mntmListaDeVehiculos);
		
		mntmVerConductores = new JMenuItem("Ver Conductores");
		mntmVerConductores.addActionListener(this);
		mntmVerConductores.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnVehiculosConductores.add(mntmVerConductores);
		
		mnSedes = new JMenu("|Sedes|");
		mnSedes.setEnabled(false);
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
		
		mntmViajes = new JMenuItem("Viajes");
		mntmViajes.addActionListener(this);
		mntmViajes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReportes.add(mntmViajes);
		
		mnRegristrarGastosRealizados = new JMenu("Pagos y Gastos");
		mnRegristrarGastosRealizados.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReportes.add(mnRegristrarGastosRealizados);
		
		JMenuItem mntmFacturasYBoletas = new JMenuItem("Facturas y boletas");
		mntmFacturasYBoletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmFacturasYBoletas(e);
			}
		});
		mntmFacturasYBoletas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnRegristrarGastosRealizados.add(mntmFacturasYBoletas);
		
		JMenuItem mntmOtros = new JMenuItem("Otros");
		mntmOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmOtros(e);
			}
		});
		mntmOtros.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnRegristrarGastosRealizados.add(mntmOtros);
		
		mntmContabilidad = new JMenuItem("Contabilidad");
		mntmContabilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedMntmContabilidad(arg0);
			}
		});
		mntmContabilidad.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReportes.add(mntmContabilidad);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		cargar();
	}
	
	public void cargar(){
		Consultas consulta = new Consultas();
		consulta.iniciar();
		ResultSet rs1 = consulta.cargarConfiguracionInicial();  
		
		try {
			rs1.next();
			int estado = rs1.getInt("estado");
			if(estado == 0){// PRIMERA VES
				ci = new viConfiguracionInicial(this, 1); // PRIMERA VES
				desktopPane.add(ci);
				ci.setLocation((ancho - FrameSize.width)/2, (alto - FrameSize.height)/4);
				ci.show();
			}
			else{// NO ES LA PRIMERA VES
				rs = consulta.cargarVentaTemporal();
				int estado2;
				try {
					rs.next();
					estado2 = rs.getInt("estado");
					if(estado2 == 0){
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
				desktopPane.add(lg);
		        lg.setLocation((ancho - FrameSize.width)/2, (alto - FrameSize.height)/4);
				lg.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		consulta.reset();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmViajes) {
			actionPerformedMntmViajes(arg0);
		}
		if (arg0.getSource() == mntmContrato) {
			actionPerformedMntmContrato(arg0);
		}
		if (arg0.getSource() == mntmVerConductores) {
			actionPerformedMntmVerConductores(arg0);
		}
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
		lusu = null;
		sa1 = null;
		sa2 = null;
		sa3 = null;
		sa4 = null;
		lvc = null;
		ldest = null;
		lcond = null;
		lpjr = null;
		datfalt = null;
		lsoc = null;
		r_fyb = null;
		r_go = null;
		r_v = null;
		r_c = null;		
	}
	
	public void esconderVentanas(){
		if (d1!=null)
			d1.setVisible(false);
		if (lusu!=null)
			lusu.setVisible(false);
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
		if (lcond!=null)
			lcond.setVisible(false);
		if (ldest!=null)
			ldest.setVisible(false);
		if (lpjr!=null)
			lpjr.setVisible(false);
		if (datfalt!=null)
			datfalt.setVisible(false);
		if (lsoc!=null)
			lsoc.setVisible(false);
		if (r_fyb!=null)
			r_fyb.setVisible(false);
		if (r_go!=null)
			r_go.setVisible(false);
		if (r_v!=null)
			r_v.setVisible(false);
		if (r_c!=null)
			r_c.setVisible(false);
	}
	
	public void desactivarMenu(){
		mnArchivo.setEnabled(false);
		mnSalidas.setEnabled(false);
		mnFormatos.setEnabled(false);
		mnVehiculosConductores.setEnabled(false);
		mnSedes.setEnabled(false);
		mnClientes.setEnabled(false);
		mnReportes.setEnabled(false);
		mntmOpcionesAvanzadas.setEnabled(false);
		
	}
	
	public void activarMenu(int tipo){
		if(tipo == 0 || tipo == 2){
			mnArchivo.setEnabled(true);
			mnSalidas.setEnabled(true);
			mnFormatos.setEnabled(true);
			mnVehiculosConductores.setEnabled(true);
			mnSedes.setEnabled(true);
			mnClientes.setEnabled(true);
			mnReportes.setEnabled(true);
		}
		else{
			mnArchivo.setEnabled(true);
			mnSalidas.setEnabled(true);
			mntmAdministrarUsuarios.setEnabled(false);
		}
		if(tipo == 2){
			mntmOpcionesAvanzadas.setEnabled(true);
		}
		
		Consultas consulta = new Consultas();
		consulta.iniciar();
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
		}
		consulta.reset();
		
	}
	
	protected void actionPerformedMntmAdministrarUsuarios(ActionEvent e) {
		esconderVentanas();
		cerrarVentanas();
		lusu = new viListaUsuarios(this);
		desktopPane.add(lusu);
		lusu.show();
		try{
			lusu.setMaximum(true);
		}catch(Exception f){}
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
		
		consulta.iniciar();
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
		consulta.reset();
		
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

		Consultas consulta0 = new Consultas();
		consulta0.iniciar();
		ResultSet rs = consulta0.cargarVentaTemporal(); // OBTENER TODOS LOS DATOS TEMPORALES
		String usuario = "";
		try {
			rs.next();
			rs.getString("usuario");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar usuario registrado");
		}
		consulta0.reset();
		
		if (opc == 0){
			Consultas consulta = new Consultas();
			consulta.iniciar();
			consulta.eliminarSalidaVehiculo(usuario);
			esconderVentanas();
			cerrarVentanas();
			mntmCrearNuevaSalida.setEnabled(true);
			mntmContinuarPreparacion.setEnabled(false);
			mntmCancelarSalida.setEnabled(false);
			mnFormatos.setEnabled(false);
			consulta.reset();
			JOptionPane.showMessageDialog(null, "Salida cancelada");
		}
	}
	
	protected void actionPerformedMntmListaDeDestinos(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		ldest = new viListaSedes(this);
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
		consulta.iniciar();		
		rs = consulta.cantPasajeros();
		int cantPasajeros = 0;
		try {
			rs.next();
			cantPasajeros = rs.getInt("cantPasajeros");
		} catch (SQLException e1) {	e1.printStackTrace(); }
		consulta.reset();

		try {
			Map<String, Object> parameters = new HashMap();
			parameters.put("cantPasajeros", cantPasajeros);
			Connection con = MySQLConexion.getConection();
			new AbstractJasperReports().createReport( con, "rManifiestoPasajeros.jasper", parameters);
			AbstractJasperReports.showViewer();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:. "+ e.getStackTrace());			
		}
	}
	
	protected void actionPerformedMntmHdR(ActionEvent arg0) {
		Consultas consulta = new Consultas();
		consulta.iniciar();
		ResultSet rs = consulta.cargarVentaTemporal();
		int empresa = 0;
		try {
			rs.next();
			empresa = rs.getInt("empresa");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error al cargar empresa: "+ e1.getStackTrace());
		}
		consulta.reset();
		
		try {
			Connection con = MySQLConexion.getConection();
			if(empresa == 1)
				new AbstractJasperReports().createReport( con, "rHojaRutaMA5.jasper");
			else
				new AbstractJasperReports().createReport( con, "rHojaRutaZA5.jasper");
			AbstractJasperReports.showViewer();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar boleta: "+ e.getStackTrace());			
		}
	}
	
	protected void actionPerformedMntmIdV(ActionEvent arg0) {
		Consultas consulta = new Consultas();
		consulta.iniciar();
		ResultSet rs = consulta.cargarVentaTemporal();
		int empresa = 0;
		try {
			rs.next();
			empresa = rs.getInt("empresa");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error al cargar empresa: "+ e1.getStackTrace());
		}
		consulta.reset();
		
		try {
			Connection con = MySQLConexion.getConection();
			if(empresa == 1)
				new AbstractJasperReports().createReport( con, "rItinerarioViajeMA5.jasper");
			else
				new AbstractJasperReports().createReport( con, "rItinerarioViajeZA5.jasper");
			AbstractJasperReports.showViewer();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar boleta: "+ e.getStackTrace());			
		}
	}
	
	protected void actionPerformedMntmListaSocios(ActionEvent e) {
		esconderVentanas();
		cerrarVentanas();
		lsoc = new viListaSocios(this);
		desktopPane.add(lsoc);
		lsoc.show();
		try{
			lsoc.setMaximum(true);
		}catch(Exception f){}
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
	
	protected void actionPerformedMntmVerConductores(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		lcond = new viListaConductores(this);
		desktopPane.add(lcond);
		lcond.show();
		try{
			lcond.setMaximum(true);
		}catch(Exception f){}
	}
	protected void actionPerformedMntmContrato(ActionEvent arg0) {
		Consultas consulta = new Consultas();
		consulta.iniciar();
		ResultSet rs = consulta.cargarVentaTemporal();
		int nViaje = 0;
		int empresa = 0;
		try {
			rs.next();
			empresa = rs.getInt("empresa");
			nViaje = rs.getInt("nviaje");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error al cargar Empresa o N Viaje: "+ e1.getStackTrace());
		}
		consulta.reset();
		
		try {
			Map<String, Object> parameters = new HashMap();
			parameters.put("prmtNViaje", nViaje);
			Connection con = MySQLConexion.getConection();
			if(empresa == 1)
				new AbstractJasperReports().createReport( con, "rContratoMA5.jasper", parameters);
			else
				new AbstractJasperReports().createReport( con, "rContratoZA5.jasper", parameters);
			AbstractJasperReports.showViewer();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar boleta: "+ e.getStackTrace());			
		}
	}
	
	protected void actionPerformedMntmOpcionesAvanzadas(ActionEvent e) {
		esconderVentanas();
		cerrarVentanas();
		ci = new viConfiguracionInicial(this, 2); // MODIFICAR
		desktopPane.add(ci);
		ci.setLocation((ancho - FrameSize.width)/2, (alto - FrameSize.height)/4);
		ci.show();
	}
	
	protected void actionPerformedMntmVerBoletaVenta(ActionEvent arg0) {
		Consultas consulta = new Consultas();
		consulta.iniciar();
		ResultSet rs = consulta.cargarVentaTemporal();
		int empresa = 0;
		try {
			rs.next();
			empresa = rs.getInt("empresa");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error al cargar empresa: "+ e1.getStackTrace());
		}
		consulta.reset();
		
		try {
			Connection con = MySQLConexion.getConection();
			if(empresa == 0)
				new AbstractJasperReports().createReport( con, "rBoletaVentaM.jasper");
			else
				new AbstractJasperReports().createReport( con, "rBoletaVentaZ.jasper");
			AbstractJasperReports.showViewer();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar boleta: "+ e.getStackTrace());			
		}
	}
	
	protected void actionPerformedMntmFacturasYBoletas(ActionEvent e) {
		esconderVentanas();
		cerrarVentanas();
		r_fyb = new viReporte_GastosByF(this);
		desktopPane.add(r_fyb);
		r_fyb.show();
		try{
			r_fyb.setMaximum(true);
		}catch(Exception f){}
	}
	
	protected void actionPerformedMntmOtros(ActionEvent e) {
		esconderVentanas();
		cerrarVentanas();
		r_go = new viReporte_GastosOtros(this);
		desktopPane.add(r_go);
		r_go.show();
		try{
			r_go.setMaximum(true);
		}catch(Exception f){}
	}
	
	protected void actionPerformedMntmViajes(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		r_v = new viReporte_Viajes(this);
		desktopPane.add(r_v);
		r_v.show();
		try{
			r_v.setMaximum(true);
		}catch(Exception f){}
	}
	
	protected void actionPerformedMntmContabilidad(ActionEvent arg0) {
		esconderVentanas();
		cerrarVentanas();
		r_c = new viReporte_Contabilidad(this);
		desktopPane.add(r_c);
		r_c.show();
		try{
			r_c.setMaximum(true);
		}catch(Exception f){}
	}
}





















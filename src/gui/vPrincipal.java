package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


public class vPrincipal extends JFrame implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnSalidas;
	private JMenu mnClientes;
	private JMenu mnReportes;
	private JDesktopPane desktopPane;
	private JMenuItem mntmCrearNuevaSalida;
	private JMenuItem mntmSalir;
	private JMenu mnVehiculosConductores;
	private JMenuItem mntmCerrarSesin;
	private JMenuItem mntmListaDeVehiculos;
    private JMenuItem mntmListaDeDestinos;
    private JMenuItem mntmGastos;
    
    
	viLogin lg = new viLogin(this);
	viDatos1 d1 = new viDatos1(this);
	viSeleccionAsientos1 sa1 = new viSeleccionAsientos1(this);
	viVehiculos lvc = new viVehiculos(this);
	
	int estado = 0; // 0: No existe ventas pentdientes  1: Existen ventas pendientes
	
	//RESOLUCION MONITOR
	//Dimension desktopSize = desktopPane.getSize();
    Dimension FrameSize = lg.getSize();
    // Toolkit t = Toolkit.getDefaultToolkit();
    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
	
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
		
		
		lg.setTitle("LOGIN");
		d1.setTitle("SELECCIONE LOS SIGUIENTE DATOS");
		
		
		addWindowListener(this);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 563);
		
		menuBar = new JMenuBar();
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
		
		mnSalidas = new JMenu("SALIDAS");
		mnSalidas.setEnabled(false);
		menuBar.add(mnSalidas);
		
		mntmCrearNuevaSalida = new JMenuItem("Crear nueva salida bus");
		mntmCrearNuevaSalida.addActionListener(this);
		mnSalidas.add(mntmCrearNuevaSalida);
		
		mnVehiculosConductores = new JMenu("VEHICULOS Y CONDUCTORES");
		mnVehiculosConductores.setEnabled(false);
		menuBar.add(mnVehiculosConductores);
		
		mntmListaDeVehiculos = new JMenuItem("Lista de Vehiculos");
		mntmListaDeVehiculos.addActionListener(this);
		mnVehiculosConductores.add(mntmListaDeVehiculos);
		
		mntmListaDeDestinos = new JMenuItem("Lista de Destinos");
		mnVehiculosConductores.add(mntmListaDeDestinos);
		
		mntmGastos = new JMenuItem("Ingresar gastos generados con vehiculos");
		mnVehiculosConductores.add(mntmGastos);
		
		mnClientes = new JMenu("CLIENTES");
		mnClientes.setEnabled(false);
		menuBar.add(mnClientes);
		
		mnReportes = new JMenu("REPORTES");
		mnReportes.setEnabled(false);
		menuBar.add(mnReportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		
		desktopPane.add(lg);//LOGIN
		desktopPane.add(d1);//DETALLES 1 (DESELECCION DE CARRO)
		desktopPane.add(sa1);//SELECCION DE ASIENTOS 1 
		desktopPane.add(lvc);//LISTA DE VEHICULOS
		
		cargar();
		//JOptionPane.showMessageDialog(null, "" + ancho + "  " + alto);
	}

	public void actionPerformed(ActionEvent arg0) {
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
		
	public void cargar(){
		esconderVentanas();
        lg.setLocation((ancho - FrameSize.width)/2, (alto - FrameSize.height)/4);
		lg.show();
	}
	
	public void esconderVentanas(){
		lg.hide();
		d1.hide();
		sa1.hide();
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
	
	public int verificarEstado(){
		return estado;
	}
	
	protected void actionPerformedMntmCerrarSesin(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Cerrar Sesión?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			desactivarMenu();
			esconderVentanas();
			lg.show();
			lg.cursor();
		}
	}
	
	protected void actionPerformedMntmCrearNuevaSalida(ActionEvent arg0) {
		esconderVentanas();
		d1.setLocation((ancho - FrameSize.width)/2, (alto - FrameSize.height)/4);
		d1.show();
	}
	protected void actionPerformedMntmListaDeVehiculos(ActionEvent arg0) {
		esconderVentanas();
		lvc.show();
		try{
			lvc.setMaximum(true);
		}catch(Exception f){}
		
	}
}





















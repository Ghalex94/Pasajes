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

public class viReporte_GastosByF extends JInternalFrame {
	
	vPrincipal vp = null;
	private JTextField txtEmisionDeBoletas;
	private JPanel panel1;
	private JTextField txtNSerie1_2;
	private JLabel label_1;
	private JComboBox <Sedes> cbOrigen1;
	private JLabel label_2;
	private JComboBox <Sedes> cbDestino1;
	private JLabel lblNSerie;
	private JLabel lblDescripcin;
	private JTextField txtDescripcion1;
	private JLabel lblImporte;
	private JTextField txtImporte1;
	private JDateChooser dchFechaEmision1;
	private JLabel lblFecha;
	private JLabel lblEmpresa;
	private JComboBox cbEmpresa1;
	private JTextField txtNSerie1_1;
	private JLabel label_3;
	private JButton btnRegstrar1;
	private JPanel panel_2;
	private JTextField txtTitulo0;
	private JTextField txtTitulo2;
	private JLabel label;
	private JComboBox cbEmpresa2;
	private JDateChooser dchFechaInicial2;
	private JLabel lblFechaInicial;
	private JDateChooser dchFechaFinal2;
	private JLabel lblFechaFinal;
	private JLabel lblVer;
	private JComboBox cbDocumento2;
	private JButton btnBuscar2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viReporte_GastosByF frame = new viReporte_GastosByF(null);
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
	public viReporte_GastosByF(vPrincipal temp) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		vp = temp;
		
		setBounds(100, 100, 1361, 660);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        
		txtEmisionDeBoletas = new JTextField();
		txtEmisionDeBoletas.setText("REPORTE DE BOLETAS Y FACTURAS EMITIDAS");
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
		panel1.setBounds(20, 86, 625, 535);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		txtNSerie1_2 = new JTextField();
		txtNSerie1_2.setHorizontalAlignment(SwingConstants.LEFT);
		txtNSerie1_2.setForeground(Color.DARK_GRAY);
		txtNSerie1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtNSerie1_2.setColumns(10);
		txtNSerie1_2.setBounds(318, 227, 279, 40);
		panel1.add(txtNSerie1_2);
		
		label_1 = new JLabel("Origen:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		label_1.setBounds(35, 116, 131, 40);
		panel1.add(label_1);
		
		cbOrigen1 = new JComboBox();
		cbOrigen1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		cbOrigen1.setBounds(166, 116, 427, 40);
		panel1.add(cbOrigen1);
		
		label_2 = new JLabel("Destino:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		label_2.setBounds(35, 171, 131, 40);
		panel1.add(label_2);
		
		cbDestino1 = new JComboBox();
		cbDestino1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		cbDestino1.setBounds(166, 171, 427, 40);
		panel1.add(cbDestino1);
		
		lblNSerie = new JLabel("N\u00B0 Serie:");
		lblNSerie.setHorizontalAlignment(SwingConstants.LEFT);
		lblNSerie.setForeground(Color.DARK_GRAY);
		lblNSerie.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		lblNSerie.setBounds(35, 228, 131, 40);
		panel1.add(lblNSerie);
		
		lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcin.setForeground(Color.DARK_GRAY);
		lblDescripcin.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		lblDescripcin.setBounds(35, 279, 239, 33);
		panel1.add(lblDescripcin);
		
		txtDescripcion1 = new JTextField();
		txtDescripcion1.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescripcion1.setForeground(Color.DARK_GRAY);
		txtDescripcion1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtDescripcion1.setColumns(10);
		txtDescripcion1.setBounds(35, 312, 562, 40);
		panel1.add(txtDescripcion1);
		
		lblImporte = new JLabel("Importe: S/");
		lblImporte.setHorizontalAlignment(SwingConstants.LEFT);
		lblImporte.setForeground(Color.DARK_GRAY);
		lblImporte.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		lblImporte.setBounds(35, 369, 168, 40);
		panel1.add(lblImporte);
		
		txtImporte1 = new JTextField();
		txtImporte1.setHorizontalAlignment(SwingConstants.LEFT);
		txtImporte1.setForeground(Color.DARK_GRAY);
		txtImporte1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtImporte1.setColumns(10);
		txtImporte1.setBounds(202, 369, 395, 40);
		panel1.add(txtImporte1);
		
		dchFechaEmision1 = new JDateChooser();
		dchFechaEmision1.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dchFechaEmision1.setBounds(202, 428, 395, 40);
		panel1.add(dchFechaEmision1);
		
		lblFecha = new JLabel("Fecha: ");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setForeground(Color.DARK_GRAY);
		lblFecha.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		lblFecha.setBounds(35, 428, 168, 40);
		panel1.add(lblFecha);
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpresa.setForeground(Color.DARK_GRAY);
		lblEmpresa.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		lblEmpresa.setBounds(35, 55, 131, 40);
		panel1.add(lblEmpresa);
		
		cbEmpresa1 = new JComboBox();
		cbEmpresa1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		cbEmpresa1.setBounds(166, 55, 427, 40);
		panel1.add(cbEmpresa1);
		
		txtNSerie1_1 = new JTextField();
		txtNSerie1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNSerie1_1.setForeground(Color.DARK_GRAY);
		txtNSerie1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtNSerie1_1.setColumns(10);
		txtNSerie1_1.setBounds(166, 227, 112, 40);
		panel1.add(txtNSerie1_1);
		
		label_3 = new JLabel("-");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		label_3.setBounds(277, 227, 41, 40);
		panel1.add(label_3);
		
		btnRegstrar1 = new JButton("REGISTRAR");
		btnRegstrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegstrar1(e);
			}
		});
		btnRegstrar1.setForeground(Color.WHITE);
		btnRegstrar1.setFont(new Font("Dialog", Font.BOLD, 25));
		btnRegstrar1.setBackground(new Color(0, 139, 139));
		btnRegstrar1.setBounds(35, 479, 562, 43);
		panel1.add(btnRegstrar1);
		
		txtTitulo0 = new JTextField();
		txtTitulo0.setBackground(Color.DARK_GRAY);
		txtTitulo0.setForeground(Color.WHITE);
		txtTitulo0.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		txtTitulo0.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo0.setText("REGISTRAR FACTURA O BOLETA");
		txtTitulo0.setBounds(0, 0, 625, 44);
		panel1.add(txtTitulo0);
		txtTitulo0.setColumns(10);
		panel1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cbEmpresa1, cbOrigen1, cbDestino1, txtNSerie1_1, txtNSerie1_2, txtDescripcion1, txtImporte1, dchFechaEmision1, dchFechaEmision1.getCalendarButton(), btnRegstrar1}));
		
		panel_2 = new JPanel();
		panel_2.setBounds(699, 86, 625, 535);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		txtTitulo2 = new JTextField();
		txtTitulo2.setText("CONSULTAS");
		txtTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo2.setForeground(Color.WHITE);
		txtTitulo2.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		txtTitulo2.setColumns(10);
		txtTitulo2.setBackground(Color.DARK_GRAY);
		txtTitulo2.setBounds(0, 0, 625, 44);
		panel_2.add(txtTitulo2);
		
		label = new JLabel("Empresa:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		label.setBounds(37, 55, 131, 40);
		panel_2.add(label);
		
		cbEmpresa2 = new JComboBox();
		cbEmpresa2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		cbEmpresa2.setBounds(229, 55, 366, 40);
		panel_2.add(cbEmpresa2);
		
		dchFechaInicial2 = new JDateChooser();
		dchFechaInicial2.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dchFechaInicial2.setBounds(229, 197, 193, 33);
		panel_2.add(dchFechaInicial2);
		
		lblFechaInicial = new JLabel("Fecha inicial:");
		lblFechaInicial.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaInicial.setForeground(Color.DARK_GRAY);
		lblFechaInicial.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		lblFechaInicial.setBounds(37, 197, 193, 33);
		panel_2.add(lblFechaInicial);
		
		dchFechaFinal2 = new JDateChooser();
		dchFechaFinal2.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dchFechaFinal2.setBounds(229, 259, 193, 33);
		panel_2.add(dchFechaFinal2);
		
		lblFechaFinal = new JLabel("Fecha final:");
		lblFechaFinal.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaFinal.setForeground(Color.DARK_GRAY);
		lblFechaFinal.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		lblFechaFinal.setBounds(37, 259, 193, 33);
		panel_2.add(lblFechaFinal);
		
		lblVer = new JLabel("Documento:");
		lblVer.setHorizontalAlignment(SwingConstants.LEFT);
		lblVer.setForeground(Color.DARK_GRAY);
		lblVer.setFont(new Font("EngraversGothic BT", Font.PLAIN, 30));
		lblVer.setBounds(37, 127, 162, 40);
		panel_2.add(lblVer);
		
		cbDocumento2 = new JComboBox();
		cbDocumento2.setModel(new DefaultComboBoxModel(new String[] {"TODOS", "BOLETAS", "FACTURAS"}));
		cbDocumento2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		cbDocumento2.setBounds(229, 127, 366, 40);
		panel_2.add(cbDocumento2);
		
		btnBuscar2 = new JButton("BUSCAR");
		btnBuscar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar2(e);
			}
		});
		btnBuscar2.setForeground(Color.WHITE);
		btnBuscar2.setFont(new Font("Dialog", Font.BOLD, 25));
		btnBuscar2.setBackground(new Color(0, 139, 139));
		btnBuscar2.setBounds(37, 481, 558, 43);
		panel_2.add(btnBuscar2);
		panel_2.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtTitulo2, cbEmpresa2, dchFechaInicial2, dchFechaInicial2.getCalendarButton(), dchFechaFinal2, dchFechaFinal2.getCalendarButton(), cbDocumento2, btnBuscar2}));
		
		cargar();

	}
	
	public void cargar(){
		//LLENAR COMBOS
		Empresa empresa1 = new Empresa();// EMPRESA 1
		empresa1.cargarEmpresas(cbEmpresa1);
		
		Empresa todEmpresas = new Empresa(-1, "0", "TODOS"); // EMPRESA 2
		cbEmpresa2.addItem(todEmpresas);
		Empresa empresa2 = new Empresa();
		empresa2.cargarEmpresas(cbEmpresa2);
		
		Sedes origen1 = new Sedes();// ORIGEN
		origen1.cargarDestinos(cbOrigen1);
		
		Sedes destino1 = new Sedes();// DESTINO
		destino1.cargarDestinos(cbDestino1);
	}
	
	protected void actionPerformedBtnRegstrar1(ActionEvent e) {
	}
	
	protected void actionPerformedBtnBuscar2(ActionEvent e) {
	}
}

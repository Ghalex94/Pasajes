package gui;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import clases.AbstractJasperReports;
import guiSecundarios.vdVehiculoModificar;
import guiSecundarios.vdVehiculoNuevo;
import mysql.Consultas;
import mysql.MySQLConexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

public class viListaConductores extends JInternalFrame implements ActionListener {
	private JTextField txtVehiculos;
	private JButton btnAnadirVehiculo;
	private JButton btnModificarVehiculo;
	private JButton btnDeshabilitarVehiculo;
	private JScrollPane scrollPane;
	public JTable tbVehiculos;
	
	JTable tb;
	ResultSet rs;
	vPrincipal vp = null;
	private JButton btnReporteConductores;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viListaConductores frame = new viListaConductores(null);
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
	public viListaConductores(vPrincipal temp) {
		
		vp = temp;
		
		setBounds(100, 100, 1353, 677);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		btnAnadirVehiculo = new JButton("A\u00F1adir Vehiculo");
		btnAnadirVehiculo.setVisible(false);
		btnAnadirVehiculo.addActionListener(this);
		
		txtVehiculos = new JTextField();
		txtVehiculos.setText("CONDUCTORES");
		txtVehiculos.setRequestFocusEnabled(false);
		txtVehiculos.setIgnoreRepaint(true);
		txtVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		txtVehiculos.setForeground(Color.WHITE);
		txtVehiculos.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		txtVehiculos.setFocusable(false);
		txtVehiculos.setFocusTraversalKeysEnabled(false);
		txtVehiculos.setEditable(false);
		txtVehiculos.setColumns(10);
		txtVehiculos.setBackground(Color.DARK_GRAY);
		txtVehiculos.setBounds(0, 0, ancho, 75);
		getContentPane().add(txtVehiculos);
		btnAnadirVehiculo.setForeground(Color.WHITE);
		btnAnadirVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnAnadirVehiculo.setBackground(new Color(0, 139, 139));
		btnAnadirVehiculo.setBounds(957, 88, 364, 98);
		getContentPane().add(btnAnadirVehiculo);
		
		btnModificarVehiculo = new JButton("Modificar");
		btnModificarVehiculo.setVisible(false);
		btnModificarVehiculo.addActionListener(this);
		btnModificarVehiculo.setForeground(Color.WHITE);
		btnModificarVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnModificarVehiculo.setBackground(new Color(0, 139, 139));
		btnModificarVehiculo.setBounds(957, 197, 364, 98);
		getContentPane().add(btnModificarVehiculo);
		
		btnDeshabilitarVehiculo = new JButton("Eliminar Vehiculo");
		btnDeshabilitarVehiculo.setVisible(false);
		btnDeshabilitarVehiculo.setEnabled(false);
		btnDeshabilitarVehiculo.addActionListener(this);
		btnDeshabilitarVehiculo.setForeground(Color.WHITE);
		btnDeshabilitarVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnDeshabilitarVehiculo.setBackground(new Color(0, 139, 139));
		btnDeshabilitarVehiculo.setBounds(957, 306, 364, 98);
		getContentPane().add(btnDeshabilitarVehiculo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 937, 525);
		getContentPane().add(scrollPane);
		
		tbVehiculos = new JTable();
		scrollPane.setViewportView(tbVehiculos);
		
		btnReporteConductores = new JButton("<html>Ver Reporte<br>de Conductores</html>");
		btnReporteConductores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnReporteConductores(e);
			}
		});
		btnReporteConductores.setForeground(Color.WHITE);
		btnReporteConductores.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnReporteConductores.setBackground(new Color(0, 139, 139));
		btnReporteConductores.setBounds(957, 513, 364, 98);
		getContentPane().add(btnReporteConductores);

		cargar();
	}
	
	public void cargar(){
		DefaultTableModel dtm = new DefaultTableModel();
		tb = this.tbVehiculos;
		tb.setRowHeight(40);
		tb.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[]{"DNI", "CONDUCTOR", "LICENCIA"});
		Consultas consulta = new Consultas();
		consulta.iniciar();
		rs = consulta.cargarConductores();
		try {
			while(rs.next())
				dtm.addRow(new Object[]{rs.getInt("dniconductor"), rs.getString("conductor"), rs.getString("licencia")});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		consulta.reset();
	}
	
	public void actionPerformed(ActionEvent arg0) {
	}
	
	protected void actionPerformedBtnReporteConductores(ActionEvent e) {
		try {
			Connection con = MySQLConexion.getConection();
			new AbstractJasperReports().createReport( con, "rListaConductores.jasper", null);
			AbstractJasperReports.showViewer();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al cargar reporte de Conductores: "+ ex);			
		}
	}
}






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
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import guiSecundarios.vdVehiculoModificar;
import guiSecundarios.vdVehiculoNuevo;
import mysql.Consultas;
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

public class viListaSocios extends JInternalFrame implements ActionListener {
	private JTextField txtVehiculos;
	private JButton btnAnadirVehiculo;
	private JButton btnModificarVehiculo;
	private JButton btnDeshabilitarVehiculo;
	private JScrollPane scrollPane;
	public JTable tbVehiculos;
	
	JTable tb;
	ResultSet rs;
	vPrincipal vp = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viListaSocios frame = new viListaSocios(null);
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
	public viListaSocios(vPrincipal temp) {
		
		vp = temp;
		
		setBounds(100, 100, 1353, 677);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		txtVehiculos = new JTextField();
		txtVehiculos.setText("SOCIOS");
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
		
		btnAnadirVehiculo = new JButton("A\u00F1adir Socio");
		btnAnadirVehiculo.addActionListener(this);
		btnAnadirVehiculo.setForeground(Color.WHITE);
		btnAnadirVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnAnadirVehiculo.setBackground(new Color(0, 139, 139));
		btnAnadirVehiculo.setBounds(957, 88, 364, 98);
		getContentPane().add(btnAnadirVehiculo);
		
		btnModificarVehiculo = new JButton("Modificar Socio");
		btnModificarVehiculo.addActionListener(this);
		btnModificarVehiculo.setForeground(Color.WHITE);
		btnModificarVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnModificarVehiculo.setBackground(new Color(0, 139, 139));
		btnModificarVehiculo.setBounds(957, 224, 364, 98);
		getContentPane().add(btnModificarVehiculo);
		
		btnDeshabilitarVehiculo = new JButton("Eliminar Socio");
		btnDeshabilitarVehiculo.setEnabled(false);
		btnDeshabilitarVehiculo.addActionListener(this);
		btnDeshabilitarVehiculo.setForeground(Color.WHITE);
		btnDeshabilitarVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnDeshabilitarVehiculo.setBackground(new Color(0, 139, 139));
		btnDeshabilitarVehiculo.setBounds(957, 365, 364, 98);
		getContentPane().add(btnDeshabilitarVehiculo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 937, 544);
		getContentPane().add(scrollPane);
		
		tbVehiculos = new JTable();
		scrollPane.setViewportView(tbVehiculos);

		cargar();
	}
	
	
	
	public void cargar(){
		DefaultTableModel dtm = new DefaultTableModel();
		tb = this.tbVehiculos;
		tb.setRowHeight(40);
		tb.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[]{"PLACA", "MODELO", "DETALLE", "DNI CONDUCTOR", "NOMBRE CONDUCTOR", "MTC"});
		Consultas consult = new Consultas();
		rs = consult.cargarVehiculosConductores();
		try {
			while(rs.next())
				dtm.addRow(new Object[]{rs.getString("placa"), rs.getString("modelo"), rs.getString("detalle"), rs.getString("dniconductor"), rs.getString("conductor"), rs.getString("mtc")});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnDeshabilitarVehiculo) {
			actionPerformedBtnDeshabilitarVehiculo(arg0);
		}
		if (arg0.getSource() == btnModificarVehiculo) {
			actionPerformedBtnModificarVehiculo(arg0);
		}
		if (arg0.getSource() == btnAnadirVehiculo) {
			actionPerformedBtnAnadirVehiculo(arg0);
		}
	}
	
	protected void actionPerformedBtnAnadirVehiculo(ActionEvent arg0) {
	}
	
	protected void actionPerformedBtnModificarVehiculo(ActionEvent arg0) {
	}
	protected void actionPerformedBtnDeshabilitarVehiculo(ActionEvent arg0) {
	}
}






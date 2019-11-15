package gui;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import clases.AbstractJasperReports;
import guiSecundarios.vdSedeNueva;
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
import java.awt.event.ActionEvent;

public class viListaSedes extends JInternalFrame implements ActionListener {
	private JTextField txtVehiculos;
	private JButton btnAnadirDestino;
	private JButton btnEliminarDestino;
	private JScrollPane scrollPane;
	public JTable tbDestinos;
	
	JTable tb;
	ResultSet rs;
	vPrincipal vp = null;
	private JButton btnReporteSedes;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viListaSedes frame = new viListaSedes(null);
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
	public viListaSedes(vPrincipal temp) {
		
		vp = temp;
		
		setBounds(100, 100, 1368, 678);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		txtVehiculos = new JTextField();
		txtVehiculos.setText("SEDES");
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
		
		btnAnadirDestino = new JButton("A\u00F1adir Sede");
		btnAnadirDestino.addActionListener(this);
		btnAnadirDestino.setForeground(Color.WHITE);
		btnAnadirDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnAnadirDestino.setBackground(new Color(0, 139, 139));
		btnAnadirDestino.setBounds(968, 86, 364, 98);
		getContentPane().add(btnAnadirDestino);
		
		btnEliminarDestino = new JButton("Eliminar Sede");
		btnEliminarDestino.setEnabled(false);
		btnEliminarDestino.addActionListener(this);
		btnEliminarDestino.setForeground(Color.WHITE);
		btnEliminarDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnEliminarDestino.setBackground(new Color(0, 139, 139));
		btnEliminarDestino.setBounds(968, 195, 364, 98);
		getContentPane().add(btnEliminarDestino);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 948, 549);
		getContentPane().add(scrollPane);
		
		tbDestinos = new JTable();
		scrollPane.setViewportView(tbDestinos);
		
		btnReporteSedes = new JButton("<html>Ver Reporte<br>\u00A0de Sedes</html>");
		btnReporteSedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnReporteSedes(arg0);
			}
		});
		btnReporteSedes.setForeground(Color.WHITE);
		btnReporteSedes.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnReporteSedes.setBackground(new Color(0, 139, 139));
		btnReporteSedes.setBounds(968, 537, 364, 98);
		getContentPane().add(btnReporteSedes);

		cargar();
	}
	
	
	
	public void cargar(){
		DefaultTableModel dtm = new DefaultTableModel();
		tb = this.tbDestinos;
		tb.setRowHeight(40);
		tb.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[]{"ID", "SEDE"});
		Consultas consult = new Consultas();
		consult.iniciar();
		rs = consult.cargarSedes();
		try {
			while(rs.next())
				dtm.addRow(new Object[]{rs.getInt("idsede"), rs.getString("sede")});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		consult.reset();
		ajustarAnchoColumnas();
	}
	
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbDestinos.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));// ID
		tcm.getColumn(1).setPreferredWidth(anchoColumna(90));// Destino
			
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminarDestino) {
			actionPerformedBtnEliminarDestino(arg0);
		}
		if (arg0.getSource() == btnAnadirDestino) {
			actionPerformedBtnAnadirDestino(arg0);
		}
	}
	
	protected void actionPerformedBtnAnadirDestino(ActionEvent arg0) {
		vdSedeNueva ldest = new vdSedeNueva(vp, this);
		ldest.setVisible(true);
		vp.setEnabled(false);
	}
	
	protected void actionPerformedBtnEliminarDestino(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Eliminar destino?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			int iddestino = Integer.parseInt(tbDestinos.getValueAt(tbDestinos.getSelectedRow(), 0).toString());
			Consultas consulta = new Consultas();
			consulta.iniciar();
			consulta.eliminarDestino(iddestino);
			this.cargar();
			consulta.reset();
			JOptionPane.showMessageDialog(null, "Eliminado correctamente");
		}
	}
	
	protected void actionPerformedBtnReporteSedes(ActionEvent arg0) {
		try {
			Connection con = MySQLConexion.getConection();
			new AbstractJasperReports().createReport( con, "rListaSedes.jasper", null);
			AbstractJasperReports.showViewer();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar reporte de Sedes: "+ e);			
		}
	}
}






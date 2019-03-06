package gui;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import guiSecundarios.vdDestinoNuevo;
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
import java.awt.event.ActionEvent;

public class viListaDestinos extends JInternalFrame implements ActionListener {
	private JTextField txtVehiculos;
	private JButton btnAnadirDestino;
	private JButton btnEliminarDestino;
	private JScrollPane scrollPane;
	public JTable tbDestinos;
	
	JTable tb;
	ResultSet rs;
	vPrincipal vp = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viListaDestinos frame = new viListaDestinos(null);
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
	public viListaDestinos(vPrincipal temp) {
		
		vp = temp;
		
		setBounds(100, 100, 1514, 721);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		txtVehiculos = new JTextField();
		txtVehiculos.setText("DESTINOS");
		txtVehiculos.setRequestFocusEnabled(false);
		txtVehiculos.setIgnoreRepaint(true);
		txtVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		txtVehiculos.setForeground(Color.WHITE);
		txtVehiculos.setFont(new Font("USAngel", Font.BOLD, 32));
		txtVehiculos.setFocusable(false);
		txtVehiculos.setFocusTraversalKeysEnabled(false);
		txtVehiculos.setEditable(false);
		txtVehiculos.setColumns(10);
		txtVehiculos.setBackground(Color.DARK_GRAY);
		txtVehiculos.setBounds(0, 0, ancho, 75);
		getContentPane().add(txtVehiculos);
		
		btnAnadirDestino = new JButton("Anadir Destino");
		btnAnadirDestino.addActionListener(this);
		btnAnadirDestino.setForeground(Color.WHITE);
		btnAnadirDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 28));
		btnAnadirDestino.setBackground(Color.DARK_GRAY);
		btnAnadirDestino.setBounds(1124, 86, 364, 98);
		getContentPane().add(btnAnadirDestino);
		
		btnEliminarDestino = new JButton("Eliminar Destino");
		btnEliminarDestino.addActionListener(this);
		btnEliminarDestino.setForeground(Color.WHITE);
		btnEliminarDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 28));
		btnEliminarDestino.setBackground(Color.DARK_GRAY);
		btnEliminarDestino.setBounds(1124, 227, 364, 98);
		getContentPane().add(btnEliminarDestino);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 1104, 594);
		getContentPane().add(scrollPane);
		
		tbDestinos = new JTable();
		scrollPane.setViewportView(tbDestinos);

		cargar();
	}
	
	
	
	public void cargar(){
		DefaultTableModel dtm = new DefaultTableModel();
		tb = this.tbDestinos;
		tb.setRowHeight(40);
		tb.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[]{"ID", "DESTINO"});
		Consultas consult = new Consultas();
		rs = consult.cargarDestinos();
		try {
			while(rs.next())
				dtm.addRow(new Object[]{rs.getInt("iddestino"), rs.getString("destino")});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
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
		vdDestinoNuevo ldest = new vdDestinoNuevo(vp, this);
		ldest.setVisible(true);
		vp.setEnabled(false);
	}
	protected void actionPerformedBtnEliminarDestino(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Eliminar destino?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			int iddestino = Integer.parseInt(tbDestinos.getValueAt(tbDestinos.getSelectedRow(), 0).toString());
			Consultas.eliminarDestino(iddestino);
			this.cargar();
			JOptionPane.showMessageDialog(null, "Eliminado correctamente");
		}
	}
}






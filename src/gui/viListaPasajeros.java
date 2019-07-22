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

import guiSecundarios.vdSedeNueva;
import guiSecundarios.vdPasajeroNuevo;
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

public class viListaPasajeros extends JInternalFrame implements ActionListener {
	private JTextField txtVehiculos;
	private JButton btnAnadirPasajero;
	private JButton btnEliminarPasajero;
	private JScrollPane scrollPane;
	public JTable tbPasajeros;
	
	JTable tb;
	ResultSet rs;
	vPrincipal vp = null;
	private JButton btnModificarCliente;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viListaPasajeros frame = new viListaPasajeros(null);
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
	public viListaPasajeros(vPrincipal temp) {
		
		vp = temp;
		
		setBounds(100, 100, 1361, 674);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		txtVehiculos = new JTextField();
		txtVehiculos.setText("CLIENTES");
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
		
		btnAnadirPasajero = new JButton("A\u00F1adir Cliente");
		btnAnadirPasajero.addActionListener(this);
		btnAnadirPasajero.setForeground(Color.WHITE);
		btnAnadirPasajero.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnAnadirPasajero.setBackground(new Color(0, 139, 139));
		btnAnadirPasajero.setBounds(973, 86, 364, 98);
		getContentPane().add(btnAnadirPasajero);
		
		btnEliminarPasajero = new JButton("Eliminar Cliente");
		btnEliminarPasajero.setEnabled(false);
		btnEliminarPasajero.addActionListener(this);
		btnEliminarPasajero.setForeground(Color.WHITE);
		btnEliminarPasajero.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnEliminarPasajero.setBackground(new Color(0, 139, 139));
		btnEliminarPasajero.setBounds(973, 333, 364, 98);
		getContentPane().add(btnEliminarPasajero);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 953, 541);
		getContentPane().add(scrollPane);
		
		tbPasajeros = new JTable();
		scrollPane.setViewportView(tbPasajeros);
		
		btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.addActionListener(this);
		btnModificarCliente.setForeground(Color.WHITE);
		btnModificarCliente.setFont(new Font("EngraversGothic BT", Font.BOLD, 35));
		btnModificarCliente.setBackground(new Color(0, 139, 139));
		btnModificarCliente.setBounds(973, 209, 364, 98);
		getContentPane().add(btnModificarCliente);

		cargar();
	}
	
	public void cargar(){
		DefaultTableModel dtm = new DefaultTableModel();
		tb = this.tbPasajeros;
		tb.setRowHeight(40);
		tb.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[]{"DNI", "RUC", "NOMBRE", "RAZ SOCIAL", "F. NACIMIENTO", "NACIONALIDAD"});
		Consultas consult = new Consultas();
		rs = consult.cargarPasajeros();
		try {
			while(rs.next())
				dtm.addRow(new Object[]{rs.getInt("dnipasajero"), rs.getString("ruc"), rs.getString("nombre"), rs.getString("razsocial"), rs.getString("fnacimiento"), rs.getString("nacionalidad")});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificarCliente) {
			actionPerformedBtnModificarCliente(arg0);
		}
		if (arg0.getSource() == btnEliminarPasajero) {
			actionPerformedBtnEliminarDestino(arg0);
		}
		if (arg0.getSource() == btnAnadirPasajero) {
			actionPerformedBtnAnadirDestino(arg0);
		}
	}
	
	protected void actionPerformedBtnAnadirDestino(ActionEvent arg0) {
		vdPasajeroNuevo vdp = new vdPasajeroNuevo(vp, this, 1, 0); // 1 NUEVO --  2 MODIFICAR
		vdp.setVisible(true);
		vdp.setAlwaysOnTop(true);
		vdp.setLocationRelativeTo(null);
		vp.setEnabled(false);		
	}
	
	protected void actionPerformedBtnModificarCliente(ActionEvent arg0) {
		int dniPasajero = Integer.parseInt(tbPasajeros.getValueAt(tbPasajeros.getSelectedRow(), 0).toString()); 
		vdPasajeroNuevo vdp = new vdPasajeroNuevo(vp, this, 2, dniPasajero); // 1 NUEVO --  2 MODIFICAR
		vdp.setVisible(true);
		vdp.setAlwaysOnTop(true);
		vdp.setLocationRelativeTo(null);
		vp.setEnabled(false);
	}
	
	protected void actionPerformedBtnEliminarDestino(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Eliminar Cliente?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			int dniPasajero = Integer.parseInt(tbPasajeros.getValueAt(tbPasajeros.getSelectedRow(), 0).toString());
			Consultas.eliminarPasajero(dniPasajero);
			this.cargar();
			JOptionPane.showMessageDialog(null, "Eliminado correctamente");
		}
	}
}






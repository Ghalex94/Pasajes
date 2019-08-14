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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import guiSecundarios.vdSocioModificar;
import guiSecundarios.vdSocioNuevo;
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
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class viListaUsuarios extends JInternalFrame {
	private JTextField txtVehiculos;
	private JButton btnDeshabilitarUsuario;
	private JScrollPane scrollPane;
	public JTable tbUsuarios;
	
	JTable tb;
	ResultSet rs;
	vPrincipal vp = null;

	Consultas consulta = new Consultas();
	private JTextField txtUsuario;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtNombre;
	private JLabel label_3;
	private JComboBox cbTipo;
	private JButton btnGuardar;
	private JPasswordField txtPass;
	private JCheckBox chckbxMostrarPass;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viListaUsuarios frame = new viListaUsuarios(null);
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
	public viListaUsuarios(vPrincipal temp) {
		
		vp = temp;
		
		setBounds(100, 100, 1353, 677);
		getContentPane().setLayout(null);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		txtVehiculos = new JTextField();
		txtVehiculos.setText("USUARIOS");
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
		
		btnDeshabilitarUsuario = new JButton("Eliminar");
		btnDeshabilitarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnDeshabilitarUsuario(e);
			}
		});
		btnDeshabilitarUsuario.setForeground(Color.WHITE);
		btnDeshabilitarUsuario.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnDeshabilitarUsuario.setBackground(new Color(0, 139, 139));
		btnDeshabilitarUsuario.setBounds(1189, 115, 138, 36);
		getContentPane().add(btnDeshabilitarUsuario);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 1317, 447);
		getContentPane().add(scrollPane);
		
		tbUsuarios = new JTable();
		tbUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedTbUsuarios(arg0);
			}
		});
		scrollPane.setViewportView(tbUsuarios);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setForeground(SystemColor.windowBorder);
		txtUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtUsuario.setColumns(10);
		txtUsuario.setBackground(SystemColor.controlHighlight);
		txtUsuario.setBounds(10, 117, 169, 34);
		getContentPane().add(txtUsuario);
		
		label = new JLabel("Usuario:");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		label.setBounds(10, 79, 138, 38);
		getContentPane().add(label);
		
		label_1 = new JLabel("Contrase\u00F1a:");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		label_1.setBounds(189, 79, 205, 38);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("Nombre:");
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		label_2.setBounds(452, 86, 132, 31);
		getContentPane().add(label_2);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setForeground(SystemColor.windowBorder);
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtNombre.setColumns(10);
		txtNombre.setBackground(SystemColor.controlHighlight);
		txtNombre.setBounds(452, 117, 351, 34);
		getContentPane().add(txtNombre);
		
		label_3 = new JLabel("Tipo:");
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		label_3.setBounds(813, 86, 138, 31);
		getContentPane().add(label_3);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Empleado"}));
		cbTipo.setSelectedIndex(-1);
		cbTipo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cbTipo.setBounds(813, 115, 205, 36);
		getContentPane().add(cbTipo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnGuardar(e);
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 20));
		btnGuardar.setBackground(new Color(0, 139, 139));
		btnGuardar.setBounds(1028, 115, 138, 36);
		getContentPane().add(btnGuardar);
		
		txtPass = new JPasswordField();
		txtPass.setBackground(SystemColor.controlHighlight);
		txtPass.setBounds(189, 115, 253, 36);
		getContentPane().add(txtPass);
		
		chckbxMostrarPass = new JCheckBox("");
		chckbxMostrarPass.setVisible(false);
		chckbxMostrarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedChckbxMostrarPass(e);
			}
		});
		chckbxMostrarPass.setBounds(411, 94, 31, 23);
		getContentPane().add(chckbxMostrarPass);

		cargar();
	}	
	
	public void cargar(){
		DefaultTableModel dtm = new DefaultTableModel();
		tb = this.tbUsuarios;
		tb.setRowHeight(40);
		tb.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[]{"NOMBRE", "USUARIO", "CONTRASEÑA", "TIPO"});
		Consultas consult = new Consultas();
		rs = consult.cargarUsuarios();
		try {
			while(rs.next()){
				if(rs.getInt("tipo") != 2){
					String tipo = "";
					if(rs.getInt("tipo") == 0)
						tipo = "Administrador";
					if(rs.getInt("tipo") == 1)
						tipo = "Empleado";
					/*if(rs.getInt("tipo") == 2)
						tipo = "Soporte";*/
					dtm.addRow(new Object[]{rs.getString("nombre"), rs.getString("usuario"), "************", tipo});
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR al cargar usuarios: " + e);
		}		
		ajustarAnchoColumnas();
	}
	
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	public void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbUsuarios.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(40));  // Usuario
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30));  // Contraseña
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  // Nombre
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // Tipo
		
		DefaultTableCellRenderer tcr0 = new DefaultTableCellRenderer();
		tcr0.setHorizontalAlignment(SwingConstants.CENTER);
		tbUsuarios.getColumnModel().getColumn(3).setCellRenderer(tcr0);
	}
	
	public void seleccionarUsuario(String usu){
		int cantUsuarios = tbUsuarios.getRowCount();
		for(int i = 0; i<cantUsuarios; i++){
			if(usu.equals(tbUsuarios.getValueAt(i, 1))){
				tbUsuarios.setRowSelectionInterval(i,i);
				break;
			}
		}
	}
	
	public void limpiar(){
		txtNombre.setText(null);
		txtUsuario.setText(null);
		txtPass.setText(null);
		cbTipo.setSelectedIndex(0);
	}
	
	protected void mouseClickedTbUsuarios(MouseEvent arg0) {
		String nombre = tbUsuarios.getValueAt(tbUsuarios.getSelectedRow(), 0).toString();
		String usuario = tbUsuarios.getValueAt(tbUsuarios.getSelectedRow(), 1).toString();
		String pass = tbUsuarios.getValueAt(tbUsuarios.getSelectedRow(), 2).toString();
		String tipo = tbUsuarios.getValueAt(tbUsuarios.getSelectedRow(), 3).toString();
		
		txtNombre.setText(nombre);
		txtUsuario.setText(usuario);
		txtPass.setText("");
		cbTipo.setSelectedItem(tipo);
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		if(txtUsuario.getText().length() == 0 || txtPass.getText().length() == 0 || txtNombre.getText().length() == 0)
			JOptionPane.showMessageDialog(null, "Ingrese todos los datos correctamente");
		else{
			String nombre = txtNombre.getText();
			String usuario = txtUsuario.getText();
			String pass = txtPass.getText();
			int tipo = cbTipo.getSelectedIndex(); 
			
			Consultas consult = new Consultas();
			ResultSet rs2 = null;
			rs2 = consult.buscarUsuario(usuario);
			try {
				rs2.next();//MODIFICAR
				String nombrers = rs2.getString("nombre");
				int opc = JOptionPane.showConfirmDialog(null, "Ya existe el usuario, se modificará ¿Continuar?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opc == 0){
					consult.modificarUsuario(usuario, pass, nombre, tipo);
					cargar();
					seleccionarUsuario(usuario);
					limpiar();
				}
			} catch (Exception e2) {// CREAR
				int opc = JOptionPane.showConfirmDialog(null, "Se creará un nuevo usuario ¿Continuar?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opc == 0){
					
					consult.ingresarUsuario(usuario, pass, nombre, tipo);
					cargar();
					seleccionarUsuario(usuario);
					limpiar();
					
				}
			}	
		}
	}
	
	protected void actionPerformedBtnDeshabilitarUsuario(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			DefaultTableModel tm = (DefaultTableModel) tbUsuarios.getModel();
			String usuario = String.valueOf(tm.getValueAt(tbUsuarios.getSelectedRow(),1));
			if( usuario.equals("admin"))
				JOptionPane.showMessageDialog(null, "Este usuario no se puede borrar por seguridad.");
			else{
				try {
					consulta.eliminarUsuario(usuario);
					cargar();
					limpiar();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR: "+ ex);
				}
			}
		}
	}
	protected void actionPerformedChckbxMostrarPass(ActionEvent e) {
		if(chckbxMostrarPass.isSelected())
			txtPass.setEchoChar((char)0);
		else
			txtPass.setEchoChar('*');
	}
}






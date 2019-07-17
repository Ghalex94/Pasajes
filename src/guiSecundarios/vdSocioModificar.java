package guiSecundarios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Conductor;
import clases.Empresa;
import gui.vPrincipal;
import gui.viListaSocios;
import gui.viListaVehiculos;
import mysql.Consultas;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;

public class vdSocioModificar extends JDialog implements ActionListener, KeyListener {
	private JTextField txtAgregarVehiculo;
	private JTextField txtCodSocio;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblPlaca;
	private JTextField txtDniSocio;
	private JLabel lblEmpresa;
	private JComboBox cbEmpresa;
	private JLabel label;
	private JTextField txtPlaca;
	private JComboBox cbModeloV;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtDetalles;
	private JLabel label_3;
	private JTextField txtMTC;
	private JLabel lblConductor_1;
	private JLabel lblDni;
	private JTextField txtDniConductor;
	private JLabel lblNombre;
	private JTextField txtNombreConductor;
	private JLabel label_7;
	private JTextField txtNlicencia;
	private Component horizontalStrut;
	private Component verticalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_1;
	private Component horizontalStrut_2;
	private Component verticalStrut_2;
	private JTextField txtNombreSocio;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_8;
	
	vPrincipal vp = null;
	viListaSocios vnsn = null;
	int codsocio = 0;
	int dniconductor = 0;
	String placa = null;
	
	public static void main(String[] args) {
		try {
			vdSocioModificar dialog = new vdSocioModificar(null, null, 0, 0, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vdSocioModificar(vPrincipal temp, viListaSocios temp2, int temp3, int temp4, String temp5) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		vp = temp;
		vnsn = temp2;
		codsocio = temp3;
		dniconductor = temp4;
		placa = temp5;
		
		
		setUndecorated(true);
		setBounds(100, 100, 724, 709);
		getContentPane().setLayout(null);
		{
			txtAgregarVehiculo = new JTextField();
			txtAgregarVehiculo.setEditable(false);
			txtAgregarVehiculo.setText("MODIFICAR SOCIO");
			txtAgregarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
			txtAgregarVehiculo.setForeground(Color.WHITE);
			txtAgregarVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
			txtAgregarVehiculo.setColumns(10);
			txtAgregarVehiculo.setBackground(new Color(0, 139, 139));
			txtAgregarVehiculo.setBounds(0, 0, 724, 46);
			getContentPane().add(txtAgregarVehiculo);
		}
		{
			lblPlaca = new JLabel("Codigo de socio:");
			lblPlaca.setVerticalAlignment(SwingConstants.BOTTOM);
			lblPlaca.setHorizontalAlignment(SwingConstants.LEFT);
			lblPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblPlaca.setBounds(30, 57, 190, 34);
			getContentPane().add(lblPlaca);
		}
		{
			txtCodSocio = new JTextField();
			txtCodSocio.setEditable(false);
			txtCodSocio.setForeground(new Color(255, 69, 0));
			txtCodSocio.addKeyListener(this);
			txtCodSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtCodSocio.setColumns(10);
			txtCodSocio.setBounds(226, 69, 464, 25);
			getContentPane().add(txtCodSocio);
		}
		{
			JLabel lblModelo = new JLabel("DNI:");
			lblModelo.setVerticalAlignment(SwingConstants.BOTTOM);
			lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
			lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblModelo.setBounds(70, 146, 105, 34);
			getContentPane().add(lblModelo);
		}
		{
			JLabel lblConductor = new JLabel("Veh\u00EDculo afiliado");
			lblConductor.setVerticalAlignment(SwingConstants.BOTTOM);
			lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblConductor.setBounds(30, 246, 190, 34);
			getContentPane().add(lblConductor);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnCancelar.setBackground(new Color(0, 139, 139));
			btnCancelar.setBounds(31, 634, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			btnGuardar = new JButton("<html>Guardar</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnGuardar.setBackground(new Color(0, 139, 139));
			btnGuardar.setBounds(470, 634, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			txtDniSocio = new JTextField();
			txtDniSocio.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					keyTypedTxtDniSocio(arg0);
				}
			});
			txtDniSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtDniSocio.setColumns(10);
			txtDniSocio.setBounds(226, 155, 464, 25);
			getContentPane().add(txtDniSocio);
		}
		
		lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpresa.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblEmpresa.setBounds(70, 102, 105, 34);
		getContentPane().add(lblEmpresa);
		
		cbEmpresa = new JComboBox();
		cbEmpresa.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbEmpresa.setBounds(226, 112, 464, 25);
		getContentPane().add(cbEmpresa);
		
		label = new JLabel("Placa:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label.setBounds(70, 293, 95, 20);
		getContentPane().add(label);
		
		txtPlaca = new JTextField();
		txtPlaca.setEditable(false);
		txtPlaca.setForeground(new Color(255, 69, 0));
		txtPlaca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				keyTypedTxtPlaca(arg0);
			}
		});
		txtPlaca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				focusLostTxtPlaca(arg0);
			}
		});
		txtPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(226, 291, 464, 25);
		getContentPane().add(txtPlaca);
		
		cbModeloV = new JComboBox();
		cbModeloV.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbModeloV.setBounds(226, 331, 464, 25);
		getContentPane().add(cbModeloV);
		
		label_1 = new JLabel("Modelo:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_1.setBounds(70, 336, 95, 20);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("Detalles:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(70, 377, 95, 20);
		getContentPane().add(label_2);
		
		txtDetalles = new JTextField();
		txtDetalles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtDetalles(e);
			}
		});
		txtDetalles.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDetalles.setColumns(10);
		txtDetalles.setBounds(226, 372, 464, 25);
		getContentPane().add(txtDetalles);
		
		label_3 = new JLabel("MTC:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBounds(70, 420, 95, 20);
		getContentPane().add(label_3);
		
		txtMTC = new JTextField();
		txtMTC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtMTC(e);
			}
		});
		txtMTC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtMTC.setColumns(10);
		txtMTC.setBounds(226, 415, 464, 25);
		getContentPane().add(txtMTC);
		
		lblConductor_1 = new JLabel("Conductor");
		lblConductor_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblConductor_1.setBounds(30, 484, 132, 20);
		getContentPane().add(lblConductor_1);
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblDni.setBounds(70, 518, 104, 20);
		getContentPane().add(lblDni);
		
		txtDniConductor = new JTextField();
		txtDniConductor.setEditable(false);
		txtDniConductor.setForeground(new Color(255, 69, 0));
		txtDniConductor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				keyTypedTxtDniConductor(arg0);
			}
		});
		txtDniConductor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostTxtDniConductor(e);
			}
		});
		txtDniConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDniConductor.setColumns(10);
		txtDniConductor.setBounds(226, 515, 464, 25);
		getContentPane().add(txtDniConductor);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNombre.setBounds(70, 553, 111, 20);
		getContentPane().add(lblNombre);
		
		txtNombreConductor = new JTextField();
		txtNombreConductor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtNombreConductor(e);
			}
		});
		txtNombreConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNombreConductor.setColumns(10);
		txtNombreConductor.setBounds(226, 550, 464, 25);
		getContentPane().add(txtNombreConductor);
		
		label_7 = new JLabel("N Licencia:");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(new Color(0, 0, 0));
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_7.setBounds(70, 586, 132, 20);
		getContentPane().add(label_7);
		
		txtNlicencia = new JTextField();
		txtNlicencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtNlicencia(e);
			}
		});
		txtNlicencia.setForeground(Color.BLACK);
		txtNlicencia.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNlicencia.setColumns(10);
		txtNlicencia.setBounds(226, 584, 464, 25);
		getContentPane().add(txtNlicencia);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(22, 503, 40, 20);
		getContentPane().add(horizontalStrut);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(52, 513, 18, 110);
		getContentPane().add(verticalStrut);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(22, 275, 40, 20);
		getContentPane().add(horizontalStrut_1);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(52, 285, 18, 162);
		getContentPane().add(verticalStrut_1);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setBounds(22, 85, 40, 20);
		getContentPane().add(horizontalStrut_2);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setBounds(52, 95, 18, 140);
		getContentPane().add(verticalStrut_2);
		
		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setVerticalAlignment(SwingConstants.BOTTOM);
		Nombre.setHorizontalAlignment(SwingConstants.LEFT);
		Nombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		Nombre.setBounds(70, 191, 105, 34);
		getContentPane().add(Nombre);
		
		txtNombreSocio = new JTextField();
		txtNombreSocio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtNombreSocio(e);
			}
		});
		txtNombreSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNombreSocio.setColumns(10);
		txtNombreSocio.setBounds(226, 200, 464, 25);
		getContentPane().add(txtNombreSocio);
		
		label_5 = new JLabel("*");
		label_5.setForeground(new Color(255, 0, 0));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_5.setBounds(202, 70, 18, 20);
		getContentPane().add(label_5);
		
		label_6 = new JLabel("*");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_6.setBounds(202, 291, 18, 20);
		getContentPane().add(label_6);
		
		label_8 = new JLabel("*");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_8.setBounds(202, 518, 18, 20);
		getContentPane().add(label_8);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtCodSocio, cbEmpresa, txtDniSocio, txtNombreSocio, txtPlaca, cbModeloV, txtDetalles, txtMTC, txtDniConductor, txtNombreConductor, txtNlicencia, btnGuardar, btnCancelar}));
		cargar();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	
	public void cargar(){
		this.setLocationRelativeTo(null);
		
		//CARGAR EMPRESAS
		Empresa empresa = new Empresa();
		empresa.cargarEmpresas(cbEmpresa);
		
		//CARGAR MODELOS DE VEHICULOS
		Consultas consult = new Consultas();
		ResultSet rs1;
		rs1 = consult.cargarModelosVehiculos();
		try {
			while(rs1.next())
				cbModeloV.addItem(rs1.getString("modelo"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		
		//BUSCAR DATOS
		txtCodSocio.setText("" + codsocio);
		txtDniConductor.setText("" + dniconductor);
		txtPlaca.setText(placa);
		
		Consultas consult2 = new Consultas();
		ResultSet rs2;
		rs2 = consult2.buscarSocio(codsocio);
		int idEmpresa = 0;
		try {
			rs2.next();
			idEmpresa = rs2.getInt("idempresa");
			txtDniSocio.setText(""+rs2.getString("dnisocio"));
			txtNombreSocio.setText(rs2.getString("nombresocio"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		cbEmpresa.setSelectedIndex(idEmpresa-1);
		/*
		Consultas consult25 = new Consultas();
		ResultSet rs25;
		rs25 = consult25.buscarEmpresa(idEmpresa);
		try {
			rs25.next();
			cbEmpresa.setSelectedItem(rs25.getString("empresa").toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}*/
		
		Consultas consult3 = new Consultas();
		ResultSet rs3;
		rs3 = consult3.buscarVehiculo(placa);
		int idmodelovehiculo = 0;
		try {
			rs3.next();
			idmodelovehiculo = rs3.getInt("idmodelo");
			txtDetalles.setText(rs3.getString("detalle"));
			txtMTC.setText(rs3.getString("mtc"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		
		Consultas consultas35 = new Consultas();
		ResultSet rs35;
		rs35 = consultas35.buscarModeloVehiculo(idmodelovehiculo);
		try {
			rs35.next();
			cbModeloV.setSelectedItem(rs35.getString("modelo"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		
		Consultas consult4 = new Consultas();
		ResultSet rs4;
		rs4 = consult4.buscarConductor(dniconductor);
		try {
			rs4.next();
			txtNombreConductor.setText(rs4.getString("conductor"));
			txtNlicencia.setText(rs4.getString("licencia"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}		
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		vp.enable(true);
		this.dispose();
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		if(txtCodSocio.getText().length() == 0 || txtPlaca.getText().length() != 7 || txtDniConductor.getText().length() != 8){
			this.setAlwaysOnTop(false);		
			JOptionPane.showMessageDialog(null, "Ingrese los datos necesarios correctamente");
			this.setAlwaysOnTop(true);
		}
		else{
			int codsocio = Integer.parseInt(txtCodSocio.getText());
			int idempresa = cbEmpresa.getSelectedIndex() + 1;
			int dnisocio = Integer.parseInt(txtDniSocio.getText());	
			String nombresocio = txtNombreSocio	.getText();
			
			String placa = txtPlaca.getText();
			int modelo = cbModeloV.getSelectedIndex() + 1;
			String detalles = txtDetalles.getText();
			String mtc = txtMTC.getText();
			
			int dniconductor = Integer.parseInt(txtDniConductor.getText());
			String nombreconductor = txtNombreConductor.getText();
			String licencia = txtNlicencia.getText();
			
			this.setAlwaysOnTop(false);
			Consultas consulta1 = new Consultas();
			consulta1.modificarConductor(dniconductor, licencia, nombreconductor);
			
			Consultas consulta2 = new Consultas();
			consulta2.modificarVehiculo(placa, modelo, detalles, mtc);
			
			Consultas consulta = new Consultas();	
			this.setAlwaysOnTop(false);
			consulta.modificarSocio(codsocio, idempresa, dnisocio, nombresocio);
			this.dispose();
			JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");
			this.dispose();
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodSocio) 
			keyTypedTxtCodSocio(e);
		if (e.getSource() == txtDniSocio) 
			keyTypedTxtDniSocio(e);
		if (e.getSource() == txtPlaca) 
			keyTypedTxtPlaca(e);
	}
	
	protected void keyTypedTxtCodSocio(KeyEvent e) {
		if (txtCodSocio.getText().length() == 8)
			e.consume();
	}
	protected void keyTypedTxtDniSocio(KeyEvent e) {
		
		char c = e.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER))
			e.consume();
		if (txtDniSocio.getText().length() == 8)
			e.consume();
	}
	protected void keyTypedTxtNombreSocio(KeyEvent e) {
		if (txtNombreSocio.getText().length() == 50)
			e.consume();
	}
	protected void keyTypedTxtPlaca(KeyEvent e) {
		if (txtPlaca.getText().length() == 7)
			e.consume();
	}
	protected void keyTypedTxtDetalles(KeyEvent e) {
		if (txtDetalles.getText().length() == 100)
			e.consume();
	}
	protected void keyTypedTxtMTC(KeyEvent e) {
		if (txtMTC.getText().length() == 20)
			e.consume();
	}
	protected void keyTypedTxtDniConductor(KeyEvent e) {
		char c = e.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER))
			e.consume();
		if (txtDniConductor.getText().length() == 8){
			e.consume();
		}
	}
	protected void keyTypedTxtNombreConductor(KeyEvent e) {
		if (txtNombreConductor.getText().length() == 50)
			e.consume();
	}
	protected void keyTypedTxtNlicencia(KeyEvent e) {
		if (txtNlicencia.getText().length() == 20)
			e.consume();
	}
	
	protected void focusLostTxtPlaca(FocusEvent arg0) {
		//verificarPlaca();
	}
	protected void focusLostTxtDniConductor(FocusEvent e) {
		verificarConductor();
	}
	
	public void verificarConductor(){
		int dniConductor;
		if(txtDniConductor.getText().length() != 8){
			this.setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "DNI incorrecto");
			this.setAlwaysOnTop(true);
		}
		else{
			dniConductor = Integer.parseInt(txtDniConductor.getText());
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.buscarConductor(dniConductor);
			try {
				rs.next();
				txtNombreConductor.setText(rs.getString("conductor"));
				txtNlicencia.setText(rs.getString("licencia"));				
			} catch (SQLException ex) {
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "No existe el conductor, se creará uno nuevo.");
				limpiarConductor();
				this.setAlwaysOnTop(true);
			}
		}
	}
	
	public void verificarPlaca(){
		String placa;
		if(txtPlaca.getText().length() != 7){
			this.setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "Placa incorrecta");
			this.setAlwaysOnTop(true);
		}
		else{
			placa = txtPlaca.getText();
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.buscarVehiculo(placa);
			try {
				rs.next();
				txtDetalles.setText(rs.getString("detalle"));
				txtMTC.setText(rs.getString("mtc"));
				
				ResultSet rs2 = consulta.buscarModeloVehiculo(rs.getInt("idmodelo"));
				rs2.next();
				cbModeloV.setSelectedItem(rs2.getString("modelo"));
			} catch (SQLException ex) {
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "No existe el vehiculo, se creará uno nuevo.");
				limpiarVehiculo();
			}
		}
	}
	
	public void limpiarVehiculo(){
		cbModeloV.setSelectedIndex(1);
		txtDetalles.setText("");
		txtMTC.setText("");
	} 
	
	public void limpiarConductor(){
		cbModeloV.setSelectedIndex(1);
		txtNombreConductor.setText("");
		txtNlicencia.setText("");
	} 
}








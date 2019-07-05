package guiSecundarios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Conductor;
import gui.vPrincipal;
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
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Box;

public class vdSocioNuevo extends JDialog implements ActionListener, KeyListener {
	private JTextField txtAgregarVehiculo;
	private JTextField txtCodSocio;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblPlaca;
	public JComboBox <Conductor> cbVehiculoAfiliado;
	
	vPrincipal vp = null;
	viListaVehiculos vnvh = null;
	ResultSet rs;
	private JTextField txtNombreSocio;
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
	private JLabel label_4;
	private JComboBox cbConductor;
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
	
	public static void main(String[] args) {
		try {
			vdSocioNuevo dialog = new vdSocioNuevo(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vdSocioNuevo(vPrincipal temp, viListaVehiculos temp2) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		vp = temp;
		vnvh = temp2;
		
		setUndecorated(true);
		setBounds(100, 100, 724, 672);
		getContentPane().setLayout(null);
		{
			txtAgregarVehiculo = new JTextField();
			txtAgregarVehiculo.setEditable(false);
			txtAgregarVehiculo.setText("AGREGAR SOCIO");
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
			txtCodSocio.addKeyListener(this);
			txtCodSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtCodSocio.setColumns(10);
			txtCodSocio.setBounds(226, 69, 464, 25);
			getContentPane().add(txtCodSocio);
		}
		{
			JLabel lblModelo = new JLabel("Nombre:");
			lblModelo.setVerticalAlignment(SwingConstants.BOTTOM);
			lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
			lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblModelo.setBounds(70, 146, 105, 34);
			getContentPane().add(lblModelo);
		}
		{
			JLabel lblConductor = new JLabel("Veh\u00EDculo afiliado:");
			lblConductor.setVerticalAlignment(SwingConstants.BOTTOM);
			lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblConductor.setBounds(30, 209, 190, 34);
			getContentPane().add(lblConductor);
		}
		{
			cbVehiculoAfiliado = new JComboBox();
			cbVehiculoAfiliado.addActionListener(this);
			cbVehiculoAfiliado.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			cbVehiculoAfiliado.setBounds(226, 214, 393, 25);
			getContentPane().add(cbVehiculoAfiliado);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnCancelar.setBackground(new Color(0, 139, 139));
			btnCancelar.setBounds(31, 597, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			btnGuardar = new JButton("<html>Guardar</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnGuardar.setBackground(new Color(0, 139, 139));
			btnGuardar.setBounds(470, 597, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			txtNombreSocio = new JTextField();
			txtNombreSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtNombreSocio.setColumns(10);
			txtNombreSocio.setBounds(226, 155, 464, 25);
			getContentPane().add(txtNombreSocio);
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
		label.setBounds(70, 256, 95, 20);
		getContentPane().add(label);
		
		txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(226, 254, 464, 25);
		getContentPane().add(txtPlaca);
		
		cbModeloV = new JComboBox();
		cbModeloV.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbModeloV.setBounds(226, 294, 464, 25);
		getContentPane().add(cbModeloV);
		
		label_1 = new JLabel("Modelo:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_1.setBounds(70, 299, 95, 20);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("Detalles:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(70, 340, 95, 20);
		getContentPane().add(label_2);
		
		txtDetalles = new JTextField();
		txtDetalles.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDetalles.setColumns(10);
		txtDetalles.setBounds(226, 335, 464, 25);
		getContentPane().add(txtDetalles);
		
		label_3 = new JLabel("MTC:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBounds(70, 383, 95, 20);
		getContentPane().add(label_3);
		
		txtMTC = new JTextField();
		txtMTC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtMTC.setColumns(10);
		txtMTC.setBounds(226, 378, 464, 25);
		getContentPane().add(txtMTC);
		
		label_4 = new JLabel("Conductor:");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_4.setBounds(30, 447, 132, 20);
		getContentPane().add(label_4);
		
		cbConductor = new JComboBox();
		cbConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbConductor.setBounds(226, 444, 464, 25);
		getContentPane().add(cbConductor);
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblDni.setBounds(70, 481, 104, 20);
		getContentPane().add(lblDni);
		
		txtDniConductor = new JTextField();
		txtDniConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDniConductor.setEditable(false);
		txtDniConductor.setColumns(10);
		txtDniConductor.setBounds(226, 478, 464, 25);
		getContentPane().add(txtDniConductor);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNombre.setBounds(70, 516, 111, 20);
		getContentPane().add(lblNombre);
		
		txtNombreConductor = new JTextField();
		txtNombreConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNombreConductor.setEditable(false);
		txtNombreConductor.setColumns(10);
		txtNombreConductor.setBounds(226, 513, 464, 25);
		getContentPane().add(txtNombreConductor);
		
		label_7 = new JLabel("N Licencia:");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(new Color(0, 139, 139));
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_7.setEnabled(false);
		label_7.setBounds(70, 549, 132, 20);
		getContentPane().add(label_7);
		
		txtNlicencia = new JTextField();
		txtNlicencia.setForeground(new Color(0, 139, 139));
		txtNlicencia.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNlicencia.setEnabled(false);
		txtNlicencia.setColumns(10);
		txtNlicencia.setBounds(226, 547, 464, 25);
		getContentPane().add(txtNlicencia);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(22, 466, 40, 20);
		getContentPane().add(horizontalStrut);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(52, 476, 18, 110);
		getContentPane().add(verticalStrut);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(22, 238, 40, 20);
		getContentPane().add(horizontalStrut_1);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(52, 248, 18, 162);
		getContentPane().add(verticalStrut_1);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setBounds(22, 85, 40, 20);
		getContentPane().add(horizontalStrut_2);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setBounds(52, 95, 18, 91);
		getContentPane().add(verticalStrut_2);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtCodSocio, cbVehiculoAfiliado, btnCancelar, btnGuardar}));
		cargar();
	}
	
	
	public void cargar(){
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbVehiculoAfiliado) {
			actionPerformedCbConductor(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		vp.enable(true);
		this.dispose();
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		int codsocio = Integer.parseInt(txtCodSocio.getText());
		int impresa = cbEmpresa.getSelectedIndex() + 1;
		String nombresocio = txtNombreSocio.getText();
		
		String placa = txtPlaca.getText();
		int modelo = cbModeloV.getSelectedIndex() + 1;
		String detalles = txtDetalles.getText();
		String mtc = txtMTC.getText();
		
		int dniconductor = Integer.parseInt(txtDniConductor.getText());
		String nombreconductor = txtNombreConductor.getText();
		String licencia = txtNlicencia.getText();
		
				
		
	}
	
	public void selecionarVehiculo(){
		String placa = txtCodSocio.getText();
		int cantVehiculos = vnvh.tbVehiculos.getRowCount();
		for(int i = 0; i<cantVehiculos; i++){
			if(placa.equals(vnvh.tbVehiculos.getValueAt(i, 0))){
				vnvh.tbVehiculos.setRowSelectionInterval(i,i);
				break;
			}
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
	protected void actionPerformedCbConductor(ActionEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodSocio) {
			keyTypedTxtPlaca(e);
		}
	}
	protected void keyTypedTxtPlaca(KeyEvent e) {
		if (txtCodSocio.getText().length() == 7){
			e.consume();
		}
	}
}





























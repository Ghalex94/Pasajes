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

public class vdVehiculoNuevo extends JDialog implements ActionListener, KeyListener {
	private JTextField txtAgregarVehiculo;
	private JTextField txtPlaca;
	private JTextField txtDetalles;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblPlaca;
	private JComboBox cbModelo;
	public JComboBox <Conductor> cbConductor;
	private JButton btnNewConductor;
	private JLabel lblDniConductor;
	private JTextField txtDni;
	
	vPrincipal vp = null;
	viListaVehiculos vnvh = null;
	ResultSet rs;
	private JTextField txtMtc;
	private JTextField textField_1;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField_2;
	private Component verticalStrut;
	private Component horizontalStrut;
	private JLabel lblNombre;
	private JTextField txtNombreConductor;
	
	public static void main(String[] args) {
		try {
			vdVehiculoNuevo dialog = new vdVehiculoNuevo(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vdVehiculoNuevo(vPrincipal temp, viListaVehiculos temp2) {
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		vp = temp;
		vnvh = temp2;
		setBounds(100, 100, 591, 495);
		getContentPane().setLayout(null);
		{
			txtAgregarVehiculo = new JTextField();
			txtAgregarVehiculo.setEditable(false);
			txtAgregarVehiculo.setText("AGREGAR VEHICULO");
			txtAgregarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
			txtAgregarVehiculo.setForeground(Color.WHITE);
			txtAgregarVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			txtAgregarVehiculo.setColumns(10);
			txtAgregarVehiculo.setBackground(new Color(30, 144, 255));
			txtAgregarVehiculo.setBounds(0, 0, 591, 46);
			getContentPane().add(txtAgregarVehiculo);
		}
		{
			lblPlaca = new JLabel("Placa:");
			lblPlaca.setHorizontalAlignment(SwingConstants.LEFT);
			lblPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblPlaca.setBounds(30, 71, 132, 20);
			getContentPane().add(lblPlaca);
		}
		{
			txtPlaca = new JTextField();
			txtPlaca.addKeyListener(this);
			txtPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(201, 69, 362, 25);
			getContentPane().add(txtPlaca);
		}
		{
			JLabel lblModelo = new JLabel("Modelo:");
			lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
			lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblModelo.setBounds(30, 114, 132, 20);
			getContentPane().add(lblModelo);
		}
		{
			cbModelo = new JComboBox();
			cbModelo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			cbModelo.setBounds(201, 109, 362, 25);
			getContentPane().add(cbModelo);
		}
		{
			JLabel lblConductor = new JLabel("Conductor:");
			lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblConductor.setBounds(30, 236, 132, 20);
			getContentPane().add(lblConductor);
		}
		{
			cbConductor = new JComboBox();
			cbConductor.addActionListener(this);
			cbConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			cbConductor.setBounds(201, 233, 300, 25);
			getContentPane().add(cbConductor);
		}
		{
			btnNewConductor = new JButton("+");
			btnNewConductor.addActionListener(this);
			btnNewConductor.setForeground(Color.WHITE);
			btnNewConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			btnNewConductor.setBackground(new Color(50, 205, 50));
			btnNewConductor.setBounds(511, 235, 52, 23);
			getContentPane().add(btnNewConductor);
		}
		{
			txtDetalles = new JTextField();
			txtDetalles.addKeyListener(this);
			txtDetalles.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtDetalles.setColumns(10);
			txtDetalles.setBounds(201, 150, 362, 25);
			getContentPane().add(txtDetalles);
		}
		{
			JLabel lblDetalles = new JLabel("Detalles:");
			lblDetalles.setHorizontalAlignment(SwingConstants.LEFT);
			lblDetalles.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblDetalles.setBounds(30, 155, 132, 20);
			getContentPane().add(lblDetalles);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnCancelar.setBackground(new Color(0, 139, 139));
			btnCancelar.setBounds(30, 408, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			btnGuardar = new JButton("<html>Guardar</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnGuardar.setBackground(new Color(0, 139, 139));
			btnGuardar.setBounds(343, 411, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			lblDniConductor = new JLabel("DNI:");
			lblDniConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblDniConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblDniConductor.setBounds(70, 305, 73, 20);
			getContentPane().add(lblDniConductor);
		}
		{
			txtDni = new JTextField();
			txtDni.setEditable(false);
			txtDni.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtDni.setColumns(10);
			txtDni.setBounds(201, 302, 362, 25);
			getContentPane().add(txtDni);
		}
		
		JLabel lblMtc = new JLabel("MTC:");
		lblMtc.setHorizontalAlignment(SwingConstants.LEFT);
		lblMtc.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblMtc.setBounds(30, 198, 132, 20);
		getContentPane().add(lblMtc);
		
		txtMtc = new JTextField();
		txtMtc.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtMtc.setColumns(10);
		txtMtc.setBounds(201, 193, 362, 25);
		getContentPane().add(txtMtc);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setForeground(new Color(0, 139, 139));
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(201, 336, 362, 25);
		getContentPane().add(textField_1);
		
		label_1 = new JLabel("N Licencia:");
		label_1.setEnabled(false);
		label_1.setForeground(new Color(0, 139, 139));
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_1.setBounds(70, 338, 132, 20);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("Conductor:");
		label_2.setEnabled(false);
		label_2.setForeground(new Color(0, 139, 139));
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(70, 374, 132, 20);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setForeground(new Color(0, 139, 139));
		textField_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(201, 372, 362, 25);
		getContentPane().add(textField_2);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(51, 264, 18, 133);
		getContentPane().add(verticalStrut);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(21, 254, 40, 20);
		getContentPane().add(horizontalStrut);
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblNombre.setBounds(70, 270, 104, 20);
			getContentPane().add(lblNombre);
		}
		{
			txtNombreConductor = new JTextField();
			txtNombreConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtNombreConductor.setEditable(false);
			txtNombreConductor.setColumns(10);
			txtNombreConductor.setBounds(201, 267, 362, 25);
			getContentPane().add(txtNombreConductor);
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtPlaca, cbModelo, txtDetalles, cbConductor, btnNewConductor, btnCancelar, btnGuardar}));
		cargar();
	}
	
	
	public void cargar(){
		setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		
		Consultas consult = new Consultas();
		rs = consult.cargarModelosVehiculos();
		try {
			while(rs.next())
				cbModelo.addItem(rs.getString("modelo"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		
		Conductor conductor = new Conductor();
		conductor.cargarConductores(cbConductor);
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewConductor) {
			actionPerformedBtnNewConductor(e);
		}
		if (e.getSource() == cbConductor) {
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
		try {
			String placa = txtPlaca.getText();
			int modelo = cbModelo.getSelectedIndex()+1;
			String detalle = txtDetalles.getText();
			String mtc = txtMtc.getText();
			int dni = Integer.parseInt(txtDni.getText());
			if(txtPlaca.getText().length() == 0){
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Por favor, coloque el número de placa");
				txtPlaca.requestFocus();
				this.setAlwaysOnTop(true);
			}
			else{
				Consultas consulta = new Consultas();
				consulta.crearVehiculo(placa, modelo, detalle, mtc);
				this.setAlwaysOnTop(false);
				vnvh.cargar();
				selecionarVehiculo();
				JOptionPane.showMessageDialog(null, "Creado correctamente");
				vp.enable(true);
				this.dispose();
			}
		}
		catch(Exception ex){
		}
	}
	
	public void selecionarVehiculo(){
		String placa = txtPlaca.getText();
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
	//	int dni = cbConductor.getItemAt(cbConductor.getSelectedIndex()).getDni();
		txtDni.setText("" + cbConductor.getItemAt(cbConductor.getSelectedIndex()).getDni());
	}
	protected void actionPerformedBtnNewConductor(ActionEvent e) {
		viConductorNuevo vncon = new viConductorNuevo(this, null, null);
		vncon.show();
		this.setAlwaysOnTop(false);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDetalles) {
			keyTypedTxtDetalles(e);
		}
		if (e.getSource() == txtPlaca) {
			keyTypedTxtPlaca(e);
		}
	}
	protected void keyTypedTxtPlaca(KeyEvent e) {
		if (txtPlaca.getText().length() == 7){
			e.consume();
		}
	}
	protected void keyTypedTxtDetalles(KeyEvent e) {
		if (txtDetalles.getText().length() == 100){
			e.consume();
		}
	}
}





























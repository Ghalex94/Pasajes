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
	private JTextField txtPlaca;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblPlaca;
	public JComboBox <Conductor> cbConductor;
	
	vPrincipal vp = null;
	viListaVehiculos vnvh = null;
	ResultSet rs;
	private JTextField textField;
	private JLabel lblEmpresa;
	private JComboBox comboBox;
	private JLabel label;
	private JTextField textField_1;
	private JComboBox comboBox_1;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField_2;
	private JLabel label_3;
	private JTextField textField_3;
	private JLabel label_4;
	private JComboBox comboBox_2;
	private JLabel label_5;
	private JTextField textField_4;
	private JLabel label_6;
	private JTextField textField_5;
	private JLabel label_7;
	private JTextField textField_6;
	private JLabel label_8;
	private JTextField textField_7;
	private Component horizontalStrut;
	private Component verticalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_1;
	private Component horizontalStrut_2;
	private Component verticalStrut_2;
	private JTextField textField_8;
	
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
		setBounds(100, 100, 724, 726);
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
			txtPlaca = new JTextField();
			txtPlaca.addKeyListener(this);
			txtPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(226, 69, 464, 25);
			getContentPane().add(txtPlaca);
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
			cbConductor = new JComboBox();
			cbConductor.addActionListener(this);
			cbConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			cbConductor.setBounds(226, 214, 393, 25);
			getContentPane().add(cbConductor);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnCancelar.setBackground(new Color(0, 139, 139));
			btnCancelar.setBounds(31, 644, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			btnGuardar = new JButton("<html>Guardar</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnGuardar.setBackground(new Color(0, 139, 139));
			btnGuardar.setBounds(470, 644, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			textField.setColumns(10);
			textField.setBounds(226, 155, 464, 25);
			getContentPane().add(textField);
		}
		
		lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpresa.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblEmpresa.setBounds(70, 102, 105, 34);
		getContentPane().add(lblEmpresa);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		comboBox.setBounds(226, 112, 464, 25);
		getContentPane().add(comboBox);
		
		label = new JLabel("Placa:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label.setBounds(70, 256, 95, 20);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(226, 254, 464, 25);
		getContentPane().add(textField_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		comboBox_1.setBounds(226, 294, 464, 25);
		getContentPane().add(comboBox_1);
		
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
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(226, 335, 464, 25);
		getContentPane().add(textField_2);
		
		label_3 = new JLabel("MTC:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBounds(70, 383, 95, 20);
		getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(226, 378, 464, 25);
		getContentPane().add(textField_3);
		
		label_4 = new JLabel("Conductor:");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_4.setBounds(30, 447, 132, 20);
		getContentPane().add(label_4);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		comboBox_2.setBounds(226, 444, 464, 25);
		getContentPane().add(comboBox_2);
		
		label_5 = new JLabel("Nombre:");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_5.setBounds(70, 481, 104, 20);
		getContentPane().add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(226, 478, 464, 25);
		getContentPane().add(textField_4);
		
		label_6 = new JLabel("DNI:");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_6.setBounds(70, 516, 73, 20);
		getContentPane().add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(226, 513, 464, 25);
		getContentPane().add(textField_5);
		
		label_7 = new JLabel("N Licencia:");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(new Color(0, 139, 139));
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_7.setEnabled(false);
		label_7.setBounds(70, 549, 132, 20);
		getContentPane().add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 139, 139));
		textField_6.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(226, 547, 464, 25);
		getContentPane().add(textField_6);
		
		label_8 = new JLabel("Conductor:");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setForeground(new Color(0, 139, 139));
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_8.setEnabled(false);
		label_8.setBounds(70, 585, 132, 20);
		getContentPane().add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(0, 139, 139));
		textField_7.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(226, 583, 464, 25);
		getContentPane().add(textField_7);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(22, 466, 40, 20);
		getContentPane().add(horizontalStrut);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(52, 476, 18, 133);
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
		
		textField_8 = new JTextField();
		textField_8.setBounds(261, 655, 86, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtPlaca, cbConductor, btnCancelar, btnGuardar}));
		cargar();
	}
	
	
	public void cargar(){
	}
	

	public void actionPerformed(ActionEvent e) {
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
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPlaca) {
			keyTypedTxtPlaca(e);
		}
	}
	protected void keyTypedTxtPlaca(KeyEvent e) {
		if (txtPlaca.getText().length() == 7){
			e.consume();
		}
	}
}





























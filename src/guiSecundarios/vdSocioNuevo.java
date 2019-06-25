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

public class vdSocioNuevo extends JDialog implements ActionListener, KeyListener {
	private JTextField txtAgregarVehiculo;
	private JTextField txtPlaca;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblPlaca;
	public JComboBox <Conductor> cbConductor;
	private JButton btnNewConductor;
	
	vPrincipal vp = null;
	viListaVehiculos vnvh = null;
	ResultSet rs;
	private JTextField textField;
	
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
		setBounds(100, 100, 672, 287);
		getContentPane().setLayout(null);
		{
			txtAgregarVehiculo = new JTextField();
			txtAgregarVehiculo.setEditable(false);
			txtAgregarVehiculo.setText("AGREGAR SOCIO");
			txtAgregarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
			txtAgregarVehiculo.setForeground(Color.WHITE);
			txtAgregarVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			txtAgregarVehiculo.setColumns(10);
			txtAgregarVehiculo.setBackground(new Color(30, 144, 255));
			txtAgregarVehiculo.setBounds(0, 0, 672, 46);
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
			txtPlaca.setBounds(226, 69, 411, 25);
			getContentPane().add(txtPlaca);
		}
		{
			JLabel lblModelo = new JLabel("Nombre:");
			lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
			lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblModelo.setBounds(30, 114, 105, 20);
			getContentPane().add(lblModelo);
		}
		{
			JLabel lblConductor = new JLabel("Veh\u00EDculo afiliado:");
			lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblConductor.setBounds(30, 159, 190, 20);
			getContentPane().add(lblConductor);
		}
		{
			cbConductor = new JComboBox();
			cbConductor.addActionListener(this);
			cbConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			cbConductor.setBounds(226, 156, 349, 25);
			getContentPane().add(cbConductor);
		}
		{
			btnNewConductor = new JButton("+");
			btnNewConductor.addActionListener(this);
			btnNewConductor.setForeground(Color.WHITE);
			btnNewConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			btnNewConductor.setBackground(new Color(50, 205, 50));
			btnNewConductor.setBounds(585, 158, 52, 23);
			getContentPane().add(btnNewConductor);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnCancelar.setBackground(Color.DARK_GRAY);
			btnCancelar.setBounds(30, 212, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			btnGuardar = new JButton("<html>Guardar</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnGuardar.setBackground(Color.DARK_GRAY);
			btnGuardar.setBounds(417, 212, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			textField.setColumns(10);
			textField.setBounds(132, 111, 505, 25);
			getContentPane().add(textField);
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtPlaca, cbConductor, btnNewConductor, btnCancelar, btnGuardar}));
		cargar();
	}
	
	
	public void cargar(){
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
	protected void actionPerformedBtnNewConductor(ActionEvent e) {
	
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





























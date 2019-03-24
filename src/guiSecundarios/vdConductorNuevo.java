package guiSecundarios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Conductor;
import gui.vdConductor;
import mysql.Consultas;

import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vdConductorNuevo extends JDialog implements ActionListener {
	private JTextField txtAgregarConductor;
	private JLabel lblDni;
	private JTextField txtDni;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel lblConductor;
	private JTextField txtConductor;

	
	vdVehiculoNuevo vnvh = null; // Ventana nuevo vehiculo
	vdVehiculoModificar vmvh = null; // Ventana modificar vehiculo
	vdConductor cndtr = null;
	private JLabel lblNLicencia;
	private JTextField txtNlicencia;
	
	public static void main(String[] args) {
		try {
			vdConductorNuevo dialog = new vdConductorNuevo(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vdConductorNuevo(vdVehiculoNuevo temp, vdVehiculoModificar temp2, vdConductor temp3) {
		vnvh = temp;
		vmvh = temp2;
		cndtr = temp3;
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setBounds(100, 100, 559, 303);
		getContentPane().setLayout(null);
		
		txtAgregarConductor = new JTextField();
		txtAgregarConductor.setText("AGREGAR CONDUCTOR");
		txtAgregarConductor.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgregarConductor.setForeground(Color.WHITE);
		txtAgregarConductor.setFont(new Font("USAngel", Font.PLAIN, 20));
		txtAgregarConductor.setEditable(false);
		txtAgregarConductor.setColumns(10);
		txtAgregarConductor.setBackground(new Color(30, 144, 255));
		txtAgregarConductor.setBounds(0, 0, 559, 46);
		getContentPane().add(txtAgregarConductor);
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblDni.setBounds(30, 71, 132, 20);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtDni.setColumns(10);
		txtDni.setBounds(188, 69, 335, 25);
		getContentPane().add(txtDni);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(30, 236, 220, 53);
		getContentPane().add(btnCancelar);
		
		btnGuardar = new JButton("<html>Guardar</html>");
		btnGuardar.addActionListener(this);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setBounds(303, 239, 220, 53);
		getContentPane().add(btnGuardar);
		
		lblConductor = new JLabel("Conductor:");
		lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblConductor.setBounds(30, 182, 132, 20);
		getContentPane().add(lblConductor);
		
		txtConductor = new JTextField();
		txtConductor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtConductor.setColumns(10);
		txtConductor.setBounds(188, 177, 335, 25);
		getContentPane().add(txtConductor);
		
		lblNLicencia = new JLabel("N Licencia:");
		lblNLicencia.setHorizontalAlignment(SwingConstants.LEFT);
		lblNLicencia.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblNLicencia.setBounds(30, 125, 132, 20);
		getContentPane().add(lblNLicencia);
		
		txtNlicencia = new JTextField();
		txtNlicencia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtNlicencia.setColumns(10);
		txtNlicencia.setBounds(188, 123, 335, 25);
		getContentPane().add(txtNlicencia);
		cargar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}
	
	public void cargar(){
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		if(vnvh != null){
			vnvh.setVisible(true);
			vnvh.setAlwaysOnTop(true);
		}
		if(cndtr != null){
			cndtr.setVisible(true);
			cndtr.setAlwaysOnTop(true);
		}
		this.dispose();
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		try {			
			int dni = Integer.parseInt(txtDni.getText());
			String nlicencia = txtNlicencia.getText();
			String nomconductor = txtConductor.getText();
			
			if(txtDni.getText().length() == 0 || txtNlicencia.getText().length() == 0 || txtConductor.getText().length() == 0){
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Por favor, complete los datos");
				this.setAlwaysOnTop(true);
			}
			else{
				this.setAlwaysOnTop(false);
				Consultas.crearConductor(dni, nlicencia, nomconductor);
				Conductor conductor = new Conductor(dni, nlicencia, nomconductor);
				if(vnvh != null){
					vnvh.cbConductor.addItem(conductor);
					int cantitems = vnvh.cbConductor.getItemCount();
					vnvh.cbConductor.setSelectedIndex(cantitems-1);
					vnvh.setVisible(true);
					vnvh.setAlwaysOnTop(true);
				}
				if(vmvh != null){
					vmvh.cbConductor.addItem(conductor);
					int cantitems = vmvh.cbConductor.getItemCount();
					vmvh.cbConductor.setSelectedIndex(cantitems-1);
					vmvh.setVisible(true);
					vmvh.setAlwaysOnTop(true);
				}
				if(cndtr != null){
					cndtr.cbConductor.addItem(conductor);
					int cantitems = cndtr.cbConductor.getItemCount();
					cndtr.cbConductor.setSelectedIndex(cantitems-1);
					cndtr.setVisible(true);
					cndtr.setAlwaysOnTop(true);
				}
				this.dispose();
			}
		}
		catch(Exception ex){
		}
		
		
	}
}



















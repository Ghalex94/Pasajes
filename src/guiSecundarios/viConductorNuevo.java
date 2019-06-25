package guiSecundarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Conductor;
import gui.vdConductor;
import mysql.Consultas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class viConductorNuevo extends JInternalFrame implements ActionListener, KeyListener {
	private JTextField textField;
	private JLabel label;
	private JTextField txtDni;
	private JTextField txtNlicencia;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtConductor;
	private JButton btnCancelar;
	private JButton btnGuardar;

	vdVehiculoNuevo vnvh = null; // Ventana nuevo vehiculo
	vdVehiculoModificar vmvh = null; // Ventana modificar vehiculo
	vdConductor cndtr = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viConductorNuevo frame = new viConductorNuevo(null, null, null);
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
	public viConductorNuevo(vdVehiculoNuevo temp, vdVehiculoModificar temp2, vdConductor temp3) {
		vnvh = temp;
		vmvh = temp2;
		cndtr = temp3;
		
		setBounds(100, 100, 574, 340);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setText("AGREGAR CONDUCTOR");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(0, 139, 139));
		textField.setBounds(0, 0, 559, 46);
		getContentPane().add(textField);
		
		label = new JLabel("DNI:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label.setBounds(30, 71, 132, 20);
		getContentPane().add(label);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDni.setColumns(10);
		txtDni.setBounds(188, 69, 335, 25);
		getContentPane().add(txtDni);
		
		txtNlicencia = new JTextField();
		txtNlicencia.addKeyListener(this);
		txtNlicencia.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNlicencia.setColumns(10);
		txtNlicencia.setBounds(188, 123, 335, 25);
		getContentPane().add(txtNlicencia);
		
		label_1 = new JLabel("N Licencia:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_1.setBounds(30, 125, 132, 20);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("Conductor:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(30, 182, 132, 20);
		getContentPane().add(label_2);
		
		txtConductor = new JTextField();
		txtConductor.addKeyListener(this);
		txtConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtConductor.setColumns(10);
		txtConductor.setBounds(188, 177, 335, 25);
		getContentPane().add(txtConductor);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnCancelar.setBackground(new Color(0, 139, 139));
		btnCancelar.setBounds(30, 236, 220, 53);
		getContentPane().add(btnCancelar);
		
		btnGuardar = new JButton("<html>Guardar</html>");
		btnGuardar.addActionListener(this);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnGuardar.setBackground(new Color(0, 139, 139));
		btnGuardar.setBounds(303, 239, 220, 53);
		getContentPane().add(btnGuardar);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		try {			
			int dni = Integer.parseInt(txtDni.getText());
			String nlicencia = txtNlicencia.getText();
			String nomconductor = txtConductor.getText();
			
			if(txtDni.getText().length() == 0 || txtNlicencia.getText().length() == 0 || txtConductor.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Por favor, complete los datos");
			}
			else{
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
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		if(vnvh != null){
			vnvh.setVisible(true);
			vnvh.setAlwaysOnTop(true);
			vnvh.setEnabled(true);
		}
		if(cndtr != null){
			cndtr.setVisible(true);
			cndtr.setAlwaysOnTop(true);
			cndtr.setEnabled(true);
		}
		if(vmvh != null){
			vmvh.setVisible(true);
			vmvh.setAlwaysOnTop(true);
			vmvh.setEnabled(true);
		}
		this.dispose();
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtConductor) {
			keyTypedTxtConductor(arg0);
		}
		if (arg0.getSource() == txtNlicencia) {
			keyTypedTxtNlicencia(arg0);
		}
		if (arg0.getSource() == txtDni) {
			keyTypedTxtDni(arg0);
		}
	}
	protected void keyTypedTxtDni(KeyEvent e) {
		char c = e.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER)){
			e.consume();
		}
		if (txtDni.getText().length() == 8){
			e.consume();
		}
	}
	protected void keyTypedTxtNlicencia(KeyEvent e) {
		if (txtNlicencia.getText().length() == 30){
			e.consume();
		}
	}
	protected void keyTypedTxtConductor(KeyEvent e) {
		if (txtConductor.getText().length() == 50){
			e.consume();
		}
	}
}

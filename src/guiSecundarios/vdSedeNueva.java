package guiSecundarios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Conductor;
import gui.vPrincipal;
import gui.vdConductor;
import gui.viListaSedes;
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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class vdSedeNueva extends JDialog implements ActionListener, KeyListener {
	private JTextField txtAgregarDestino;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel lblConductor;
	private JTextField txtDestino;

	vPrincipal vp = null;
	viListaSedes ldest = null;
	
	public static void main(String[] args) {
		try {
			vdSedeNueva dialog = new vdSedeNueva(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vdSedeNueva(vPrincipal temp, viListaSedes temp2) {
		vp = temp;
		ldest = temp2;
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setBounds(100, 100, 559, 253);
		getContentPane().setLayout(null);
		
		txtAgregarDestino = new JTextField();
		txtAgregarDestino.setText("AGREGAR SEDE");
		txtAgregarDestino.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgregarDestino.setForeground(Color.WHITE);
		txtAgregarDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		txtAgregarDestino.setEditable(false);
		txtAgregarDestino.setColumns(10);
		txtAgregarDestino.setBackground(new Color(0, 139, 139));
		txtAgregarDestino.setBounds(0, 0, 559, 46);
		getContentPane().add(txtAgregarDestino);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnCancelar.setBackground(new Color(0, 139, 139));
		btnCancelar.setBounds(30, 179, 220, 53);
		getContentPane().add(btnCancelar);
		
		btnGuardar = new JButton("<html>Guardar</html>");
		btnGuardar.addActionListener(this);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnGuardar.setBackground(new Color(0, 139, 139));
		btnGuardar.setBounds(303, 182, 220, 53);
		getContentPane().add(btnGuardar);
		
		lblConductor = new JLabel("Sede:");
		lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblConductor.setBounds(30, 98, 132, 20);
		getContentPane().add(lblConductor);
		
		txtDestino = new JTextField();
		txtDestino.addKeyListener(this);
		txtDestino.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDestino.setColumns(10);
		txtDestino.setBounds(119, 93, 404, 25);
		getContentPane().add(txtDestino);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtDestino, btnGuardar, btnCancelar}));
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
		vp.setEnabled(true);
		this.dispose();
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		try {
			String sede = txtDestino.getText();
			if(txtDestino.getText().length() == 0){
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Por favor, ingrese sede");
				this.setAlwaysOnTop(true);
			}
			else{
				Consultas.crearSede(sede);
				this.setAlwaysOnTop(false);
				ldest.cargar();
				selecionarSede();
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Creado correctamente");
				vp.enable(true);
				this.dispose();
			}
		}
		catch(Exception ex){
		}
	}
	
	public void selecionarSede(){
		String sede = txtDestino.getText();
		int cantDestinos = ldest.tbDestinos.getRowCount();
		for(int i = 0; i<cantDestinos; i++){
			if(sede.equals(ldest.tbDestinos.getValueAt(i, 1))){
				ldest.tbDestinos.setRowSelectionInterval(i,i);
				break;
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDestino) {
			keyTypedTxtDestino(e);
		}
	}
	protected void keyTypedTxtDestino(KeyEvent e) {
		if (txtDestino.getText().length() == 50){
			e.consume();
		}
		
	}
}



















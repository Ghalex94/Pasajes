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
import gui.viListaDestinos;
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

public class vdDestinoNuevo extends JDialog implements ActionListener, KeyListener {
	private JTextField txtAgregarDestino;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel lblConductor;
	private JTextField txtDestino;

	vPrincipal vp = null;
	viListaDestinos ldest = null;
	
	public static void main(String[] args) {
		try {
			vdDestinoNuevo dialog = new vdDestinoNuevo(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vdDestinoNuevo(vPrincipal temp, viListaDestinos temp2) {
		vp = temp;
		ldest = temp2;
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setBounds(100, 100, 559, 253);
		getContentPane().setLayout(null);
		
		txtAgregarDestino = new JTextField();
		txtAgregarDestino.setText("AGREGAR DESTINO");
		txtAgregarDestino.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgregarDestino.setForeground(Color.WHITE);
		txtAgregarDestino.setFont(new Font("USAngel", Font.PLAIN, 20));
		txtAgregarDestino.setEditable(false);
		txtAgregarDestino.setColumns(10);
		txtAgregarDestino.setBackground(new Color(30, 144, 255));
		txtAgregarDestino.setBounds(0, 0, 559, 46);
		getContentPane().add(txtAgregarDestino);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(30, 179, 220, 53);
		getContentPane().add(btnCancelar);
		
		btnGuardar = new JButton("<html>Guardar</html>");
		btnGuardar.addActionListener(this);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setBounds(303, 182, 220, 53);
		getContentPane().add(btnGuardar);
		
		lblConductor = new JLabel("Destino:");
		lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblConductor.setBounds(30, 98, 132, 20);
		getContentPane().add(lblConductor);
		
		txtDestino = new JTextField();
		txtDestino.addKeyListener(this);
		txtDestino.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtDestino.setColumns(10);
		txtDestino.setBounds(188, 93, 335, 25);
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
			String destino = txtDestino.getText();
			if(txtDestino.getText().length() == 0){
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Por favor, ingrese destino");
				this.setAlwaysOnTop(true);
			}
			else{
				Consultas.crearDestino(destino);
				this.setAlwaysOnTop(false);
				ldest.cargar();
				selecionarDestino();
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "Creado correctamente");
				vp.enable(true);
				this.dispose();
			}
		}
		catch(Exception ex){
		}
	}
	
	public void selecionarDestino(){
		String destino = txtDestino.getText();
		int cantDestinos = ldest.tbDestinos.getRowCount();
		for(int i = 0; i<cantDestinos; i++){
			if(destino.equals(ldest.tbDestinos.getValueAt(i, 1))){
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



















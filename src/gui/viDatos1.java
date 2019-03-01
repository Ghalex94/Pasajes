package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import clases.Conductor;
import clases.Vehiculo;
import mysql.Consultas;

import java.awt.Color;

public class viDatos1 extends JInternalFrame implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblVehiculo;
	private JButton btnContinuar;
	private JComboBox cbEmpresa;
	private JComboBox <Vehiculo> cbVehiculo;
	
	vPrincipal  vp = null;
	ResultSet rs;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viDatos1 frame = new viDatos1(null);
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
	public viDatos1(vPrincipal temp) {
		setTitle("SELECCIONE");
		vp = temp;
		setBounds(100, 100, 489, 237);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Empresa:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblNewLabel.setBounds(35, 49, 132, 20);
		getContentPane().add(lblNewLabel);
		
		lblVehiculo = new JLabel("Vehiculo:");
		lblVehiculo.setHorizontalAlignment(SwingConstants.LEFT);
		lblVehiculo.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblVehiculo.setBounds(35, 112, 132, 20);
		getContentPane().add(lblVehiculo);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnContinuar.addActionListener(this);
		btnContinuar.setBounds(162, 153, 282, 31);
		getContentPane().add(btnContinuar);
		
		cbEmpresa = new JComboBox();
		cbEmpresa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbEmpresa.setModel(new DefaultComboBoxModel(new String[] {"MERMA HERMANOS S.R.L", "ZIGUEL E.I.R.L"}));
		cbEmpresa.setBounds(162, 49, 282, 23);
		getContentPane().add(cbEmpresa);
		
		cbVehiculo = new JComboBox();
		cbVehiculo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbVehiculo.setBounds(162, 109, 282, 23);
		getContentPane().add(cbVehiculo);
		cargar();
	}
	
	public void cargar(){
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.cargarVehiculo(cbVehiculo);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnContinuar) {
			actionPerformedBtnContinuar(e);
		}
	}
	protected void actionPerformedBtnContinuar(ActionEvent e) {
		
		int modelo = cbVehiculo.getItemAt(cbVehiculo.getSelectedIndex()).getIdmodelo();
		vp.esconderVentanas();
		switch(modelo){
		case 1:
			vp.sa1.show();
			try{
				vp.sa1.setMaximum(true);
			}catch(Exception f){}
			break;
		case 2:
			vp.sa2.show();
			try{
				vp.sa2.setMaximum(true);
			}catch(Exception f){}
			break;
		case 3:
			vp.sa3.show();
			try{
				vp.sa3.setMaximum(true);
			}catch(Exception f){}
			break;
		case 4:
			vp.sa4.show();
			try{
				vp.sa4.setMaximum(true);
			}catch(Exception f){}
			break;
		}
		vp.mntmCrearNuevaSalida.setEnabled(false);
		vp.mntmContinuarPreparacion.setEnabled(true);
		vp.mntmCancelarSalida.setEnabled(true);
	}
}

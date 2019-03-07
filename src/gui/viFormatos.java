package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import clases.Conductor;
import clases.Vehiculo;
import guiSecundarios.vfManifiestoPas;
import mysql.Consultas;

import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class viFormatos extends JInternalFrame implements ActionListener {
	private JLabel lblNewLabel;
	private JButton btnLlenarMP;
	private JButton btnCancelar;
	private JButton btnImprimirMP;
	private JTextField txtFormatos;
	
	vPrincipal  vp = null;
	viSeleccionAsientos1 vsa1 = null;
	ResultSet rs;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viFormatos frame = new viFormatos(null, null);
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
	public viFormatos(vPrincipal temp, viSeleccionAsientos1 temp2) {
		
		vp = temp;
		vsa1 = temp2;
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("SELECCIONE");
		
		setBounds(100, 100, 667, 448);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Manifiesto de pasajeros:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		lblNewLabel.setBounds(35, 75, 606, 20);
		getContentPane().add(lblNewLabel);
		
		btnLlenarMP = new JButton("LLenar");
		btnLlenarMP.setForeground(Color.WHITE);
		btnLlenarMP.setBackground(Color.DARK_GRAY);
		btnLlenarMP.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnLlenarMP.addActionListener(this);
		btnLlenarMP.setBounds(35, 106, 229, 31);
		getContentPane().add(btnLlenarMP);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(218, 376, 221, 31);
		getContentPane().add(btnCancelar);
		
		btnImprimirMP = new JButton("Imprimir");
		btnImprimirMP.addActionListener(this);
		btnImprimirMP.setForeground(Color.WHITE);
		btnImprimirMP.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnImprimirMP.setBackground(Color.DARK_GRAY);
		btnImprimirMP.setBounds(363, 106, 229, 31);
		getContentPane().add(btnImprimirMP);
		
		txtFormatos = new JTextField();
		txtFormatos.setText("FORMATOS");
		txtFormatos.setHorizontalAlignment(SwingConstants.CENTER);
		txtFormatos.setForeground(Color.WHITE);
		txtFormatos.setFont(new Font("USAngel", Font.PLAIN, 20));
		txtFormatos.setEditable(false);
		txtFormatos.setColumns(10);
		txtFormatos.setBackground(new Color(30, 144, 255));
		txtFormatos.setBounds(0, 0, 658, 68);
		getContentPane().add(txtFormatos);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnLlenarMP, btnCancelar}));
		cargar();
	}
	
	public void cargar(){
		Vehiculo vehiculo = new Vehiculo();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImprimirMP) {
			actionPerformedBtnImprimirMP(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnLlenarMP) {
			actionPerformedBtnLlenarMP(e);
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e){		
		this.setVisible(false);
		vp.esconderVentanas();
		vp.cerrarVentanas();
	}
	
	protected void actionPerformedBtnLlenarMP(ActionEvent e) {
		vfManifiestoPas vfmp = new vfManifiestoPas();
		vfmp.setVisible(true);
	}
	protected void actionPerformedBtnImprimirMP(ActionEvent e) {
		
	}
	
}

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
	private JLabel label;
	private JButton button;
	private JButton button_1;
	private JLabel label_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel label_2;
	private JButton button_4;
	private JButton button_5;
	
	
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
		
		label = new JLabel("Manifiesto de pasajeros:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label.setBounds(35, 148, 606, 20);
		getContentPane().add(label);
		
		button = new JButton("LLenar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("USAngel", Font.PLAIN, 20));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(35, 179, 229, 31);
		getContentPane().add(button);
		
		button_1 = new JButton("Imprimir");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("USAngel", Font.PLAIN, 20));
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setBounds(363, 179, 229, 31);
		getContentPane().add(button_1);
		
		label_1 = new JLabel("Manifiesto de pasajeros:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_1.setBounds(45, 221, 606, 20);
		getContentPane().add(label_1);
		
		button_2 = new JButton("LLenar");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("USAngel", Font.PLAIN, 20));
		button_2.setBackground(Color.DARK_GRAY);
		button_2.setBounds(45, 252, 229, 31);
		getContentPane().add(button_2);
		
		button_3 = new JButton("Imprimir");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("USAngel", Font.PLAIN, 20));
		button_3.setBackground(Color.DARK_GRAY);
		button_3.setBounds(373, 252, 229, 31);
		getContentPane().add(button_3);
		
		label_2 = new JLabel("Manifiesto de pasajeros:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("EngraversGothic BT", Font.PLAIN, 25));
		label_2.setBounds(35, 294, 606, 20);
		getContentPane().add(label_2);
		
		button_4 = new JButton("LLenar");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("USAngel", Font.PLAIN, 20));
		button_4.setBackground(Color.DARK_GRAY);
		button_4.setBounds(35, 325, 229, 31);
		getContentPane().add(button_4);
		
		button_5 = new JButton("Imprimir");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("USAngel", Font.PLAIN, 20));
		button_5.setBackground(Color.DARK_GRAY);
		button_5.setBounds(363, 325, 229, 31);
		getContentPane().add(button_5);
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

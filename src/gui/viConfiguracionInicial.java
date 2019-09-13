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
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Conductor;
import clases.Empresa;
import clases.Sedes;
import clases.Socio;
import clases.Vehiculo;
import mysql.Consultas;

import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class viConfiguracionInicial extends JInternalFrame implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblVehiculo;
	private JButton btnContinuar;
	
	vPrincipal  vp = null;
	private JButton btnCancelar;
	private JLabel lblPrecioDePasaje;
	private JTextField txtNAsientoInicial;
	private JLabel lblNewLabel_1;
	private JLabel lblConductor;
	private JTextField txtNViajeInicial;
	private JTextField txtNSerie;
	private JComboBox <Sedes> cbSedes ;
	int tipo = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viConfiguracionInicial frame = new viConfiguracionInicial(null, 0);
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
	public viConfiguracionInicial(vPrincipal temp, int temp2) {
		tipo = temp2;
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("SELECCIONE");
		vp = temp;
		setBounds(100, 100, 594, 356);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Sede");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 78, 271, 31);
		getContentPane().add(lblNewLabel);
		
		lblVehiculo = new JLabel("N\u00FAmero de Viaje Inicial");
		lblVehiculo.setHorizontalAlignment(SwingConstants.LEFT);
		lblVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblVehiculo.setBounds(34, 181, 270, 20);
		getContentPane().add(lblVehiculo);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBackground(new Color(0, 139, 139));
		btnContinuar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnContinuar.addActionListener(this);
		btnContinuar.setBounds(326, 280, 238, 31);
		getContentPane().add(btnContinuar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnCancelar.setBackground(new Color(0, 139, 139));
		btnCancelar.setBounds(111, 280, 190, 31);
		getContentPane().add(btnCancelar);
		
		lblPrecioDePasaje = new JLabel("N\u00FAmero de Asiento Inicial:");
		lblPrecioDePasaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioDePasaje.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPrecioDePasaje.setBounds(34, 222, 270, 31);
		getContentPane().add(lblPrecioDePasaje);
		
		txtNAsientoInicial = new JTextField();
		txtNAsientoInicial.setHorizontalAlignment(SwingConstants.LEFT);
		txtNAsientoInicial.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNAsientoInicial.setColumns(10);
		txtNAsientoInicial.setBounds(326, 224, 238, 25);
		getContentPane().add(txtNAsientoInicial);
		
		lblNewLabel_1 = new JLabel("Llene los siguientes datos");
		lblNewLabel_1.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		lblNewLabel_1.setBounds(34, 21, 455, 31);
		getContentPane().add(lblNewLabel_1);
		
		lblConductor = new JLabel("N\u00FAmero de serie:");
		lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblConductor.setBounds(34, 134, 270, 20);
		getContentPane().add(lblConductor);
		
		txtNViajeInicial = new JTextField();
		txtNViajeInicial.setHorizontalAlignment(SwingConstants.LEFT);
		txtNViajeInicial.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNViajeInicial.setColumns(10);
		txtNViajeInicial.setBounds(326, 176, 238, 25);
		getContentPane().add(txtNViajeInicial);
		
		txtNSerie = new JTextField();
		txtNSerie.setHorizontalAlignment(SwingConstants.LEFT);
		txtNSerie.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNSerie.setColumns(10);
		txtNSerie.setBounds(326, 131, 238, 25);
		getContentPane().add(txtNSerie);
		
		cbSedes = new JComboBox();
		cbSedes.setBounds(326, 85, 238, 25);
		getContentPane().add(cbSedes);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNSerie, txtNViajeInicial, txtNAsientoInicial, btnContinuar, btnCancelar}));
		cargar();
	}
	
	public void cargar(){
		Sedes sedes = new Sedes();
		sedes.cargarDestinos(cbSedes);
		
		if(tipo == 2){
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.cargarConfiguracionInicial();
			try {
				rs.next();
				txtNSerie.setText(rs.getString("nserie"));
				txtNAsientoInicial.setText(rs.getString("nboletoinicial"));
				txtNViajeInicial.setText(rs.getString("nviajeinicial"));
				
				int nsede = rs.getInt("sede");
				
				ResultSet rs2 = consulta.buscarSede(nsede);
				try {
					rs2.next();
					String sede = rs2.getString("sede");					
					for(int i = 0; i < cbSedes.getItemCount(); i++){
						if(sede.equals(cbSedes.getItemAt(i).toString())){
							cbSedes.setSelectedIndex(i);							
						}					
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al cargar sede " + e);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar Configuracion inicial: " + e);
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnContinuar) {
			actionPerformedBtnContinuar(e);
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e){		
		this.setVisible(false);
		vp.esconderVentanas();
		vp.cerrarVentanas();
	}
	
	protected void actionPerformedBtnContinuar(ActionEvent e) {
		if(txtNSerie.getText().length() <=0 || txtNSerie.getText().length() <=0 || txtNViajeInicial.getText().length() <=0 || txtNAsientoInicial.getText().length() <=0)
			JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
		else{
			int idsede = cbSedes.getItemAt(cbSedes.getSelectedIndex()).getIdsede();
			int nserie = Integer.parseInt(txtNSerie.getText());
			int nviajeinicial = Integer.parseInt(txtNViajeInicial.getText());
			int nasientoinicial = Integer.parseInt(txtNAsientoInicial.getText());			
			
			Consultas consulta = new Consultas();
			consulta.actualizarConfiguracionInicial(idsede, nserie, nviajeinicial, nasientoinicial);
			this.hide();
			vp.esconderVentanas();
			vp.cerrarVentanas();
			if(tipo == 0)
				vp.cargar();
		}
	}
}

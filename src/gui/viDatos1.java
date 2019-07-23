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

public class viDatos1 extends JInternalFrame implements ActionListener, KeyListener {
	private JLabel lblNewLabel;
	private JLabel lblVehiculo;
	private JButton btnContinuar;
	private JComboBox <Empresa> cbEmpresa;
	private JComboBox <Vehiculo> cbVehiculo;
	private JComboBox <Conductor> cbConductor;
	
	vPrincipal  vp = null;
	private JButton btnCancelar;
	private JLabel lblPrecioDePasaje;
	private JTextField txtPrePasaje;
	private JLabel label;
	private JLabel lblCdigoDeSocio;
	private JLabel lblNewLabel_1;
	private JLabel lblConductor;
	private JComboBox cbSocio;
	
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
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("SELECCIONE");
		vp = temp;
		setBounds(100, 100, 863, 374);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Empresa:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 123, 132, 31);
		getContentPane().add(lblNewLabel);
		
		lblVehiculo = new JLabel("Vehiculo:");
		lblVehiculo.setHorizontalAlignment(SwingConstants.LEFT);
		lblVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblVehiculo.setBounds(34, 226, 132, 20);
		getContentPane().add(lblVehiculo);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setEnabled(false);
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBackground(new Color(0, 139, 139));
		btnContinuar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnContinuar.addActionListener(this);
		btnContinuar.setBounds(589, 267, 212, 31);
		getContentPane().add(btnContinuar);
		
		cbEmpresa = new JComboBox();
		cbEmpresa.setEnabled(false);
		cbEmpresa.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbEmpresa.setBounds(226, 126, 575, 25);
		getContentPane().add(cbEmpresa);
		
		cbVehiculo = new JComboBox();
		cbVehiculo.setEnabled(false);
		cbVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbVehiculo.setBounds(227, 223, 574, 25);
		getContentPane().add(cbVehiculo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		btnCancelar.setBackground(new Color(0, 139, 139));
		btnCancelar.setBounds(389, 267, 190, 31);
		getContentPane().add(btnCancelar);
		
		lblPrecioDePasaje = new JLabel("Precio de pasaje:");
		lblPrecioDePasaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioDePasaje.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPrecioDePasaje.setBounds(34, 267, 182, 31);
		getContentPane().add(lblPrecioDePasaje);
		
		txtPrePasaje = new JTextField();
		txtPrePasaje.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrePasaje.addKeyListener(this);
		txtPrePasaje.setText("25");
		txtPrePasaje.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtPrePasaje.setColumns(10);
		txtPrePasaje.setBounds(227, 271, 52, 25);
		getContentPane().add(txtPrePasaje);
		
		label = new JLabel(".00");
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label.setBounds(282, 273, 52, 25);
		getContentPane().add(label);
		
		lblCdigoDeSocio = new JLabel("C\u00F3digo de socio:");
		lblCdigoDeSocio.setHorizontalAlignment(SwingConstants.LEFT);
		lblCdigoDeSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblCdigoDeSocio.setBounds(34, 74, 182, 31);
		getContentPane().add(lblCdigoDeSocio);
		
		lblNewLabel_1 = new JLabel("Complete el siguiente formulario");
		lblNewLabel_1.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
		lblNewLabel_1.setBounds(34, 21, 455, 31);
		getContentPane().add(lblNewLabel_1);
		
		lblConductor = new JLabel("Conductor:");
		lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblConductor.setBounds(34, 179, 132, 20);
		getContentPane().add(lblConductor);
		
		cbConductor = new JComboBox();
		cbConductor.setEnabled(false);
		cbConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbConductor.setBounds(227, 176, 574, 25);
		getContentPane().add(cbConductor);
		
		cbSocio = new JComboBox();
		cbSocio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				itemStateChangedCbSocio(arg0);
			}
		});
		cbSocio.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE SOCIO"}));
		cbSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbSocio.setBounds(225, 80, 576, 25);
		getContentPane().add(cbSocio);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cbSocio, cbConductor, cbVehiculo, txtPrePasaje, btnContinuar, btnCancelar}));
		cargar();
	}
	
	public void cargar(){
		
		Socio socio = new Socio();
		socio.cargarSocio(cbSocio);
		
		Empresa empresa = new Empresa();
		empresa.cargarEmpresas(cbEmpresa);
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.cargarVehiculo(cbVehiculo);
		
		Conductor conductor = new Conductor();
		conductor.cargarConductores(cbConductor);
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
		if(txtPrePasaje.getText().length() <=0)
			JOptionPane.showMessageDialog(null, "Ingrese el precio del pasaje");
		else{
			int empresa = 0;
			empresa = cbEmpresa.getItemAt(cbEmpresa.getSelectedIndex()).getIdempresa(); //1MERMA  2SIGUEL
			//JOptionPane.showMessageDialog(null, ""+empresa);
			String placa = cbVehiculo.getItemAt(cbVehiculo.getSelectedIndex()).getPlaca();
			int idmodelovh = cbVehiculo.getItemAt(cbVehiculo.getSelectedIndex()).getIdmodelo();
			String modelovh = cbVehiculo.getItemAt(cbVehiculo.getSelectedIndex()).getModelo();
			int dniconductor = cbConductor.getItemAt(cbConductor.getSelectedIndex()).getDni();
			float prepasaje = Float.parseFloat(txtPrePasaje.getText());
			Consultas consulta = new Consultas();
			consulta.actualizarVentaTemporal01(1, empresa, dniconductor, placa, idmodelovh, prepasaje);
			vp.mntmCrearNuevaSalida.setEnabled(false);
			vp.mntmContinuarPreparacion.setEnabled(true);
			vp.mntmCancelarSalida.setEnabled(true);
			vp.mnFormatos.setEnabled(true);

			vp.esconderVentanas();
			vp.cerrarVentanas();
			
			switch(idmodelovh){
			case 1:
				vp.sa1 = new viSeleccionAsientos1(vp);		// Mercedes Sprinter 413 19+1 Asientos
				vp.desktopPane.add(vp.sa1);
				vp.sa1.show();
				vp.sa1.txtTitulo.setText(modelovh);
				try{
					vp.sa1.setMaximum(true);
				}catch(Exception f){}
				break;
			case 2:
				vp.sa1 = new viSeleccionAsientos1(vp);     // Mercedes sprinter 515 19+1 				
				vp.desktopPane.add(vp.sa1);
				vp.sa1.show();
				vp.sa1.txtTitulo.setText(modelovh);
				Image imBanner = new ImageIcon(this.getClass().getResource("/mv02.png")).getImage();
				vp.sa1.lblBanner.setIcon(new ImageIcon(imBanner));
				try{
					vp.sa1.setMaximum(true);
				}catch(Exception f){}
				break;
			case 3:
				vp.sa2 = new viSeleccionAsientos2(vp);     // Mercedes sprinter 515 20+1				
				vp.desktopPane.add(vp.sa2);
				vp.sa2.show();
				vp.sa2.txtTitulo.setText(modelovh);
				try{
					vp.sa2.setMaximum(true);
				}catch(Exception f){}
				break;
			case 4:
				vp.sa3 = new viSeleccionAsientos3(vp);    // Renault 2012 15
				vp.desktopPane.add(vp.sa3);
				vp.sa3.show();
				vp.sa3.txtTitulo.setText(modelovh);
				try{
					vp.sa3.setMaximum(true);
				}catch(Exception f){}
				break;
			case 5:
				vp.sa4 = new viSeleccionAsientos4(vp);     // Renault master moderna
				vp.desktopPane.add(vp.sa4);
				vp.sa4.show();
				vp.sa4.txtTitulo.setText(modelovh);
				try{
					vp.sa4.setMaximum(true);
				}catch(Exception f){}
				break;
			case 6:
				vp.sa2 = new viSeleccionAsientos2(vp);     // Wolskwagen Crafter
				vp.desktopPane.add(vp.sa2);
				vp.sa2.show();
				vp.sa2.txtTitulo.setText(modelovh);
				Image imBanner2 = new ImageIcon(this.getClass().getResource("/mv06.png")).getImage();
				vp.sa2.lblBanner.setIcon(new ImageIcon(imBanner2));
				try{
					vp.sa2.setMaximum(true);
				}catch(Exception f){}
				break;
			}
			
		}
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtPrePasaje) {
			keyTypedTxtPrePasaje(arg0);
		}
	}
	protected void keyTypedTxtPrePasaje(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE)){
			arg0.consume();
		}
		if (txtPrePasaje.getText().length() == 4){
			arg0.consume();
		}
	}
	protected void itemStateChangedCbSocio(ItemEvent arg0) {
		if(cbSocio.getSelectedIndex() == 0){
			cbConductor.setEnabled(false);
			cbVehiculo.setEnabled(false);
			btnContinuar.setEnabled(false);
		}
		else{
			cbVehiculo.setEnabled(true);
			cbConductor.setEnabled(true);
			btnContinuar.setEnabled(true);
			Consultas consult = new Consultas();
			ResultSet rs;
			rs = consult.buscarSocio(Integer.parseInt(cbSocio.getSelectedItem().toString()));
			try {
				rs.next();
				if(rs.getInt("idempresa") == 1)
					cbEmpresa.setSelectedIndex(0);
				if(rs.getInt("idempresa") == 2)
					cbEmpresa.setSelectedIndex(1);
				
				int dniconductor = rs.getInt("dniconductor");
				String placa = rs.getString("placa");
				String modelovehiculo = null;
	
				ResultSet rs2 = consult.buscarVehiculo(placa);
				try {
					rs2.next();
					int idmodelovehiculo = rs2.getInt("idmodelo");
					
					ResultSet rs3 = consult.buscarModeloVehiculo(idmodelovehiculo);
					try {
						rs3.next();
						modelovehiculo = rs3.getString("modelo");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "ERROR Modelo Vehiculo: " + e);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERROR Vehiculo: " + e);
				}
				String temp = placa + " (" + modelovehiculo + ")";
				for(int i = 0; i<cbVehiculo.getItemCount(); i++){
					if(temp.equals(cbVehiculo.getItemAt(i).toString())){
						cbVehiculo.setSelectedIndex(i);		
					}
				}
				
				ResultSet rs4 = consult.buscarConductor(dniconductor);
				try {
					rs4.next();
					for(int i = 0; i<cbConductor.getItemCount(); i++){
						if(rs4.getString("conductor").toString().equals(cbConductor.getItemAt(i).toString())){
							cbConductor.setSelectedIndex(i);		
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERROR Conductor: " + e);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR: " + e);
			}	
		}
	}
}

package guiSecundarios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import clases.Conductor;
import clases.Empresa;
import gui.vPrincipal;
import gui.viListaSocios;
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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;

public class vdSocioNuevo extends JDialog implements ActionListener, KeyListener {
	private JTextField txtAgregarVehiculo;
	private JTextField txtCodSocio;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblPlaca;
	private JTextField txtDniSocio;
	private JLabel lblEmpresa;
	private JComboBox cbEmpresa;
	private JLabel label;
	private JTextField txtPlaca;
	private JComboBox cbModeloV;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtDetalles;
	private JLabel label_3;
	private JTextField txtMTC;
	private JLabel lblConductor_1;
	private JLabel lblDniConductor;
	private JTextField txtDniConductor;
	private JLabel lblNombreConductor;
	private JTextField txtNombreConductor;
	private JLabel lblNlicenciaConductor;
	private JTextField txtNlicenciaConductor;
	private Component horizontalStrut;
	private Component verticalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_1;
	private Component horizontalStrut_2;
	private Component verticalStrut_2;
	private JTextField txtNombreSocio;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_8;
	private JLabel label_4;
	private JCheckBox chbxSocio;
	private JLabel lblNlicenciaSocio;
	private JTextField txtNlicenciaSocio;

	vPrincipal vp = null;
	viListaSocios ls = null;
	ResultSet rs;
	
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
	public vdSocioNuevo(vPrincipal temp, viListaSocios temp2) {
		setTitle("Socio Nuevo");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		vp = temp;
		ls = temp2;
		setBounds(100, 100, 724, 805);
		getContentPane().setLayout(null);
		{
			txtAgregarVehiculo = new JTextField();
			txtAgregarVehiculo.setEditable(false);
			txtAgregarVehiculo.setText("AGREGAR SOCIO");
			txtAgregarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
			txtAgregarVehiculo.setForeground(Color.WHITE);
			txtAgregarVehiculo.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
			txtAgregarVehiculo.setColumns(10);
			txtAgregarVehiculo.setBackground(new Color(0, 139, 139));
			txtAgregarVehiculo.setBounds(0, 0, 724, 46);
			getContentPane().add(txtAgregarVehiculo);
		}
		{
			lblPlaca = new JLabel("Codigo de socio:");
			this.lblPlaca.setForeground(Color.BLACK);
			lblPlaca.setVerticalAlignment(SwingConstants.BOTTOM);
			lblPlaca.setHorizontalAlignment(SwingConstants.LEFT);
			lblPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblPlaca.setBounds(30, 57, 190, 34);
			getContentPane().add(lblPlaca);
		}
		{
			txtCodSocio = new JTextField();
			txtCodSocio.setForeground(new Color(255, 69, 0));
			txtCodSocio.addKeyListener(this);
			txtCodSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtCodSocio.setColumns(10);
			txtCodSocio.setBounds(226, 69, 464, 25);
			getContentPane().add(txtCodSocio);
		}
		{
			JLabel lblModelo = new JLabel("DNI:");
			lblModelo.setForeground(Color.BLACK);
			lblModelo.setVerticalAlignment(SwingConstants.BOTTOM);
			lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
			lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblModelo.setBounds(70, 146, 105, 34);
			getContentPane().add(lblModelo);
		}
		{
			JLabel lblConductor = new JLabel("Veh\u00EDculo afiliado");
			lblConductor.setForeground(Color.BLACK);
			lblConductor.setVerticalAlignment(SwingConstants.BOTTOM);
			lblConductor.setHorizontalAlignment(SwingConstants.LEFT);
			lblConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			lblConductor.setBounds(30, 298, 190, 34);
			getContentPane().add(lblConductor);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnCancelar.setBackground(new Color(0, 139, 139));
			btnCancelar.setBounds(31, 706, 220, 53);
			getContentPane().add(btnCancelar);
		}
		{
			btnGuardar = new JButton("<html>Guardar</html>");
			btnGuardar.addActionListener(this);
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			btnGuardar.setBackground(new Color(0, 139, 139));
			btnGuardar.setBounds(470, 706, 220, 53);
			getContentPane().add(btnGuardar);
		}
		{
			txtDniSocio = new JTextField();
			txtDniSocio.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					keyTypedTxtDniSocio(arg0);
				}
			});
			txtDniSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			txtDniSocio.setColumns(10);
			txtDniSocio.setBounds(226, 155, 464, 25);
			getContentPane().add(txtDniSocio);
		}
		
		lblEmpresa = new JLabel("Empresa");
		this.lblEmpresa.setForeground(Color.BLACK);
		lblEmpresa.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpresa.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblEmpresa.setBounds(70, 102, 105, 34);
		getContentPane().add(lblEmpresa);
		
		cbEmpresa = new JComboBox();
		cbEmpresa.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbEmpresa.setBounds(226, 112, 464, 25);
		getContentPane().add(cbEmpresa);
		
		label = new JLabel("Placa:");
		this.label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label.setBounds(70, 345, 95, 20);
		getContentPane().add(label);
		
		txtPlaca = new JTextField();
		txtPlaca.setForeground(new Color(255, 69, 0));
		txtPlaca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				keyTypedTxtPlaca(arg0);
			}
		});
		txtPlaca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				focusLostTxtPlaca(arg0);
			}
		});
		txtPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(226, 343, 464, 25);
		getContentPane().add(txtPlaca);
		
		cbModeloV = new JComboBox();
		cbModeloV.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbModeloV.setBounds(226, 383, 464, 25);
		getContentPane().add(cbModeloV);
		
		label_1 = new JLabel("Modelo:");
		this.label_1.setForeground(Color.BLACK);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_1.setBounds(70, 388, 95, 20);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("Detalles:");
		this.label_2.setForeground(Color.BLACK);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(70, 429, 95, 20);
		getContentPane().add(label_2);
		
		txtDetalles = new JTextField();
		txtDetalles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtDetalles(e);
			}
		});
		txtDetalles.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDetalles.setColumns(10);
		txtDetalles.setBounds(226, 424, 464, 25);
		getContentPane().add(txtDetalles);
		
		label_3 = new JLabel("MTC:");
		this.label_3.setForeground(Color.BLACK);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBounds(70, 472, 95, 20);
		getContentPane().add(label_3);
		
		txtMTC = new JTextField();
		txtMTC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtMTC(e);
			}
		});
		txtMTC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtMTC.setColumns(10);
		txtMTC.setBounds(226, 467, 464, 25);
		getContentPane().add(txtMTC);
		
		lblConductor_1 = new JLabel("Conductor");
		this.lblConductor_1.setForeground(Color.BLACK);
		lblConductor_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblConductor_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblConductor_1.setBounds(30, 536, 132, 20);
		getContentPane().add(lblConductor_1);
		
		lblDniConductor = new JLabel("DNI:");
		this.lblDniConductor.setForeground(Color.BLACK);
		lblDniConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblDniConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblDniConductor.setBounds(70, 570, 104, 20);
		getContentPane().add(lblDniConductor);
		
		txtDniConductor = new JTextField();
		txtDniConductor.setForeground(new Color(255, 69, 0));
		txtDniConductor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				keyTypedTxtDniConductor(arg0);
			}
		});
		txtDniConductor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostTxtDniConductor(e);
			}
		});
		txtDniConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDniConductor.setColumns(10);
		txtDniConductor.setBounds(226, 567, 464, 25);
		getContentPane().add(txtDniConductor);
		
		lblNombreConductor = new JLabel("Nombre:");
		this.lblNombreConductor.setForeground(Color.BLACK);
		lblNombreConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNombreConductor.setBounds(70, 605, 111, 20);
		getContentPane().add(lblNombreConductor);
		
		txtNombreConductor = new JTextField();
		txtNombreConductor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtNombreConductor(e);
			}
		});
		txtNombreConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNombreConductor.setColumns(10);
		txtNombreConductor.setBounds(226, 602, 464, 25);
		getContentPane().add(txtNombreConductor);
		
		lblNlicenciaConductor = new JLabel("N Licencia:");
		lblNlicenciaConductor.setHorizontalAlignment(SwingConstants.LEFT);
		lblNlicenciaConductor.setForeground(Color.BLACK);
		lblNlicenciaConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNlicenciaConductor.setBounds(70, 638, 132, 20);
		getContentPane().add(lblNlicenciaConductor);
		
		txtNlicenciaConductor = new JTextField();
		txtNlicenciaConductor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtNlicencia(e);
			}
		});
		txtNlicenciaConductor.setForeground(Color.BLACK);
		txtNlicenciaConductor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNlicenciaConductor.setColumns(10);
		txtNlicenciaConductor.setBounds(226, 636, 464, 25);
		getContentPane().add(txtNlicenciaConductor);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(22, 555, 40, 20);
		getContentPane().add(horizontalStrut);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(52, 565, 18, 110);
		getContentPane().add(verticalStrut);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(22, 327, 40, 20);
		getContentPane().add(horizontalStrut_1);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(52, 337, 18, 162);
		getContentPane().add(verticalStrut_1);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setBounds(22, 85, 40, 20);
		getContentPane().add(horizontalStrut_2);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setBounds(52, 95, 18, 140);
		getContentPane().add(verticalStrut_2);
		
		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setForeground(Color.BLACK);
		Nombre.setVerticalAlignment(SwingConstants.BOTTOM);
		Nombre.setHorizontalAlignment(SwingConstants.LEFT);
		Nombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		Nombre.setBounds(70, 191, 105, 34);
		getContentPane().add(Nombre);
		
		txtNombreSocio = new JTextField();
		txtNombreSocio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtNombreSocio(e);
			}
		});
		txtNombreSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtNombreSocio.setColumns(10);
		txtNombreSocio.setBounds(226, 200, 464, 25);
		getContentPane().add(txtNombreSocio);
		
		label_5 = new JLabel("*");
		label_5.setForeground(new Color(255, 0, 0));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_5.setBounds(202, 70, 18, 20);
		getContentPane().add(label_5);
		
		label_6 = new JLabel("*");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_6.setBounds(202, 343, 18, 20);
		getContentPane().add(label_6);
		
		label_8 = new JLabel("*");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_8.setBounds(202, 570, 18, 20);
		getContentPane().add(label_8);
		
		label_4 = new JLabel("*");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_4.setBounds(202, 146, 18, 34);
		getContentPane().add(label_4);
		
		this.chbxSocio = new JCheckBox("Si el socio tambien har\u00E1 de conductor, marque esta casilla.");
		this.chbxSocio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedChbxSocio(arg0);
			}
		});
		this.chbxSocio.setHorizontalAlignment(SwingConstants.RIGHT);
		this.chbxSocio.setForeground(new Color(0, 139, 139));
		this.chbxSocio.setFont(new Font("Tahoma", Font.ITALIC, 15));
		this.chbxSocio.setBackground(Color.LIGHT_GRAY);
		this.chbxSocio.setBounds(226, 268, 464, 23);
		getContentPane().add(this.chbxSocio);
		
		this.lblNlicenciaSocio = new JLabel("N Licencia:");
		this.lblNlicenciaSocio.setEnabled(false);
		this.lblNlicenciaSocio.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblNlicenciaSocio.setForeground(Color.BLACK);
		this.lblNlicenciaSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		this.lblNlicenciaSocio.setBounds(70, 245, 132, 20);
		getContentPane().add(this.lblNlicenciaSocio);
		
		this.txtNlicenciaSocio = new JTextField();
		this.txtNlicenciaSocio.setEnabled(false);
		this.txtNlicenciaSocio.setForeground(Color.BLACK);
		this.txtNlicenciaSocio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		this.txtNlicenciaSocio.setColumns(10);
		this.txtNlicenciaSocio.setBounds(226, 243, 464, 25);
		getContentPane().add(this.txtNlicenciaSocio);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtCodSocio, cbEmpresa, txtDniSocio, txtNombreSocio, txtPlaca, cbModeloV, txtDetalles, txtMTC, txtDniConductor, txtNombreConductor, txtNlicenciaConductor, btnGuardar, btnCancelar}));
		cargar();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	
	public void cargar(){
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		
		Empresa empresa = new Empresa();
		empresa.cargarEmpresas(cbEmpresa);
		
		Consultas consulta = new Consultas();
		consulta.iniciar();
		rs = consulta.cargarModelosVehiculos();
		try {
			while(rs.next())
				cbModeloV.addItem(rs.getString("modelo"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		
		Conductor conductor = new Conductor();
		
		
		// CARGAR AUTOCOMPLETADORES
		//SOCIO
		TextAutoCompleter acs;
		acs = new TextAutoCompleter(txtDniSocio);
		ResultSet rss = consulta.cargarSocios();
		acs.setMode(0);
		try {
			while (rss.next()) 
				acs.addItem(rss.getInt("dnisocio"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR al cargar Socios: " + e);
		}
		
		//VEHICULOS
		TextAutoCompleter acv;
		acv = new TextAutoCompleter(txtPlaca);
		ResultSet rsv = consulta.cargarVehiculos();
		acv.setMode(0);
		try {
			while (rsv.next()) 
				acv.addItem(rsv.getString("placa"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR al cargar placas: " + e);
		}
		
		//CONDUCTOR
		TextAutoCompleter acc;
		acc = new TextAutoCompleter(txtDniConductor);
		ResultSet rsc = consulta.cargarConductores();
		acc.setMode(0);
		try {
			while (rsc.next()) 
				acc.addItem(rsc.getInt("dniconductor"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR al cargar conductor: " + e);
		}
		consulta.reset();
		
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		vp.enable(true);
		this.dispose();
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		int error = 0; // 0NO ERROR  1ERROR
		if(txtCodSocio.getText().length() == 0 || txtDniSocio.getText().length() != 8 || txtPlaca.getText().length() != 7)
			error = 1;
		if(chbxSocio.isSelected())
			if(txtNlicenciaSocio.getText().length() < 9)
				error = 1;
		if(!chbxSocio.isSelected())
			if(txtNlicenciaConductor.getText().length() < 9)
				error = 1;
		
		if(error == 1){
			this.setAlwaysOnTop(false);		
			JOptionPane.showMessageDialog(null, "Ingrese los datos necesarios correctamente");
			this.setAlwaysOnTop(true);
		}
		else{
			int codsocio = Integer.parseInt(txtCodSocio.getText());
			int idempresa = cbEmpresa.getSelectedIndex() + 1;
			int dnisocio = Integer.parseInt(txtDniSocio.getText());	
			String nombresocio = txtNombreSocio	.getText();
			
			String placa = txtPlaca.getText();
			int modelo = cbModeloV.getSelectedIndex() + 1;
			String detalles = txtDetalles.getText();
			String mtc = txtMTC.getText();
			
			int dniconductor = 0;
			String nombreconductor = "";
			String licencia = "";
			
			if(chbxSocio.isSelected()){
				dniconductor = Integer.parseInt(txtDniSocio.getText());
				nombreconductor = txtNombreSocio.getText();
				licencia = txtNlicenciaSocio.getText();
			}
			else{
				dniconductor = Integer.parseInt(txtDniConductor.getText());
				nombreconductor = txtNombreConductor.getText();
				licencia = txtNlicenciaConductor.getText();
			}
			
			String comprobador = null;
			try {				
				Consultas consult = new Consultas();
				consult.iniciar();
				int existeconductor = 0; // 0NO 1SI
				try {
					ResultSet rsconductor = null;
					rsconductor = consult.buscarConductor(dniconductor);
					rsconductor.next();
					//JOptionPane.showMessageDialog(null, rsconductor.getString("conductor"));
					comprobador = rsconductor.getString("conductor");
					existeconductor = 1;
				} catch (Exception e2) {
					//JOptionPane.showMessageDialog(null, "No existe conductor");
					existeconductor = 0;
				}
				
				int existevehiculo = 0; // 0NO 1SI
				try {
					ResultSet rsvehiculo = null;
					rsvehiculo = consult.buscarVehiculo(placa);
					rsvehiculo.next();
					//JOptionPane.showMessageDialog(null, rsvehiculo.getString("mtc"));
					comprobador = rsvehiculo.getString("mtc");
					existevehiculo = 1;
				} catch (Exception e2) {
					//JOptionPane.showMessageDialog(null, "No existe vehiculo");
					existevehiculo = 0;
				}	
				
				int existecodsocio = 0; // 0NO 1SI
				try {
					ResultSet rssocio = null;
					rssocio = consult.buscarSocio(codsocio);
					rssocio.next();
					//JOptionPane.showMessageDialog(null, "COD: " + rssocio.getString("nombresocio"));
					comprobador = rssocio.getString("nombresocio");
					existecodsocio = 1;
				} catch (Exception e2) {
					//JOptionPane.showMessageDialog(null, "No existe codigo  socio");
					existecodsocio = 0;
				}	
				
				int existednisocio = 0; // 0NO 1SI
				try {
					ResultSet rssocio2 = null;
					rssocio2 = consult.buscarSocio2(dnisocio);
					rssocio2.next();
					//JOptionPane.showMessageDialog(null, "DNI: " + rssocio2.getString("nombresocio"));
					comprobador = rssocio2.getString("nombresocio");
					existednisocio = 1;
				} catch (Exception e2) {
					//JOptionPane.showMessageDialog(null, "No existe dni socio");
					existednisocio = 0;
				}
				
				if(existecodsocio == 1){
					this.setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "Ya existe un socio creado con el Codigo: " + codsocio, "Alerta", JOptionPane.ERROR_MESSAGE);
					this.setAlwaysOnTop(true);
				}
				else{
					//JOptionPane.showMessageDialog(null, "Entró a regristrar datos: " + codsocio, "Alerta", JOptionPane.INFORMATION_MESSAGE);
					if(existevehiculo == 1){
						ResultSet rsvehiculo = null;
						rsvehiculo = consult.buscarVehiculo(placa);
						rsvehiculo.next();//ENTRA AQUI SI EXISTE 
						if(rsvehiculo.getInt("estado") == 0){ // SI ES 0 ES POR QUE ESTÁ ACTIVO, ENTONCES NO SE HACE NADA
							this.setAlwaysOnTop(false);
							JOptionPane.showMessageDialog(null, "El vehiculo ya existe y está relacionado a un socio. \nNo se puede registrar.", "Alerta", JOptionPane.ERROR_MESSAGE);
							this.setAlwaysOnTop(true);
						}
						
						else{ // ENTRA AQUÍ SI EXISTE PERO ESTÁ INACTIVO, SI SE REGISTRARÁ
							consult.actualizarVehiculoEstado(placa, 0); // 0 = ACTIVO
														
							if(existeconductor == 0){
								this.setAlwaysOnTop(false);
								consult.crearConductor(dniconductor, licencia, nombreconductor);
							}
							
							this.setAlwaysOnTop(false);
							consult.crearSocio(codsocio, idempresa, dnisocio, nombresocio, dniconductor, placa);
							this.setAlwaysOnTop(true);
						}							
					}
					else{
						 // ENTRA AQUÍ SI EXISTE PERO ESTÁ INACTIVO, SI SE REGISTRARÁ
						consult.crearVehiculo(placa, modelo, detalles, mtc);
													
						if(existeconductor == 0){
							this.setAlwaysOnTop(false);
							consult.crearConductor(dniconductor, licencia, nombreconductor);
						}
						
						this.setAlwaysOnTop(false);
						consult.crearSocio(codsocio, idempresa, dnisocio, nombresocio, dniconductor, placa);
						this.setAlwaysOnTop(true);
					}					
					
					ls.cargar();
					ls.seleccionarSocio(codsocio);
					vp.setEnabled(true);
					this.dispose();
				}
				
				consult.reset();	
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR al guardar: " + e2);
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
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodSocio) 
			keyTypedTxtCodSocio(e);
		if (e.getSource() == txtDniSocio) 
			keyTypedTxtDniSocio(e);
		if (e.getSource() == txtPlaca) 
			keyTypedTxtPlaca(e);
	}
	
	protected void keyTypedTxtCodSocio(KeyEvent e) {
		if (txtCodSocio.getText().length() == 8)
			e.consume();
	}
	protected void keyTypedTxtDniSocio(KeyEvent e) {
		char c = e.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER))
			e.consume();
		if (txtDniSocio.getText().length() == 8)
			e.consume();
		
		if (c == (char)KeyEvent.VK_ENTER){
			try {
			Consultas consulta = new Consultas();
			consulta.iniciar();
			ResultSet rs = consulta.buscarSocio2(Integer.parseInt(txtDniSocio.getText()));
				rs.next();
				txtNombreSocio.setText(rs.getString("nombresocio"));
			consulta.reset();
			} catch (Exception e2) {
				txtNombreSocio.setText(null);
			}
		}		
	}
	protected void keyTypedTxtNombreSocio(KeyEvent e) {
		if (txtNombreSocio.getText().length() == 50)
			e.consume();
	}
	protected void keyTypedTxtPlaca(KeyEvent e) {
		if (txtPlaca.getText().length() == 7)
			e.consume();
		
		char c = e.getKeyChar();
		if (c == (char)KeyEvent.VK_ENTER){
			try {
			Consultas consulta = new Consultas();
			consulta.iniciar();
			ResultSet rs = consulta.buscarVehiculo(txtPlaca.getText());
				rs.next();
				txtDetalles.setText(rs.getString("detalle"));
				txtMTC.setText(rs.getString("mtc"));
				cbModeloV.setSelectedIndex(rs.getInt("idmodelo")-1);
				consulta.reset();
			} catch (Exception e2) {
				txtDetalles.setText(null);
				txtMTC.setText(null);
				cbModeloV.setSelectedIndex(0);
			}
		}
	}
	protected void keyTypedTxtDetalles(KeyEvent e) {
		if (txtDetalles.getText().length() == 100)
			e.consume();
	}
	protected void keyTypedTxtMTC(KeyEvent e) {
		if (txtMTC.getText().length() == 20)
			e.consume();
	}
	protected void keyTypedTxtDniConductor(KeyEvent e) {
		char c = e.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER))
			e.consume();
		if (txtDniConductor.getText().length() == 8){
			e.consume();
		}
		
		if (c == (char)KeyEvent.VK_ENTER){
			try {
			Consultas consulta = new Consultas();
			consulta.iniciar();
			ResultSet rs = consulta.buscarConductor(Integer.parseInt(txtDniConductor.getText()));
				rs.next();
				txtNombreConductor.setText(rs.getString("conductor"));
				txtNlicenciaConductor.setText(rs.getString("licencia"));
				consulta.reset();
			} catch (Exception e2) {
				txtNombreConductor.setText(null);
				txtNlicenciaConductor.setText(null);
			}
		}
	}
	protected void keyTypedTxtNombreConductor(KeyEvent e) {
		if (txtNombreConductor.getText().length() == 50)
			e.consume();
	}
	protected void keyTypedTxtNlicencia(KeyEvent e) {
		if (txtNlicenciaConductor.getText().length() == 20)
			e.consume();
	}
	
	protected void focusLostTxtPlaca(FocusEvent arg0) {
		//verificarPlaca();
	}
	protected void focusLostTxtDniConductor(FocusEvent e) {
		//verificarConductor();
	}
	
	public void verificarConductor(){
		int dniConductor;
		if(txtDniConductor.getText().length() != 8){
			this.setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "DNI incorrecto");
			this.setAlwaysOnTop(true);
		}
		else{
			dniConductor = Integer.parseInt(txtDniConductor.getText());
			Consultas consulta = new Consultas();
			consulta.iniciar();
			ResultSet rs = consulta.buscarConductor(dniConductor);
			try {
				rs.next();
				txtNombreConductor.setText(rs.getString("conductor"));
				txtNlicenciaConductor.setText(rs.getString("licencia"));				
			} catch (SQLException ex) {
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "No existe el conductor, se creará uno nuevo.");
				limpiarConductor();
				this.setAlwaysOnTop(true);
			}
			consulta.reset();
		}
	}
	
	public void verificarPlaca(){
		String placa;
		if(txtPlaca.getText().length() != 7){
			this.setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "Placa incorrecta");
			this.setAlwaysOnTop(true);
		}
		else{
			placa = txtPlaca.getText();
			Consultas consulta = new Consultas();
			consulta.iniciar();
			ResultSet rs = consulta.buscarVehiculo(placa);
			try {
				rs.next();
				txtDetalles.setText(rs.getString("detalle"));
				txtMTC.setText(rs.getString("mtc"));
				
				ResultSet rs2 = consulta.buscarModeloVehiculo(rs.getInt("idmodelo"));
				rs2.next();
				cbModeloV.setSelectedItem(rs2.getString("modelo"));
			} catch (SQLException ex) {
				this.setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "No existe el vehiculo, se creará uno nuevo.");
				limpiarVehiculo();
			}
			consulta.reset();
		}
	}
	
	public void limpiarVehiculo(){
		cbModeloV.setSelectedIndex(1);
		txtDetalles.setText("");
		txtMTC.setText("");
	} 
	
	public void limpiarConductor(){
		cbModeloV.setSelectedIndex(1);
		txtNombreConductor.setText("");
		txtNlicenciaConductor.setText("");
	} 
	protected void mouseClickedChbxSocio(MouseEvent arg0) {
		this.setAlwaysOnTop(false);
		if(chbxSocio.isSelected()){
			int opc = JOptionPane.showConfirmDialog(null, "¿Está seguro de que el socio será el conductor?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (opc == 0){
				txtNlicenciaSocio.setEnabled(true);
				txtNlicenciaConductor.setEnabled(false);
				txtNombreConductor.setEnabled(false);
				txtDniConductor.setEnabled(false);
				
				lblNlicenciaSocio.setEnabled(true);
				lblDniConductor.setEnabled(false);
				lblNombreConductor.setEnabled(false);
				lblNlicenciaConductor.setEnabled(false);
				
				txtNlicenciaConductor.setText(null);
				txtNombreConductor.setText(null);
				txtDniConductor.setText(null);
			}
			else
				chbxSocio.setSelected(false);
		}
		else{
			int opc = JOptionPane.showConfirmDialog(null, "¿Está seguro cancelar al socio como conductor?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (opc == 0){
				txtNlicenciaSocio.setEnabled(false);
				txtNlicenciaConductor.setEnabled(true);
				txtNombreConductor.setEnabled(true);
				txtDniConductor.setEnabled(true);
				
				lblNlicenciaSocio.setEnabled(false);
				lblDniConductor.setEnabled(true);
				lblNombreConductor.setEnabled(true);
				lblNlicenciaConductor.setEnabled(true);
				
				txtNlicenciaSocio.setText(null);
			}
			else
				chbxSocio.setSelected(true);
		}
		this.setAlwaysOnTop(true);
	}
}





























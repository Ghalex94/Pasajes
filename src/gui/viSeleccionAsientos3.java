package gui;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import clases.Conductor;
import clases.Sedes;
import mysql.Consultas;
import java.awt.event.MouseAdapter;
import com.toedter.components.JSpinField;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;

public class viSeleccionAsientos3 extends JInternalFrame implements ActionListener, PropertyChangeListener, KeyListener {
	public JTextField txtTitulo;
	private JLabel lblOrigen;
	private JComboBox <Sedes> cbOrigen;
	private JLabel lblDestino;
	private JLabel lblCuentaTotal;
	private JButton btnfinalizarEImprimir;
	private JComboBox <Sedes> cbDestino ;
	private JLabel lblS;
	public JButton btnConductor;
	public JButton btnA1;
	public JButton btnA2;
	public JButton btnA3;
	public JButton btnA4;
	public JButton btnA5;
	public JButton btnA6;
	public JButton btnA7;
	public JButton btnA8;
	public JButton btnA9;
	public JButton btnA10;
	public JButton btnA11;
	public JButton btnA12;
	public JButton btnA13;
	public JButton btnA14;
	public JButton btnA15;
	private JLabel lblPasadizo;
	private JLabel lblpuerta;
	private JLabel lblBanner;
	public JLabel lblTotal;
	private JComboBox cbHoraOrigen;
	private JComboBox cbMinutoOrigen;
	private JComboBox cbHoraDestino;
	private JComboBox cbMinutoDestino;
	private JDateChooser dchOrigen;
	private JDateChooser dchDestino;
	
	vPrincipal vp;	
	private JLabel lblTV;
	private JLabel label;
	private JTextField txtNviaje;
	private JLabel lblNSerie;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viSeleccionAsientos3 frame = new viSeleccionAsientos3(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public viSeleccionAsientos3(vPrincipal temp) {
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setFont(new Font("Segoe UI", Font.BOLD, 30));
		vp = temp;
	
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(100, 100, 1361, 705);
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(Color.DARK_GRAY);
		
		txtTitulo = new JTextField();
		txtTitulo.setText("SELECCI\u00D3N DE ASIENTOS");
		txtTitulo.setRequestFocusEnabled(false);
		txtTitulo.setIgnoreRepaint(true);
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setForeground(Color.WHITE);
		txtTitulo.setFont(new Font("USAngel", Font.BOLD, 32));
		txtTitulo.setFocusable(false);
		txtTitulo.setFocusTraversalKeysEnabled(false);
		txtTitulo.setEditable(false);
		txtTitulo.setColumns(10);
		txtTitulo.setBackground(Color.DARK_GRAY);
		txtTitulo.setBounds(580, 0, 786, 75);
		getContentPane().add(txtTitulo);
		
		lblOrigen = new JLabel("Origen:");
		lblOrigen.setForeground(Color.WHITE);
		lblOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrigen.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblOrigen.setBounds(581, 86, 120, 32);
		getContentPane().add(lblOrigen);
		
		cbOrigen = new JComboBox();
		cbOrigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedCbOrigen(arg0);
			}
		});
		cbOrigen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbOrigen.setBounds(580, 144, 441, 40);
		getContentPane().add(cbOrigen);
		
		lblDestino = new JLabel("Destino:");
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblDestino.setBounds(580, 200, 134, 32);
		getContentPane().add(lblDestino);
		
		lblCuentaTotal = new JLabel("Cuenta Total:");
		lblCuentaTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLblCuentaTotal(e);
			}
		});
		lblCuentaTotal.setForeground(Color.WHITE);
		lblCuentaTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblCuentaTotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblCuentaTotal.setBounds(1051, 152, 258, 32);
		getContentPane().add(lblCuentaTotal);
		
		btnfinalizarEImprimir = new JButton("<html>FINALIZAR E <br>\u00A0\u00A0IMPRIMIR </html>");
		btnfinalizarEImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnfinalizarEImprimir(e);
			}
		});
		btnfinalizarEImprimir.setForeground(new Color(255, 255, 255));
		btnfinalizarEImprimir.setBackground(new Color(220, 20, 60));
		btnfinalizarEImprimir.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnfinalizarEImprimir.setBounds(1051, 220, 282, 62);
		getContentPane().add(btnfinalizarEImprimir);
		
		cbDestino = new JComboBox();
		cbDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCbDestino(e);
			}
		});
		cbDestino.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbDestino.setBounds(580, 242, 441, 40);
		getContentPane().add(cbDestino);
		
		lblS = new JLabel("S/ ");
		lblS.setForeground(Color.WHITE);
		lblS.setVerticalAlignment(SwingConstants.BOTTOM);
		lblS.setHorizontalAlignment(SwingConstants.LEFT);
		lblS.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblS.setBounds(1051, 188, 52, 32);
		getContentPane().add(lblS);
		
		Image imgChofer = new ImageIcon(this.getClass().getResource("/chofer.png")).getImage();		
		btnConductor = new JButton(" ");
		btnConductor.setBackground(SystemColor.controlDkShadow);
		btnConductor.setHorizontalAlignment(SwingConstants.CENTER);
		btnConductor.setIcon(new ImageIcon(imgChofer));
		btnConductor.addActionListener(this);
		btnConductor.setBounds(10, 11, 150, 90);
		getContentPane().add(btnConductor);
		
		Image imgAsiento1 = new ImageIcon(this.getClass().getResource("/asiento01.png")).getImage();
		btnA1 = new JButton("");
		btnA1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnA1.addActionListener(this);
		btnA1.setBackground(Color.GREEN);
		btnA1.setHorizontalAlignment(SwingConstants.CENTER);
		btnA1.setIcon(new ImageIcon(imgAsiento1));
		btnA1.setBounds(180, 11, 160, 90);
		getContentPane().add(btnA1);

		Image imgAsiento2 = new ImageIcon(this.getClass().getResource("/asiento02.png")).getImage();
		btnA2 = new JButton("");
		btnA2.setBackground(Color.GREEN);
		btnA2.setHorizontalAlignment(SwingConstants.CENTER);
		btnA2.setIcon(new ImageIcon(imgAsiento2));
		btnA2.addActionListener(this);
		btnA2.setBounds(347, 11, 167, 90);
		getContentPane().add(btnA2);

		Image imgAsiento3 = new ImageIcon(this.getClass().getResource("/asiento03.png")).getImage();
		btnA3 = new JButton("");
		btnA3.setBackground(Color.GREEN);
		btnA3.setIcon(new ImageIcon(imgAsiento3));
		btnA3.addActionListener(this);
		btnA3.setBounds(10, 139, 150, 90);
		getContentPane().add(btnA3);

		Image imgAsiento4 = new ImageIcon(this.getClass().getResource("/asiento04.png")).getImage();
		btnA4 = new JButton("");
		btnA4.setHorizontalAlignment(SwingConstants.CENTER);
		btnA4.setBackground(Color.GREEN);
		btnA4.setIcon(new ImageIcon(imgAsiento4));
		btnA4.addActionListener(this);
		btnA4.setBounds(165, 139, 145, 90);
		getContentPane().add(btnA4);

		Image imgAsiento5 = new ImageIcon(this.getClass().getResource("/asiento05.png")).getImage();
		btnA5 = new JButton("");
		btnA5.setHorizontalAlignment(SwingConstants.CENTER);
		btnA5.setBackground(Color.GREEN);
		btnA5.setIcon(new ImageIcon(imgAsiento5));
		btnA5.addActionListener(this);
		btnA5.setBounds(315, 139, 145, 90);
		getContentPane().add(btnA5);

		Image imgAsiento6 = new ImageIcon(this.getClass().getResource("/asiento06.png")).getImage();
		btnA6 = new JButton("");
		btnA6.setHorizontalAlignment(SwingConstants.CENTER);
		btnA6.setIcon(new ImageIcon(imgAsiento6));
		btnA6.addActionListener(this);
		btnA6.setBackground(Color.GREEN);
		btnA6.setBounds(10, 244, 150, 90);
		getContentPane().add(btnA6);

		Image imgAsiento7 = new ImageIcon(this.getClass().getResource("/asiento07.png")).getImage();
		btnA7 = new JButton("");
		btnA7.setHorizontalAlignment(SwingConstants.CENTER);
		btnA7.setIcon(new ImageIcon(imgAsiento7));
		btnA7.addActionListener(this);
		btnA7.setBackground(Color.GREEN);
		btnA7.setBounds(165, 244, 145, 90);
		getContentPane().add(btnA7);

		Image imgAsiento8 = new ImageIcon(this.getClass().getResource("/asiento08.png")).getImage();
		btnA8 = new JButton("");
		btnA8.setHorizontalAlignment(SwingConstants.CENTER);
		btnA8.setIcon(new ImageIcon(imgAsiento8));
		btnA8.addActionListener(this);
		btnA8.setBackground(Color.GREEN);
		btnA8.setBounds(315, 244, 145, 90);
		getContentPane().add(btnA8);

		Image imgAsiento9 = new ImageIcon(this.getClass().getResource("/asiento09.png")).getImage();
		btnA9 = new JButton("");
		btnA9.setHorizontalAlignment(SwingConstants.CENTER);
		btnA9.setIcon(new ImageIcon(imgAsiento9));
		btnA9.addActionListener(this);
		btnA9.setBackground(Color.GREEN);
		btnA9.setBounds(10, 349, 150, 100);
		getContentPane().add(btnA9);

		Image imgAsiento10 = new ImageIcon(this.getClass().getResource("/asiento10.png")).getImage();
		btnA10 = new JButton("");
		btnA10.setHorizontalAlignment(SwingConstants.CENTER);
		btnA10.setIcon(new ImageIcon(imgAsiento10));
		btnA10.addActionListener(this);
		btnA10.setBackground(Color.GREEN);
		btnA10.setBounds(165, 349, 145, 100);
		getContentPane().add(btnA10);

		Image imgAsiento11 = new ImageIcon(this.getClass().getResource("/asiento11.png")).getImage();
		btnA11 = new JButton("");
		btnA11.setHorizontalAlignment(SwingConstants.CENTER);
		btnA11.setIcon(new ImageIcon(imgAsiento11));
		btnA11.addActionListener(this);
		btnA11.setBackground(Color.GREEN);
		btnA11.setBounds(315, 349, 145, 100);
		getContentPane().add(btnA11);

		Image imgAsiento12 = new ImageIcon(this.getClass().getResource("/asiento12.png")).getImage();
		btnA12 = new JButton("");
		btnA12.setHorizontalAlignment(SwingConstants.CENTER);
		btnA12.setIcon(new ImageIcon(imgAsiento12));
		btnA12.addActionListener(this);
		btnA12.setBackground(Color.GREEN);
		btnA12.setBounds(10, 464, 122, 100);
		getContentPane().add(btnA12);

		Image imgAsiento13 = new ImageIcon(this.getClass().getResource("/asiento13.png")).getImage();
		btnA13 = new JButton("");
		btnA13.setHorizontalAlignment(SwingConstants.CENTER);
		btnA13.setIcon(new ImageIcon(imgAsiento13));
		btnA13.addActionListener(this);
		btnA13.setBackground(Color.GREEN);
		btnA13.setBounds(137, 464, 122, 100);
		getContentPane().add(btnA13);

		Image imgAsiento14 = new ImageIcon(this.getClass().getResource("/asiento14.png")).getImage();
		btnA14 = new JButton("");
		btnA14.setHorizontalAlignment(SwingConstants.CENTER);
		btnA14.setIcon(new ImageIcon(imgAsiento14));
		btnA14.addActionListener(this);
		btnA14.setBackground(Color.GREEN);
		btnA14.setBounds(264, 464, 121, 100);
		getContentPane().add(btnA14);

		Image imgAsiento15 = new ImageIcon(this.getClass().getResource("/asiento15.png")).getImage();
		btnA15 = new JButton("");
		btnA15.setHorizontalAlignment(SwingConstants.CENTER);
		btnA15.setIcon(new ImageIcon(imgAsiento15));
		btnA15.addActionListener(this);
		btnA15.setBackground(Color.GREEN);
		btnA15.setBounds(389, 464, 122, 100);
		getContentPane().add(btnA15);
		
		lblPasadizo = new JLabel("<html>P<br>A<br>S<br>I<br>L<br>L<br>O</html>");
		lblPasadizo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPasadizo.setForeground(SystemColor.window);
		lblPasadizo.setBounds(483, 315, 30, 140);
		getContentPane().add(lblPasadizo);
		
		lblpuerta = new JLabel("<html>P<br>U<br>E<br>R<br>T<br>A</html>");
		lblpuerta.setForeground(Color.WHITE);
		lblpuerta.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblpuerta.setBounds(495, 112, 30, 175);
		getContentPane().add(lblpuerta);
		
		lblBanner = new JLabel("");
		lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
		Image imBanner = new ImageIcon(this.getClass().getResource("/mv04.png")).getImage();
		lblBanner.setIcon(new ImageIcon(imBanner));
		lblBanner.setBounds(580, 293, 750, 350);
		getContentPane().add(lblBanner);
		
		lblTotal = new JLabel("");
		lblTotal.setVisible(false);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblTotal.setBounds(1099, 188, 210, 32);
		getContentPane().add(lblTotal);
				
		cbHoraOrigen = new JComboBox();
		cbHoraOrigen.addActionListener(this);
		cbHoraOrigen.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbHoraOrigen.setBounds(917, 108, 52, 32);
		getContentPane().add(cbHoraOrigen);
		
		cbMinutoOrigen = new JComboBox();
		cbMinutoOrigen.addActionListener(this);
		cbMinutoOrigen.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		cbMinutoOrigen.setBounds(969, 108, 52, 32);
		getContentPane().add(cbMinutoOrigen);
		
		cbHoraDestino = new JComboBox();
		cbHoraDestino.addActionListener(this);
		cbHoraDestino.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbHoraDestino.setBounds(917, 200, 52, 32);
		getContentPane().add(cbHoraDestino);
		
		cbMinutoDestino = new JComboBox();
		cbMinutoDestino.addActionListener(this);
		cbMinutoDestino.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		cbMinutoDestino.setBounds(970, 200, 52, 32);
		getContentPane().add(cbMinutoDestino);
		
		dchOrigen = new JDateChooser();
		dchOrigen.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				propertyChangeDchOrigen(arg0);
			}
		});
		dchOrigen.setBounds(732, 108, 175, 32);
		getContentPane().add(dchOrigen);
		
		dchDestino = new JDateChooser();
		dchDestino.addPropertyChangeListener(this);
		dchDestino.setBounds(733, 200, 175, 32);
		getContentPane().add(dchDestino);
		
		lblTV = new JLabel("");
		lblTV.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgTV = new ImageIcon(this.getClass().getResource("/tv.png")).getImage();
		lblTV.setIcon(new ImageIcon(imgTV));
		lblTV.setBounds(152, 107, 177, 28);
		getContentPane().add(lblTV);
		
		label = new JLabel("Viaje N\u00BA:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		label.setBounds(1051, 86, 258, 32);
		getContentPane().add(label);
		
		txtNviaje = new JTextField();
		txtNviaje.addKeyListener(this);
		txtNviaje.setText("0");
		txtNviaje.setForeground(Color.RED);
		txtNviaje.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtNviaje.setColumns(10);
		txtNviaje.setBounds(1166, 116, 167, 40);
		getContentPane().add(txtNviaje);
		
		lblNSerie = new JLabel("<dynamic> - ");
		lblNSerie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNSerie.setForeground(Color.RED);
		lblNSerie.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNSerie.setBounds(1051, 116, 105, 40);
		getContentPane().add(lblNSerie);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtTitulo, cbOrigen, btnfinalizarEImprimir, cbDestino, btnConductor, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9, btnA10, btnA11, btnA12, btnA13, btnA14, btnA15, btnA1, btnA2}));
		
		cargar(); 
		}
	
	public void cargar(){
		//seleccionar cbos
		try {
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.cargarVentaTemporal();
			int idorigen = 0;
			int iddestino = 0;
			if(rs.next()){
				idorigen = rs.getInt("idorigen");
				iddestino = rs.getInt("iddestino");
				txtNviaje.setText(rs.getString("nviaje"));
			}
			
			//Llenar cbos de Destinos
			Sedes o = new Sedes();
			o.cargarDestinos(cbOrigen);
			Sedes d = new Sedes();
			d.cargarDestinos(cbDestino);
		
			for(int i = 0; i < cbOrigen.getItemCount(); i++){
				if(idorigen == cbOrigen.getItemAt(i).getIdsede())
					cbOrigen.setSelectedIndex(i);
				if(iddestino == cbDestino.getItemAt(i).getIdsede())
					cbDestino.setSelectedIndex(i);
			}
			
			//Actualizar asientos y total
			try {
				Consultas consulta2 = new Consultas();
				ResultSet rs2 = consulta2.cargarPasajerosTemporal();
				while(rs2.next()){
					if(rs2.getInt("estado") == 1);{
						int asiento = rs2.getInt("asiento");
						int contratante = rs2.getInt("contratante");
						cambiarColorAsiento(asiento, contratante);
					}
				}
				sumarTotalPasajes();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR al cargar asientos y total: " + e);
			}
			
			//Cargar Horas
			try {
				Consultas consulta3 = new Consultas();
				ResultSet rs3 = consulta3.cargarVentaTemporal();
				rs3.next();
				String fooriginal = rs3.getString("fpartida");  // FECHA ORIGEN ORIGINAL
				String fdoriginal = rs3.getString("fllegada"); //  FECHA DESTINO ORIGIAL
				
				String[] partso = fooriginal.split(" ");
				String diao = partso[0]; // 123
				String horaso = partso[1]; // 654321
				java.util.Date fechaParseadaOrigen= new SimpleDateFormat("yyyy-MM-dd").parse(diao);
				dchOrigen.setDate(fechaParseadaOrigen);	
				
				String[] partshoraso = partso[1].split(":");
				String horao = partshoraso[0];
				String mino = partshoraso[1];
				cbHoraOrigen.setSelectedItem(horao);
				cbMinutoOrigen.setSelectedItem(mino);
				
				
				String[] partsd = fdoriginal.split(" ");
				String diad = partsd[0]; // 123
				String horasd = partsd[1]; // 654321
				java.util.Date fechaParseadaDestino= new SimpleDateFormat("yyyy-MM-dd").parse(diad);
				dchDestino.setDate(fechaParseadaDestino);	
				
				String[] partshorasd = partsd[1].split(":");
				String horad = partshorasd[0];
				String mind = partshorasd[1];
				cbHoraDestino.setSelectedItem(horad);
				cbMinutoDestino.setSelectedItem(mind);
			} catch (Exception e) {
				//JOptionPane.showMessageDialog(null, "Ninguna fecha registrada" + e);
			}
			
		}
		catch(Exception e){
		}
		
		//CARGAR NRO DE VIAJE
		try { //ASIGNAR N VIAJE 
			
			// BUSCAR SI EXISTE VENTA TEMPORAL
			Consultas consult = new Consultas();
			ResultSet rs4 = consult.cargarVentaTemporal();
			rs4.next();
			int nviajeventemp = rs4.getInt("nviaje");
			if(nviajeventemp == -1){// SI ES = -1 ENTRA AQUÍ ES POR QUE SE CREARÁ UN NUEVO VIAJE
				ResultSet rs5 = consult.cargarUltimoViaje();
				try {// SI ENTRA AQUÍ ES POR QUE HUBO VIAJES ANTERIORES
					rs5.next();
					int ultviajeregistrado = rs5.getInt("nviaje");
					txtNviaje.setText(""+ (ultviajeregistrado+1));
					consult.actualizarVentaTemporal09((ultviajeregistrado+1));
					
				} catch (Exception e) { // SI ENTRA AQUÍ ES POR QUE ES EL PRIMER VIAJE QUE SE HARÁ Y CARGAMOS EL DE LA PRIMERA CONFIGURACIÓN
					ResultSet rs6 = consult.cargarConfiguracionInicial();
					rs6.next();
					int nviajeconfiginicial = rs6.getInt("nviajeinicial");
					txtNviaje.setText("" + nviajeconfiginicial);
					consult.actualizarVentaTemporal09((nviajeconfiginicial));
				}
			}
			else{ // SI ENTRA AQUÍ ES POR QUE YA EXISTE UNA PREPARACIÓN
				txtNviaje.setText("" + nviajeventemp);
			}
		
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		
		// CARGAR NRO SERIE
		Consultas consult = new Consultas();
		ResultSet rs7 = consult.cargarConfiguracionInicial();
		try {
			rs7.next();
			String nSerie = rs7.getString("nserie");
			lblNSerie.setText(nSerie + " - ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar nSerie: " + e);
		}
	}
	
	public void sumarTotalPasajes(){
		try {
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.cargarPasajerosTemporal();
			float tot = 0 ;
			while(rs.next()){
				tot = tot + rs.getFloat("prepasaje");
			}
			lblTotal.setText(""+tot);
		}
		catch (Exception e) {
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cbMinutoDestino) {
			actionPerformedCbMinutoDestino(arg0);
		}
		if (arg0.getSource() == cbHoraDestino) {
			actionPerformedCbHoraDestino(arg0);
		}
		if (arg0.getSource() == cbMinutoOrigen) {
			actionPerformedCbMinutoOrigen(arg0);
		}
		if (arg0.getSource() == cbHoraOrigen) {
			actionPerformedCbHoraOrigen(arg0);
		}
		if (arg0.getSource() == btnConductor) {
			actionPerformedBtnConductor(arg0);
		}
		if (arg0.getSource() == btnA1) {
			actionPerformedBtnA1(arg0);
		}
		if (arg0.getSource() == btnA2) {
			actionPerformedBtnA2(arg0);
		}
		if (arg0.getSource() == btnA3) {
			actionPerformedBtnA3(arg0);
		}
		if (arg0.getSource() == btnA4) {
			actionPerformedBtnA4(arg0);
		}
		if (arg0.getSource() == btnA5) {
			actionPerformedBtnA5(arg0);
		}
		if (arg0.getSource() == btnA6) {
			actionPerformedBtnA6(arg0);
		}
		if (arg0.getSource() == btnA7) {
			actionPerformedBtnA7(arg0);
		}
		if (arg0.getSource() == btnA8) {
			actionPerformedBtnA8(arg0);
		}
		if (arg0.getSource() == btnA9) {
			actionPerformedBtnA9(arg0);
		}
		if (arg0.getSource() == btnA10) {
			actionPerformedBtnA10(arg0);
		}
		if (arg0.getSource() == btnA11) {
			actionPerformedBtnA11(arg0);
		}
		if (arg0.getSource() == btnA12) {
			actionPerformedBtnA12(arg0);
		}
		if (arg0.getSource() == btnA13) {
			actionPerformedBtnA13(arg0);
		}
		if (arg0.getSource() == btnA14) {
			actionPerformedBtnA14(arg0);
		}
		if (arg0.getSource() == btnA15) {
			actionPerformedBtnA15(arg0);
		}
	}
	
	public void cambiarColorAsiento(int asiento, int contratante){
		if(contratante == 0){
			switch(asiento){
			case 1: btnA1.setBackground(Color.RED); break;
			case 2: btnA2.setBackground(Color.RED);	break;
			case 3: btnA3.setBackground(Color.RED); break;
			case 4: btnA4.setBackground(Color.RED); break;
			case 5: btnA5.setBackground(Color.RED); break;
			case 6: btnA6.setBackground(Color.RED); break;
			case 7: btnA7.setBackground(Color.RED); break;
			case 8: btnA8.setBackground(Color.RED); break;
			case 9: btnA9.setBackground(Color.RED); break;
			case 10: btnA10.setBackground(Color.RED); break;
			case 11: btnA11.setBackground(Color.RED); break;
			case 12: btnA12.setBackground(Color.RED); break;
			case 13: btnA13.setBackground(Color.RED); break;
			case 14: btnA14.setBackground(Color.RED); break;
			case 15: btnA15.setBackground(Color.RED); break;
			}
		}
		else{
			switch(asiento){
			case 1: btnA1.setBackground(Color.YELLOW); break;
			case 2: btnA2.setBackground(Color.YELLOW);	break;
			case 3: btnA3.setBackground(Color.YELLOW); break;
			case 4: btnA4.setBackground(Color.YELLOW); break;
			case 5: btnA5.setBackground(Color.YELLOW); break;
			case 6: btnA6.setBackground(Color.YELLOW); break;
			case 7: btnA7.setBackground(Color.YELLOW); break;
			case 8: btnA8.setBackground(Color.YELLOW); break;
			case 9: btnA9.setBackground(Color.YELLOW); break;
			case 10: btnA10.setBackground(Color.YELLOW); break;
			case 11: btnA11.setBackground(Color.YELLOW); break;
			case 12: btnA12.setBackground(Color.YELLOW); break;
			case 13: btnA13.setBackground(Color.YELLOW); break;
			case 14: btnA14.setBackground(Color.YELLOW); break;
			case 15: btnA15.setBackground(Color.YELLOW); break;
			}
		}
	}
	
	public void cambiarColorAsientoVerde(int asiento){
		switch(asiento){
		case 1: btnA1.setBackground(Color.GREEN); break;
		case 2: btnA2.setBackground(Color.GREEN); break;
		case 3: btnA3.setBackground(Color.GREEN); break;
		case 4: btnA4.setBackground(Color.GREEN); break;
		case 5: btnA5.setBackground(Color.GREEN); break;
		case 6: btnA6.setBackground(Color.GREEN); break;
		case 7: btnA7.setBackground(Color.GREEN); break;
		case 8: btnA8.setBackground(Color.GREEN); break;
		case 9: btnA9.setBackground(Color.GREEN); break;
		case 10: btnA10.setBackground(Color.GREEN); break;
		case 11: btnA11.setBackground(Color.GREEN); break;
		case 12: btnA12.setBackground(Color.GREEN); break;
		case 13: btnA13.setBackground(Color.GREEN); break;
		case 14: btnA14.setBackground(Color.GREEN); break;
		case 15: btnA15.setBackground(Color.GREEN); break;
		}
	}
	
	protected void actionPerformedBtnConductor(ActionEvent arg0) {
		vdConductor vdc = new vdConductor(vp, this, null, null, null);
		vdc.setVisible(true);
		vp.setEnabled(false);
	}
	protected void actionPerformedBtnA1(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 1, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA2(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 2, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA3(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 3, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA4(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 4, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA5(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 5, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA6(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 6, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA7(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 7, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA8(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 8, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA9(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 9, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA10(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 10, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA11(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 11, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA12(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 12, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA13(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 13, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA14(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 14, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA15(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 15, this, null, null, null);
		vdp.setVisible(true);
		vp.enable(false);
	}
	
	protected void actionPerformedCbOrigen(ActionEvent arg0) {
		int idorigen = cbOrigen.getItemAt(cbOrigen.getSelectedIndex()).getIdsede();
		String origen = cbOrigen.getItemAt(cbOrigen.getSelectedIndex()).getSede();
		Consultas consulta = new Consultas();
		consulta.actualizarVentaTemporal03(idorigen, origen);
		
	}
	protected void actionPerformedCbDestino(ActionEvent e) {
		int iddestino = cbDestino.getItemAt(cbDestino.getSelectedIndex()).getIdsede();
		String destino = cbDestino.getItemAt(cbDestino.getSelectedIndex()).getSede();
		Consultas consulta = new Consultas();
		consulta.actualizarVentaTemporal04(iddestino, destino);
		
	}
	protected void mouseClickedLblCuentaTotal(MouseEvent e) {
		if(lblTotal.isVisible())
			lblTotal.setVisible(false);
		else
			lblTotal.setVisible(true);
	}
	protected void propertyChangeDchOrigen(PropertyChangeEvent arg0) {
		actualizarFechaOrigen();
	}
	protected void actionPerformedCbHoraOrigen(ActionEvent arg0) {
		actualizarFechaOrigen();
	}
	protected void actionPerformedCbMinutoOrigen(ActionEvent arg0) {
		actualizarFechaOrigen();
	}
	public void actualizarFechaOrigen(){
		try {
			Date dateo = dchOrigen.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fOrigen = String.valueOf(sdf.format(dateo));
			int horao = Integer.parseInt(cbHoraOrigen.getSelectedItem().toString());
			int mino = Integer.parseInt(cbMinutoOrigen.getSelectedItem().toString());
			/*if(cbMOrigen.getSelectedItem().toString().equals("pm")){
				if(cbHoraOrigen.getSelectedItem().toString().equals("12"))
					horao = 0;
				else
					horao = horao + 12;
			}*/
			fOrigen = fOrigen + " " + horao+":"+mino+":00";
			Consultas consulta = new Consultas();
			consulta.actualizarVentaTemporal05(fOrigen);
			
			} catch (Exception e) {	}
	}
	
	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getSource() == dchDestino) {
			propertyChangeDchDestino(arg0);
		}
	}
	protected void propertyChangeDchDestino(PropertyChangeEvent arg0) {
		actualizarFechaDestino();
	}
	protected void actionPerformedCbHoraDestino(ActionEvent arg0) {
		actualizarFechaDestino();
	}
	
	protected void actionPerformedCbMinutoDestino(ActionEvent arg0) {
		actualizarFechaDestino();
	}
	public void actualizarFechaDestino(){
		try {
			Date dater = dchDestino.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fDestino= String.valueOf(sdf.format(dater));
			int horad = Integer.parseInt(cbHoraDestino.getSelectedItem().toString());
			int mind = Integer.parseInt(cbMinutoDestino.getSelectedItem().toString());
			/*if(cbMOrigen.getSelectedItem().toString().equals("pm")){
				if(cbHoraOrigen.getSelectedItem().toString().equals("12"))
					horao = 0;
				else
					horao = horao + 12;
			}*/
			fDestino = fDestino + " " + horad+":"+mind+":00";
			Consultas consulta = new Consultas();
			consulta.actualizarVentaTemporal06(fDestino);	
			} catch (Exception e) {	}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtNviaje) {
			keyReleasedTxtNviaje(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtNviaje(KeyEvent e) {
		try {
			int nViaje = Integer.parseInt(txtNviaje.getText());
			Consultas consulta = new Consultas();
			consulta.actualizarVentaTemporal07(nViaje);	
		} catch (Exception ex) {	
		}
	}
	
	public int contarAsientosVendidos(){
		int cantvendidos = 0;
		if(btnA1.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA2.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA3.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA4.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA5.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA6.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA7.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA8.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA9.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA10.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA11.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA12.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA13.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA14.getBackground() != Color.GREEN)
			cantvendidos++;
		if(btnA15.getBackground() != Color.GREEN)
			cantvendidos++;
		return cantvendidos;
	}

	 	protected void actionPerformedBtnfinalizarEImprimir(ActionEvent arg0) {
		int opc = JOptionPane.showConfirmDialog(null, "¿ESTÁ SEGURO DE FINALIZAR?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opc == 0){
			Consultas consulta = new Consultas();
			ResultSet rs1 = consulta.cargarVentaTemporal(); // OBTENER TODOS LOS DATOS TEMPORALES
			try {
				rs1.next();
				int totalasientos = 0;
				int asientosvendidos = 0;	
				float total = Float.parseFloat(lblTotal.getText());
				asientosvendidos = contarAsientosVendidos();
				
				
				ResultSet rs3 = consulta.buscarModeloVehiculo(rs1.getInt("modelovh")); // BUSCAR CANTIDAD DE ASIENTOS 
				try {
					rs3.next();
					totalasientos = rs3.getInt("casientos");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al buscar total de cantidad de asientos: " + e);
				}

				int codsocio = rs1.getInt("codsocio");
				
				
				//REGISTRAR LOS DATOS CORRESPONDIENTES EN VIAJE
				consulta.registrarViaje(rs1.getInt("nviaje"), codsocio, rs1.getInt("empresa"), rs1.getInt("idorigen"), rs1.getInt("iddestino"), rs1.getString("fpartida"), 
						rs1.getString("fllegada"), rs1.getString("placa"), rs1.getInt("dniconductor"), rs1.getString("prepasaje"), 
						total, totalasientos, asientosvendidos);
				
				
				//REGISTRAR LOS DATOS CORRESPONDIENTES EN DETALLE
				ResultSet rs4 = consulta.cargarPasajerosTemporal(); // OBTENER TODOS LOS DATOS TEMPORALES
				try {
					while(rs4.next())
						consulta.registrarDetallesViaje(rs1.getInt("nviaje"), rs4.getInt("nboleto"), rs4.getInt("dnipasajero"), rs4.getInt("asiento"), rs4.getInt("edad"), rs4.getFloat("prepasaje"), rs4.getInt("contratante"));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al buscar tabla pasajeros temporal: " + e);
				}
				
				//REGISTRAR LOS DATOS CORRESPONDIENTES EN DETALLES OTROS
				ResultSet rs5 = consulta.cargarVentaTemporal(); // OBTENER TODOS LOS DATOS TEMPORALES
				String fpartidaoriginal = "";
				String horamin1 = "";
				String horamin2 = "";
				String usuario = "";
				try {
					rs5.next();
					usuario = rs5.getString("usuario");
					if(rs5.getString("fpartida") != null){
						fpartidaoriginal = rs5.getString("fpartida");
						String[] arrayfecha1 = fpartidaoriginal.split(" ");
						horamin1 = arrayfecha1[1]; // 00:00:00:00
						
						String[] arrayhora1 = horamin1.split(":");
						String hora1 = arrayhora1[0];
						String minuto1 = arrayhora1[1];
						horamin2 = hora1 + ":" + minuto1; // 00:00
						
						consulta.registrarDetallesOtros(rs5.getInt("nviaje"), rs5.getInt("standar"), rs5.getInt("escalacom"), rs5.getString("ciudaddesde"), rs5.getString("ciudadhasta"), 
								rs5.getString("puntoencuentro"), rs5.getString("escalas"), rs5.getInt("dniconductor"), horamin2, rs5.getString("horainicio2"), 
								rs5.getInt("dniconductor2"), rs5.getString("horafin1"), rs5.getString("horafin2"), rs5.getInt("modalidad"), rs5.getFloat("totalmodif"), rs5.getString("usuario"));
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al buscar tabla pasajeros temporal 2 : " + e);
				}
				
				JOptionPane.showMessageDialog(null, "VENTA EXITOSA");
				consulta.eliminarSalidaVehiculo(usuario);
				vp.mntmCrearNuevaSalida.setEnabled(true);
				vp.mntmContinuarPreparacion.setEnabled(false);
				vp.mntmCancelarSalida.setEnabled(false);
				vp.mnFormatos.setEnabled(false);
				vp.esconderVentanas();
				vp.cerrarVentanas();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al finalizar: " + e);
			}			
		}
	}
}

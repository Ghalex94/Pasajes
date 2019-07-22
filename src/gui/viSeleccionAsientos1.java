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

public class viSeleccionAsientos1 extends JInternalFrame implements ActionListener, PropertyChangeListener, KeyListener {
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
	public JLabel lblBanner;
	public JLabel lblTotal;
	private JComboBox cbHoraOrigen;
	private JComboBox cbMinutoOrigen;
	private JComboBox cbHoraDestino;
	private JComboBox cbMinutoDestino;
	private JDateChooser dchOrigen;
	private JDateChooser dchDestino;
	
	vPrincipal vp;	
	private JButton btnA20;
	private JButton btnA16;
	private JButton btnA17;
	private JButton btnA18;
	private JButton btnA19;
	private JLabel lblViajeN;
	private JTextField txtNviaje;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viSeleccionAsientos1 frame = new viSeleccionAsientos1(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public viSeleccionAsientos1(vPrincipal temp) {
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setFont(new Font("Segoe UI", Font.BOLD, 30));
		vp = temp;
	
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(100, 100, 1361, 854);
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
		lblOrigen.setBounds(580, 81, 120, 32);
		getContentPane().add(lblOrigen);
		
		cbOrigen = new JComboBox();
		cbOrigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedCbOrigen(arg0);
			}
		});
		cbOrigen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbOrigen.setBounds(580, 117, 441, 40);
		getContentPane().add(cbOrigen);
		
		lblDestino = new JLabel("Destino:");
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblDestino.setBounds(580, 203, 134, 32);
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
		lblCuentaTotal.setBounds(1051, 151, 258, 32);
		getContentPane().add(lblCuentaTotal);
		
		btnfinalizarEImprimir = new JButton("<html>FINALIZAR E <br>\u00A0\u00A0IMPRIMIR </html>");
		btnfinalizarEImprimir.addActionListener(this);
		btnfinalizarEImprimir.setForeground(new Color(255, 255, 255));
		btnfinalizarEImprimir.setBackground(new Color(220, 20, 60));
		btnfinalizarEImprimir.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnfinalizarEImprimir.setBounds(1051, 223, 282, 62);
		getContentPane().add(btnfinalizarEImprimir);
		
		cbDestino = new JComboBox();
		cbDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCbDestino(e);
			}
		});
		cbDestino.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbDestino.setBounds(580, 245, 441, 40);
		getContentPane().add(cbDestino);
		
		lblS = new JLabel("S/ ");
		lblS.setForeground(Color.WHITE);
		lblS.setVerticalAlignment(SwingConstants.BOTTOM);
		lblS.setHorizontalAlignment(SwingConstants.LEFT);
		lblS.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblS.setBounds(1051, 180, 52, 32);
		getContentPane().add(lblS);
		
		Image imgChofer = new ImageIcon(this.getClass().getResource("/chofer.png")).getImage();
		btnConductor = new JButton(" ");
		btnConductor.setBackground(SystemColor.controlDkShadow);
		btnConductor.setHorizontalAlignment(SwingConstants.CENTER);
		btnConductor.setIcon(new ImageIcon(imgChofer));
		btnConductor.addActionListener(this);
		btnConductor.setBounds(20, 11, 150, 90);
		getContentPane().add(btnConductor);
		
		Image imgAsiento1 = new ImageIcon(this.getClass().getResource("/asiento01.png")).getImage();
		btnA1 = new JButton("");
		btnA1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA1.addActionListener(this);
		btnA1.setBackground(Color.GREEN);
		btnA1.setIcon(new ImageIcon(imgAsiento1));
		btnA1.setBounds(20, 112, 145, 90);
		getContentPane().add(btnA1);

		Image imgAsiento2 = new ImageIcon(this.getClass().getResource("/asiento02.png")).getImage();
		btnA2 = new JButton("");
		btnA2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA2.setBackground(Color.GREEN);
		btnA2.setHorizontalAlignment(SwingConstants.CENTER);
		btnA2.setIcon(new ImageIcon(imgAsiento2));
		btnA2.addActionListener(this);
		btnA2.setBounds(170, 112, 145, 90);
		getContentPane().add(btnA2);

		Image imgAsiento3 = new ImageIcon(this.getClass().getResource("/asiento03.png")).getImage();
		btnA3 = new JButton("");
		btnA3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA3.setBackground(Color.GREEN);
		btnA3.setIcon(new ImageIcon(imgAsiento3));
		btnA3.addActionListener(this);
		btnA3.setBounds(379, 137, 145, 85);
		getContentPane().add(btnA3);

		Image imgAsiento4 = new ImageIcon(this.getClass().getResource("/asiento04.png")).getImage();
		btnA4 = new JButton("");
		btnA4.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA4.setHorizontalAlignment(SwingConstants.CENTER);
		btnA4.setBackground(Color.GREEN);
		btnA4.setIcon(new ImageIcon(imgAsiento4));
		btnA4.addActionListener(this);
		btnA4.setBounds(20, 207, 145, 90);
		getContentPane().add(btnA4);

		Image imgAsiento5 = new ImageIcon(this.getClass().getResource("/asiento05.png")).getImage();
		btnA5 = new JButton("");
		btnA5.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA5.setHorizontalAlignment(SwingConstants.CENTER);
		btnA5.setBackground(Color.GREEN);
		btnA5.setIcon(new ImageIcon(imgAsiento5));
		btnA5.addActionListener(this);
		btnA5.setBounds(170, 207, 145, 90);
		getContentPane().add(btnA5);

		Image imgAsiento6 = new ImageIcon(this.getClass().getResource("/asiento06.png")).getImage();
		btnA6 = new JButton("");
		btnA6.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA6.setHorizontalAlignment(SwingConstants.CENTER);
		btnA6.setIcon(new ImageIcon(imgAsiento6));
		btnA6.addActionListener(this);
		btnA6.setBackground(Color.GREEN);
		btnA6.setBounds(379, 227, 145, 85);
		getContentPane().add(btnA6);

		Image imgAsiento7 = new ImageIcon(this.getClass().getResource("/asiento07.png")).getImage();
		btnA7 = new JButton("");
		btnA7.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA7.setHorizontalAlignment(SwingConstants.CENTER);
		btnA7.setIcon(new ImageIcon(imgAsiento7));
		btnA7.addActionListener(this);
		btnA7.setBackground(Color.GREEN);
		btnA7.setBounds(20, 302, 145, 90);
		getContentPane().add(btnA7);

		Image imgAsiento8 = new ImageIcon(this.getClass().getResource("/asiento08.png")).getImage();
		btnA8 = new JButton("");
		btnA8.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA8.setHorizontalAlignment(SwingConstants.CENTER);
		btnA8.setIcon(new ImageIcon(imgAsiento8));
		btnA8.addActionListener(this);
		btnA8.setBackground(Color.GREEN);
		btnA8.setBounds(170, 302, 145, 90);
		getContentPane().add(btnA8);

		Image imgAsiento9 = new ImageIcon(this.getClass().getResource("/asiento09.png")).getImage();
		btnA9 = new JButton("");
		btnA9.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA9.setHorizontalAlignment(SwingConstants.CENTER);
		btnA9.setIcon(new ImageIcon(imgAsiento9));
		btnA9.addActionListener(this);
		btnA9.setBackground(Color.GREEN);
		btnA9.setBounds(378, 317, 146, 85);
		getContentPane().add(btnA9);

		Image imgAsiento10 = new ImageIcon(this.getClass().getResource("/asiento10.png")).getImage();
		btnA10 = new JButton("");
		btnA10.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnA10.setHorizontalAlignment(SwingConstants.CENTER);
		btnA10.setIcon(new ImageIcon(imgAsiento10));
		btnA10.addActionListener(this);
		btnA10.setBackground(Color.GREEN);
		btnA10.setBounds(20, 397, 145, 90);
		getContentPane().add(btnA10);

		Image imgAsiento11 = new ImageIcon(this.getClass().getResource("/asiento11.png")).getImage();
		btnA11 = new JButton("");
		btnA11.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA11.setHorizontalAlignment(SwingConstants.CENTER);
		btnA11.setIcon(new ImageIcon(imgAsiento11));
		btnA11.addActionListener(this);
		btnA11.setBackground(Color.GREEN);
		btnA11.setBounds(170, 399, 145, 88);
		getContentPane().add(btnA11);

		Image imgAsiento12 = new ImageIcon(this.getClass().getResource("/asiento12.png")).getImage();
		btnA12 = new JButton("");
		btnA12.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA12.setHorizontalAlignment(SwingConstants.CENTER);
		btnA12.setIcon(new ImageIcon(imgAsiento12));
		btnA12.addActionListener(this);
		btnA12.setBackground(Color.GREEN);
		btnA12.setBounds(379, 407, 145, 85);
		getContentPane().add(btnA12);

		Image imgAsiento13 = new ImageIcon(this.getClass().getResource("/asiento13.png")).getImage();
		btnA13 = new JButton("");
		btnA13.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA13.setHorizontalAlignment(SwingConstants.CENTER);
		btnA13.setIcon(new ImageIcon(imgAsiento13));
		btnA13.addActionListener(this);
		btnA13.setBackground(Color.GREEN);
		btnA13.setBounds(20, 492, 145, 90);
		getContentPane().add(btnA13);

		Image imgAsiento14 = new ImageIcon(this.getClass().getResource("/asiento14.png")).getImage();
		btnA14 = new JButton("");
		btnA14.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA14.setHorizontalAlignment(SwingConstants.CENTER);
		btnA14.setIcon(new ImageIcon(imgAsiento14));
		btnA14.addActionListener(this);
		btnA14.setBackground(Color.GREEN);
		btnA14.setBounds(170, 492, 145, 90);
		getContentPane().add(btnA14);

		Image imgAsiento15 = new ImageIcon(this.getClass().getResource("/asiento15.png")).getImage();
		btnA15 = new JButton("");
		btnA15.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA15.setHorizontalAlignment(SwingConstants.CENTER);
		btnA15.setIcon(new ImageIcon(imgAsiento15));
		btnA15.addActionListener(this);
		btnA15.setBackground(Color.GREEN);
		btnA15.setBounds(379, 497, 145, 85);
		getContentPane().add(btnA15);

		Image imgAsiento16 = new ImageIcon(this.getClass().getResource("/asiento16.png")).getImage();
		btnA16 = new JButton("");
		btnA16.addActionListener(this);
		btnA16.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA16.setHorizontalAlignment(SwingConstants.CENTER);
		btnA16.setIcon(new ImageIcon(imgAsiento16));
		btnA16.setBackground(Color.GREEN);
		btnA16.setBounds(20, 586, 120, 90);
		getContentPane().add(btnA16);

		Image imgAsiento17 = new ImageIcon(this.getClass().getResource("/asiento17.png")).getImage();
		btnA17 = new JButton("");
		btnA17.addActionListener(this);
		btnA17.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA17.setHorizontalAlignment(SwingConstants.CENTER);
		btnA17.setIcon(new ImageIcon(imgAsiento17));
		btnA17.setBackground(Color.GREEN);
		btnA17.setBounds(150, 586, 120, 90);
		getContentPane().add(btnA17);

		Image imgAsiento18 = new ImageIcon(this.getClass().getResource("/asiento18.png")).getImage();
		btnA18 = new JButton("");
		btnA18.addActionListener(this);
		btnA18.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA18.setHorizontalAlignment(SwingConstants.CENTER);
		btnA18.setIcon(new ImageIcon(imgAsiento18));
		btnA18.setBackground(Color.GREEN);
		btnA18.setBounds(276, 586, 120, 90);
		getContentPane().add(btnA18);

		Image imgAsiento19 = new ImageIcon(this.getClass().getResource("/asiento19.png")).getImage();
		btnA19 = new JButton("");
		btnA19.addActionListener(this);
		btnA19.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA19.setHorizontalAlignment(SwingConstants.CENTER);
		btnA19.setIcon(new ImageIcon(imgAsiento19));
		btnA19.setBackground(Color.GREEN);
		btnA19.setBounds(404, 586, 120, 90);
		getContentPane().add(btnA19); 

		Image imgAsiento20 = new ImageIcon(this.getClass().getResource("/asiento20.png")).getImage();
		btnA20 = new JButton("");
		btnA20.addActionListener(this);
		btnA20.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnA20.setHorizontalAlignment(SwingConstants.CENTER);
		btnA20.setIcon(new ImageIcon(imgAsiento20));
		btnA20.setBackground(Color.GREEN);
		btnA20.setBounds(192, 11, 155, 90);
		getContentPane().add(btnA20);
		
		lblPasadizo = new JLabel("<html>P<br>A<br>S<br>I<br>L<br>L<br>O</html>");
		lblPasadizo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPasadizo.setForeground(SystemColor.window);
		lblPasadizo.setBounds(338, 233, 25, 231);
		getContentPane().add(lblPasadizo);
		
		lblpuerta = new JLabel("PUERTA");
		lblpuerta.setHorizontalAlignment(SwingConstants.CENTER);
		lblpuerta.setForeground(Color.WHITE);
		lblpuerta.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblpuerta.setBounds(357, 35, 167, 40);
		getContentPane().add(lblpuerta);
		
		lblBanner = new JLabel("");
		lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
		Image imBanner = new ImageIcon(this.getClass().getResource("/mv01.png")).getImage();
		lblBanner.setIcon(new ImageIcon(imBanner));
		lblBanner.setBounds(583, 296, 750, 350);
		getContentPane().add(lblBanner);
		
		lblTotal = new JLabel("");
		lblTotal.setVisible(false);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblTotal.setBounds(1096, 180, 213, 32);
		getContentPane().add(lblTotal);
		
		
		
		cbHoraOrigen = new JComboBox();
		cbHoraOrigen.addActionListener(this);
		cbHoraOrigen.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbHoraOrigen.setBounds(916, 81, 52, 32);
		getContentPane().add(cbHoraOrigen);
		
		cbMinutoOrigen = new JComboBox();
		cbMinutoOrigen.addActionListener(this);
		cbMinutoOrigen.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		cbMinutoOrigen.setBounds(968, 81, 52, 32);
		getContentPane().add(cbMinutoOrigen);
		
		cbHoraDestino = new JComboBox();
		cbHoraDestino.addActionListener(this);
		cbHoraDestino.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbHoraDestino.setBounds(916, 203, 52, 32);
		getContentPane().add(cbHoraDestino);
		
		cbMinutoDestino = new JComboBox();
		cbMinutoDestino.addActionListener(this);
		cbMinutoDestino.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		cbMinutoDestino.setBounds(969, 203, 52, 32);
		getContentPane().add(cbMinutoDestino);
		
		dchOrigen = new JDateChooser();
		dchOrigen.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				propertyChangeDchOrigen(arg0);
			}
		});
		dchOrigen.setBounds(732, 81, 174, 32);
		getContentPane().add(dchOrigen);
		
		dchDestino = new JDateChooser();
		dchDestino.addPropertyChangeListener(this);
		dchDestino.setBounds(733, 203, 173, 32);
		getContentPane().add(dchDestino);
		
		lblViajeN = new JLabel("Viaje N\u00BA:");
		lblViajeN.setHorizontalAlignment(SwingConstants.LEFT);
		lblViajeN.setForeground(Color.WHITE);
		lblViajeN.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblViajeN.setBounds(1051, 70, 258, 32);
		getContentPane().add(lblViajeN);
		
		txtNviaje = new JTextField();
		txtNviaje.addKeyListener(this);
		txtNviaje.setText("0");
		txtNviaje.setForeground(Color.RED);
		txtNviaje.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		txtNviaje.setColumns(10);
		txtNviaje.setBounds(1051, 100, 202, 40);
		getContentPane().add(txtNviaje);
		
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtTitulo, cbOrigen, btnfinalizarEImprimir, cbDestino, btnConductor, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9, btnA10, btnA11, btnA12, btnA13, btnA14, btnA15, btnA1, btnA2}));
		cargar();
		}
	
	public void cargar(){
		//seleccionar cbos
		try {
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.cargarVentaTemporal();
			String origen = null;
			String destino = null;
			if(rs.next()){
				origen = rs.getString("origen");
				destino = rs.getString("destino");
				txtNviaje.setText(rs.getString("nviaje"));
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
				JOptionPane.showMessageDialog(null, "Ningun pasajero registrado");
			}
			
			//Llenar cbos de Destinos
			Sedes destinos2 = new Sedes();
			destinos2.cargarDestinos(cbOrigen);
			Sedes destinos = new Sedes();
			destinos.cargarDestinos(cbDestino);
		
			for(int i = 0; i < cbOrigen.getItemCount(); i++){
				if(origen.equals(cbOrigen.getItemAt(i).getSede()))
					cbOrigen.setSelectedIndex(i);
				if(destino.equals(cbDestino.getItemAt(i).getSede()))
					cbDestino.setSelectedIndex(i);
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
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "ERROR: " + e);
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
		if (arg0.getSource() == btnA20) {
			actionPerformedBtnA20(arg0);
		}
		if (arg0.getSource() == btnA19) {
			actionPerformedBtnA19(arg0);
		}
		if (arg0.getSource() == btnA18) {
			actionPerformedBtnA18(arg0);
		}
		if (arg0.getSource() == btnA17) {
			actionPerformedBtnA17(arg0);
		}
		if (arg0.getSource() == btnA16) {
			actionPerformedBtnA16(arg0);
		}
		if (arg0.getSource() == btnfinalizarEImprimir) {
			actionPerformedBtnfinalizarEImprimir(arg0);
		}
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
			case 16: btnA16.setBackground(Color.RED); break;
			case 17: btnA17.setBackground(Color.RED); break;
			case 18: btnA18.setBackground(Color.RED); break;
			case 19: btnA19.setBackground(Color.RED); break;
			case 20: btnA20.setBackground(Color.RED); break;
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
			case 16: btnA16.setBackground(Color.YELLOW); break;
			case 17: btnA17.setBackground(Color.YELLOW); break;
			case 18: btnA18.setBackground(Color.YELLOW); break;
			case 19: btnA19.setBackground(Color.YELLOW); break;
			case 20: btnA20.setBackground(Color.YELLOW); break;
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
		case 16: btnA16.setBackground(Color.GREEN); break;
		case 17: btnA17.setBackground(Color.GREEN); break;
		case 18: btnA18.setBackground(Color.GREEN); break;
		case 19: btnA19.setBackground(Color.GREEN); break;
		case 20: btnA20.setBackground(Color.GREEN); break;
		}
	}
	
	protected void actionPerformedBtnConductor(ActionEvent arg0) {
		vdConductor vdc = new vdConductor(vp, null, null, null, this);
		vdc.setVisible(true);
		vp.setEnabled(false);
	}
	protected void actionPerformedBtnA1(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 1, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA2(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 2, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA3(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 3, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA4(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 4, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA5(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 5, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA6(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 6, null, null, null, this);
		vdp.setVisible(true); 
		vp.enable(false);
	}
	protected void actionPerformedBtnA7(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 7, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA8(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 8, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA9(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 9, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA10(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 10, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA11(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 11, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA12(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 12, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA13(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 13, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA14(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 14, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA15(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 15, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA16(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 16, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA17(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 17, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA18(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 18, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA19(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 19, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA20(ActionEvent arg0) {
		vdAsiento vdp = new vdAsiento(vp, 20, null, null, null, this);
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
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtNviaje) {
			keyReleasedTxtNviaje(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE)){
			arg0.consume();
		}
		if (txtNviaje.getText().length() == 5){
			arg0.consume();
		}
	}
	protected void actionPerformedBtnfinalizarEImprimir(ActionEvent arg0) {
		
	}
	
	protected void keyReleasedTxtNviaje(KeyEvent arg0) {
		try {
			int nViaje = Integer.parseInt(txtNviaje.getText());
			Consultas consulta = new Consultas();
			consulta.actualizarVentaTemporal07(nViaje);	
		} catch (Exception e) {	
			JOptionPane.showMessageDialog(null, "Error: " + e);
		}
	}
	
}

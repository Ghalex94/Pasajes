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
import clases.Destinos;
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

public class viSeleccionAsientos1 extends JInternalFrame implements ActionListener {
	private JTextField txtSelecinDeAsientos;
	private JLabel lblOrigen;
	private JComboBox <Destinos> cbOrigen;
	private JLabel lblDestino;
	private JLabel lblCuentaTotal;
	private JButton btnfinalizarEImprimir;
	private JComboBox <Destinos> cbDestino ;
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
	
	vPrincipal vp;	
	private JDateChooser dchOrigen;
	private JDateChooser dchDestino;
	private JComboBox cbMOrigen;
	private JComboBox cbMDestino;
	private JTextField txtPrueba;
	
	
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
		
		setBounds(100, 100, 1492, 988);
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(SystemColor.textInactiveText);
		
		txtSelecinDeAsientos = new JTextField();
		txtSelecinDeAsientos.setText("SELECCI\u00D3N DE ASIENTOS CHEVROLET N300");
		txtSelecinDeAsientos.setRequestFocusEnabled(false);
		txtSelecinDeAsientos.setIgnoreRepaint(true);
		txtSelecinDeAsientos.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelecinDeAsientos.setForeground(Color.WHITE);
		txtSelecinDeAsientos.setFont(new Font("USAngel", Font.BOLD, 32));
		txtSelecinDeAsientos.setFocusable(false);
		txtSelecinDeAsientos.setFocusTraversalKeysEnabled(false);
		txtSelecinDeAsientos.setEditable(false);
		txtSelecinDeAsientos.setColumns(10);
		txtSelecinDeAsientos.setBackground(Color.DARK_GRAY);
		txtSelecinDeAsientos.setBounds(0, 0, ancho, 75);
		getContentPane().add(txtSelecinDeAsientos);
		
		lblOrigen = new JLabel("Origen:");
		lblOrigen.setForeground(Color.WHITE);
		lblOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrigen.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblOrigen.setBounds(580, 443, 120, 32);
		getContentPane().add(lblOrigen);
		
		cbOrigen = new JComboBox();
		cbOrigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedCbOrigen(arg0);
			}
		});
		cbOrigen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbOrigen.setBounds(580, 479, 441, 40);
		getContentPane().add(cbOrigen);
		
		lblDestino = new JLabel("Destino:");
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblDestino.setBounds(579, 557, 134, 32);
		getContentPane().add(lblDestino);
		
		lblCuentaTotal = new JLabel("Cuenta Total:");
		lblCuentaTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLblCuentaTotal(e);
			}
		});
		lblCuentaTotal.setForeground(Color.WHITE);
		lblCuentaTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentaTotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblCuentaTotal.setBounds(1051, 443, 258, 32);
		getContentPane().add(lblCuentaTotal);
		
		btnfinalizarEImprimir = new JButton("<html>FINALIZAR E <br>\u00A0\u00A0IMPRIMIR </html>");
		btnfinalizarEImprimir.setForeground(new Color(255, 255, 255));
		btnfinalizarEImprimir.setBackground(Color.DARK_GRAY);
		btnfinalizarEImprimir.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnfinalizarEImprimir.setBounds(1050, 577, 282, 62);
		getContentPane().add(btnfinalizarEImprimir);
		
		cbDestino = new JComboBox();
		cbDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCbDestino(e);
			}
		});
		cbDestino.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbDestino.setBounds(579, 599, 441, 40);
		getContentPane().add(cbDestino);
		
		lblS = new JLabel("S/ ");
		lblS.setForeground(Color.WHITE);
		lblS.setVerticalAlignment(SwingConstants.BOTTOM);
		lblS.setHorizontalAlignment(SwingConstants.LEFT);
		lblS.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblS.setBounds(1051, 487, 60, 32);
		getContentPane().add(lblS);
		
		Image imgChofer = new ImageIcon(this.getClass().getResource("/chofer.png")).getImage();
		Image imgAsiento = new ImageIcon(this.getClass().getResource("/asiento.png")).getImage();
		
		btnConductor = new JButton(" ");
		btnConductor.setBackground(SystemColor.controlDkShadow);
		btnConductor.setHorizontalAlignment(SwingConstants.CENTER);
		btnConductor.setIcon(new ImageIcon(imgChofer));
		btnConductor.addActionListener(this);
		btnConductor.setBounds(10, 86, 168, 90);
		getContentPane().add(btnConductor);
		
		btnA3 = new JButton("");
		btnA3.setBackground(Color.GREEN);
		btnA3.setIcon(new ImageIcon(imgAsiento));
		btnA3.addActionListener(this);
		btnA3.setBounds(10, 187, 100, 100);
		getContentPane().add(btnA3);
		
		btnA4 = new JButton("");
		btnA4.setHorizontalAlignment(SwingConstants.CENTER);
		btnA4.setBackground(Color.GREEN);
		btnA4.setIcon(new ImageIcon(imgAsiento));
		btnA4.addActionListener(this);
		btnA4.setBounds(130, 187, 100, 100);
		getContentPane().add(btnA4);
		
		btnA5 = new JButton("");
		btnA5.setHorizontalAlignment(SwingConstants.CENTER);
		btnA5.setBackground(Color.GREEN);
		btnA5.setIcon(new ImageIcon(imgAsiento));
		btnA5.addActionListener(this);
		btnA5.setBounds(247, 188, 100, 100);
		getContentPane().add(btnA5);
		
		btnA6 = new JButton("");
		btnA6.setHorizontalAlignment(SwingConstants.CENTER);
		btnA6.setIcon(new ImageIcon(imgAsiento));
		btnA6.addActionListener(this);
		btnA6.setBackground(Color.GREEN);
		btnA6.setBounds(10, 297, 100, 100);
		getContentPane().add(btnA6);
		
		btnA7 = new JButton("");
		btnA7.setHorizontalAlignment(SwingConstants.CENTER);
		btnA7.setIcon(new ImageIcon(imgAsiento));
		btnA7.addActionListener(this);
		btnA7.setBackground(Color.GREEN);
		btnA7.setBounds(130, 297, 100, 100);
		getContentPane().add(btnA7);
		
		btnA8 = new JButton("");
		btnA8.setHorizontalAlignment(SwingConstants.CENTER);
		btnA8.setIcon(new ImageIcon(imgAsiento));
		btnA8.addActionListener(this);
		btnA8.setBackground(Color.GREEN);
		btnA8.setBounds(389, 297, 100, 100);
		getContentPane().add(btnA8);
		
		btnA9 = new JButton("");
		btnA9.setHorizontalAlignment(SwingConstants.CENTER);
		btnA9.setIcon(new ImageIcon(imgAsiento));
		btnA9.addActionListener(this);
		btnA9.setBackground(Color.GREEN);
		btnA9.setBounds(10, 412, 100, 100);
		getContentPane().add(btnA9);
		
		btnA10 = new JButton("");
		btnA10.setHorizontalAlignment(SwingConstants.CENTER);
		btnA10.setIcon(new ImageIcon(imgAsiento));
		btnA10.addActionListener(this);
		btnA10.setBackground(Color.GREEN);
		btnA10.setBounds(130, 412, 100, 100);
		getContentPane().add(btnA10);
		
		btnA11 = new JButton("");
		btnA11.setHorizontalAlignment(SwingConstants.CENTER);
		btnA11.setIcon(new ImageIcon(imgAsiento));
		btnA11.addActionListener(this);
		btnA11.setBackground(Color.GREEN);
		btnA11.setBounds(389, 412, 100, 100);
		getContentPane().add(btnA11);
		
		btnA12 = new JButton("");
		btnA12.setHorizontalAlignment(SwingConstants.CENTER);
		btnA12.setIcon(new ImageIcon(imgAsiento));
		btnA12.addActionListener(this);
		btnA12.setBackground(Color.GREEN);
		btnA12.setBounds(10, 527, 100, 100);
		getContentPane().add(btnA12);
		
		btnA13 = new JButton("");
		btnA13.setHorizontalAlignment(SwingConstants.CENTER);
		btnA13.setIcon(new ImageIcon(imgAsiento));
		btnA13.addActionListener(this);
		btnA13.setBackground(Color.GREEN);
		btnA13.setBounds(130, 527, 100, 100);
		getContentPane().add(btnA13);
		
		btnA14 = new JButton("");
		btnA14.setHorizontalAlignment(SwingConstants.CENTER);
		btnA14.setIcon(new ImageIcon(imgAsiento));
		btnA14.addActionListener(this);
		btnA14.setBackground(Color.GREEN);
		btnA14.setBounds(260, 527, 100, 100);
		getContentPane().add(btnA14);
		
		btnA15 = new JButton("");
		btnA15.setHorizontalAlignment(SwingConstants.CENTER);
		btnA15.setIcon(new ImageIcon(imgAsiento));
		btnA15.addActionListener(this);
		btnA15.setBackground(Color.GREEN);
		btnA15.setBounds(389, 527, 100, 100);
		getContentPane().add(btnA15);
		
		lblPasadizo = new JLabel("<html>P<br>A<br>S<br>A<br>D<br>I<br>Z<br>O</html>");
		lblPasadizo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPasadizo.setForeground(SystemColor.window);
		lblPasadizo.setBounds(314, 326, 22, 179);
		getContentPane().add(lblPasadizo);
		
		lblpuerta = new JLabel("<html>P<br>U<br>E<br>R<br>T<br>A</html>");
		lblpuerta.setForeground(Color.WHITE);
		lblpuerta.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblpuerta.setBounds(492, 182, 22, 95);
		getContentPane().add(lblpuerta);
		
		lblBanner = new JLabel("");
		lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
		Image imBanner = new ImageIcon(this.getClass().getResource("/multivan2.png")).getImage();
		lblBanner.setIcon(new ImageIcon(imBanner));
		lblBanner.setBounds(640, 86, 600, 300);
		getContentPane().add(lblBanner);
		
		lblTotal = new JLabel("");
		lblTotal.setVisible(false);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblTotal.setBounds(1121, 487, 188, 32);
		getContentPane().add(lblTotal);
		
		btnA1 = new JButton("");
		btnA1.addActionListener(this);
		btnA1.setBackground(Color.GREEN);
		btnA1.setHorizontalAlignment(SwingConstants.CENTER);
		btnA1.setIcon(new ImageIcon(imgAsiento));
		btnA1.setBounds(180, 86, 167, 90);
		getContentPane().add(btnA1);
		
		btnA2 = new JButton("");
		btnA2.setBackground(Color.GREEN);
		btnA2.setHorizontalAlignment(SwingConstants.CENTER);
		btnA2.setIcon(new ImageIcon(imgAsiento));
		btnA2.addActionListener(this);
		btnA2.setBounds(347, 86, 167, 90);
		getContentPane().add(btnA2);
		
		cbHoraOrigen = new JComboBox();
		cbHoraOrigen.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbHoraOrigen.setBounds(864, 443, 52, 32);
		getContentPane().add(cbHoraOrigen);
		
		cbMinutoOrigen = new JComboBox();
		cbMinutoOrigen.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		cbMinutoOrigen.setBounds(916, 443, 52, 32);
		getContentPane().add(cbMinutoOrigen);
		
		cbHoraDestino = new JComboBox();
		cbHoraDestino.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbHoraDestino.setBounds(863, 557, 52, 32);
		getContentPane().add(cbHoraDestino);
		
		cbMinutoDestino = new JComboBox();
		cbMinutoDestino.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		cbMinutoDestino.setBounds(916, 557, 52, 32);
		getContentPane().add(cbMinutoDestino);
		
		dchOrigen = new JDateChooser();
		dchOrigen.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				propertyChangeDchOrigen(arg0);
			}
		});
		dchOrigen.setBounds(732, 443, 126, 32);
		getContentPane().add(dchOrigen);
		
		dchDestino = new JDateChooser();
		dchDestino.setBounds(732, 557, 126, 32);
		getContentPane().add(dchDestino);
		
		cbMOrigen = new JComboBox();
		cbMOrigen.setModel(new DefaultComboBoxModel(new String[] {"am", "pm"}));
		cbMOrigen.setBounds(969, 443, 52, 32);
		getContentPane().add(cbMOrigen);
		
		cbMDestino = new JComboBox();
		cbMDestino.setModel(new DefaultComboBoxModel(new String[] {"am", "pm"}));
		cbMDestino.setBounds(969, 557, 52, 32);
		getContentPane().add(cbMDestino);
		
		txtPrueba = new JTextField();
		txtPrueba.setText("1");
		txtPrueba.setBounds(732, 412, 86, 20);
		getContentPane().add(txtPrueba);
		txtPrueba.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtSelecinDeAsientos, cbOrigen, btnfinalizarEImprimir, cbDestino, btnConductor, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9, btnA10, btnA11, btnA12, btnA13, btnA14, btnA15, btnA1, btnA2}));
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
			}
		
			//Actualizar asientos y total
			try {
				Consultas consulta2 = new Consultas();
				ResultSet rs2 = consulta2.cargarPasajerosTemporal();
				while(rs2.next()){
					if(rs2.getInt("estado") == 1);{
						int asiento = rs2.getInt("asiento");
						cambiarColorAsiento(asiento);
					}
				}
				sumarTotalPasajes();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ningun pasajero registrado");
			}
			
			//Llenar cbos de Destinos
			Destinos destinos2 = new Destinos();
			destinos2.cargarDestinos(cbOrigen);
			Destinos destinos = new Destinos();
			destinos.cargarDestinos(cbDestino);
		
			for(int i = 0; i < cbOrigen.getItemCount(); i++){
				if(origen.equals(cbOrigen.getItemAt(i).getDestino()))
					cbOrigen.setSelectedIndex(i);
				if(destino.equals(cbDestino.getItemAt(i).getDestino()))
					cbDestino.setSelectedIndex(i);
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
	
	public void cambiarColorAsiento(int asiento){
		switch(asiento){
		case 1: btnA1.setBackground(Color.RED);
			break;
		case 2: btnA2.setBackground(Color.RED);
			break;
		case 3: btnA3.setBackground(Color.RED);
			break;
		case 4: btnA4.setBackground(Color.RED);
			break;
		case 5: btnA5.setBackground(Color.RED);
			break;
		case 6: btnA6.setBackground(Color.RED);
			break;
		case 7: btnA7.setBackground(Color.RED);
			break;
		case 8: btnA8.setBackground(Color.RED);
			break;
		case 9: btnA9.setBackground(Color.RED);
			break;
		case 10: btnA10.setBackground(Color.RED);
			break;
		case 11: btnA11.setBackground(Color.RED);
			break;
		case 12: btnA12.setBackground(Color.RED);
			break;
		case 13: btnA13.setBackground(Color.RED);
			break;
		case 14: btnA14.setBackground(Color.RED);
			break;
		case 15: btnA15.setBackground(Color.RED);
			break;
		}
	}
	
	public void cambiarColorAsientoVerde(int asiento){
		switch(asiento){
		case 1: btnA1.setBackground(Color.GREEN);
			break;
		case 2: btnA2.setBackground(Color.GREEN);
			break;
		case 3: btnA3.setBackground(Color.GREEN);
			break;
		case 4: btnA4.setBackground(Color.GREEN);
			break;
		case 5: btnA5.setBackground(Color.GREEN);
			break;
		case 6: btnA6.setBackground(Color.GREEN);
			break;
		case 7: btnA7.setBackground(Color.GREEN);
			break;
		case 8: btnA8.setBackground(Color.GREEN);
			break;
		case 9: btnA9.setBackground(Color.GREEN);
			break;
		case 10: btnA10.setBackground(Color.GREEN);
			break;
		case 11: btnA11.setBackground(Color.GREEN);
			break;
		case 12: btnA12.setBackground(Color.GREEN);
			break;
		case 13: btnA13.setBackground(Color.GREEN);
			break;
		case 14: btnA14.setBackground(Color.GREEN);
			break;
		case 15: btnA15.setBackground(Color.GREEN);
			break;
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
		int idorigen = cbOrigen.getItemAt(cbOrigen.getSelectedIndex()).getIddestino();
		String origen = cbOrigen.getItemAt(cbOrigen.getSelectedIndex()).getDestino();
		Consultas consulta = new Consultas();
		consulta.actualizarVentaTemporal03(idorigen, origen);
		
	}
	protected void actionPerformedCbDestino(ActionEvent e) {
		int iddestino = cbDestino.getItemAt(cbDestino.getSelectedIndex()).getIddestino();
		String destino = cbDestino.getItemAt(cbDestino.getSelectedIndex()).getDestino();
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
		try {
			Date dateo = dchOrigen.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fOrigen = String.valueOf(sdf.format(dateo));
			int horao = Integer.parseInt(cbHoraOrigen.getSelectedItem().toString());
			int mino = Integer.parseInt(cbMinutoOrigen.getSelectedItem().toString());
			if(cbMOrigen.getSelectedItem().toString().equals("pm"))
				horao = horao + 12;
			fOrigen = fOrigen + " " + horao+":"+mino+":00";
			txtPrueba.setText(fOrigen);
			Consultas consulta = new Consultas();
			consulta.actualizarVentaTemporal05(fOrigen);
			
			} catch (Exception e) {	}
	}
}

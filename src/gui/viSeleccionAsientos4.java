package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
import java.sql.ResultSet;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import mysql.Consultas;

public class viSeleccionAsientos4 extends JInternalFrame implements ActionListener {
	private JTextField txtSelecinDeAsientos;
	private JLabel lblOrigen;
	private JComboBox cbOrigen;
	private JLabel lblDestino;
	private JLabel lblCuentaTotal;
	private JButton btnFormatos;
	private JButton btnfinalizarEImprimir;
	private JComboBox cbDestino;
	private JLabel lblS;

	vPrincipal vp;
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
	private JLabel lblTotal;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viSeleccionAsientos4 frame = new viSeleccionAsientos4(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public viSeleccionAsientos4(vPrincipal temp) {
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
		lblOrigen.setBounds(579, 469, 213, 32);
		getContentPane().add(lblOrigen);
		
		cbOrigen = new JComboBox();
		cbOrigen.setModel(new DefaultComboBoxModel(new String[] {"AREQUIPA", "PUNO", "JULIACA", "SICUANI"}));
		cbOrigen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbOrigen.setBounds(579, 505, 302, 40);
		getContentPane().add(cbOrigen);
		
		lblDestino = new JLabel("Destino:");
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblDestino.setBounds(579, 557, 213, 32);
		getContentPane().add(lblDestino);
		
		lblCuentaTotal = new JLabel("Cuenta Total:");
		lblCuentaTotal.setForeground(Color.WHITE);
		lblCuentaTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentaTotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblCuentaTotal.setBounds(897, 396, 258, 32);
		getContentPane().add(lblCuentaTotal);
		
		btnFormatos = new JButton("<html>\u00A0\u00A0Llenar<br>formatos</html>");
		btnFormatos.setBackground(new Color(255, 255, 255));
		btnFormatos.setForeground(new Color(220, 20, 60));
		btnFormatos.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnFormatos.setBounds(897, 505, 282, 62);
		getContentPane().add(btnFormatos);
		
		btnfinalizarEImprimir = new JButton("<html>FINALIZAR E <br>\u00A0\u00A0IMPRIMIR </html>");
		btnfinalizarEImprimir.setForeground(new Color(255, 255, 255));
		btnfinalizarEImprimir.setBackground(Color.DARK_GRAY);
		btnfinalizarEImprimir.setFont(new Font("USAngel", Font.PLAIN, 20));
		btnfinalizarEImprimir.setBounds(897, 577, 282, 62);
		getContentPane().add(btnfinalizarEImprimir);
		
		cbDestino = new JComboBox();
		cbDestino.setModel(new DefaultComboBoxModel(new String[] {"AREQUIPA", "PUNO", "JULIACA", "SICUANI"}));
		cbDestino.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		cbDestino.setBounds(579, 599, 302, 40);
		getContentPane().add(cbDestino);
		
		lblS = new JLabel("S/ ");
		lblS.setForeground(Color.WHITE);
		lblS.setVerticalAlignment(SwingConstants.BOTTOM);
		lblS.setHorizontalAlignment(SwingConstants.LEFT);
		lblS.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblS.setBounds(897, 440, 60, 32);
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
		lblBanner.setBounds(579, 86, 600, 300);
		getContentPane().add(lblBanner);
		
		lblTotal = new JLabel("345.00");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("EngraversGothic BT", Font.BOLD, 30));
		lblTotal.setBounds(967, 440, 188, 32);
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
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtSelecinDeAsientos, cbOrigen, btnFormatos, btnfinalizarEImprimir, cbDestino, btnConductor, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9, btnA10, btnA11, btnA12, btnA13, btnA14, btnA15, btnA1, btnA2}));
		cargar();
		}
	
	public void cargar(){
		try {
			Consultas consulta = new Consultas();
			ResultSet rs = consulta.cargarPasajerosTemporal();
			while(rs.next()){
				if(rs.getInt("estado") == 1);{
					int asiento = rs.getInt("asiento");
					cambiarColorAsiento(asiento);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ningun pasajero registrado");
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
	protected void actionPerformedBtnConductor(ActionEvent arg0) {
		vdConductor vdc = new vdConductor(vp, null, null, null, this);
		vdc.setVisible(true);
		vp.setEnabled(false);
	}
	protected void actionPerformedBtnA1(ActionEvent arg0) {
		int estado = 0;
		if(btnA1.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 1, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA2(ActionEvent arg0) {
		int estado = 0;
		if(btnA2.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 2, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA3(ActionEvent arg0) {
		int estado = 0;
		if(btnA3.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 3, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA4(ActionEvent arg0) {
		int estado = 0;
		if(btnA4.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 4, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA5(ActionEvent arg0) {
		int estado = 0;
		if(btnA5.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 5, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA6(ActionEvent arg0) {
		int estado = 0;
		if(btnA6.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 6, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA7(ActionEvent arg0) {
		int estado = 0;
		if(btnA7.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 7, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA8(ActionEvent arg0) {
		int estado = 0;
		if(btnA8.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 8, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA9(ActionEvent arg0) {
		int estado = 0;
		if(btnA9.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 9, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA10(ActionEvent arg0) {
		int estado = 0;
		if(btnA10.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 10, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA11(ActionEvent arg0) {
		int estado = 0;
		if(btnA11.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 11, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA12(ActionEvent arg0) {
		int estado = 0;
		if(btnA12.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 12, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA13(ActionEvent arg0) {
		int estado = 0;
		if(btnA13.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 13, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA14(ActionEvent arg0) {
		int estado = 0;
		if(btnA14.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 14, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	protected void actionPerformedBtnA15(ActionEvent arg0) {
		int estado = 0;
		if(btnA15.getBackground() == Color.RED)
			estado = 1;
		vdAsiento vdp = new vdAsiento(vp, 15, estado, null, null, null, this);
		vdp.setVisible(true);
		vp.enable(false);
	}
	
}

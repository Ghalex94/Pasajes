	package clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mysql.Consultas;

public class Vehiculo {
	String placa;
	int idmodelo;
	String modelo;
	String detalle;
	ResultSet rs;
	String mtc;
	
	public Vehiculo(){}
	public Vehiculo(String placa, int idmodelo, String modelo, String detalle, String mtc){
		this.placa = placa;
		this.idmodelo = idmodelo;
		this.modelo = modelo;
		this.detalle = detalle;
		this.mtc = mtc;
	}
	
	
	public void cargarVehiculo(JComboBox<Vehiculo> cbVehiculo){
		Consultas consult = new Consultas();
		consult.iniciar();
		rs = consult.cargarVehiculos();
		try {
			while(rs.next())
				cbVehiculo.addItem(
						new Vehiculo(
								rs.getString("placa"),
								rs.getInt("idmodelo"),
								rs.getString("modelo"),
								rs.getString("detalle"),
								rs.getString("mtc")
								)
				);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}		
		consult.reset();
	}
	
	
	@Override
	public String toString(){
		String t = "";
		t = placa + " (" +  modelo + ")";
				/*
		switch(idmodelo){
		case 1:
			t = modelo + " " + placa + " - " + conductor;
			break;
		case 2:
			t = "JAC Refine 2017   -  " + placa + "  -  " + conductor;
			break;
		case 3:
			t = "Volkswagen R.     -  " + placa + "  -  " + conductor;
			break;
		case 4:
			t = "Hyundai H1 2016   -  " + placa + "  -  " + conductor;
			break;
		}*/
		return t;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getIdmodelo() {
		return idmodelo;
	}
	public void setIdmodelo(int idmodelo) {
		this.idmodelo = idmodelo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}	
	public String getMtc() {
		return mtc;
	}
	public void setMtc(String mtc) {
		this.mtc = mtc;
	}
}

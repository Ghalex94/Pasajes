package clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mysql.Consultas;

public class Vehiculo {
	String placa;
	int idmodelo;
	String detalle;
	int dniconductor;
	ResultSet rs;
	String conductor;
	
	public Vehiculo(){}
	public Vehiculo(String placa, int idmodelo, String detalle, int dniconductor, String conductor){
		this.placa = placa;
		this.idmodelo = idmodelo;
		this.detalle = detalle;
		this.dniconductor = dniconductor;
		this.conductor = conductor;
	}
	
	
	public void cargarVehiculo(JComboBox<Vehiculo> cbVehiculo){
		Consultas consult = new Consultas();
		rs = consult.cargarVehiculosConductores();
		try {
			while(rs.next())
				cbVehiculo.addItem(
						new Vehiculo(
								rs.getString("placa"),
								rs.getInt("idmodelo"),
								rs.getString("detalle"),
								rs.getInt("dniconductor"),
								rs.getString("conductor")
								)
				);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}		
	}
	
	@Override
	public String toString(){
		String t = "";
		switch(idmodelo){
		case 1:
			t = "Chevrolet N300    -  " + placa + "  -  " + conductor;
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
		}
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
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getDniconductor() {
		return dniconductor;
	}
	public void setDniconductor(int dniconductor) {
		this.dniconductor = dniconductor;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}	
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	

}

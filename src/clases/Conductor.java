package clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mysql.Consultas;

public class Conductor {
	int	dni;
	String conductor;
	ResultSet rs;
	
	public Conductor(){}
	public Conductor(int dni, String conductor){
		this.dni = dni;
		this.conductor = conductor;
	}
	
	public void cargarConductores(JComboBox<Conductor> cbConductor){
		Consultas consult = new Consultas();
		rs = consult.cargarConductores();
		try {
			while(rs.next())
				cbConductor.addItem(
						new Conductor(
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
		return conductor;
	}	
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
}

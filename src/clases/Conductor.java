package clases;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mysql.Consultas;

public class Conductor {
	int	dni;
	String nlicencia;
	String conductor;
	ResultSet rs;
	
	public Conductor(){}
	public Conductor(int dni, String nlicencia, String conductor){
		this.dni = dni;
		this.nlicencia = nlicencia;
		this.conductor = conductor;
	}
	
	public void cargarConductores(JComboBox<Conductor> cbConductor){
		Consultas consult = new Consultas();
		consult.iniciar();
		rs = consult.cargarConductores();
		try {
			while(rs.next())
				cbConductor.addItem(
						new Conductor(
								rs.getInt("dniconductor"),
								rs.getString("licencia"),
								rs.getString("conductor")
								)
				);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		try {
			rs.close();
			consult.reset();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public String getNlicencia() {
		return nlicencia;
	}
	public void setNlicencia(String nlicencia) {
		this.nlicencia = nlicencia;
	}
}

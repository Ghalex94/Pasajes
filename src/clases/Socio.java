package clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mysql.Consultas;

public class Socio {
	int codsocio;
	int idempresa;
	int dnisocio;
	String nombresocio;
	int dniconductor;
	String placa;
	ResultSet rs;
	
	public Socio(){}
	public Socio(int codsocio, int idempresa, int dnisocio, String nombresocio, int dniconductor, String placa){
		this.codsocio = codsocio;
		this.idempresa = idempresa;
		this.dnisocio = dnisocio;
		this.nombresocio = nombresocio;
		this.dniconductor = dniconductor;
		this.placa = placa;
	}
	
	
	public void cargarSocio(JComboBox<Socio> cbSocio){
		Consultas consult = new Consultas();
		rs = consult.cargarSocios();
		try {
			while(rs.next())
				cbSocio.addItem(
						new Socio(
								rs.getInt("codsocio"),
								rs.getInt("idempresa"),
								rs.getInt("dnisocio"),
								rs.getString("nombresocio"),
								rs.getInt("dniconductor"),
								rs.getString("placa")
								)
				);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}		
	}
	
	
	@Override
	public String toString(){
		String t = "";
		//t = codsocio + " (" +  nombresocio + ")";
		t = "" + codsocio;
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
	
	public int getCodsocio() {
		return codsocio;
	}
	public void setCodsocio(int codsocio) {
		this.codsocio = codsocio;
	}
	public int getIdempresa() {
		return idempresa;
	}
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	public int getDnisocio() {
		return dnisocio;
	}
	public void setDnisocio(int dnisocio) {
		this.dnisocio = dnisocio;
	}
	public String getNombresocio() {
		return nombresocio;
	}
	public void setNombresocio(String nombresocio) {
		this.nombresocio = nombresocio;
	}
	public int getDniconductor() {
		return dniconductor;
	}
	public void setDniconductor(int dniconductor) {
		this.dniconductor = dniconductor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}

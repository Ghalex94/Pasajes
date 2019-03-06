package clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mysql.Consultas;

public class Destinos {
	int	iddestino;
	String destino;
	ResultSet rs;
	
	public Destinos(){}
	public Destinos(int iddestino, String destino){
		this.iddestino = iddestino;
		this.destino = destino;
	}
	
	public void cargarDestinos(JComboBox<Destinos> cbDestinos){
		Consultas consult = new Consultas();
		rs = consult.cargarDestinos();
		try {
			while(rs.next())
				cbDestinos.addItem(
						new Destinos(
								rs.getInt("iddestino"),
								rs.getString("destino")
								)
				);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}		
	}
	
	@Override
	public String toString(){
		return destino;
	}
	public int getIddestino() {
		return iddestino;
	}
	public void setIddestino(int iddestino) {
		this.iddestino = iddestino;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}

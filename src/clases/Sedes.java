package clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mysql.Consultas;

public class Sedes {
	int	idsede;
	String sede;
	ResultSet rs;
	
	public Sedes(){}
	public Sedes(int idsede, String sede){
		this.idsede = idsede;
		this.sede = sede;
	}
	
	public void cargarDestinos(JComboBox<Sedes> cbDestinos){
		Consultas consult = new Consultas();
		consult.iniciar();
		rs = consult.cargarSedes();
		try {
			while(rs.next())
				cbDestinos.addItem(
						new Sedes(
								rs.getInt("idsede"),
								rs.getString("sede")
								)
				);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}		
		consult.reset();
	}
	
	@Override
	public String toString(){
		return sede;
	}
	
	public int getIdsede() {
		return idsede;
	}
	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}

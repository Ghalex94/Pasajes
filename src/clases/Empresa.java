package clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mysql.Consultas;

public class Empresa {
	int	idempresa;
	String ruc;
	String empresa;
	String mtc;
	ResultSet rs;
	
	public Empresa(){}
	public Empresa(int idempresa, String ruc, String empresa, String mtc){
		this.idempresa = idempresa;
		this.ruc = ruc;
		this.empresa = empresa;
		this.mtc = mtc;
	}
	
	public void cargarEmpresas(JComboBox<Empresa> cbEmpresa){
		Consultas consult = new Consultas();
		rs = consult.cargarEmpresas();
		try {
			while(rs.next())
				cbEmpresa.addItem(
						new Empresa(
								rs.getInt("idempresa"),
								rs.getString("ruc"),
								rs.getString("empresa"),
								rs.getString("mtc")
								)
				);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}		
	}
	
	@Override
	public String toString(){
		return empresa;
	}
	
	public int getIdempresa() {
		return idempresa;
	}
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getMtc() {
		return mtc;
	}
	public void setMtc(String mtc) {
		this.mtc = mtc;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}	
}

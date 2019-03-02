package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import clases.Usuarios;
import mysql.MySQLConexion;

public class Consultas {
	
	public Usuarios obtenerUsuario(Usuarios ingresante){
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConection();
			String sql = "select * from tb_usuario where usuario = ? COLLATE utf8_bin and pass = ? COLLATE utf8_bin ";
			pst = con.prepareStatement(sql);
			pst.setString(1, ingresante.getUsuario());
			pst.setString(2, ingresante.getPassword());
			rs = pst.executeQuery();
			while (rs.next()) {
				ingresante.setNombre(rs.getString(3));
				ingresante.setTipo(rs.getInt(4));
			}			
		} catch (Exception e) {
			System.out.println("Error en obtener usuario");
		}
		return ingresante;
	}
	
	public ResultSet cargarVehiculosConductores(){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select vh.placa, mvh.idmodelo, mvh.modelo, vh.detalle, co.dniconductor, co.conductor from tb_vehiculo vh inner join tb_modelo_vehiculo mvh  inner join tb_conductor co on vh.idmodelo = mvh.idmodelo and vh.dniconductor = co.dniconductor order by mvh.modelo");		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
	public ResultSet cargarModelosVehiculos(){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from tb_modelo_vehiculo");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
	public ResultSet cargarConductores(){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from tb_conductor order by conductor");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
	public static void crearVehiculo(String placa, int modelo, String detalle, int dni){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			String sql = "insert into tb_vehiculo (placa, idmodelo, detalle, dniconductor)" + " values (?, ?, ?, ?)";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, placa);
			prepareStmt.setInt(2, modelo);
			prepareStmt.setString(3, detalle);
			prepareStmt.setInt(4, dni);
			prepareStmt.execute();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	
	public static void crearConductor(int dni, String conductor){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "insert into tb_conductor (dniconductor, conductor)" + " values (?, ?)";
			//insert into tb_conductor values(48562548, 'Pablo Ramirez Valderrama');
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, dni);
			prepareStmt.setString(2, conductor);
			prepareStmt.execute();
			JOptionPane.showMessageDialog(null, "Conductor creado correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR" + e);
		}
	}
	
	public static void modificarvehiculo(String placa, String detalles, int dni){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "update tb_vehiculo set detalle=?, dniconductor=? where placa=?";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, detalles);
			prepareStmt.setInt(2, dni);
			prepareStmt.setString(3, placa);
			prepareStmt.execute();
			//JOptionPane.showMessageDialog(null, " VEHICULO MODIFICADO CORRECTAMENTE ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	
	public static void eliminarVehiculo(String placa){
		Connection con = MySQLConexion.getConection();
		ResultSet rs = null;
		try {
			String sql = "delete from tb_vehiculo where placa = ?";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, placa);		
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	
	public static void eliminarHistorialVehiculo(String placa){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "delete from tb_viaje where placa = ?";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, placa);		
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	
	public ResultSet cagarVentaTemporal(){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from tb_venta_temporal");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
	public static void actualizarVentaTemporal01(int estado, int empresa, int dniconductor, String placa, int modelovh, float prepasaje){ //1MERMA 2SIGUEL
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "update tb_venta_temporal set estado=? , empresa=?, dniconductor=?, placa=?, modelovh=?, prepasaje=? where id=1";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, estado);
			prepareStmt.setInt(2, empresa);
			prepareStmt.setInt(3, dniconductor);
			prepareStmt.setString(4, placa);
			prepareStmt.setInt(5, modelovh);
			prepareStmt.setFloat(6, prepasaje);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	
	public ResultSet buscarVehiculo(String placa){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			st = con.createStatement();
			String sql = "select * from tb_vehiculo where placa = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, placa);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
}

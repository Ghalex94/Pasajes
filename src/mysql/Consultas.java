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
	
	public ResultSet cargarVentaTemporal(){
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
	
	//1MERMA 2SIGUEL
	//VIENE DE DATOS1
	public static void actualizarVentaTemporal01(int estado, int empresa, int dniconductor, String placa, int modelovh, float prepasaje){ 
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
	//VIENE DE MODIFICACION A CONDUCTOR
	public static void actualizarVentaTemporal02(int dniconductor, float prepasaje){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "update tb_venta_temporal set dniconductor=?, prepasaje=? where id=1";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, dniconductor);
			prepareStmt.setFloat(2, prepasaje);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	//VIENE DE VENTA PASAJES
	public static void actualizarVentaTemporal03(int idorigen, String origen){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "update tb_venta_temporal set origen=? where id=1";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, origen);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	public static void actualizarVentaTemporal04(int iddestino, String destino){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "update tb_venta_temporal set destino=? where id=1";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, destino);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	public static void actualizarVentaTemporal05(String fOrigen){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "update tb_venta_temporal set fpardida=? where id=1";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, fOrigen);
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
	
	public static void eliminarSalidaVehiculo(){
		Connection con = MySQLConexion.getConection();
		try {
			String sql1 = "delete from tb_venta_temporal where id = 1";
			String sql2 = "insert into tb_venta_temporal values(1, 0, 0, 0, null, 0, null, null, null, null, null)";
			String sql3 = "delete from tb_pasajeros_temporal where asiento < 50";
			PreparedStatement prepareStmt = con.prepareStatement(sql1);
			prepareStmt.execute();
			PreparedStatement prepareStmt2 = con.prepareStatement(sql2);
			prepareStmt2.execute();
			PreparedStatement prepareStmt3 = con.prepareStatement(sql3);
			prepareStmt3.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	
	public static void crearPasajero(int dni, int ruc, String fnacimiento, int edad, String nombre, String razsocial){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "insert into tb_pasajero (dnipasajero, ruc, fnacimiento, edad, nombre, razsocial)" + " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, dni);
			prepareStmt.setInt(2, ruc);
			prepareStmt.setString(3, fnacimiento);
			prepareStmt.setInt(4, edad);
			prepareStmt.setString(5, nombre);
			prepareStmt.setString(6, razsocial);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR" + e);
		}
	}
	
	public ResultSet buscarPasajero(int dni){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			st = con.createStatement();
			String sql = "select * from tb_pasajero where dnipasajero = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, dni);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
	public static void crearPasajero(int dnipasajero, String ruc, String fnacimiento, String nombre, String razsocial){
		Object fn = fnacimiento;
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "insert into tb_pasajero (dnipasajero, ruc, fnacimiento, nombre, razsocial)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, dnipasajero);
			prepareStmt.setString(2, ruc);
			prepareStmt.setObject(3, fn);
			prepareStmt.setString(4, nombre);
			prepareStmt.setString(5, razsocial);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR" + e);
		}
	}
	
	public static void actualizarPasajero(int dnipasajero, String ruc, String fnacimiento, String nombre, String razsocial){
		Object fn = fnacimiento;
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "update tb_pasajero set ruc=?, fnacimiento=?, nombre=?, razsocial=? where dnipasajero=?";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, ruc);
			prepareStmt.setObject(2, fn);
			prepareStmt.setString(3, nombre);
			prepareStmt.setString(4, razsocial);
			prepareStmt.setInt(5, dnipasajero);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRORnbvnb: " + e);
		}
	}
	
	public static void asignarAsiento(int asiento, int dnipasajero, int edad, float prepasaje){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "insert into tb_pasajeros_temporal (asiento, estado, dnipasajero, edad, prepasaje)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, asiento);
			prepareStmt.setInt(2, 1);
			prepareStmt.setInt(3, dnipasajero);
			prepareStmt.setInt(4, edad);
			prepareStmt.setFloat(5, prepasaje);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR" + e);
		}
	}
	
	public ResultSet cargarPasajerosTemporal(){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			st = con.createStatement();
			String sql = "select * from tb_pasajeros_temporal";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
	public ResultSet buscarPasajerosTemporal(int asiento){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			st = con.createStatement();
			String sql = "select * from tb_pasajeros_temporal where asiento = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, asiento);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
	public static void eliminarAsiento(int asiento){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "delete from tb_pasajeros_temporal where asiento = ?";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, asiento);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR" + e);
		}
	}
	
	public ResultSet cargarDestinos(){
		Connection con = MySQLConexion.getConection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			String sql = "select * from tb_destinos";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
	
	public static void crearDestino(String destino){
		Connection con = MySQLConexion.getConection();
		try {
			String sql = "insert into tb_destinos (destino)" + " values (?)";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, destino);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR" + e);
		}
	}
	
	public static void eliminarDestino(int iddestino){
		Connection con = MySQLConexion.getConection();
		ResultSet rs = null;
		try {
			String sql = "delete from tb_destinos where iddestino = ?";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, iddestino);		
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
	}
	
	public ResultSet cargarPasajeros(){
		Connection con = MySQLConexion.getConection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			String sql = "select * from tb_pasajero";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e);
		}
		return rs;
	}
}

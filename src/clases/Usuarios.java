package clases;

public class Usuarios {
	String usuario;
	String password;
	String nombre;
	int tipo;
	
	public Usuarios(){}
	public Usuarios(String id, String password, String nombre, int tipo){
		this.usuario = id;
		this.password = password;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}


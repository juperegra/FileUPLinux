package model;

public class Usuario {
	
	private String id;
	
	private String nombre;
	
	private String apellidos;
	
	private String contraseña;
	
	private String IP;
	
	public Usuario(String id, String nombre, String apellidos, String contraseña, String IP) {
		this.setId(id);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setContraseña(contraseña);
		this.setIP(IP);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}
	
	public boolean equals(Usuario u) {
		
		if(this==u) {
			return true;
		}else {
			if (this.id==u.id) {// en la base de datos, id es clave, por eso, 2 usuario seran iguales si sus id's son iguales
				return true;
			}else {
				return false;
			}
		}
		
	}
	
	
}

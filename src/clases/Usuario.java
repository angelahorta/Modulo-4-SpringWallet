package clases;

public class Usuario {
	
	private String nombre;
	private String correo_electronico;
	private String contrasenia;
	private int saldo;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public int deposito(int monto){
		return this.saldo + monto;
	}
	
	public int retiro(int monto) {
		return this.saldo - monto; 
	}
	
	public Boolean validarRetiro(int monto) {
		
		if(this.saldo < monto) {
			return true;
		}
		
		return false;
	}

}

public class Persona {
	private String nombre, apellido, alias;
	private char sexo;

	public Persona(String nombre, String apellido, String alias, char sexo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.alias = alias;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String toString() {
		return "Nombre: " + nombre + "\nApellido: " + apellido + "\nAlias: " + alias + "\nSexo: " + sexo;
	}
}
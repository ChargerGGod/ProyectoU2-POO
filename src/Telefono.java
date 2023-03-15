//ese
public class Telefono {
	// parece carpintero por que hace
	public String rin() {
		return "Rin-Rin";
	}

	private String numTelefono;
	private char tipoTelefono;
	private String clavePais;

	public Telefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public Telefono(String numTelefono, char tipoTelefono, String clavePais) {
		this.numTelefono = numTelefono;
		this.tipoTelefono = tipoTelefono;
		this.clavePais = clavePais;
	}

	public char getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(char tipotelefono) {
		this.tipoTelefono = tipotelefono;
	}

	public String getClavePais() {
		return clavePais;
	}

	public void setClavePais(String clavepais) {
		this.clavePais = clavepais;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numtelefono) {
		this.numTelefono = numtelefono;
	}

	// Escribe los datos de telefono
	@Override
	public String toString() {
		return "Tipo de telefono: " + tipoTelefono + "\nClave Pais: " + clavePais + "\nNumero de telefono: "
				+ numTelefono;
	}

}
import java.util.ArrayList;

public class Contacto extends Persona {
    private ArrayList<Telefono> telefonos = new ArrayList<Telefono>();

    public Contacto(String nombre, String apellido, String alias, char sexo) {
        super(nombre, apellido, alias, sexo);
    }

    public void agregarTelefono(String numeroTelefonico) {
        this.telefonos.add(new Telefono(numeroTelefonico));
    }

    public void agregarTelefono(String numeroTelefonico, char tipoTelefono, String clavePais) {
        this.telefonos.add(new Telefono(numeroTelefonico,tipoTelefono,clavePais));
    }

    public boolean tieneTelefono() {
        return telefonos.isEmpty();
    }

    // si el contacto tiene telefonos, concatena sus toStrings al de Persona
    @Override
    public String toString() {
        String salida = "";

        if (tieneTelefono()) {
            salida = "\nEl contacto no tiene telefonos";
        } 
        else {
            for (Telefono telefono : telefonos) {
                salida = salida + "\nTelefonos del contacto:\n" + telefono.toString();
            }
        }
        return super.toString() + salida;
    }
}

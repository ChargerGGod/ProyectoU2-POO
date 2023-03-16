import java.util.ArrayList;

public class Contacto extends Persona implements Comparable<Contacto> {
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

    public ArrayList<Telefono> getTelefonos(){
        return telefonos;
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
        return super.toString() + salida + "\n-------------------------------";
    }

    @Override
    public int compareTo(Contacto otro) {
        // compara los valores unicode de los caracteres en los strings, devuelve la diferencia entre los valores numericos de los caracteres

        // lo convertimos a minusculas para que compare unicamente los valores alfabeticos y no en el orden unicode
        int compareInt = this.getNombre().toLowerCase().compareTo(otro.getNombre().toLowerCase());
        if (compareInt < 0 ) return -1; // nombre de este objeto es mas grande
        if (compareInt > 0 ) return 1; // nombre de otro objeto es mas grande
        return 0; // si ningun otro se cumple son iguales
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Agenda {
    private static ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        contactosIniciales();

        int x = 0;
        do {
            limpiarConsola();

            // despliega el menu de opciones
            System.out.println(
                    "Ingrese unas de las siguienes opciones:\n\n" +
                            "\t1.Imprimir directorio\n" +
                            "\t2.Listado por tipo de telefono\n" +
                            "\t3.Agregar Persona\n" +
                            "\t4.Buscar Persona\n" +
                            "\t5.Eliminar Persona\n" +
                            "\t6.Consultar Persona\n" +
                            "\t7.Ordenar el Directorio\n" +
                            "\t0.Finalizar Programa\n");

            // pregunta por la opcion
            x = sc.nextInt();
            // arregla el bug del scanner XDDDDDDDDDDDDDDDDDDDDDDDDDDD
            sc.nextLine();

            // comportamiento de cada opcion
            switch (x) {
                case 1: {
                    // Escribe por consola el string de los contactos
                    System.out.println(imprimirAgenda());

                    pausarPrograma();
                    break;
                }
                case 2: {

                    System.out.println("Escriba el tipo de telefono de la persona: \n");
                    char dato = sc.next().charAt(0);

                    ArrayList<Integer> persona = consultarTipoTelefono(dato);
                    if (persona.size() < 0) {
                        System.out.println("\nNo se encontro la persona");
                    } else {
                        for (Integer index : persona) {
                            System.out.println(contactos.get(index).toString() + "\n");
                        }
                    }

                    pausarPrograma();
                    break;
                }
                case 3: {
                    Contacto nuevoContacto = leerContacto();

                    System.out.println("¿Desea agregar un telefono? (Y o N)");
                    String respuesta = sc.nextLine();

                    if (respuesta.equalsIgnoreCase("y")) {
                        agregarTelefonoAContacto(nuevoContacto);
                    }

                    contactos.add(nuevoContacto);

                    pausarPrograma();
                    break;
                }
                case 4: {
                    System.out.println("Escriba el nombre o alias de la persona: " + "\n");
                    String dato = sc.nextLine();

                    ArrayList<Integer> personas = buscarPersona(dato);

                    if (personas.size() == 0) {
                        System.out.println("\nNo se encontro la persona");
                    } else {
                        for (Integer index : personas) {
                            System.out.println(contactos.get(index).toString() + "\n");
                        }
                    }

                    pausarPrograma();
                    break;
                }
                case 5: {
                    System.out.println("Escriba el nombre del contacto: ");
                    String nombre = sc.nextLine();
                    System.out.println("Escriba el apellido del contacto: ");
                    String apellido = sc.nextLine();

                    ArrayList<Integer> personas = eliminarPersona(nombre, apellido);

                    if (personas.size() == 0) {
                        System.out.println("\nNo se encontro la persona");
                    } else {
                        for (Integer index : personas) {
                            System.out.println(contactos.get(index).toString() + "\n");

                            System.out.println("¿Es esta el contacto? (Y o N) \n");
                            String respuesta = sc.nextLine();

                            if (respuesta.equalsIgnoreCase("y")) {
                                contactos.remove((int) index);
                                System.out.println("Contacto borrado con exito!");
                            }
                        }
                    }

                    pausarPrograma();
                    break;
                }
                case 6: {

                    System.out.println("Escriba el nombre, apellido, alias o telefono de la persona: \n");
                    String dato = sc.nextLine();

                    ArrayList<Integer> persona = consultarPersona(dato);

                    if (persona.size() < 0) {
                        System.out.println("\nNo se encontro la persona");
                    } else {
                        for (Integer index : persona) {
                            System.out.println(contactos.get(index).toString() + "\n");
                        }
                    }

                    pausarPrograma();
                    break;
                }
                case 7: {

                    Collections.sort(contactos);

                    // contactos.sort(new Comparator<Contacto>() {
                    //     public int compare(Contacto este, Contacto siguiente) {
                    //         return String.;
                    //     }
                    // });

                    break;
                }
                case 0: {
                    x = 0;
                    break;
                }
                default: {
                    System.out.println("¡Error! No selecciono ninguna opcion existente, intente de nuevo");
                    break;
                }
                // TODO: agregar telefono a persona

            }
        } while (x != 0);

        limpiarConsola();

        sc.close();
        System.out.println("¡El programa ha terminado con exito!");
    }

    // lee contacto y regresa un objeto contacto

    public static Contacto leerContacto() {

        System.out.print("Escribe el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Escribe el apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Escribe el alias: ");
        String alias = sc.nextLine();
        System.out.println("Escribe el sexo (M o F): ");
        char sexo = sc.nextLine().charAt(0);

        Contacto nuevoContacto = new Contacto(nombre, apellido, alias, sexo);
        return nuevoContacto;
    }

    // recibe un contacto y le agrega un numero telefonico

    public static void agregarTelefonoAContacto(Contacto contacto) {
        System.out.println("Introduce numero de telefono");
        String numeroTelefono = sc.nextLine();
        System.out.println("Introduce tipo de telefono");
        char tipoTelefono = sc.nextLine().charAt(0);
        System.out.println("Introduce clave de pais");
        String clavePais = sc.nextLine();

        contacto.agregarTelefono(numeroTelefono, tipoTelefono, clavePais);
    }

    // busqueda para eliminar persona

    public static ArrayList<Integer> buscarPersona(String dato) {
        ArrayList<Integer> posicion = new ArrayList<Integer>();

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(dato) || contacto.getAlias().equalsIgnoreCase(dato)) {
                posicion.add(contactos.indexOf(contacto));
            }
        }
        return posicion;
    }

    public static ArrayList<Integer> eliminarPersona(String nombre, String apellido) {
        ArrayList<Integer> posicion = new ArrayList<Integer>();

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)) {
                posicion.add(contactos.indexOf(contacto));
            }
        }
        return posicion;
    }

    // consultar por nombre, apellido, alias, o telefono

    public static ArrayList<Integer> consultarPersona(String dato) {
        ArrayList<Integer> posicion = new ArrayList<Integer>();

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(dato) || contacto.getApellido().equalsIgnoreCase(dato)
                    || contacto.getAlias().equalsIgnoreCase(dato) || consultarTelefono(contacto, dato)) {
                posicion.add(contactos.indexOf(contacto));
            }

        }
        return posicion;
    }

    public static boolean consultarTelefono(Contacto contacto, String dato) {
        for (Telefono telefono : contacto.getTelefonos()) {
            return telefono.getNumTelefono().equalsIgnoreCase(dato);
        }

        return false;
    }

    // consultar por tipo de telefono

    public static ArrayList<Integer> consultarTipoTelefono(char dato) {
        ArrayList<Integer> posicion = new ArrayList<Integer>();

        for (Contacto contacto : contactos) {
            if (consultarTipo(contacto, dato)) {
                posicion.add(contactos.indexOf(contacto));
            }

        }
        return posicion;
    }

    public static boolean consultarTipo(Contacto contacto, char dato) {
        for (Telefono telefono : contacto.getTelefonos()) {
            return Character.toLowerCase(telefono.getTipoTelefono()) == Character.toLowerCase(dato);
        }

        return false;
    }

    // utiliza escape para limpiar la consola y posicionar el cursor al inicio
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // detiene la ejecucion hasta presionar enter
    public static void pausarPrograma() {
        System.out.print("\nPresiona enter para continuar  . . . ");
        sc.nextLine();
    }

    // recorre el ArrayList de contactos y los concatena a un solo String
    public static String imprimirAgenda() {
        String salida = "";

        for (Contacto contacto : contactos) {
            salida = salida + "\n" + contacto.toString() + "\n";
        }
        return salida;
    }

    // instancia 4 contactos por defecto sin telefono
    public static void contactosIniciales() {
        String[] nombres = { "Lucia", "Bertha", "Guilermo", "Jose Luis" };
        String[] apellidos = { "Barron", "Legas", "Del Toro", "Perales" };
        String[] alias = { "Maestra", "nina", "memo", "pepe" };
        char[] sexo = { 'F', 'F', 'M', 'M' };

        for (int i = 0; i < 4; i++) {
            contactos.add(new Contacto(nombres[i], apellidos[i], alias[i], sexo[i]));
        }
    }

}
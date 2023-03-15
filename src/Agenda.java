import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private static ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        contactosIniciales();

        Scanner sc = new Scanner(System.in);
        int x = 0;
        do {
            limpiarConsola();

            // TODO: agregar telefono a persona
            
            // TODO: listado por tipo de telefono
            // TODO: buscar 
            // TODO: eliminar
            // TODO: consultar
            // TODO: ordenar
            
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
                case 1:
                    // Escribe por consola el string de los contactos
                    System.out.println(imprimirAgenda());
                    
                    pausarPrograma();
                    break;
                case 2:

                    break;
                case 3:
                    Contacto nuevoContacto = leerContacto();

                    System.out.println("¿Desea agregar un telefono? (Y o N)");
                    String respuesta = sc.nextLine();

                    if (respuesta.equalsIgnoreCase("y")) {
                        agregarTelefonoAContacto(nuevoContacto);
                    }

                    contactos.add(nuevoContacto);

                    pausarPrograma();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 0:
                    x = 0;
                    break;

            }
        } while (x != 0);

        limpiarConsola();

        System.out.println("¡El programa ha terminado con exito!");
    }

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

    public static void agregarTelefonoAContacto(Contacto contacto) {
        System.out.println("Introduce numero de telefono");
        String numeroTelefono = sc.nextLine();
        System.out.println("Introduce tipo de telefono");
        char tipoTelefono = sc.nextLine().charAt(0);
        System.out.println("Introduce clave de pais");
        String clavePais = sc.nextLine();

        contacto.agregarTelefono(numeroTelefono, tipoTelefono, clavePais);
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
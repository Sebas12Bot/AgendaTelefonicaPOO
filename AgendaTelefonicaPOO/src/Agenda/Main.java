package Agenda;

import java.util.*;


public class Main {
    public static void main(String[] args){
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("|   Agenda Telefonica Electronica📲 |");
        System.out.println("-------------------------------------");
        int opc;

        do {
            System.out.println("-------------------------------------");
            System.out.println("|      🎰       Opciones            |");
            System.out.println("|     1.Agregar Contacto            |");
            System.out.println("|     2.Eliminar Contacto           |");
            System.out.println("|     3.Busquedad Por Nombre        |");
            System.out.println("|     4.Busquedad Por Apellido      |");
            System.out.println("|     5.Busquedad Por Numero        |");
            System.out.println("|     6.Editar Un Numero            |");
            System.out.println("|     7.Orden Alfabetico            |");
            System.out.println("-------------------------------------");

            System.out.println("Se le solicita que digite el numero de la opcion deseada: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Usted ha seleccionado la opcion 1, favor diligenciar los datos requeridos😉.");
                    if (agenda.getNumeroContactos() < 50) {
                        System.out.println("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.println("Numero: ");
                        String numero = scanner.nextLine();

                        Contacto contactoNuevo = new Contacto(nombre,apellido,numero);
                        agenda.agregarContacto(contactoNuevo);
                    } else {
                        System.out.println("Lo sentimos, ya has agregado 50 contactos😪.");
                    }
                    break;
                case 2:
                    System.out.println("Usted ha seleccionado la opcion 2, favor diligenciar los datos requeridos😉.");
                    System.out.println("Digite el nombre y apellido o el numero del contacto que desea eliminar: ");
                    String registro = scanner.nextLine();
                    if (agenda.validacionExistenciaContacto(registro)){
                        agenda.eliminarContacto(registro);
                        System.out.println("El contacto fue eliminado satisfactoriamente😎.");
                    } else {
                        System.out.println("No fue posible eliminar el contacto😪.");
                    }
                    break;
                case 3:
                    System.out.println("Usted ha seleccionado la opcion 3, favor diligenciar los datos requeridos😉.");
                    System.out.println("Porfavor ingrese el nombre del contacto a buscar: ");
                    String busquedaNombre = scanner.nextLine();

                    List<Contacto> contactosEncontrados = new ArrayList<>();

                    for (Contacto contacto : agenda.getContactos()) {
                        if (contacto.getNombre().equalsIgnoreCase(busquedaNombre)) {
                            contactosEncontrados.add(contacto);
                        }
                    }

                    if (!contactosEncontrados.isEmpty()) {
                        System.out.println("Contactos encontrados con el nombre '" + busquedaNombre + "':");
                        for (Contacto contactoEncontrado : contactosEncontrados) {
                            System.out.println("--------------------------------");
                            System.out.println("|Nombre: " + contactoEncontrado.getNombre());
                            System.out.println("|Apellido: " + contactoEncontrado.getApellido());
                            System.out.println("|Numero: " + contactoEncontrado.getNumero());
                            System.out.println("--------------------------------");
                        }
                    } else {
                        System.out.println("No se encontraron contactos con el nombre '" + busquedaNombre + "'.");
                    }
                    break;
                case 4:
                    System.out.println("Usted ha seleccionado la opción 4, favor diligenciar los datos requeridos😉.");
                    System.out.println("Por favor ingrese el apellido del contacto a buscar: ");
                    String busquedaApellido = scanner.nextLine();

                    List<Contacto> contactosApellidoEncontrados = new ArrayList<>();

                    for (Contacto contacto : agenda.getContactos()) {
                        if (contacto.getApellido().equalsIgnoreCase(busquedaApellido)) {
                            contactosApellidoEncontrados.add(contacto);
                        }
                    }

                    if (!contactosApellidoEncontrados.isEmpty()) {
                        System.out.println("Contactos encontrados con el apellido '" + busquedaApellido + "':");
                        for (Contacto contactoEncontrado : contactosApellidoEncontrados) {
                            System.out.println("--------------------------------");
                            System.out.println("|Nombre: " + contactoEncontrado.getNombre());
                            System.out.println("|Apellido: " + contactoEncontrado.getApellido());
                            System.out.println("|Numero: " + contactoEncontrado.getNumero());
                            System.out.println("--------------------------------");
                        }
                    } else {
                        System.out.println("No se encontraron contactos con el apellido '" + busquedaApellido + "'.");
                    }
                    break;
                case 5:
                    System.out.println("Usted ha seleccionado la opción 5, favor diligenciar los datos requeridos😉.");
                    System.out.println("Por favor ingrese el numero del contacto a buscar: ");
                    String busquedaNumero = scanner.nextLine();

                    List<Contacto> contactosNumeroEncontrado = new ArrayList<>();

                    for (Contacto contacto : agenda.getContactos()){
                        if (contacto.getNumero().equals(busquedaNumero)) {
                            contactosNumeroEncontrado.add(contacto);
                        }
                    }
                    if (!contactosNumeroEncontrado.isEmpty()) {
                        System.out.println("Contacto encontrado con el numero '" + busquedaNumero + "':");
                        for (Contacto contactoEncontrado : contactosNumeroEncontrado){
                            System.out.println("--------------------------------");
                            System.out.println("|Nombre: " + contactoEncontrado.getNombre());
                            System.out.println("|Apellido: " + contactoEncontrado.getApellido());
                            System.out.println("|Numero: " + contactoEncontrado.getNumero());
                            System.out.println("--------------------------------");
                        }
                    } else {
                        System.out.println("No se encontraron contactos con el numero '" + busquedaNumero + "'.");
                    }
                    break;
                case 6:
                    System.out.println("Usted ha seleccionado la opción 6, favor diligenciar los datos requeridos😉.");
                    System.out.println("Porfavor ingrese el nombre de la persona de la cual desea editar su numero: ");
                    String numeroContactoEditar = scanner.nextLine();

                    if (agenda.validacionExistenciaContacto(numeroContactoEditar)){
                        System.out.println("Ingrese el nuevo numero de telefono📱:");
                        String numeroNuevo = scanner.nextLine();

                        for (Contacto contacto : agenda.getContactos()) {
                            if (contacto.getNombre().equalsIgnoreCase(numeroContactoEditar)) {
                                contacto.setNumero(numeroNuevo);
                                System.out.println("Numero de telefono actualizado satisfactoriamente😎.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("No se encontraron contactos con el nombre '"+ numeroContactoEditar + "'.");
                    }
                    break;
                case 7:
                    System.out.println("Usted ha seleccionado la opcion 7, a continuacion se le mostraran sus contactos ordenados alfabeticamente😉.");
                    List<Contacto> contactosOrdenados = new ArrayList<>(agenda.getContactos());

                    Comparator<Contacto> comparador = (contacto1, contacto2) -> contacto1.getApellido().compareToIgnoreCase(contacto2.getApellido());
                    Collections.sort(contactosOrdenados, comparador);

                    for (Contacto contactoOrdenado : contactosOrdenados) {
                        System.out.println("--------------------------------");
                        System.out.println("|Nombre: " + contactoOrdenado.getNombre());
                        System.out.println("|Apellido: " + contactoOrdenado.getApellido());
                        System.out.println("|Numero: " + contactoOrdenado.getNumero());
                        System.out.println("--------------------------------");
                    }
                    break;

                default:
                    System.out.println("Opcion invalida🤡🤓");
            }
        }
        while (opc < 7);
        System.out.println("Hasta Pronto🎆");
    }
}

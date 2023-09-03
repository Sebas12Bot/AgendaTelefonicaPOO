package Agenda;

import java.util.*;
import java.util.Collections;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
            System.out.println("|     8.Test Base Datos             |");
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
                        long numero = scanner.nextLong();
                        scanner.nextLine();

                        Contacto contactoNuevo = new Contacto(nombre, apellido, numero);
                        agenda.agregarContacto(contactoNuevo);
                    } else {
                        System.out.println("Lo sentimos, ya has agregado 50 contactos😪.");
                    }
                    break;
                case 2:
                    System.out.println("Usted ha seleccionado la opcion 2, favor diligenciar los datos requeridos😉.");
                    System.out.println("Digite el nombre o apellido o el numero del contacto que desea eliminar: ");
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
                    System.out.println("Por favor ingrese el número del contacto a buscar: ");
                    String busquedaNumero = scanner.nextLine();

                    List<Contacto> contactosNumeroEncontrado = new ArrayList<>();

                    for (Contacto contacto : agenda.getContactos()) {
                        long numero = Long.parseLong(busquedaNumero);

                        if (contacto.getNumero() == numero) {
                            contactosNumeroEncontrado.add(contacto);
                        }
                    }

                    if (!contactosNumeroEncontrado.isEmpty()) {
                        System.out.println("Contacto encontrado con el número '" + busquedaNumero + "':");
                        for (Contacto contactoEncontrado : contactosNumeroEncontrado) {
                            System.out.println("--------------------------------");
                            System.out.println("|Nombre: " + contactoEncontrado.getNombre());
                            System.out.println("|Apellido: " + contactoEncontrado.getApellido());
                            System.out.println("|Numero: " + contactoEncontrado.getNumero());
                            System.out.println("--------------------------------");
                        }
                    } else {
                        System.out.println("No se encontraron contactos con el número '" + busquedaNumero + "'.");
                    }
                    break;

                case 6:
                    System.out.println("Usted ha seleccionado la opción 6, favor diligenciar los datos requeridos😉.");
                    System.out.println("Por favor ingrese el nombre de la persona de la cual desea editar su número: ");
                    String nombreContactoEditar = scanner.nextLine();

                    if (agenda.validacionExistenciaContacto(nombreContactoEditar)){
                        System.out.println("Ingrese el nuevo número de teléfono📱:");
                        long numeroNuevo = scanner.nextLong();
                        scanner.nextLine();

                        for (Contacto contacto : agenda.getContactos()) {
                            if (contacto.getNombre().equalsIgnoreCase(nombreContactoEditar)) {
                                contacto.cambiarNumero(numeroNuevo);
                                System.out.println("Número de teléfono actualizado satisfactoriamente😎.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("No se encontraron contactos con el nombre '"+ nombreContactoEditar + "'.");
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
                case 8:
                    Connection connection = DataBase.getConnection();

                    if (connection != null) {
                        try {
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT * FROM agenda ORDER BY nombre, apellido");

                            while (resultSet.next()) {
                                String columna1 = resultSet.getString("numero");
                                String columna2 = resultSet.getString("nombre");
                                String columna3 = resultSet.getString("apellido");
                                System.out.println("|Numero: " + columna1);
                                System.out.println("|Nombre: " + columna2);
                                System.out.println("|Apellido: " + columna3);
                                System.out.println("--------------------------------");
                            }

                            resultSet.close();
                            statement.close();
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("No se pudo obtener la conexión a la base de datos");
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

package Agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AgendaTelefonica {
    private List<Contacto> contactos;

    public AgendaTelefonica() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        if (contactos.size() < 50) {
            contactos.add(contacto);
            System.out.println("El contacto fue agregado💫. ");
        } else {
            System.out.println("Tu agenda está llena😏.");
        }
    }

    public void eliminarContacto(String registro) {
        List<Contacto> contactosAEliminar = new ArrayList<>();

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(registro) ||
                    contacto.getApellido().equalsIgnoreCase(registro) ||
                    contacto.getNumero() == Long.parseLong(registro)) {
                contactosAEliminar.add(contacto);
            }
        }

        contactos.removeAll(contactosAEliminar);
    }

    public boolean validarExistenciaContacto(String registro) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(registro) ||
                    contacto.getApellido().equalsIgnoreCase(registro) ||
                    String.valueOf(contacto.getNumero()).equals(registro)) {
                return true;
            }
        }
        return false;
    }

    public List<Contacto> buscarPorNombre(String busquedaNombre) {
        List<Contacto> contactosEncontrados = new ArrayList<>();

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(busquedaNombre)) {
                contactosEncontrados.add(contacto);
            }
        }
        return contactosEncontrados;
    }

    public List<Contacto> buscarPorApellido(String busquedaApellido) {
        List<Contacto> contactosApellidoEncontrados = new ArrayList<>();

        for (Contacto contacto : contactos) {
            if (contacto.getApellido().equalsIgnoreCase(busquedaApellido)) {
                contactosApellidoEncontrados.add(contacto);
            }
        }
        return contactosApellidoEncontrados;
    }

    public List<Contacto> buscarPorNumero(String busquedaNumero) {
        List<Contacto> contactosNumeroEncontrado = new ArrayList<>();

        for (Contacto contacto : contactos) {
            long numero = Long.parseLong(busquedaNumero);

            if (contacto.getNumero() == numero) {
                contactosNumeroEncontrado.add(contacto);
            }
        }
        return contactosNumeroEncontrado;
    }

    public void editarNumero(String nombreContactoEditar, long numeroNuevo) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombreContactoEditar)) {
                contacto.cambiarNumero(numeroNuevo);
                System.out.println("Número de teléfono actualizado satisfactoriamente😎.");
                break;
            }
        }
    }

    public List<Contacto> ordenarAlfabeticamente() {
        List<Contacto> contactosOrdenados = new ArrayList<>(contactos);

        Comparator<Contacto> comparador = (contacto1, contacto2) -> contacto1.getApellido().compareToIgnoreCase(contacto2.getApellido());
        Collections.sort(contactosOrdenados, comparador);

        return contactosOrdenados;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public int getNumeroContactos() {
        return contactos.size();
    }
}

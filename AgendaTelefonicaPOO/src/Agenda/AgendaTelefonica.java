package Agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgendaTelefonica {
    private List<Contacto> contactos;
    public AgendaTelefonica(){
        contactos = new ArrayList<>();
    }

    public void agregarContacto (Contacto contacto){
        if (contactos.size() < 50) {
            contactos.add(contacto);
            System.out.println("El contacto fue agregado💫. ");
        } else {
            System.out.println("Tu agenda esta llena😏.");
        }
    }
    public void eliminarContacto(String registro) {
        List<Contacto> contactosAEliminar = new ArrayList<>();

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(registro) ||
                    contacto.getApellido().equalsIgnoreCase(registro) ||
                    contacto.getNumero().equalsIgnoreCase(registro)) {
                contactosAEliminar.add(contacto);
            }
        }

        contactos.removeAll(contactosAEliminar);
    }


    public boolean validacionExistenciaContacto(String registro){
        for (Contacto contacto : contactos){
            if (contacto.getNombre().equalsIgnoreCase(registro) ||
                contacto.getApellido().equalsIgnoreCase(registro) ||
                contacto.getNumero().equals(registro)){
                return true;
            }
        }
        return false;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public int getNumeroContactos() {
        return contactos.size();
    }
}

package aclaracionComparatorEquals;

import java.util.Comparator;

public class Persona {
    String nombre;
    int edad;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return edad == persona.edad && nombre.equals(persona.nombre);
    }
}

class PersonaComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.edad, p2.edad);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof PersonaComparator;
    }
}

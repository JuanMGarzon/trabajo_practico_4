package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Alumno;

@Service
public class AlumnoCollection {
    private List<Alumno> alumnos = new ArrayList<>();

    public List<Alumno> listar() {
        return alumnos;
    }

    public Alumno buscar(String dni) {
        for (Alumno alumno : alumnos) {
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
        }
        return null;
    }

    public void agregar(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void modificar(Alumno alumno) {
        Alumno existente = buscar(alumno.getDni());
        if (existente != null) {
            int index = alumnos.indexOf(existente);
            alumnos.set(index, alumno);
        }
    }

    public void eliminar(String dni) {
        Alumno alumno = buscar(dni);
        if (alumno != null) {
            alumnos.remove(alumno);
        }
    }
}

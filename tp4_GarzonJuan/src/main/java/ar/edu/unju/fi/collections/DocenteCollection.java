package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Docente;

@Service
public class DocenteCollection {
    private List<Docente> docentes = new ArrayList<>();

    public DocenteCollection() {
        // Agregar algunos docentes de ejemplo
        docentes.add(new Docente("D001", "Juan", "Pérez", "juan.perez@unju.edu.ar", "123456789"));
        docentes.add(new Docente("D002", "Ana", "Gómez", "ana.gomez@unju.edu.ar", "987654321"));
        docentes.add(new Docente("D003", "Carlos", "Rodríguez", "carlos.rodriguez@unju.edu.ar", "456123789"));
    }

    public List<Docente> listar() {
        return docentes;
    }

    public void agregar(Docente docente) {
        docentes.add(docente);
    }

    public Docente buscar(String legajo) {
        for (Docente docente : docentes) {
            if (docente.getLegajo().equalsIgnoreCase(legajo)) {
                return docente;
            }
        }
        return null;
    }

    public void eliminar(String legajo) {
        Docente docente = buscar(legajo);
        if (docente != null) {
            docentes.remove(docente);
        }
    }

    public void modificar(Docente docenteModificado) {
        Docente docente = buscar(docenteModificado.getLegajo());
        if (docente != null) {
            docente.setNombre(docenteModificado.getNombre());
            docente.setApellido(docenteModificado.getApellido());
            docente.setEmail(docenteModificado.getEmail());
            docente.setTelefono(docenteModificado.getTelefono());
        }
    }

    public Docente buscarPorLegajo(String legajo) {
        Optional<Docente> docenteOptional = docentes.stream()
                .filter(docente -> docente.getLegajo().equals(legajo))
                .findFirst();
        return docenteOptional.orElse(null);
    }
}

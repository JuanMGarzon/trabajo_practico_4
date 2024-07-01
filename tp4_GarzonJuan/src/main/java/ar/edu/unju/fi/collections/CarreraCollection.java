package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Carrera;

@Service
public class CarreraCollection {
    private List<Carrera> carreras = new ArrayList<>();

    public CarreraCollection() {
        // Agregar algunas carreras de ejemplo
        carreras.add(new Carrera("C001", "Ingeniería en Sistemas", 5, "Activa"));
        carreras.add(new Carrera("C002", "Licenciatura en Matemáticas", 4, "Activa"));
        carreras.add(new Carrera("C003", "Ingeniería Industrial", 5, "Inactiva"));
    }

    public List<Carrera> listar() {
        return carreras;
    }

    public void agregar(Carrera carrera) {
        carreras.add(carrera);
    }

    public Carrera buscar(String codigo) {
        for (Carrera carrera : carreras) {
            if (carrera.getCodigo().equalsIgnoreCase(codigo)) {
                return carrera;
            }
        }
        return null;
    }

    public void eliminar(String codigo) {
        Carrera carrera = buscar(codigo);
        if (carrera != null) {
            carreras.remove(carrera);
        }
    }

    public void modificar(Carrera carreraModificada) {
        Carrera carrera = buscar(carreraModificada.getCodigo());
        if (carrera != null) {
            carrera.setNombre(carreraModificada.getNombre());
            carrera.setCantidadAnios(carreraModificada.getCantidadAnios());
            carrera.setEstado(carreraModificada.getEstado());
        }
    }

    public Carrera buscarPorCodigo(String codigo) {
        Optional<Carrera> carreraOptional = carreras.stream()
                .filter(carrera -> carrera.getCodigo().equals(codigo))
                .findFirst();
        return carreraOptional.orElse(null);
    }
}


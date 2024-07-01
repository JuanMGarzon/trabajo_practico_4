package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraCollection carreraCollection;

    @GetMapping
    public String listarCarreras(Model model) {
        model.addAttribute("carreras", carreraCollection.listar());
        return "carreras";
    }

    @GetMapping("/nuevo")
    public String nuevaCarrera(Model model) {
        model.addAttribute("carrera", new Carrera());
        return "nuevaCarrera";
    }

    @PostMapping
    public String agregarCarrera(@ModelAttribute Carrera carrera) {
        carreraCollection.agregar(carrera);
        return "redirect:/carreras";
    }

    @GetMapping("/editar/{codigo}")
    public String editarCarrera(@PathVariable String codigo, Model model) {
        Carrera carrera = carreraCollection.buscar(codigo);
        model.addAttribute("carrera", carrera);
        return "editarCarrera";
    }

    @PostMapping("/modificar")
    public String modificarCarrera(@ModelAttribute Carrera carrera) {
        carreraCollection.modificar(carrera);
        return "redirect:/carreras";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarCarrera(@PathVariable String codigo) {
        carreraCollection.eliminar(codigo);
        return "redirect:/carreras";
    }
}

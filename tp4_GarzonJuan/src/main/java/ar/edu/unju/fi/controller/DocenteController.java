package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private DocenteCollection docenteCollection;

    @GetMapping
    public String listarDocentes(Model model) {
        model.addAttribute("docentes", docenteCollection.listar());
        return "docentes";
    }

    @GetMapping("/nuevo")
    public String nuevoDocente(Model model) {
        model.addAttribute("docente", new Docente());
        return "nuevoDocente";
    }

    @PostMapping
    public String agregarDocente(@ModelAttribute Docente docente) {
        docenteCollection.agregar(docente);
        return "redirect:/docentes";
    }

    @GetMapping("/editar/{legajo}")
    public String editarDocente(@PathVariable String legajo, Model model) {
        Docente docente = docenteCollection.buscar(legajo);
        model.addAttribute("docente", docente);
        return "editarDocente";
    }

    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute Docente docente) {
        docenteCollection.modificar(docente);
        return "redirect:/docentes";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable String legajo) {
        docenteCollection.eliminar(legajo);
        return "redirect:/docentes";
    }
}

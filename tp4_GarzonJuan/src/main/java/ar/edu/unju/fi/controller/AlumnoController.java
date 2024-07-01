package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoCollection listadoAlumno;

    @GetMapping
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", listadoAlumno.listar());
        return "alumnos";
    }

    @GetMapping("/nuevo")
    public String nuevoAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "nuevoAlumno";
    }

    @PostMapping
    public String agregarAlumno(@ModelAttribute Alumno alumno) {
        listadoAlumno.agregar(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/editar/{dni}")
    public String editarAlumno(@PathVariable String dni, Model model) {
        Alumno alumno = listadoAlumno.buscar(dni);
        model.addAttribute("alumno", alumno);
        return "editarAlumno";
    }

    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute Alumno alumno) {
        listadoAlumno.modificar(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable String dni) {
        listadoAlumno.eliminar(dni);
        return "redirect:/alumnos";
    }
}


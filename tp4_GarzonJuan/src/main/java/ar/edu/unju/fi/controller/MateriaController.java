package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaCollection materiaCollection;

    @Autowired
    private DocenteCollection docenteCollection;

    @Autowired
    private CarreraCollection carreraCollection;

    @GetMapping
    public String listarMaterias(Model model) {
        model.addAttribute("materias", materiaCollection.listar());
        return "materias";
    }

    @GetMapping("/nuevo")
    public String nuevaMateria(Model model) {
        model.addAttribute("materia", new Materia());
        model.addAttribute("docentes", docenteCollection.listar());
        model.addAttribute("carreras", carreraCollection.listar());
        return "nuevaMateria";
    }

    @PostMapping
    public String agregarMateria(@Validated @ModelAttribute Materia materia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("docentes", docenteCollection.listar());
            model.addAttribute("carreras", carreraCollection.listar());
            return "nuevaMateria";
        }
        // Obtener y asignar el docente y la carrera desde la base de datos
        Docente docente = docenteCollection.buscarPorLegajo(materia.getDocente().getLegajo());
        Carrera carrera = carreraCollection.buscarPorCodigo(materia.getCarrera().getCodigo());
        materia.setDocente(docente);
        materia.setCarrera(carrera);
        
        materiaCollection.agregar(materia);
        return "redirect:/materias";
    }

    @GetMapping("/editar/{codigo}")
    public String editarMateria(@PathVariable String codigo, Model model) {
        Materia materia = materiaCollection.buscar(codigo);
        model.addAttribute("materia", materia);
        model.addAttribute("docentes", docenteCollection.listar());
        model.addAttribute("carreras", carreraCollection.listar());
        return "editarMateria";
    }

    @PostMapping("/modificar")
    public String modificarMateria(@Validated @ModelAttribute Materia materia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("docentes", docenteCollection.listar());
            model.addAttribute("carreras", carreraCollection.listar());
            return "editarMateria";
        }
        // Obtener y asignar el docente y la carrera desde la base de datos
        Docente docente = docenteCollection.buscarPorLegajo(materia.getDocente().getLegajo());
        Carrera carrera = carreraCollection.buscarPorCodigo(materia.getCarrera().getCodigo());
        materia.setDocente(docente);
        materia.setCarrera(carrera);
        
        materiaCollection.modificar(materia);
        return "redirect:/materias";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable String codigo) {
        materiaCollection.eliminar(codigo);
        return "redirect:/materias";
    }
}

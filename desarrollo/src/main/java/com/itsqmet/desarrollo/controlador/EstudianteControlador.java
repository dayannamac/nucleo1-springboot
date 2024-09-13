package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Estudiante;
import com.itsqmet.desarrollo.servicios.impl.EstudianteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiante")
public class EstudianteControlador {

    @Autowired
    EstudianteServicioImpl estudianteServicioImpl;

    //LISTAR ESTUDIANTES
    @GetMapping()
    public String getAllEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteServicioImpl.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiante/listaEstudiante";
    }

    //AÑADIR ESTUDIANTE
    @GetMapping("/registrar")
    public String saveEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/formEstudiante";
    }

    @PostMapping("/registrar")
    public String saveEstudiante(@ModelAttribute Estudiante estudiante, Model model) {
        try {
            Estudiante savedEstudiante = estudianteServicioImpl.saveEstudiante(estudiante);
            model.addAttribute("estudiante", savedEstudiante);
            return "redirect:/estudiante";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el estudiante: " + e.getMessage());
            return "/estudiante/registrar";
        }
    }

    //EDITAR ESTUDIANTE
    @GetMapping("/editar/{idEstudiante}")
    public String updateEstudiante(@PathVariable int idEstudiante, Model model) {
        Optional<Estudiante> estudiante = estudianteServicioImpl.getEstudianteById(idEstudiante);
        if (estudiante.isPresent()) {
            model.addAttribute("estudiante", estudiante.get());
            return "estudiante/formEstudiante";
        } else {
            return "redirect:/estudiante";
        }
    }

    //ELIMINAR ESTUDIANTE
    @GetMapping("/eliminar/{idEstudiante}")
    public String deleteEstudiante(@PathVariable int idEstudiante, Model model) {
        Optional<Estudiante> estudiante = estudianteServicioImpl.getEstudianteById(idEstudiante);
        if (estudiante.isPresent()) {
            estudianteServicioImpl.deleteEstudiante(idEstudiante);
        } else {
            model.addAttribute("error", "Estudiante no encontrado.");
        }
        return "redirect:/estudiante";
    }

}

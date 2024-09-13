package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.*;
import com.itsqmet.desarrollo.servicios.impl.CursoServicioImpl;
import com.itsqmet.desarrollo.servicios.impl.EstudianteServicioImpl;
import com.itsqmet.desarrollo.servicios.impl.MatriculaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/matricula")
public class MatriculaControlador {

    @Autowired
    MatriculaServicioImpl matriculaServicioImpl;

    @Autowired
    EstudianteServicioImpl estudianteServicioImpl;

    @Autowired
    CursoServicioImpl cursoServicioImpl;

    //LISTAR MATRICULAS
    @GetMapping()
    public String getAllMatriculas(Model model){
        List<Matricula> matriculas = matriculaServicioImpl.getMatriculas();
        model.addAttribute("matriculas", matriculas);
        return "matricula/listaMatricula";
    }

    //AÑADIR MATRICULAS EN RELACION CON ESTUDIANTE Y CURSO
    @GetMapping("/registrar")
    public String saveMatricula(Model model){
        model.addAttribute("matricula", new Matricula());
        List<Estudiante> estudiantes = estudianteServicioImpl.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        List<Curso> cursos = cursoServicioImpl.getCursos();
        model.addAttribute("cursos", cursos);
        return "matricula/formMatricula";
    }

    @PostMapping("/registrar")
    public String saveMatricula(@ModelAttribute Matricula matricula, Model model){
        try{
            Matricula savedMatricula = matriculaServicioImpl.saveMatricula(matricula);
            model.addAttribute("matricula", savedMatricula);
            return "redirect:/matricula";
        }
        catch (Exception e){
            model.addAttribute("error", "Error al guardar la matricula"+ e.getMessage());
            return "/matricula/registrar";
        }
    }

    //EDITAR MATRICULA
    @GetMapping("/editar/{idMatricula}")
    public String updateMatricula(@PathVariable int idMatricula, Model model){
        Optional<Matricula> matricula = matriculaServicioImpl.getMatriculaById(idMatricula);
        if (matricula.isPresent()){
            model.addAttribute("matricula", matricula.get());
            // Se llama la lista de estudiantes y cursos registradas
            List<Estudiante> estudiantes = estudianteServicioImpl.getEstudiantes();
            model.addAttribute("estudiantes", estudiantes);
            List<Curso> cursos = cursoServicioImpl.getCursos();
            model.addAttribute("cursos", cursos);
            return "matricula/formMatricula";
        } else {
            return "redirect:/matricula";
        }
    }

    @PostMapping("/editar")
    public String updateMatricula(@ModelAttribute Matricula matricula, Model model) {
        try {
            matriculaServicioImpl.updateMatricula(matricula);
            return "redirect:/matricula";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar la matricula: " + e.getMessage());
            return "matricula/formMatricula";
        }
    }

    //ELIMINAR CURSO
    @GetMapping("/eliminar/{idMatricula}")
    public String deleteMatricula(@PathVariable int idMatricula, Model model){
        Optional<Matricula> matricula = matriculaServicioImpl.getMatriculaById(idMatricula);
        if (matricula.isPresent()){
            matriculaServicioImpl.deleteMatricula(idMatricula);
        } else {
            model.addAttribute("error", "Matricula no encontrada");
        }
        return "redirect:/matricula";
    }

}

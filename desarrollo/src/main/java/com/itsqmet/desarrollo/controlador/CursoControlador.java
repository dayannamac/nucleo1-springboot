package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Aula;
import com.itsqmet.desarrollo.modelo.Curso;
import com.itsqmet.desarrollo.modelo.Docente;
import com.itsqmet.desarrollo.servicios.impl.AulaServicioImpl;
import com.itsqmet.desarrollo.servicios.impl.CursoServicioImpl;
import com.itsqmet.desarrollo.servicios.impl.DocenteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/curso")
public class CursoControlador {

    @Autowired
    CursoServicioImpl cursoServicioImpl;

    @Autowired
    DocenteServicioImpl docenteServicioImpl;

    @Autowired
    AulaServicioImpl aulaServicioImpl;

    //LISTAR CURSOS
    @GetMapping()
    public String getAllCursos(Model model){
        List<Curso> cursos = cursoServicioImpl.getCursos();
        model.addAttribute("cursos", cursos);
        return "curso/listaCurso";
    }

    //AÑADIR CURSOS EN RELACION CON DOCENTE Y #AULA
    @GetMapping("/registrar")
    public String saveCurso(Model model){
        model.addAttribute("curso", new Curso());
        List<Docente> docentes = docenteServicioImpl.getDocentes();
        model.addAttribute("docentes", docentes);
        List<Aula> aulas = aulaServicioImpl.getAulas();
        model.addAttribute("aulas", aulas);
        return "curso/formCurso";
    }

    @PostMapping("/registrar")
    public String saveCurso(@ModelAttribute Curso curso, Model model){
        try {
            Curso savedCurso = cursoServicioImpl.saveCurso(curso);
            model.addAttribute("curso", savedCurso);
            return "redirect:/curso";
        }
        catch (Exception e){
            model.addAttribute("error", "Error al guardar el curso"+ e.getMessage());
            return "/curso/registrar";
        }
    }

    //EDITAR CURSO
    @GetMapping("/editar/{idCurso}")
    public String updateCurso(@PathVariable int idCurso, Model model){
        Optional<Curso> curso = cursoServicioImpl.getCursoById(idCurso);
        if (curso.isPresent()){
            model.addAttribute("curso", curso.get());
            // Se llama la lista de docentes y aulas registradas
            List<Docente> docentes = docenteServicioImpl.getDocentes();
            model.addAttribute("docentes", docentes);
            List<Aula> aulas = aulaServicioImpl.getAulas();
            model.addAttribute("aulas", aulas);
            return "curso/formCurso";
        } else {
            return "redirect:/curso";
        }
    }

    @PostMapping("/editar")
    public String updateCurso(@ModelAttribute Curso curso, Model model) {
        try {
            cursoServicioImpl.updateCurso(curso);
            return "redirect:/curso";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el curso: " + e.getMessage());
            return "curso/formCurso";
        }
    }

    //ELIMINAR CURSO
    @GetMapping("/eliminar/{idCurso}")
    public String deleteCurso(@PathVariable int idCurso, Model model){
        Optional<Curso> curso = cursoServicioImpl.getCursoById(idCurso);
        if (curso.isPresent()){
            cursoServicioImpl.deleteCurso(idCurso);
        } else {
            model.addAttribute("error", "Curso no encontrado");
        }
        return "redirect:/curso";
    }

}

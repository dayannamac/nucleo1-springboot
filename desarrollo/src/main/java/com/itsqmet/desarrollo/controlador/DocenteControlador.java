package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Docente;
import com.itsqmet.desarrollo.servicios.impl.DocenteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/docente")
public class DocenteControlador {

    @Autowired
    DocenteServicioImpl docenteServicioImpl;

    //LISTAR DOCENTES
    @GetMapping()
    public String getAllDocentes(Model model) {
        List<Docente> docentes = docenteServicioImpl.getDocentes();
        model.addAttribute("docentes", docentes);
        return "docente/listaDocente";
    }

    //AÑADIR ESTUDIANTE
    @GetMapping("/registrar")
    public String saveDocente(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente/formDocente";
    }

    @PostMapping("/registrar")
    public String saveDocente(@ModelAttribute Docente docente, Model model) {
        try {
            Docente savedDocente = docenteServicioImpl.saveDocente(docente);
            model.addAttribute("docente", savedDocente);
            return "redirect:/docente";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el docente: " + e.getMessage());
            return "/docente/registrar";
        }
    }

    //EDITAR DOCENTE
    @GetMapping("/editar/{idDocente}")
    public String updateDocente(@PathVariable int idDocente, Model model) {
        Optional<Docente> docente = docenteServicioImpl.getDocenteById(idDocente);
        if (docente.isPresent()) {
            model.addAttribute("docente", docente.get());
            return "docente/formDocente";
        } else {
            return "redirect:/docente";
        }
    }

    //ELIMINAR DOCENTE
    @GetMapping("/eliminar/{idDocente}")
    public String deleteDocente(@PathVariable int idDocente, Model model) {
        Optional<Docente> docente = docenteServicioImpl.getDocenteById(idDocente);
        if (docente.isPresent()) {
            docenteServicioImpl.deleteDocente(idDocente);
        } else {
            model.addAttribute("error", "Docente no encontrado.");
        }
        return "redirect:/docente";
    }

}

package com.itsqmet.desarrollo.controlador;

import com.itsqmet.desarrollo.modelo.Aula;
import com.itsqmet.desarrollo.servicios.impl.AulaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aula")
public class AulaControlador {

    @Autowired
    AulaServicioImpl aulaServicioImpl;

    //LISTAR AULAS
    @GetMapping()
    public String getAllAulas(Model model){
        List<Aula> aulas = aulaServicioImpl.getAulas();
        model.addAttribute("aulas", aulas);
        return "aula/listaAula";
    }

    //AÑADIR AULA
    @GetMapping("/registrar")
    public String saveAula(Model model){
        model.addAttribute("aula", new Aula());
        return "aula/formAula";
    }

    @PostMapping("/registrar")
    public String saveAula(@ModelAttribute Aula aula, Model model){
        try {
            Aula savedAula = aulaServicioImpl.saveAula(aula);
            model.addAttribute("aula", savedAula);
            return "redirect:/aula";
        }
        catch (Exception e){
            model.addAttribute("error", "Error al guardar el aula: "+ e.getMessage());
            return "/aula/registrar";
        }
    }

    //EDITAR AULA
    @GetMapping("/editar/{idAula}")
    public String updateAula(@PathVariable int idAula, Model model){
        Optional<Aula> aula = aulaServicioImpl.getAulaById(idAula);
        if(aula.isPresent()){
            model.addAttribute("aula", aula.get());
            return "aula/formAula";
        } else {
            return "redirect:/aula";
        }
    }

    //ELIMINAR AULA
    @GetMapping("/eliminar/{idAula}")
    public String deleteAula(@PathVariable int idAula, Model model){
        Optional<Aula> aula = aulaServicioImpl.getAulaById(idAula);
        if (aula.isPresent()){
            aulaServicioImpl.deleteAula(idAula);
        } else {
            model.addAttribute("error", "Aula no encontrada");
        }
        return "redirect:/aula";
    }

}

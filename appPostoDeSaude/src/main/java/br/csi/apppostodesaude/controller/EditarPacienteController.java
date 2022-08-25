package br.csi.apppostodesaude.controller;

import br.csi.apppostodesaude.model.Paciente;
import br.csi.apppostodesaude.model.Usuario;
import br.csi.apppostodesaude.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/editarPaciente")
public class EditarPacienteController {

    @PostMapping("/editar")
    public String editar(@ModelAttribute("paciente") Paciente paciente, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            System.out.println("entrou em EditarPacienteController/paciente/editar");
            String status = new PacienteService().editar(paciente);
            System.out.println(status);
            return new PacienteController().listarPacientes(model);
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            return "dashboard";
        }
        return "login";
    }
}

package br.csi.apppostodesaude.controller;

import br.csi.apppostodesaude.model.Medico;
import br.csi.apppostodesaude.model.Usuario;
import br.csi.apppostodesaude.service.MedicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/editarMedico")
public class editarMedicoController {

    @PostMapping("/editar")
    public String editar(@ModelAttribute("medico") Medico medico, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            String status = new MedicoService().editar(medico);
            System.out.println(status);
            return new MedicoController().listarMedicos(model);
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

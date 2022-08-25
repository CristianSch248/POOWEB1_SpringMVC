package br.csi.apppostodesaude.controller;

import br.csi.apppostodesaude.model.Consulta;
import br.csi.apppostodesaude.model.Usuario;
import br.csi.apppostodesaude.service.ConsultaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/editarConsulta")
public class EditarConsultaController {

    @PostMapping("/editar")
    public String editar(@ModelAttribute("consulta")Consulta consulta, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null) {
            String status = new ConsultaService().editar(consulta);
            System.out.println(status);
            return new ConsultaController().listarConsulta(model);
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            return "dashboard";
        }
        return "login";
    }
}

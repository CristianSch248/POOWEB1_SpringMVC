package br.csi.apppostodesaude.controller;

import br.csi.apppostodesaude.dao.ConsultaDAO;
import br.csi.apppostodesaude.model.Consulta;
import br.csi.apppostodesaude.model.Usuario;
import br.csi.apppostodesaude.service.ConsultaService;
import br.csi.apppostodesaude.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
    ConsultaService cs = new ConsultaService();
    PacienteService ps = new PacienteService();

    ConsultaDAO consultaDAO = new ConsultaDAO();
    @GetMapping
    public String listarConsulta(Model model){
        model.addAttribute(model.addAttribute("consultas", consultaDAO.getConsultas()));
        return "consulta/listarConsultas";
    }

    @PostMapping("/cadastrar")
    public String cadastraConsulta(@ModelAttribute("consulta") Consulta consulta, HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");

        if(usuario != null) {
            consultaDAO.cadastrar(consulta);
            model.addAttribute("consultas", consultaDAO.getConsultas());
            return listarConsulta(model);
        }
        return "login";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null) {
            model.addAttribute("consulta", new ConsultaDAO().getConsultaAtiva(id));
            model.addAttribute("consultas", consultaDAO.getConsultas());
            return "consulta/editarConsulta";
        }
        return "login";
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam int id, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null) {
            new ConsultaService().excluir(id);
            return listarConsulta(model);
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            return "dashboard";
        }
        return "login";
    }
}

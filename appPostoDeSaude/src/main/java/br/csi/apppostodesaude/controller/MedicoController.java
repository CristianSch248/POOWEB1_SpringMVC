package br.csi.apppostodesaude.controller;

import br.csi.apppostodesaude.dao.ConsultaDAO;
import br.csi.apppostodesaude.dao.MedicoDAO;
import br.csi.apppostodesaude.model.Consulta;
import br.csi.apppostodesaude.model.Medico;
import br.csi.apppostodesaude.model.Usuario;
import br.csi.apppostodesaude.service.ConsultaService;
import br.csi.apppostodesaude.service.MedicoService;
import br.csi.apppostodesaude.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/medico")
public class MedicoController {
    MedicoService medicoService = new MedicoService();
    ConsultaService cs = new ConsultaService();
    ConsultaDAO consultaDAO = new ConsultaDAO();
    PacienteService ps = new PacienteService();
    @GetMapping
    public String listarMedicos(Model model){
        model.addAttribute(model.addAttribute("medicos", medicoService.getMedicos()));
        return "medico/listarMedicos";
    }
    @PostMapping("cadastrar")
    public String cadastra(@ModelAttribute("medico") Medico medico, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            new MedicoService().cadastro(medico);
            model.addAttribute("medicos", medicoService.getMedicos());
            return listarMedicos(model);
        }
        return "login";
    }
    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            model.addAttribute("medico", new MedicoDAO().getMedico(id));
            model.addAttribute("medicos", medicoService.getMedicos());
            return "medico/editarMedicos";
        }
        return "login";
    }
    @GetMapping("excluir")
    public String excluir(@RequestParam int id, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            new MedicoService().excluir(id);
            return listarMedicos(model);
        }
        return "login";
    }

    //====================================================================================
    @PostMapping("/historico")
    public String mostrarHistorico(@RequestParam int id, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            model.addAttribute("medicos", new MedicoDAO().getMedicos());
            model.addAttribute("consultas",  consultaDAO.getHistoricoAtendimentoMedico(id));
            model.addAttribute("paciente", ps.getPacientes());
            //model.addAttribute("consulta", new Consulta());
            return "medico/historicoAtendimentoMedico";
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

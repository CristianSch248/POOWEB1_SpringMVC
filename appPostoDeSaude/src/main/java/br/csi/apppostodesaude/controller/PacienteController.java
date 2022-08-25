package br.csi.apppostodesaude.controller;

import br.csi.apppostodesaude.dao.ConsultaDAO;
import br.csi.apppostodesaude.dao.MedicoDAO;
import br.csi.apppostodesaude.dao.PacienteDAO;
import br.csi.apppostodesaude.model.Paciente;
import br.csi.apppostodesaude.model.Usuario;
import br.csi.apppostodesaude.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/paciente")
public class PacienteController {
    PacienteService pacienteService = new PacienteService();

    ConsultaDAO consultaDAO = new ConsultaDAO();
    MedicoDAO medicoDAO = new MedicoDAO();
    @GetMapping
    public String listarPacientes(Model model){
        model.addAttribute(model.addAttribute("pacientes", pacienteService.getPacientes()));
        return "paciente/listarPaciente";
    }

    @PostMapping("cadastrar")
    public String Cadastrar(@ModelAttribute("paciente") Paciente paciente, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            new PacienteService().cadastro(paciente);
            model.addAttribute("pacientes", pacienteService.getPacientes());
            return listarPacientes(model);
        }
        return "login";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            model.addAttribute("paciente", new PacienteDAO().getPacienteUnico(id));
            model.addAttribute("pacientes", pacienteService.getPacientes());
            return "paciente/editarPaciente";
        }
        return "login";
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam int id, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            new PacienteService().excluir(id);
            return listarPacientes(model);
        }
        return "login";
    }

    @PostMapping("/historico")
    public String mostrarHistorico(@RequestParam int id, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if (usuario != null) {
            model.addAttribute("pacientes", new PacienteDAO().getPacientes());
            model.addAttribute("consultas",  consultaDAO.getHistoricoConsultasPaciente(id));
            model.addAttribute("medico", medicoDAO.getMedicos());
            return "paciente/historicoConsultaPaciente";
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

package br.csi.apppostodesaude.controller;

import br.csi.apppostodesaude.dao.MedicoDAO;
import br.csi.apppostodesaude.dao.PacienteDAO;
import br.csi.apppostodesaude.model.Consulta;
import br.csi.apppostodesaude.model.Medico;
import br.csi.apppostodesaude.model.Paciente;
import br.csi.apppostodesaude.model.Usuario;
import br.csi.apppostodesaude.service.ConsultaService;
import br.csi.apppostodesaude.service.MedicoService;
import br.csi.apppostodesaude.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    PacienteService ps = new PacienteService();

    MedicoDAO medicoDAO = new MedicoDAO();
    PacienteDAO pacienteDAO  = new PacienteDAO();

    MedicoService ms = new MedicoService();

    ConsultaService cs = new ConsultaService();

    @GetMapping("/paciente")
    public String paciente(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("pacientes", ps.getPacientes());
            model.addAttribute("paciente", new Paciente());
            return "paciente/paciente";
        }
        return "login";
    }
    @GetMapping("/cadastrarPaciente")
    public String cadastrarPaciente(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("pacientes", ps.getPacientes());
            model.addAttribute("paciente", new Paciente());
            return "paciente/cadastrarPaciente";
        }
        return "login";
    }
    @GetMapping("/listarPaciente")
    public String listarPaciente(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("pacientes", ps.getPacientes());
            model.addAttribute("paciente", new Paciente());
            return "paciente/listarPaciente";
        }
        return "login";
    }

    @GetMapping("/medico")
    public String medico(@ModelAttribute("medico") Medico medico, HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("medicos", ms.getMedicos());
            return "medico/medico";
        }
        return "login";
    }

    @GetMapping("/cadastrarMedico")
    public String cadastrarMedico(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("medicos", ms.getMedicos());
            model.addAttribute("medico", new Medico());
            return "medico/cadastrarMedico";
        }
        return "login";
    }

    @GetMapping("/listarMedico")
    public String listarMedico(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("medicos", ms.getMedicos());
            model.addAttribute("medico", new Medico());
            return "medico/listarMedicos";
        }
        return "login";
    }

    @GetMapping("/cadastrarConsulta")
    public String cadastrarConsulta(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("paciente", new Paciente());
            model.addAttribute("pacientes", pacienteDAO.getPacientes());
            model.addAttribute("medico", new Medico());
            model.addAttribute("medicos", medicoDAO.getMedicos());
            model.addAttribute("consulta", new Consulta());
            return "consulta/cadastrarConsulta";
        }
        return "login";
    }

    @GetMapping("/listarConsultas")
    public String listarConsulta(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("consultas", cs.getConsultas());
            model.addAttribute("paciente", ps.getPacientes());
            model.addAttribute("medico", ms.getMedicos());
            model.addAttribute("consulta", new Consulta());
            return "consulta/listarConsultas";
        }
        return "login";
    }
    //============================================================================
    @GetMapping("/historicoAtendimento")
    public String historicoAtendimentoMedico(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("medico", new Medico());
            model.addAttribute("medicos", medicoDAO.getMedicos());
            return "medico/historicoAtendimentoMedico";
        }
        return "login";
    }

    @GetMapping("/historicoConsulta")
    public String historicoConsultaPaciente(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
        if(usuario != null){
            model.addAttribute("paciente", new Paciente());
            model.addAttribute("pacientes", pacienteDAO.getPacientes());
            return "paciente/historicoConsultaPaciente";
        }
        return "login";
    }
}

package br.csi.apppostodesaude.service;

import br.csi.apppostodesaude.dao.PacienteDAO;
import br.csi.apppostodesaude.model.Paciente;

import java.util.List;

public class PacienteService {
    public String cadastro(Paciente paciente){
        System.out.println("antes de chamar o DAO");
        PacienteDAO dao = new PacienteDAO();
        String status = dao.cadastrarPaciente(paciente);
        System.out.println(status);
        return status;
    }
    public List<Paciente> getPacientes(){ return new PacienteDAO().getPacientes(); }

    public String pacinteUnico(String nome, String cpf){
        Paciente paciente = new PacienteDAO().getPaciente(nome, cpf);
        return null;
    }

    public String editar (Paciente paciente){
        return new PacienteDAO().editarPaciente(paciente);
    }

    public String excluir (int id){
        return new PacienteDAO().excluirPaciente(id);
    }
}

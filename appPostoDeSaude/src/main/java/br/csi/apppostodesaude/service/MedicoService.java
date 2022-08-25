package br.csi.apppostodesaude.service;

import br.csi.apppostodesaude.dao.MedicoDAO;
import br.csi.apppostodesaude.model.Medico;

import java.util.List;

public class MedicoService {
    public String cadastro(Medico medico){
        MedicoDAO dao = new MedicoDAO();
        String status = dao.cadastraMedico(medico);
        System.out.println(status);
        return status;
    }
    public List<Medico> getMedicos(){
        return new MedicoDAO().getMedicos();
    }

    public String editar(Medico medico){
        return new MedicoDAO().editaMedico(medico);
    }

    public String excluir(int id){
        return new MedicoDAO().deletaMedico(id);
    }
}

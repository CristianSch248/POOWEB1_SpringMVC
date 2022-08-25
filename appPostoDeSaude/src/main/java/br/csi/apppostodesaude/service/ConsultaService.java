package br.csi.apppostodesaude.service;

import br.csi.apppostodesaude.dao.ConsultaDAO;
import br.csi.apppostodesaude.model.Consulta;
import java.util.List;
public class ConsultaService {
    public String cadastro(Consulta consulta){
        ConsultaDAO dao = new ConsultaDAO();
        String status = dao.cadastrar(consulta);
        System.out.println(status);
        return status;
    }

    public List<Consulta> getConsultas(){
        return new ConsultaDAO().getConsultas();
    }

    public String editar(Consulta consulta){
        System.out.println("estou no SERVICE editar da consulta");
        return new ConsultaDAO().editarConsulta(consulta);
    }

    public String excluir(int id){
        return new ConsultaDAO().deletaConsulta(id);
    }
}

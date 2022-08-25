package br.csi.apppostodesaude.service;

import br.csi.apppostodesaude.dao.UsuarioDAO;
import br.csi.apppostodesaude.model.Usuario;
public class UsuarioService {
    private UsuarioDAO dao;

    public Usuario autenticado(String email, String senha){

        dao = new UsuarioDAO();

        Usuario usuario = dao.getUsuario(email, senha);

        try{
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return usuario;
            }
        } catch (Exception e){
            e.printStackTrace();
            //throw new RuntimeException("Usuário não encontrado!", e);
        }
        return null;
    }
}

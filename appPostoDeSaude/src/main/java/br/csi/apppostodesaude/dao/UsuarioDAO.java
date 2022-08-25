package br.csi.apppostodesaude.dao;

import br.csi.apppostodesaude.model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public Usuario getUsuario(String email, String senha){
        Usuario usuario = null;

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT id_usuario, email_usuario, senha FROM usuario " +
                        " WHERE email_usuario = ? " +
                        "AND senha = ?;";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId((resultSet.getInt("id_usuario")));
                usuario.setEmail(resultSet.getString("email_usuario"));
                usuario.setSenha(resultSet.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public String cadastraUsuario(Usuario usuario){

        try(Connection connection = new ConectaDB().getConexao()){
            connection.setAutoCommit(false);

            this.sql = "INSERT  INTO usuario (email, senha, id_hospital)" +
                    "values (?, ?, ?); ";

            this.preparedStatement=connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, usuario.getEmail());
            this.preparedStatement.setString(2, usuario.getSenha());
            this.preparedStatement.setInt(3, usuario.getId());

            System.out.println(usuario.getEmail());
            System.out.println(usuario.getSenha());
            System.out.println(usuario.getId());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if(this.resultSet.getInt(1) > 0){
                this.status = "OK";
                connection.commit();
                System.out.println(this.status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
            System.out.println(this.status);
        }
        return this.status;
    }

    public String editarUsuario(Usuario usuario){
        try(Connection connection = new ConectaDB().getConexao()){
            connection.setAutoCommit(false);

            this.sql = "update USUARIO set email = ?, senha = ?, id_hospital = ?" +
                    "where id_usuario = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, usuario.getEmail());
            this.preparedStatement.setString(2, usuario.getSenha());
            this.preparedStatement.setInt(3, usuario.getId());
            this.preparedStatement.executeUpdate();

            if(this.preparedStatement.getUpdateCount() > 0){
                this.status = "OKk";
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }

    public String excluirUsuario(Usuario usuario){
        try(Connection connection = new ConectaDB().getConexao()){
            connection.setAutoCommit(false);

            this.sql = "DELETE FROM usuario WHERE id_usuario = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, usuario.getId());
            this.preparedStatement.executeUpdate();

            System.out.println(usuario.getId());

            if(this.preparedStatement.getUpdateCount() > 0){
                this.status = "OK";
                System.out.println(this.status);
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }
}

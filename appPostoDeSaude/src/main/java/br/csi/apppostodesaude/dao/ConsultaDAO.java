package br.csi.apppostodesaude.dao;

import br.csi.apppostodesaude.model.Consulta;

import java.sql.*;
import java.util.ArrayList;

public class ConsultaDAO {

    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Consulta> getConsultas(){
        ArrayList<Consulta> consultas = new ArrayList<>();
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT consulta.id_consulta, consulta.id_paciente, consulta.id_medico, nome_paciente, nome_medico, caso, data, hora, status_consulta " +
                    "FROM paciente, medico, consulta " +
                    "WHERE consulta.id_paciente = paciente.id_paciente " +
                    "AND consulta.id_medico = medico.id_medico " +
                    "and status_consulta = true";

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(this.sql);

            while(this.resultSet.next()){
                Consulta consulta = new Consulta();

                consulta.setId(this.resultSet.getInt("id_consulta"));
                consulta.setPaciente(new PacienteDAO().getPacienteUnico(resultSet.getInt("id_paciente")));
                consulta.setMedico(new MedicoDAO().getMedicoAtivo(resultSet.getInt("id_medico")));
                consulta.setCaso(this.resultSet.getString("caso"));
                consulta.setData(this.resultSet.getString("data"));;
                consulta.setHora(this.resultSet.getString("hora"));
                consulta.setStatus_consulta(this.resultSet.getBoolean("status_consulta"));
                consultas.add(consulta);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return consultas;
    }

    public String cadastrar(Consulta consulta){

        try(Connection connection = new ConectaDB().getConexao()){
            connection.setAutoCommit(false);

            this.sql = "INSERT INTO consulta (id_paciente, id_medico, caso, hora, data, status_consulta)" +
                    "VALUES(?, ?, ?, ?, ?, true); ";
            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setInt(1, consulta.getPaciente().getId());
            this.preparedStatement.setInt(2, consulta.getMedico().getId());
            this.preparedStatement.setString(3, consulta.getCaso());
            this.preparedStatement.setString(4, consulta.getHora());
            this.preparedStatement.setString(5, consulta.getData());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if(this.resultSet.getInt(1) > 0){
                this.status = "OK";
                connection.commit();
            }
        }catch(SQLException e){
            e.printStackTrace();
            this.status = "ERROR";
        }
        return this.status;
    }

    public Consulta getConsultaAtiva(int id){
        Consulta consulta = new Consulta();

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT consulta.id_consulta, consulta.id_paciente, consulta.id_medico, nome_paciente, nome_medico, caso, data, hora, status_consulta " +
                    "FROM paciente, medico, consulta " +
                    "WHERE consulta.id_paciente = paciente.id_paciente " +
                    "AND consulta.id_medico = medico.id_medico " +
                    "AND id_consulta = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet =this.preparedStatement.executeQuery();

            while(this.resultSet.next()){
                consulta.setId(resultSet.getInt("id_consulta"));
                consulta.setData(resultSet.getString("data"));
                consulta.setCaso(resultSet.getString("caso"));
                consulta.setStatus_consulta(resultSet.getBoolean("status_consulta"));
                consulta.setPaciente((new PacienteDAO().getPacienteUnico(resultSet.getInt("id_paciente"))));
                consulta.setMedico(new MedicoDAO().getMedicoAtivo(resultSet.getInt("id_medico")));
                consulta.setHora(resultSet.getString("hora"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

    public String editarConsulta(Consulta consulta){
        System.out.println("estrei no  DAO de editar consulta");

        try (Connection connection = new ConectaDB().getConexao()) {
            connection.setAutoCommit(false);

            System.out.println("estrei no  try de editar consulta");

            this.sql = "UPDATE consulta SET " +
                    "caso = ?, " +
                    "data = ?, " +
                    "hora = ? " +
                    "WHERE id_consulta = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, consulta.getCaso());
            this.preparedStatement.setString(2, consulta.getData());
            this.preparedStatement.setString(3, consulta.getHora());
            this.preparedStatement.setInt(4, consulta.getId());
            this.preparedStatement.executeUpdate();


            if(this.preparedStatement.getUpdateCount() > 0){
                this.status = "OK";
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.println("estrei no CATCH DO DAO de editar consulta");
            e.printStackTrace();
            this.status = "Erro";
        }
        System.out.println("SAINDO DO doa DE EDITAR");
        return this.status;
    }

    public String deletaConsulta(int id){
        try (Connection connection = new ConectaDB().getConexao()) {
            connection.setAutoCommit(false);

            this.sql = "UPDATE consulta SET status_consulta = false " +
                    "WHERE id_consulta = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                System.out.println(this.status);
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }
        return "";
    }
    //=================================================
    public ArrayList<Consulta> getHistoricoAtendimentoMedico(int id){
        ArrayList<Consulta> consultas = new ArrayList<>();
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT consulta.id_consulta, consulta.id_paciente, consulta.id_medico, nome_paciente, nome_medico, caso, data, hora, status_consulta " +
                    "FROM paciente, medico, consulta " +
                    "WHERE consulta.id_paciente = paciente.id_paciente " +
                    "AND consulta.id_medico = medico.id_medico " +
                    "AND consulta.status_consulta = false " +
                    "AND consulta.id_medico = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet =this.preparedStatement.executeQuery();

            while(this.resultSet.next()){
                Consulta consulta = new Consulta();
                consulta.setId(resultSet.getInt("id_consulta"));
                consulta.setData(resultSet.getString("data"));
                consulta.setCaso(resultSet.getString("caso"));
                consulta.setStatus_consulta(resultSet.getBoolean("status_consulta"));
                consulta.setPaciente((new PacienteDAO().getPacienteUnico(resultSet.getInt("id_paciente"))));
                consulta.setMedico(new MedicoDAO().getMedicoAtivo(resultSet.getInt("id_medico")));
                consulta.setHora(resultSet.getString("hora"));
                consultas.add(consulta);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public ArrayList <Consulta> getHistoricoConsultasPaciente(int id){
        ArrayList<Consulta> consultas = new ArrayList<>();
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT consulta.id_consulta, consulta.id_paciente, consulta.id_medico, nome_paciente, nome_medico, caso, data, hora, status_consulta " +
                    "FROM paciente, medico, consulta " +
                    "WHERE consulta.id_paciente = paciente.id_paciente " +
                    "AND consulta.id_medico = medico.id_medico " +
                    "AND consulta.status_consulta = false " +
                    "AND consulta.id_paciente = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet =this.preparedStatement.executeQuery();

            while(this.resultSet.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(resultSet.getInt("id_consulta"));
                consulta.setData(resultSet.getString("data"));
                consulta.setCaso(resultSet.getString("caso"));
                consulta.setStatus_consulta(resultSet.getBoolean("status_consulta"));
                consulta.setPaciente((new PacienteDAO().getPacienteUnico(resultSet.getInt("id_paciente"))));
                consulta.setMedico(new MedicoDAO().getMedicoAtivo(resultSet.getInt("id_medico")));
                consulta.setHora(resultSet.getString("hora"));
                consultas.add(consulta);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}

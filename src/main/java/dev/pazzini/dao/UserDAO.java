// Importa as classes necessárias
package dev.pazzini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.pazzini.dao.jdbc.ConnectionFactory;
import dev.pazzini.domain.TelephoneType;
import dev.pazzini.domain.User;

// Implementação da interface IUserDAO para operações de banco de dados relacionadas à entidade User
public class UserDAO implements IUserDAO {

  // Método para registrar um novo usuário no banco de dados
  @Override
  public Integer register(User user) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      // Obtém a conexão com o banco de dados
      connection = ConnectionFactory.getConnection();

      // Define a consulta SQL para inserir um novo usuário
      String query = "INSERT INTO tb_user(id, name, telephone, type) VALUES(nextval('sq_user'), ?, ?, ?::telephone_type)";
      
      // Prepara a declaração SQL com os parâmetros
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getTelephone());
      preparedStatement.setString(3, user.getTelephoneType().name());

      // Executa a atualização no banco de dados e retorna o resultado
      return preparedStatement.executeUpdate();
    } catch (Exception e) {
      // Lança uma exceção em caso de erro
      throw e;
    } finally {
      // Garante o fechamento seguro dos recursos
      if (preparedStatement != null && !preparedStatement.isClosed()) {
        preparedStatement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  // Método para remover um usuário do banco de dados
  @Override
  public Integer remove(User user) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      // Obtém a conexão com o banco de dados
      connection = ConnectionFactory.getConnection();

      // Define a consulta SQL para excluir um usuário
      String query = "DELETE FROM tb_user WHERE telephone = ?";
      
      // Prepara a declaração SQL com os parâmetros
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, user.getTelephone());

      // Executa a atualização no banco de dados e retorna o resultado
      return preparedStatement.executeUpdate();
    } catch (Exception e) {
      // Lança uma exceção em caso de erro
      throw e;
    } finally {
      // Garante o fechamento seguro dos recursos
      if (preparedStatement != null && !preparedStatement.isClosed()) {
        preparedStatement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  // Método para buscar todos os usuários no banco de dados
  @Override
  public List<User> searchAll() throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Obtém a conexão com o banco de dados
      connection = ConnectionFactory.getConnection();

      // Define a consulta SQL para selecionar todos os usuários
      String query = "SELECT * FROM tb_user";
      
      // Prepara a declaração SQL
      preparedStatement = connection.prepareStatement(query);

      // Executa a consulta no banco de dados e processa o resultado
      resultSet = preparedStatement.executeQuery();
      List<User> userList = new ArrayList<User>();

      while (resultSet.next()) {
        // Cria um objeto User para cada resultado da consulta
        User user = new User();
        user.setName(resultSet.getString("name"));
        user.setTelephone(resultSet.getString("telephone"));
        user.setTelephoneType(TelephoneType.valueOf(resultSet.getString("type")));
        userList.add(user);
      }

      // Retorna a lista de usuários
      return userList;
    } catch (Exception e) {
      // Lança uma exceção em caso de erro
      throw e;
    } finally {
      // Garante o fechamento seguro dos recursos
      if (preparedStatement != null && !preparedStatement.isClosed()) {
        preparedStatement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  // Método para buscar um usuário pelo número de telefone no banco de dados
  @Override
  public Optional<User> search(String telephone) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Obtém a conexão com o banco de dados
      connection = ConnectionFactory.getConnection();

      // Define a consulta SQL para selecionar um usuário pelo número de telefone
      String query = "SELECT * FROM tb_user WHERE telephone = ?";
      
      // Prepara a declaração SQL com os parâmetros
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, telephone);

      // Executa a consulta no banco de dados e processa o resultado
      resultSet = preparedStatement.executeQuery();
      User user = new User();

      while (resultSet.next()) {
        // Preenche o objeto User com os dados do resultado da consulta
        user.setName(resultSet.getString("name"));
        user.setTelephone(resultSet.getString("telephone"));
        user.setTelephoneType(TelephoneType.valueOf(resultSet.getString("type")));
      }

      // Retorna um Optional contendo o usuário (se encontrado) ou vazio
      if(user.getTelephone() == null) {
        return Optional.empty();
      }
      return Optional.of(user);
    } catch (Exception e) {
      // Lança uma exceção em caso de erro
      throw e;
    } finally {
      // Garante o fechamento seguro dos recursos
      if (preparedStatement != null && !preparedStatement.isClosed()) {
        preparedStatement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }
}

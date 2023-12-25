// Importa as classes necessárias
package dev.pazzini.dao;

import java.util.List;
import java.util.Optional;

import dev.pazzini.domain.User;

// Interface que define as operações do DAO para a entidade User
public interface IUserDAO {

  // Método para registrar um novo usuário no banco de dados
  public Integer register(User user) throws Exception;

  // Método para remover um usuário do banco de dados
  public Integer remove(User user) throws Exception;

  // Método para buscar todos os usuários no banco de dados
  public List<User> searchAll() throws Exception;

  // Método para buscar um usuário pelo número de telefone no banco de dados
  public Optional<User> search(String telephone) throws Exception;

}

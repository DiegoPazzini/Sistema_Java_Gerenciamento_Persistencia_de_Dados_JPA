// Importa as classes necessárias
package dev.pazzini.sample;

import dev.pazzini.dao.UserDAO;
import dev.pazzini.domain.TelephoneType;
import dev.pazzini.domain.User;

// Classe de exemplo que demonstra o uso da aplicação
public class SampleApplication {
  
  // Instâncias estáticas da entidade User e do DAO
  private static User user;
  private static UserDAO dao;

  // Método principal que é executado ao iniciar a aplicação
  public static void main(String[] args) throws Exception {
    // Cria uma instância da entidade User com valores específicos
    user = new User("Nath", "002", TelephoneType.LANDLINE);
    
    // Cria uma instância do DAO para interagir com o banco de dados
    dao = new UserDAO();

    // Registra o usuário no banco de dados usando o DAO
    dao.register(user);
  }
}

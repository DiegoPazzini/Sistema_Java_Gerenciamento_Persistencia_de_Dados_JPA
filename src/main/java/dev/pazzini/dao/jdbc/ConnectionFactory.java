// Importa as classes necessárias
package dev.pazzini.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe responsável por fornecer uma conexão com o banco de dados PostgreSQL
public class ConnectionFactory {
  // Instância única da conexão
  private static Connection connection;

  // Construtor privado para impedir a criação de instâncias externas
  private ConnectionFactory(Connection connection) {

  }

  // Método estático para obter uma instância da conexão
  public static Connection getConnection() throws SQLException {
    // Se a conexão ainda não foi inicializada ou está fechada, inicializa uma nova conexão
    if (connection == null || connection.isClosed()) {
      connection = initConnection();
    }
    // Retorna a instância da conexão
    return connection;
  }

  // Método privado para inicializar uma nova conexão com o banco de dados
  private static Connection initConnection() {
    try {
      // Estabelece uma conexão com o banco de dados PostgreSQL
      return DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_telephone_list",
          "telephone_list_user", "secret");
    } catch (SQLException e) {
      // Lança uma exceção em caso de erro na inicialização da conexão
      throw new RuntimeException(e);
    }
  }
}

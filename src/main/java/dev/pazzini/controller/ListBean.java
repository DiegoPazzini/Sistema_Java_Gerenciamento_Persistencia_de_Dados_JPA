// Importa as classes necessárias do pacote Java
package dev.pazzini.controller;

// Importa as classes do pacote Java que serão usadas na View
import java.io.Serializable;
import java.util.List;

// Importa as anotações do Java EE para a definição do escopo e nome do bean
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.annotation.PostConstruct;

// Importa as classes do projeto
import dev.pazzini.dao.UserDAO;
import dev.pazzini.domain.User;

// Define o nome do bean e o escopo de visão da JSF
@Named
@ViewScoped
public class ListBean implements Serializable {
  // Identificador único para a serialização
  private static final long serialVersionUID = 1L;

  // Instância do DAO para interação com o banco de dados
  private UserDAO dao;

  // Objeto User para manipulação na View
  private User user;

  // Lista de usuários a ser exibida na View
  private List<User> users;

  // Método executado após a criação do bean
  @PostConstruct
  public void init() throws Exception {
    // Inicializa o DAO e o objeto User
    dao = new UserDAO();
    user = new User();
    
    // Carrega a lista de usuários a partir do banco de dados
    users = dao.searchAll();
  }

  // Método getter para obter a lista de usuários
  public List<User> getList() throws Exception {
    return users;
  }

  // Método setter para definir o usuário atual
  public void setUser(User user) {
    this.user = user;
  }

  // Método getter para obter o usuário atual
  public User getUser() {
    return user;
  }

  // Método para excluir um usuário
  public void delete(User user) throws Exception {
    // Remove o usuário do banco de dados e da lista em memória
    dao.remove(user);
    users.remove(user);
  }
}

// Importa as classes necessárias
package dev.pazzini.domain;

// Classe que representa a entidade User
public class User {
  // Atributos da classe representando as propriedades do usuário
  private String name;
  private String telephone;
  private TelephoneType telephoneType;

  // Construtor padrão sem parâmetros
  public User() {
  }

  // Construtor com parâmetros para inicializar a entidade User
  public User(String name, String telephone, TelephoneType telephoneType) {
    this.name = name;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
  }

  // Método getter para obter o nome do usuário
  public String getName() {
    return name;
  }

  // Método setter para definir o nome do usuário
  public void setName(String name) {
    this.name = name;
  }

  // Método getter para obter o número de telefone do usuário
  public String getTelephone() {
    return telephone;
  }

  // Método setter para definir o número de telefone do usuário
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  // Método getter para obter o tipo de telefone do usuário
  public TelephoneType getTelephoneType() {
    return telephoneType;
  }

  // Método setter para definir o tipo de telefone do usuário
  public void setTelephoneType(TelephoneType telephoneType) {
    this.telephoneType = telephoneType;
  }
}

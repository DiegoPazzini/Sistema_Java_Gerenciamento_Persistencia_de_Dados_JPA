// Importa as classes necessárias
package dev.pazzini.domain;

// Enumeração que representa os tipos de telefone
public enum TelephoneType {
  // Constantes que representam os diferentes tipos de telefone
  LANDLINE("landline"), CELLPHONE("cellphone"), PUBLIC("public");

  // Atributo para armazenar a descrição do tipo de telefone
  private String description;

  // Construtor que associa uma descrição a cada constante
  TelephoneType(String description) {
    this.description = description;
  }

  // Método getter para obter a descrição do tipo de telefone
  public String getDescription() {
    return description;
  }
}

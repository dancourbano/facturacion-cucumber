Feature: Cliente Management

  Scenario: Registrar un cliente
    Given el cliente proporciona detalle de sus datos validos al usuario que registra
    When el usuario envia una solicitud POST al path "/cliente/"
    Then el status code de la respuesta deberia ser 200

  Scenario: Obtener un cliente existente
    Given un cliente registrado con el indice 1
    When el usuario envia una solicitud GET a "/cliente/indice"
    Then el code status de la respuesta debe ser 200
    And el cuerpo de la respuesta debe contener los detalles del cliente
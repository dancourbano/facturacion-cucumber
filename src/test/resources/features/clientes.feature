Feature: Cliente Management

  Scenario: Registrar un cliente
    Given el cliente proporciona detalle de sus datos validos al usuario que registra
    When el usuario envia una solicitud POST al path "/cliente/"
    Then el status code de la respuesta deberia ser 200

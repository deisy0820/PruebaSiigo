Feature: el usuario quiere validar un flujo completo de la API de ReqRes
  Para asegurar que los endpoints funcionan correctamente

  Background: Precondition
  Given que el usuario obtiene la url base de la api

  Scenario: yo como usuario espero crear, consultar,actulizar y eleiminar un registro registro
    When realiza un registro con email "eve.holt@reqres.in" y password "cityslicka"
    Then debería recibir un código de respuesta 401
    And la respuesta debería contener los campos
    |error|


    When consulta el usuario por id 2
    Then debería recibir un código de respuesta para  la consulta 401


    When actualiza el usuario con nombre "morpheus" y trabajo "zion resident"
    Then debería recibir un código de respuesta para la actualizacion 401

    When elimina el usuario con id 2
    Then debería recibir un código de respuesta para la eliminacion  401

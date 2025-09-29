Feature:Como usuario autenticado Quiero crear un cliente (tercero)
        en el sistema de siigo

  Scenario: Crear un cliente exitosamente
    Given que el usuario inicia sesión en la aplicación
    When crea un tercero con los siguientes datos
      | Tipo               | Es persona           |
      | TipoIdentificación | Cédula de ciudadanía |
      | Identificación     | 115218161            |
      | Nombres            | Daisy                |
      | Apellidos          | Mosquera             |
      | Ciudad             | Medellín             |
      | Dirección          | Calle 123            |
    Then el tercero debería quedar registrado correctamente
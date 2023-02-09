Feature: Login
  Como usuario quiero entrar a la página con mis credenciales.
  Scenario: Realizar login válido
    Given El usuario se encuentra en la pantalla de inicio de la pagina
    When El usuario introduce sus credenciales correctamente
    Then El usuario visualiza un mensaje de login exitoso

  Scenario: Realizar login inválido
    Given El usuario se encuentra en la pantalla de inicio de la pagina
    When El usuario introduce sus credenciales incorrectas
    Then El usuario visualiza un mensaje de login invalido

@test-execution
Feature:
  Yo como cliente de Web Driver
  Quiero darme de alta en la aplicación
  Para realizar login, signup, forms y sección webview

  @test-execution @test-group @CP001
  Scenario Outline: [CP001] Dar de alta a nuevo usuario - OK
    Given que me encuentro en la aplicación webdriver
    When doy de alta mi usuario "<email>" "<password>" "<repeatPassword>"
    Then validar alerta de usuario registrado
    Examples:
      | email                  | password | repeatPassword |
      | eberssgarcia@gmail.com | 12345678 | 12345678       |

  @test-execution @test-group @CP002
  Scenario Outline: [CP002] Login con usuario creado - OK
    Given que me encuentro en la aplicación webdriver
    When inicio sesión con mi usuario "<email>" "<password>"
    Then validar alerta de usuario logeado
    Examples:
      | email                  | password |
      | eberssgarcia@gmail.com | 12345678 |

  @test-execution @test-group @CP003
  Scenario Outline: [CP003] Completar formulario y activar
    Given que me encuentro en la aplicación webdriver
    When completo la sección Form "<input>" "<select>"
    And hago click en el boton Active
    Then validar alerta de button activo
    Examples:
      | input          | select            |
      | enviando texto | Appium is awesome |

  @test-execution @test-group @CP004
  Scenario: Realizar una busqueda de la palabra browser
    Given que me encuentro en la aplicación webdriver
    And ingreso a la opcion Webview
    When realizo una busqueda de la palabra "browser"
    Then deberia poder ver los resultados de la busqueda "browser"

  @test-execution @test-group @CP005
#  Scenario Outline: Realizar una busqueda de la palabra browser
#    Given que me encuentro en la aplicación webdriver
#    And ingreso a la opción Webview
#    When navego entre los "<tabs>"
#    Then debería poder ver los resultados de la búsqueda
#    Examples:
#      | tabs       |
#      | Docs       |
#      | API        |
#      | Help       |
#      | Versions   |
#      | Blog       |
#      | Contribute |
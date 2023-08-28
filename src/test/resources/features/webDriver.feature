#language: es

@test-execution
Característica: Dar de alta a usuario en aplicación para hacer busqueda y navegar en los tabs
  Yo como cliente de Web Driver
  Quiero darme de alta en la aplicación
  Para realizar login, signup, forms y sección webview

  @test-execution @test-group @CP001
  Esquema del escenario: [CP001] Dar de alta a nuevo usuario - OK
    Dado que me encuentro en la aplicación webdriver
    Cuando doy de alta mi usuario "<email>" "<password>" "<repeatPassword>"
    Entonces validar alerta de usuario registrado
    Ejemplos:
      | email                  | password | repeatPassword |
      | eberssgarcia@gmail.com | 12345678 | 12345678       |

  @test-execution @test-group @CP002
  Esquema del escenario: [CP002] Login con usuario creado - OK
    Dado que me encuentro en la aplicación webdriver
    Cuando inicio sesión con mi usuario "<email>" "<password>"
    Entonces validar alerta de usuario logeado
    Ejemplos:
      | email                  | password |
      | eberssgarcia@gmail.com | 12345678 |

  @test-execution @test-group @CP003
  Esquema del escenario: [CP003] Completar formulario y activar
    Dado que me encuentro en la aplicación webdriver
    Cuando completo la sección Form "<input>" "<select>"
    Y hago click en el boton Active
    Entonces validar alerta de button activo
    Ejemplos:
      | input          | select            |
      | enviando texto | Appium is awesome |

  @test-execution @test-group @CP004
  Escenario: Realizar una busqueda de la palabra browser
    Dado que me encuentro en la aplicación webdriver
    Y ingreso a la opcion Webview
    Cuando realizo una busqueda de la palabra "browser"
    Entonces deberia poder ver los resultados de la busqueda "browser"

  @test-execution @test-group @CP005
  Esquema del escenario: Realizar una busqueda de la palabra browser
    Dado que me encuentro en la aplicación webdriver
    Y ingreso a la opcion Webview
    Cuando navego entre los "<tabs>"
    Entonces deberia poder ver los resultados de la busqueda
    Ejemplos:
      | tabs       |
      | Docs       |
      | API        |
      | Contribute |
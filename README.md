# AUTOMATIZACIÓN DE APP EN ANDROID - [WDIO DEMO APP](https://github.com/webdriverio/native-demoapp/releases/download/v0.4.0/Android-NativeDemoApp-0.4.0.apk)

Este PORYECTO de automatización sobre la aplicación WDIO DEMO APP esta hecho con las herramientas Appium y
desarrollado con Java 1.8.

# Herramientas y/o tecnologías a usar

* **Intellij IDEA:** Este IDE permitirá crear proyectos.
* **JDK Java verisón 1.8:** Configurar como variable de entorno.
* **Depedencias Appium:** Estas dependencias se debe ingresar en el POM.XML
* **apache-maven-3.9.0:** Descargar package y configurar como variable de entorno.
* **Apppium Software:** [Click para descargar](https://github.com/appium/appium-desktop/releases/tag/v1.20.2)

# Configurar proyecto

1. Crear proyecto de tipo MAVEN
2. Ingresar las dependencias de selenium en el pom.xml
3. Ejecutar comando `mvn install` a través de la terminal

**Nota**: Si ya tienes definido test de prueba, puedes ejecutar el comando `mvn install -DskipTests` para omitir dichos
tests.

# Dependencias

1. **IO Appium**: Esta dependencia te permite escribir script con Appium enn Java.
   **`Repositorio`**: https://mvnrepository.com/artifact/io.appium/java-client

         <dependency>
             <groupId>io.appium</groupId>
             <artifactId>java-client</artifactId>
             <version>7.5.1</version>
         </dependency>

2. **Cucumber JUnit**: Esta dependencia es esencial para redactar casos de prueba.

**`Repositorio`**: https://mvnrepository.com/artifact/io.cucumber/cucumber-java

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.11.0</version>
        </dependency>

3. **Selenium Java**: Esta dependencia te permite utilizar Cucumber con jUnit

**`Repositorio`**: https://mvnrepository.com/artifact/io.cucumber/cucumber-junit

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>6.11.0</version>
            <scope>test</scope>
        </dependency>

# Tags para ejecución de feature

##### Para ejecutar los features de web, de manera independiente, utilizar lo siguiente:

| MOBILE Feature                           | TAG             |
|------------------------------------------|-----------------|
| Ejecución de todos los casos de pruebas. | @test-execution |
| Ejecutar casos de pruebas agrupados      | @test-group     |
| Ejecutar casos de pruebas independientes | @CP00*          | 

**Nota**: Para ejecutar un caso de prueba o muchos, debe ingresar el TAG de caso de prueba en la clase java: RunnerTest
en la opción verde tags = "@CP003"

# Visulización de reportes e imagenes adjunto

#### Para ver el reporte de ejecución de caso de prueba, debe esperar a que el caso de prueba finalice su ejecución y en la terminal de ejecución mostrará un link para aaceder al reporte. Debajo se muestra a detalle en imagenes:

![Reporte de ejecución de caso de prueba](/img/reporte_01.png)

![Visualización de reporte de ejecución de caso de prueba](/img/reporte_02.png)

# Referencias

* `Appium:` http://appium.io/docs/en/2.1/
* `Appium capabilities documentation:` https://appium.io/docs/en/2.1/guides/caps/#:~:text=Capabilities%20are%20represented%20as%20key,session%20to%20your%20client%20library



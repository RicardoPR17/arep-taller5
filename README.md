# **Taller 5 - Modularización con virtualización e introducción a Docker**
### *Hecho por Ricardo Pulido Renteria*

En este taller, se trabaja con Spark para crear un servidor sencillo en el cual se trabajen diferentes peticiones GET. Posteriormente, se procede a crear una imagen Docker del proyecto para poder ejecutarlo de forma virtualizada, verificar su funcionamiento y posteriormente ser publicado en Docker Hub.

## **Descarga y ejecución**

Para poder ejecutar este proyecto, el cual se ejecutará en tu ambiente local por fines de desarrollo y pruebas, debes contar con algunos elementos que serán indicados a continuación.


## **Prerequisitos**

La ejecución de este proyecto requiere de:
- `Java (versión 17 o superior)`
- `Maven (3.8.1 o superior)`
- `Conexión a internet`
- `Docker Desktop`


## **Instalación**

Para poder trabajar con el proyecto hay 2 opciones, descargarlo desde GitHub o descargar la imagen del proyecto de Docker Hub.

#### GitHub
Sí se descarga desde GitHub, primero se clona el repositorio en su máquina o puede descargarlo en formato zip. Luego, una vez acceda al directorio del proyecto, debe ejecutar el comando `mvn install` para descargar las dependencias del proyecto, ya sea desde la terminal de comandos o desde la terminal que le brinde el intérprete de código de su preferencia (VS Code, IntelliJ, NetBeans, etc).

Para ejecutarlo, podrá hacerlo desde la terminal de comandos como se explica a continuación. O desde el intérprete de código de su elección, haciendo `run` o ejecutando el código de la clase _SparkWebServer_.


- **_Ejecución usando terminal de comandos_**
  
  En caso de realizar la ejecución desde la terminal de comandos, se debe realizar lo siguiente:
  1. Acceder al directorio del proyecto usando el comando `cd arep-taller5`.
  2. Una vez dentro del directorio del proyecto, se ejecuta el comando `mvn clean install` para generar la carpeta _target_.
  3. Desde la terminal, ejecutamos el comando `java -cp "target/classes;target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer`. En caso de ejecutarse en Mac o Linux, cambiar el ; por :, es decir el comando sería `java -cp "target/classes:target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer`.
  4. Listo, el servidor web estará corriendo y verás un mensaje diciendo que el servidor ya inició.

#### Docker Hub

Primero, se descarga la imagen de Docker usando el comando `docker pull ricardopr17/firstsparkwebapprepo:latest` que nos traerá la versión más reciente. Hecho esto, podemos crear un contenedor donde ejecutar nuestro contenedor donde indicaremos el puerto físico donde acceder al servicio que ofrece y el puerto que se relaciona en el contenedor, en este caso usaremos el puerto físico 34000 y el comando es el siguiente `docker run -d -p 34000:47000 --name taller5-Ricardo ricardopr17/firstsparkwebapprepo:latest`.

## **Uso**

Si descargamos el proyecto desde GitHub, accedemos desde la ruta http://localhost:4567/, o con el puerto que tengamos en nuestras variables de entorno najo el nombre de `PORT`. Si ejecutamos el contenedor de Docker, accedemos desde la ruta http://localhost:34000/. En ambos casos, se tienen las siguientes opciones:

+ Seno con el ángulo en grados
+ Coseno con el ángulo en grados
+ Palíndromo
+ Magnitud de un vector

Todo eso es asequible mediante un formulario donde ver cada una de las opciones y obtener los resultados de cada una de ellas.


## **Diseño**

Para este proyecto se manejan una clase que es _SparkWebServer_, siendo la clase principal donde se configuraron las peticiones con el framework de Spark. Aquí, se asigna el puerto donde corra el servidor, el directorio de donde tomar los archivos estáticos del servidor y las peticiones GET que se responderán.

Adicional a ello, se definen los métodos de apoyo para la configuración y peticiones. Estos métodos son `getPort`, `checkPalindrome` y `vectorModule`.

Con el método de `location` se asigna la carpeta dentro del directorio _resources_ donde buscar los archivos estáticos que sean solicitados. En este caso, la carpeta se llama _public_ y en ella tenemos los archivos del formulario junto a su respectiva hoja de estilos y scripts.

En los scripts, se toma el contenido del formulario en particular para poder enviar la petición al servidor y obtener la respuesta para colocarla en el espacio de la respuesta indicado.

## **Pruebas**

Para estas pruebas, vamos a acceder a cada una de las rutas y luego mostrar en el formulario su funcionamiento. Haremos las mismas pruebas para varificar que se obtiene el mismo resultado. Para eso, se usará el navegador de Firefox y el apartado de red de su inspección de recursos.

+ Ejecución local de Java
  + Seno con el ángulo en grados: http://localhost:4567/sin/85

  ![Seno Java](<Imágenes README/seno java.png>)

  Con Wolfram vamos a verificar el resultado y vemos que es correcto.

  ![Seno wolfram](<Imágenes README/seno wolfram.png>)

  + Coseno con el ángulo en grados: http://localhost:4567/cos/25

  ![Coseno java](<Imágenes README/coseno java.png>)

  Con Wolfram vamos a verificar el resultado y vemos que es correcto.

  ![Coseno wolfram](<Imágenes README/coseno wolfram.png>)

  + Palíndromo:
    + Cadena palíndroma: http://localhost:4567/palindrome/radar

    ![palin bien](<Imágenes README/palin bien java.png>)

    + Cadena no palíndroma: http://localhost:4567/palindrome/taller

    ![palin mal](<Imágenes README/palin mal java.png>)

  + Magnitud de un vector: http://localhost:4567/module/30,25

  ![Módulo java](<Imágenes README/modulo java.png>)

  Nuevamente validamos con Wolfram y vemos que el resultado es correcto.

  ![Módulo wolfram](<Imágenes README/modulo wolfram.png>)

  + Formulario http://localhost:4567/form.html

  ![Form 1](<Imágenes README/Form 1 java.png>)

  ![Form 2](<Imágenes README/Form 2 java.png>)

  Si vemos el apartado de red, vemos las peticiones realizadas para cargar el formulario y las peticiones para cada operación.

  ![Red java](<Imágenes README/red java.png>)

+ Contenedor de Docker

Vemos que se corre el contenedor con el comando indicado al comienzo del documento

![Ejecutar contenedor](<Imágenes README/contenedor.png>)

  + Seno con el ángulo en grados: http://localhost:34000/sin/85

  ![Seno docker](<Imágenes README/seno docker.png>)

  + Coseno con el ángulo en grados: http://localhost:34000/cos/25

  ![Coseno docker](<Imágenes README/coseno docker.png>)

  + Palíndromo:
    + Cadena palíndroma: http://localhost:34000/palindrome/radar

    ![palin bien docker](<Imágenes README/palin bien docker.png>)

    + Cadena no palíndroma: http://localhost:34000/palindrome/taller

    ![palin mal docker](<Imágenes README/palin mal docker.png>)

  + Magnitud de un vector: http://localhost:34000/module/30,25

  ![Módulo docker](<Imágenes README/modulo docker.png>)

  + Formulario http://localhost:34000/form.html

  ![Form 1 docker](<Imágenes README/Form 1 docker.png>)

  ![Form 2 docker](<Imágenes README/Form 2 docker.png>)

  ![Red docker](<Imágenes README/red docker.png>)


## **Construido con**
  - [Git](https://git-scm.com) - Control de versiones
  - [Maven](https://maven.apache.org) - Administrador de dependencias
  - [Docker](https://www.docker.com/) - Manejo de contenedores

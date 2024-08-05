# 2024_2C_SC-304_GRUPO-7
Integrantes:  
*Isabel Rebeca Gutiérrez Hidalgo  
*Diego Andrés Ramírez Bolaños  
*Geylan Salas Chaves

## Plan de Proyecto para el Sistema de Gestión de Eventos Deportivos 
1. Definición de proyecto  
* **Objetivo:** Crear una aplicación para el registro de eventos deportivos, permitir a los administradores, registrador de eventos, participantes, programas de participantes, registrador de resultados y consulta de información relevante para los espectadores.  
* **Actividades:** Incluye funciones de registro, actualizaciones y asesoramiento sobre eventos, participantes, programa de participantes, resultados y clasificación de equipos.  

2. Fases del proyecto  
    1. Análisis y diseño  
            * **Requisitos funcionales:** detalle y valide todos los requisitos funcionales y funciones faltantes del sistema.  
            * **Diseño de arquitectura:** Definir la arquitectura general del sistema, incluyendo la estructura de datos y la interacción entre módulos.
    2. Implementación  
            * **Descripción funcional:** Implementar las funciones básicas del sistema en el diseño anterior.  
            * **Comprobaciones coherentes:** realice comprobaciones coherentes para garantizar que todos los componentes funcionen correctamente.  
    3. Integración y pruebas  
            * **Integración de componentes:** Unidad formada por varios módulos y componentes del sistema.  
            * **Pruebas del sistema:** realice pruebas de integración y del sistema para verificar la funcionalidad global y la interoperabilidad de los módulos.  
    4. Despliegue y Entrega  
            * **Requisitos del sistema:** Prepare la aplicación para eliminarla en un trabajo de producción.  
            * **Contenido y Capacidad:** Ingresar la aplicación al cliente, crear documentación y capacidad para usuarios finales y administradores.

3. Recursos Necesarios  
* **Recursos Humanos:** desarrolladores, testers y equipos de soporte técnico.  
* **Recursos Tecnológicos:** Entorno desarrollo, servidores para pruebas y producción, software para manejo de bases de datos.

## Diagrama de Clases

![Diagrama de clases del programa](/Imagenes/DiagramaClases.JPG)

## Menú principal
El menú principal va a mostrar la interfaz de selección de tipo de usuario, llámense Administrador y Espectador. Una vez seleccionado el usuario se muestra una nueva interfaz dependiendo de la selección con el nuevo submenú, como se muestra a continuación:

![Menú Principal del programa](/Imagenes/Menus/MenuPrincipal1.png)

### Submenú Administrador
En el caso del menú para Administrador se muestran las opciones de los siguientes requisitos funcionales, cada opción mostrará un nuevo submenú mostrando las opciones disponibles a seleccionar en cada requisito. Cada una de las opciones finales correrá el código necesario para cumplir los objetivos de dicha opción.

![Menú del usuario tipo Administrador](/Imagenes/Menus/MenuAdministrador.png)

1. Gestión de Eventos:  
   * Registrar Evento  
   * Actualizar Evento  
   * Eliminar Evento  
   * Lista de Eventos  
   * Lista de Participantes  

![Menú de Gestión de Eventos para Administrador](/Imagenes/Menus/GestionEventos.png)

2. Gestión de Participantes  
   * Registrar Participante  
   * Actualizar Participante  
   * Eliminar Participante

![Menú de Gestión de Participantes para Administrador](/Imagenes/Menus/GestionParticipantes.png)
    
3. Programación de Eventos  
   * Programar Partidos  
   * Calendario de Partidos

![Menú de Programación de Eventos para Administrador](/Imagenes/Menus/ProgramacionEventos1.png)
     
4. Resultados de Partidos  
   * Registrar Resultado  
   * Historial de Resultados

![Menú de Resultados de Partidos para Administrador](/Imagenes/Menus/ResultadosPartidos.png)  
   
6. Consultas  
   * Consulta de Participantes (consulta de la lista de participantes en un evento)  
   * Grafo de equipos (muestra el grafo de la representación de la relación de enfrentamientos entre equipos)  
   * Árbol de clasificación (muestra el árbol binario que gestiona la clasificación de los equipos)
  
![Menú de Consultas para Administrador](/Imagenes/Menus/Consultas.png)

### Submenú Espectador
Por otro lado, el menú para Espectador solamente va a mostrar las opciones finales. Al igual que en el caso del menú para Administrador, cada opción final correrá el código necesario para cumplir el objetivo en cada opción.
1. Consulta de Participantes  
2. Consulta de Eventos (muestra la lista de eventos y sus detalles)  
3. Consulta de Resultados  
4. Grafo de equipos  
5. Árbol de clasificación

![Menú del usuario tipo Espectador](/Imagenes/Menus/MenuEspectador.png) 

## Librerías a utilizar
* JOptionPane  

## Componentes visuales a utilizar
* JFrame Forms: para los menús.  
* Imagenes png: para los menús. Ubicadas en el archivo img en Source Packages.  
* InputDialog de JOptionPane: para insertar datos durante la corrida del código.  
* MessageDialog de JOptionPane: para mostrar datos resultantes del código en cada opción del menú.  

# 2024_2C_SC-304_GRUPO-7
Integrantes:  
*Isabel Rebeca Gutiérrez Hidalgo  
*Diego Andrés Ramírez Bolaños  

## Menú principal
El menú principal va a mostrar la interfaz de selección de tipo de usuario, llámense Administrador y Espectador. Una vez seleccionado el usuario se muestra una nueva interfaz dependiendo de la selección con el nuevo submenú, como se muestra a continuación:

![Menú Principal del programa](/Imagenes/Menus/MenuPrincipal.png)

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

![Menú de Programación de Eventos para Administrador](/Imagenes/Menus/ProgramacionEventos.png)
     
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

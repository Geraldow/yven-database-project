# Yven Project

##Introducción
Dedicado a crear experiencias inolvidables, únicas y significativas a través eventos especiales brindando a los usuarios la facilidad de organizar su propio evento de forma eficaz y eficiente.


## Instalación
### Para descargar el código fuente de Yven, sigue estos pasos:
1. Abre una terminal o línea de comandos en tu sistema.
2. Ubicarse en el escritorio.
3. Crear una carpeta llamada Proyecto.
4. Entrar a la carpeta recientemente creada.
5. Clonar el repositorio del proyecto.
6. Crear una carpeta para la aplicación web.
   
```sh
cd %USERPROFILE%\Desktop || cd %USERPROFILE%\OneDrive\Desktop
mkdir ispw_project
cd ispw_project
git clone https://github.com/Geraldow/yven-database-project
cd yven-database-project
```


## Flujo de trabajo
### Para enviar actualizaciones y creaciones de archivos al repositorio remoto, deben seguir estos pasos:
1. Ejecutar cmd en la barra de navegación desde la carpeta del proyecto.
2. Configurar su nombre y correo electrónico de Git de manera global o no para los registros de auditoría.
4. Ubicarse en la rama 'develop'.
6. Las nuevas ramas serán creadas desde 'develop' dependiendo de las asignaciones de cada desarrollador.
7. Crear archivos para el proyecto.
8. Visualizar los archivos disponibles.
9. Seleccionar las funcionalidades aptas.
10. Comentar los archivos elegidos.
11. Enviar los archivos al repositorio remoto.
12. Visualizar los cambios recientes desde el GitHub.

### Ejemplo

```sh
git config --global user.name "<nombre>"
git config --global user.email "<correo_electrónico>"
git checkout develop
git status
git add index.html
git commit
git push
git log -n 10
```

## Librerías y Frameworks aplicados
Spring Framework
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Thymeleaf
  - Spring Boot Starter Web
  - Spring Boot DevTools
MySQL Connector/J
Project Lombok
Spring Boot Starter Test


## Equipo 
- Geraldo Jaramillo Florida [71992956@certus.edu.pe]
- Dayne Fiorella Ruiz Fernandez [73987271@certus.edu.pe]
- Alessandro Miguel Arias Marquina [76287712@certus.edu.pe]


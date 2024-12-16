# 🎮 **Buscaminas en Consola**

Este proyecto es una implementación en consola del clásico juego **Buscaminas**, creado como examen final para la asignatura de **Programación Orientada a Objetos (POO)**. 

El juego utiliza conceptos fundamentales de programación orientada a objetos, como:
- **Encapsulamiento**  
- **Herencia**  
- **Manejo de Excepciones**  
- **Programación Modular**

---

## 📜 **Descripción del Proyecto**

El objetivo principal de este proyecto es ofrecer una experiencia interactiva para los usuarios mediante un tablero dinámico, el uso de lógica de programación modular y un sistema que simula las mecánicas del clásico juego de **Buscaminas**.

Este juego fue desarrollado para demostrar la aplicación de prácticas esenciales de la programación orientada a objetos, validación de datos y manejo de excepciones.

---

## 🏆 **Características del Juego**

### **1. Tablero Dinámico**

El juego cuenta con un tablero de tamaño **10x10**, donde se distribuyen **10 minas** de forma aleatoria.  

Cada celda del tablero puede ser explorada por el jugador para descubrir su contenido o marcada como sospechosa para identificar posibles minas.

---

### **2. Funcionalidades para el Usuario**

El juego ofrece varias opciones al jugador, incluyendo:

- **Explorar Casillas:** Permite descubrir celdas en busca de minas.
- **Marcar Casillas:** El jugador puede marcar áreas donde sospecha que se encuentran minas.
- **Guardar Progreso:** Puedes guardar el progreso del juego y retomarlo más tarde.
- **Cargar Juego:** Retomar el progreso guardado en caso de interrupciones.

---

### **3. Condiciones de Victoria y Derrota**

El juego tiene reglas claras para determinar el fin de la partida:

- 💥 **Derrota:** El jugador pierde si descubre una mina.
- 🏆 **Victoria:** El jugador gana al descubrir todas las casillas seguras en el tablero.

---

### **4. Manejo de Excepciones**

Se han implementado validaciones para garantizar una experiencia de usuario amigable y sin interrupciones inesperadas:

- 🚨 **Validación en la Entrada del Usuario:** Se verifican las acciones del jugador para evitar entradas no válidas.
- 🛠️ **Excepciones Personalizadas:**  
  - `CasillaYaDescubiertaException`: Se lanza si el usuario intenta descubrir una casilla que ya fue explorada.  
  - `CoordenadaInvalidaException`: Se lanza si el jugador ingresa una coordenada fuera de rango o inválida.

---

## ⚙️ **Requisitos del Sistema**

Antes de ejecutar el código en tu entorno, asegúrate de tener configurado lo siguiente:

| Requisito               | Descripción                          |
|--------------------------|--------------------------------------|
| **Java 11 o superior**  | Necesario para ejecutar el juego. |
| **JUnit 5**             | Herramienta para realizar pruebas unitarias. |
| **IDE recomendado (opcional)** | IntelliJ IDEA, Eclipse, NetBeans o cualquier IDE compatible. |

---

## 📂 **Instalación y Configuración**

Sigue estos pasos para ejecutar el proyecto en tu computadora local:

### **1. Clona el repositorio desde GitHub**

Abre tu terminal o línea de comandos y ejecuta el siguiente comando:

```bash
git clone https://github.com/Alberthluiiz/Guillen_Luis_Examen_final.git

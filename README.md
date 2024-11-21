# Plataforma Social - Modelo de Base de Datos

Este diseño de base de datos está optimizado para una plataforma de blogging con interacciones sociales. A continuación, se describe la estructura y justificación del modelo.

## 📊 **Estructura del Modelo**

### **Usuarios (`users`)**
- Gestión de usuarios con atributos como:
  - Nombre completo
  - Correo electrónico
  - Contraseña
  - Estado activo/inactivo

### **Publicaciones (`posts`)**
- Almacena publicaciones con:
  - Título y contenido
  - Fecha de creación y actualización
  - Relación con categorías y etiquetas

### **Interacciones Sociales**
- **Comentarios (`comments`)**: Los usuarios pueden comentar en publicaciones.
- **Likes (`likes`)**: Sistema de "me gusta" para publicaciones.
- **Seguimientos (`follows`)**: Relación de seguidores/seguidos entre usuarios.

### **Etiquetas y Categorías**
- **Categorías (`categories`)**: Clasificación de publicaciones por temas.
- **Etiquetas (`tags`, `post_tags`)**: Relación muchos a muchos para etiquetar posts.

### **Borradores (`drafts`)**
- Permite a los usuarios guardar publicaciones no publicadas para editarlas posteriormente.

### **Vistas de Posts (`post_views`)**
- Registro de visualizaciones de publicaciones para estadísticas.

---

## ✅ **Justificación del Diseño**

1. **Escalabilidad**:  
   - Relaciones 1 a muchos y muchos a muchos permiten manejar un alto volumen de datos sin pérdida de rendimiento.

2. **Funcionalidad Social**:  
   - Incluye soporte para comentarios, "me gusta" y seguimiento de usuarios para fomentar la interacción entre ellos.

3. **Flexibilidad**:  
   - Categorías y etiquetas permiten organizar y filtrar publicaciones fácilmente.

4. **Gestión Avanzada**:  
   - Funcionalidades como borradores y estadísticas de visualización enriquecen la experiencia del usuario y agregan valor.

---

## 🌟 **Características Clave**
- Modular y extensible para añadir futuras funcionalidades.
- Eficiencia en consultas gracias al uso de índices y relaciones bien definidas.
- Diseño intuitivo que facilita el mantenimiento y escalabilidad.

---
# Arquitectura Hexagonal 

La **Arquitectura Hexagonal** (también conocida como **Ports and Adapters**) es la elección ideal para este sistema debido a los siguientes beneficios clave:

###  Separación de Responsabilidades
La arquitectura hexagonal aísla la lógica de negocio de los detalles técnicos (bases de datos, APIs), lo que facilita su mantenimiento y evolución.

###  Facilidad de Pruebas
Permite probar la lógica de negocio de forma aislada utilizando **mocking**, sin necesidad de depender de la infraestructura, garantizando pruebas más rápidas y eficaces.

###  Escalabilidad y Flexibilidad
La modularidad de la arquitectura facilita la integración de nuevas funcionalidades, como sistemas de notificación, o cambios en la infraestructura (por ejemplo, cambiar la base de datos) sin afectar la lógica del negocio.

###  Reutilización de Código
El núcleo de negocio es independiente de las interfaces, lo que permite reutilizar el mismo código en diferentes interfaces (API REST, interfaces gráficas de usuario, etc.).

### Buenas Prácticas de Diseño
Implementa un diseño limpio, modular y fácil de mantener, demostrando buenas prácticas de arquitectura que aseguran la escalabilidad y sostenibilidad del sistema a largo plazo.

---

## Requisitos para ejecutar la aplicación

1. **Docker**: Ya que la aplicación utiliza un contenedor de PostgreSQL como base de datos.
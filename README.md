# Gestion des Étudiants et Cours

Application web de gestion des étudiants et des cours développée avec Spring Boot et Thymeleaf.

## 📋 Fonctionnalités

### Gestion des Cours
- Lister tous les cours
- Ajouter un nouveau cours
- Modifier un cours existant
- Supprimer un cours

### Gestion des Étudiants
- Lister tous les étudiants
- Ajouter un nouvel étudiant
- Modifier les informations d'un étudiant
- Supprimer un étudiant
- Associer un étudiant à un cours

## 🛠️ Technologies Utilisées

- **Backend**:
  - Java 17
  - Spring Boot 3.x
  - Spring Data JPA
  - Hibernate Validator
  - Maven

- **Frontend**:
  - Thymeleaf
  - Bootstrap 5.0
  - HTML5
  - CSS3

- **Base de données**:
  - MySQL
  - H2 (pour les tests)

## 🚀 Prérequis

- Java JDK 17 ou supérieur
- Maven 3.8+
- MySQL 8.0+ (ou une base de données compatible)
- Un IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## ⚙️ Installation

1. **Cloner le dépôt**
   ```bash
   git clone [URL_DU_DEPOT]
   cd student-course
   ```

2. **Configurer la base de données**
   - Créer une base de données MySQL nommée `student_course_db`
   - Configurer les identifiants dans `application.properties` si nécessaire

3. **Compiler et exécuter**
   ```bash
   mvn spring-boot:run
   ```

4. **Accéder à l'application**
   - Ouvrir un navigateur et aller à l'adresse : [http://localhost:8080](http://localhost:8080)

## 📂 Structure du Projet

```
src/
├── main/
│   ├── java/com/exam/student_course/
│   │   ├── controller/    # Contrôleurs Spring MVC
│   │   ├── entity/        # Entités JPA
│   │   ├── repository/    # Interfaces de repository
│   │   ├── service/       # Couche service
│   │   └── StudentCourseApplication.java  # Classe principale
│   └── resources/
│       ├── static/        # Fichiers statiques (CSS, JS, images)
│       ├── templates/     # Fichiers Thymeleaf
│       └── application.properties  # Configuration de l'application
└── test/                  # Tests unitaires et d'intégration
```

## 📝 Configuration

Le fichier `application.properties` contient les configurations principales :

```properties
# Configuration de la base de données
spring.datasource.url=jdbc:mysql://localhost:3306/student_course_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuration Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuration du serveur
server.port=8080
server.servlet.context-path=/
```

## 🧪 Tests

Pour exécuter les tests :
```bash
mvn test
```

## 📝 Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

## ✉️ Contact

Pour toute question ou suggestion, n'hésitez pas à me contacter.

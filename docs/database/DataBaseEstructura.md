# 📚 MorphoKey - Esquema de Base de Datos
Este repositorio contiene el esquema de base de datos para **MorphoKey**, una plataforma para el registro, exploración y gestión taxonómica de especies, publicaciones científicas y usuarios.

## 🗃️ Motor de Base de Datos

- **Sistema**: PostgreSQL
- **ORM compatible**: JPA/Hibernate (Java)

---

## 🧬 Estructura de la Base de Datos

La base de datos está dividida en varios dominios funcionales:
1. User
    * userID
    * name
    * last_name
    * email
    * creation_account_date
    * date_of_birth
    * role
    * status
    * updated_account_date
    * last_login_date

2. Password
    * passwordID
    * userID
    * password_hash
    * last_update
    
3. Publication
    * publicationID
    * title
    * body
    * sources
    * creation_date
    * updated_date
    * status
    * publication_type
    * userID
    cityID
---
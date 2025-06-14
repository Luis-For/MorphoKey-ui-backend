# 📚 MorphoKey - Esquema de Base de Datos
Este repositorio contiene el esquema de base de datos para **MorphoKey**, una plataforma para el registro, exploración y gestión taxonómica de especies, publicaciones científicas y usuarios.

## 🗃️ Motor de Base de Datos

- **Sistema**: PostgreSQL
- **ORM compatible**: JPA/Hibernate (Java)

---

## 🧬 Estructura de la Base de Datos

La base de datos está dividida en varios dominios funcionales:
## Dominios funcionales y sus campos principales

### 1. Country
- <span style="color:yellow;">countryID (UUID, PK)</style> 
- name (VARCHAR(100), NOT NULL)
- code (VARCHAR(10))
- description (TEXT)

### 2. City
- <span style="color:yellow;">cityID (UUID, PK)
- name (VARCHAR(100), NOT NULL)
- countryID (UUID, FK a Country.countryID, NOT NULL)
- description (TEXT)

### 3. Domain
- <span style="color:yellow;">domainID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- scientific_name (VARCHAR(50), NOT NULL)
- description (TEXT)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- photo_url (TEXT)

### 4. Kingdom
- <span style="color:yellow;">kingdomID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- scientific_name (VARCHAR(50), NOT NULL)
- description (TEXT)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- photo_url (TEXT)
- domainID (UUID, FK a Domain.domainID, NOT NULL)

### 5. Phylum
- <span style="color:yellow;">phylumID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- scientific_name (VARCHAR(50), NOT NULL)
- description (TEXT)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- photo_url (TEXT)
- kingdomID (UUID, FK a Kingdom.kingdomID, NOT NULL)

### 6. Class
- <span style="color:yellow;">classID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- scientific_name (VARCHAR(50), NOT NULL)
- description (TEXT)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- photo_url (TEXT)
- phylumID (UUID, FK a Phylum.phylumID, NOT NULL)

### 7. Order
- <span style="color:yellow;">orderID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- scientific_name (VARCHAR(50), NOT NULL)
- description (TEXT)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- photo_url (TEXT)
- classID (UUID, FK a Class.classID, NOT NULL)

### 8. Family
- <span style="color:yellow;">familyID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- scientific_name (VARCHAR(50), NOT NULL)
- description (TEXT)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- photo_url (TEXT)
- orderID (UUID, FK a Order.orderID, NOT NULL)

### 9. Genus
- <span style="color:yellow;">genusID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- scientific_name (VARCHAR(50), NOT NULL)
- description (TEXT)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- photo_url (TEXT)
- familyID (UUID, FK a Family.familyID, NOT NULL)

### 10. Species
- <span style="color:yellow;">speciesID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- scientific_name (VARCHAR(50), NOT NULL)
- description (TEXT)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- photo_url (TEXT)
- genusID (UUID, FK a Genus.genusID, NOT NULL)
- countryID (UUID, FK a Country.countryID, NOT NULL)

### 11. User
- <span style="color:yellow;">userID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- last_name (VARCHAR(50), NOT NULL)
- email (VARCHAR(50), UNIQUE, NOT NULL)
- password_hash (VARCHAR(255), NOT NULL)
- creation_account_date (DATE, NOT NULL)
- date_of_birth (DATE)
- role (VARCHAR(20))
- status (BOOLEAN, NOT NULL)
- phone (VARCHAR(15))
- profile_photo_url (TEXT)
- updated_account_date (DATE)
- last_login_date (TIMESTAMP)
- countryID (UUID, FK a Country.countryID)

### 12. Password (comentada)
- <span style="color:yellow;">passwordID (UUID, PK)
- userID (UUID, FK a User.userID, NOT NULL)
- password_hash (VARCHAR(255), NOT NULL)
- last_updated (TIMESTAMP, NOT NULL)

### 13. Publication_Type
- <span style="color:yellow;">publicationTypeID (UUID, PK)
- type_name (VARCHAR(50), NOT NULL)

### 14. Publication
- <span style="color:yellow;">publicationID (UUID, PK)
- title (VARCHAR(100))
- body (TEXT, NOT NULL)
- sources (VARCHAR(100))
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- status (BOOLEAN, NOT NULL)
- publicationTypeID (UUID, FK a Publication_Type.publicationTypeID, NOT NULL)
- userID (UUID, FK a User.userID, NOT NULL)
- cityID (UUID, FK a City.cityID, NOT NULL)

### 15. Comment
- <span style="color:yellow;">commentID (UUID, PK)
- publicationID (UUID, FK a Publication.publicationID, NOT NULL)
- userID (UUID, FK a User.userID, NOT NULL)
- content (TEXT, NOT NULL)
- comment_date (TIMESTAMP, NOT NULL)
- status (BOOLEAN, NOT NULL)
- parentCommentID (UUID, FK a Comment.commentID)

### 16. Publication_Reference
- <span style="color:yellow;">referenceID (UUID, PK)
- publicationID (UUID, FK a Publication.publicationID, NOT NULL)
- referencedEntityID (UUID, NOT NULL)
- entityType (VARCHAR(50), NOT NULL)
- description (TEXT)

### 17. Publication_Photo
- <span style="color:yellow;">photoID (UUID, PK)
- publicationID (UUID, FK a Publication.publicationID, NOT NULL)
- photo_url (TEXT, NOT NULL)
- description (VARCHAR(255))
- upload_date (DATE, NOT NULL)

### 18. Taxonomic_Question
- <span style="color:yellow;">questionID (UUID, PK)
- question_text (TEXT, NOT NULL)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)
- difficulty_level (VARCHAR(20))

### 19. Taxonomic_Option
- <span style="color:yellow;">optionID (UUID, PK)
- questionID (UUID, FK a Taxonomic_Question.questionID, NOT NULL)
- nextQuestionID (UUID, FK a Taxonomic_Question.questionID)
- speciesID (UUID, FK a Species.speciesID)
- option_text (VARCHAR(255), NOT NULL)

### 20. Characteristic_Type
- <span style="color:yellow;">characteristicTypeID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- description (TEXT)

### 21. Characteristic
- <span style="color:yellow;">characteristicID (UUID, PK)
- name (VARCHAR(50), NOT NULL)
- description (TEXT)
- characteristicTypeID (UUID, FK a Characteristic_Type.characteristicTypeID, NOT NULL)
- creation_date (DATE, NOT NULL)
- updated_date (DATE)

### 22. Species_Characteristic
- <span style="color:yellow;">speciesCharacteristicID (UUID, PK)
- speciesID (UUID, FK a Species.speciesID, NOT NULL)
- characteristicID (UUID, FK a Characteristic.characteristicID, NOT NULL)
- observation (TEXT)
- association_date (DATE, NOT NULL)

---

url para la conexión: 
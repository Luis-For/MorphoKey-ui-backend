// Taxonomy Tables
Table Domain {
  domainID uuid [primary key]
  name varchar(50)
  scientific_name varchar(50)
  description text
  creation_date date
  updated_date date
  status boolean
  photo_url text [note: 'Optional']
}

Table Kingdom {
  kingdomID uuid [primary key]
  name varchar(50)
  scientific_name varchar(50)
  description text
  creation_date date
  updated_date date
  status boolean
  photo_url text [note: 'Optional']
  domainID uuid [ref: > Domain.domainID]
}

Table Phylum {
  phylumID uuid [primary key]
  name varchar(50)
  scientific_name varchar(50)
  description text
  creation_date date
  updated_date date
  status boolean
  photo_url text [note: 'Optional']
  kingdomID uuid [ref: > Kingdom.kingdomID]
}

Table Class {
  classID uuid [primary key]
  name varchar(50)
  scientific_name varchar(50)
  description text
  creation_date date
  updated_date date
  status boolean
  photo_url text [note: 'Optional']
  phylumID uuid [ref: > Phylum.phylumID]
}

Table Order {
  orderID uuid [primary key]
  name varchar(50)
  scientific_name varchar(50)
  description text
  creation_date date
  updated_date date
  status boolean
  photo_url text [note: 'Optional']
  classID uuid [ref: > Class.classID]
}

Table Family {
  familyID uuid [primary key]
  name varchar(50)
  scientific_name varchar(50)
  description text
  creation_date date
  updated_date date
  status boolean
  photo_url text [note: 'Optional']
  orderID uuid [ref: > Order.orderID]
}

Table Genus {
  genusID uuid [primary key]
  name varchar(50)
  scientific_name varchar(50)
  description text
  creation_date date
  updated_date date
  status boolean
  photo_url text [note: 'Optional']
  familyID uuid [ref: > Family.familyID]
}

Table Species {
  speciesID uuid [primary key]
  name varchar(50)
  scientific_name varchar(50)
  description text
  creation_date date
  updated_date date
  status boolean
  photo_url text [note: 'Optional']
  genusID uuid [ref: > Genus.genusID]
  countryID uuid [ref: > Country.countryID]
}

// User Tables
Table User {
  userID uuid [primary key]
  name varchar(50)
  last_name varchar(50)
  email varchar(50) [unique]
  creation_account_date date
  date_of_birth date
  role varchar(20)
  status boolean
  updated_account_date date
  last_login_date timestamp [note: 'Optional']
}

Table User_Contact {
  contactID uuid [primary key]
  userID uuid [ref: > User.userID]
  phone varchar(15)
  profile_photo_url text [note: 'Optional']
  countryID uuid [ref: > Country.countryID]
}

Table Password {
  passwordID uuid [primary key]
  userID uuid [ref: > User.userID]
  password_hash varchar(255)
  last_updated timestamp
}

// Publication Tables
Table Publication {
  publicationID uuid [primary key]
  title varchar(100) [note: 'Optional']
  body text
  sources varchar(100) [note: 'Optional']
  creation_date date
  updated_date date
  status boolean
  publication_type varchar(50) [note: 'Ejemplos: BLOG, OFFICIAL, LOGBOOK, NOTE']
  userID uuid [ref: > User.userID]
  cityID uuid [ref: > City.cityID]
}

Table Comment {
  commentID uuid [primary key]
  publicationID uuid [ref: > Publication.publicationID]
  userID uuid [ref: > User.userID]
  content text
  comment_date timestamp
  status boolean [note: 'true for active, false for hidden']
  parentCommentID uuid [ref: > Comment.commentID, note: 'Referencia al comentario padre (si es una respuesta)']
}

Table Entity_Type {
  entityTypeID uuid [primary key]
  name varchar(50)
}

Table Publication_Reference {
  referenceID uuid [primary key]
  publicationID uuid [ref: > Publication.publicationID]
  referencedEntityID uuid
  entityTypeID uuid [ref: > Entity_Type.entityTypeID]
  description text
}

Table Publication_Photo {
  photoID uuid [primary key]
  publicationID uuid [ref: > Publication.publicationID]
  photo_url text
  description varchar(255) [note: 'Optional']
  upload_date date
}

// Taxonomic Question System
Table Taxonomic_Question {
  questionID uuid [primary key]
  question_text text
  creation_date date
  updated_date date
  difficulty_level varchar(20)
}

Table Taxonomic_Option {
  optionID uuid [primary key]
  questionID uuid [ref: > Taxonomic_Question.questionID]
  nextQuestionID uuid [ref: > Taxonomic_Question.questionID]
  speciesID uuid [ref: > Species.speciesID]
  option_text varchar(255)
}

Table Option_Species {
  optionSpeciesID uuid [primary key]
  optionID uuid [ref: > Taxonomic_Option.optionID]
  speciesID uuid [ref: > Species.speciesID]
}

// Characteristics Tables
Table Characteristic {
  characteristicID uuid [primary key]
  name varchar(50)
  description text
  characteristicTypeID uuid [ref: > Characteristic_Type.characteristicTypeID]
  creation_date date
  updated_date date
}

Table Characteristic_Type {
  characteristicTypeID uuid [primary key]
  name varchar(50)
  description text
}

Table Species_Characteristic {
  speciesCharacteristicID uuid [primary key]
  speciesID uuid [ref: > Species.speciesID]
  characteristicID uuid [ref: > Characteristic.characteristicID]
  observation text
  association_date date
}

// Country and City Tables
Table Country {
  countryID uuid [primary key]
  name varchar(100)
  code varchar(10)
  description text [note: 'Optional']
}

Table City {
  cityID uuid [primary key]
  name varchar(100)
  countryID uuid [ref: > Country.countryID]
  description text [note: 'Optional']
}


Ref: "Class"."scientific_name" < "Class"."name"

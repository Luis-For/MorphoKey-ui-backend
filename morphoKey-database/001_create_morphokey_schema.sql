--Taxon Tables
CREATE TABLE Domain (
  domainID SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE NOT NULL,
  photo_url TEXT
);

CREATE TABLE Kingdom (
  kingdomID SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE NOT NULL,
  photo_url TEXT,
  domainID INTEGER NOT NULL,
  FOREIGN KEY (domainID) REFERENCES Domain(domainID) ON DELETE CASCADE
);

CREATE TABLE Phylum (
  phylumID SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE NOT NULL,
  photo_url TEXT,
  kingdomID INTEGER NOT NULL,
  FOREIGN KEY (kingdomID) REFERENCES Kingdom(kingdomID) ON DELETE CASCADE
);

CREATE TABLE Class (
  classID SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE NOT NULL,
  photo_url TEXT,
  phylumID INTEGER NOT NULL,
  FOREIGN KEY (phylumID) REFERENCES Phylum(phylumID) ON DELETE CASCADE
);

CREATE TABLE "Order" (
  orderID SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE NOT NULL,
  photo_url TEXT,
  classID INTEGER NOT NULL,
  FOREIGN KEY (classID) REFERENCES Class(classID) ON DELETE CASCADE
);

CREATE TABLE Family (
  familyID SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE NOT NULL,
  photo_url TEXT,
  orderID INTEGER NOT NULL,
  FOREIGN KEY (orderID) REFERENCES "Order"(orderID) ON DELETE CASCADE
);

CREATE TABLE Genus (
  genusID SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE NOT NULL,
  photo_url TEXT,
  familyID INTEGER NOT NULL,
  FOREIGN KEY (familyID) REFERENCES Family(familyID) ON DELETE CASCADE
);

CREATE TABLE Country (
  countryID SERIAL PRIMARY KEY,
  name VARCHAR(100),
  code INTEGER,
  description TEXT
);

CREATE TABLE Species (
  speciesID SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE NOT NULL,
  photo_url TEXT,
  genusID INTEGER NOT NULL,
  countryID INTEGER NOT NULL,
  FOREIGN KEY (genusID) REFERENCES Genus(genusID) ON DELETE CASCADE,
  FOREIGN KEY (countryID) REFERENCES Country(countryID)
);

-- User Tables
CREATE TABLE "User" (
  userID UUID PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  user_name VARCHAR(50) UNIQUE NOT NULL,
  email VARCHAR(50) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  creation_account_date DATE NOT NULL,
  date_of_birth DATE NOT NULL,
  role VARCHAR(20) NOT NULL,
  status BOOLEAN NOT NULL DEFAULT TRUE,
  verified BOOLEAN NOT NULL DEFAULT FALSE,
  updated_account_date DATE,
  last_login_date TIMESTAMP,
  photo_profile TEXT
);

--Publication and content table
CREATE TABLE City (
  cityID SERIAL PRIMARY KEY,
  name VARCHAR(100),
  countryID INTEGER,
  description TEXT,
  FOREIGN KEY (countryID) REFERENCES Country(countryID)
);

CREATE TABLE Publication (
  publicationID SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  body TEXT NOT NULL,
  sources TEXT,
  creation_date DATE NOT NULL,
  updated_date DATE,
  status BOOLEAN,
  publication_type VARCHAR(50),
  userID UUID NOT NULL,
  cityID INTEGER NOT NULL,
  FOREIGN KEY (userID) REFERENCES "User"(userID) ON DELETE CASCADE,
  FOREIGN KEY (cityID) REFERENCES City(cityID)
);

CREATE TABLE Comment (
  commentID SERIAL PRIMARY KEY,
  publicationID INTEGER,
  userID UUID,
  content TEXT,
  comment_date TIMESTAMP,
  status BOOLEAN,
  parentCommentID INTEGER,
  FOREIGN KEY (publicationID) REFERENCES Publication(publicationID) ON DELETE CASCADE,
  FOREIGN KEY (userID) REFERENCES "User"(userID),
  FOREIGN KEY (parentCommentID) REFERENCES Comment(commentID) ON DELETE CASCADE
);

CREATE TABLE Score (
  publicationID INTEGER,
  userID UUID,
  score INTEGER,
  description TEXT,
  PRIMARY KEY (publicationID, userID),
  FOREIGN KEY (publicationID) REFERENCES Publication(publicationID) ON DELETE CASCADE,
  FOREIGN KEY (userID) REFERENCES "User"(userID) ON DELETE CASCADE
);

CREATE TABLE Entity_Type (
  entityTypeID SERIAL PRIMARY KEY,
  name VARCHAR(50)
);

CREATE TABLE Publication_Reference (
  referenceID SERIAL PRIMARY KEY,
  publicationID INTEGER,
  referencedEntityID INTEGER,
  entityTypeID INTEGER,
  description TEXT,
  FOREIGN KEY (publicationID) REFERENCES Publication(publicationID) ON DELETE CASCADE,
  FOREIGN KEY (entityTypeID) REFERENCES Entity_Type(entityTypeID)
);

CREATE TABLE Publication_Photo (
  photoID TEXT PRIMARY KEY,
  publicationID INTEGER,
  photo_url TEXT,
  description VARCHAR(255),
  upload_date DATE,
  FOREIGN KEY (publicationID) REFERENCES Publication(publicationID) ON DELETE CASCADE
);

--Taxon Question
CREATE TABLE Taxonomic_Question (
  questionID UUID PRIMARY KEY,
  question_text TEXT,
  creation_date DATE,
  updated_date DATE,
  difficulty_level VARCHAR(20)
);

CREATE TABLE Taxonomic_Option (
  optionID UUID PRIMARY KEY,
  questionID UUID,
  nextQuestionID UUID,
  speciesID INTEGER,
  option_text VARCHAR(255),
  FOREIGN KEY (questionID) REFERENCES Taxonomic_Question(questionID) ON DELETE CASCADE,
  FOREIGN KEY (nextQuestionID) REFERENCES Taxonomic_Question(questionID),
  FOREIGN KEY (speciesID) REFERENCES Species(speciesID)
);

CREATE TABLE Option_Species (
  optionSpeciesID UUID PRIMARY KEY,
  optionID UUID,
  speciesID INTEGER,
  FOREIGN KEY (optionID) REFERENCES Taxonomic_Option(optionID) ON DELETE CASCADE,
  FOREIGN KEY (speciesID) REFERENCES Species(speciesID)
);

-- Characteristics
CREATE TABLE Characteristic_Type (
  characteristicTypeID TEXT PRIMARY KEY,
  name VARCHAR(50),
  description TEXT
);

CREATE TABLE Characteristic (
  characteristicID SERIAL PRIMARY KEY,
  name VARCHAR(50),
  description TEXT,
  characteristicTypeID TEXT,
  creation_date DATE,
  updated_date DATE,
  FOREIGN KEY (characteristicTypeID) REFERENCES Characteristic_Type(characteristicTypeID)
);

CREATE TABLE Species_Characteristic (
  speciesCharacteristicID TEXT PRIMARY KEY,
  speciesID INTEGER,
  characteristicID INTEGER,
  observation TEXT,
  association_date DATE,
  FOREIGN KEY (speciesID) REFERENCES Species(speciesID) ON DELETE CASCADE,
  FOREIGN KEY (characteristicID) REFERENCES Characteristic(characteristicID)
);

--tokens
CREATE TABLE Refresh_tokens (
  tokenID UUID PRIMARY KEY,
  userID UUID,
  toker_hash TEXT NOT NULL,
  created_at TIMESTAMP NOT NULL,
  expires_at TIMESTAMP NOT NULL,
  revoked BOOLEAN DEFAULT FALSE,
  FOREIGN KEY (userID) REFERENCES "User"(userID) ON DELETE CASCADE
);

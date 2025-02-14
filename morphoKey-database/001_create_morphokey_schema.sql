-- Crear esquema para la base de datos Taxokey
CREATE SCHEMA taxokey;

-- Tabla Domain
CREATE TABLE taxokey.Domain (
    domainID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    scientific_name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    photo_url TEXT
);

-- Tabla Kingdom
CREATE TABLE taxokey.Kingdom (
    kingdomID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    scientific_name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    photo_url TEXT,
    domainID UUID NOT NULL REFERENCES taxokey.Domain(domainID)
);

-- Tabla Phylum
CREATE TABLE taxokey.Phylum (
    phylumID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    scientific_name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    photo_url TEXT,
    kingdomID UUID NOT NULL REFERENCES taxokey.Kingdom(kingdomID)
);

-- Tabla Class
CREATE TABLE taxokey.Class (
    classID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    scientific_name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    photo_url TEXT,
    phylumID UUID NOT NULL REFERENCES taxokey.Phylum(phylumID)
);

-- Tabla Order
CREATE TABLE taxokey.Order (
    orderID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    scientific_name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    photo_url TEXT,
    classID UUID NOT NULL REFERENCES taxokey.Class(classID)
);

-- Tabla Family
CREATE TABLE taxokey.Family (
    familyID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    scientific_name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    photo_url TEXT,
    orderID UUID NOT NULL REFERENCES taxokey.Order(orderID)
);

-- Tabla Genus
CREATE TABLE taxokey.Genus (
    genusID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    scientific_name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    photo_url TEXT,
    familyID UUID NOT NULL REFERENCES taxokey.Family(familyID)
);

-- Tabla Species
CREATE TABLE taxokey.Species (
    speciesID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    scientific_name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    photo_url TEXT,
    genusID UUID NOT NULL REFERENCES taxokey.Genus(genusID),
    countryID UUID NOT NULL REFERENCES taxokey.Country(countryID)
);

-- Tabla Country
CREATE TABLE taxokey.Country (
    countryID UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(10),
    description TEXT
);

-- Tabla City
CREATE TABLE taxokey.City (
    cityID UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    countryID UUID NOT NULL REFERENCES taxokey.Country(countryID),
    description TEXT
);

-- Tabla User
CREATE TABLE taxokey.User (
    userID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    creation_account_date DATE NOT NULL,
    date_of_birth DATE,
    role VARCHAR(20),
    status BOOLEAN NOT NULL,
    phone VARCHAR(15),
    profile_photo_url TEXT,
    updated_account_date DATE,
    last_login_date TIMESTAMP,
    countryID UUID REFERENCES taxokey.Country(countryID)
);

-- Tabla Password
CREATE TABLE taxokey.Password (
    passwordID UUID PRIMARY KEY,
    userID UUID NOT NULL REFERENCES taxokey.User(userID),
    password_hash VARCHAR(255) NOT NULL,
    last_updated TIMESTAMP NOT NULL
);

-- Tabla Publication_Type (Nueva tabla para normalización)
CREATE TABLE taxokey.Publication_Type (
    publicationTypeID UUID PRIMARY KEY,
    type_name VARCHAR(50) NOT NULL
);

-- Tabla Publication
CREATE TABLE taxokey.Publication (
    publicationID UUID PRIMARY KEY,
    title VARCHAR(100),
    body TEXT NOT NULL,
    sources VARCHAR(100),
    creation_date DATE NOT NULL,
    updated_date DATE,
    status BOOLEAN NOT NULL,
    publicationTypeID UUID NOT NULL REFERENCES taxokey.Publication_Type(publicationTypeID),
    userID UUID NOT NULL REFERENCES taxokey.User(userID),
    cityID UUID NOT NULL REFERENCES taxokey.City(cityID)
);

-- Tabla Comment
CREATE TABLE taxokey.Comment (
    commentID UUID PRIMARY KEY,
    publicationID UUID NOT NULL REFERENCES taxokey.Publication(publicationID),
    userID UUID NOT NULL REFERENCES taxokey.User(userID),
    content TEXT NOT NULL,
    comment_date TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
    parentCommentID UUID REFERENCES taxokey.Comment(commentID)
);

-- Tabla Publication_Reference
CREATE TABLE taxokey.Publication_Reference (
    referenceID UUID PRIMARY KEY,
    publicationID UUID NOT NULL REFERENCES taxokey.Publication(publicationID),
    referencedEntityID UUID NOT NULL,
    entityType VARCHAR(50) NOT NULL,
    description TEXT
);

-- Tabla Publication_Photo
CREATE TABLE taxokey.Publication_Photo (
    photoID UUID PRIMARY KEY,
    publicationID UUID NOT NULL REFERENCES taxokey.Publication(publicationID),
    photo_url TEXT NOT NULL,
    description VARCHAR(255),
    upload_date DATE NOT NULL
);

-- Tabla Taxonomic_Question
CREATE TABLE taxokey.Taxonomic_Question (
    questionID UUID PRIMARY KEY,
    question_text TEXT NOT NULL,
    creation_date DATE NOT NULL,
    updated_date DATE,
    difficulty_level VARCHAR(20)
);

-- Tabla Taxonomic_Option
CREATE TABLE taxokey.Taxonomic_Option (
    optionID UUID PRIMARY KEY,
    questionID UUID NOT NULL REFERENCES taxokey.Taxonomic_Question(questionID),
    nextQuestionID UUID REFERENCES taxokey.Taxonomic_Question(questionID),
    speciesID UUID REFERENCES taxokey.Species(speciesID),
    option_text VARCHAR(255) NOT NULL
);

-- Tabla Characteristic_Type
CREATE TABLE taxokey.Characteristic_Type (
    characteristicTypeID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT
);

-- Tabla Characteristic
CREATE TABLE taxokey.Characteristic (
    characteristicID UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    characteristicTypeID UUID NOT NULL REFERENCES taxokey.Characteristic_Type(characteristicTypeID),
    creation_date DATE NOT NULL,
    updated_date DATE
);

-- Tabla Species_Characteristic
CREATE TABLE taxokey.Species_Characteristic (
    speciesCharacteristicID UUID PRIMARY KEY,
    speciesID UUID NOT NULL REFERENCES taxokey.Species(speciesID),
    characteristicID UUID NOT NULL REFERENCES taxokey.Characteristic(characteristicID),
    observation TEXT,
    association_date DATE NOT NULL
);


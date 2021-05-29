CREATE TABLE user(
    user_name VARCHAR (255) identity NOT NULL UNIQUE,
    password VARCHAR (255) NOT NULL,
    email VARCHAR (255) NOT NULL,
    register_date DATE NOT NULL,
    PRIMARY KEY (user_name)
);

CREATE TABLE admin(
    admin_user_name VARCHAR (255) REFERENCES user (user_name),
    phone_NR VARCHAR(16) NOT NULL,
    address VARCHAR (255),
    PRIMARY KEY (admin_user_name)
);

CREATE TABLE rate(
    rating_ID INT NOT NULL AUTO_INCREMENT,
    rate INT NOT NULL,
    text_review VARCHAR (255),
    rate_date DATE NOT NULL,
    PRIMARY KEY (rating_ID)
);

CREATE TABLE book(
    isbn VARCHAR (255) identity NOT NULL UNIQUE,
    title VARCHAR (255) NOT NULL,
    publisher VARCHAR (255) NOT NULL,
    release_date DATE NOT NULL,
    PRIMARY KEY (isbn)
);

CREATE TABLE abstract(
    isbn VARCHAR (255) REFERENCES book (isbn),
    details VARCHAR (255) NOT NULL,
    parental_advisory VARCHAR (255) NOT NULL,
    PRIMARY KEY (isbn)
);

CREATE TABLE genre(
    genre_ID INT NOT NULL AUTO_INCREMENT,
    name VARCHAR (255) NOT NULL,
    age_restriction INT (2),
    PRIMARY KEY (genre_ID)
);
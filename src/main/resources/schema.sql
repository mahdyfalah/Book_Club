DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS admin;


DROP TABLE IF EXISTS rate;

DROP TABLE IF EXISTS book;


DROP TABLE IF EXISTS book_abstract;


DROP TABLE IF EXISTS genre;


CREATE TABLE user(
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR (255) NOT NULL UNIQUE,
    password VARCHAR (255) NOT NULL,
    email VARCHAR (255) NOT NULL,
    register_date VARCHAR (255) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE admin(
    admin_user_id INT REFERENCES user (user_id),
    phone_NR VARCHAR(16) NOT NULL,
    address VARCHAR (255),
    PRIMARY KEY (admin_user_id)
);

CREATE TABLE rate(
    rating_ID INT NOT NULL AUTO_INCREMENT,
    rate INT NOT NULL,
    text_review VARCHAR (255),
    rate_date DATE NOT NULL,
    PRIMARY KEY (rating_id)
);

CREATE TABLE book(
    book_id INT NOT NULL AUTO_INCREMENT,
    isbn VARCHAR (255) NOT NULL UNIQUE,
    title VARCHAR (255) NOT NULL,
    publisher VARCHAR (255) NOT NULL,
    PRIMARY KEY (book_id)
);

CREATE TABLE book_abstract(
    book_abstract_id INT NOT NULL AUTO_INCREMENT,
    details VARCHAR (255) NOT NULL,
    parental_advisory VARCHAR (255) NOT NULL,
    PRIMARY KEY (book_abstract_id)
);

CREATE TABLE genre(
    genre_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR (255) NOT NULL,
    age_restriction INT (2),
    PRIMARY KEY (genre_id)
);
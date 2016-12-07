/* Copyright 2016 Ryan Kugel & Tyler LaVecchia */
CREATE DATABASE IF NOT EXISTS tylerspace;
USE tylerspace;

Drop TABLE IF EXISTS member;
CREATE TABLE member (
	id int NOT NULL AUTO_INCREMENT,
	first_name		VARCHAR(25)		,
    last_name		VARCHAR(25) 	NOT NULL,
    email_address	VARCHAR(25)		NOT NULL,
    book_title		VARCHAR(25)		NOT NULL,
    due_date		DATE 			NOT NULL,
    PRIMARY KEY (id)
);
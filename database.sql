CREATE DATABASE servlet CHARACTER SET utf8 COLLATE utf8_general_ci;

USE servlet;

CREATE TABLE news (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(255) NULL ,
	thumnail VARCHAR(255) NULL,
	short_description TEXT NULL,
	content TEXT NULL,
	category_id BIGINT NOT NULL,
	create_date TIMESTAMP NULL,
	create_by VARCHAR(255) NULL,
	modify_date TIMESTAMP NULL,
	modify_by VARCHAR(255) NULL
);

CREATE TABLE category (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	category_type VARCHAR(255) NOT NULL
);

CREATE TABLE user (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	role_id BIGINT NOT NULL
);

CREATE TABLE role (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	code VARCHAR(255) NOT NULL	
);

CREATE TABLE comment(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	content TEXT NOT NULL,
	news_id BIGINT NOT NULL,
	user_id BIGINT NOT NULL,
	create_date TIMESTAMP NULL,
	create_by VARCHAR(255) NULL
);

ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (category_id) REFERENCES category(id);
ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_news FOREIGN KEY (news_id) REFERENCES news(id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user(id);

INSERT INTO category (category_type) VALUES ("chính trị");
INSERT INTO category (category_type) VALUES ("văn hóa");
INSERT INTO category (category_type) VALUES ("thể thao");

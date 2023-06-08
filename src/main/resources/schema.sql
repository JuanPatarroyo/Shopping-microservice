DROP TABLE IF EXISTS categoria;

CREATE TABLE categoria (id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                         name VARCHAR(250) NOT NULL);

DROP TABLE IF EXISTS producto;

CREATE TABLE producto (id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                           name VARCHAR(250) NOT NULL,
                           description VARCHAR(250) NOT NULL,
                           stock DOUBLE,
                           price DOUBLE,
                           status VARCHAR(250) NOT NULL,
                           created_at TIMESTAMP,
                           category_id BIGINT
);
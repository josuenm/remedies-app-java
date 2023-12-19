CREATE TABLE users(
        id BIGINT NOT NULL auto_increment,
        email VARCHAR(100) NOT NULL,
        password VARCHAR(100) NOT NULL,
        created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_at DATETIME,

        PRIMARY KEY (id)
);
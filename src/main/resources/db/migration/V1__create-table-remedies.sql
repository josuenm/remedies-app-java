CREATE TABLE remedies(
    id BIGINT NOT NULL auto_increment,
    name VARCHAR(100) NOT NULL,
    lot VARCHAR(100) NOT NULL,
    route VARCHAR(100) NOT NULL,
    laboratory VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME,
    validity DATETIME NOT NULL,

    PRIMARY KEY (id)
);
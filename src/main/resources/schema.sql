DROP ALL OBJECTS DELETE FILES;

CREATE TABLE product
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE brand
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    brand VARCHAR(255),
    CONSTRAINT pk_brand PRIMARY KEY (id)
);

CREATE TABLE prices
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    brand_id   BIGINT                NOT NULL,
    start_date TIMESTAMP,
    end_date   TIMESTAMP,
    price_list INT,
    product_id BIGINT                NOT NULL,
    priority   INT,
    price      DOUBLE,
    curr       VARCHAR(255),
    CONSTRAINT pk_prices PRIMARY KEY (id)
);

ALTER TABLE prices
    ADD CONSTRAINT FK_PRICES_ON_BRAND FOREIGN KEY (brand_id) REFERENCES brand (id);

ALTER TABLE prices
    ADD CONSTRAINT FK_PRICES_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);
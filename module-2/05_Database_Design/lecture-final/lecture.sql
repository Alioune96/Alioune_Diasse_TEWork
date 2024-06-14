START TRANSACTION;

CREATE TABLE customer (

	-- column_name datatype,
	customer_id serial,
	first_name varchar(25) NOT NULL,
	last_name varchar(25) NOT NULL,
	address_street varchar(50) NOT NULL,
	address_city varchar(20) NOT NULL,
	address_state char(2) NOT NULL,
	address_zipcode varchar(10) NOT NULL,
	phone_number varchar(20) NULL,
	
	CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

CREATE TABLE artist (

	artist_id serial,
	artist_name varchar(100) NOT NULL,

	CONSTRAINT pk_artist PRIMARY KEY (artist_id)
);

CREATE TABLE painting (

	painting_id serial,
	title varchar(100) NOT NULL,
	artist_id int NOT NULL,
	
	CONSTRAINT pk_painting PRIMARY KEY (painting_id),
	CONSTRAINT fk_painting_artist FOREIGN KEY (artist_id) REFERENCES artist (artist_id)

);

CREATE TABLE purchase (

	customer_id int NOT NULL,
	painting_id int NOT NULL,
	sales_price money NOT NULL,
	purchase_date timestamp NOT NULL,
	
	CONSTRAINT fk_purchase_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
	CONSTRAINT fk_purchase_painting FOREIGN KEY (painting_id) REFERENCES painting (painting_id),
	CONSTRAINT pk_purchase PRIMARY KEY (customer_id, painting_id, purchase_date)

);

ROLLBACK;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS city;

-- Table: public.city
CREATE TABLE city
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying NOT NULL,
	PRIMARY KEY (id)
);

-- Table: public.person
CREATE TABLE person
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying NOT NULL,
    age integer NOT NULL,
    city_id integer NOT NULL,
    FOREIGN KEY (city_id) REFERENCES city (id) ON DELETE RESTRICT
);


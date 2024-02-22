-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = forelesning1
        -- Tabell(er) = person 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS forelesning1 CASCADE;

CREATE SCHEMA forelesning1;
SET search_path TO forelesning1;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE person;

CREATE TABLE person
(
    id integer NOT NULL,
    navn VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO
  person(id, navn)
VALUES
    (1001, 'Per Viskeler'),
    (1002, 'Atle Patle'),
    (1003, 'Donald Duck');

select * from person;





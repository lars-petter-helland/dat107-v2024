-- SQL for serial-eksemplet gjennomgått i timen onsdag 13. mars 2024 

-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = forelesning3_serial
        -- Tabell(er) = person 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS forelesning3_serial CASCADE;
CREATE SCHEMA forelesning3_serial;
SET search_path TO forelesning3_serial;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE person;
CREATE TABLE person
(
    id SERIAL,
    navn VARCHAR(30) NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id)
);

INSERT INTO
  person(navn)
VALUES
    ('Per Viskeler'),
    ('Atle Patle'),
    ('Donald Duck');

SELECT * FROM person;

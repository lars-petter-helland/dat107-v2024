-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = forelesning2_todo
        -- Tabell(er) = todo 

-- FARE !!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS forelesning2_todo CASCADE;
CREATE SCHEMA forelesning2_todo;
SET search_path TO forelesning2_todo;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE IF EXISTS todo CASCADE;

CREATE TABLE todo
(
    id INTEGER PRIMARY KEY,
    tekst VARCHAR NOT NULL
);

INSERT INTO
  todo(id, tekst)
VALUES
    (1, 'Handle mat'),
    (2, 'Vaske opp'),
    (3, 'Ta ut bosset');

SELECT * FROM todo;
    
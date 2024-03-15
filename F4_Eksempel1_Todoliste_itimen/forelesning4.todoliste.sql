-- SQL for todoliste-eksemplet gjennomgått i timen fredag 15. mars 2024 

DROP SCHEMA IF EXISTS forelesning4_todoliste CASCADE;
CREATE SCHEMA forelesning4_todoliste;
SET search_path TO forelesning4_todoliste;
    
CREATE TABLE todoliste
(
    id		SERIAL PRIMARY KEY,
    navn	VARCHAR
);

CREATE TABLE todo
(
    id      SERIAL PRIMARY KEY,
    tekst   VARCHAR,
    listeid INTEGER,
    CONSTRAINT listeFK FOREIGN KEY (listeid) REFERENCES todoliste(id)
);


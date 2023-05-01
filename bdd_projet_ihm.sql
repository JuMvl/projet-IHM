--
-- Fichier généré par SQLiteStudio v3.4.4 sur lun. mai 1 16:37:03 2023
--
-- Encodage texte utilisé : System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tableau : table_etu
CREATE TABLE IF NOT EXISTS table_etu (id_etu INTEGER PRIMARY KEY AUTOINCREMENT, nom_etu TEXT, prenom_etu TEXT, annee_naissance INTEGEr CHECK (annee_naissance BETWEEN 1900 AND 2023), formation TEXT CHECK (formation IN ('GPHY', 'GCELL', 'ECMPS')), promotion TEXT CHECK (promotion IN ('M1', 'M2')));
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (1, 'louise', 'GAEL', 2001, 'GPHY', 'M1');
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (2, 'DUBROCA', 'ROMANE', 2000, 'GPHY', 'M1');
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (3, 'RAMZI', 'ERIC', 1999, 'GPHY', 'M2');
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (4, 'KINANGA', 'KATELL', 2000, 'GPHY', 'M2');
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (5, 'LACHO', 'PHILIPE', 2001, 'GCELL', 'M1');
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (6, 'LAPEINE', 'CECILE', 2002, 'GCELL', 'M2');
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (7, 'GORBEINE', 'BERNI', 2000, 'ECMPS', 'M1');
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (8, 'LEPONGE', 'BOB', 2001, 'ECMPS', 'M2');
INSERT INTO table_etu (id_etu, nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (9, 'FRAISE', 'CHARLOTTE', 1999, 'ECMPS', 'M2');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;

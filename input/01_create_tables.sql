/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* CREATEd on:     22.01.2018 18:35:40                          */
/*==============================================================*/


DROP TABLE IF EXISTS arbeitsvertrag;
DROP TABLE IF EXISTS faehigkeit_bewerber;
DROP TABLE IF EXISTS faehigkeit_leiharbeiter;
DROP TABLE IF EXISTS leiharbeiter_schulung;
DROP TABLE IF EXISTS faehigkeit_kundenanfrage;
DROP TABLE IF EXISTS tarif;
DROP TABLE IF EXISTS ueberlassungsvertrag;
DROP TABLE IF EXISTS stellenausschreibung_bewerber;
DROP TABLE IF EXISTS bewerber;
DROP TABLE IF EXISTS leiharbeiter;
DROP TABLE IF EXISTS stellenausschreibung;
DROP TABLE IF EXISTS kundenanfrage;
DROP TABLE IF EXISTS kunde;
DROP TABLE IF EXISTS verwaltungsangestellter;
DROP TABLE IF EXISTS schulungstermin;
DROP TABLE IF EXISTS faehigkeit;
DROP TABLE IF EXISTS schulung;
DROP TABLE IF EXISTS schulungsanbieter;
DROP TABLE IF EXISTS adresse;
DROP TABLE IF EXISTS konto;

/*==============================================================*/
/* TABLE: ADRESSE                                               */
/*==============================================================*/
CREATE TABLE adresse (
   id          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   strasse     TEXT NOT NULL,
   hausnummer  INT NOT NULL,
   plz         INT NOT NULL,
   ort         TEXT NOT NULL,
   bemerkung   TEXT
);

/*==============================================================*/
/* TABLE: TARIF                                                 */
/*==============================================================*/
CREATE TABLE tarif (
   bezeichnung VARCHAR(50) NOT NULL,
   stufe       INT NOT NULL,
   stundenlohn FLOAT NOT NULL,
   PRIMARY KEY (bezeichnung, stufe)
);

/*==============================================================*/
/* TABLE: SCHULUNGSANBIETER                                     */
/*==============================================================*/
CREATE TABLE schulungsanbieter (
   id          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   adresse     INT NOT NULL,
   bezeichnung TEXT NOT NULL,
   telefon     TEXT,
   email       TEXT,
   FOREIGN KEY (adresse) REFERENCES adresse(id)
);

/*==============================================================*/
/* TABLE: SCHULUNG                                              */
/*==============================================================*/
CREATE TABLE schulung (
   id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   anbieter INT NOT NULL,
   thema    TEXT NOT NULL,
   FOREIGN KEY (anbieter) REFERENCES schulungsanbieter(id)
);

/*==============================================================*/
/* TABLE: SCHULUNGSTERMIN                                       */
/*==============================================================*/
CREATE TABLE schulungstermin (
   id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   adresse  INT NOT NULL,
   schulung INT NOT NULL,
   beginn   DATETIME NOT NULL,
   ende     DATETIME NOT NULL,
   FOREIGN KEY (adresse) REFERENCES adresse(id),
   FOREIGN KEY (schulung) REFERENCES schulung(id)
);

/*==============================================================*/
/* TABLE: FAEHIGKEIT                                            */
/*==============================================================*/
CREATE TABLE faehigkeit (
   id          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   bezeichnung TEXT NOT NULL,
   kategorie   TEXT NOT NULL
);

/*==============================================================*/
/* TABLE: KONTO                                                 */
/*==============================================================*/
CREATE TABLE konto (
   id           INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   benutzername TEXT NOT NULL,
   passwort     TEXT NOT NULL
);

/*==============================================================*/
/* TABLE: KUNDE                                                 */
/*==============================================================*/
CREATE TABLE kunde (
   id               INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   adresse          INT NOT NULL,
   bezeichnung      TEXT NOT NULL,
   ansprechpartner  TEXT NOT NULL,
   telefon          TEXT,
   email            TEXT,
   FOREIGN KEY (adresse) REFERENCES adresse(id)
);

/*==============================================================*/
/* TABLE: KUNDENANFRAGE                                         */
/*==============================================================*/
CREATE TABLE kundenanfrage (
   id                INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   kunde             INT NOT NULL,
   lohnangebot       INT NOT NULL,
   wochenstunden     INT NOT NULL,
   beginn            DATE,
   ende              DATE,
   FOREIGN KEY (kunde) REFERENCES kunde(id)
);

/*==============================================================*/
/* TABLE: FAEHIGKEIT_KUNDENANFRAGE                                         */
/*==============================================================*/
CREATE TABLE faehigkeit_kundenanfrage(
   kundenanfrage  INT NOT NULL,
   faehigkeit     INT NOT NULL,
   niveau         TEXT NOT NULL,
   FOREIGN KEY (faehigkeit) REFERENCES faehigkeit(id),
   FOREIGN KEY (kundenanfrage) REFERENCES kundenanfrage(id),
   PRIMARY KEY (faehigkeit, kundenanfrage)
);

/*==============================================================*/
/* TABLE: VERWALTUNGSANGESTELLTER                               */
/*==============================================================*/
CREATE TABLE verwaltungsangestellter (
   personalnummer INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   adresse        INT NOT NULL,
   konto          INT NOT NULL,
   vorname        TEXT NOT NULL,
   nachname       TEXT NOT NULL,
   email          TEXT NOT NULL,
   telefon        TEXT NOT NULL,
   geburtsdatum   DATE NOT NULL,
   FOREIGN KEY (adresse) REFERENCES adresse(id),
   FOREIGN KEY (konto) REFERENCES konto(id)
);

/*==============================================================*/
/* TABLE: LEIHARBEITER                                          */
/*==============================================================*/
CREATE TABLE leiharbeiter (
   personalnummer INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   adresse        INT NOT NULL,
   konto          INT NOT NULL,
   verwalter      INT NOT NULL,
   vorname        TEXT NOT NULL,
   nachname       TEXT NOT NULL,
   email          TEXT NOT NULL,
   telefon        TEXT NOT NULL,
   geburtsdatum   DATE NOT NULL,
   lebenslauf     TEXT,
   FOREIGN KEY (adresse) REFERENCES adresse(id),
   FOREIGN KEY (konto) REFERENCES konto(id),
   FOREIGN KEY (verwalter) REFERENCES verwaltungsangestellter(personalnummer)
);

/*==============================================================*/
/* TABLE: FAEHIGKEIT_LEIHARBEITER                               */
/*==============================================================*/
CREATE TABLE faehigkeit_leiharbeiter (
   faehigkeit   INT NOT NULL,
   leiharbeiter INT NOT NULL,
   niveau       TEXT NOT NULL,
   FOREIGN KEY (faehigkeit) REFERENCES faehigkeit(id),
   FOREIGN KEY (leiharbeiter) REFERENCES leiharbeiter(personalnummer),
   PRIMARY KEY (faehigkeit, leiharbeiter)
);

/*==============================================================*/
/* TABLE: BEWERBER                                              */
/*==============================================================*/
CREATE TABLE bewerber (
   id           INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   adresse      INT,
   konto        INT NOT NULL,
   verwalter    INT,
   vorname      TEXT NOT NULL,
   nachname     TEXT NOT NULL,
   email        TEXT NOT NULL,
   geburtsdatum DATE NOT NULL,
   telefon      TEXT,
   lebenslauf   TEXT,
   FOREIGN KEY (adresse) REFERENCES adresse(id),
   FOREIGN KEY (konto) REFERENCES konto(id),
   FOREIGN KEY (verwalter) REFERENCES verwaltungsangestellter(personalnummer)
);

/*==============================================================*/
/* TABLE: FAEHIGKEIT_BEWERBER                                   */
/*==============================================================*/
CREATE TABLE  faehigkeit_bewerber (
   faehigkeit   INT NOT NULL,
   bewerber INT NOT NULL,
   niveau       TEXT NOT NULL,
   FOREIGN KEY (faehigkeit) REFERENCES faehigkeit(id),
   FOREIGN KEY (bewerber) REFERENCES bewerber(id),
   PRIMARY KEY (faehigkeit, bewerber)
);

/*==============================================================*/
/* TABLE: ARBEITSVERTRAG                                        */
/*==============================================================*/
CREATE TABLE arbeitsvertrag (
   id                INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   tarif_stufe       INT NOT NULL,
   tarif_bezeichnung VARCHAR(50) NOT NULL,
   verwalter         INT,
   leiharbeiter      INT,
   beginn            DATETIME NOT NULL,
   ende              DATETIME,
   FOREIGN KEY (verwalter) REFERENCES verwaltungsangestellter(personalnummer),
   FOREIGN KEY (leiharbeiter) REFERENCES leiharbeiter(personalnummer),
   FOREIGN KEY (tarif_bezeichnung, tarif_stufe) REFERENCES tarif(bezeichnung, stufe)
);

/*==============================================================*/
/* TABLE: UEBERLASSUNGSVERTRAG                                  */
/*==============================================================*/
CREATE TABLE ueberlassungsvertrag (
   id            INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   kunde         INT NOT NULL,
   leiharbeiter  INT NOT NULL,
   beginn        DATE NOT NULL,
   ende          DATE NOT NULL,
   wochenstunden INT NOT NULL,
   stundenlohn   FLOAT NOT NULL,
   FOREIGN KEY (kunde) REFERENCES kunde(id),
   FOREIGN KEY (leiharbeiter) REFERENCES leiharbeiter(personalnummer)
);

/*==============================================================*/
/* TABLE: LEIHARBEITER_SCHULUNG                                 */
/*==============================================================*/
CREATE TABLE leiharbeiter_schulung (
   leiharbeiter INT NOT NULL,
   schulung     INT NOT NULL,
   PRIMARY KEY (leiharbeiter, schulung),
   FOREIGN KEY (schulung) REFERENCES schulung(id),
   FOREIGN KEY (leiharbeiter) REFERENCES leiharbeiter(personalnummer)
);

/*==============================================================*/
/* TABLE: STELLENAUSSCHREIBUNG                                  */
/*==============================================================*/
CREATE TABLE stellenausschreibung (
   id                 INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   kundenanfrage      INT NOT NULL,
   verwalter          INT NOT NULL,
   stellenbezeichnung TEXT NOT NULL,
   beschreibung       TEXT NOT NULL,
   FOREIGN KEY (kundenanfrage) REFERENCES kundenanfrage(id),
   FOREIGN KEY (verwalter) REFERENCES verwaltungsangestellter(personalnummer)
);

/*==============================================================*/
/* TABLE: STELLENAUSSCHR_BEWERBER                               */
/*==============================================================*/
CREATE TABLE stellenausschreibung_bewerber (
   stellenausschreibung INT NOT NULL,
   bewerber             INT NOT NULL,
   anschreiben          TEXT NOT NULL,
   FOREIGN KEY (bewerber) REFERENCES bewerber(id),
   FOREIGN KEY (stellenausschreibung) REFERENCES stellenausschreibung(id),
   PRIMARY KEY (stellenausschreibung, bewerber)
);

/*##############################################################################################################*/
/*################################################### Views ####################################################*/
/*##############################################################################################################*/

/*==============================================================*/
/* View: Fähigkeiten von Bewerbern                              */
/*==============================================================*/
CREATE OR REPLACE VIEW faehigkeitenvonbewerbern AS
SELECT b.id AS bewerber, f.id AS faehigkeit, f.bezeichnung, f.kategorie, fb.niveau
FROM (bewerber AS b RIGHT JOIN faehigkeit_bewerber AS fb ON b.id = fb.bewerber) LEFT JOIN faehigkeit AS f ON f.id = fb.faehigkeit;

/*==============================================================*/
/* View: Fähigkeiten von Kundenanfragen                         */
/*==============================================================*/
CREATE OR REPLACE VIEW faehigkeitenvonkundenanfragen AS
SELECT ka.id AS kundenanfrage, f.id AS faehigkeit, f.bezeichnung, f.kategorie, fk.niveau
FROM (kundenanfrage AS ka RIGHT JOIN faehigkeit_kundenanfrage AS fk ON ka.id = fk.kundenanfrage) LEFT JOIN faehigkeit AS f ON f.id = fk.faehigkeit; 
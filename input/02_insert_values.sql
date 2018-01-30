-- SET names utf8;

INSERT INTO adresse(strasse, hausnummer, plz, ort, bemerkung)
VALUES
	('Hochstrasse', 85, '25932', 'Wyk', NULL),
	('Fugger Strasse', 37,'14439', 'Potsdam', NULL),
	('Hollander Strasse', 34, '35305', 'Grünberg', NULL),
	('Rudower Strasse', 17, '54608', 'Großlangenfeld', NULL),
	('Schoenebergerstrasse', 18, '23921', 'Schönberg', NULL),
	('Anhalter Strasse', 45, '67742', 'Ginsweiler', NULL),
	('Rhinstrasse', 28, '80972', 'München', NULL),
	('Hedemannstasse', 19, '88361', 'Eichstegen', NULL),
	('Am Borsigturm', 68, '47805', 'Krefeld', NULL),
	('Rudolstaedter Strasse', 63, '63702', 'Aschaffenburg', NULL),
	('Meinekestraße', 79, '37434', 'Krebeck', NULL),
	('Kurfuerstendamm', 41, '74081', 'Heilbronn Klingenberg', NULL),
	('Eschenweg', 81, '07720', 'Jena', NULL),
	('Technologiepark', 11, '33100', 'Paderborn', NULL),
	('Graf-Adolf-Str.', 63, '40210', 'Düsseldorf', NULL),
	('Graf-Adolf-Str.', 63, '40210', 'Düsseldorf', 'Raum D312'),
	('Graf-Adolf-Str.', 63, '40210', 'Düsseldorf', 'Raum D320'),
	('Technologiepark', 11, '33100', 'Paderborn', 'Raum 110'),
	('Technologiepark', 11, '33100', 'Paderborn', 'Raum 120'),
	('Petuelring', 130, '80788', 'München', 'Personalabteilung'),
	('Auto-Union-Straße', 1, '85045', 'Ingolstadt', 'Personalabteilung'),
	('Henry-Ford-Str.', 1,  '50735', 'Köln', 'Personalabteilung'),
	('Porscheplatz', 1, '70435', 'Stuttgart', 'Personalabteilung')
;

INSERT INTO tarif(bezeichnung, stufe, stundenlohn)
VALUES 
	('TV-L 13 2018 West', 1, 21.45),
	('TV-L 13 2018 West', 2, 21.34),
	('TV-L 13 2018 West', 3, 24.32),
	('TV-L 13 2018 West', 4, 26.39),
	('TV-L 13 2018 West', 5, 30.31),
	('TV-L 13 2018 West', 6, 15.30),
	('TV-L 12 2018 West', 1, 30.76),
	('TV-L 12 2018 West', 2, 19.33),
	('TV-L 12 2018 West', 3, 21.34),
	('TV-L 12 2018 West', 4, 24.32),
	('TV-L 12 2018 West', 5, 26.39),
	('TV-L 12 2018 West', 6, 30.76),
	('TV-L 5 2018 West', 1, 13.39),
	('TV-L 5 2018 West', 2, 14.71),
	('TV-L 5 2018 West', 3, 15.40),
	('TV-L 5 2018 West', 4, 16.07),
	('TV-L 5 2018 West', 5, 16.59),
	('TV-L 5 2018 West', 6, 16.94)
;

INSERT INTO schulungsanbieter(adresse, bezeichnung, telefon, email)
VALUES 
	(15, 'Konfuzius Institut', '(0211) 4162 8540', 'info@konfuzius-duesseldorf.de'),
	(14, 'The MathWorks, Inc.', '+ 49-89-45235-6700', NULL) 
;

INSERT INTO schulung(anbieter, thema)
VALUES
	(1, 'Business Chinesisch B1.1'),
	(1, 'Business Chinesisch B1.3'),
	(2, 'Model-Based Design und Codegenerierung von AUTOSAR-Softwarekomponenten'),
	(2, 'MATLAB Grundlagen für Anwendungen im Automobilbau')
;

INSERT INTO schulungstermin(adresse, schulung, beginn, ende)
VALUES
	(17, 1, '2018-02-15 09:00:00', '2018-02-15 13:00:00'),
	(17, 1, '2018-02-22 09:00:00', '2018-02-22 13:00:00'),
	(17, 1, '2018-03-01 09:00:00', '2018-03-01 13:00:00'),
	(17, 1, '2018-03-08 09:00:00', '2018-03-08 13:00:00'),
	(16, 2, '2018-02-15 13:00:00', '2018-02-15 17:00:00'),
	(16, 2, '2018-02-22 13:00:00', '2018-02-15 17:00:00'),
	(16, 2, '2018-03-01 13:00:00', '2018-02-15 17:00:00'),
	(16, 2, '2018-03-08 13:00:00', '2018-02-15 17:00:00'),
	(18, 3, '2018-03-15 09:00:00', '2018-02-15 15:00:00'),
	(19, 4, '2018-03-22 09:00:00', '2018-02-15 15:00:00')
;

INSERT INTO faehigkeit(bezeichnung, kategorie)
VALUES
	('C Programmieren', 'Softwareentwicklung'),
	('Python Programmieren', 'Softwareentwicklung'),
	('Requirements Engineering mit Doors', 'Produktentwicklung'),
	('AUTOSAR', 'Automotive'),
	('Chinesisch', 'Sprachen'),
	('Englisch', 'Sprachen')
;

INSERT INTO konto(benutzername, passwort)
VALUES
	('smeister', 'lentulus'),
	('ktraugott', 'lentulus'),
	('mfarber', 'lentulus'),
	('sbar', 'lentulus'),
	('meisenhauer', 'lentulus'),
	('mjung', 'lentulus'),
	('lmaur', 'lentulus'),
	('mkuhn', 'lentulus'),
	('lschneider', 'lentulus'),
	('kmuller', 'lentulus'),
	('lbrandt', 'lentulus'),
	('ybader', 'lentulus'),
	('feisenhower', 'lentulus')
;

INSERT INTO kunde(adresse, bezeichnung, ansprechpartner, telefon, email)
VALUES
	(20, 'BMW AG', 'Swen Feierabend', NULL, 's.feierabend@bmw.de'),
	(21, 'Audi AG', 'Uta Gerber', NULL, 'u.gerber@audi.de'),
	(22, 'Ford-Werke GmbH', 'Ralf Schultz', NULL, 'r.schultz@ford.de'),
	(23, 'Porsche AG', 'Kevin Schmitz', NULL, 'k.schmitz@porsche.de')
;

INSERT INTO kundenanfrage(kunde, lohnangebot, wochenstunden, beginn, ende)
VALUES
	(1, 35.00, 35, '2018-03-01', '2020-02-28'),
	(1, 37.00, 35, '2018-03-01', '2019-02-28'),
	(1, 42.00, 35, '2018-05-01', '2018-11-30'),
	(2, 34.00, 35, '2018-04-01', '2019-03-31'),
	(2, 33.00, 35, '2018-06-01', '2020-05-31'),
	(3, 28.00, 35, '2018-04-01', '2018-10-31'),
	(3, 30.00, 35, '2018-05-01', '2020-04-30'),
	(4, 30.00, 35, '2018-03-01', '2020-02-28'),
	(4, 35.00, 35, '2018-05-01', '2020-04-30'),
	(4, 40.00, 35, '2018-05-01', '2019-04-30')
;

INSERT INTO faehigkeit_kundenanfrage(faehigkeit, kundenanfrage, niveau)
VALUES
	(2, 1, 'mind. 1 Jahr Berufserfahrung'),
	(4, 1, 'Wünschenswert'),
	(1, 2, 'mind. 3 Jahre Berufserfahrung'),
	(3, 2, 'Wünschenswert'),
	(1, 3, 'mind. 1 Jahr Berufserfahrung'),
	(5, 3, 'HSK 2'),
	(1, 4, 'mind. 1 Jahr Berufserfahrung'),
	(6, 4, 'verhandlungssicher'),
	(5, 5, 'HSK 3'),
	(6, 5, 'verhandlungssicher'),
	(1, 6, 'mind. 1 Jahr Berufserfahrung'),
	(4, 6, 'Wünschenswert'),
	(1, 7, 'mind. 1 Jahr Berufserfahrung'),
	(4, 7, 'Wünschenswert'),
	(1, 8, 'mind. 3 Jahre Berufserfahrung'),
	(3, 8, 'Wünschenswert'),
	(1, 9, 'mind. 3 Jahre Berufserfahrung'),
	(3, 9, 'mind. 1 Jahr Berufserfahrung'),
	(2, 10, 'mind. 3 Jahre Berufserfahrung'),
	(4, 10, 'mind. 1 Jahre Berufserfahrung')
;

INSERT INTO verwaltungsangestellter(personalnummer, adresse, konto, vorname, nachname, email, telefon, geburtsdatum)
VALUES
	(100001, 1, 1, 'Sarah', 'Meister','SarahMeister@lentulus.de', '+49 571 2501 - 04', '1991-04-30'),
	(100002, 2, 2, 'Katja', 'Traugott','KatjaTraugott@lentulus.de', '+49 571 2501 - 14', '1990-07-11'),
	(100003, 3, 3, 'Marko', 'Farber', 'MarkoFarber@lentulus.de', '+49 571 2501 - 06', '1975-04-10')
;

INSERT INTO leiharbeiter(personalnummer, adresse, konto, verwalter, vorname, nachname, email, telefon, geburtsdatum, lebenslauf)
VALUES
	(200001, 4, 4, 100001, 'Swen', 'Bar', 'SwenBar@einrot.com', '06555 33 97 78', '1977-09-25', NULL),
	(200002, 5, 5, 100001, 'Michelle', 'Eisenhauer', 'MichelleEisenhauer@cuvox.de', '03764 62 75 70', '1986-03-03', NULL),
	(200003, 6, 6, 100003, 'Mathias', 'Jung', 'MathiasJung@cuvox.de', '06364 92 10 12', '1982-06-22', NULL),
	(200004, 7, 7, 100002, 'Lisa', 'Maur', 'LisaMaur@cuvox.de', '089 71 07 89', '1992-06-27', NULL),
	(200005, 8, 8, 100002, 'Mathias', 'Kuhn', 'MathiasKuhn@cuvox.de', '07581 57 56 16', '1974-03-03', NULL),
	(200006, 9, 9, 100001, 'Luca', 'Schneider', 'LucaSchneider@cuvox.de', '02151 89 11 81', '1991-12-10', NULL)
;

INSERT INTO faehigkeit_leiharbeiter(faehigkeit, leiharbeiter, niveau)
VALUES
	(1, 200001, '1 Jahr Berufserfahrung'),
	(6, 200001, 'konversationsfähig'),
	(1, 200002, 'Erfahrung aus Studium'),
	(6, 200002, 'verhandlungssischer'),
	(2, 200003, 'Erfahrung aus Studium'),
	(5, 200003, 'konversationsfähig'),
	(2, 200004, '3 Jahre Berufserfahrung'),
	(3, 200004, '1 Jahr Berufserfahrung'),
	(1, 200005, '1 Jahr Berufserfahrung'),
	(4, 200005, '1 Jahr Berufserfahrung'),
	(5, 200006, 'konversationsfähig'),
	(6, 200006, 'verhandlungssischer')
;

INSERT INTO bewerber(adresse, konto, verwalter, vorname, nachname, email, telefon, geburtsdatum, lebenslauf)
VALUES
	(10, 10, 100003, 'Klaus', 'Muller', 'KlausMuller@einrot.com', '06021 13 14 27', '1983-06-13', NULL),
	(11, 11, 100003, 'Luca', 'Brandt', 'LucaBrandt@cuvox.de', '05507 38 35 40', '1992-03-16', NULL),
	(12, 12, 100002, 'Yvonne', 'Bader', 'YvonneBader@cuvox.de', '079 54 68 27', '1990-01-19', NULL),
	(13, 13, NULL, 'Frank', 'Eisenhower', 'FrankEisenhower@cuvox.de', '03641 33 33 28', '1988-08-09', NULL)
;

INSERT INTO faehigkeit_bewerber(faehigkeit, bewerber, niveau)
VALUES
	(1, 1, '1 Jahr Berufserfahrung'),
	(6, 1, 'konversationsfähig'),
	(1, 2, 'Erfahrung aus Studium'),
	(6, 2, 'verhandlungssischer'),
	(2, 3, 'Erfahrung aus Studium'),
	(5, 3, 'konversationsfähig'),
	(2, 4, '3 Jahre Berufserfahrung'),
	(3, 4, '1 Jahr Berufserfahrung')
;

INSERT INTO arbeitsvertrag(tarif_stufe, tarif_bezeichnung, verwalter, leiharbeiter, beginn, ende)
VALUES
	(1, 'TV-L 13 2018 West', 100001, 200001, '2016-02-01 00:00:00', NULL),
	(3, 'TV-L 13 2018 West', 100001, 200001, '2016-02-01 00:00:00', '2018-01-31 00:00:00'),
	(2, 'TV-L 12 2018 West', 100001, 200003, '2016-02-01 00:00:00', NULL),
	(1, 'TV-L 12 2018 West', 100001, 200002, '2016-02-01 00:00:00', NULL),
	(2, 'TV-L 13 2018 West', 100001, 200002, '2016-02-01 00:00:00', NULL),
	(1, 'TV-L 13 2018 West', 100001, 200001, '2016-02-01 00:00:00', NULL)
;

INSERT INTO ueberlassungsvertrag(kunde, leiharbeiter, beginn, ende, wochenstunden, stundenlohn)
VALUES
	(1, 200001, '2017-08-01', '2019-07-30', 35, 26.00),
	(4, 200002, '2017-07-01', '2019-06-30', 35, 30.00),
	(3, 200004, '2017-08-01', '2018-07-30', 35, 35.00),
	(4, 200005, '2017-10-01', '2019-09-30', 35, 28.00),
	(1, 200006, '2017-06-01', '2020-05-31', 35, 27.00)
;

INSERT INTO leiharbeiter_schulung(leiharbeiter, schulung)
VALUES
	(200001, 1),
	(200001, 3),
	(200003, 2),
	(200004, 4),
	(200006, 3)
;

INSERT INTO stellenausschreibung(kundenanfrage, verwalter, stellenbezeichnung, beschreibung)
VALUES
	(1, 100001, 'ENTWICKLUNGSINGENIEUR 48V ELEKTRONIK-HARDWARE (W/M)', 'Wir bieten Ihnen bei einem großen Automobil OEM eine anspruchsvolle Tätigkeit als Entwicklungsingenieur 48V Elektronik-Hardware (w/m) im Bereich E/E Getriebe. Im Rahmen Ihrer Tätigkeit entwickeln Sie gemeinsam mit externen Systemlieferanten und internen Prozesspartnern elektronische Systemkomponenten und die zugehörigen Diagnose-/Steuerungssoftware von Getrieben vom Konzept bis zur Serienreife. Sie bewerten technische Konzepte von externen Lieferanten, stimmen hierzu die Anforderungen ab und begleiten die Serienentwicklung. Der Schwerpunkt Ihrer Tätigkeit ist neben der Lastenhefterstellung die Spezifikation von E/E Hardware für 48V-Systeme, Diagnosen sowie deren Absicherung und Qualifikation. Darüber hinaus stellen Sie sicher, dass die Zulassungsfähigkeit von Getrieben und Antriebssträngen im Rahmen der gesetzlichen Anforderungen gegeben ist. Ihr Engagement in mehreren Projekt- und Fachteams zur Realisierung von standardisierten Lösungen rundet Ihre anspruchsvolle Tätigkeit ab.'),
	(2, 100001, 'PROJEKTLEITER (W/M) FÜR ELEKTRIK/ELEKTRONIK-ARCHITEKTUR', 'Wir bieten Ihnen bei einem großen Automobil OEM eine innovative Aufgabe als Projektleiter (w/m) für Elektrik/Elektronik-Architektur. Im Rahmen Ihrer verantwortungsvollen Tätigkeit gestalten und bestätigen Sie die Elektrik/Elektronik-Architektur unserer zukünftigen Fahrzeugprojekte. Sie stellen in der frühen Phase der Produktentstehung sicher, dass neue Bordnetz-Architekturen aus Sicht der Systemintegration und Absicherung tragfähig und beherrschbar sind. Darüber hinaus analysieren und bewerten Sie innovative Bordnetz-Alternativen und bringen Ihre Lösungsvorschläge ein. Zur Absicherung der Ergebnisse bauen Sie ein Netzwerk über die Fachbereiche Fahrdynamik, Fahrerassistenz und Interieur auf. Zu Ihrem komplexen Tätigkeitsfeld gehört die gesetzten Ziele für unsere Produkte und Prozesse in der Architektur zu verankern. Die Unterstützung von Entscheidungsprozessen und das regelmäßige Berichten der Zielerreichung in den zuständigen Steuerungsgremien runden Ihr vielfältiges Aufgabengebiet ab.'),
	(4, 100001, 'PROJEKTLEITUNG E/E-KONFIGURATIONSMANAGEMENT (W/M)', 'Sie suchen eine Herausforderung in der Entwicklung Elektrik / Elektronik? Wir bieten Ihnen eine abwechslungsreiche und verantwortungsvolle Tätigkeit in der Software-Logistik für Fahrzeug-Steuergeräte. An der Schnittstelle zwischen Entwicklung, Software-Lieferanten, Produktionswerken und Handelsorganisation verantworten Sie die qualitative Intergation von Software mit ihren logistischen Informationen. Die Beherrschung komplexer SW-Konfigurationen über alle Steuergeräte und Fahrzeugprojekte spricht Sie an und motiviert Sie zu innovativen Lösungen. Eigenständig identifizieren Sie situative und längerfristig wirksame Maßnahmen und initiieren die Veränderungen im Prozess und den IT-Tools bei Bedarf. Ihr loyales Engagement macht Sie zum anerkannten Partner. Ihre Vernetzung über Entwicklung, Produktion und Vertrieb bietet Ihnen die Basis für ein breites Verständnis über die Entwicklung Elektrik / Elektronik.'),
	(6, 100001, 'TESTMANAGER HOCHVOLTSPEICHER (W/M)', 'Wir bieten Ihnen bei bei einem großen Automobil OEM eine interessante Tätigkeit als Testmanager (w/m) im Bereich elektrischer Hochvoltspeicher basierend auf der Lithium-Ionen-Technologie. Im Rahmen Ihrer Tätigkeit arbeiten Sie in einem internationalen und interdisziplinären Team und verantworten die Hochvoltspeichersysteme während des Entwicklungsprozesses bis hin zur Serie. In enger Zusammenarbeit mit der technischen Projektleitung bestimmen Sie die notwendigen Tests und entwickeln Testpläne unter Berücksichtigung von Kosten und Projektterminen. Darüber hinaus koordinieren und überwachen Sie die Versuche interner und externer Partner. Die anschließende Auswertung der Testresultate aus mechanischer, thermischer und elektrischer Perspektive und Ihre Handlungsempfehlung zur Freigabe runden Ihr herausforderndes Aufgabengebiet ab.'),
	(8, 100001, 'IT-PROJEKTLEITER / SOLUTION-ARCHITEKT (W/M)', 'Wir bieten Ihnen bei bei einem großen Automobil OEM eine interessante Tätigkeit als IT-Projektleiter / Solution-Architekt (w/m) im Bereich der Funktions- und Softwarearchitektur für Fahrzeugsysteme. Ihre Kernaufgaben umfassen die Erarbeitung von Prozessen und IT-Systemen, welche eine Definition und Abstimmung einer serviceorientierten Funktions- und Softwarearchitektur ermöglichen. In enger Zusammenarbeit mit Fach- und Zentralstellen konsolidieren und bewerten Sie Anforderungen, leiten daraus stimmige Konzepte und Methoden für Prozesse und IT-Systeme ab und begleiten deren Umsetzung bis zum Produktiveinsatz. Die organisationsübergreifende Zusammenarbeit mit Funktions- und Softwarearchitekten, Prozessstellen und Entwicklungspartnern runden Ihr spannendes Aufgabengebiet ab.'),
	(9, 100001, 'ENTWICKLUNGSEXPERTE FÜR ANZEIGE- UND BEDIENKONZEPTE (W/M)', 'Ihre Aufgabe als Spezialist/-in Entwicklung Anzeige- und Bedienkonzept bei einem großen Automobil OEM ist es, innovative Interaktionskonzepte in und um das Fahrzeug zu entwickeln. Für die Marken des OEM sind baureihenübergreifend konsistente und zukunftsfähige Interaktionskonzepte in und um das Fahrzeug zu entwickeln, die gleichzeitig Raum für eine markenspezifische Akzentuierung bieten. Mit dem Interaktionskonzept schaffen Sie ein begeisterndes End to End Bedienerlebnis und stellen eine hervorragende Usability sicher. Sie stellen den Kunden in den Mittelpunkt und kombinieren ein ausgeprägtes technisches Verständnis in diesem Themengebiet mit einem Gespür für Kundenbedürfnisse und Gestaltungslösungen. Des Weiteren verfügen Sie über die Erfahrung und das Wissen, intuitive, effiziente und vor allem auch fahrtgerechte Konzepte zu definieren. Sie koordinieren eigenverantwortlich die Abstimmung mit den relevanten Prozesspartnern und stellen die Bewertung der Anzeige- und Bedienkonzepte hinsichtlich Gebrauchstauglichkeit, Akzeptanz sowie der Einhaltung interner und externer Anforderungen sicher. ')
;

INSERT INTO stellenausschreibung_bewerber(stellenausschreibung, bewerber, anschreiben)
VALUES
	(2, 2, NULL),
	(3, 3, NULL),
	(6, 4, NULL)
;
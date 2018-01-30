-- Alle Stellen, die für einen bestimmten Bewerber in Frage kommen (die Fähigkeiten des Bewerbers also die erforderten abdecken).

-- Alle Bewerber, die von einem bestimmten Verwalter betreut werden.
SELECT bewerber.id FROM bewerber JOIN verwaltungsangestellter ON bewerber.verwalter = verwaltungsangestellter.personalnummer 
WHERE verwaltungsangestellter.personalnummer = [VerwalterID];

-- Alle Leiharbeiter, die von einem bestimmten Verwalter betreut werden.
SELECT leiharbeiter.personalnummer
FROM leiharbeiter JOIN verwaltungsangestellter ON leiharbeiter.verwalter = verwaltungsangestellter.personalnummer
WHERE verwaltungsangestellter.personalnummer = [VerwalterID];

-- Alle Bewerber, die noch keinem Verwalter zugeteilt wurden.
SELECT id FROM bewerber WHERE verwalter IS NULL;

-- Alle Fähigkeiten eines bestimmten Bewerbers.
SELECT faehigkeit.id, faehigkeit.bezeichnung
FROM (faehigkeit JOIN faehigkeit_bewerber ON faehigkeit.id  = faehigkeit_bewerber.faehigkeit)
      JOIN bewerber ON faehigkeit_bewerber.bewerber = bewerber.id
WHERE bewerber.id = [BewerberID];

-- Alle Fähigkeiten eines bestimmten Leiharbeiters.
SELECT faehigkeit.id, faehigkeit.bezeichnung
FROM (faehigkeit JOIN faehigkeit_leiharbeiter ON faehigkeit.id = faehigkeit_leiharbeiter.faehigkeit)
    JOIN leiharbeiter ON faehigkeit_leiharbeiter.leiharbeiter = leiharbeiter.personalnummer
WHERE leiharbeiter.personalnummer = [LeiharbeiterID];

-- Alle Arbeitsverträge eines bestimmten Leiharbeiters.
SELECT arbeitsvertrag.id
FROM arbeitsvertrag JOIN leiharbeiter ON arbeitsvertrag.leiharbeiter = leiharbeiter.personalnummer
WHERE leiharbeiter.personalnummer = [LeiharbeiterID];

-- Alle Bewerbungen (stellenausschreibung_bewerber) eines bestimmten Bewerbers.
SELECT stellenausschreibung_bewerber.stellenausschreibung
FROM stellenausschreibung_bewerber JOIN bewerber ON stellenausschreibung_bewerber.bewerber = bewerber.id
WHERE bewerber.id = [BewerberID];
-- -----------------------------------------------------
-- Table `czytelnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `czytelnik` (
`id_czytelnik` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz g��wny przydzielony automatycznie',
`login` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Nazwa czytelnika potrzeba przy logowaniu.',
`haslo` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Has�o niezaszyfrowane',
`imie` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Imi� ',
`nazwisko` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Nazwisko', 
`email` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Adres e-mail',
`telefon` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NULL COMMENT 'Telefony',
PRIMARY KEY (`id_czytelnik`))
COMMENT = 'Posiada informacje o czytelnikach zarejestrowanych w programie.';

-- -----------------------------------------------------
-- Table `adres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adres` (
`id_czytelnik` INT NOT NULL COMMENT 'Klucz g��wny',
`adres` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Adres zamieszkania np.: ul. Przyk�ad 3/12',
`miasto` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Miasto',
`wojewodztwo` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Nazwa wojew�dztwa',
`kod_pocztowy` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Kod pocztowy',  
PRIMARY KEY (`id_czytelnik`),
CONSTRAINT `fk_adres_czytelnik1`
FOREIGN KEY (`id_czytelnik`)
REFERENCES `czytelnik` (`id_czytelnik`)
ON DELETE CASCADE
ON UPDATE NO ACTION)
COMMENT = 'Posiada informacje o danych adresowych.';

-- -----------------------------------------------------
-- Table `kategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kategoria` (
`id_kategoria` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz g��wny przydzielony automatycznie',
`nazwa` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Nazwa kategorii',
PRIMARY KEY (`id_kategoria`))
COMMENT = 'Tabela zawieraj�ca wszystkie kategorie ksi��ek w systemie.';

-- -----------------------------------------------------
-- Table `ksiazka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ksiazka` (
`id_ksiazka` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz g��wny przydzielony automatycznie',
`id_kategoria` INT NOT NULL COMMENT 'Klucz obcy z tabeli kategoria',
`isbn` VARCHAR(13) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Niepowtarzalny 13-cyfrowy identyfikator ksi��ki',
`tytul` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Tytu� ksi��ki',
`autor` VARCHAR(70) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Imi� i Nazwisko autora ksi��ki',
`stron` INT(4) NOT NULL COMMENT 'Liczba stron ksi��ki',
`wydawnictwo` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Nazwa wydawnictwa, w kt�rym wydano ksi��k�',
`rok_wydania` INT(4) NOT NULL COMMENT 'Rok wydania ksi��ki',
`opis` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NULL COMMENT 'Opis ksi��ki',
PRIMARY KEY (`id_ksiazka`),
INDEX `fk_ksiazka_kategoria1_idx` (`id_kategoria` ASC),
CONSTRAINT `fk_ksiazka_kategoria1`
FOREIGN KEY (`id_kategoria`)
REFERENCES `kategoria` (`id_kategoria`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
COMMENT = 'Wszystkie ksi��ki dodane do bazy danych.';


-- -----------------------------------------------------
-- Table `zamowienie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zamowienie` (
`id_zamowienie` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz g��wny przydzielony automatycznie',
`id_czytelnik` INT NOT NULL COMMENT 'Klucz obcy z tabeli czytelnik',
`id_ksiazka` INT NOT NULL COMMENT 'Klucz obcy z tabeli ksiazka',
`data_zamowienia` DATETIME NOT NULL COMMENT 'Data z�o�enia zam�wienia w bibliotece',
`data_odbioru` DATETIME NULL COMMENT 'Data odbioru ksi��ki z biblioteki ',
`data_zwrotu` DATETIME NULL COMMENT 'Data zwrotu ksi��ki do biblioteki',
PRIMARY KEY (`id_zamowienie`),
INDEX `fk_zamowienie_czytelnik1_idx` (`id_czytelnik` ASC),
INDEX `fk_zamowienie_ksiazka1_idx` (`id_ksiazka` ASC),
CONSTRAINT `fk_zamowienie_czytelnik1`
FOREIGN KEY (`id_czytelnik`)
REFERENCES `czytelnik` (`id_czytelnik`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_zamowienie_ksiazka1`
FOREIGN KEY (`id_ksiazka`)
REFERENCES `ksiazka` (`id_ksiazka`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
COMMENT = 'Posiada informacje o zam�wionych, wypo�yczonych czy oddanych ksi��kach w bibliotece.';

-- -----------------------------------------------------
-- Table `admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin` (
`id_admin` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz g��wny przydzielony automatycznie',
`login` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Nazwa administratora potrzebna przy logowaniu',
`haslo` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Has�o niezaszyfrowane',
PRIMARY KEY (`id_admin`))
COMMENT = 'Posiada informacje o administratorach zarejestrowanych w programie.';

-- -----------------------------------------------------
-- Table `bibliotekarz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotekarz` (
`id_bibliotekarz` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz g��wny przydzielony automatycznie',
`login` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Nazwa bibliotekarza potrzebna przy logowaniu',
`haslo` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL COMMENT 'Has�o niezaszyfrowane',
PRIMARY KEY (`id_bibliotekarz`))
COMMENT = 'Posiada informacje o bibliotekarzach zarejestrowanych w programie.';

-- -----------------------------------------------------
-- Table `logowanie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logowanie` (
`id_uczen` INT NOT NULL COMMENT 'Element klucza g��wnego (identyfikator ucznia)',
`id_system` INT NOT NULL COMMENT 'Element klucz g��wnego (identyfikator systemu)',
`liczba_logowan` INT NOT NULL COMMENT 'Liczba logowa� danego ucznia do danego systemu',
PRIMARY KEY (`id_uczen`, `id_system`))
COMMENT = 'Posiada informacje na temat liczby logowa� uczni�w w systemach informatycznych.';

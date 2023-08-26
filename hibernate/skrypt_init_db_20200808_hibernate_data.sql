-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie kategorii do systemu
-- -----------------------------------------------------
INSERT INTO kategoria VALUES(1, 'BIZNES');
INSERT INTO kategoria VALUES(2, 'PORADNIKI');
INSERT INTO kategoria VALUES(3, 'PROGRAMOWANIE');
INSERT INTO kategoria VALUES(4, 'PROGRAMOWANIE_MOBILNE');
INSERT INTO kategoria VALUES(5, 'WEBMASTERSTWO');
INSERT INTO kategoria VALUES(6, 'SYSTEMY_OPERACYJNE');

-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie bibliotekarza do systemu
-- -----------------------------------------------------
INSERT INTO bibliotekarz VALUES(null, 'bibliotekarz', 'bibliotekarz');

-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie administratora do systemu
-- -----------------------------------------------------
INSERT INTO admin VALUES(null, 'admin', 'admin');

-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie czytelników do systemu
-- -----------------------------------------------------
INSERT INTO czytelnik VALUES(1, 'czytelnik_1', 'has³o_czytelnika', 'Piotr', 'Klimek', 'przyklad_1@wiedzanaplus.pl', null);
INSERT INTO czytelnik VALUES(2, 'czytelnik_2', 'has³o_czytelnika', 'Patryk', 'Klimek', 'przyklad_2@wiedzanaplus.pl', null);

-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie danych adresowych do systemu
-- -----------------------------------------------------
INSERT INTO adres VALUES(1, 'ul. Przyk³ad 4/ 12', 'Lublin', 'Lubelskie', '20-998');
INSERT INTO adres VALUES(2, 'ul. Przyk³ad 10/300', 'Lublin', 'Lubelskie', '20-999');

-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie ksi¹¿ek do systemu
-- -----------------------------------------------------
INSERT INTO ksiazka VALUE(1, 3, 9788324631773, 'PHP i MySQL. Tworzenie stron WWW. Vademecum profesjonalisty. Wydanie czwarte', 'Luke Welling, Laura Thomson', 856, 'Helion', 2009, 'Czwarte wydanie bestsellerowego podrêcznika dla webmasterów wykorzystuj¹cych w swojej pracy funkcjonalnoœæ jêzyka PHP i bazy danych MySQL.');
INSERT INTO ksiazka VALUE(2, 3, 9788324685301, 'Jêzyk C++. Kompendium wiedzy', 'Bjarne Stroustrup', 1296, 'Helion', 2014, null);
INSERT INTO ksiazka VALUE(3, 3, 9788324675340, 'Mistrz czystego kodu. Kodeks postêpowania profesjonalnych programistów', 'Robert C. Martin', 216, 'Helion', 2013, null);
INSERT INTO ksiazka VALUE('4', '6', '9788324690138', 'Kali Linux. Testy penetracyjne', 'Joseph Muniz, Aamir Lakhani', '336', 'Helion', '2014', null);
INSERT INTO ksiazka VALUE(5, 3, 9788324621880, 'Czysty kod. Podrêcznik dobrego programisty', 'Robert C. Martin', 424, 'Helion', 2010, null);
INSERT INTO ksiazka VALUE(6, 3, 9788324632374, 'Pragmatyczny programista. Od czeladnika do mistrza', 'Andrew Hunt, David Thomas', 332, 'Helion', 2011, null);
INSERT INTO ksiazka VALUE(7, 3, 9788324683178, 'Praca z zastanym kodem. Najlepsze techniki', 'Michael Feathers', 440, 'Helion', 2014, null);
INSERT INTO ksiazka VALUE(8, 5, 9788324685042, 'Tajemnice JavaScriptu. Podrêcznik ninja', 'John Resig, Bear Bibeault', 432, 'Helion', 2014, null);
INSERT INTO ksiazka VALUE(9, 3, 9788324689361, 'Java EE 6. Tworzenie aplikacji w NetBeans 7', 'David R. Heffelfinger', 352, 'Helion', 2014, null);
INSERT INTO ksiazka VALUE(10, 5, 9788324666676, 'Projektowanie stron internetowych. Przewodnik dla pocz¹tkuj¹cych webmasterów po HTML5, CSS3 i grafice. Wydanie IV', 'Jennifer Niederst Robbins', 600, 'Helion', 2014, null);

-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie zamówieñ dla czytelnik_1
-- -----------------------------------------------------
INSERT INTO zamowienie SET id_czytelnik=1, id_ksiazka=1, data_zamowienia='2014-08-01 10:12:02';
INSERT INTO zamowienie SET id_czytelnik=1, id_ksiazka=2, data_zamowienia='2014-08-01 10:12:02', data_odbioru='2014-08-03 12:10:10';
INSERT INTO zamowienie SET id_czytelnik=1, id_ksiazka=3, data_zamowienia='2014-08-01 10:13:02', data_odbioru='2014-08-03 12:11:10', data_zwrotu='2014-08-15 12:00:00';

-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie dwóch zamówieñ dla czytelnik_2
-- -----------------------------------------------------
INSERT INTO zamowienie SET id_czytelnik=2, id_ksiazka=3, data_zamowienia='2014-08-02 12:00:02';
INSERT INTO zamowienie SET id_czytelnik=2, id_ksiazka=4, data_zamowienia='2014-08-03 09:12:02', data_odbioru='2014-08-05 15:20:00';

-- -----------------------------------------------------
-- Skrypt odpowiedzialny za dodanie informacji na temat logowañ uczniów w systemach informatycznych
-- -----------------------------------------------------
INSERT INTO LOGOWANIE SET id_uczen = 1, id_system = 1, liczba_logowan = 5;
INSERT INTO LOGOWANIE SET id_uczen = 1, id_system = 5, liczba_logowan = 4;
INSERT INTO LOGOWANIE SET id_uczen = 1, id_system = 4, liczba_logowan = 1;
INSERT INTO LOGOWANIE SET id_uczen = 2, id_system = 1, liczba_logowan = 10;
INSERT INTO LOGOWANIE SET id_uczen = 2, id_system = 2, liczba_logowan = 8;
INSERT INTO LOGOWANIE SET id_uczen = 3, id_system = 3, liczba_logowan = 1;
INSERT INTO LOGOWANIE SET id_uczen = 4, id_system = 1, liczba_logowan = 1;
INSERT INTO LOGOWANIE SET id_uczen = 4, id_system = 4, liczba_logowan = 2;
INSERT INTO LOGOWANIE SET id_uczen = 4, id_system = 5, liczba_logowan = 3;


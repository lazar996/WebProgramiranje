create database webAerodrom

use webAerodrom



CREATE TABLE `webAerodrom`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `datumRegistracije` VARCHAR(45) NOT NULL,
  `role` ENUM('user', 'admin') NOT NULL,
  `blokiran` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `webAerodrom`.`let` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `broj` INT NOT NULL,
  `datumPolaska` VARCHAR(45) NOT NULL,
  `datumDolaska` VARCHAR(45) NOT NULL,
  `polazniAerodrom` INT NOT NULL,
  `dolazniAerodrom` INT NOT NULL,
  `brojSedista` INT NOT NULL,
  `cenaKarte` INT NOT NULL,
  `izbrisan` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));


CREATE TABLE `webAerodrom`.`rezervacije1` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `polazniLet` VARCHAR(45) NOT NULL,
  `povratniLet` VARCHAR(45),
  `sedistePolazni` INT NOT NULL,
  `sedisteDolazni` INT NOT NULL,
  `datumRezervacije` VARCHAR(45) NOT NULL,
  `datumProdajeKarte` VARCHAR(45) NOT NULL,
  `user` INT NOT NULL,
  `imePutnika` VARCHAR(45) NOT NULL,
  `prezimePutnika` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `webAerodrom`.`aerodromi` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `webAerodrom`.`users` (`id`, `username`, `password`, `datumRegistracije`, `role`, `blokiran`) VALUES ('0', 'pera', '123', '02/13/2019', 'admin', '0');
INSERT INTO `webAerodrom`.`users` (`id`, `username`, `password`, `datumRegistracije`, `role`, `blokiran`) VALUES ('0', 'marko', '123', '02/13/2019', 'user', '0');
INSERT INTO `webAerodrom`.`users` (`id`, `username`, `password`, `datumRegistracije`, `role`, `blokiran`) VALUES ('0', 'ivan', '123', '02/13/2019', 'user', '0');


INSERT INTO `webAerodrom`.`aerodromi` (`id`, `naziv`) VALUES ('0', 'Divci');
INSERT INTO `webAerodrom`.`aerodromi` (`id`, `naziv`) VALUES ('0', 'Nikola Tesla');
INSERT INTO `webAerodrom`.`aerodromi` (`id`, `naziv`) VALUES ('0', 'Konstantin ');
INSERT INTO `webAerodrom`.`aerodromi` (`id`, `naziv`) VALUES ('0', 'Dusseldorf');
INSERT INTO `webAerodrom`.`aerodromi` (`naziv`) VALUES ('Berlin Tegel');

INSERT INTO `webAerodrom`.`let` (`id`, `broj`, `datumPolaska`, `datumDolaska`, `polazniAerodrom`, `dolazniAerodrom`, `brojSedista`, `cenaKarte`, `izbrisan`) VALUES ('0', '520', '2019-02-14 01:00:00', '2019-02-15 01:00:00', '2', '1', '52', '6500', '0');
INSERT INTO `webAerodrom`.`let` (`id`, `broj`, `datumPolaska`, `datumDolaska`, `polazniAerodrom`, `dolazniAerodrom`, `brojSedista`, `cenaKarte`, `izbrisan`) VALUES ('0', '524', '2019-02-16 01:00:00', '2019-02-17 01:00:00', '1', '2', '54', '8500', '0');
INSERT INTO `webAerodrom`.`let` (`id`, `broj`, `datumPolaska`, `datumDolaska`, `polazniAerodrom`, `dolazniAerodrom`, `brojSedista`, `cenaKarte`, `izbrisan`) VALUES ('0', '695', '2019-02-18 01:00:00', '2019-02-19 01:00:00', '3', '5', '55', '8950', '0');
INSERT INTO `webAerodrom`.`let` (`id`, `broj`, `datumPolaska`, `datumDolaska`, `polazniAerodrom`, `dolazniAerodrom`, `brojSedista`, `cenaKarte`, `izbrisan`) VALUES ('0', '785', '2019-02-19 01:00:00', '2019-02-20 01:00:00', '4', '5', '80', '8700', '0');
INSERT INTO `webAerodrom`.`let` (`id`, `broj`, `datumPolaska`, `datumDolaska`, `polazniAerodrom`, `dolazniAerodrom`, `brojSedista`, `cenaKarte`, `izbrisan`) VALUES ('0', '65', '2019-02-20 01:00:00', '2019-02-21 01:00:00', '3', '4', '90', '4524', '0');

INSERT INTO `webAerodrom`.`rezervacije1` (`id`, `polazniLet`, `povratniLet`, `sedistePolazni`, `sedisteDolazni`, `datumRezervacije`, `datumProdajeKarte`, `user`, `imePutnika`, `prezimePutnika`) VALUES ('3', '1', '2', '10', '12', '2019.02.13.12.29.02', '2019.02.13.12.29.02', '1', 'marko', 'peric');
INSERT INTO `webAerodrom`.`rezervacije1` (`id`, `polazniLet`, `povratniLet`, `sedistePolazni`, `sedisteDolazni`, `datumRezervacije`, `datumProdajeKarte`, `user`, `imePutnika`, `prezimePutnika`) VALUES ('4', '1', '', '15', '15', '2019.02.13.12.29.02', '2019.02.13.12.29.02', '2', 'ivan', 'ivanovic');





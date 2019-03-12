-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ExamenSta
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ExamenSta` ;

-- -----------------------------------------------------
-- Schema ExamenSta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ExamenSta` DEFAULT CHARACTER SET utf8 ;
USE `ExamenSta` ;

-- -----------------------------------------------------
-- Table `ExamenSta`.`Autobus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Autobus` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Autobus` (
  `idAutobus` INT(11) NOT NULL AUTO_INCREMENT,
  `coordenadas` VARCHAR(45) NOT NULL,
  `plazas` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idAutobus`),
  UNIQUE INDEX `idAutobus_UNIQUE` (`idAutobus` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ExamenSta`.`Horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Horario` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Horario` (
  `idHorario` INT(11) NOT NULL AUTO_INCREMENT,
  `hora` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idHorario`),
  UNIQUE INDEX `idHorario_UNIQUE` (`idHorario` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ExamenSta`.`Linea`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Linea` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Linea` (
  `idLinea` INT(11) NOT NULL AUTO_INCREMENT,
  `origenDestino` VARCHAR(45) NOT NULL,
  `Autobus_idAutobus` INT(11) NOT NULL,
  PRIMARY KEY (`idLinea`),
  UNIQUE INDEX `idLinea_UNIQUE` (`idLinea` ASC),
  INDEX `fk_Linea_Autobus1_idx` (`Autobus_idAutobus` ASC),
  CONSTRAINT `fk_Linea_Autobus1`
    FOREIGN KEY (`Autobus_idAutobus`)
    REFERENCES `ExamenSta`.`Autobus` (`idAutobus`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ExamenSta`.`Parada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Parada` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Parada` (
  `idParada` INT NOT NULL AUTO_INCREMENT,
  `nombreParada` VARCHAR(45) NOT NULL,
  `coordenadas` VARCHAR(45) NULL,
  PRIMARY KEY (`idParada`),
  UNIQUE INDEX `idParadas_UNIQUE` (`idParada` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ExamenSta`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`Usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `tiempoAviso` VARCHAR(45) NULL,
  `reserva` TINYINT(1) NULL DEFAULT NULL,
  `Linea_idLinea` INT(11) NOT NULL,
  `Parada_idParadas` INT NOT NULL,
  `Horario_idHorario` INT(11) NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC),
  INDEX `fk_Usuario_Linea1_idx` (`Linea_idLinea` ASC),
  INDEX `fk_Usuario_Parada1_idx` (`Parada_idParadas` ASC),
  INDEX `fk_Usuario_Horario1_idx` (`Horario_idHorario` ASC),
  CONSTRAINT `fk_Usuario_Linea1`
    FOREIGN KEY (`Linea_idLinea`)
    REFERENCES `ExamenSta`.`Linea` (`idLinea`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Usuario_Parada1`
    FOREIGN KEY (`Parada_idParadas`)
    REFERENCES `ExamenSta`.`Parada` (`idParada`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Usuario_Horario1`
    FOREIGN KEY (`Horario_idHorario`)
    REFERENCES `ExamenSta`.`Horario` (`idHorario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ExamenSta`.`LineaParadas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`LineaParadas` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`LineaParadas` (
  `idLineaParadas` INT NOT NULL AUTO_INCREMENT,
  `Parada_idParada` INT NOT NULL,
  `Linea_idLinea` INT(11) NOT NULL,
  `orden` VARCHAR(45) NULL,
  INDEX `fk_Recorrido_Parada1_idx` (`Parada_idParada` ASC),
  INDEX `fk_Recorrido_Linea1_idx` (`Linea_idLinea` ASC),
  PRIMARY KEY (`idLineaParadas`),
  UNIQUE INDEX `idLineaParadas_UNIQUE` (`idLineaParadas` ASC),
  CONSTRAINT `fk_Recorrido_Parada1`
    FOREIGN KEY (`Parada_idParada`)
    REFERENCES `ExamenSta`.`Parada` (`idParada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Recorrido_Linea1`
    FOREIGN KEY (`Linea_idLinea`)
    REFERENCES `ExamenSta`.`Linea` (`idLinea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ExamenSta`.`LineaHorarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ExamenSta`.`LineaHorarios` ;

CREATE TABLE IF NOT EXISTS `ExamenSta`.`LineaHorarios` (
  `idLineaHorarios` INT NOT NULL AUTO_INCREMENT,
  `Linea_idLinea` INT(11) NOT NULL,
  `Horario_idHorario` INT(11) NOT NULL,
  INDEX `fk_LineaHorarios_Linea1_idx` (`Linea_idLinea` ASC),
  INDEX `fk_LineaHorarios_Horario1_idx` (`Horario_idHorario` ASC),
  PRIMARY KEY (`idLineaHorarios`),
  UNIQUE INDEX `idLineaHorarios_UNIQUE` (`idLineaHorarios` ASC),
  CONSTRAINT `fk_LineaHorarios_Linea1`
    FOREIGN KEY (`Linea_idLinea`)
    REFERENCES `ExamenSta`.`Linea` (`idLinea`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_LineaHorarios_Horario1`
    FOREIGN KEY (`Horario_idHorario`)
    REFERENCES `ExamenSta`.`Horario` (`idHorario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

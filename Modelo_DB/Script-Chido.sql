-- MySQL Script generated by MySQL Workbench
-- Tue May 19 18:52:10 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Prototipo_Pla_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Prototipo_Pla_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Prototipo_Pla_DB` DEFAULT CHARACTER SET utf8 ;
USE `Prototipo_Pla_DB` ;

-- -----------------------------------------------------
-- Table `Prototipo_Pla_DB`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo_Pla_DB`.`Usuario` (
  `email` VARCHAR(50) NOT NULL,
  `Contrasena` VARCHAR(45) NULL,
  `Rol` VARCHAR(45) NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellido_Pat` VARCHAR(45) NULL,
  `Boleta` INT NULL,
  `Unidad_Aca` VARCHAR(45) NULL,
  `Email_Recl` VARCHAR(45) NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo_Pla_DB`.`Aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo_Pla_DB`.`Aula` (
  `Id` INT NOT NULL,
  `Unidad_Aprendizaje` VARCHAR(45) NULL,
  `Salón` INT NULL,
  `Periodo` VARCHAR(45) NULL,
  `Fecha_Ini` DATE NULL,
  `Fecha_Fina` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo_Pla_DB`.`Usuario_has_Aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo_Pla_DB`.`Usuario_has_Aula` (
  `Usuario_email` VARCHAR(50) NOT NULL,
  `Aula_Id` INT NOT NULL,
  PRIMARY KEY (`Usuario_email`, `Aula_Id`),  
  CONSTRAINT `fk_Usuario_has_Aula_Usuario`
    FOREIGN KEY (`Usuario_email`)
    REFERENCES `Prototipo_Pla_DB`.`Usuario` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Aula_Aula1`
    FOREIGN KEY (`Aula_Id`)
    REFERENCES `Prototipo_Pla_DB`.`Aula` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
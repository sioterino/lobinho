SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

create database if not exists sofiadb;
use sofiadb;

CREATE TABLE IF NOT EXISTS `sofiadb`.`TipoSanguineo` (
                                                         `idTipoSanguineo` INT NOT NULL AUTO_INCREMENT,
                                                         `tipo` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idTipoSanguineo`)
    );


CREATE TABLE IF NOT EXISTS `sofiadb`.`Jovem` (
                                                 `idJovem` INT NOT NULL AUTO_INCREMENT,
                                                 `nome` VARCHAR(255) NOT NULL,
    `dataNascimento` DATETIME NOT NULL,
    `telefone` VARCHAR(45) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `idTipoSanguineo` INT NOT NULL,
    PRIMARY KEY (`idJovem`),
    INDEX `fk_Jovem_TipoSanguineo_idx` (`idTipoSanguineo`),
    CONSTRAINT `fk_Jovem_TipoSanguineo`
    FOREIGN KEY (`idTipoSanguineo`)
    REFERENCES `mydb`.`TipoSanguineo` (`idTipoSanguineo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    );

CREATE TABLE IF NOT EXISTS `sofiadb`.`Responsavel` (
                                                       `idResponsavel` INT NOT NULL AUTO_INCREMENT,
                                                       `nome` VARCHAR(255) NOT NULL,
    `telefone` VARCHAR(45) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`idResponsavel`)
    );

CREATE TABLE IF NOT EXISTS `sofiadb`.`Vinculo` (
                                                   `id` INT NOT NULL AUTO_INCREMENT,
                                                   `idJovem` INT NOT NULL,
                                                   `idResponsavel` INT NOT NULL,
                                                   PRIMARY KEY (`id`),
    INDEX `idx_idResponsavel` (`idResponsavel`),
    INDEX `idx_idJovem` (`idJovem`),
    CONSTRAINT `fk_Vinculo_Jovem`
    FOREIGN KEY (`idJovem`)
    REFERENCES `mydb`.`Jovem` (`idJovem`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_Vinculo_Responsavel`
    FOREIGN KEY (`idResponsavel`)
    REFERENCES `mydb`.`Responsavel` (`idResponsavel`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS `sofiadb`.`ProblemaSaude` (
                                                         `idProblemaSaude` INT NOT NULL AUTO_INCREMENT,
                                                         `tipoProblema` VARCHAR(255) NOT NULL,
    `descricao` VARCHAR(255),
    PRIMARY KEY (`idProblemaSaude`)
    );

CREATE TABLE IF NOT EXISTS `sofiadb`.`Saude` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `idJovem` INT NOT NULL,
                                                 `idProblemaSaude` INT NOT NULL,
                                                 PRIMARY KEY (`id`),
    INDEX `idx_idJovem` (`idJovem`),
    INDEX `idx_idProblemaSaude` (`idProblemaSaude`),
    CONSTRAINT `fk_Saude_Jovem`
    FOREIGN KEY (`idJovem`)
    REFERENCES `mydb`.`Jovem` (`idJovem`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_Saude_ProblemaSaude`
    FOREIGN KEY (`idProblemaSaude`)
    REFERENCES `mydb`.`ProblemaSaude` (`idProblemaSaude`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS `sofiadb`.`Insignia` (
                                                    `idInsignia` INT NOT NULL AUTO_INCREMENT,
                                                    `nome` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`idInsignia`)
    );

CREATE TABLE IF NOT EXISTS `sofiadb`.`Desafio` (
                                                   `idDesafio` INT NOT NULL AUTO_INCREMENT,
                                                   `nome` VARCHAR(255) NOT NULL,
    `Insignia_idInsignia` INT,
    PRIMARY KEY (`idDesafio`),
    INDEX `idx_Insignia_idInsignia` (`Insignia_idInsignia`),
    CONSTRAINT `fk_Desafio_Insignia`
    FOREIGN KEY (`Insignia_idInsignia`)
    REFERENCES `mydb`.`Insignias` (`idInsignia`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS `sofiadb`.`DesafioInsignia` (
                                                           `idDesafio` INT NOT NULL AUTO_INCREMENT,
                                                           `nome` VARCHAR(255) NOT NULL,
    `idInsignia` INT NOT NULL,
    PRIMARY KEY (`idDesafio`),
    INDEX `fk_DesafioInsignia_Insignia_idx` (`idInsignia`),
    CONSTRAINT `fk_DesafioInsignia_Insignia`
    FOREIGN KEY (`idInsignia`)
    REFERENCES `mydb`.`Insignias` (`idInsignia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`DesafioInsigniaFeita` (
                                                                `id` INT NOT NULL AUTO_INCREMENT,
                                                                `idDesafio` INT NOT NULL,
                                                                `idJovem` INT NOT NULL,
                                                                `data` DATETIME NOT NULL,
                                                                PRIMARY KEY (`id`),
    INDEX `idx_idDesafio` (`idDesafio`),
    INDEX `idx_idJovem` (`idJovem`),
    CONSTRAINT `fk_DesafioInsigniaFeita_DesafioInsignia`
    FOREIGN KEY (`idDesafio`)
    REFERENCES `mydb`.`DesafioInsignia` (`idDesafio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_DesafioInsigniaFeita_Jovem`
    FOREIGN KEY (`idJovem`)
    REFERENCES `mydb`.`Jovem` (`idJovem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`AreaDeConhecimento` (
                                                              `idAreaDeConhecimento` INT NOT NULL AUTO_INCREMENT,
                                                              `nome` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`idAreaDeConhecimento`)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`Especialidades` (
                                                          `idEspecialidade` INT NOT NULL AUTO_INCREMENT,
                                                          `nome` VARCHAR(255) NOT NULL,
    `idAreaDeConhecimento` INT,
    PRIMARY KEY (`idEspecialidade`),
    INDEX `idx_idAreaDeConhecimento` (`idAreaDeConhecimento`),
    CONSTRAINT `fk_Especialidades_AreaDeConhecimento`
    FOREIGN KEY (`idAreaDeConhecimento`)
    REFERENCES `mydb`.`AreaDeConhecimento` (`idAreaDeConhecimento`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`DesafioEspecialidade` (
                                                                `idDesafio` INT NOT NULL AUTO_INCREMENT,
                                                                `nome` VARCHAR(255) NOT NULL,
    `idEspecialidade` INT,
    PRIMARY KEY (`idDesafio`),
    INDEX `idx_idEspecialidade` (`idEspecialidade`),
    CONSTRAINT `fk_DesafioEspecialidade_Especialidade`
    FOREIGN KEY (`idEspecialidade`)
    REFERENCES `mydb`.`Especialidades` (`idEspecialidade`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`DesafioEspecialidadeFeita` (
                                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                                     `idDesafio` INT NOT NULL,
                                                                     `idJovem` INT NOT NULL,
                                                                     `data` DATETIME NOT NULL,
                                                                     PRIMARY KEY (`id`),
    INDEX `idx_idDesafio` (`idDesafio`),
    INDEX `idx_idJovem` (`idJovem`),
    CONSTRAINT `fk_DesafioEspecialidadeFeita_DesafioEspecialidade`
    FOREIGN KEY (`idDesafio`)
    REFERENCES `mydb`.`DesafioEspecialidade` (`idDesafio`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_DesafioEspecialidadeFeita_Jovem`
    FOREIGN KEY (`idJovem`)
    REFERENCES `mydb`.`Jovem` (`idJovem`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`Acampamentos` (
                                                        `idAcampamento` INT NOT NULL AUTO_INCREMENT,
                                                        `nome` VARCHAR(255) NOT NULL,
    `data` DATETIME NOT NULL,
    PRIMARY KEY (`idAcampamento`)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`NoiteAcampada` (
                                                         `id` INT NOT NULL AUTO_INCREMENT,
                                                         `idAcampamento` INT NOT NULL,
                                                         `idJovem` INT NOT NULL,
                                                         PRIMARY KEY (`id`),
    INDEX `idx_idAcampamento` (`idAcampamento`),
    INDEX `idx_idJovem` (`idJovem`),
    CONSTRAINT `fk_NoiteAcampada_Acampamento`
    FOREIGN KEY (`idAcampamento`)
    REFERENCES `mydb`.`Acampamentos` (`idAcampamento`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_NoiteAcampada_Jovem`
    FOREIGN KEY (`idJovem`)
    REFERENCES `mydb`.`Jovem` (`idJovem`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`Distintivos` (
                                                       `idDistintivo` INT NOT NULL AUTO_INCREMENT,
                                                       `nome` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idDistintivo`)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`DesafiosDistintivo` (
                                                              `idDesafioDistintivo` INT NOT NULL AUTO_INCREMENT,
                                                              `descricao` VARCHAR(45) NOT NULL,
    `idDistintivo` INT,
    PRIMARY KEY (`idDesafioDistintivo`),
    INDEX `idx_idDistintivo` (`idDistintivo`),
    CONSTRAINT `fk_DesafiosDeDistintivos_Distintivo`
    FOREIGN KEY (`idDistintivo`)
    REFERENCES `mydb`.`Distintivos` (`idDistintivo`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `sofiadb`.`DesafioDistintivoFeito` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `idDesafioDistintivo` INT NOT NULL,
      `idJovem` INT NOT NULL,
      `dataInicio` DATETIME NOT NULL,
      `dataFim` DATETIME NOT NULL,
      PRIMARY KEY (`id`),
    INDEX `idx_idDesafioDistintivo` (`idDesafioDistintivo`),
    INDEX `idx_idJovem` (`idJovem`),
    CONSTRAINT `fk_DesafioDistintivoFeito_DesafioDistintivo`
    FOREIGN KEY (`idDesafioDistintivo`)
    REFERENCES `mydb`.`DesafiosDeDistintivos` (`idDesafioDistintivo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_DesafioDistintivoFeito_Jovem`
    FOREIGN KEY (`idJovem`)
    REFERENCES `mydb`.`Jovem` (`idJovem`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
    ) ENGINE=InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

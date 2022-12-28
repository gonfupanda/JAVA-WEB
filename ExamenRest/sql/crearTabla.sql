CREATE TABLE IF NOT EXISTS `gestiondocente`.`resenas` (
  `curso_codigo` INT NOT NULL,
  `alumno_codigo` INT NOT NULL,
  `texto` VARCHAR(45) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  INDEX `fk_curso_has_alumno_alumno1_idx` (`alumno_codigo` ASC) VISIBLE,
  INDEX `fk_curso_has_alumno_curso1_idx` (`curso_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_curso_has_alumno_alumno1`
    FOREIGN KEY (`alumno_codigo`)
    REFERENCES `gestiondocente`.`alumno` (`codigo`),
  CONSTRAINT `fk_curso_has_alumno_curso1`
    FOREIGN KEY (`curso_codigo`)
    REFERENCES `gestiondocente`.`curso` (`codigo`))
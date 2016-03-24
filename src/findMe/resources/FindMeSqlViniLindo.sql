/*Depois de deletar um supervisor apaga a pessoa com mesmo id*/
DELIMITER $$
CREATE TRIGGER afterDelete_Supervisor AFTER DELETE ON supervisor
FOR EACH ROW
BEGIN
	DELETE FROM person WHERE id = OLD.id;
END$$

DELIMITER $$

/*Antes de deletar um supervisor apaga na tabela supervisor_schoolsubject a linha com mesmo id
 * e coloca em monitor um valor null na linha onde existia tal supervisor
 */
DELIMITER $$
CREATE TRIGGER beforeDelete_Supervisor BEFORE DELETE ON supervisor
FOR EACH ROW
BEGIN
    DELETE FROM supervisor_schoolsubject WHERE id_supervisor = OLD.id;
    UPDATE monitor SET id_supervisor = null WHERE id_supervisor = OLD.id;
END$$

DELIMITER $$



/*Antes de deletar um monitor apaga o estudante, a pessoa, e a bankAccount com seu id*/
DELIMITER $$
CREATE TRIGGER afterDelete_Monitor AFTER DELETE ON monitor
FOR EACH ROW
BEGIN
	DELETE FROM student WHERE id = OLD.id;
    DELETE FROM person WHERE id = OLD.id;
    DELETE FROM bankaccount WHERE id = OLD.id_bankaccount;
END$$
DELIMITER $$


/*Antes de deletar um monitor exclui as timetables com seu id*/
DELIMITER $$
CREATE TRIGGER beforeDelete_Monitor BEFORE DELETE ON monitor
FOR EACH ROW
BEGIN
    DELETE FROM timetable WHERE id_monitor = OLD.id;
END$$
DELIMITER $$


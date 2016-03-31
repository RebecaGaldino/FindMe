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



/*Depois de deletar um monitor apaga o estudante, a pessoa, e a bankAccount com seu id*/
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


/*Antes de deletar uma disciplina exclui os id_schoolsubject em monitor com seu id*/
DELIMITER $$
CREATE TRIGGER beforeDelete_SchoolSubject BEFORE DELETE ON schoolsubject
FOR EACH ROW
BEGIN
    
    UPDATE monitor 
	SET id_schoolsubject = null
	WHERE id_schoolsubject = old.id;
    UPDATE supervisor_schoolsubject
    SET id_schoolsubject = null
    WHERE id_schoolsubject = old.id;
    
END$$
DELIMITER $$

/*-----------------------------------------------------------------------------------------*/

/*Exibe todos os monitores e suas matrículas ---- getMonitorsAndIds() ---- OK*/
SELECT person.namePerson Nome, person.id Matricula
FROM monitor
INNER JOIN student
ON monitor.id = student.id
INNER JOIN person
ON student.id = person.id
ORDER BY person.namePerson;


/*Exibe todas as informações dos monitores - 
 * person, student e e ids do supervisor, schoolsubject e banckaccount*/
SELECT person.*, student.course, student.grade, monitor.id_supervisor, monitor.id_schoolsubject, monitor.id_bankaccount, monitor.roomwork
FROM monitor
INNER JOIN student
ON monitor.id = student.id
INNER JOIN person
ON student.id = person.id
ORDER BY person.namePerson;


/*Exibe todas as informações de um monitor - 
 * person, student e e ids do supervisor, schoolsubject e banckaccount*/
SELECT person.*, student.course, student.grade, monitor.id_supervisor, monitor.id_schoolsubject, monitor.id_bankaccount, monitor.roomwork
FROM monitor
INNER JOIN student
ON monitor.id = student.id
INNER JOIN person
ON student.id = person.id
WHERE monitor.id = "20151004018";/*No DAO substituir isso por uma variavel*/


/*Exibe os horários de um monitor*/
SELECT timetable.dayname, timetable.begin_time, timetable.end_time
FROM person p
INNER JOIN monitor
ON p.id = monitor.id
INNER JOIN timetable
ON monitor.id = timetable.id_monitor
WHERE monitor.id = "20151004018";/*No DAO substituir isso por uma variavel*/


/*Exibe os horários de todos os monitores, em ordem alfabética */
SELECT p.namePerson, timetable.dayname, timetable.begin_time, timetable.end_time
FROM person p
INNER JOIN monitor
ON p.id = monitor.id
INNER JOIN timetable
ON monitor.id = timetable.id_monitor
ORDER BY namePerson;


/*Exibe os horários de todos os monitores em um dia específico*/
SELECT p.namePerson, timetable.dayname, timetable.begin_time, timetable.end_time
FROM person p
INNER JOIN monitor
ON p.id = monitor.id
INNER JOIN timetable
ON monitor.id = timetable.id_monitor
HAVING timetable.dayname = "Quarta";/*No DAO substituir isso por uma variavel*/


/*Exibe as informações bancárias de um monitor*/
SELECT bankaccount.*
FROM person p
INNER JOIN monitor
ON p.id = monitor.id
INNER JOIN bankaccount
ON monitor.id_bankaccount = bankaccount.id
WHERE monitor.id = "20151004018";/*No DAO substituir isso por uma variavel*/


/*Exibe os monitores de um supervisor*/
SELECT p.*
FROM person p
INNER JOIN monitor
ON p.id = monitor.id
INNER JOIN supervisor
ON monitor.id_supervisor = supervisor.id
WHERE supervisor.id = "20111002017"/*No DAO substituir isso por uma variavel*/
ORDER BY p.id;


/*Exibe todas as contas bancarias de todos os monitores, por ordem alfabética do namePerson*/
SELECT p.namePerson, bankaccount.*
FROM person p
INNER JOIN monitor
ON p.id = monitor.id
INNER JOIN bankaccount
ON monitor.id_bankaccount = bankaccount.id
ORDER BY p.namePerson;
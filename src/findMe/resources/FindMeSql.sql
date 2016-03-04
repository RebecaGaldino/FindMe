CREATE SCHEMA findme;

USE findme;


CREATE TABLE person( 

id VARCHAR(11) NOT NULL,

    cpf VARCHAR(14) NOT NULL,

    birth_dt date NOT NULL,

    namePerson VARCHAR(100) NOT NULL,

    

    PRIMARY KEY (id)

);

CREATE TABLE supervisor( 

id VARCHAR(11) NOT NULL,

    

    PRIMARY KEY(id),

    CONSTRAINT fk_supervisor_person  FOREIGN KEY (id) REFERENCES person(id)

);

CREATE TABLE schoolsubject(

id VARCHAR(100) NOT NULL,

    namesubject VARCHAR (100) NOT NULL,

    

    PRIMARY KEY (id)

);

CREATE TABLE student (

     course VARCHAR(30) NOT NULL,

     grade VARCHAR(7) NOT NULL,

   id  VARCHAR(11) NOT NULL,

    PRIMARY KEY(id),

     CONSTRAINT fk_student_person  FOREIGN KEY (id) REFERENCES person(id)

);

CREATE TABLE monitor( 

id VARCHAR(11) NOT NULL,

    id_supervisor VARCHAR (11),

    id_schoolsubject VARCHAR(100),

    roomwork VARCHAR(50) NOT NULL,

    

    PRIMARY KEY(id),

    CONSTRAINT fk_monitor_student  FOREIGN KEY (id) REFERENCES student(id),

    CONSTRAINT fk_id_supervisorA  FOREIGN KEY (id_supervisor) REFERENCES 

supervisor(id),

    CONSTRAINT fk_id_schoolsubjectA  FOREIGN KEY (id_schoolsubject) 

REFERENCES schoolsubject(id)

);

CREATE TABLE timetable( 

id INT UNSIGNED AUTO_INCREMENT NOT NULL,

    id_monitor VARCHAR(11),

    dayname VARCHAR (10),

    begin_time DATETIME,

    end_time DATETIME,

    

    PRIMARY KEY(id),

    CONSTRAINT fk_id_monitor  FOREIGN KEY (id_monitor) REFERENCES monitor(id)

);

/* para o trigger*/ 

CREATE TABLE timetableHistory( 

id_timetable INT UNSIGNED, 

id_monitor VARCHAR(11) NOT NULL,

    dayname VARCHAR (10),

    begin_time DATETIME,

    end_time DATETIME,

    modificadoem DATETIME

);

CREATE TABLE supervisor_schoolsubject( 

id INT AUTO_INCREMENT NOT NULL, 

id_supervisor VARCHAR(11),

    id_schoolsubject VARCHAR(100), 

PRIMARY KEY (id),

    

    CONSTRAINT fk_id_supervisorB  FOREIGN KEY (id_supervisor) REFERENCES 

supervisor(id),

    CONSTRAINT fk_id_schoolsubjectB  FOREIGN KEY (id_schoolsubject) 

REFERENCES schoolsubject(id)

);

insert into person (id, cpf, birth_dt, namePerson) 

values("20141004019", "111.222.333-44", '1999-11-07', "Maria"), 

("20151004018", "555.666.777-88", '1999-11-07', "Joao"), 

("20131004017", "999.111.000-11", '1998-10-06', "Pedro"), 

("20122003011", "555.667.001-25", '1995-09-05', "Joana"), 

("20111002017", "434.567.090-11", '1995-05-03', "Mateus"), 

("20102001040", "234.897.001-09", '1997-09-06', "Davi"); 

insert into student (course, grade, id) 

values("Informática", "2º ano", "20141004019"), 

("Mineração", "1º ano", "20151004018"), 

("Petróleo e gás", "3º ano", "20131004017"); 

insert into supervisor(id) values

 ("20122003011"),

 ("20111002017"),

 ("20102001040");

 

 insert into schoolsubject(id, namesubject) values

 ("122", "Matemática"),

 ("134","Biologia"),

 ("155","Física"),

 ("110","Português");

        

insert into supervisor_schoolsubject(id_supervisor, id_schoolsubject) values 

 ("20111002017", "134"),

 ("20102001040", "110");

 

 insert into monitor(id, id_supervisor, id_schoolsubject, roomwork) values

 ("20141004019", "20122003011", "122", "Sala A"),

 ("20151004018", "20111002017", "134", "Sala B"),

 ("20131004017", "20102001040", "110", "Sala C");

        

insert into timetable(id_monitor, dayname, begin_time, end_time) values 

 ("20151004018", "Sexta", '12:00:00', '13:00:00'),

 ("20131004017", "Segunda", '09:00:00', '16:00:00'); 

    

    delete from timetable 

where id_monitor = "20141004019" and id = "20141004018" and id = 

"20141004017";

    

    delete from monitor

 where id = "20141004019" and id = "20151004018" and id = "20131004017";

    

("20122003011", "122"),

("20141004019", "Terça", '13:00:00', '15:00:00'),

    delete from supervisor_schoolsubject

 where id = "20122003011" and id = "20111002017" and id = "20151004018";

    

    delete from schoolsubject

 where id = "122" and id = "134" and id = "155" and id = "110"; 

    delete from supervisor

 where id = "20122003011" and id = "20111002017" and id = "20151004018";

    

delete from student 

where id = "20141004019" and id = "20141004018" and id = "20141004017"; 

delete from person 

where id = "20141004019" and id = "20141004018" and id = "20141004017";

    

/* Triggers de Person ------------------------------------------------*/

DELIMITER $$

CREATE TRIGGER beforeIsrt_person BEFORE INSERT ON person

 FOR EACH ROW

 BEGIN 

 IF length(new.cpf) != 14 THEN 

 SET new.cpf = ""; 

 END IF; 

END$$

    

    

DELIMITER $$

CREATE TRIGGER beforeUpdt_person BEFORE UPDATE ON person

 FOR EACH ROW

 BEGIN 

IF length(new.cpf) != 14 THEN 

IF length(OLD.cpf) != 14 THEN 

ELSE 

END if; 

ELSE 

SET new.cpf = ""; 

SET new.cpf = old.cpf; 

            SET new.cpf = new.cpf; 

 END IF; 

END$$

    

    

DELIMITER $$

CREATE TRIGGER beforeDelete_person BEFORE DELETE ON person 

 FOR EACH ROW

 BEGIN 

 DELETE FROM student WHERE id = OLD.id; 

 DELETE FROM supervisor WHERE id = OLD.id; 

END$$

    

    

/*Triggers de Supervisor------------------------------------------------*/

/*OBS: Supervisor só possui o ID de person, logo sem opções de fazer triggers*/

DELIMITER $$

CREATE TRIGGER beforeDelete_supervisor BEFORE DELETE ON supervisor

 FOR EACH ROW

 BEGIN 

DELETE FROM monitor WHERE id = OLD.id; 

UPDATE monitor 

SET id_supervisor = null

        WHERE id_supervisor = old.id;

        

        UPDATE supervisor_schoolsubject 

        WHERE id_supervisor = old.id; 

END$$

    

    

/*Triggers de School Subject -------------------------------------*/

DELIMITER $$

create trigger beforeUpdate_schoolsubject before update on schoolsubject

 for each row 

 begin 

 if (SELECT CHARINDEX(new.namesubject,'0123456789') = 0) then 

            SET new.namesubject = new.namesubject 

 WHERE id = id; 

 end if;

        

        if new.id != old.id THEN 

SET id_supervisor = null

UPDATE schoolsubject

        

UPDATE monitor 

SET id_schoolsubject = new.id 

WHERE id_schoolsubject = old.id;

UPDATE supervisor_schoolsubject 

SET id_schoolsubject = new.id 

WHERE id_schoolsubject = old.id; 

END IF;

 end$$

    

    

DELIMITER $$

CREATE TRIGGER beforeDelete_schoolsubject BEFORE DELETE ON schoolsubject

 FOR EACH ROW

 BEGIN 

UPDATE monitor 

SET id_schoolsubject = null

        WHERE id_schoolsubject = old.id;

        

        UPDATE supervisor_schoolsubject 

        WHERE id_schoolsubject = old.id; 

END$$

    

/*Triggers de Student ---------------------------------------------------*/

    

    DELIMITER $$

 create trigger beforeinsert_student before insert on student

 for each row

 begin 

 if (SELECT CHARINDEX(new.course, '0123456789')) = 0 then 

 set new.course = ""; 

 else 

 set new.course = new.course; 

 if (SELECT CHARINDEX(new.grade, '0123456789')) = 0 then 

 set new.grade = ""; 

 else 

 set new.grade = new.grade; 

 end if; 

 end if;

 end$$ 

 

 DELIMITER $$ 

CREATE TRIGGER beforeDelete_student BEFORE DELETE ON student 

 FOR EACH ROW 

 BEGIN 

SET id_schoolsubject = null

UPDATE person 

SET id = null 

        WHERE id = old.id; 

    end$$    

DELIMITER $$ 

create trigger beforeUpdate_student before update on student 

 for each row 

 begin 

 UPDATE person 

SET id = new.id 

        WHERE id  = old.id; 

        

        UPDATE monitor 

        WHERE id = old.id; 

SET id = new.id 

end$$

/*Triggers de Monitor ---------------------------------------------------*/ 

DELIMITER $$

 CREATE TRIGGER beforeInsert_monitor before INSERT ON monitor

 FOR EACH ROW

 BEGIN 

 set new.roomwork = ""; 

 else 

 set new.roomwork = new.roomwork; 

 end if;

 END$$ 

 

 DELIMITER $$ 

create trigger beforeUpdate_monitor before update on monitor

 for each row 

 begin 

 UPDATE student 

        WHERE id = old.id; 

end$$   

    

DELIMITER $$

CREATE TRIGGER beforeDelete_monitor BEFORE DELETE ON monitor

 FOR EACH ROW

 BEGIN 

if (SELECT CHARINDEX(new.roomwork, '0123456789')) = 0 then 

SET id  = new.id

UPDATE timetable 

SET id_monitor = null

        WHERE id_monitor = id_monitor;

        

    END$$

    

/*Triggers de timetable--------------------------------------------------------------*/

 

    DELIMITER $$

 create trigger beforeUpdate_timetable BEFORE update on timetable

 for each row 

 begin 

 if (new.dayname is null) then 

 set new.dayname = old.dayname; 

 end if;

 end$$ 

 

    

    delimiter $$ 

create trigger beforeInsert_timetable before insert on timetable

 for each row 

 begin 

 if (new.begin_time is not null and new.end_time is not null) 

 then 

 set new.begin_time = new.begin_time, 

 new.end_time = new.end_time; 

 end if;

 end$$

    

    

    DELIMITER $$

 create trigger beforeDelete_timetable before delete on timetable  /*Histórico dos 

horários*/

 for each row 

 begin 

 insert into timetableHistory 

 set id_timetable = old.id, 

 id_monitor = old.id_monitor, 

 dayname = old.dayname, 

 begin_time = old.begin_time, 

 end_time = old.end_time, 

 modificadoem = NOW();

 end$$ 

    

drop table timetable;

drop table monitor;

drop table supervisor_schoolsubject;

drop table schoolsubject;

drop table supervisor;

drop table student;

drop table person;

drop schema findme;

/*Consultas

SELECT A3.namePerson

FROM monitor A1, student A2, person A3

WHERE A1.id = A2.id and A2.id = A3.id

GROUP BY A3.namePerson;*/

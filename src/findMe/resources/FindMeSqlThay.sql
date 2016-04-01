CREATE SCHEMA findme;

USE findme;


CREATE TABLE person( 

	id VARCHAR(11) NOT NULL,

    cpf VARCHAR(14) NOT NULL,

    birth_dt date NOT NULL,

    namePerson VARCHAR(100) NOT NULL,
    
    password VARCHAR(100) NOT NULL,
    
    sex VARCHAR(10) NOT NULL,
    
    email VARCHAR(100) NOT NULL,
    
    rg VARCHAR(9) NOT NULL,

    

    PRIMARY KEY (id)

);

CREATE TABLE bankaccount( 

    id VARCHAR(10) NOT NULL ,

    numberaccount VARCHAR (10),

    agency VARCHAR(20),
    
    typeaccount VARCHAR(20),
    
    notes VARCHAR(500),
    
    PRIMARY KEY(id)

);


CREATE TABLE supervisor( 

id VARCHAR(11) NOT NULL,

    

    PRIMARY KEY(id),

    CONSTRAINT fk_supervisor_person  FOREIGN KEY (id) REFERENCES person(id)

);

CREATE TABLE manager( 

id VARCHAR(11) NOT NULL,

    

    PRIMARY KEY(id),

    CONSTRAINT fk_manager_person  FOREIGN KEY (id) REFERENCES person(id)

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
    
    id_bankaccount VARCHAR(6),

    roomwork VARCHAR(50) NOT NULL,
    

    

    PRIMARY KEY(id),

    CONSTRAINT fk_monitor_student  FOREIGN KEY (id) REFERENCES student(id),

    CONSTRAINT fk_id_supervisorA  FOREIGN KEY (id_supervisor) REFERENCES supervisor(id),

    CONSTRAINT fk_id_schoolsubjectA  FOREIGN KEY (id_schoolsubject) REFERENCES schoolsubject(id),
    
    CONSTRAINT fk_id_bankaccount FOREIGN KEY (id_bankaccount) REFERENCES bankaccount(id)

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


insert into bankaccount (id, numberaccount, agency, typeaccount, notes) 

values("000001", "1234567891", "Banco do Brasil", "Corrente", "."),

("000002", "9876543211", "Bradesco", "Poupança", "."),

("000003", "9876543210", "Itaú", "Corrente", "."),
("000005", "7623472410", "Banco da Suiça", "Poupança", "melhor banco de todos os tempos");

insert into person (id, cpf, birth_dt, namePerson, password,  sex, email, rg)

values("20141004019", "111.222.333-44", '1999-11-07', "Maria", "euamoarroz","feminino", "maria@gmail.com", "67894584"), 

("20151004018", "555.666.777-88", '1999-11-07', "Joao",  "thezueraneverends", "masculino", "joaoluis@hotmail.com", "45672346"), 

("20131004017", "999.111.000-11", '1998-10-06', "Pedro", "metralhadora", "masculino", "pedroot@ymail.com", "87903456"), 

("20122003011", "555.667.001-25", '1995-09-05', "Joana", "iamafeminist", "feminino", "joaninha@gmail.com", "783465738"), 

("20111002017", "434.567.090-11", '1995-05-03', "Mateus", "littlemonster4life", "masculino", "matt023@hotmail.com", "23459683"), 

("20102001040", "234.897.001-09", '1997-09-06', "Davi", "easpedrinhas", "masculino", "davinodabilia@gmail.com", "48573909"),

("20122671058", "274.950.032-14", '1976-10-10', "El grande", "poderosochefao", "masculino", "admin@gmail.com", "32173969"),
("20122671051", "234.910.032-12", '1990-01-07', "Lucas", "adoropaodoce", "masculino", "lucas@gmail.com", "1.234.112"),
("20122671001", "834.900.132-12", '1990-01-07', "Tiago", "maepai", "masculino", "tiago@gmail.com", "3.198.110"),
("20152000081", "174.900.132-12", '1990-01-07', "Eugenio", "minhaesposa", "masculino", "eugenio@gmail.com", "8.123.000"); 

insert into student (course, grade, id) 

values("Informatica", "2Âº ano", "20141004019"), 

("Mineracao", "1Âº ano", "20151004018"), 

("Petroleo e gas", "3Âº ano", "20131004017"),
("Informatica", "3º ano", "20152000081"); 

insert into supervisor(id) values

 ("20122003011"),

 ("20111002017"),

 ("20102001040"),
 ("20122671051"),
 ("20122671001");

 insert into manager(id) values
 
 ("20122671058");

 insert into schoolsubject(id, namesubject) values

 ("122", "Matematica"),

 ("134","Biologia"),

 ("155","Fisica"),

 ("110","Portugues"),
 ("109","POO"),
 ("010","ED");



insert into supervisor_schoolsubject(id_supervisor, id_schoolsubject) values 

 ("20111002017", "134"),

 ("20102001040", "110"),
 ( null, "155"),
 ("20122003011", null),
 ("20122671001", "010");


 insert into monitor(id, id_supervisor, id_schoolsubject, id_bankaccount, roomwork) values

 ("20141004019", "20122003011", "122", "000001", "Sala A"),

 ("20151004018", "20111002017", "134", "000002", "Sala B"),

 ("20131004017", "20102001040", "110", "000003", "Sala C");


insert into timetable(id_monitor, dayname, begin_time, end_time) values 

 ("20151004018", "Sexta", '12:00:00', '13:00:00'),

 ("20131004017", "Segunda", '09:00:00', '16:00:00'); 

        

insert into timetable(id_monitor, dayname, begin_time, end_time) values 

 ("20151004018", "Sexta", '12:00:00', '13:00:00'),

 ("20131004017", "Segunda", '09:00:00', '16:00:00'); 

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
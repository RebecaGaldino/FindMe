CREATE SCHEMA findme;

USE findme;

CREATE TABLE person(
	id VARCHAR(11) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    birth_dt datetime NOT NULL,
    namePerson VARCHAR(100),
    
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
    id_schoolsubject VARCHAR(100) NOT NULL,
    roomwork VARCHAR(50) NOT NULL,
    
    PRIMARY KEY(id),
    CONSTRAINT fk_monitor_student  FOREIGN KEY (id) REFERENCES student(id),
    CONSTRAINT fk_id_supervisorA  FOREIGN KEY (id_supervisor) REFERENCES supervisor(id),
    CONSTRAINT fk_id_schoolsubjectA  FOREIGN KEY (id_schoolsubject) REFERENCES schoolsubject(id)
);

CREATE TABLE timetable(
	id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    id_monitor VARCHAR(11) NOT NULL,
    dayname VARCHAR (10) NOT NULL,
    begin_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    
    PRIMARY KEY(id),
    CONSTRAINT fk_id_monitor  FOREIGN KEY (id_monitor) REFERENCES monitor(id)
);

CREATE TABLE supervisor_schoolsubject(
	id INT AUTO_INCREMENT NOT NULL,
	id_supervisor VARCHAR(11) NOT NULL,
    id_schoolsubject VARCHAR(100) NOT NULL,
		
	PRIMARY KEY (id),
    
    CONSTRAINT fk_id_supervisorB  FOREIGN KEY (id_supervisor) REFERENCES supervisor(id),
    CONSTRAINT fk_id_schoolsubjectB  FOREIGN KEY (id_schoolsubject) REFERENCES schoolsubject(id)
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
		("20122003011", "122"),
 		("20111002017", "134"),
 		("20102001040", "110");
 	
 	insert into monitor(id, id_supervisor, id_schoolsubject, roomwork) values
 		("20141004019", "20122003011", "122", "Sala A"),
 		("20151004018", "20111002017", "134", "Sala B"),
 		("20131004017", "20102001040", "110", "Sala C");
        
	insert into timetable(id_monitor, dayname, begin_time, end_time) values
		("20141004019", "Terça", '13:00:00', '15:00:00'),
 		("20151004018", "Sexta", '12:00:00', '13:00:00'),
 		("20131004017", "Segunda", '09:00:00', '16:00:00');
	
    
    delete from timetable 
	where id_monitor = "20141004019" and id = "20141004018" and id = "20141004017";
    
    delete from monitor
 	where id = "20141004019" and id = "20151004018" and id = "20131004017";
    
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

drop table timetable;

drop table monitor;

drop table supervisor_schoolsubject;

drop table schoolsubject;

drop table supervisor;

drop table student;

drop table person;

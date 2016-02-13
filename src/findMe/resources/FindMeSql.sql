create schema findme;

USE findme;

CREATE TABLE person(
	id VARCHAR(11) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    birth_dt datetime NOT NULL,
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
    name VARCHAR (100) NOT NULL,
    
    PRIMARY KEY (id)
);

CREATE TABLE student (
     course VARCHAR(30),
     grade VARCHAR(7),
  	 id  VARCHAR(11) NOT NULL,
   	 PRIMARY KEY(id),
     CONSTRAINT fk_student_person  FOREIGN KEY (id) REFERENCES person(id)
);

CREATE TABLE monitor(
	id VARCHAR(11) NOT NULL,
	worktime DATETIME NOT NULL,
    roomwork VARCHAR(50) NOT NULL,
    
    PRIMARY KEY(id),
    CONSTRAINT fk_monitor_student  FOREIGN KEY (id) REFERENCES student(id)
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
 	
 	insert into schoolsubject(id, name) values
 		("122", "Matemática"),
 		("134","Biologia"),
 		("155","Física"),
 		("110","Português");
 	
 	insert into monitor(id, worktime, roomwork) values
 		("20141004019", '60:00', 12),
 		("20151004018", '50:00', 13),
 		("20131004017", '40:00', 13);
        
	delete from student 
	where id = "20141004019" and id = "20141004018" and id = "20141004017";

	delete from person
	where id = "20141004019" and id = "20141004018" and id = "20141004017";

	delete from supervisor
 	where id = "20122003011" and id = "20111002017" and id = "20151004018";
 	
 	delete from schoolsubject
 	where id = "122" and id = "134" and id = "155" and id = "110";
 	
 	delete from monitor
 	where id = "20141004019" and id = "20151004018" and id = "20131004017";
 	

drop table monitor;

drop table student;

drop table supervisor;

drop table schoolsubject;

drop table person;

drop schema findme;

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
     grade VARCHAR(4),
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
			("20131004017", "999.111.000-11", '1998-10-06', "Pedro");

insert into student (course, grade, id)
	values("Informática", "2ano", "20141004019"),
			("Mineração", "1ano", "20151004018"),
			("Petróleo e gás", "3ano", "20131004017");
        
delete from student 
where id = "20141004019" and id = "20141004018" and id = "20141004017";

delete from person
where id = "20141004019" and id = "20141004018" and id = "20141004017";

drop table monitor;

drop table student;

drop table supervisor;

drop table person;

drop schema findme;

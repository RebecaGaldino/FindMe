CREATE SCHEMA findme;

USE findme;

CREATE TABLE person(
	id VARCHAR(11) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    birth_dt DATE NOT NULL,
    name VARCHAR(100) NOT NULL,
    
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
    CONSTRAINT fk_monitor_person  FOREIGN KEY (id) REFERENCES person(id)
);

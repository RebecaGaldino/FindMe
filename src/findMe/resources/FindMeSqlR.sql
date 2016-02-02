 CREATE DATABASE findme;
 
 use findme;
 
 	CREATE TABLE student (
     course VARCHAR(30),
     grade VARCHAR(4),
  	 id  VARCHAR(11) NOT NULL,
   	 PRIMARY KEY(id),
     CONSTRAINT fk_student_person  FOREIGN KEY (id) REFERENCES person(id)
	 );
    
 0
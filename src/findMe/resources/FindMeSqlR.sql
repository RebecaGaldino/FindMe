#Consultas

/* Select name from a student from the father table, within the others where there's the same id */
SELECT A3.namePerson

FROM monitor A1, student A2, person A3

WHERE A1.id = A2.id and A2.id = A3.id

GROUP BY A3.namePerson;


/* Select monitors' names that are supervisioned by the same supervisor */
SELECT A2.namePerson

FROM monitor A1, person A2, supervisor A3

WHERE A1.id = A2.id and A1.id_supervisor = A3.id 

GROUP BY A2.namePerson;


/* Select the student's names and courses */
SELECT A2.namePerson, A1.course

FROM student A1, person A2

WHERE A1.id = A2.id 

GROUP BY A2.namePerson;

/* Select the monitor's name and his subject  */
SELECT A2.namePerson, A3.namesubject

FROM supervisor_schoolsubject A1, person A2, schoolsubject A3

WHERE A2.id = A1.id_supervisor and A3.id = A1.id_schoolsubject

GROUP BY A2.namePerson;

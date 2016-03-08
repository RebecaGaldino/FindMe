#Consultas

/* Select name from a student from the father table, within the others where there's the same id */
SELECT A3.namePerson FROM monitor A1, student A2, person A3
WHERE A1.id = A2.id and A2.id = A3.id
GROUP BY A3.namePerson; #Exibe os monitores


/* Select name from a supervisor from the father table, within the others where there's the same id */
SELECT A2.namePerson FROM supervisor A1, person A2
WHERE A1.id = A2.id
GROUP BY A2.namePerson; #Exibe os supervisores


/* Select monitors' names that are supervisioned by the same supervisor
SELECT A2.namePerson, A2.namePerson FROM monitor A1, person A2, supervisor A3
WHERE A1.id = A2.id and A1.id_supervisor = A3.id and A3.id = A2.id
GROUP BY A2.namePerson; #Exibe os monitores e seus supervisores - Duvida*/


/* Select the student's names and courses */
SELECT A2.namePerson, A1.course FROM student A1, person A2
WHERE A1.id = A2.id 
GROUP BY A2.namePerson; #Exibe os estudantes e seus cursos


/* Select the supervisor's name and his subject  */
SELECT A2.namePerson, A3.namesubject FROM supervisor_schoolsubject A1, person A2, schoolsubject A3
WHERE A2.id = A1.id_supervisor and A3.id = A1.id_schoolsubject
GROUP BY A2.namePerson; #Exibe os nomes dos supervisores e suas disciplinas


/* Select the monitor's name and his subject  */
SELECT A1.namePerson, A3.namesubject FROM person A1, monitor A2, schoolsubject A3
WHERE A2.id = A1.id and A2.id_schoolsubject = A3.id
GROUP BY A1.namePerson; #Exibe os nomes dos monitores e suas disciplinas 


/* Select the monitor's name and the timetables related to him */
SELECT A1.namePerson, A2.dayname, A2.begin_time, A2.end_time FROM person A1, timetable A2
WHERE A1.id = A2.id_monitor
GROUP BY A1.namePerson; #Exibe os horários dos monitores
/* ORDER BY A2.dayname(A2.dayname, 'Segunda-feira', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabado', 'Domingo'); - Tenta se isso funciona pra ordenar pelo dia */


/* Select the monitors and theirs classrooms */
SELECT A1.namePerson, A2.roomwork FROM person A1, monitor A2
WHERE A2.id = A1.id
GROUP BY A1.namePerson; #Exibe os monitores e suas salas de atendimento

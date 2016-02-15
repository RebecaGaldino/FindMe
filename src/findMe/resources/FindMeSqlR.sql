 CREATE DATABASE findme;
 
 use findme;
 
 /* Os cod n tão funfando por erro de sintaxe, pls corrige */
 /*Correção*/
 DELIMITER $$
	CREATE TRIGGER beforeIsrt_person BEFORE INSERT ON person
 	FOR EACH ROW
 	BEGIN
	 	IF length(new.cpf) != 14 THEN
	 		SET new.cpf = "--Invalid CPF-";
	 	END IF;
	END$$
 	
 	create trigger beforeUpdt_person before update on person
 	for each row
 	begin
	 	if (new.namePerson is not null) then
	 		update person;
	 	end if;
 	end 
 	
 	create trigger afterDelete_person after delete on person
 	for each row 
 	begin
	 	delete from student where id = OLD.id;
	 	delete from supervisor where id = OLD.id;
	 	delete from monitor where id = OLD.id;
 	end 
 	
 	/*--------------------------------------------------------------*/
 	
 	create trigger beforeInsert_timetable before insert on timetable
 	for each row 
 	begin
	 	if (new.begin_time is not null and new.end_time is not null)
	 		then 
	 			set begin_time = new.begin_time,
	 			end_time = new.end_time;
	 		end if;
 	end 
 	
 	create trigger afterUpdate_timetable after update on timetable
 	for each row 
 	begin 
	 	if (new.dayname is null) then
	 		set new.dayname = old.dayname;
	 	end if;
 	end 
 	
 	create trigger beforeDelete_timetable before delete on timetable  /*Histórico dos horários*/
 	for each row 
 	begin
	 	insert into timetableHistory 
	 	set id_timetable = old.id,
	 	id_monitor = old.id_monitor,
	 	dayname = old.dayname,
	 	begin_time = old.begin_time,
	 	end_time = old.end_time,
	 	modificadoem = NOW();
 	end 
 	
   	/*--------------------------------------------------------------*/

 	/* Verificar se ha numero na string do nome*/
 	create trigger beforeUpdate_schoolsubject before update on schoolsubject
 	for each row 
 	begin
	 	if (SELECT CAST(new.namesubject AS UNSIGNED)) == 0 then
	 		new.namesubject = new.subject;
	 	end if;
 	end 

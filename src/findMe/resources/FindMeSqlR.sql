 CREATE DATABASE findme;
 
 use findme;
 
/*Triggers de Person*/
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
				SET new.cpf = "";
			ELSE
				SET new.cpf = old.cpf;
			END if;
		ELSE 
            SET new.cpf = new.cpf;
	 	END IF;
	END$$
    
    
DELIMITER $$
CREATE TRIGGER beforeDelete_person BEFORE DELETE ON person
 	FOR EACH ROW
 	BEGIN
		DELETE FROM monitor WHERE id = OLD.id;
	 	DELETE FROM student WHERE id = OLD.id;
	 	DELETE FROM supervisor WHERE id = OLD.id;
	end$$
 	
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
	 	if (SELECT CAST(new.namesubject AS UNSIGNED)) = 0 then
	 		set new.namesubject = "";
	 	else
	 		set new.namesubject = new.subject;
	 	end if;
 	end 

	/*--------------------------------------------------------------*/

 	DELIMITER $$
 	create trigger beforeUpdate_student before update on student
 	for each row
 	begin
	 	if (SELECT CAST(new.course AS UNSIGNED)) = 0 then
	 		set new.namecourse = "";
	 	else
	 		set new.namesubject = new.subject;
	 		if (SELECT CAST(new.grade AS UNSIGNED)) = 0 then
	 			set new.grade = "";
	 		else
	 			set new.grade = new.grade;
	 		end if;;
	 	end if;
 	end 
 END$$
 
 	/*--------------------------------------------------------------*/
 
 
 
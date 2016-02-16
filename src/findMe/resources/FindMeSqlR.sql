 CREATE DATABASE findme;
 
 use findme;
 
/*Triggers de Person -----------------------------------------*/
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
 
 
 /*Triggers de School Subject ------------------------------------------------*/

DELIMITER $$
create trigger beforeUpdate_schoolsubject before update on schoolsubject
 	for each row 
 	begin
	 	if (SELECT CAST(new.namesubject AS UNSIGNED)) = 0 then
			UPDATE schoolsubject
            SET namesubject = new.namesubject
	 		WHERE id = id;
	 	end if;
 	end$$
    
    
    
DELIMITER $$
create trigger beforeUpdate_schoolsubject_id before update on schoolsubject
 	for each row 
 	begin
	 	UPDATE monitor
		SET id_schoolsubject = new.id
        WHERE id_schoolsubject = old.id;
        
        UPDATE supervisor_schoolsubject
		SET id_schoolsubject = new.id
        WHERE id_schoolsubject = old.id;
 	end$$
    
    
    
DELIMITER $$
CREATE TRIGGER beforeDelete_schoolsubject BEFORE DELETE ON schoolsubject
 	FOR EACH ROW
 	BEGIN
		UPDATE monitor
		SET id_schoolsubject = null
        WHERE id_schoolsubject = old.id;
        
        UPDATE supervisor_schoolsubject
		SET id_schoolsubject = null
        WHERE id_schoolsubject = old.id;
	END$$
	
 /*Triggers de timetable--------------------------------------------------------------*/
 	
 	create trigger beforeInsert_timetable before insert on timetable
 	for each row 
 	begin
	 	if (new.begin_time is not null and new.end_time is not null)
	 		then 
	 			set new.begin_time = new.begin_time,
	 			new.end_time = new.end_time;
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
 	
   	

/*Triggers de student--------------------------------------------------------------*/

 	DELIMITER $$
 	create trigger beforeinsert_student before insert on student
 	for each row
 	begin
	 	if (SELECT CHARINDEX(new.course, '0123456789')) = 0 then
	 		set new.course = "";
	 	else
	 		set new.course = new.course;
	 		if (SELECT CHARINDEX(new.grade, '0123456789')) = 0 then
	 			set new.grade = "";
	 		else
	 			set new.grade = new.grade;
	 		end if;
	 	end if;
 	end 
 END$$
 
 DELIMITER $$
	CREATE TRIGGER beforeDelete_student BEFORE DELETE ON student
	 	FOR EACH ROW
	 	BEGIN
			UPDATE person
			SET id = null
	        WHERE id = old.id;
	    end;    
		END$$
		

DELIMITER $$
	create trigger beforeUpdate_student before update on student
	 	for each row 
	 	begin
		 	UPDATE person
			SET id = new.id
	        WHERE id  = old.id;
	        
	        UPDATE monitor
			SET id = new.id
	        WHERE id = old.id;
	       end;
	 	end$$

/*Triggers de monitor--------------------------------------------------------------*/
 
 	DELIMITER $$
 	CREATE TRIGGER beforeInsert_monitor before INSERT ON monitor
 	FOR EACH ROW
 	BEGIN
		if (SELECT CHARINDEX(new.roomwork, '0123456789')) = 0 then
	 		set new.roomwork = "";
	 	else
	 		set new.roomwork = new.roomwork;
	 	end if;
 	END 
 	END$$
 	
 	DELIMITER $$
	create trigger beforeUpdate_monitor before update on monitor
 	for each row 
 	begin
	 	UPDATE student
		SET id  = new.id
        WHERE id = old.id;
     end   
    
 	end$$
    
    
    
DELIMITER $$
CREATE TRIGGER beforeDelete_monitor BEFORE DELETE ON monitor
 	FOR EACH ROW
 	BEGIN
		UPDATE timetable
		SET id_monitor = null
        WHERE id_monitor = old.id_monitor;
        
    end
	END$$
	
/*Triggers de supervisor--------------------------------------------------------------*/
 	
DELIMITER $$
	create trigger beforeUpdate_supervisor before update on supervisor
 	for each row 
 	begin
	 	UPDATE monitor
		SET id_monitor  = new.id_monitor
        WHERE id_monitor = old.id_monitor;
   end 
 	end$$
 

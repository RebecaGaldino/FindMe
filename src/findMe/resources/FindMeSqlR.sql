 CREATE DATABASE findme;
 
 use findme;
 
 	CREATE TRIGGER beforeIsrt_person BEFORE INSERT ON person
 	for each row 
 	BEGIN
	 	IF length(new.cpf) = 14 THEN
	 		INSERT person
	 	END IF;
 	END
 	
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
 	
 	
 	
 	
    
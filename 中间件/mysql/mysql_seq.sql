create table ai_seq_table (
	name varchar(50) not null primary key,
	start_value BIGINT not null,
	increment_value int not null default 1
);


DELIMITER $$
USE `IntelligentCall`$$
CREATE FUNCTION `nextval`(str varchar(50)) RETURNS bigint(8)
begin
	declare i bigint;
	set i=(select start_value from ai_seq_table where name=str);
	update ai_seq_table
		set start_value=i+increment_value
	where name=str;
return i;
end$$

DELIMITER ;

-- ----------------------------------------------------------------------------
-- Routine IntelligentCall.nexValbyLen
-- ----------------------------------------------------------------------------
DELIMITER $$

DELIMITER $$
USE `IntelligentCall`$$
CREATE FUNCTION `nexValbyLen`(len integer,str varchar(50)) RETURNS bigint(8)
BEGIN
declare start_val bigint;
	select start_value into start_val  from ai_seq_table where name=str;
	update ai_seq_table
		set start_value=start_value+increment_value*len
	where name=str;
return start_val;
END$$

DELIMITER ;
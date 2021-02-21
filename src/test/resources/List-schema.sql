drop table if exists `list_name` CASCADE;
drop table if exists `item` CASCADE ;

create table list_name (id bigint PRIMARY KEY AUTO_INCREMENT, name varchar(255) not null)
create table item (id bigint PRIMARY KEY AUTO_INCREMENT, item_action varchar(255) not null, item_name varchar(255) not null, list_name_id bigint)


SET @var1 = UUID();
SET @var2 = UUID();
insert into  User (id,account_name,mail,password,enabled,is_account_non_expired,is_account_non_locked,is_credentials_non_expired,verification_code,modify_time,user_id) values(1,'javamail.com','javamail.com','jo',true,true,true,true,'HOQL',current_time,@var1);
insert into  User (id,account_name,mail,password,enabled,is_account_non_expired,is_account_non_locked,is_credentials_non_expired,verification_code,modify_time,user_id) values(2,'javamailtest.com','javamailtest.com','jotest',true,true,true,true,'HOQLtest',current_time,@var2);
insert into user_role(id,role_name) values( 1,'USER');
insert into user_role(id,role_name) values( 2,'ADMIN');
insert into user_role(id,role_name) values( 3,'VIEWER');

insert into user_privilege(id,privilege_name) values( 1,'canReadUser');
insert into user_privilege(id,privilege_name) values( 2,'canReadAdmin');
insert into user_privilege(id,privilege_name) values( 3,'USER_READ');

insert into user_role_to_privilege(id,role_id,privilege_id) values (1,1,1);
insert into user_role_to_privilege(id,role_id,privilege_id) values (2,2,1);
insert into user_role_to_privilege(id,role_id,privilege_id) values (3,2,2);
insert into user_role_to_privilege(id,role_id,privilege_id) values (4,3,3);

insert into user_to_role(id,user_id,role_id) values( 1,1,1);
/*insert into user_to_role(id,user_id,role_id) values( 2,2,2);
*/insert into user_to_role(id,user_id,role_id) values( 3,2,3);
####################### BANKS #######################

insert into bank (id, name, bank_uid)
select * from (select 999 as id, 'Dummy' as name, 'Dummy' as bank_uid) source
where not exists (select id, bank_uid from bank where bank.id = source.id);

insert into bank (id, name, bank_uid)
select * from (select 1 as id, 'GoliathNacionale' as name, 'Bank-000001' as bank_uid) source
where not exists (select id, bank_uid from bank where bank.id = source.id);

insert into bank (id, name, bank_uid)
select * from (select 2 as id, 'GermoneyBank' as name, 'Bank-000002' as bank_uid) source
where not exists (select id, bank_uid from bank where bank.id = source.id);

insert into bank (id, name, bank_uid)
select * from (select 3 as id, 'Gringott' as name, 'Bank-000003' as bank_uid) source
where not exists (select id, bank_uid from bank where bank.id = source.id);

####################### CUSTOMERS #######################

insert into customer (id, customer_uid, last_name, name)
select * from (select 999 as id, 'Custom-000999' as customer_uid, 'Dummy' as last_name, 'Dummy' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 1 as id, 'Custom-000001' as customer_uid, 'Doe' as last_name, 'John' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 2 as id, 'Custom-000002' as customer_uid, 'Bowman' as last_name, 'Jack' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 3 as id, 'Custom-000003' as customer_uid, 'Bowman' as last_name, 'Michelle' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 4 as id, 'Custom-000004' as customer_uid, 'McKellen' as last_name, 'Angus' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 5 as id, 'Custom-000005' as customer_uid, 'Buffalo' as last_name, 'William' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 6 as id, 'Custom-000006' as customer_uid, 'Alderan' as last_name, 'Lilly' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 7 as id, 'Custom-000007' as customer_uid, 'Sherbootskey' as last_name, 'Robin' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 8 as id, 'Custom-000008' as customer_uid, 'Stevenson' as last_name, 'Barney' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 9 as id, 'Custom-000009' as customer_uid, 'Mopsy' as last_name, 'Ted' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);

insert into customer (id, customer_uid, last_name, name)
select * from (select 10 as id, 'Custom-000010' as customer_uid, 'Erikson' as last_name, 'Marshal' as name) source
where not exists (select id, customer_uid from customer where customer.id = source.id);


####################### BANK_ACCOUNTS #######################

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 999 as id, 'BankAc-000999' as account_uid, 0.00 as money, null as bank_id, null as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 1 as id, 'BankAc-000001' as account_uid, 100.34 as money, 1 as bank_id, 1 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 2 as id, 'BankAc-000002' as account_uid, 300.12 as money, 1 as bank_id, 1 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 3 as id, 'BankAc-000003' as account_uid, 250.53 as money, 2 as bank_id, 2 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 4 as id, 'BankAc-000004' as account_uid, 10050.12 as money, 1 as bank_id, 3 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 5 as id, 'BankAc-000005' as account_uid, 12300.54 as money, 3 as bank_id, 4 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 6 as id, 'BankAc-000006' as account_uid, 16400.23 as money, 1 as bank_id, 6 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 7 as id, 'BankAc-000007' as account_uid, 5.12 as money, 3 as bank_id, 6 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 8 as id, 'BankAc-000008' as account_uid, 1235.75 as money, 2 as bank_id, 6 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 9 as id, 'BankAc-000009' as account_uid, 1255.11 as money, 1 as bank_id, 7 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

insert into bank_account (id, account_uid, money, bank_id, customer_id)
select * from (select 10 as id, 'BankAc-000010' as account_uid, 100.11 as money, 1 as bank_id, 1 as customer_id) source
where not exists (select id, account_uid from bank_account where bank_account.id = source.id);

####################### ROLES #######################

insert into role (id, role_name)
select * from (select 999 as id, 'Dummy' as role_name) source
where not exists (select id from role where role.id = source.id);

insert into role (id, role_name)
select * from (select 1 as id, 'EMPLOYEE' as role_name) source
where not exists (select id from role where role.id = source.id);

insert into role (id, role_name)
select * from (select 2 as id, 'ADMIN' as role_name) source
where not exists (select id from role where role.id = source.id);


####################### EMPLOYEES #######################

insert into employee (id, employee_uid, last_name, name)
select * from (select 999 as id, 'Employ-000999' as employee_uid, 'Dummy' as last_name, 'Dummy' as name) source
where not exists (select id, employee_uid from employee where employee.id = source.id);

insert into employee (id, employee_uid, last_name, name)
select * from (select 1 as id, 'Employ-000001' as employee_uid, 'Juan' as last_name, 'Salsa' as name) source
where not exists (select id, employee_uid from employee where employee.id = source.id);

insert into employee (id, employee_uid, last_name, name)
select * from (select 2 as id, 'Employ-000002' as employee_uid, 'Amparo' as last_name, 'Porta' as name) source
where not exists (select id, employee_uid from employee where employee.id = source.id);


####################### USERS ####################### ## '{bcrypt}$2a$10$7f9HZrDXUwGDm5Vm2n3EM.aeHDTyENUGzZB36mx4IczCNN79vwrk6' = 'password' ##

insert into user (id, employee_uid, password, user_name)
select * from (select 999 as id, 'Employ-000999' as employee_uid, 'Dummy' as password, 'Dummy' as user_name) source
where not exists (select id, employee_uid from user where user.id = source.id);

insert into user (id, employee_uid, password, user_name)
select * from (select 1 as id, 'Employ-000001' as employee_uid, '{bcrypt}$2a$10$7f9HZrDXUwGDm5Vm2n3EM.aeHDTyENUGzZB36mx4IczCNN79vwrk6' as password, 'Salsa' as user_name) source
where not exists (select id, employee_uid from user where user.id = source.id);

insert into user (id, employee_uid, password, user_name)
select * from (select 2 as id, 'Employ-000002' as employee_uid, '{bcrypt}$2a$10$7f9HZrDXUwGDm5Vm2n3EM.aeHDTyENUGzZB36mx4IczCNN79vwrk6' as password, 'Porta' as user_name) source
where not exists (select id, employee_uid from user where user.id = source.id);


####################### USER_ROLE #######################

insert into user_role (user_id, role_id)
select * from (select 999 as user_id, 999 as role_id) source
where not exists (select user_id, role_id from user_role where user_role.user_id = source.user_id and user_role.role_id = source.role_id);

insert into user_role (user_id, role_id)
select * from (select 1 as user_id, 1 as role_id) source
where not exists (select user_id, role_id from user_role where user_role.user_id = source.user_id and user_role.role_id = source.role_id);

insert into user_role (user_id, role_id)
select * from (select 2 as user_id, 1 as role_id) source
where not exists (select user_id, role_id from user_role where user_role.user_id = source.user_id and user_role.role_id = source.role_id);

insert into user_role (user_id, role_id)
select * from (select 2 as user_id, 2 as role_id) source
where not exists (select user_id, role_id from user_role where user_role.user_id = source.user_id and user_role.role_id = source.role_id);
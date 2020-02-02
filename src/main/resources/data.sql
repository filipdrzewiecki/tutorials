REPLACE INTO customer (id, customer_uid, name, last_name) VALUES
(1, 'Custom-000001', 'John', 'Doe'),
(2, 'Custom-000002', 'Jack', 'Bowman'),
(3, 'Custom-000003', 'Michelle', 'Bowman'),
(4, 'Custom-000004', 'Angus', 'McKellen'),
(5, 'Custom-000005', 'William', 'Buffalo'),
(6, 'Custom-000006', 'Lilly', 'Alderan'),
(7, 'Custom-000007', 'Robin', 'Sherbootskey'),
(8, 'Custom-000008', 'Barney', 'Stevenson'),
(9, 'Custom-000009', 'Ted', 'Mopsy'),
(10, 'Custom-000010', 'Marshal', 'Erikson');

REPLACE INTO bank (id, bank_uid, name) VALUES
(1, 'Bank-000001', 'GoliathNacionale'),
(2, 'Bank-000002', 'GermoneyBank'),
(3, 'Bank-000003', 'Gringott');

REPLACE INTO bank_account (id, account_uid, money, bank_id, customer_id) VALUES
(1, 'BankAc-000001', 100.34, 1, 1),
(2, 'BankAc-000002', 300.12, 1, 1),
(3, 'BankAc-000003', 250.53, 2, 2),
(4, 'BankAc-000004', 10050.12, 1, 3),
(5, 'BankAc-000005', 12300.54, 3, 4),
(6, 'BankAc-000006', 16400.23, 1, 5),
(7, 'BankAc-000007', 5.12, 3, 6),
(8, 'BankAc-000008', 1235.75, 2, 6),
(9, 'BankAc-000009', 1255.11, 1, 6),
(10, 'BankAc-000010', 100.11, 1, 7);
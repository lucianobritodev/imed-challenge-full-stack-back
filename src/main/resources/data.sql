
insert into patient
    (id, date_created, date_modified, online_status, password, total_appointment, username)
values
    ((select nextval('seq_patient')), now(), now(), true, '$2a$10$uqEVq2J6iPBoPGrZPkcNEue6lQZ2bf0iPo1ix/va.n9.x7UcwG8/S', 0, 'admin'),
    ((select nextval('seq_patient')), now(), now(), true, '$2a$10$uqEVq2J6iPBoPGrZPkcNEue6lQZ2bf0iPo1ix/va.n9.x7UcwG8/S', 0, 'user-test'),
    ((select nextval('seq_patient')), now(), now(), true, '$2a$10$uqEVq2J6iPBoPGrZPkcNEue6lQZ2bf0iPo1ix/va.n9.x7UcwG8/S', 10, 'luciano');

insert into health_insurance
(id, date_created, date_modified, price, cnpj, name)
values
    ((select nextval('seq_health_insurance')), now(), now(), 199.90, '27655133000152', 'Breath Health'),
    ((select nextval('seq_health_insurance')), now(), now(), 299.90, '50736355000111', 'Live Heath Insurance'),
    ((select nextval('seq_health_insurance')), now(), now(), 599.90, '29357738000192', 'Living');

insert into healthcare_professional
(id, date_created, date_modified, crm, rating, status, name)
values
    ((select nextval('seq_healthcare_professional')), now(), now(), 59381, 5, true, 'Maria'),
    ((select nextval('seq_healthcare_professional')), now(), now(), 63854, 4, false, 'José'),
    ((select nextval('seq_healthcare_professional')), now(), now(), 31852, 4, true, 'Pedro');
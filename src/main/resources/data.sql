
insert into patient
    (id, created_at, last_modified_at, online_status, password, total_appointment, username)
values
    ((select nextval('seq_patient')), now(), now(), true, '$2a$10$uqEVq2J6iPBoPGrZPkcNEue6lQZ2bf0iPo1ix/va.n9.x7UcwG8/S', 0, 'admin'),
    ((select nextval('seq_patient')), now(), now(), true, '$2a$10$uqEVq2J6iPBoPGrZPkcNEue6lQZ2bf0iPo1ix/va.n9.x7UcwG8/S', 0, 'user-test'),
    ((select nextval('seq_patient')), now(), now(), true, '$2a$10$uqEVq2J6iPBoPGrZPkcNEue6lQZ2bf0iPo1ix/va.n9.x7UcwG8/S', 10, 'luciano');
